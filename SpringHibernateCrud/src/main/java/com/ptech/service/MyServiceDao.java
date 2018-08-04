package com.ptech.service;



import java.util.List;

import com.ptech.pojo.StudentMaster;

public interface MyServiceDao<T> {

	public boolean saveStudentdata(StudentMaster s);
	public List<StudentMaster> getStudentDetails();
	public boolean saveDetails(T obj);

}
