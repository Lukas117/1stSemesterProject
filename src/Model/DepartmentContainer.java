package Model;

import java.util.*;

public class DepartmentContainer {
	private ArrayList<Department> departmentList;
	private static DepartmentContainer instance;
	private Department dep = new Department("Kitchen and Bathroom department", "DIY Center");
	private Department dep1 = new Department("Fireplace and Woodburning department", "DIY Center");
	private Department dep2 = new Department("Timber department", "Timber merchant warehouse");
	
	
	private DepartmentContainer() {
		departmentList = new ArrayList<>();
		addDepartment(dep);
		addDepartment(dep1);
		addDepartment(dep2);
	}
	
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
    	for (Department _department: departmentList) {
            if (_department.getName().equals(department.getName())) {           
            	departmentToDelete = _department;
            	deletedDepartment = true;
            }
        }
    	if (deletedDepartment) {
    		departmentList.remove(departmentToDelete);
    	}
		return deletedDepartment;
    }
}
