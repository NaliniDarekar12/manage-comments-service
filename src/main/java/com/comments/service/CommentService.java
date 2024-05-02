package com.comments.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.domain.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	public List<Comment> getCommentsByUsername(String username) {
		return commentRepository.findByUsername(username);
	}

	public List<Comment> getCommentsByDate(Date date) {
		return commentRepository.findByDate(date);
	}

	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public void deleteComment(Long id) {
		commentRepository.deleteById(id);

	}

	public Comment updateComment(Long id, Comment comment) {
		Comment existingComment = commentRepository.findById(id).orElseThrow();
		existingComment.setUsername(comment.getUsername());
		existingComment.setComment(comment.getComment());
		existingComment.setDate(comment.getDate());
		return commentRepository.save(existingComment);
	}

}
