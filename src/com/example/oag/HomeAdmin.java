package com.example.oag;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeAdmin extends Activity {
	Button a,b,c,d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_admin);
		a=(Button)findViewById(R.id.button1);
		a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Agalleryadd.class));	
			}
		});
		b=(Button)findViewById(R.id.button2);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Agaleryview.class));	
			}
		});
		
		c=(Button)findViewById(R.id.button3);
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Auserview.class));	
			}
		});
		
		d=(Button)findViewById(R.id.button4);
		d.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Home.class));	
			}
		});
	}
	 @Override
	    public void onBackPressed() {
	    	// TODO Auto-generated method stub
	    	 Toast.makeText(getApplicationContext(), "Please press Logout to go to Login Page", Toast.LENGTH_LONG).show();
	    }

}
