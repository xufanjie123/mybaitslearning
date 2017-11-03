package com.test.Sqltest;

import com.test.DB.Entity.User;
import com.test.DB.Mapper.UserCustomMapper;
import com.test.DB.Mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class SqlTest {
    @Test
    public void selectById () throws IOException {
        String resources = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectByName() throws IOException {
        String resources = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName","%111%");
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void insertOne() throws IOException {
        String resources = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("李四");
        user.setGender("male");
        user.setBirthday(new Date(95,00,13));
        user.setAddress("浙江省杭州市");
        System.out.println(user);
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void deleteOne() throws IOException {
        String resources = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.deleteUserById",4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        String resources = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(5);
        user.setUsername("李四");
        user.setGender("male");
        user.setBirthday(new Date(99,00,13));
        user.setAddress("浙江省杭州市");
        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception
    {
        String resources = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void getUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserByName() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUserByName("1");
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void insertUser() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("王五");
        user.setAddress("2312312");
        user.setBirthday(new Date());
        user.setGender("male");
        mapper.insertUser(user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectUser() throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        List<User> users = mapper.selectUserList(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void selectOrderUser() throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserCustomMapper mapper = sqlSession.getMapper(UserCustomMapper.class);
        List<UserCustomMapper> list = mapper.findOrderUser();
        System.out.println(list);
        sqlSession.close();
    }
}
