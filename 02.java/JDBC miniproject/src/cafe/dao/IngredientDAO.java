package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cafe.dto.IngredientDTO;
import cafe.util.DBUtil;

public class IngredientDAO {
	
	// show all
	public static ArrayList<IngredientDTO> getAllIngredients() throws SQLException{
		ArrayList<IngredientDTO> allIngredients = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("Select * from Ingredient");
			rset = pstmt.executeQuery();
			
			allIngredients = new ArrayList<IngredientDTO>();
			while(rset.next()) {
				allIngredients.add(new IngredientDTO(rset.getString(1), 
													rset.getString(2), 
													rset.getInt(3), 
													rset.getInt(4)));
			}
		}finally {
			DBUtil.close(conn, pstmt, rset);
		}	
		
		return allIngredients;
	}
	
	// show one
	public static IngredientDTO getIngredient(String ingredientId) throws SQLException {
		IngredientDTO ingredient = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from ingredient where ingredient_id = ?");
			pstmt.setString(1, ingredientId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ingredient = new IngredientDTO(rset.getString(1), 
												rset.getString(2), 
												rset.getInt(3), 
												rset.getInt(4));
			}
		}finally {
			DBUtil.close(conn, pstmt, rset);
		}
		
		return ingredient;
	}
	
	// add
	public static boolean addIngredient(IngredientDTO ingredient) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO INGREDIENT VALUES(?, ?, ?, ?)");
			pstmt.setString(1, ingredient.getIngredientId());
			pstmt.setString(2, ingredient.getIngredientName());
			pstmt.setInt(3, ingredient.getIngredientPrice());
			pstmt.setInt(4, ingredient.getIngredientStock());
			
			int result = pstmt.executeUpdate();
			if(result == 1)
				return true;
			
		}finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	// update - price
	public static boolean updateIngredientPrice(String ingredientId, int newIngredientPrice) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE INGREDIENT SET ingredient_price = ? WHERE ingredient_id = ?");
			pstmt.setInt(1,  newIngredientPrice);
			pstmt.setNString(2,  ingredientId);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				return true;		
		}finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	// 재고 확인
	public static int stockCheck(String ingredientId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		IngredientDTO ingredient = new IngredientDTO();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM INGREDIENT WHERE ingredient_id = ?");
			pstmt.setNString(2,  ingredientId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ingredient = new IngredientDTO(rset.getNString(1),
											rset.getNString(2),
											rset.getInt(3),
											rset.getInt(4));
			}
		}finally {
			DBUtil.close(conn, pstmt, rset);
		}
		
		int stock = ingredient.getIngredientStock();
		
		return stock;
	}
	
	// update - stock
	public static boolean updateIngredientNStock(String ingredientId, int newIngredientStock) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE INGREDIENT SET ingredient_stock = ? WHERE ingredient_id = ?");
			pstmt.setInt(1,  newIngredientStock);
			pstmt.setNString(2,  ingredientId);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				return true;		
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	// update - stock 1개 감소
	public static boolean updateIngredientStock(String ingredientId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		if(stockCheck(ingredientId) >= 1) {
			try {
				conn = DBUtil.getConnection();
				pstmt = conn.prepareStatement("UPDATE INGREDIENT SET ingredient_stock = ingredient_stock-1 WHERE ingredient_id = ?");
				pstmt.setNString(1,  ingredientId);
				
				int result = pstmt.executeUpdate();
				
				if(result == 1)
					return true;		
			}finally{
				DBUtil.close(conn, pstmt);
			}
		}
		return false;
	}
	
	// delete
	public static boolean deleteIngredient(String ingredientId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM INGREDIENT WHERE ingredient_id = ?");
			pstmt.setNString(1, ingredientId);
			
			int result = pstmt.executeUpdate();
			if(result == 1)
				return true;
			
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	
}
