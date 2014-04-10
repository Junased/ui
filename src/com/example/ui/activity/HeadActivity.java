package com.example.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.ViewGroup;

public class HeadActivity extends Activity {
	
	public int[] imageId = new int[]{
			R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,
			R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.head);								//���ø�Activityʹ�õĲ���
		GridView gridView = (GridView)findViewById(R.id.gridView);	//��ȡGridView���
		BaseAdapter adapter = new BaseAdapter(){
			public View getView(int position,View convertView,ViewGroup parent){
				ImageView imageview;								//����ImageView�Ķ���
				if(convertView==null){
					imageview = new ImageView(HeadActivity.this);	//ʵ����ImageView�Ķ���
					/*
					 * ����ͼ��ĸ߶ȺͿ��
					 */
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(158);
					imageview.setMaxHeight(150);
					/************************************/
					imageview.setPadding(5,5,5,5);					//����ImageView���ڱ߿�					
				}
				else{
					imageview=(ImageView)convertView;
				}
				imageview.setImageResource(imageId[position]);		//ΪImageView����Ҫ��ʾ��ͼƬ
				return imageview;									//����ImageView
			}
			
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageId.length;
			}
		};
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view,int position,long id){
				Intent intent=getIntent();			//��ȡintent����
				Bundle bundle=new Bundle();			//ʵ�������ݵ����ݰ�
				bundle.putInt("imageId", imageId[position]);
				intent.putExtras(bundle);			//��ʾѡ�е�ͼƬ
				setResult(100,intent);				//���÷��صĽ���룬�����ص���
				finish();							//�رյ�ǰActivity
			}
		});
	}

}
