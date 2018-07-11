package com.ptech.service;

import org.springframework.beans.factory.annotation.Autowired;


import com.ptech.pojo.StudentMaster;

public interface MyServiceDao {

	public boolean saveStudentdata(StudentMaster s);

}
