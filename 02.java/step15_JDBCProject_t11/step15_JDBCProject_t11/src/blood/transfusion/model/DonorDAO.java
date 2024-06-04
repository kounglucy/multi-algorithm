package blood.transfusion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blood.transfusion.dto.DonorDTO;
import blood.transfusion.util.DBUtil;

public class DonorDAO {
	public static boolean addDonor(DonorDTO donor) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into Donor values(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, donor.getId());
			pstmt.setString(2, donor.getName());
			pstmt.setInt(3, donor.getAge());
			pstmt.setString(4, donor.getSex());
			pstmt.setString(5, donor.getBloodType());
			pstmt.setString(6, donor.getPurposeDonation());
			
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
	// 헌혈자 id로 주요 기부 내용 수정하기
	public static boolean updateDonor(String donorId, String purposeDonation) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update Donor set purpose_donation=? where Donor_id=?");
			pstmt.setString(1, purposeDonation);
			pstmt.setString(2, donorId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// sql - delete from donor where donor_id=?
	public static boolean deleteDonor(String donorId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from donor where donor_id=?");
			pstmt.setString(1, donorId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 헌혈자의 모든 정보 반환
	public static DonorDTO getDonor(String donorId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DonorDTO Donor = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from donor where Donor_id=?");
			pstmt.setString(1, donorId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Donor = new DonorDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Donor;
	}

	// 모든 헌혈자 검색해서 반환
	// sql - select * from donor
	public static  ArrayList<DonorDTO> getAllDonors() throws SQLException {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DonorDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from donor");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<DonorDTO>();
			while(rset.next()) {
				list.add(new DonorDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getString(6) ));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
