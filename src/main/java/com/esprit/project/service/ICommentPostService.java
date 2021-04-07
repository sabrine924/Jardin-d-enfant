package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.CommentPost;

public interface ICommentPostService {
	  CommentPost addCommentPost(CommentPost cp);
	  void deleteCommentPostById(String idCommentPost);
	  CommentPost updateCommentPost(CommentPost cp);
	  List<CommentPost> retrieveAllCommentsPost();
	  Optional<CommentPost> retrieveCommentPost(String idCommentPost);

}
