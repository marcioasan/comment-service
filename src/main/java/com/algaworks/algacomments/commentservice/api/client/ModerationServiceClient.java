package com.algaworks.algacomments.commentservice.api.client;

import com.algaworks.algacomments.commentservice.api.model.ModerationInput;
import com.algaworks.algacomments.commentservice.api.model.ModerationOutput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api")
public interface ModerationServiceClient {

    @PostExchange("/moderate")
    ModerationOutput moderateComment(@RequestBody ModerationInput moderationInput);
}
