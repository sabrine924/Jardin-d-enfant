package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.CommentPost;
import com.esprit.project.repository.CommentPostRepository;
@Service
public class CommentPostServiceImpl implements ICommentPostService {
	@Autowired
	CommentPostRepository commentPostRepository;
private static final Logger L = LogManager.getLogger(PostServiceImpl.class);
	

	@Override
	public CommentPost addCommentPost(CommentPost cp) {
		return commentPostRepository.save(cp);
	}

	@Override
	public void deleteCommentPostById(String idCommentPost) {
		commentPostRepository.deleteById(Long.parseLong(idCommentPost));
		
	}

	@Override
	public CommentPost updateCommentPost(CommentPost cp) {
		
		return commentPostRepository.save(cp);
	}

	@Override
	public List<CommentPost> retrieveAllCommentsPost() {
		List<CommentPost> commentsPost = (List<CommentPost>) commentPostRepository.findAll();
		for (CommentPost commentPost :  commentsPost){
			L.info("commentPost +++ : " + commentPost);
		}
		return   commentsPost ;
	}

	@Override
	public Optional<CommentPost> retrieveCommentPost(String idCommentPost) {
		Optional<CommentPost> cp = commentPostRepository.findById(Long.parseLong(idCommentPost));
		return  cp ;
		
	}
	
	

}
