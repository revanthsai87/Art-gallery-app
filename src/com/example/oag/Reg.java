package com.example.oag;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reg extends Activity {
	EditText uid,pas,em,mb;
	Button sub;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		uid=(EditText)findViewById(R.id.editText1);
		pas=(EditText)findViewById(R.id.editText2);
		em=(EditText)findViewById(R.id.editText3);
		mb=(EditText)findViewById(R.id.editText4);
		sub=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("ecil", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists reg(uid varchar,pass varchar,em varchar,mob varchar);");
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(uid.getText().toString().trim().length()==0||
						pas.getText().toString().trim().length()==0||
						em.getText().toString().trim().length()==0||
						mb.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "enter all the fields", Toast.LENGTH_SHORT).show();
					return;
				}
				else if(mb.getText().toString().trim().length()!=10)
				{
					Toast.makeText(getApplicationContext(), "enter 10digit Mobile No", Toast.LENGTH_SHORT).show();
					return;
				}
				db.execSQL("insert into reg values('"+uid.getText()+"','"+pas.getText()+"','"+em.getText()+"','"+mb.getText()+"');");
				Toast.makeText(getApplicationContext(), "Registration Done", Toast.LENGTH_SHORT).show();
				clr();
			}
		});
	}
public void clr()
{
	uid.setText("");
	pas.setText("");
	em.setText("");
	mb.setText("");
}
	

}
