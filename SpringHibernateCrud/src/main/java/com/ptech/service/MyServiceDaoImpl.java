package com.ptech.service;

import java.util.List;

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
public class MyServiceDaoImpl implements MyServiceDao {

	@Autowired
	StudentDao st;
	
	@Override
	public boolean saveStudentdata(StudentMaster s) {
		// TODO Auto-generated method stub
		return st.save(s);
	}

	@Override
	public List<StudentMaster> getStudentDetails() {
		// TODO Auto-generated method stub
		return st.getAllDetails();
	}

}
