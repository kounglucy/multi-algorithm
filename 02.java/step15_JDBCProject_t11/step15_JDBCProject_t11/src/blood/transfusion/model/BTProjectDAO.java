package blood.transfusion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.util.DBUtil;

public class BTProjectDAO {
	// 프로젝트 저장
	public static boolean addBTProject(BTProjectDTO btProject) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into blood_transfusion_project values(?, ?, ?, ?, ?)");
			pstmt.setString(1, btProject.getBtProjectName());
			pstmt.setString(2, btProject.getBtProjectId());
			pstmt.setString(3, btProject.getDonorId());
			pstmt.setString(4, btProject.getRecipientId());
			pstmt.setString(5, btProject.getbtContent());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 프로젝트 아이디로 헌혈자 정보 수정
	public static boolean updateBTProjectdonor(String btProjectId, String donorId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update bt_project set donor_id=? where bt_project_id=?");
			pstmt.setString(1, donorId);
			pstmt.setString(2, btProjectId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 프로젝트 아이디로 수혈자 정보 수정
	public static boolean updateBTProjectReceive(String btProjectId, String recipientId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update bt_project set receive_id=? where bt_project_id=?");
			pstmt.setString(1, recipientId);
			pstmt.setString(2, btProjectId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 프로젝트 이름으로 프로젝트 삭제
	public static boolean deleteBTProject(String btProjectName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BTProjectDTO blood_transfusionUser = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from bt_project where bt_project_name=?");
			
			pstmt.setString(1, btProjectName);
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 프로젝트 이름으로 프로젝트 검색
	public static BTProjectDTO getBTProject(String btProjectName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BTProjectDTO blood_transfusionUser = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from bt_project where bt_project_name=?");
			pstmt.setString(1, btProjectName);
			rset = pstmt.executeQuery();

			// 
			if(rset.next()) {
				blood_transfusionUser = new BTProjectDTO(rset.getString(1),
															rset.getString(2),
															rset.getString(3),
															rset.getString(4),
															rset.getString(5));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return blood_transfusionUser;
	}
	// 모든 수혈 프로젝트 검색
	public static ArrayList<BTProjectDTO> getAllBTProjects() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BTProjectDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from bt_project");
			rset = pstmt.executeQuery();
			
			// 
			list = new ArrayList<BTProjectDTO>();
			while(rset.next()) {
				list.add(new BTProjectDTO(rset.getString("bt_project_name"),
											rset.getString("bt_project_id"),
											rset.getString("donor_id"),
											rset.getString("recipient_id"),
											rset.getString("bt_content")));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
