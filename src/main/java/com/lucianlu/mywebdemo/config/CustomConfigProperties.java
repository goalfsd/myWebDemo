package com.lucianlu.mywebdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "custom-config")
@Configuration()
public class CustomConfigProperties {

    /**
     * 在Spring Boot 2.0中对配置属性加载的时候会除了像1.x版本时候那样移除特殊字符外，还会将配置均以全小写的方式进行匹配和加载。
     * 配置中的user-name 等同于 username  userName
     *
     * 但是如果我们要在Spring应用程序的environment中读取属性的时候，每个属性的唯一名称符合如下规则：
     *
     * 通过.分离各个元素
     * 最后一个.将前缀与属性名称分开
     * 必须是字母（a-z）和数字(0-9)
     * 必须是小写字母
     * 用连字符-来分隔单词
     * 唯一允许的其他字符是[和]，用于List的索引
     * 不能以数字开头
     */
    private String userName;
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public CustomConfigProperties setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public CustomConfigProperties setUserAge(Integer userAge) {
        this.userAge = userAge;
        return this;
    }
}
