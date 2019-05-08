/**
 * 
 */
package red.lille.crawl.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author 刘金明 2019-5-8
 * 
 */
public class HttpUtil{

	/*
	 * (non-Javadoc)
	 * 
	 * @see red.lille.crawl.utils.HttpUtil#get(java.lang.String, java.util.Map)
	 */
	public static String get(String url, Map<String, String> param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString=url;
			URL realUrl=new URL(urlNameString);
			URLConnection connection=realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection","Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
			connection.connect();
			Map<String,List<String>> map=connection.getHeaderFields();
			for (@SuppressWarnings("unused") String key:map.keySet()){
				//System.out.println(key+"--->"+map.get(key));
			}
			//获得编码格式
			String charset="utf-8";
			List<String> contentType=map.get("Content-Type");
			for(String ele : contentType){
				int point=ele.indexOf("charset=");
				if(point>0){
					charset=ele.substring(point+8);
				}
			}
			in=new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
			String line;
			while((line=in.readLine())!=null){
				result+=line+'\n';
			}
		} catch (Exception e) {
			System.out.println("发送get请求出现异常" + e);
			e.printStackTrace();
		}finally{
			try{
				if(in!=null){
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see red.lille.crawl.utils.HttpUtil#post(java.lang.String, java.util.Map)
	 */
	public static String post(String url, Map<String, String> param) {
		PrintWriter out=null;
		BufferedReader in=null;
		String result="";
		try{
			URL realUrl=new URL(url);
			URLConnection conn=realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connectoin", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			Map<String,List<String>> map=conn.getHeaderFields();
			for (String key:map.keySet()){
				System.out.println(key+"--->"+map.get(key));
			}
			//获得编码格式
			String charset="utf-8";
			List<String> contentType=map.get("Content-Type");
			for(String ele : contentType){
				int point=ele.indexOf("charset=");
				if(point>0){
					charset=ele.substring(point+8);
				}
			}
			
			out=new PrintWriter(conn.getOutputStream());
			out.print("");
			out.flush();
			in=new BufferedReader(new InputStreamReader(conn.getInputStream(),charset));
			String line;
			while((line=in.readLine())!=null){
				result+=line+'\n';
			}
		}catch(Exception e){
			System.out.println("发送post请求出现异常"+e);
			e.printStackTrace();
		}finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
