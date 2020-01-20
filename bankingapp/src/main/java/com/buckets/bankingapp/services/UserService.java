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
	public List<User> getAllUsers()
	{
		return repo.findAll();
	}
	
	//user specific
	public User getUser(Long id) 
	{
		Optional<User> found = UserRepo.findById(id);
		
		if(found.isPresent()) 
		{
			return found.get();
		}
		else 
		{
			return new User();
		}
	}
	
	//add user to list
	public void addUser(User user) 
	{
		boolean foundUser = false;
		repo.findAll().stream().anyMatch(c -> c.getId() == user.getId());
		if(!foundUser) 
		{
			repo.save(user);
		}
	}
	
	//update a user in the list
	public void updateUser(User user) 
	{
		Optional<User> optToUpdate = userRepo.findById(user.getId());
		
		if(optToUpdate.isPresent()) 
		{
			User toUpdate = optToUpdate.get();
			toUpdate.setFullName(user.getFullName());
			toUpdate.setPassword(user.getPassword());
			repo.save(toUpdate);
		}
	}
	
	//delete user list
	public void deleteUser(long id) 
	{
		repo.deleteById(id);
	}
}
