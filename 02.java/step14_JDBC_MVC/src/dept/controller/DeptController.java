package dept.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.Dept;
import dept.service.DeptService;

public class DeptController {
	private static DeptController instance = new DeptController();
	private DeptService service = DeptService.getInstance();

	private DeptController() {}

	public static DeptController getInstance() {
		return instance;
	}

	public ArrayList<Dept> getAllDept() {
		ArrayList<Dept> allDepts = null;
		
		try {
			allDepts = service.getAllDepts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allDepts;
	}
}
