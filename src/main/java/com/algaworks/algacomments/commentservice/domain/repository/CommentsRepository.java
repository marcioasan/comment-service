package com.algaworks.algacomments.commentservice.domain.repository;

import com.algaworks.algacomments.commentservice.domain.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
