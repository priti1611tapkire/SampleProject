package com.example.demo.drepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;
import com.example.demo.model.Student;

@Repository
public interface HomeRepositoryD extends CrudRepository<Department, Integer>{
	Department findByDname(String dname);

}
