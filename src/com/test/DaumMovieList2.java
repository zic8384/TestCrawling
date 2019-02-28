package com.test;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DaumMovieList2 {
	public static void main(String[] args) {
	
	System.out.println("---------다음 영화 순위----------");	
	System.out.println();
	Document daum;
	try {
		daum = Jsoup.connect("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q=%EC%98%81%ED%99%94").get();
		
		Elements movie_list = daum.select("ol.movie_list li").not("li.hide");		
		Elements titleContainer = movie_list.select("div.info_tit a");
		Elements rateContainer = movie_list.select("em.rate");
		ArrayList<Movie> arr = new ArrayList<>();
		
		for(int i=0; i<rateContainer.size(); i++) {
			Movie m = new Movie();
			String title = titleContainer.get(i).text();
			String rate = rateContainer.get(i).text();
			m.setTitle(title);
			m.setRate(rate);
			arr.add(m);			
		}
			
		for(Movie movie:arr) { 			
			System.out.println("제목 : "+movie.getTitle());
			System.out.println("평점 : "+movie.getRate());
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
		
	}
}
