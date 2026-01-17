package com.algaworks.algacomments.commentservice.api.controller;


import com.algaworks.algacomments.commentservice.api.model.CommentInput;
import com.algaworks.algacomments.commentservice.api.model.CommentOutput;
import com.algaworks.algacomments.commentservice.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentServiceController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentOutput create(@RequestBody CommentInput input) {

        CommentOutput commentOutput = commentService.moderateComment(input);

        return commentOutput;
    }
}
