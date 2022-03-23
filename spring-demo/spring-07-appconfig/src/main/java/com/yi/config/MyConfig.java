package com.yi.config;

import com.yi.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会Spring容器托管,注册到容器中,因为他本米就是一个@Component
//@Configuration代表这是一个配置类,就像我们之前看的beans.xml
@Configuration
@ComponentScan("com.yi.pojo")
@Import(MyConfig2.class)
public class MyConfig {

    //注册一个bean,就相当于我们之前写的一个bean标签
    //这个方法的名字,就相当于bean标签中的id属性
    //这个方法的返同值,就相当于bean标签中的class属性
    @Bean
    public User getUser() {
        return new User();//就是返回要注入到bean的对象
    }
}
