package com.algaworks.algacomments.commentservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModerationOutput {
    private Boolean approved;
    private String reason;
}
