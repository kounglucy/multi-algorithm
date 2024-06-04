package cafe.service;

import java.sql.SQLException;
import java.util.ArrayList;

import cafe.dao.IngredientDAO;
import cafe.dao.MenuDAO;
import cafe.dao.MenuIngredientDAO;
import cafe.dao.OrderMenuDAO;
import cafe.dto.IngredientDTO;
import cafe.dto.MenuDTO;
import cafe.dto.MenuIngredientDTO;
import cafe.dto.OrderMenuDTO;
import cafe.exception.NotExistException;

public class CafeSerive {
	private static CafeSerive instance = new CafeSerive();
	
	private CafeSerive(){}
	
	public static CafeSerive getInstance(){
		return instance;
	}
	

	/*============ Menu ===============*/
	// Menu - CRUD 
	public void notExistMenu(String menuId) throws SQLException,NotExistException {
		MenuDTO menu = MenuDAO.getMenu(menuId);
		if (menu == null) {
			throw new NotExistException("검색한 메뉴가 없습니다");
		}
	}
	
	// 모든 Menu 출력 : getAllMenus();
	public ArrayList<MenuDTO> getAllMenus() throws SQLException{
		return MenuDAO.getAllMenus();
	}
	
	// menu_id로 특정 Menu 출력 : getMenu();
	public MenuDTO getMenu(String menuId) throws SQLException, NotExistException {
		notExistMenu(menuId);
		return MenuDAO.getMenu(menuId);
	}
	
	// menu 추가 : addMenu();
	public boolean addMenu(MenuDTO menu) throws SQLException {
		return MenuDAO.addMenu(menu);
	}
	
	// menu name 수정
	public boolean updateMenuName (String menuId, String newMenuName) throws SQLException, NotExistException {
		notExistMenu(menuId);
		return MenuDAO.updateMenuName (menuId, newMenuName);
	}
	
	// menu price 수정 
	public boolean updateMenuPrice (String menuId, int newMenuPrice) throws SQLException, NotExistException {
		notExistMenu(menuId);
		return MenuDAO.updateMenuPrice(menuId, newMenuPrice);
	}
	
	// menu 삭제
	public boolean deleteMenu(String menuId) throws SQLException, NotExistException {
		notExistMenu(menuId);
		return MenuDAO.deleteMenu(menuId);
		}
	
	
	
	
	/*============ Ingredient ===============*/
	//Ingredient - CRUD
	public void notExistIngredient(String ingredientId) throws NotExistException, SQLException{
		IngredientDTO ingredient = IngredientDAO.getIngredient(ingredientId);
		if(ingredient == null){
			throw new NotExistException("검색하신 Ingredient가 없습니다.");
		}
	}
	
	// 모든 Ingredient 출력 : getAllIngredients();
	public ArrayList<IngredientDTO> getAllIngredients() throws SQLException {
		return IngredientDAO.getAllIngredients();
	}
	
	// ingredient_id로 특정 Ingredient 출력 : getIngredient();
	public IngredientDTO getIngredient(String ingredientId) throws SQLException, NotExistException {
		notExistIngredient(ingredientId);
		return IngredientDAO.getIngredient(ingredientId);
	}
	
	// ingredient 추가 : addIngredient();
	public boolean addIngredient(IngredientDTO ingredient) throws SQLException {
		return IngredientDAO.addIngredient(ingredient);
	}
	
	// ingredient price 업데이트
	public boolean updateIngredientPrice(String ingredientId, int newIngredientPrice) throws SQLException, NotExistException {
		notExistIngredient(ingredientId);
		return IngredientDAO.updateIngredientPrice(ingredientId, newIngredientPrice);
	}
	
	// ingredient stock 업데이트
	public boolean updateIngredientNStock(String ingredientId, int newIngredientStock) throws SQLException, NotExistException {
		notExistIngredient(ingredientId);
		return IngredientDAO.updateIngredientNStock(ingredientId, newIngredientStock);
	}
	
	// ingredient 삭제
	public boolean deleteIngredient(String ingredientId) throws SQLException, NotExistException {
		notExistIngredient(ingredientId);
		return IngredientDAO.deleteIngredient(ingredientId);
	}
	
	
	/*============ OrderMenu ===============*/
	//OrderMenu - CRUD
	public void notExistOrderMenu(String orderMenuId) throws NotExistException, SQLException{
		OrderMenuDTO orderMenu = OrderMenuDAO.getOrderMenu(orderMenuId);
		if(orderMenu == null){
			throw new NotExistException("검색하신 OrderMenu가 없습니다.");
		}
	}
	// 모든 OrderMenu 출력
	public ArrayList<OrderMenuDTO> getAllOrderMenus() throws SQLException{
		return OrderMenuDAO.getAllOrderMenus();
	}
	
	
	// 특정 OrderMenu 출력
	public OrderMenuDTO getOrderMenu(String orderMenuId) throws SQLException, NotExistException {
		notExistOrderMenu(orderMenuId);
		return OrderMenuDAO.getOrderMenu(orderMenuId);
	}
	
	// OrderMenu 추가(MenuId)
	public boolean addOrderMenu(String menuId) throws SQLException, NotExistException {
		notExistMenu(menuId);
		return OrderMenuDAO.addOrderMenu(menuId);
	}
	
	// OrderMenu menu 수정
	public boolean updateOrderMenu(String orderId, String orderMenuId) throws SQLException {
		return OrderMenuDAO.updateOrderMenu(orderId, orderMenuId);
	}
	
	// OrderMenu menu 삭제
	public boolean deleteOrderMenu(String orderMenuId) throws SQLException {
		return OrderMenuDAO.deleteOrderMenu(orderMenuId);
	}
	
	
	
	/*============ MenuIngredient ===============*/
	//MenuIngredient - CRUD
	public void notExistMenuIngredient(String menuId) throws NotExistException, SQLException{
		ArrayList<MenuIngredientDTO> menuIngredient = MenuIngredientDAO.getMenuIngredientsByMenuId(menuId);
		if(menuIngredient.size() == 0){ // 이 경우 특별하게 null이 아닌 빈 공간으로 생성(PK가 아닌 값으로 검색했기 때문) 사이즈로 구분하였다.
			throw new NotExistException("검색하신 MenuIngredient가 없습니다.");
		}
	}
	
	
	// 메뉴id로 관련 MenuIngredient 가져오기
	public ArrayList<MenuIngredientDTO> getMenuIngredientsByMenuId(String menuId) throws SQLException, NotExistException{
		notExistMenuIngredient(menuId);
		return MenuIngredientDAO.getMenuIngredientsByMenuId(menuId);
	}
	
	
	
}
