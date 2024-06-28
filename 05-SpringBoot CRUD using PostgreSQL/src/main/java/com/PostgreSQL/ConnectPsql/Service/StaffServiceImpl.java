package com.PostgreSQL.ConnectPsql.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.PostgreSQL.ConnectPsql.Entity.staffs;
import com.PostgreSQL.ConnectPsql.repo.StaffRepo;

@Service
public class StaffServiceImpl implements StaffService{


	private StaffRepo staffRepo;
	
	public  StaffServiceImpl(StaffRepo theStaffRepo) {
		staffRepo=theStaffRepo;
	}
	
	@Override
	public staffs save(staffs thestaffs) {
		
		return staffRepo.save(thestaffs);
	}

	@Override
	public staffs findById(int theid) {

		Optional<staffs> value=staffRepo.findById(theid);
		staffs dbstaffs=null;
		if(value.isPresent()) {
			dbstaffs=value.get();
		}
		else {
			throw new RuntimeException("Did not have in database - "+theid);
		}
		return dbstaffs;
	}

	

	@Override
	public void deleteById(int theid) {
		
		staffRepo.deleteById(theid);
		
	}

	@Override
	public List<staffs> findAll() {
		return staffRepo.findAll();
	}
	
	

}
