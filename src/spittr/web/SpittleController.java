package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2017/7/16.
 */
/**
 * Computes key.hashCode() and spreads (XORs) higher bits of hash
 * to lower.  Because the table uses power-of-two masking, sets of
 * hashes that vary only in bits above the current mask will
 * always collide. (Among known examples are sets of Float keys
 * holding consecutive whole numbers in small tables.)  So we
 * apply a transform that spreads the impact of higher bits
 * downward. There is a tradeoff between speed, utility, and
 * quality of bit-spreading. Because many common sets of hashes
 * are already reasonably distributed (so don't benefit from
 * spreading), and because we use trees to handle large sets of
 * collisions in bins, we just XOR some shifted bits in the
 * cheapest possible way to reduce systematic lossage, as well as
 * to incorporate impact of the highest bits that would otherwise
 * never be used in index calculations because of table bounds.
 */
@Controller
@Component
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    @Autowired
    public SpittleController(MyRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    @RequestMapping(method = GET)
    public String spittles(
            @RequestParam(value = "max",defaultValue = "10") long max,
            @RequestParam(value = "count", defaultValue = "" + Integer.MAX_VALUE) int count,
            Model model){
        model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        model.addAttribute("max", max);
        model.addAttribute("count", count);
        return "spittles";

    }

    @RequestMapping(value="/{pathValue}",method = GET)
    public String variTest(
            @PathVariable("pathValue") String pathValue,
            Model model){
        model.addAttribute("pathValue", pathValue);
        return "spittles";
    }

    @RequestMapping(value="/register",method = GET)
    public String showForm(Model model)
    {
        model.addAttribute("roleInfo", new RoleInfo());
        return "register";
    }

    @RequestMapping(value="/register",method = POST)
    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid  RoleInfo roleInfo, Errors errors, Model model){
        System.out.println(roleInfo.firstName+ " "+roleInfo.lastName);
        try {
            profilePicture.transferTo(new File("/data/spittr/" + profilePicture.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(errors.hasErrors()){
            model.addAttribute("hasError",true);
            return "register";
        }
        return "redirect:/spittles/profile/" + roleInfo.getUserName();
    }

    @RequestMapping(value="/profile/{username}", method = GET)
    public String showUserInfo(@PathVariable String username, Model model){
        model.addAttribute("username", username);
        return "profile";
    }


}
