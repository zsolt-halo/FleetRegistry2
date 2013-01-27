package com.example.gson_servlet_sample;





import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			
			//Post k�r�s k�ld�se a szerverre (�j rekord beszur�sa)
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod("http://testerg.cloudfoundry.com/driver/");
			//Json objektum legy�rt�sa
			Gson gs = new Gson();
			Driver d = new Driver("Alexa", "M�����rk", "12843514");
			String par = gs.toJson(d);
			//Json string hozz�ad�sa a requesthez
			method.setQueryString("obj=" + URLEncoder.encode(par));
			//request elk�ld�se
			client.executeMethod(method);
			/////////////////////////////////////
			
			
			//Get k�r�s k�ld�se a szerverre (param�terezhet� is id-val    .../{id}    )
			HttpClient client1 = new HttpClient();
			GetMethod method1 = new GetMethod("http://testerg.cloudfoundry.com/driver/");
			//request elk�ld�se
			client1.executeMethod(method1);
			
			TextView t = (TextView)findViewById(R.id.textView1);
			t.setText(method1.getResponseBodyAsString());
			
			Log.d("asd",method1.getResponseBodyAsString());
			/////////////////////////////////////
			
			
			//Put k�r�s k�ld�se a szerverre(id parameteru rekordot frissiti)
			HttpClient client2 = new HttpClient();
			PutMethod method2 = new PutMethod("http://testerg.cloudfoundry.com/driver/");
			//Json objektum legy�rt�sa
			Gson gs2 = new Gson();
			Driver d2 = new Driver("1", "Kis", "Kacsa", "43");
			String par2 = gs.toJson(d2);
			//Json string hozz�ad�sa a requesthez
			method2.setQueryString("obj=" + URLEncoder.encode(par2));
			//request elk�ld�se
			client2.executeMethod(method2);
			/////////////////////////////////////
			
			
			//Delete k�r�s k�ld�se a szerverre (id parameteru rekordot t�rli)
			HttpClient client3 = new HttpClient();
			DeleteMethod method3 = new DeleteMethod("http://testerg.cloudfoundry.com/driver/7");
			//request elk�ld�se
			client3.executeMethod(method3);
			/////////////////////////////////////
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	

}
