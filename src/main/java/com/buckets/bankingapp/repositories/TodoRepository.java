package com.buckets.bankingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buckets.bankingapp.models.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
