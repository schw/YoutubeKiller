package com.rdc.classes;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class VideoDataClass {
	
	public String id;
	public String uri;
	public Bitmap thumbnail;
	public String name;
	public ArrayList<RelatedVideosClass> relatedVideos;
	
	public void setId(String id){
		this.id = id;
	}
	public void setUri(String uri){
		this.uri = uri;
	}
	public void setThumbnail(Bitmap thumbnail){
		this.thumbnail = thumbnail;
	}
	public void setName(String name){
		this.name = name;
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
	public Bitmap getThumbnail(){
		return this.thumbnail;
	}
	public String getName(){
		return this.name;
	}
	public ArrayList<RelatedVideosClass> getRelatedVideos(){
		return this.relatedVideos;
		
	}

}
