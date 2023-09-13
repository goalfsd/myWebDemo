package com.lucianlu.mywebdemo;

import com.lucianlu.mywebdemo.config.CustomConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lucianlu")
public class MyWebDemoApplication {

    public static void main(String[] args) {
        /**
         * 数据文件加载顺序，为了更合理的重写各属性的值
         *  #命令行中传入的参数。
         *  #SPRING_APPLICATION_JSON中的属性。SPRING_APPLICATION_JSON是以JSON格式配置在系统环境变量中的内容。
         *  #java:comp/env中的JNDI属性。
         *  #Java的系统属性，可以通过System.getProperties()获得的内容。
         *  #操作系统的环境变量
         *  #通过random.*配置的随机属性
         *  #位于当前应用jar包之外，针对不同{profile}环境的配置文件内容，例如：application-{profile}.properties或是YAML定义的配置文件
         *  #位于当前应用jar包之内，针对不同{profile}环境的配置文件内容，例如：application-{profile}.properties或是YAML定义的配置文件
         *  #位于当前应用jar包之外的application.properties和YAML配置内容
         *  #位于当前应用jar包之内的application.properties和YAML配置内容
         *  #在@Configuration注解修改的类中，通过@PropertySource注解定义的属性
         *  #应用默认属性，使用SpringApplication.setDefaultProperties定义的内容
         */
        ApplicationContext context = SpringApplication.run(MyWebDemoApplication.class, args);

        Binder binder = Binder.get(context.getEnvironment());

        // 绑定简单配置
        CustomConfigProperties customConfigProperties = binder.bind("custom-config",
                Bindable.of(CustomConfigProperties.class)).get();
        System.out.println("=====customConfigProperties.getUserName:" + customConfigProperties.getUserName());
        System.out.println("=====customConfigProperties.getUserAge:" + customConfigProperties.getUserAge());

        System.out.println("======from context environment get user-name:" + context.getEnvironment()
                .containsProperty("custom-config.user-name"));
        System.out.println("======from context environment get username:" + context.getEnvironment()
                .containsProperty("custom-config.username"));
        System.out.println("======from context environment get userName:" + context.getEnvironment()
                .containsProperty("custom-config.userName"));
    }

}
