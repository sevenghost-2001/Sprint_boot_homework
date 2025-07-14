package com.cybersoft.demospringboot09.config;

import com.cybersoft.demospringboot09.entity.Role;
import com.cybersoft.demospringboot09.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration// Khi sprint boot khởi tạo sẽ quét các class có @Configuration
// @Configuration để tạo ra các bean đưa vào IOC container
public class DemoIOC {
    //@Bean: Đánh dấu phương thức này sẽ tạo ra một bean và đưa vào IOC container
    //@Component: Đánh dấu class này sẽ tạo ra một bean và đưa vào IOC container
    //@Service: Đánh dấu class này sẽ tạo ra một bean và đưa vào IOC container. thường dùng cho các service
    //@Repository: Đánh dấu class này sẽ tạo ra một bean và đưa vào IOC container. thường dùng cho các repository

    @Bean("Role1") // name là tên của bean, nếu không đặt thì tên sẽ là tên phương thức
    public Role role(){
        Role role = new Role();
        role.setId("1");
        role.setName("Admin");
        return role;
    }

    @Bean("Role2")
    public Role role2(){
        Role role = new Role();
        role.setId("2");
        role.setName("User");
        return role;
    }

    @Bean(name = "userA") // name là tên của bean, nếu không đặt thì tên sẽ là tên phương thức
    public User user(@Qualifier("Role2") Role role) {
        User user = new User();
        user.setUsername("cybersoft");
        System.out.println("Role ID: " + role.getName());
        return user;
    }

    @Bean(name = "userB")
    @Primary // Đánh dấu bean này là bean chính, nếu có nhiều bean cùng loại thì sẽ lấy bean này
    public  User user2(@Qualifier("Role2") Role role) {
        User user = new User();
        user.setUsername("cybersoft2");

        return user;
    }
}
