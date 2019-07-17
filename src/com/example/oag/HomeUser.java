package com.example.oag;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeUser extends Activity {
	TextView aaa;
	Button a,b,c;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_user);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		aaa=(TextView)findViewById(R.id.textView2);
		aaa.setText(globalvariabel.GetUsername().toString());
		a=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("ecil", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists reg(uid varchar,pass varchar,ema varchar,mob varchar);");
		a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(aaa.getText().toString().trim().length()==0)
	    		{
	    			showMessage("Error", "Please enter Rollno");
	    			return;
	    		}
	    		Cursor c=db.rawQuery("SELECT * FROM reg WHERE uid='"+aaa.getText()+"'", null);
	    		if(c.getCount()==0)
	    		{
	    			showMessage("Error", "No records found");
	    			return;
	    		}
	    		StringBuffer buffer=new StringBuffer();
	    		while(c.moveToNext())
	    		{
	    			buffer.append("User Id: "+c.getString(0)+"\n");
	    			buffer.append("Password: "+c.getString(1)+"\n");
	    			buffer.append("Email: "+c.getString(2)+"\n");
	    			buffer.append("Mobile No: "+c.getString(3)+"\n");

	    		}
	    		showMessage("User Profile", buffer.toString());	
			}
		});
		b=(Button)findViewById(R.id.button2);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Uvg.class));	
			}
		});
		
		c=(Button)findViewById(R.id.button3);
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(),Home.class));	
			}
		});
	}

	 public void showMessage(String title,String message)
	    {
	    	Builder builder=new Builder(this);
	    	builder.setCancelable(true);
	    	builder.setTitle(title);
	    	builder.setMessage(message);
	    	builder.show();
		}
	 @Override
	    public void onBackPressed() {
	    	// TODO Auto-generated method stub
	    	 Toast.makeText(getApplicationContext(), "Please press Logout to go to Login Page", Toast.LENGTH_LONG).show();
	    }

}
