package dept.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerMapping {
	private Map<String, Object> mappings;

	public ControllerMapping() {
		mappings = new HashMap<String, Object>();
		mappings.put("/insertDeptForm.do", new InsertDeptFormController());
		mappings.put("/inserDept.do", new InsertDeptController());
		mappings.put("/getDeptList.do", new GetDeptListController());
		mappings.put("/getDept.do", new GetDeptController());
		mappings.put("/updateDeptForm.do", new UpdateDeptFormController());
		mappings.put("/updateDept.do", new UpdateDeptController());
		mappings.put("/deleteDept.do", new DeleteDeptController());
	}
	
	public Object getController(String path) {
		return mappings.get(path);
	}
}