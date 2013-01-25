import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;

public class ApacheHttpClientGet {

	public static void main(String[] args) {
		try {
			HttpClient client = new HttpClient();
			GetMethod method = new GetMethod("http://testerg.cloudfoundry.com/driver/");
			/*
			Gson gs = new Gson();
			Driver d = new Driver("Alexa", "Mçrk", "12843514");
			String par = gs.toJson(d);*/
			int statusCode = client.executeMethod(method);
			System.out.println(method.getResponseBodyAsString());


		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}