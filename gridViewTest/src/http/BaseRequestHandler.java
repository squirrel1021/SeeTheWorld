package http;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;


import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * @ClassName: BaseRequestHandler
 * @Description: 请求基类
 * @author Kevinliu
 * @date 2015年1月30日 上午10:04:29
 * 
 */

public class BaseRequestHandler {

	public <T> void send(String url, HttpMethod method, Object obj, RequestCallBack<T> callBack) {
		send(url, method, obj, new RequestParamsByHeader(), callBack);
	}

	public <T> void send(String url, HttpMethod method, RequestCallBack<T> callBack) {
		send(url, method, null, new RequestParamsByHeader(), callBack);
	}

	public <T> ResponseStream sendSync(String url, HttpMethod method, Object obj) {
		return sendSync(method, url, obj, new RequestParamsByHeader());
	}

	public <T> ResponseStream sendSync(String url, HttpMethod method) {
		return sendSync(method, url, null, new RequestParamsByHeader());
	}

	public <T> ResponseStream sendSync(HttpMethod method, String url, Object obj, RequestParams params) {
		setDefaultRequestParams(obj, params);
		try {
			return CarnestApplication.mHttpUtils.sendSync(method, url, params);
		} catch (HttpException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> void send(String url, HttpMethod method, Object obj, RequestParams params, RequestCallBack<T> callBack) {
		// TODO Auto-generated method stub
		setDefaultRequestParams(obj, params);
		CarnestApplication.mHttpUtils.send(method, url, params, callBack);
	}

	private void setDefaultRequestParams(Object obj, RequestParams params) {

		if (obj != null) {
			String Json = new Gson().toJson(obj);
			try {
				params.setBodyEntity(new StringEntity(Json, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}

}
