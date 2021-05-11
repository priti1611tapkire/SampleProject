package com.example.demo.srepository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface HomeRepositoryS extends CrudRepository<Student, Integer> {

	

	List<Student> findByDept_did(int did);

	
	
	
}
