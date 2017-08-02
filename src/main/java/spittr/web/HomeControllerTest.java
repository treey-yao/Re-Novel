package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import www.ccyblog.novel.config.WebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by Administrator on 2017/7/16.
 */

public class HomeControllerTest
{
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.
                standaloneSetup(controller).
                setViewResolvers(new WebConfig().viewResolver()).
                build();
        mockMvc.perform(get("/home")).andExpect(MockMvcResultMatchers.view().name("home"));
    }


}
