package com.aibot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aibot.service.ChatgptBotService;

@RestController
@RequestMapping("/bot")
public class ChatgptBotController {

	private ChatgptBotService chatgptBotService;
	
	@Autowired
	public void init(ChatgptBotService chatgptBotService) {
		this.chatgptBotService= chatgptBotService;
	}
	
	@GetMapping("/chat")
	public String getGeneratedText(@RequestParam("prompt") String prompt) {
		return chatgptBotService.getPrompt(prompt);
	}
}
