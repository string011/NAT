package com.nerdery.snafoo.repository.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class HttpClientTestPost {

	public static void main(String[] args) {
		URI url;
		try {
			// url = new
			// URL("https://api-snacks.nerderylabs.com/v1/snacks/?ApiKey=3db4ceed-81f4-47dc-b34a-31ba6a0aef88");
			RestTemplate rt = new RestTemplate();
			url = new URI("https://api-snacks.nerderylabs.com/v1/snacks?ApiKey=0eaeec59-fa32-420c-9cc4-e6b96633e211");
			URI ret = rt.postForLocation(url, new HttpClientTestPost().new Suggestion());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@JsonSerialize
	private class Suggestion {

		private String name = "snaussage";
		private String location = "petco";

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
	}

	public class SuggestionSerializer extends JsonSerializer<Suggestion> {

		@Override
		public void serialize(Suggestion value, JsonGenerator jgen, SerializerProvider provider)
				throws IOException, JsonProcessingException {
			jgen.writeStartObject();
			jgen.writeObjectField("name", value.name);
			jgen.writeObjectField("location", value.location);
			jgen.writeEndObject();
		}
	}

}
