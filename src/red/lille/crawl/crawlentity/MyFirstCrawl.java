/**
 * 
 */
package red.lille.crawl.crawlentity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import red.lille.crawl.utils.HttpUtil;

/**
 * @author 刘金明 2019-5-8
 * 
 */
public class MyFirstCrawl {

	public Map<String, List<String>> craUrl(String rootUrl, Integer deep) {
		if (deep == 0) {
			return null;
		}
		Map<String, List<String>> result = new HashMap<String, List<String>>(8);
		List<String> list = getUrlList(rootUrl);
		result.put(rootUrl, list);
		for (String newUrl : list) {
			Map<String, List<String>> temp = craUrl(newUrl, deep - 1);
			if (temp != null) {
				result.putAll(temp);
			}
		}
		return result;
	}

	/**
	 * 抓取一个url的内容，结果保存在result中,收集该html中的所有格式符合url的字符串并返回
	 * 
	 * @param thisUrl
	 * @return
	 */
	private List<String> getUrlList(String thisUrl) {
		String result = HttpUtil.get(thisUrl, null);
		List<String> list = new ArrayList<String>(8);
		String rgex = "[\"|']http(.*?)['|\"| |]";
		Pattern pattern = Pattern.compile(rgex);
		Matcher m = pattern.matcher(result);
		while (m.find()) {
			String temp ="http" + m.group(1);
			//if (isUrl(temp))
				list.add(temp);
		}
		return list;
	}
	/**
	 * 判断一个字符串是不是一个合法的url
	 * @param str
	 * @return
	 */
	public boolean isUrl(String str){
		return isUrlPattern.matcher(str).find();
	}
	//\\[\\]<>  !\u4e00-\u9fa5
	private static final String isUrlRgex="^https?://[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*(/[^(\u4e00-\u9fa5\\[\\]<>)]*)*$";
	private static final Pattern isUrlPattern=Pattern.compile(isUrlRgex);
}
