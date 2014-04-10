package com.example.ui.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.horizontal);
		
		Button btnChooseImage=(Button)findViewById(R.id.buttonChooseImage);
		btnChooseImage.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent(MainActivity.this,HeadActivity.class);
				startActivityForResult(intent,100);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==100){
			Bundle bundle=data.getExtras();
			int imageId=bundle.getInt("imageId");
			ImageView iv=(ImageView)findViewById(R.id.imageView);
			iv.setImageResource(imageId);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
