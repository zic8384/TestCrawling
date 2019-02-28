package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DaumNews {
	public static void main(String[] args) {
	
	System.out.println("---------다음 랭킹 뉴스 ----------");	
	Document doc;
	try {
		doc = Jsoup.connect("https://media.daum.net/ranking/popular/").get();
		
		Elements News = doc.select("ul.list_news2");
		Elements Nums = News.select("span.screen_out"); //번호
		Elements titles = News.select("a.link_txt"); //제목		
		Elements sinmoon = News.select("span.info_news"); //신문사
		Elements articles  = News.select("span.link_txt"); //기사내용

		
		for(int i=0;i<titles.size();i++) {
			String num = Nums.get(i).text();
			String title = titles.get(i).text();
			String sin = sinmoon.get(i).text(); 
			String article = articles.get(i).text();			
			System.out.println(num + " 위 : "+ title);
			System.out.println("신문사 : "+ sin);
			System.out.println("기사내용 : "+ article);
			System.out.println("-------------------------------------------------------------");
			
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
  }
}
