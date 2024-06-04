package model;

import java.util.ArrayList;

import model.domain.Student;

public class StudentModel {
	
	// DB 역할
//	private static Student[] allData = new Student[5];
	private static ArrayList<Student> allData = new ArrayList<Student>();
	
	// 가상의 데이터 저장
	static {
//		allData[0] = new Student("Java", 26);
//		allData[1] = new Student("Python", 30);
//		allData[2] = new Student("C++", 38);
		
		allData.add(new Student("Java", 26));
		allData.add(new Student("Python", 30));
		allData.add(new Student("C++", 38));
	}
	
	// 모든 학생 검색
	public static ArrayList<Student> getAll() {
		return allData;
	}
	
	// 한 학생의 정보만 검색
	public static Student getOne(String name) {
		ArrayList<Student> allData  = getAll();
		for(int i = 0; i < StudentModel.allData.size(); i++) {
			if(allData.get(i) != null && name.equals(allData.get(i).getName())) {
				return allData.get(i);
			}
		}
		return null;
	}
	
	// 저장 메소드
	public static boolean insert(Student student) {
		if(student != null) {
			allData.add(student);
			return true;
		}
		return false;
	}
	
	// 삭제 메소드
	public static boolean delete(String name) {
		for(int i = 0; i < allData.size(); i++) {
			if(name.equals(allData.get(i).getName())) {
				allData.remove(i);
				return true;
			}
		}
		return false;
	}

	// 수정 : 이름으로 검색 -> 학생의 이름이 있다면 -> 한살 추가 // updateAge
	public static Student updateAge(String name) {
		for(int i = 0; i < allData.size(); i++) {
			if(name.equals(allData.get(i).getName())) {
				allData.get(i).setAge(allData.get(i).getAge() + 1);
				return allData.get(i);
			}
		}
		return null;
	}
}












