package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.Comment;

@Service
public interface CommentService {

	public Comment saveComment(Comment c0mment);
	public List<Comment> getComment(String projectId);
}
