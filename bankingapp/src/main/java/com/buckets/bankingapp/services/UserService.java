package com.buckets.bankingapp.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserService implements UserRespository
{
	@Autowired
	UserRepository userRepo;
	
	//return all users
	public List<User> lisAllUsers()
	{
		return null;
	}
	
	//user specific
	public List<User> listUsers(String user)
	{
		try
		{
			List<User> users = userRepo.getList();
			return users;
		} catch(SQLException e) {}
		return null;
	}
	
	public User getUser(int userId) 
	{
		try 
		{
			List<User> users = userRepo.getList();
			for(User user:users) 
			{
				if(user.getId()==userId) 
				{
					return user;
				}
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//add user to list
	public User createUser(String userName, String password, String fullName, String role)
	{
		try 
		{
			User user = userRepo.insertUser(1,userName, password, fullName, role);
			return user;
		} 
		catch(SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User edit2User(User user) 
	{
		try 
		{
			userRepo.getUser(user.getId());
			userRepo.editUser(user);
			return user;
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//update a user in the list
	public User updateUser(User user)
	{
		try 
		{
			List<User> users = userRepo.getList();
			if(users.contains(user)) 
			{
				for(User userTemp:users) 
				{
					if(userTemp.getId()==user.getId()) 
					{
						userTemp.setUserName(user.getUserName());
						userTemp.setPassword(user.getPassword());
						userTemp.setFullName(user.getFullName());
						userTemp.setRole(user.getRole());
					}
				}
			}
			return user;
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//delete user list
	public User deleteUser(int userId)
	{
		try 
		{
			userRepo.deleteUser(userId);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
