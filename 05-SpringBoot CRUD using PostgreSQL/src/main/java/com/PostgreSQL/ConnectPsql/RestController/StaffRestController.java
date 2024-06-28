package com.PostgreSQL.ConnectPsql.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.PostgreSQL.ConnectPsql.Entity.staffs;
import com.PostgreSQL.ConnectPsql.Service.StaffService;

@RestController
@RequestMapping("/call")
public class StaffRestController {

	private StaffService staffService;

	public StaffRestController(StaffService theStaffService) {
		staffService=theStaffService;
	}
	
	@PostMapping("/addStaffs")
	public staffs add(@RequestBody staffs theStaffs ) {
		
		theStaffs.setId(0);
		staffs dbStaffs=staffService.save(theStaffs);
		return dbStaffs;
	}
	
	@GetMapping("/getStaffs/{staffId}")
	public staffs getStaffs(@PathVariable int staffId) {
		
		staffs dbStaffs=staffService.findById(staffId);
		return dbStaffs;
	}
	
	@DeleteMapping("/delete/{staffId}")
	public String deletestaff(@PathVariable int staffId) {
		
		staffs theStaffs=staffService.findById(staffId);
		if(theStaffs==null) {
			throw new RuntimeException("Didn't the Staff id - "+staffId);
		}
		staffService.deleteById(staffId);
		return "Deleted id = "+staffId;
	}
	
	@GetMapping("/staffs")
	public List<staffs> findAll(){
		return staffService.findAll();
	}
	
	@PutMapping("/change")
	public staffs putStaffs(@RequestBody staffs theStaffs) {
		
		int id=theStaffs.getId();
		staffService.findById(id);
		
		staffs dbStaffs=staffService.save(theStaffs);
		return dbStaffs;
		
	}
}
