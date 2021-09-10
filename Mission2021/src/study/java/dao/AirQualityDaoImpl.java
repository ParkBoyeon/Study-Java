package study.java.dao;


import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import study.java.helper.HttpHelper;
import study.java.helper.JsonHelper;
import study.java.model.AirQualityItem;

public class AirQualityDaoImpl implements AirQualityDao{

	@Override
	public List<AirQualityItem> getAirQualityList(String keyword) {
		List<AirQualityItem> list = null;
		
		// 검색어
		String msrste_nm = null;
		double o3 = 0D;
		int pm10 = 0;
		int pm25 = 0;
		
		/** 한글일 경우 URLEncoding 처리가 되어야한다. */
		try {
			msrste_nm = URLEncoder.encode(keyword, "utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		// OpenAPI 주소
		String dataurl = "http://openAPI.seoul.go.kr:8088/70796c7a786f6b7137305a42645079/json/MonthlyAverageAirQuality/1/25/202103?MSRSTE_NM=" 
		+ msrste_nm + "O3=" + o3 + "PM10=" + pm10 + "PM25=" + pm25;
		
		
		Map<String, String> header = new HashMap<String, String>();
		header.put("Authorization", "70796c7a786f6b7137305a42645079");
		
		// JSON 파일을 읽어서 객체로 변환 
		// --> URL과 HTTP Header데이터를 함께 전달한다. 
		InputStream is = HttpHelper.getInstance().getWebData(dataurl, "utf-8", header);
		
		// 통신 결과가 없다면 처리 중단 
		if (is == null) {
			System.out.println("데이터 다운로드 실패");
			return null; 
		} 
		
		// 통신에 성공하였으므로, 리턴할 List 할당 
		list = new ArrayList<AirQualityItem>();
		
		// 통신 결과를 JSON 으로 변환 
		JSONObject json = JsonHelper.getInstance().getJSONObject(is, "utf-8");
		// 원하는 데이터에 접근하기
		JSONObject MonthlyAverageAirQuality = json.getJSONObject("MonthlyAverageAirQuality");
		JSONArray row = MonthlyAverageAirQuality.getJSONArray("row");
		
		
		// 배열의 항목 수 만큼 반복 
		for (int i = 0; i < row.length(); i++) {
			// 배열의 각 요소 추출
			JSONObject item = row.getJSONObject(i);
			
			// 값 추출
			String MSRSTE_NM = item.getString("MSRSTE_NM");
			float O3 = (float)item.getDouble("O3");
			int PM10 = item.getInt("PM10");
			int PM25 = item.getInt("PM25");
			
			// 추출한 값을 객체화하여 List에 추가
			list.add(new AirQualityItem(MSRSTE_NM, O3, PM10, PM25));
		}
		
		return list;
	}


}
