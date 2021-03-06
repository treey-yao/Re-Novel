package www.ccyblog.novel.modules.account.dao;

import org.springframework.stereotype.Repository;
import www.ccyblog.novel.modules.account.entity.Account;

/**
 * Created by ccy on 2017/7/31.
 */
@Repository
public interface AccountDao {
    int createAccount(Account account);
    Account getAccount(String userName);
    int update(String password, String salt);
}
