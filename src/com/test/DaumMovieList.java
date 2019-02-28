package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DaumMovieList {
	public static void main(String[] args) {
	
	System.out.println("---------다음 영화 순위----------");	
	Document daum;
	try {
		daum = Jsoup.connect("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q=%EC%98%81%ED%99%94").get();
		
		Elements count = daum.select("ol.type_plural div.info_tit");		
		Elements rank = count.select("dd.score em.rate");
		
		for(int i=0; i<count.size(); i++) {
			
			String rank2 = count.get(i).text();
			System.out.println(rank2+"\t");
		}
		
		System.out.println("---------다음 영화 순위2----------");		
		
			Elements div1 = daum.select("ol.type_plural div.info_tit");  
			Elements div2 = daum.select("dd.score em.rate");
			Elements div3 = daum.select("dl.dl_comm dd.cont");
			for(int i=0;i<div1.size();i++) { 
				String title = div1.get(i).text();
				String rate = div2.get(i).text();
				
				System.out.println(title + " 평점: "+ rate);
			}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
		
	}
}
