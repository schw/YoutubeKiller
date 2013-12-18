package com.rdc.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class VideoDataClass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String id;
	public String uri;
	public String thumbnail;
	public ArrayList<RelatedVideosClass> relatedVideos;
	
	public void setId(String id){
		this.id = id;
	}
	public void setUri(String uri){
		this.uri = uri;
	}
	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}
	
	public void setRelatedVideos(ArrayList<RelatedVideosClass> relatedVideos){
		this.relatedVideos = relatedVideos;
		
	}
	public String getId(){
		return this.id;
	}
	public String getUri(){
		return this.uri;
	}
	public String getThumbnail(){
		return this.thumbnail;
	}
	
	public ArrayList<RelatedVideosClass> getRelatedVideos(){
		return this.relatedVideos;
		
	}

}
