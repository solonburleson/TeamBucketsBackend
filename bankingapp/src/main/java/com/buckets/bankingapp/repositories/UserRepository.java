package com.buckets.bankingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buckets.bankingapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
 