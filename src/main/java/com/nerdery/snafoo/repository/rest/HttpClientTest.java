package com.nerdery.snafoo.repository.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClientTest {

	public static void main(String[] args) {
		URL url;
		try {
			// url = new URL("https://api-snacks.nerderylabs.com/v1/snacks/?ApiKey=3db4ceed-81f4-47dc-b34a-31ba6a0aef88");
			url = new URL("https://api-snacks.nerderylabs.com/v1/snacks?ApiKey=0eaeec59-fa32-420c-9cc4-e6b96633e211");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code = connection.getResponseCode();
			System.out.println("code: " + code);

			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			char[] buf = new char[10000];
			reader.read(buf);
			String s = new String(buf);
			System.out.println("returned: " + s);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
