package www.ccyblog.novel.modules.account.web;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by isghost on 2017/8/6.
 */
@Log4j
@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String showProfile(){
        return "profile";
    }
}
