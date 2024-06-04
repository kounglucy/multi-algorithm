package blood.transfusion.view;

import blood.transfusion.contoller.BTController;

public class RunningStartView {

	public static void main(String[] args) {
		BTController controller = BTController.getInstance();
		
		System.out.println("=====모든 프로젝트 검색=====");
		controller.allBTProjects();
		
	}
}
