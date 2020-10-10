package com.zhss.demo.zuul.gateway.gray;


import java.util.ArrayList;
import java.util.List;

/**
 * 存储路由信息
 */
public class GatewayApiGrayUtil {

    private static List<GrayReleaseConfig> gatewayApiRoutes = new ArrayList<GrayReleaseConfig>();

    public static List<GrayReleaseConfig> getGatewayApiRoutes() {
        return gatewayApiRoutes;
    }

    public static void setGatewayApiRoutes(List<GrayReleaseConfig> gatewayApiRoutes) {
        GatewayApiGrayUtil.gatewayApiRoutes = gatewayApiRoutes;
    }
}
