package www.ccyblog.novel.modules.register.dao;

import org.springframework.stereotype.Repository;
import www.ccyblog.novel.modules.register.entity.Account;

/**
 * Created by ccy on 2017/7/31.
 */
@Repository
interface AccountDao {
    int create(String userName, String password, String salt);
    Account getAccount(String userName);
    int update(String password, String salt);
}
