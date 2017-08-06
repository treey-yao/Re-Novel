package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Administrator on 2017/7/16.
 */
@Controller
@RequestMapping(value="/home")
public class HomeController {
    @RequestMapping(method=GET)
    public String home(){
        return "index";
    }
}
