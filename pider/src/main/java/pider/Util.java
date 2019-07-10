package pider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.Cookie;
public class Util {
	public static String getKugouSource(String url,String charset,String fangfa) throws IOException{
			HttpURLConnection urlobject=(HttpURLConnection)new URL(url).openConnection();
		String cookie="kg_mid=6113a5ae3f1a4d24cb9c40304ae6ae90";
			urlobject.setRequestProperty("cookie",cookie);
			InputStream is=urlobject.getInputStream();
			InputStreamReader ir=new InputStreamReader(is,charset);
			BufferedReader br=new BufferedReader(ir);
			StringBuffer sb=new StringBuffer();
			String temp=null;
			while ((temp=br.readLine())!=null){
				sb.append(temp);
			}
			br.close();
			//System.out.println(document.toString());
			return  sb.toString();
		}

	public static String getMp3ByHash(String url) throws Exception{
		String charset="utf-8";
		String fangfa="t";
		String sourse= Util.getKugouSource(url, charset,fangfa);
		//System.out.println("hash="+sourse);
		return sourse;
	}

	public static void main(String[] args) throws Exception {
		String url="https://songsearch.kugou.com/song_search_v2?keyword=%E5%A4%A7%E6%B5%B7&page=1&pagesize=30&platform=WebFilter&tag=em&filter=2";
		String charset="utf-8";
		String sourse=Util.getMp3ByHash(url);
		System.out.println(sourse);

	}

}
