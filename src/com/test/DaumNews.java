package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DaumNews {
	public static void main(String[] args) {
	
	System.out.println("---------���� ��ŷ ���� ----------");	
	Document doc;
	try {
		doc = Jsoup.connect("https://media.daum.net/ranking/popular/").get();
		
		Elements News = doc.select("ul.list_news2");
		Elements Nums = News.select("span.screen_out"); //��ȣ
		Elements titles = News.select("a.link_txt"); //����		
		Elements sinmoon = News.select("span.info_news"); //�Ź���
		Elements articles  = News.select("span.link_txt"); //��系��

		
		for(int i=0;i<titles.size();i++) {
			String num = Nums.get(i).text();
			String title = titles.get(i).text();
			String sin = sinmoon.get(i).text(); 
			String article = articles.get(i).text();			
			System.out.println(num + " �� : "+ title);
			System.out.println("�Ź��� : "+ sin);
			System.out.println("��系�� : "+ article);
			System.out.println("-------------------------------------------------------------");
			
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
  }
}
