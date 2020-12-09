package Controller;

import Model.Department;
import Model.DepartmentContainer;

public class DepartmentController {
	private DepartmentContainer departmentController;
	
	public DepartmentController() {
		departmentController = DepartmentContainer.getInstance();
	}
	
	public DepartmentContainer getDepartmentContainer() {
		return departmentController;
	}
	
	public boolean createDepartment(Department department) {
    	return departmentController.addDepartment(department);
    }
    
    public Department findDepartment(String name) {
    	return departmentController.findDepartment(name);
    }
    
    public boolean deleteDepartment(Department department) {
    	return departmentController.deleteDepartment(department);
    }
}
