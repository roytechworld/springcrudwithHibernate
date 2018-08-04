package com.ptech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ptech.dao.MyGenericDao;
import com.ptech.dao.StudentDao;
import com.ptech.pojo.StudentMaster;

/**
 * Software : PR Stock software
 * Developer : Pradipto Roy (Java developer)
 * @param <T>
 */
@Service
public class MyServiceDaoImpl<T> implements MyServiceDao<T> {

	@Autowired
	StudentDao st;
	
	@Autowired
	MyGenericDao<T> detailsobj;
	
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

	@Override
	public boolean saveDetails(T obj) {
		// TODO Auto-generated method stub
		return detailsobj.saveDetails(obj);
	}

}
