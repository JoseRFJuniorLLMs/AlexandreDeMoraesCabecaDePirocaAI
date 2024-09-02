package com.thomasjayconsulting.sbai.controll;

import com.thomasjayconsulting.sbai.model.LLMRequest;
import com.thomasjayconsulting.sbai.model.LLMResponse;
import com.thomasjayconsulting.sbai.service.OllamaLLMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/llm")
public class LLMRestController {

    private OllamaLLMService ollamaLLMService;

    public LLMRestController(OllamaLLMService ollamaLLMService) {
        this.ollamaLLMService = ollamaLLMService;

    }

    @PostMapping("/chat")
    public ResponseEntity<LLMResponse> chat(@RequestBody LLMRequest llmRequest) {
        String chatResponse = ollamaLLMService.chat(llmRequest.getQuery());

        LLMResponse llmResponse = new LLMResponse("Success", chatResponse);

        return ResponseEntity.ok(llmResponse);

    }
}
