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
 * @author ������ 2019-5-8
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
	 * ץȡһ��url�����ݣ����������result��,�ռ���html�е����и�ʽ����url���ַ���������
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
	 * �ж�һ���ַ����ǲ���һ���Ϸ���url
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
