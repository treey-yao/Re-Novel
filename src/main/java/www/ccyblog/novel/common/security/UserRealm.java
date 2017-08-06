package www.ccyblog.novel.common.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.Realm;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import www.ccyblog.novel.modules.account.entity.Account;
import www.ccyblog.novel.modules.account.service.AccountService;

/**
 * Created by isghost on 2017/8/6.
 */
public class UserRealm implements Realm{
    public String getName() {
        return "user";
    }

//    @Autowired
    // 无法自动装配，因为Shiro使用的Realm并不是一个bean
    private AccountService accountService = null;

    public boolean supports(AuthenticationToken authenticationToken) {
        return true;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if(accountService == null){
            WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            accountService = (AccountService)currentWebApplicationContext.getBean("accountService");
        }
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
//        accountService = ((UserAuthenticationToken)authenticationToken).getAccountService();
        Account account = accountService.getAccount(username);
        if(account == null){
            throw new UnknownAccountException();
        }
        else if(!new Md5Hash(password + username + account.getSalt()).toString().equals(account.getPassword())){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
