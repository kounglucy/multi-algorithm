package blood.transfusion.view;

import java.util.Scanner;

import blood.transfusion.controller.BloodTransfusionController;
import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.Donor;
import blood.transfusion.dto.Recipient;

public class StartView {

	public static void main(String[] args) {

		BloodTransfusionController controller = BloodTransfusionController.getInstance();

		// 헌혈자
		Donor donor4 = new Donor("donor4", "헌혈4", 52, "M", "AB-", "실험");
		// 수혈자
		Recipient recipient4 = new Recipient("recipient4", "수혈4", 83, "M", "AB-", "수술");
		// 새로운 헌혈 프로젝트
		BloodTransfusionProject newProject = new BloodTransfusionProject("AB-", "bt4", donor4, recipient4, "응급 처치 프로젝트");

		// 모든 프로젝트 검색
		System.out.println("===== 1. 모든 프로젝트 검색  =====");
//		controller.projectListView();

		// 새로운 프로젝트 저장
		System.out.println("===== 2. 새로운 프로젝트 저장 및 확인 =====");
//		controller.insertProject(newProject);
//		controller.projectListView();

		// 존재하는 프로젝트 검색
		System.out.println("===== 3. 존재하는 프로젝트 검색 =====");
		Scanner sc = new Scanner(System.in);
		String projectName = sc.next();
		controller.projectView(projectName);

		System.out.println();

		System.out.println("===== 4. 존재하지 않는 프로젝트 검색 - 예외처리 =====");
//		controller.projectView("A+");

		System.out.println();

		// 존재하는 프로젝트 수정
		System.out.println("===== 5. 존재하는 프로젝트 수정 및 확인 =====");
		controller.updateProject("A-", new Recipient("recipient5", "수혈5", 2, "F", "A-", "응급수술"));
		controller.projectView("A-");

		System.out.println();

		// 존재하지 않는 프로젝트 수정 : 예외 발생
		System.out.println("===== 6. 존재하지 않는 프로젝트 수정 - 예외처리 확인용 =====");
//		controller.updateProject("B+", new Recipient("recipient6", "수혈6", 22, "F", "B-", "질병"));
		
		System.out.println();

		// 존재하는 프로젝트 삭제 및 삭제여부 확인
		System.out.println("===== 7. 존재하는 프로젝트 삭제 및 확인 =====");
		controller.deleteProject("B-");
		controller.projectView("B-");
	}

}



































