package com.rdc.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rdc.classes.VideoDataClass;
import com.rdc.youtubekiller.R;

public class videosAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<VideoDataClass> arrayVideoData;
	private LayoutInflater inflater;
	private ViewGroup viewGroup= null;
	private View rowView = null;
	
	public videosAdapter(Context context){
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return arrayVideoData.size();
	}

	@Override
	public Object getItem(int position) {
		return arrayVideoData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		rowView = inflater.inflate(R.layout.layout_item_video_listview, viewGroup, false);
		ImageView image = (ImageView)rowView.findViewById(R.id.itemImageView);
		TextView text = (TextView)rowView.findViewById(R.id.itemTextView);
		
		text.setText(arrayVideoData.get(position).getUri());
		
		return rowView;
	}
	
	public void setData(ArrayList<VideoDataClass> arrayVideoData){
		this.arrayVideoData = arrayVideoData;
		notifyDataSetChanged(); //fazer um teste sem esse método.
	}

}
