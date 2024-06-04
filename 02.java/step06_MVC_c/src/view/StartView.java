package view;

import controller.StudentController;

public class StartView {
	public static void main(String[] args) {
//		System.out.println("=== 모든 검색 ===");
//		StudentController.request(1);
//		System.out.println("=== 학생 검색 ===");
//		StudentController.request(2);
		System.out.println("=== 학생 등록 ===");
		StudentController.request(3);
		StudentController.request(1);
//		System.out.println("=== 학생 정보 삭제 ===");
//		StudentController.request(4);
//		StudentController.request(2);
//		StudentController.request(1);
//		System.out.println("=== 학생 정보 수정(한살 추가) ===");
//		StudentController.request(5);
	}
}
