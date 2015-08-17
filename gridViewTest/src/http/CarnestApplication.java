package http;

import android.app.Application;
import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class CarnestApplication extends Application {

	public static String TOKEN;

	public static Context mContext;

	public static HttpUtils mHttpUtils;
	
	public static DbUtils mDao;

	@Override
	public void onCreate() {
		mContext = this;
		mHttpUtils = new HttpUtils(this);
		mHttpUtils.sHttpCache.setEnabled(HttpMethod.GET, false);
		
		super.onCreate();
//		ChromeView.initialize(this);
	}

}
