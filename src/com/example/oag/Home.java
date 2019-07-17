package com.example.oag;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Home extends Activity {
	Button ur,log;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ur=(Button)findViewById(R.id.button1);
		ur.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Reg.class));
			}
		});
		log=(Button)findViewById(R.id.button2);
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Login.class));
			}
		});
		
		
		
	}

	 @Override
	    public void onBackPressed() {
	    	// TODO Auto-generated method stub
	    	 Toast.makeText(getApplicationContext(), "Your Cant Perform This Action", Toast.LENGTH_LONG).show();
	    }


}
