package www.ccyblog.novel.modules.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.ccyblog.novel.common.utils.CommonUtil;
import www.ccyblog.novel.modules.register.dao.AccountDao;
import www.ccyblog.novel.modules.register.entity.Account;

/**
 * Created by ccy on 2017/7/31.
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public int createAccount(String username, String password, String rePassword, String captcha){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setSalt(CommonUtil.generateRandomSalt());
        return accountDao.createAccount(account);
    }
}
