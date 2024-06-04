package blood.transfusion.view;

import java.util.ArrayList;

import blood.transfusion.dto.BTProjectDTO;

public class RunningEndView {
	//모든 프로젝트 출력
	public static void projectListView(ArrayList<BTProjectDTO> allProject){
		int length = allProject.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("검색정보 " + (index+1) + " - " + allProject.get(index));
			}
		}
	}
		
	//특정 프로젝트 출력 
	public static void projectView(BTProjectDTO project){
		System.out.println(project);		
	}
	
	// 모든 DTO 정보 출력하는 메소드
	public static void allView(Object object){
		System.out.println(object);
	}
	
	
	//예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}
}
