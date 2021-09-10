

import org.json.JSONObject;

import study.java.helper.FileHelper;
import study.java.model.News;

public class Main04 {

	public static void main(String[] args) {
		
		String source = FileHelper.getInstance().readString("res/04.json", "utf-8");
		JSONObject json = new JSONObject(source);
		JSONObject rss = json.getJSONObject("rss");
		JSONObject item = rss.getJSONObject("item");
		
		String title = item.getString("title");
		String description = item.getString("description");
		String pubDate = item.getString("pubDate");
		
		News news = new News(title, description, pubDate);
		System.out.println(news.toString());

	}

}
