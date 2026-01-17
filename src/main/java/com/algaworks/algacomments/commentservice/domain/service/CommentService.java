package com.algaworks.algacomments.commentservice.domain.service;

import com.algaworks.algacomments.commentservice.api.client.ModerationServiceClient;
import com.algaworks.algacomments.commentservice.api.model.CommentInput;
import com.algaworks.algacomments.commentservice.api.model.CommentOutput;
import com.algaworks.algacomments.commentservice.api.model.ModerationInput;
import com.algaworks.algacomments.commentservice.api.model.ModerationOutput;
import com.algaworks.algacomments.commentservice.domain.model.Comments;
import com.algaworks.algacomments.commentservice.domain.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentsRepository repository;

    @Autowired
    private ModerationServiceClient moderationServiceClient;

    public CommentOutput moderateComment(CommentInput input) {

        UUID commentIdUUID = UUID.randomUUID();
        Long commentId = commentIdUUID.getMostSignificantBits() & Long.MAX_VALUE;

        ModerationInput moderationInput = ModerationInput.builder()
                .commentId(commentIdUUID)
                .text(input.getText())
                .build();
        ModerationOutput moderationOutput = moderationServiceClient.moderateComment(moderationInput);

        if (moderationOutput.getApproved() != null && !moderationOutput.getApproved()) {
            return CommentOutput.builder()
                    .id(commentIdUUID)
                    .text(moderationOutput.getReason())
                    .author(input.getAuthor())
                    .createdAt(OffsetDateTime.now())
                    .build();
        } else {
            Comments comments = Comments.builder()
                    .id(commentId)
                    .text(input.getText())
                    .author(input.getAuthor())
                    .createdAt(OffsetDateTime.now())
                    .build();
            repository.save(comments);

            CommentOutput commentOutput = CommentOutput.builder()
                    .id(commentIdUUID)
                    .text(moderationOutput.getReason())
                    .author(input.getAuthor())
                    .createdAt(OffsetDateTime.now())
                    .build();

            return commentOutput;
        }
    }
}
