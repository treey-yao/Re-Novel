package www.ccyblog.novel.common.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import www.ccyblog.novel.modules.account.entity.Account;

/**
 * Created by isghost on 2017/8/6.
 */
public class UserAuthenticationInfo implements AuthenticationInfo {
    private Account account;
    private String username;
    private String password;
    public UserAuthenticationInfo(String username, String password, Account account){
        this.account = account;
    }
    public PrincipalCollection getPrincipals() {
        return null;
    }

    public Object getCredentials() {
        return null;
    }

    public Account getAccount(){
        return this.account;
    }
}
