package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Post;
import com.esprit.project.repository.PostRepository;

@Service
public class PostServiceImpl implements IPostService{
	@Autowired
	PostRepository postRepository;
private static final Logger L = LogManager.getLogger(PostServiceImpl.class);
	

	@Override
	public Post addPost(Post p) {
		return postRepository.save(p);
	}

	@Override
	public void deletePostById(String idPost) {
		postRepository.deleteById(Long.parseLong(idPost));
		
	}

	@Override
	public Post updatePost(Post p) {
		
		return postRepository.save(p);
	}

	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> posts = (List<Post>) postRepository.findAll();
		for (Post post :  posts){
			L.info("post +++ : " + post);
		}
		return   posts ;
	}

	@Override
	public Optional<Post> retrievePost(String idPost) {
		Optional<Post> p = postRepository.findById(Long.parseLong(idPost));
		return  p ;
		
	}
	
	

}
