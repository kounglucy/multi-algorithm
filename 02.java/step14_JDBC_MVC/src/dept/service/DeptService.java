package dept.service;

import java.sql.SQLException;
import java.util.ArrayList;

import dept.dao.DeptDAO;
import dept.dto.Dept;

public class DeptService {
	private static DeptService instance = new DeptService();
	private DeptDAO deptDao = DeptDAO.getInstance();

	private DeptService() {}

	public static DeptService getInstance() {
		return instance;
	}

	public ArrayList<Dept> getAllDepts() throws SQLException {
		return deptDao.getAllDept();
	}
}
