package blood.transfusion.model;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.Donor;
import blood.transfusion.dto.Recipient;

public class BloodTransfusionVirtualDB {
	private static BloodTransfusionVirtualDB instance = new BloodTransfusionVirtualDB();
	private ArrayList<BloodTransfusionProject> projects = new ArrayList<>();
	
	private BloodTransfusionVirtualDB() {
		projects.add(new BloodTransfusionProject("A-", "bt1",
												new Donor("donor1", "헌혈1", 12, "M", "A-", "봉사"), 
												new Recipient("recipient1", "수혈1", 23, "F", "A-", "사고"), 
												"A-형간의 수혈"));
		
		projects.add(new BloodTransfusionProject("B-","bt2",
												new Donor("donor2", "헌혈2", 67, "F", "B-", "검사"), 
												new Recipient("recipient2", "수혈2", 21, "F", "B-", "사고"), 
												"B-형간의 수혈"));
		
		projects.add(new BloodTransfusionProject("O-","bt3",
												new Donor("donor3", "헌혈3", 35, "F", "O-", "봉사"), 
												new Recipient("recipient3", "수혈3", 3, "M", "O-", "질병"), 
												"O-형간의 수혈"));
	}
	
	public static BloodTransfusionVirtualDB getInstance() {
		return instance;
	}
	
	// 모든 프로젝트 반환_
	public ArrayList<BloodTransfusionProject> getProjectList(){
		return projects;
	}
	
	// 프로젝트 주입_
	public void insertProject(BloodTransfusionProject newProject) {
		projects.add(newProject);
	}
	
	// 수정_
	
	
	// 삭제_
	
	
}















