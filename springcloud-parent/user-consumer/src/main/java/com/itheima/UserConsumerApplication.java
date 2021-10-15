package com.itheima;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/12 10:55
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//启用熔断器
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced//开启ribbon
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*@Configuration
    class DefaultRibbonConfig {

        @Bean
        public IRule ribbonRule() {
            return new RandomRule();
        }

        @Bean
        public IPing ribbonPing() {
            return new PingUrl();
        }

       *//* @Bean
            public ServerList<Server> ribbonServerList(IClientConfig config) {
                return new UserConsumerApplication.BazServiceList(config);
            }
        *//*
        @Bean
        public ServerListSubsetFilter serverListFilter() {
            ServerListSubsetFilter filter = new ServerListSubsetFilter();
            return filter;
        }

    }*/




}

