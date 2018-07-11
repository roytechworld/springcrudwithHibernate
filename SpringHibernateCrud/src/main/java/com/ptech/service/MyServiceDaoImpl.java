package com.ptech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ptech.dao.StudentDao;
import com.ptech.pojo.StudentMaster;

/**
 * Software : PR Stock software
 * Developer : Pradipto Roy (Java developer)
 */
@Service
@Repository
public class MyServiceDaoImpl implements MyServiceDao {
	@Autowired
	public StudentDao studentobj;
	
	@Override
	public boolean saveStudentdata(StudentMaster s) {
		// TODO Auto-generated method stub
		return studentobj.save(s);
	}

}