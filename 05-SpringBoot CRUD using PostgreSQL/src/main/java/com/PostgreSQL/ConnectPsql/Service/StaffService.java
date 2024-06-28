package com.PostgreSQL.ConnectPsql.Service;

import java.util.List;

import com.PostgreSQL.ConnectPsql.Entity.staffs;

public interface StaffService {

	staffs save(staffs thestaffs);
	
	staffs findById(int theid);
	
	List<staffs> findAll();
	
	void deleteById(int theid);
	
}
