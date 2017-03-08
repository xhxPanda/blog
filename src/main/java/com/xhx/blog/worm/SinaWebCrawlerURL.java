package com.xhx.blog.worm;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SinaWebCrawlerURL {
	
	
	
//	
//	public SinaWebCrawler(){
//		
//		this.getMilitaryAffairsURLByList();
//		this.getSportURL();
//		this.getEconomicURL();
//	}
	
	//爬取新浪军事数据
	public HashSet<String> getMilitaryAffairsURLByList(){
		
		//储存url
		HashSet<String> listURLSet = new HashSet<String>();
		
		String realURL = null;
		for(int i = 0;i < 6;i++){
			realURL = "http://roll.mil.news.sina.com.cn/col/zgjq/"+ "index_"+i+".shtml";
			
			Document doc = null;
			try {
				doc = Jsoup.connect(realURL).get();
				
				Elements a = doc.select("ul.linkNews").select("a");
				
				for(Element e : a){
					String aHREF = e.attr("href");
					listURLSet.add(aHREF);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return listURLSet;
	}
	
	//爬取新浪体育数据
	public HashSet<String> getSportURL(){
		
		HashSet<String> listURLSet = new HashSet<String>();
		
		String realURL = "http://sports.sina.com.cn/";
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(realURL).get();
			
			Elements a = doc.select("ul.list01").select("a");
			
			for(Element e : a){
				String aHREF = e.attr("href");
				listURLSet.add(aHREF);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listURLSet;
	}
	
	//爬取新浪财经数据
	public  HashSet<String> getEconomicURL(){
		
		HashSet<String> listURLSet = new HashSet<String>();
		
		String realURL = "http://finance.sina.com.cn/";
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(realURL).get();
			
			Elements a = null;
			for(int i=2;i<6;i++){
				a = doc.select("div.m-part"+i).select("div.m-p-middle").select("a");
				
				for(Element e : a){
					String aHREF = e.attr("href");
					if(aHREF.endsWith("shtml")){
						listURLSet.add(aHREF);
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listURLSet;
	}
	
	public static void main(String args[]){
		SinaWebCrawlerURL  swc= new SinaWebCrawlerURL();
		
		HashSet<String> test = swc.getEconomicURL();
		
		System.out.print(test.size());
	}
	
}
