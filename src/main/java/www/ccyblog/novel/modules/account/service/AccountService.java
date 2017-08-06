package www.ccyblog.novel.modules.account.service;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.ccyblog.novel.common.utils.CommonUtil;
import www.ccyblog.novel.modules.account.dao.AccountDao;
import www.ccyblog.novel.modules.account.entity.Account;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by ccy on 2017/7/31.
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JCaptchaService jCaptchaService;

    public enum REGISTER_ERROR_INFO{
        NORMAL,
        CAPTCHA,
        PASSWORD,
        USERNAME,
        OTHER
    }

    private Pattern usernamePattern = null;

    public AccountService() {
        this.usernamePattern = Pattern.compile("^[\\d\\w]{6,18}$");
    }

    // TODO 防止重名，虽然服务端，客户端都有判断，但还是会出错
    public REGISTER_ERROR_INFO createAccount(String username, String password, String rePassword, String captcha){
        if(!jCaptchaService.validateResponseForID(request.getSession().getId(), captcha)){
            return REGISTER_ERROR_INFO.CAPTCHA;
        }
        if(!password.equals(rePassword) || password.length() < 6 || password.length() > 18){
            return REGISTER_ERROR_INFO.PASSWORD;
        }
        if(!this.usernamePattern.matcher(username).find()){
            return REGISTER_ERROR_INFO.USERNAME;
        }
        Account account = new Account();
        account.setUsername(username);
        String salt = CommonUtil.generateRandomSalt();
        password = new Md5Hash(password + username + salt).toString();
        account.setSalt(salt);
        account.setPassword(password);
        if(accountDao.createAccount(account) == 1){
            return REGISTER_ERROR_INFO.NORMAL;
        }
        else{
            return REGISTER_ERROR_INFO.OTHER;

        }
    }

    public Account getAccount(String username){
        return accountDao.getAccount(username);
    }
    public Boolean hasUsername(String username){
        if(getAccount(username) != null){
            return true;
        }
        else{
            return false;
        }
    }
}
