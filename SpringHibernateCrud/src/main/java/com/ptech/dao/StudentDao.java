package com.ptech.dao;

import java.util.List;

import com.ptech.pojo.StudentMaster;

public interface StudentDao {
	
	public boolean save(StudentMaster s);
	public List<StudentMaster> getAllDetails();

}
