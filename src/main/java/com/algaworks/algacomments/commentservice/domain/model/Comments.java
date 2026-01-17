package com.algaworks.algacomments.commentservice.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comments {

    @Id
    private Long id;
    private String text;
    private String author;
    private OffsetDateTime createdAt;

}
