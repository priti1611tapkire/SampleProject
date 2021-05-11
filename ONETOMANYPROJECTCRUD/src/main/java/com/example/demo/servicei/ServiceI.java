package com.example.demo.servicei;

import java.util.List;

import com.example.demo.model.Department;
import com.example.demo.model.Student;

public interface ServiceI {

	void saveData(Department d);

	Student loginck(int id);

	Department logincheck(int did);

	List<Student> deletestu(int sid);

	List<Department> deletedept(int did);

	Student editstu(int sid);

	List<Student> updatestu(Student s);

	Department editdept(int did);

	List<Department> updatedept(Department d);

	List<Student> getAllStudentUnderPerticularDeprtment(String dname);

	void savedata(Student s, String dname);

	void savedatas(Student s);

	List<Student> logincheckn();

	List<Student> getAllStudentUnderPerticularDeprtments();


	


}
