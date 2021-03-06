package com.zhss.demo.zuul.gateway.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicRouteConfiguration {
 
    @Autowired
    private ZuulProperties zuulProperties;
    @Autowired
    private ServerProperties server;
 
    @Bean
    public DynamicRouteLocator routeLocator() {
    	DynamicRouteLocator routeLocator = new DynamicRouteLocator(
    			this.server.getServletPrefix(), this.zuulProperties);
        return routeLocator;
    }
 
}