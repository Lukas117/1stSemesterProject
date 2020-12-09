package Model;

import java.util.*;

public class DepartmentContainer {
	private ArrayList<Department> departmentList = new ArrayList<> ();
	private static DepartmentContainer instance;
	
	
	public ArrayList<Department> getDepartmentList() {
		return departmentList;
	}
	
	public static DepartmentContainer getInstance() {
		if(instance == null) {
            instance = new DepartmentContainer();
        }

        return instance;
	}
	
	public boolean addDepartment(Department newDepartment) {
		boolean foundDepartment = false;
		
		if (departmentList.isEmpty()) {
        	foundDepartment = false;
        }
        for (Department department: departmentList) {
            if (department.getName().equals(newDepartment.getName())) {
            	foundDepartment = true;
            }
        }
        if (!foundDepartment) {
        	departmentList.add(newDepartment);
        }
		return foundDepartment; 
    }
	
	public Department findDepartment(String name) {
		for(Department department : departmentList) {
			if(department.getName().equals(name)) {
				return department;
			}
		}
		return null;
	}
		
    public boolean deleteDepartment(Department department) {
    	boolean deletedDepartment = false;
    	Department departmentToDelete = null;
    	for (Department department2: departmentList) {
            if (department2.getName().equals(department.getName())) {           
            	departmentToDelete = department2;
            	deletedDepartment = true;
            }
        }
    	if (deletedDepartment) {
    		departmentList.remove(departmentToDelete);
    	}
		return deletedDepartment;
    }
}
