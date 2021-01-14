package Controller;

import Model.Department;
import Model.DepartmentContainer;

public class DepartmentController {
	private DepartmentContainer departmentContainer;
	
	public DepartmentController() {
		departmentContainer = DepartmentContainer.getInstance();
	}
	
	public DepartmentContainer getDepartmentContainer() {
		return departmentContainer;
	}
	
	public boolean createDepartment(Department department) {
    	return departmentContainer.addDepartment(department);
    }
    
    public Department findDepartment(String name) {
    	return departmentContainer.findDepartment(name);
    }
    
    public boolean deleteDepartment(Department department) {
    	return departmentContainer.deleteDepartment(department);
    }
}
