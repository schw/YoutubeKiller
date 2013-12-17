package com.rdc.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.rdc.adapters.videosAdapter;
import com.rdc.classes.VideoDataClass;
import com.rdc.parsers.VideoDataParse;
import com.rdc.youtubekiller.R;
import com.rdc.youtubekiller.ShowSelectedVideo;

public class YoutubeKillerMainActivity extends Activity {

	private ArrayList<VideoDataClass> videos;
	private videosAdapter adapter;
	private ListView videoListView;
	private Context context = this;
	private Intent intent;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_killer_main);
        
        videoListView = (ListView)findViewById(R.id.videoListView);
        
        adapter = new videosAdapter(context);
         
        new XmlVideoParse().execute(); //chamada do parser
        
        videoListView.setOnItemClickListener(new OnItemClickListener(){ //Esse método é usado para pegar um item da lista que foi escolhido pelo usuário.
			
			public void onItemClick(AdapterView<?>parent, View view, int position, long id){
				//ListView Clicked item index
//				int itemPosition = position;
				
				//ListView Clicked item value
//				TechnicalSession objectSession = (TechnicalSession)techSessions.getItemAtPosition(itemPosition);
				
				intent = new Intent(context,ShowSelectedVideo.class);
				
		        startActivity(intent); 
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.youtube_killer_main, menu);
        return true;
    }
    
    public class XmlVideoParse extends AsyncTask<Void,Void,Void>{

		@Override
		//Faz o parser to arquivo xml e add em 'videos'
		protected Void doInBackground(Void... params) {
			try {
				videos = VideoDataParse.parse(context);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(Void result){
			
			adapter.setData(videos);
		    videoListView.setAdapter(adapter);
			//Teste para saber se o parser funcionou
			for(VideoDataClass item : videos){
				Log.e("Id: ", item.getId());
				Log.e("URI: ", item.getUri());
				Log.e("Name: ", item.getName());
				Log.e("Id2: ", item.getRelatedVideos().get(0).getId());
				Log.e("Id2: ", item.getRelatedVideos().get(1).getId());
				Log.e("Id2: ", item.getRelatedVideos().get(2).getId());
				Log.e("Id2: ", item.getRelatedVideos().get(3).getId());
				Log.e("Id2: ", item.getRelatedVideos().get(4).getId());
				Log.e("Id2: ", item.getRelatedVideos().get(5).getId());
				Log.e("Id2: ", item.getRelatedVideos().get(6).getId());
				
			}
		}

		
	}
    	
}
