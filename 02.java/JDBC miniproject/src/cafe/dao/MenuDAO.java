package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cafe.dto.MenuDTO;
import cafe.util.DBUtil;

public class MenuDAO {
	//show all 
	public static ArrayList<MenuDTO> getAllMenus() throws SQLException{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<MenuDTO> allMenus = null;
			
			try {
				conn = DBUtil.getConnection();
				
				pstmt = conn.prepareStatement("Select * from menu");
				rset = pstmt.executeQuery();
				
				allMenus= new ArrayList<MenuDTO>();
				while(rset.next()) {  
					allMenus.add(new MenuDTO(rset.getString(1), 
						                     rset.getString(2), 
						                     rset.getInt(3), 
						                     rset.getString(4)));
					
					
				}
			}finally {
				DBUtil.close(conn, pstmt, rset);
			}	
			
			return allMenus;
		}
		
	// show one 
	public static MenuDTO getMenu(String menuID) throws SQLException {
		MenuDTO menu = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from menu where menu_id = ?");
			pstmt.setString(1, menuID);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				menu = new MenuDTO(rset.getString(1), 
							       rset.getString(2), 
								   rset.getInt(3), 
								   rset.getString(4));
			}
		}finally {
			DBUtil.close(conn, pstmt, rset);
		}
			
		return menu;
	}
	  
		  
    // add
	public static boolean addMenu(MenuDTO menu) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO MENU VALUES(?, ?, ?, ?)");
			pstmt.setString(1, menu.getMenuId());
			pstmt.setString(2, menu.getMenuName());
			pstmt.setInt(3, menu.getMenuPrice());
			pstmt.setString(4, menu.getMenuType());
				
			int result = pstmt.executeUpdate();
			if(result == 1)
				return true;
				
		}finally {
			DBUtil.close(conn, pstmt);
		}
			
		return false;
	}
		
	// update - name 
	public static boolean updateMenuName(String menuId, String newMenuName) throws SQLException {
		   Connection conn = null;
		   PreparedStatement pstmt = null;
				
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE MENU SET menu_name = ? WHERE menu_id = ?");
			pstmt.setString (1, newMenuName);
			pstmt.setString (2,  menuId);
				
			int result = pstmt.executeUpdate();
				
			if(result == 1)
				return true;		
				
				return false;
			}	
		
			
	// update - price 
	public static boolean updateMenuPrice(String menuId, int newMenuPrice) throws SQLException {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
			
		conn = DBUtil.getConnection();
		pstmt = conn.prepareStatement("UPDATE MENU SET menu_price = ? WHERE menu_id = ?");
		pstmt.setInt(1,  newMenuPrice);
		pstmt.setString(2,  menuId);
			
		int result = pstmt.executeUpdate();
			
		if(result == 1)
			return true;		
			
			return false;
		}
		
		
	// delete
	public static boolean deleteMenu(String menuId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM MENU WHERE menu_id = ?");
			pstmt.setNString(1, menuId);
				
			int result = pstmt.executeUpdate();
			if(result == 1)
					return true;
				
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}


	
}
