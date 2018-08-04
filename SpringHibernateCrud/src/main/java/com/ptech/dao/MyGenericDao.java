package com.ptech.dao;

public interface MyGenericDao<T> {
	
	public  boolean saveDetails(T obj);

}
