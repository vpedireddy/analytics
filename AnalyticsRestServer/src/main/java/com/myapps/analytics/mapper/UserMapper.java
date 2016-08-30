package com.myapps.analytics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.myapps.analytics.domain.User;

@Component
public interface UserMapper
{
    @Insert("insert into user_t(id,first_name,last_name,username,password,mobile,age,sex,email,is_admin) "
    		+ "values(#{id},#{firstName},#{lastName},#{username},#{password},#{mobile},#{age},#{sex},#{email},#{isAdmin})")
    void insertUser(User user);
   
    @Select("select id,first_name,last_name,username,password,mobile,age,sex,email,is_admin from user_t WHERE id=#{id}")
    @Results(value = {
    	      @Result(property = "firstName", column = "first_name"),
    	      @Result(property = "lastName", column = "last_name"),
    	      @Result(property = "isAdmin", column = "is_admin"),
    	   })
    User findUserById(Integer id);
    
    @Select("select id,first_name,last_name,username,password,mobile,age,sex,email,is_admin from user_t WHERE email=#{email}")
    @Results(value = {
    	      @Result(property = "firstName", column = "first_name"),
    	      @Result(property = "lastName", column = "last_name"),
    	      @Result(property = "isAdmin", column = "is_admin"),
    	   })
    User findUserByEmail(String email);
    
    @Select("select id,first_name,last_name,username,password,mobile,age,sex,email,is_admin from user_t")
    @Results(value = {
  	      @Result(property = "firstName", column = "first_name"),
  	      @Result(property = "lastName", column = "last_name"),
  	    @Result(property = "isAdmin", column = "is_admin"),
  	   })
    List<User> findAllUsers();

    @Update("update user_t set first_name = #{firstName},last_name = #{lastName},username = #{username},password = #{password},mobile = #{mobile},age = #{age},sex =#{sex},email = #{email},is_admin=#{isAdmin} where id = #{id}")
    @Results(value = {
    	      @Result(property = "firstName", column = "first_name"),
    	      @Result(property = "lastName", column = "last_name"),
    	      @Result(property = "isAdmin", column = "is_admin"),
    	   })
    void updateUser(User user);
}
