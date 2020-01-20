package com.buckets.bankingapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5174046345078611300L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "id", targetEntity = Todo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set <Todo> todoSet = new HashSet<Todo>();
	
	public User() {
		super();
	}

	public Set<Todo> getTodos(){
		return todoSet;
	}

	public User(Long id, String username, String password, Set<Todo> todoSet) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.todoSet = todoSet;
	}


	public Long getUser_id() {
		return id;
	}

	public void setUser_id(Long user_id) {
		this.id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", todoSet=" + todoSet + "]";
	}

	

}
