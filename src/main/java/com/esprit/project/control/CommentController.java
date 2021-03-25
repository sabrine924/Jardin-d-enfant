/*package com.esprit.project.control;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Comment;
import com.esprit.project.entity.Event;
import com.esprit.project.entity.Parent;
import com.esprit.project.service.ICommentService;
import com.esprit.project.service.IEventService;
import com.esprit.project.service.IParentService;


@RestController
public class CommentController {
	@Autowired
	private ICommentService CommentService;
	@Autowired
	private IEventService eventService;
	@Autowired
	private IParentService parentService;
	
	
	
	public IEventService getEventService() {
		return eventService;
	}
	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}
	
	public IParentService getParentService() {
		return parentService;
	}
	public void setParentService(IParentService parentService) {
		this.parentService = parentService;
	}
	public ICommentService getCommentService() {
		return CommentService;
	}
	public void setCommentService(ICommentService commentService) {
		CommentService = commentService;
	}
	public CommentController(ICommentService commentService, IEventService eventService, IParentService parentService) {
		CommentService = commentService;
		this.eventService = eventService;
		this.parentService = parentService;
	}
	@PostMapping("/addComment")
	public String addComment(@Validated @ModelAttribute("comment") Comment comment, BindingResult result, Principal principal, Model model) {
		Event commentEvent = comment.getEvent();
		Event event = eventService.findEventById(commentEvent.getIdEvent());
		
		model.addAttribute("event", event);
		if (result.hasErrors()) {
			List<Comment> comments = CommentService.findCommentsByEvent(event.getIdEvent());
			model.addAttribute("comments", comments);
			return "eventDetailsView";
		} else {
			String email = principal.getName();
			Parent currentParent = parentService.findByEmail(email);
			
			comment.setComments(currentParent);
			CommentService.saveComment(comment);
			
			List<Comment> comments = CommentService.findCommentsByEvent(event.getIdEvent());
			model.addAttribute("comments", comments);
			return "eventDetailsView";
		}
	
	}
	}*/

