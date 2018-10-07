package com.maple.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maple.api.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maple 2018.09.10 下午11:21
 */
@RestController
public class HelloController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "${dubbo.service.url}")
    private CityService cityService;


    @RequestMapping("/hello")
    public Object hello() {
        return cityService.findCityByName("武汉");
    }
}
