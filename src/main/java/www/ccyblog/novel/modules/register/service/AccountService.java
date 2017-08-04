package www.ccyblog.novel.modules.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.ccyblog.novel.common.utils.CommonUtil;
import www.ccyblog.novel.modules.register.dao.AccountDao;
import www.ccyblog.novel.modules.register.entity.Account;

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
        this.usernamePattern = Pattern.compile("^[\\d\\w]*$");
    }

    public REGISTER_ERROR_INFO createAccount(String username, String password, String rePassword, String captcha){
        if(!jCaptchaService.validateResponseForID(request.getSession().getId(), captcha)){
            return REGISTER_ERROR_INFO.CAPTCHA;
        }
        if(!password.equals(rePassword) || password.length() < 6 || password.length() > 18){
            return REGISTER_ERROR_INFO.PASSWORD;
        }
        if(username.length() <6 || username.length() > 18 || !this.usernamePattern.matcher(username).find()){
            return REGISTER_ERROR_INFO.USERNAME;
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setSalt(CommonUtil.generateRandomSalt());
        if(accountDao.createAccount(account) == 1){
            return REGISTER_ERROR_INFO.NORMAL;
        }
        else{
            return REGISTER_ERROR_INFO.OTHER;

        }
    }
}
