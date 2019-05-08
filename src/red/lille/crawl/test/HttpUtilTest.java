/**
 * 
 */
package red.lille.crawl.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import red.lille.crawl.crawlentity.MyFirstCrawl;

/**
 * @author Áõ½ðÃ÷ 2019-5-8
 *
 */
public class HttpUtilTest {
	@Test
	public void testCraUrl(){
		String url="https://www.cnblogs.com/liujinming/";
		Integer deep=2;
		MyFirstCrawl mfc=new MyFirstCrawl();
		Map<String,List<String>> result=mfc.craUrl(url, deep);
		for(String str:result.keySet()){
			System.out.println(str+"\t--->");
			for(String str2:result.get(str)){
				System.out.println(mfc.isUrl(str2)+"\t"+str2);
			}
		}
	}
}
