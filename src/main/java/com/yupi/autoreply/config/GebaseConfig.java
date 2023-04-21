package com.yupi.autoreply.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "gebase")
@Data
public class GebaseConfig {

    /**
     * 连接webSocket地址
     */
    private String url;

}
