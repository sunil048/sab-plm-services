package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, String> {

	public List<Comment> findByProject(String project);
}
