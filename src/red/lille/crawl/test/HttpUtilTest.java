/**
 * 
 */
package red.lille.crawl.test;

import org.junit.Test;

import red.lille.crawl.utils.HttpConnect;
import red.lille.crawl.utils.HttpUtil;

/**
 * @author Áõ½ðÃ÷ 2019-5-8
 *
 */
public class HttpUtilTest {
	@Test
	public void testGet(){
		String url="http://www.baidu.com";
		
		HttpUtil httpUtil=new HttpConnect();
		String result=httpUtil.get(url, null);
		System.out.print(result);
		
	}
}
