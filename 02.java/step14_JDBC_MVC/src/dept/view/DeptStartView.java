package dept.view;

import java.util.ArrayList;

import dept.controller.DeptController;
import dept.dto.Dept;

public class DeptStartView {
	public static void main(String[] args) {
		DeptController deptContoller = DeptController.getInstance();
		
			// 모든 부서 검색
			ArrayList<Dept> allDepts = deptContoller.getAllDept();
			DeptEndView.printAll(allDepts);
			
			// 특정 부서 검색
//			System.out.println(DeptDAO.getDeptByDeptno(20));
			
			// 새로운 부서 생성 v1
//			System.out.println(DeptDAO.insertDept(new Dept(60, "DEV", "SEOUL")));

			// 새로운 부서 생성 v2
//			System.out.println(DeptDAO.insertDept2(new Dept(70, "DEVOPS", "BUSAN")));
			
			// 부서명 수정
//			System.out.println(DeptDAO.updateDeptLocByDeptno(70, "JEJU"));

			// 부서 삭제
//			System.out.println(DeptDAO.deleteDeptByDeptno(70));
	}
}
