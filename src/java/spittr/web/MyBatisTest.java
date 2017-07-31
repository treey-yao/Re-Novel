package spittr.web;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sun.misc.Unsafe;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static sun.misc.Unsafe.getUnsafe;

/**
 * Created by ccy on 2017/7/22.
 */
public class MyBatisTest {
    @Test
    public void test(){
        try{
            Reader reader = Resources.getResourceAsReader("../../");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
//            Role role = (Role)sqlSession.selectOne("spittr.web.Role.getRole", 1l);
            RoleMapper roleMapper = (RoleMapper)sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1);
            System.out.println(role.getRoleName() + role.getNote());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Unsafe unsafe = getUnsafe();
    }
}
