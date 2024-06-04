package model;

import model.domain.Student;

public class StudentModel {
	
	// DB 역할
	private static Student[] allData = new Student[5];
	private static int index;
	
	// 가상의 데이터 저장
	static {
		allData[0] = new Student("Java", 26);
		allData[1] = new Student("Python", 30);
		allData[2] = new Student("C++", 38);
		index = 3;
	}
	
	// 모든 학생 검색
	public static Student[] getAll() {
		return allData;
	}
	
	// 한 학생의 정보만 검색
	public static Student getOne(String name) {
//		1. 모든 데이터를 가져와서(for) -> 각각 하나의 데이터만 접근
//		2. 접근한 데이터 객체의 이름과 파라미터로 전달받은 name값을 비교(equals)
//		3. 비교 결과가 참이면 -> return 해당 학생 객체 / 거짓이면 -> null
		for(int i = 0; i < allData.length; i++) {
			if(allData[i] != null && name.equals(allData[i].getName())) {
				return allData[i];
			}
		}
		return null;
	}
	
	// 저장 메소드
	/* Student 객체가 배열에 저장
	 * 개발
	 * 	- 고려사항 1 : 매개변수 값으로 name, age -> Student 객체 생성 -> 배열에 저장
	 * 	- 고려사항 2 : 매개변수 값으로 Student 객체 -> 배열에 저장
	 */
	public static boolean insert(Student student) {
		if(student != null && index < 5) {
			allData[index] = student;
			index++;
			return true;
		}
		return false;
		
//		for (int i = 0; i < allData.length; i++) {
//			if(allData[i] == null && student != null) {
//				allData[i] = student;
//				return true;
//			}
//		}
//		return false;
	}
	
	// 삭제 메소드
	/* 개발
	 * 	- 고려사항 1 : 미존재 데이터 삭제?
	 * 	- 고려사항 2 : 존재 데이터 삭제?
	 * 	- 삭제의 의미 : 배열의 값 삭제
	 * 	- 만약
	 * 		1. 마지막 index 데이터 삭제
	 * 		2. 중간 index 데이터 삭제
	 * 			- 모든 사람 정보 검색 데이터 출력에 문제
	 * 			- 고려사항
	 * 				1. 실행시 존재 하지 않는 객체 출력 에러 발생 가능
	 * 				2. 검증 필수
	 * 
	 * 	- 이름으로 삭제 
	 * 		1. 반복문을 통해서 이름값과 매개변수값을 비교
	 */
	public static boolean delete(String name) {
		for(int i = 0; i < allData.length; i++) {
			if(allData[i] != null && name.equals(allData[i].getName())) {
				allData[i] = null;
				return true;
			}
		}
		return false;
	}

	// 수정 : 이름으로 검색 -> 학생의 이름이 있다면 -> 한살 추가 // updateAge
	public static Student updateAge(String name) {
		for(int i = 0; i < allData.length; i++) {
			if(allData[i] != null && name.equals(allData[i].getName())) {
				allData[i].setAge(allData[i].getAge() + 1);
				return allData[i];
			}
		}
		return null;
	}
}












