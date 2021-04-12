package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.project.entity.Comment;
import com.esprit.project.service.ICommentService;

//m
@RestController
public class CommentRestController {
	@Autowired
	ICommentService commentservice;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-comments
	@GetMapping("/retrieve-all-comments")
	@ResponseBody
	public List<Comment> getComments() {
	List<Comment> Comments = commentservice.retrieveAllComments();
	return Comments;
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/add-comment
	@PostMapping("/add-comment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment c ) {
	Comment comment = commentservice.saveComment(c);
	return comment;
	}

	//http://localhost:8081/SpringMVC/servlet/delete-comment/{comment-id}
		@DeleteMapping("/delete-comment/{comment-id}")
		@ResponseBody
		public void removeEvent(@PathVariable("comment-id") String id) {
			commentservice.deleteById(id);
}
		
		
		//http://localhost:8081/SpringMVC/servlet/Comment/comments-by-event/{idEvent}
		@GetMapping("/Comment/comments-by-event/{idEvent}")
		public List<Comment> getCommentsByPost(@PathVariable("idEvent") long idEvent) {
			return commentservice.getCommentsByEventId(idEvent);

		}
		
		//http://localhost:8081/SpringMVC/servlet/parents/{id}/comments/{idComment}
		@PostMapping( "/parents/{id}/comments/{idComment}")
		@ResponseBody
		public void   parentCommentEvent(
				@PathVariable("idComment") Long  idComment,
				@PathVariable("id") Long id)   {
			commentservice.parentCommentEvent(idComment, id);
			
			
		}

}
