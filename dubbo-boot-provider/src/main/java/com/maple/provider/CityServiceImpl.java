package com.maple.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.maple.api.City;
import com.maple.api.CityService;

/**
 * @author maple 2018.09.10 下午11:05
 */

@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class CityServiceImpl implements CityService {

    @Override
    public City findCityByName(String cityName) {
        System.out.println("request cityName: " + cityName);
        return new City("武汉", "湖北");
    }
}
