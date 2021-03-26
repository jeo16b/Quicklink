package com.project2.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project2.models.Posts;

@Repository("postRepo")
@Transactional
public class PostRepositoryImpl implements PostRepository
{
	private Logger log =  Logger.getLogger(PostRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createPost(Posts post)
	{ 
		if(sessionFactory.getCurrentSession().save(post) != null)
		{
			log.trace("Post Created");
			return true;
		}
		log.error("Error making post");
		return false;
	}

	@Override
	public void deletePost(Posts post)
	{	
		sessionFactory.getCurrentSession().delete(post);
		log.trace("Post Deleted");
	}

	@Override
	public boolean updatePost(Posts post)
	{
		try
		{
			sessionFactory.getCurrentSession().update(post);
		}
		catch(EntityNotFoundException e)
		{
			log.error("Post not found!");
			log.error(e.getMessage());
			return false;
		}
		
		log.trace("Post Updated!");
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Posts> getAllPosts()
	{ 
		log.trace("Finding all posts");
		List<Posts> posts = sessionFactory.openSession().createQuery("from POSTS").list();
		
		if(!posts.isEmpty())
		{
			log.trace("Posts found");
			return posts;
		}
		
		log.error("No posts found");
		return null;
	}

}
