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

import com.esprit.project.entity.Post;
import com.esprit.project.service.IPostService;

@RestController
public class PostRestController {
	@Autowired
	IPostService postService;
    
	
	@GetMapping("/retrieve-all-posts")
	@ResponseBody
	public List<Post> getPosts() {
	List<Post> Posts = postService.retrieveAllPosts();
	return Posts;
	}
	
	@GetMapping("/retrieve-post/{post-id}")
	@ResponseBody
	public Optional<Post> retrievePost(@PathVariable("post-id") String idPost) {
	return postService.retrievePost(idPost);
	}
	
	@PostMapping("/add-post")
	@ResponseBody
	public Post addPost(@RequestBody Post p) {
	Post post = postService.addPost(p);
	return post;
	}
	@DeleteMapping("/remove-post/{post-id}")
	@ResponseBody
	public void removePost(@PathVariable("post-id") String id) {
	postService.deletePostById(id);
	}
	@PutMapping("/modify-post")
	@ResponseBody
	public Post modifyPost(@RequestBody Post post) {
	return postService.updatePost(post);
	}


}
