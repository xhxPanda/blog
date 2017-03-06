package com.xhx.blog.worm;

import java.util.HashSet;

public class SinaWebCrawler {
	
	static HashSet<String> URLset = new HashSet<String>();  //所有的网页url
	
	
	public SinaWebCrawler(){
		
		this.getMilitaryAffairsURLByList();
		this.getSportURL();
		this.getEconomicURL();
	}
	
	//爬取新浪军事数据
	public void getMilitaryAffairsURLByList(){
		
		//储存二级url
		HashSet<String> listURLSet = new HashSet<String>();
		//储存一级url
		HashSet<String> listGetURLSet = new HashSet<String>();
		
		String realURL = null;
		for(int i = 0;i < 5;i++){
			realURL = "http://roll.mil.news.sina.com.cn/col/zgjq/"+ "index_"+i+".shtml";
			
		}
	}
	
	//爬取新浪体育数据
	public void getSportURL(){
		
	}
	
	//爬取新浪财经数据
	public  void getEconomicURL(){
		
	}
	
}
