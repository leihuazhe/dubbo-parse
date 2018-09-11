package com.maple.api;

/**
 * @author maple 2018.09.10 下午11:03
 */
public interface CityService {
    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName
     */
    City findCityByName(String cityName);
}


