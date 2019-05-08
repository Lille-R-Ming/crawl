/**
 * 
 */
package red.lille.crawl.utils;

import java.util.Map;

/**
 * @author ������ 2019-5-8
 *
 */
public interface HttpUtil {
	/**
	 * ����Get����
	 * @param url
	 * @param param
	 * @return
	 */
	String get(String url,Map<String,String> param);
	/**
	 * ����post����
	 * @param url
	 * @param param
	 * @return
	 */
	String post(String url,Map<String,String> param);
}
