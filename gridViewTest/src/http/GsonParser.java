package http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @ClassName: BaseResponseHandler
 * @Description: 处理response的基类
 * @author Kevinliu 
 * @date 2015年1月31日 下午4:03:23
 * 
*/

public class GsonParser {

	public static <T> T parseList(String result,TypeToken<T> typeToken) {
		return new Gson().fromJson(result, typeToken.getType());
	}
	
	public static <T> T parseObject(String result,Class<T> clazz){
		return new Gson().fromJson(result, clazz);
	}

}
