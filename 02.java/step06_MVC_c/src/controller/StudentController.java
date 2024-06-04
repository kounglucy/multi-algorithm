/* 컨트롤러
 * StartView -> 요청한 처리 결과를 반환 -> EndView 전달
 * - 수행기능
 * 		1 - 모든 검색
 * 		2 - 개인 (1명) 검색 : 이름으로 검색
 * 		3 - 저장
 * 		4 - 삭제
 * 		5 - 수정
 * 
 */
package controller;

import model.StudentModel;
import model.domain.Student;
import view.EndView;

public class StudentController {
	public static void request(int reqNumber) {
		if(reqNumber == 1) {
			EndView.printAll(StudentModel.getAll()); 
		}else if(reqNumber == 2) {
			EndView.printOne(StudentModel.getOne("Java"));
		}else if(reqNumber == 3) {
			boolean r = StudentModel.insert(new Student("IT", 12));
			if(r) {
				EndView.printSuccess("등록 성공");
			}else {
				EndView.printFail("등록 실패");
			}
		}else if(reqNumber == 4) {
			boolean r = StudentModel.delete("Java");
			if(r) {
				EndView.printSuccess("삭제 성공");
			}else {
				EndView.printFail("삭제 실패");
			}
		}else if(reqNumber == 5) {
			EndView.printOne(StudentModel.updateAge("Java"));
		}
	}
}












