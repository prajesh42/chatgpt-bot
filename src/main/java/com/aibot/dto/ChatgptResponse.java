package com.aibot.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatgptResponse {

	private List<Choice> choices;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Choice {
       private int index;
       private Message message;
	}
}
