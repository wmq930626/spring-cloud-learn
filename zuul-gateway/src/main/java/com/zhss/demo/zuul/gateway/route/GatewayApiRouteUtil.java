package com.zhss.demo.zuul.gateway.route;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储路由信息
 */
public class GatewayApiRouteUtil {

    private static List<GatewayApiRoute> gatewayApiRoutes = new ArrayList<GatewayApiRoute>();

    public static List<GatewayApiRoute> getGatewayApiRoutes() {
        return gatewayApiRoutes;
    }

    public static void setGatewayApiRoutes(List<GatewayApiRoute> gatewayApiRoutes) {
        GatewayApiRouteUtil.gatewayApiRoutes = gatewayApiRoutes;
    }
}
