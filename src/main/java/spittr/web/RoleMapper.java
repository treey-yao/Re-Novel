package spittr.web;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by ccy on 2017/7/22.
 */
//@Repository
@Component
public interface RoleMapper {
//    @Select("SELECT * FROM role WHERE id = #{id}")
    Role getRole(@Param("id") long id);
}
