package com.test;

import java.io.IOException;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Exam01 {

	public static void main(String[] args) {
		Document doc;
		Document doc2;
		Document doc3;
		try {
			doc = Jsoup.connect("http://m.exchange.daum.net/mobile/exchange/exchangeMain.daum").get();
			Elements asiamain = doc.select("div#exchangeDiv");
			Elements dt = asiamain.select("dt");
			Elements dd = asiamain.select("dd");
			
			for(int i=0;i<dt.size();i++) {
				String title = dt.get(i).text();				
				String price = dd.get(i).select("span.price").text();
				String point = dd.get(i).select("span.point").text();
				String rate = dd.get(i).select("span.rate").text();
				System.out.println(title+"\t"+price);
				System.out.println(point+"\t"+rate);
			}
			
			System.out.println("--------------");
			
			Elements contury = doc.select("tr.link");	
					
			for(int i=0;i<contury.size();i++) {
				String name = contury.get(i).select("td.name").text();				
				String idx = contury.get(i).select("td.idx").text();											
				System.out.println(name+"\t"+idx);
				
			}
			
			System.out.println("--------------");
			Elements asia = doc.select("div#mideastBody");//'#'은 소스에서 아이디값 
			Elements td = asia.select("tr.link"); //'.'은  class명
			
			for(int i=0;i<td.size();i++) {
				String name = td.get(i).select("td.name").text();				
				String idx = td.get(i).select("td.idx").text();
				String cdn = td.get(i).select("td.idx_fluc").text();
				String rate = td.get(i).select("td.rate_fluc").text();
				System.out.println(name+"\t"+idx+"\t"+cdn+"\t"+rate+"\t");
				
			}
			
			System.out.println("--------------");
			
			doc2 = Jsoup.connect("http://m.finance.daum.net/m/quote/index.daum").get();
			Elements td2 = doc2.select("span.stUp");
			
			for(int i=0;i<td2.size();i++) {
				String name = td2.get(i).select("th.name").text();				
				String cdn = td2.get(i).select("td.rate_fluc").text();
				System.out.println(name+"\t"+cdn+"\t");
				
			}
			
				System.out.println("---------로또번호----------");
			
			doc3 = Jsoup.connect("https://m.dhlottery.co.kr/gameResult.do?method=byWin").get();
			Elements div = doc3.select("div.bx_lotto_winnum");
			
			for(int i=0;i<div.size();i++) {
				String clr2 = div.get(i).select("span.ball").text();
				System.out.println(clr2+"\t");
				
			}
			
			System.out.println("---------로또2----------");
			Document doc4 = Jsoup.connect("https://m.dhlottery.co.kr/common.do?method=main").get();			
			Element ballNum = doc4.select("div.prizeresult").first();

			String num = ballNum.select("div.num").text();
			System.out.println(num+"\t");
				
			
			System.out.println("---------로또3----------");						
			Element ballNum2 = doc4.select("div.prizeresult").first();
			Elements num2 = ballNum2.select("div.num");
			
			for(int i=0;i<num2.size();i++) {
			String su = num2.get(i).select("span").text();
			System.out.print(su+"\t");
			System.out.println("-------");
			
			}
			
			System.out.println("---------로또번호4----------");			
			Elements titles = doc4.select("div.section_title #lottoDrwNo");//하위로 들어갈땐 공백(" ")을 써라
			Elements lottoDrwNo = doc4.select("div.prizeresult");
			
			for(int i=0;i<titles.size();i++) {
				String lottoCount = titles.get(i).select("strong").text();
				String su = lottoDrwNo.get(i).select("span").text();
				System.out.println(lottoCount);
				System.out.print(su+"\t");
				System.out.println();
			}			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
