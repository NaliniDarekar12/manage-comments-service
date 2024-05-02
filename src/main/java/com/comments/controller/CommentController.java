package com.comments.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comments.domain.Comment;
import com.comments.service.CommentService;

@RestController
@RequestMapping(value = "/api/v2/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping("comments")
	public ResponseEntity<List<Comment>> getAllComments() {
		List<Comment> commentList = commentService.getAllComments();
		return ResponseEntity.ok(commentList);
	}

	@GetMapping("comments/search/username/{username}")
	public ResponseEntity<List<Comment>> getCommentsByUsername(@PathVariable String username) {
		List<Comment> byUsername = commentService.getCommentsByUsername(username);
		return ResponseEntity.ok(byUsername);
	}

	@GetMapping("comments/search/date/{date}")
	public ResponseEntity<List<Comment>> getCommentsByDate(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Comment> byDate = commentService.getCommentsByDate(date);
		return ResponseEntity.ok(byDate);
	}

	@PostMapping("addcomments")
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
		Comment addComment = commentService.createComment(comment);
		return ResponseEntity.ok(addComment);

	}

	@PutMapping("comments/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
		Comment updateComment = commentService.updateComment(id, comment);
		return ResponseEntity.ok(updateComment);

	}

	@DeleteMapping("comments/{id}")
	public void deleteComment(@PathVariable Long id) {
		commentService.deleteComment(id);
	}
}
