package com.cybersoft.demospringboot09.controller;
import com.cybersoft.demospringboot09.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
    @Controller: Định nghĩa đường dẫn của controller và trả về dữ liệu HTML
    @RestController: Định nghĩa đường đường dẫn và trả về dữ liệu JSON + String
    @RequestMapping: Định nghĩa đường dẫn của Controller
 */

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired  //Lấy bean từ IOC container
    //Tôi muốn lấy userA từ IOC container
    @Qualifier("userB") // Chỉ định lấy bean nào trong trường hợp có nhiều bean cùng loại
    private User user;

//    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping("/hel")
    public String hello(){
        return "Hello World";
    }
//    @RequestMapping(path = "/hello/bc09",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello_bc09(){
        return "Hello World - BC09";
    }


}
