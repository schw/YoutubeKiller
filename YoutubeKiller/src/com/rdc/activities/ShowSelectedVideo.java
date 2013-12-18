package com.rdc.activities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.rdc.classes.VideoDataClass;
import com.rdc.youtubekiller.R;

public class ShowSelectedVideo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_selected_video);
		
		Bundle bundle = getIntent().getExtras();
		VideoDataClass video = (VideoDataClass)bundle.get("objectVideo");
		//Pegando os texts view
		TextView idText = (TextView)findViewById(R.id.idVideo);
		TextView uriText = (TextView)findViewById(R.id.uriVideo);
		TextView thumbnailText = (TextView)findViewById(R.id.thumbnailVideo);
		//Setando os textos
		idText.setText(video.getId());
		uriText.setText(video.getUri());
		thumbnailText.setText(video.getThumbnail());
		Log.e("URI",video.getUri());
		/*Passa a uri e comeca a streaming do video*/
		startVideoStreaming(video.getUri());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_selected_video, menu);
		return true;
	}
	
	private void startVideoStreaming(String uri){
		VideoView myVideoView = (VideoView) findViewById(R.id.myvideoview);
		myVideoView.setVideoURI(Uri.parse(uri));
		myVideoView.setMediaController(new MediaController(this));
		myVideoView.requestFocus();
		myVideoView.start();
	}

}
