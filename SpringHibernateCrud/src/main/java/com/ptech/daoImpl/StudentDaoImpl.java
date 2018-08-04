package com.ptech.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Transactional
	@Override
	public List<StudentMaster> getAllDetails() {
		// TODO Auto-generated method stub
		
		List<StudentMaster> studentlist=new ArrayList<StudentMaster>();
		try
		{
		studentlist=this.sessionfactory.getCurrentSession().createQuery("from StudentMaster").list();

		}
		catch(Exception e)
		{
			logger.error("list retreive error occur : "+e);
		}
		
		return studentlist;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<StudentMaster> getAllDetails(Integer pageid,Integer total) {
		// TODO Auto-generated method stubh
		
		List<StudentMaster> studentlist=new ArrayList<StudentMaster>();
		Query tmp =null;
		try
		{
			
		 tmp = this.sessionfactory.getCurrentSession().createQuery("from StudentMaster");

	    if (pageid!= null)
	        tmp.setFirstResult(pageid);
	    if (total!= null)
	        tmp.setMaxResults(total);
		
	    studentlist=tmp.list();
			
		}
		catch(Exception e)
		{
			logger.error("list retreive error occur : "+e);
		}
		
		return studentlist;
	}
	

}
