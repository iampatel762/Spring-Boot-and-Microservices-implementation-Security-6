//package com.suraj.api_gateway;
//
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableDiscoveryClient
//public class GatewayDiscoveryConf{
//
//    @Bean
//    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(DiscoveryClient discoveryClient) {
//
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
//    }
//}