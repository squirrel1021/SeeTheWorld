package gridViewTest;

import http.BaseRequestHandler;
import http.GsonParser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gridviewtest.R;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.weather)
public class Weather extends Activity{

	@ViewInject(R.id.day)
	TextView day;
	@ViewInject(R.id.weather)
	TextView weather;
	@ViewInject(R.id.city_edittext)
	EditText mEditText;
	@ViewInject(R.id.weather_json)
	TextView mWeatherJson;
	
	private List<WeatherEntity>list=new ArrayList<WeatherEntity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ViewUtils.inject(this);
		
	}
	@OnClick(R.id.query_weather)
	protected void queryWeather(View v){
		getWeather();
	}
	private void getWeather() {
		new BaseRequestHandler().send(InterfaceRequest.WEATHER.toString()+"?"+"cityname="+mEditText.getText().toString(), HttpMethod.GET, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				System.out.println(arg1);
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				try {
					JSONObject jsonObject=new JSONObject(arg0.result);
					JSONObject retData=jsonObject.getJSONObject("retData");
					String history=retData.getString("history");
					list=GsonParser.parseList(history, new TypeToken<List<WeatherEntity>>(){});
					setDate(jsonObject);
					System.out.println(history);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	protected void setDate(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		day.setText(list.get(0).getDate());
		weather.setText(list.get(0).getLowtemp()+"~"+list.get(0).getHightemp());
		mWeatherJson.setText(jsonObject.toString());
	}
}
