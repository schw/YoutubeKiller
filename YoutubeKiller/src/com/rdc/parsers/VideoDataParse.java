package com.rdc.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.rdc.classes.VideoDataClass;

public class VideoDataParse {
	
	private static InputStream is;
	private static ArrayList<VideoDataClass> arrayVideosDataClass;
	private static VideoDataClass videoData;
	
	public static ArrayList<VideoDataClass> parse(Context context, String xmlFileName) throws IOException, SAXException {
	       
        final RootElement root = new RootElement("colecao"); //mudar isso aqui
        
        arrayVideosDataClass = new ArrayList<VideoDataClass>();
        
        is = context.getResources().getAssets().open(xmlFileName);
        
        //Acessa os atributos do item atual 
        root.setStartElementListener(new StartElementListener() {				
			
			public void start(Attributes attrb) {
				
			
		}});
        
        //pega referência de um item 
        Element video = root.getChild("video");
        
        video.setStartElementListener(new StartElementListener() {
			
			
			public void start(Attributes attr) {
				//nova instancia do objeto para armazar as informações de 'video data'
				videoData = new VideoDataClass();

			}
		});
        //acessa o valor de cada tag, nesse caso, 'id'
        video.getChild("id").setEndTextElementListener(new EndTextElementListener(){
            public void end(String id) {
                videoData.setId(id);
            }
        });
        video.getChild("uri").setEndTextElementListener(new EndTextElementListener(){
            public void end(String uri) {
            	videoData.setUri(uri);
            }
        });
        
        video.getChild("thumbnail").setEndTextElementListener(new EndTextElementListener(){ //verificar isso aqui...
            public void end(String thumbnail) {
            	videoData.setThumbnail(thumbnail);
            }

        });
        
        video.setEndElementListener(new EndElementListener() {
			
			
			public void end() {
				
				arrayVideosDataClass.add(videoData);
			}
		});

        
        Xml.parse(is, Xml.Encoding.UTF_8, root.getContentHandler());
        
        return  arrayVideosDataClass;
    }

}
