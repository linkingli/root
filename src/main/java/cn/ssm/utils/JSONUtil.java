package cn.ssm.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * @author kwd
 * JSON工具类
 * 
 */
public class JSONUtil {
	/**
	 * 将对象转换为JSON字符串
	 * @param object 对象
	 * @param excludes 不包含在JSON字符串中的对象的属性名称数组
	 * @return JSON字符串
	 */
	public static String objectToJSON(Object object,String[] excludes){
		JsonConfig config=new JsonConfig();
		config.setExcludes(excludes);
		JSONObject jsonObject=JSONObject.fromObject(object, config);
		return jsonObject.toString();
	}
	/**
	 * 将对象转换为JSON字符串数组
	 * @param object 对象
	 * @param excludes 不包含在JSON字符串中的对象的属性名称数组
	 * @return JSON字符串数组
	 */
	public static String objctToJSONArray(Object object,String[] excludes){
		JsonConfig config=new JsonConfig();
		config.setExcludes(excludes);
		JSONArray array=JSONArray.fromObject(object, config);
		return array.toString();
	}
}
