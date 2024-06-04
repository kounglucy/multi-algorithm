package cafe.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import cafe.dto.MenuIngredientDTO;
import cafe.dto.OrderMenuDTO;
import cafe.util.DBUtil;
public class OrderMenuDAO {
	// show all
	public static ArrayList<OrderMenuDTO> getAllOrderMenus() throws SQLException{
		ArrayList<OrderMenuDTO> allOrderMenus = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("Select * from order_menu");
			rset = pstmt.executeQuery();
			
			allOrderMenus = new ArrayList<OrderMenuDTO>();
			while(rset.next()) {
				allOrderMenus.add(new OrderMenuDTO(rset.getString(1),
													rset.getString(2),
													rset.getString(3)));
			}
		}finally {
			DBUtil.close(conn, pstmt);
		}		
		
		return allOrderMenus;
	}
	
	// show one
	public static OrderMenuDTO getOrderMenu(String orderMenuId) throws SQLException {
		OrderMenuDTO orderMenu = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("Select * from order_menu where order_id = ?");
			pstmt.setNString(1, orderMenuId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				orderMenu = new OrderMenuDTO(rset.getString(1),
											rset.getNString(2),
											rset.getNString(3));
			}
			
		}finally {
			DBUtil.close(conn, pstmt);
		}
		
		return orderMenu;
	}
	
	// menu_id update
	public static boolean updateOrderMenu(String orderId, String menuId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE ORDER_MENU SET menu_id = ? WHERE order_id = ?");
			
			
			pstmt.setNString(1, menuId);
			pstmt.setNString(2, orderId);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
			
			
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	// menu delete
	public static boolean deleteOrderMenu(String orderMenuId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM ORDER_MENU WHERE order_id = ?");
			
			pstmt.setString(1, orderMenuId);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		}
		finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	// order_menu add
	public static boolean addOrderMenu(String menuId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		conn = DBUtil.getConnection();
		pstmt = conn.prepareStatement("INSERT INTO ORDER_MENU VALUES(?, ?, ?)");
		
		String orderMenuId = "O" + (OrderMenuDAO.getAllOrderMenus().size()+1);
		
		pstmt.setNString(1, orderMenuId);
		pstmt.setString(2, "00-02-03"); // 시간정보 수정
		pstmt.setNString(3, menuId);
		
		int result = pstmt.executeUpdate();
		
		if(result != 0) {
			return true;
		}
		
		}finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	
	
	// stock update

	public static boolean stockUpdate(String menuId) throws SQLException {
		// 1. 메뉴 id에 어떤 재료가 들어가는지 확인한다.
		ArrayList<MenuIngredientDTO> menuIngredient = MenuIngredientDAO.getMenuIngredientsByMenuId(menuId);
		
		int length = menuIngredient.size();
		if(length >= 1) { // 재료가 들어간다면
			for(int index = 0; index < length; index++) {
				// 재료의 재고 개수를 알려준다.
				int stock = IngredientDAO.stockCheck(menuIngredient.get(0).getIngredientId());
				
				// 재고를 1개씩 감소시키는 메서드에 재료들을 하나씩 넣는다.
				if (stock >= 1) {
					IngredientDAO.updateIngredientStock(menuIngredient.get(0).getIngredientId());
				}
			}
			
			return true;
		}
		
		return false;
	}
	
}