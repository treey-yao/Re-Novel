package spittr.web;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
@Component
public class MyRepository implements SpittleRepository{
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> list = new ArrayList<Spittle>();
        for(int i = 0;i<count;i++){
            list.add(new Spittle("count =" + i, new Date()));
        }
        return list;
    }
}
