package www.ccyblog.novel.modules.register.entity;

import lombok.Data;

/**
 * Created by ccy on 2017/7/31.
 */
@Data
public class Account {
    private int uid;
    private String username;
    private String password;
    private String salt;
}
