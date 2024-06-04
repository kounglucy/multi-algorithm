package dept.test;

import java.sql.DriverManager;
import java.sql.SQLException;

import dept.dao.DeptDAO;
import dept.dto.Dept;

public class DeptTest {

	public static void main(String[] args) {
		try {
			// 모든 부서 검색 
			 System.out.println(DeptDAO.getAllDept());
			
			// 특정 부서 검색 
			// System.out.println(DeptDAO.getDeptByDeptno(20));
			
			// 새로운 부서 생성 v1
		    // System.out.println(DeptDAO.insertDept(new Dept(60,"DEV","SEOUL")));
			
			// 새로운 부서 생성 v2
			// System.out.println(DeptDAO.insertDept2(new Dept(70,"DEVOPS","BUSAN")));

			// 부서명 수정 
			// System.out.println(DeptDAO.updateDeptLocByDeptno(70, "JEJU"));
			
			// 부서명 삭제 
			// System.out.println(DeptDAO.deleteDeptByDeptno(70));
			
			} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
