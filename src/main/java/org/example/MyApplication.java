package org.example;

import org.example.config.MQConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding({MQConfig.class})
@SpringBootApplication
public class MyApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MyApplication.class, args);
    }
}
