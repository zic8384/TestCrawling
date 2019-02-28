package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Daumhotissue {
	public static void main(String[] args) {
	
	System.out.println("---------¥Ÿ¿Ω «÷¿ÃΩ¥----------");	
	Document daum;
	try {
		daum = Jsoup.connect("https://www.daum.net/").get();
		
		Elements count = daum.select("ol.list_mini li");
		Elements rank = count.select("div.rank_cont");
		
		for(int i=0; i<count.size(); i++) {
			String rank2 = count.get(i).text();
			System.out.println(rank2+"\t");
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
	
	
 }
}
