package com.esprit.project.service;




import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.project.entity.Comment;
import com.esprit.project.entity.Parent;
import com.esprit.project.repository.CommentRepositroy;
import com.esprit.project.repository.ParentRepository;





@Service
public class CommentServiceImpl implements ICommentService {
	private static final Logger L = LogManager.getLogger(CommentServiceImpl.class);
	
	@Autowired 
	CommentRepositroy commentrepository;
	@Autowired 
	ParentRepository parentrepository;

	@Override
	public Comment saveComment(Comment c) {
		return commentrepository.save(c);
	}

	@Override
	public void deleteById(String id) {
		commentrepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public List<Comment> retrieveAllComments() {
		List<Comment> Comments = (List<Comment>) commentrepository.findAll();
		for (Comment  comment :   Comments){
			L.info("comment +++ : " + comment);
		}
		return   Comments ;
	}
	
	@Override
	public List<Comment> getCommentsByEventId(long idEvent) {
		return commentrepository.getCommentsByEventId(idEvent);
	}
	
	@Override
		public void parentCommentEvent(Long idComment,  Long id) {
			
	    	  
	    	if   
	    	    ( parentrepository.findById(id).isPresent())
	    	{
	    		 Comment commententity =   commentrepository.findById(idComment).get();
	    	 
	              Parent    parententity = parentrepository.findById(id).get();
	    	
	              parententity.getComments().add(commententity);
	              commentrepository.save(commententity);
	    	}
	    	 else 
	    		 System.out.println(" id is not exist ");
	    	
				
		}
}
     
	
	




	

