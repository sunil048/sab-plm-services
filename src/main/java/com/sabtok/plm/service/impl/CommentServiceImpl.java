package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabtok.plm.dao.CommentDao;
import com.sabtok.plm.entity.Comment;
import com.sabtok.plm.service.CommentService;

@Component
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;
	
	@Override
	public Comment saveComment(Comment comment) {
		return commentDao.save(comment);
	}

	@Override
	public List<Comment> getComment(String projectId) {
		return commentDao.findByProject(projectId);
	}

}
