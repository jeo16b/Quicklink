/**
 * 
 */
package com.project2.service;

import java.util.List;

import com.project2.models.Posts;

/**
 * @author bak12
 *
 */
public interface EmployerService
{
	public boolean registerMyPost(Posts post);
	public void deleteMyPost(Posts post);
	public boolean updateMyPost(Posts post);
	public List<Posts> findAllMyPosts();
}
