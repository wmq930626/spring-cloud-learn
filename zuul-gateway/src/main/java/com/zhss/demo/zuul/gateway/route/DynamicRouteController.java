package com.zhss.demo.zuul.gateway.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dynamicRoute")
public class DynamicRouteController {

    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private RouteLocator routeLocator;

    @PostMapping("/addRoute")
    public String addRoute(@RequestBody GatewayApiRoute gatewayApiRoute){
        List<GatewayApiRoute> gatewayApiRoutes = GatewayApiRouteUtil.getGatewayApiRoutes();
        gatewayApiRoutes.add(gatewayApiRoute);
        publishEvent();
        return "success";
    }

    @PostMapping("/delRoute")
    public String delRoute(@RequestBody GatewayApiRoute gatewayApiRoute){
        List<GatewayApiRoute> gatewayApiRoutes = GatewayApiRouteUtil.getGatewayApiRoutes();
        gatewayApiRoutes.remove(gatewayApiRoute);
        publishEvent();
        return "success";
    }

    private void publishEvent() {
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }
}
