package com.zhss.demo.zuul.gateway.gray;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Configuration      
@EnableScheduling 
public class GrayReleaseConfigManager {
	
	private Map<String, GrayReleaseConfig> grayReleaseConfigs =
			new ConcurrentHashMap<String, GrayReleaseConfig>();

	
	@Scheduled(fixedRate = 1000) 
    private void refreshRoute() {
		List<GrayReleaseConfig> results = GatewayApiGrayUtil.getGatewayApiRoutes();

		for(GrayReleaseConfig grayReleaseConfig : results) {
			grayReleaseConfigs.put(grayReleaseConfig.getPath(), grayReleaseConfig);
		}
	}
	
	public Map<String, GrayReleaseConfig> getGrayReleaseConfigs() {
		return grayReleaseConfigs;
	}

}
