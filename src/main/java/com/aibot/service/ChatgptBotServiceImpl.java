package com.aibot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aibot.dto.ChatgptRequest;
import com.aibot.dto.ChatgptResponse;

@Service
public class ChatgptBotServiceImpl implements ChatgptBotService {

	@Value("${openai.model}")
	private String openAiModel;
	
	@Value("${openai.url}")
	private String openAiUrl;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public void init(RestTemplate restTemplate) {
		this.restTemplate= restTemplate;
	}
	
	@Override
	public String getPrompt(String prompt) {
		ChatgptRequest chatgptRequest=new ChatgptRequest(openAiModel, prompt);
		ChatgptResponse response = restTemplate.postForObject(openAiUrl,chatgptRequest, ChatgptResponse.class);
		return response.getChoices().get(0).getMessage().getContent();
	}

}
