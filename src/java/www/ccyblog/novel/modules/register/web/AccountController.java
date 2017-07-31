package www.ccyblog.novel.modules.register.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import www.ccyblog.novel.modules.register.service.AccountService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created by ccy on 2017/7/31.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/register", method = GET)
    public String registerForm(){
        return "";
    }

    @RequestMapping(value = "/register", method = POST)
    public String registerAccount(){
        return "";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(String username, String password){
        return "redirect:";
    }
}
