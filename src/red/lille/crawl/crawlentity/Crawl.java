/**
 * 
 */
package red.lille.crawl.crawlentity;

import java.io.File;

/**
 * @author 刘金明 2019-5-8
 *
 */
public abstract class Crawl {
	protected String root;//根url
	
	protected File file;//这是一个文件夹而不是文件，所有数据都存放在这个文件夹下（如果有必要的话）
}
