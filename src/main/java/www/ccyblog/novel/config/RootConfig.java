package www.ccyblog.novel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2017/7/16.
 */
@Configuration
@ComponentScan(basePackages = {"www.ccyblog.novel"}, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
@ImportResource("WEB-INF/dispatcher-servlet.xml")
public class RootConfig {
}
