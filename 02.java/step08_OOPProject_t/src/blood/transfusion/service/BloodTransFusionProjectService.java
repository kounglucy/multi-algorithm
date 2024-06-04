package blood.transfusion.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.Donor;
import blood.transfusion.dto.People;
import blood.transfusion.dto.Recipient;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BloodTransfusionVirtualDB;

public class BloodTransFusionProjectService {
	private static BloodTransFusionProjectService instance = new BloodTransFusionProjectService();
	private BloodTransfusionVirtualDB projectVirtualData = BloodTransfusionVirtualDB.getInstance();

	private BloodTransFusionProjectService(){}
	public static BloodTransFusionProjectService getInstance(){
		return instance;
	}
	
	// 모든 프로젝트 반환
	public ArrayList<BloodTransfusionProject> getAllProjects(){
		return projectVirtualData.getProjectList();
	}
	
	// 프로젝트 검색_
	public BloodTransfusionProject getProject(String projectName) throws NotExistException{
		BloodTransfusionProject project = null;
		
		ArrayList<BloodTransfusionProject> projectList = projectVirtualData.getProjectList();
		for(int i = 0; i < projectList.size(); i++) {
			if(projectList.get(i).getBtProjectName().equals(projectName)) {
				project = projectList.get(i);
			}
		}
		
		if(project == null) {
			throw new NotExistException("검색 요청하신 프로젝트는 존재하지 않습니다");
		}
		
		return project;
	}

	// 새로운 프로젝트 추가_
	public void projectInsert(BloodTransfusionProject newProject) {
		projectVirtualData.insertProject(newProject);
	}
	
	// 프로젝트 수정 - 프로젝트 명으로 현혈자 혹은 수혈자 수정_
	public void projectUpdate(String projectName, People people) throws NotExistException{
		// 이미 완성된 getProject(projectName)
		BloodTransfusionProject project = getProject(projectName);
		
		if(project == null){
			throw new NotExistException("수정하고자 하는 Project가 존재하지 않습니다");
		}else if(people instanceof Recipient) {
			project.setRecipient((Recipient)people);
		}else if(people instanceof Donor) {
			project.setDonor((Donor)people);
		}
	}
	
	// 프로젝트 삭제_
	public void projectDelete(String projectName) throws NotExistException{
		BloodTransfusionProject project = getProject(projectName);
		getAllProjects().remove(project);
	}	
}





