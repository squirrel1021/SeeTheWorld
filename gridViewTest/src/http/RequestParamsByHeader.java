package http;


import com.lidroid.xutils.http.RequestParams;

/**
 * @ClassName: RequestParamsByHeader
 * @Description: requestParams的包装类，封装了headers
 * 
*/

public class RequestParamsByHeader extends RequestParams {
	
	public RequestParamsByHeader() {
		super();
		addHeaders();
	}


	public RequestParamsByHeader(String charset) {
		super(charset);
		addHeaders();
	}
	private void addHeaders() {
		addHeader("Content-Type", "application/json");
		addHeader("charset", "utf-8");
//		addHeader("Authorization", PhoneUtils.getTVIMEI(CarnestApplication.mContext));
		addHeader("apikey", "18afe33dc082d9e88dfabb60bca0180e");
	}
	
	

}
