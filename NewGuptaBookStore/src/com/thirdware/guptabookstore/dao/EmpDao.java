package com.thirdware.guptabookstore.dao;

import com.thirdware.guptabookstore.models.Emp;

public interface EmpDao {
	
	public Emp empRegister(Emp emp);
	public  Emp empLogin(String email);
}
