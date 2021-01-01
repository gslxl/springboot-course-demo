package edu.bistu.loginweb.mapper;

import edu.bistu.loginweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Insert("insert into user (username, password) VALUES (#{username},#{password})" )
    int saveUser(@Param("username") String username,@Param("password") String password);
    @Select("select ID,username,password from user where username=#{username}")
    User selectUser(@Param("username") String username);
    
}
