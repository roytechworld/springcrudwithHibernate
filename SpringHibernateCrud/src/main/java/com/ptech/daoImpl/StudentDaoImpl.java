package com.ptech.daoImpl;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ptech.dao.StudentDao;
import com.ptech.pojo.StudentMaster;

@Service
@Repository
public class StudentDaoImpl implements StudentDao{
	private static Log logger=LogFactory.getLog(StudentDaoImpl.class);

	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Transactional
	@Override
	public boolean save(StudentMaster s) {
		// TODO Auto-generated method stub
		boolean result=false;
		try
		{
			this.sessionfactory.getCurrentSession().save(s);
			result=true;
			
		}
		catch(Exception e)
		{
			logger.info("Exception occur "+e);
		}
		
		
		
		
		return result;
	}
	

}
