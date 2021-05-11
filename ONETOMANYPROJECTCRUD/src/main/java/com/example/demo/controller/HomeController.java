package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.servicei.ServiceI;
@CrossOrigin("*")
@RequestMapping("/student")
@RestController
public class HomeController {

	@Autowired
	ServiceI si;
	//=========================================#REGISTER#==========================================
	@RequestMapping(value = "/register/{dname}", method =RequestMethod.POST )
	public String savedata(@RequestBody Student s,@PathVariable("dname")String dname) {
		si.savedata(s,dname);
		return "data inserted successfully";
	}
	
	@RequestMapping(value = "/regis", method =RequestMethod.POST )
	public String savedatabys(@RequestBody Student s) {
		si.savedatas(s);
		return "data inserted successfully";
	}

	@RequestMapping(value = "/reg", method =RequestMethod.POST )
	public String saveData(@RequestBody Department d) {
		System.out.println("depthh");
		si.saveData(d);
		return "data inserted successfully";
	}
	//=========================================#DATAGET#==========================================
	@RequestMapping(value = "/log/{sid}", method =RequestMethod.GET )
	public Student login(@PathVariable("sid")int id){
		
		Student s1=si.loginck(id);
		return s1;
	}
	
	@RequestMapping(value = "/login/{did}", method =RequestMethod.GET )
	public Department loginchk(@PathVariable("did")int did){
		
		Department d=si.logincheck(did);
		return d;
	}
	
	@RequestMapping(value = "/loginck", method =RequestMethod.GET )
	public List<Student> loginchkn(){
		
		List<Student> slist=si.logincheckn();
		return slist;
	}
	
	@GetMapping("/getallStudent/{dname}")
	public List<Student> sortbydept(@PathVariable("dname")String dname){
		return si.getAllStudentUnderPerticularDeprtment(dname);
	}
	
	
	@GetMapping("/getallStu")
	public List<Student> sortbydeptm(){
		return si.getAllStudentUnderPerticularDeprtments();
	}
	
	//=========================================#DATADELETE#==========================================
	@RequestMapping(value = "deletes/{sid}", method =RequestMethod.DELETE )
	public List<Student> deletestu(@PathVariable("sid")int sid){
		List<Student> slist=si.deletestu(sid);
		return slist;
	}
	
	@RequestMapping(value = "deleted/{did}", method =RequestMethod.DELETE )
	public List<Department> deletedept(@PathVariable("did")int did){
		List<Department> dlist=si.deletedept(did);
		return dlist;	
	}
	
	//=========================================#DATAEDIT-UPDATE#==========================================
	@RequestMapping(value = "/editstu/{sid}",method=RequestMethod.GET)
		public  Student editstu(@PathVariable("sid") int sid){
		Student s1=si.editstu(sid);
		return s1;
	}
	
	@RequestMapping(value = "/updatestu",method =RequestMethod.PATCH )
	public List<Student> updatestu(@RequestBody Student s){
		List<Student> list=si.updatestu(s);
		return list;
	}
	

	@RequestMapping(value = "/editdept/{did}",method=RequestMethod.GET)
		public  Department editdept(@PathVariable("did") int did){
		Department d1=si.editdept(did);
		return d1;
	}
	
	@RequestMapping(value = "/updatedept",method =RequestMethod.PATCH )
	public List<Department> updatedata(@RequestBody Department d){
		List<Department> dlist=si.updatedept(d);
		return dlist;
	}
	
	
	
}
