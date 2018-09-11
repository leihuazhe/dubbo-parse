package com.maple.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.maple.api.City;
import com.maple.api.CityService;
import org.springframework.stereotype.Component;

/**
 * @author maple 2018.09.10 下午11:05
 */

@Service(interfaceClass = CityService.class)
@Component
public class CityServiceImpl implements CityService {

    public City findCityByName(String cityName) {
        System.out.println("request cityName: " + cityName);
        return new City("武汉", "湖北");
    }
}
