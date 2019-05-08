/**
 * 
 */
package red.lille.crawl.utils;

import java.util.Map;

/**
 * @author 刘金明 2019-5-8
 *
 */
public interface HttpUtil {
	/**
	 * 发送Get请求
	 * @param url
	 * @param param
	 * @return
	 */
	String get(String url,Map<String,String> param);
	/**
	 * 发送post请求
	 * @param url
	 * @param param
	 * @return
	 */
	String post(String url,Map<String,String> param);
}
