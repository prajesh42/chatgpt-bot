package com.aibot.dto;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ChatgptRequest {

	private String model;
	private List<Message> messages;

	public ChatgptRequest(String model, String prompt) {
		this.model = model;
		this.messages = Arrays.asList(new Message("user", prompt));
	}

}
