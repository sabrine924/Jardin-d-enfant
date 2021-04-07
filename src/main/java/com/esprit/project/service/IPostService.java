package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Post;

public interface IPostService {
	  Post addPost(Post p);
	  void deletePostById(String idPost);
	  Post updatePost(Post p);
	  List<Post> retrieveAllPosts();
	  Optional<Post> retrievePost(String idPost);

}
