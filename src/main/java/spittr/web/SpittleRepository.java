package spittr.web;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
