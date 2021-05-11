package com.example.demo.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.drepository.HomeRepositoryD;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.servicei.ServiceI;
import com.example.demo.srepository.HomeRepositoryS;

@Service
public class ServiceImpl implements ServiceI{
	@Autowired
	HomeRepositoryS hs;
	@Autowired
	HomeRepositoryD hd;
	//=========================================#REGISTER-DATA#==========================================
	@Override
	public
	void savedata(Student s, String dname) {
		// TODO Auto-generated method stub
		
		Department d  =hd.findByDname(dname);
		  s.setDept(d);
		  hs.save(s);
		  
	}

	@Override
	public void saveData(Department d) {
		// TODO Auto-generated method stub
		hd.save(d);
	}

	//=========================================#GET-DATA#==========================================
	@Override
	public Student loginck(int id) {
		// TODO Auto-generated method stu
		Student s =hs.findById(id).get();
		return s;
	}

	@Override
	public Department logincheck(int did) {
		// TODO Auto-generated method stub
		Department d=hd.findById(did).get();
		return d;
	}
	
	
	//=========================================#DELETE-DATA#==========================================
	@Override
	public List<Student> deletestu(int sid) {
		// TODO Auto-generated method stub
		hs.deleteById(sid);
		List<Student> slist=(List<Student>) hs.findAll();
		return slist;
	}

	@Override
	public List<Department> deletedept(int did) {
		// TODO Auto-generated method stub
		hd.deleteById(did);
		return (List<Department>) hd.findAll();
	}
	

	@Override
	public List<Student> getAllStudentUnderPerticularDeprtment(String dname) {
		 Department d=hd.findByDname(dname);
		 List<Student> elist=hs.findByDept_did(d.getDid());
		return elist;
	}

	//=========================================#EDIT-DATA/UPDATE#==========================================
	@Override
	public Student editstu(int sid) {
		// TODO Auto-generated method stub
		Student s1=hs.findById(sid).get();
		return s1;
	}

	@Override
	public List<Student> updatestu(Student s) {
		// TODO Auto-generated method stub
		hs.save(s);
		List<Student> slist=(List<Student>) hs.findAll();
		return slist;
	}

	@Override
	public Department editdept(int did) {
		// TODO Auto-generated method stub
		Department d1=hd.findById(did).get();
		return d1;
	}

	@Override
	public List<Department> updatedept(Department d) {
		// TODO Auto-generated method stub
		hd.save(d);
		List<Department> dlist=(List<Department>) hd.findAll();
		return dlist;
	}

	@Override
	public void savedatas(Student s) {
		// TODO Auto-generated method stub
		hs.save(s);
	}

	@Override
	public List<Student> logincheckn() {
		// TODO Auto-generated method stub
		
		return (List<Student>) hs.findAll();
	}

	@Override
	public List<Student> getAllStudentUnderPerticularDeprtments() {
		// TODO Auto-generated method stub
		return (List<Student>) hs.findAll();
	}

}
