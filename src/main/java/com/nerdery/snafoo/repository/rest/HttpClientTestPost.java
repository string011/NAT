package com.nerdery.snafoo.repository.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nerdery.snafoo.model.domain.rest.SuggestionRESTModel;

public class HttpClientTestPost {

	public static void main(String[] args) {
		URI url;
		try {
			// url = new
			// URL("https://api-snacks.nerderylabs.com/v1/snacks/?ApiKey=3db4ceed-81f4-47dc-b34a-31ba6a0aef88");
			RestTemplate rt = new RestTemplate();
			url = new URI("https://api-snacks.nerderylabs.com/v1/snacks?ApiKey=0eaeec59-fa32-420c-9cc4-e6b96633e211");
			SuggestionRESTModel spm = new SuggestionRESTModel();
			spm.setName("Sushi");
			spm.setLocation("A sush place.");
			// rt.postForObject(url, spm, SuggestionRESTModel.class);
			ResponseEntity<SuggestionRESTModel> response = rt.postForEntity(url, spm, SuggestionRESTModel.class);
			HttpStatus status = response.getStatusCode();
			status.toString();

		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public class SuggestionSerializer extends JsonSerializer<Suggestion> {
	 * 
	 * @Override public void serialize(Suggestion value, JsonGenerator jgen,
	 * SerializerProvider provider) throws IOException, JsonProcessingException
	 * { jgen.writeStartObject(); jgen.writeObjectField("name", value.name);
	 * jgen.writeObjectField("location", value.location); jgen.writeEndObject();
	 * } }
	 */

}
