package com.maple.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maple.api.CityService;
import org.springframework.stereotype.Component;

/**
 * @author maple 2018.09.10 下午11:15
 */
@Component
public class HelloService {
    @Reference(url = "dubbo://127.0.0.1:20880")
    private CityService cityService;

    public Object hello() {
        return cityService.findCityByName("武汉");
    }

}
