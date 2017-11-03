package com.test.DB.Mapper;

import com.test.DB.Entity.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUserById(int id) throws Exception;

    public void updateUser(User user) throws Exception;

    public List<User> selectUserList(User user) throws Exception;
}
