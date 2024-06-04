package dept.view;

import java.util.ArrayList;

import dept.dto.Dept;


public class DeptEndView {
	// 모든 데이터 출력
	public static void printAll(ArrayList<Dept> allData) {
		for(Dept Dept : allData) {
			System.out.println(Dept);
		}
	}
	
	// 한명 출력
	public static void printOne(Dept Dept) {
		if(Dept != null) {
			System.out.println(Dept);
		}else {
			System.out.println("검색한 부서가 없습니다.");
		}
	}
	
	public static void printSuccess(String msg) {
		System.out.println(msg);
	}

	public static void printFail(String msg) {
		System.out.println(msg);
	}
}
