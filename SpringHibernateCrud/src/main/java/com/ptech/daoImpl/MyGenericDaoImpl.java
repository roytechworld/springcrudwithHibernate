package com.ptech.daoImpl;



import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.ptech.dao.MyGenericDao;
@Service
@Repository
public class MyGenericDaoImpl<T> implements MyGenericDao<T> {

	private static final Logger log=LoggerFactory.getLogger(MyGenericDaoImpl.class);

	@Autowired
	SessionFactory session;
	
	@Transactional
	@Override
	public boolean saveDetails(T obj) {
		// TODO Auto-generated method stub
		
		return (Boolean) this.session.getCurrentSession().save(obj);
	}

}
