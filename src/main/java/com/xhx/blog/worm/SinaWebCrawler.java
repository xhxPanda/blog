package com.xhx.blog.worm;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.xhx.blog.domain.Artical;
import com.xhx.blog.domain.ArticalType;
import com.xhx.blog.service.artical.impl.ArticalServiceImpl;
import com.xhx.blog.service.articalType.impl.ArticcalTypeService;

public class SinaWebCrawler {
	
	private ArticalType  aType= null; 
	private Artical at = new Artical();
	
	ArticcalTypeService ata = new ArticcalTypeService();
	ArticalServiceImpl asi = new ArticalServiceImpl(); 
	
	
	public SinaWebCrawlerURL scURL = new SinaWebCrawlerURL();

	public void getMilitaryAffairs(){
		HashSet<String> MilitaryAffairsList = scURL.getMilitaryAffairsURLByList();
		
		aType = ata.getArticalTypeByName("军事");
		
		for(String s:MilitaryAffairsList){
			try {
				Document doc = Jsoup.connect(s).get();
				
				String titleElement = doc.select("h1#main_title").text();
				
				Elements contentElement = doc.select("div.content");
				
				contentElement.remove("div.ad_44086");
				contentElement.remove("div.ad");
								
				at.setContent(contentElement.toString());
				at.setTitle(titleElement);
				at.setType(aType);
				
				asi.save(at);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void getSports(){
		HashSet<String> sports = scURL.getSportsURL();
		
		aType = ata.getArticalTypeByName("体育");
		
		for(String s:sports){
			try {
				Document doc = Jsoup.connect(s).get();
				
				String titleElement = doc.select("h1#article-a__title").text();
				
				Elements contentElement = doc.select("div.article-a__content");
				
				contentElement.remove("link");
								
				at.setContent(contentElement.toString());
				at.setTitle(titleElement);
				at.setType(aType);
				
				asi.save(at);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
	public void getEconomic(){
		HashSet<String> economic = scURL.getEconomicURL();
		
		aType = ata.getArticalTypeByName("经济");
		
		for(String s:economic){
			try {
				Document doc = Jsoup.connect(s).get();
				
				String titleElement = doc.select("h1#artibodyTitle").text();
				
				Elements contentElement = doc.select("div.article article_16");
				
				contentElement.remove("div#ad_44099");
								
				at.setContent(contentElement.toString());
				at.setTitle(titleElement);
				at.setType(aType);
				
				asi.save(at);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
	public static void main(String args[]){
		
	}

}
