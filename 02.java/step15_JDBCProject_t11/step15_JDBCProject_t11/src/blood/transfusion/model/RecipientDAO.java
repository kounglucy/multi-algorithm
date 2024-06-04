package blood.transfusion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blood.transfusion.dto.RecipientDTO;
import blood.transfusion.util.DBUtil;

public class RecipientDAO {
	public static boolean addRecipient(RecipientDTO recipient) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into Recipient values(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, recipient.getId());
			pstmt.setString(2, recipient.getName());
			pstmt.setInt(3, recipient.getAge());
			pstmt.setString(4, recipient.getSex());
			pstmt.setString(5, recipient.getBloodType());
			pstmt.setString(6, recipient.getPurposeTransfusion());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// 수혈자 id로 주요 기부 내용 수정하기
	public static boolean updateRecipient(String recipientId, String purposeTransfusion) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update Recipient set purpose_Transfusion=? where Recipient_id=?");
			pstmt.setString(1, purposeTransfusion);
			pstmt.setString(2, recipientId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// sql - delete from Recipient where Recipient_id=?
	public static boolean deleteRecipient(String recipientId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from Recipient where Recipient_id=?");
			pstmt.setString(1, recipientId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 수혈자의 모든 정보 반환
	public static RecipientDTO getRecipient(String recipientId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RecipientDTO recipient = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from Recipient where Recipient_id=?");
			pstmt.setString(1, recipientId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				recipient = new RecipientDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return recipient;
	}

	// 모든 수혈자 검색해서 반환
	// sql - select * from Recipient
	public static  ArrayList<RecipientDTO> getAllRecipients() throws SQLException {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RecipientDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from Recipient");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<RecipientDTO>();
			while(rset.next()) {
				list.add(new RecipientDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getString(6) ));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
