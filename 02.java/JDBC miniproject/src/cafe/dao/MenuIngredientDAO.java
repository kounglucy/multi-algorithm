package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cafe.dto.MenuIngredientDTO;
import cafe.util.DBUtil;

public class MenuIngredientDAO {
	// show menu_id
	public static ArrayList<MenuIngredientDTO> getMenuIngredientsByMenuId(String menuId) throws SQLException{
		ArrayList<MenuIngredientDTO> allMenuIngredients = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MENU_INGREDIENT WHERE menu_id = ?");
			pstmt.setString(1, menuId);
			rset = pstmt.executeQuery();
			
			allMenuIngredients = new ArrayList<MenuIngredientDTO>();
			while(rset.next()) {
				allMenuIngredients.add(new MenuIngredientDTO(rset.getString(1),
															rset.getString(2),
															rset.getString(3)));
			}
		}finally {
			DBUtil.close(conn, pstmt, rset);
		}
		
		return allMenuIngredients; 
	}
}
