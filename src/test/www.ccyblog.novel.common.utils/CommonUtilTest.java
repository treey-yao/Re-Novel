package www.ccyblog.novel.common.utils;

import org.junit.Test;

/**
 * Created by ccy on 2017/7/31.
 */
public class CommonUtilTest {
    @Test
    public void testSalt(){
        for(int i = 0;i<10;i ++ ){
            System.out.println(CommonUtil.generateRandomSalt());
        }
    }
}
