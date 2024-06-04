package blood.transfusion.view;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;

public class EndView {
	
	//특정 프로젝트 출력_
	public static void projectView(BloodTransfusionProject project) {
		if(project != null) {
			System.out.println(project);
		}
	}
	
	//모든 프로젝트 출력_
	public static void projectListView(ArrayList<BloodTransfusionProject> allBTPrjoects) {
		for(int i = 0; i < allBTPrjoects.size(); i++) {
			System.out.println("[프로젝트 " + (i+1) + "]");
			System.out.println(allBTPrjoects.get(i));
			System.out.println();
		}
	}
	
	//예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
}
