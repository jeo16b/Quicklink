/**
 * 
 */
package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.models.Posts;
import com.project2.repository.PostRepository;

/**
 * @author bak12
 *
 */
@Service("employerService")
public class EmployerServiceImpl implements EmployerService
{
	@Autowired
	public PostRepository postRepo;
	
	@Override
	public boolean registerMyPost(Posts post)
	{
		return (postRepo.createPost(post));
	}

	@Override
	public boolean deleteMyPost(Posts post)
	{
		return postRepo.deletePost(post);
		
	}

	@Override
	public boolean updateMyPost(Posts post)
	{
		return postRepo.updatePost(post);
		
	}

	@Override
	public List<Posts> findAllMyPosts()
	{
		return postRepo.getAllPosts();
	}
	
	
}
