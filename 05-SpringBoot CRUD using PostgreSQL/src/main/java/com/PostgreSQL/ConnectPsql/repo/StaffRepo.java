package com.PostgreSQL.ConnectPsql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PostgreSQL.ConnectPsql.Entity.staffs;

public interface StaffRepo extends JpaRepository<staffs, Integer>{
	
	//....

}
