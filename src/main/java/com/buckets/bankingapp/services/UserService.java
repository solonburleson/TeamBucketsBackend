package com.buckets.bankingapp.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.buckets.bankingapp.models.Todo;
import com.buckets.bankingapp.models.User;
import com.buckets.bankingapp.repositories.UserRepository;

@Service
@Primary
public class UserService{
	
	@Autowired
	UserRepository userRepo;
	
	//return all users
	public List<User> lisAllUsers()
	{
		return userRepo.findAll();
	}
	
	
	public User getUser(Long userId) 
	{
		Optional<User> tempTodo = userRepo.findById(userId);
		
		if(tempTodo.isPresent())
			return tempTodo.get();
		
		else
			return new User();
			
		
	}
	
	//add user to list
	public User createUser(User user)
	{
		return userRepo.save(user);
		
	}
	
//	public User edit2User(User user) 
//	{
//		try 
//		{
//			userRepo.getUser(user.getId());
//			userRepo.editUser(user);
//			return user;
//		}
//		catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	//update a user in the list
//	public User updateUser(User user)
//	{
//		try 
//		{
//			List<User> users = userRepo.getList();
//			if(users.contains(user)) 
//			{
//				for(User userTemp:users) 
//				{
//					if(userTemp.getId()==user.getId()) 
//					{
//						userTemp.setUserName(user.getUserName());
//						userTemp.setPassword(user.getPassword());
//						userTemp.setFullName(user.getFullName());
//						userTemp.setRole(user.getRole());
//					}
//				}
//			}
//			return user;
//			
//		} 
//		catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	//delete user list
//	public User deleteUser(int userId)
//	{
//		try 
//		{
//			userRepo.deleteUser(userId);
//		} 
//		catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
