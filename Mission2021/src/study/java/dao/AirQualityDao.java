package study.java.dao;


import java.util.List;

import study.java.model.AirQualityItem;

public interface AirQualityDao {
	public List<AirQualityItem> getAirQualityList(String keyword);

}

