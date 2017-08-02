package spittr.web;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ccy on 2017/7/22.
 */
public interface RoleMapper2 extends RoleMapper{
    @Select("SELECT * FROM role WHERE id = #{id}")
    Role getRole(@Param("id") long id);
}
