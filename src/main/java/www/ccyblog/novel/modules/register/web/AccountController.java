package www.ccyblog.novel.modules.register.web;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import www.ccyblog.novel.modules.register.entity.Account;
import www.ccyblog.novel.modules.register.service.AccountService;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created by ccy on 2017/7/31.
 */
@Log4j
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/register", method = GET)
    public String registerForm(){
//        accountService.createAccount("mynameisxiaoxiao", "hchc08235");
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String registerAccount(@RequestParam(value = "username",defaultValue = "") String username ,
                                  @RequestParam(value = "password",defaultValue = "") String password ,
                                  @RequestParam(value = "rePassword",defaultValue = "") String rePassword ,
                                  @RequestParam(value = "captcha",defaultValue = "") String captcha ,
                                  Model model){
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuffer requestURL = request.getRequestURL();
        log.error(username + password + rePassword);
        System.out.println(username + password + rePassword);
        accountService.createAccount(username, password, rePassword, captcha);
        return "register";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(String username, String password){
        return "redirect:";
    }
}
