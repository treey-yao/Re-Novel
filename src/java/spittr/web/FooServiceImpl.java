package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ccy on 2017/7/22.
 */
@Component
public class FooServiceImpl {
//    @Autowired
    private RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper){
        this.roleMapper = roleMapper;
    }

    public Role getRoleById(long id){
        return this.roleMapper.getRole(id);
    }
}
