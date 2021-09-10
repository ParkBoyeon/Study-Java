

import org.json.JSONArray;
import org.json.JSONObject;

import study.java.helper.FileHelper;
import study.java.model.News;

public class Main05 {

	public static void main(String[] args) {
		String source = FileHelper.getInstance().readString("res/05.json", "utf-8");
		
		JSONObject json = new JSONObject(source);
		JSONObject rss = json.getJSONObject("rss");
		JSONArray item = rss.getJSONArray("item");
		
		for(int i=0; i<item.length(); i++) {
			JSONObject temp = item.getJSONObject(i);
			
			String title = temp.getString("title");
			String description = temp.getString("description");
			String pubDate = temp.getString("pubDate");
			
			News news = new News(title, description, pubDate);
			System.out.println(news.toString());
		}

	}

}
