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
		setContentView(R.layout.head);								//设置该Activity使用的布局
		GridView gridView = (GridView)findViewById(R.id.gridView);	//获取GridView组件
		BaseAdapter adapter = new BaseAdapter(){
			public View getView(int position,View convertView,ViewGroup parent){
				ImageView imageview;								//声明ImageView的对象
				if(convertView==null){
					imageview = new ImageView(HeadActivity.this);	//实例化ImageView的对象
					/*
					 * 设置图像的高度和宽度
					 */
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(158);
					imageview.setMaxHeight(150);
					/************************************/
					imageview.setPadding(5,5,5,5);					//设置ImageView的内边框					
				}
				else{
					imageview=(ImageView)convertView;
				}
				imageview.setImageResource(imageId[position]);		//为ImageView设置要显示的图片
				return imageview;									//返回ImageView
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
				Intent intent=getIntent();			//获取intent对象
				Bundle bundle=new Bundle();			//实例化传递的数据包
				bundle.putInt("imageId", imageId[position]);
				intent.putExtras(bundle);			//显示选中的图片
				setResult(100,intent);				//设置返回的结果码，并返回调用
				finish();							//关闭当前Activity
			}
		});
	}

}
