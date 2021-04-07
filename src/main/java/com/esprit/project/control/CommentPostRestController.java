package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.CommentPost;
import com.esprit.project.service.ICommentPostService;
@RestController
public class CommentPostRestController {
	@Autowired
	ICommentPostService commentPostService;
    
	
	@GetMapping("/retrieve-all-commentPosts")
	@ResponseBody
	public List<CommentPost> getCommentsPost() {
	List<CommentPost> commentsPost = commentPostService.retrieveAllCommentsPost();
	return commentsPost;
	}
	
	@GetMapping("/retrieve-commentPost/{commentPost-id}")
	@ResponseBody
	public Optional<CommentPost> retrieveCommentPost(@PathVariable("commentPost-id") String idCommentPost) {
	return commentPostService.retrieveCommentPost(idCommentPost);
	}
	
	@PostMapping("/add-commentPost")
	@ResponseBody
	public CommentPost addCommentPost(@RequestBody CommentPost cp) {
	CommentPost commentPost = commentPostService.addCommentPost(cp);
	return commentPost;
	}
	@DeleteMapping("/remove-commentPost/{commentPost-id}")
	@ResponseBody
	public void removeCommentPost(@PathVariable("commentPost") String id) {
	commentPostService.deleteCommentPostById(id);
	}
	@PutMapping("/modify-commentPost")
	@ResponseBody
	public CommentPost modifyCommentPost(@RequestBody CommentPost commentPost) {
	return commentPostService.updateCommentPost(commentPost);
	}


}
