package cafe.controller;

import java.sql.SQLException;

import cafe.dto.IngredientDTO;
import cafe.dto.MenuDTO;
import cafe.exception.NotExistException;
import cafe.service.CafeSerive;
import cafe.view.CafeEndView;

public class CafeController {
	private static CafeController instance = new CafeController();
	private CafeSerive service = CafeSerive.getInstance();
	
	private CafeController() {}
	
	public static CafeController getInstance() {
		return instance;
	}
	
	
	/*============ Menu ===============*/
	// 모든 Menu 출력 : getAllMenus();
	public void getAllMenus() {
		try {
			CafeEndView.showAllMenus(service.getAllMenus());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 Menu 출력 : getMenu();
	public void getMenu(String menuId) {
		try {
			CafeEndView.showmenus(service.getMenu(menuId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
		
	// Menu 추가 : addMenu();
	public void addMenu(MenuDTO menu) {
		try {
			CafeEndView.addMenuView(menu.getMenuId(), service.addMenu(menu));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Menu name 수정 
	public void updateMenuName(String menuId, String newMenuName) {
		try {
			CafeEndView.updateMenuView(menuId, service.updateMenuName(menuId, newMenuName));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
		
	// Menu price 수정 
	public void updateMenuPrice(String menuId, int newMenuPrice) {
		try {
			CafeEndView.updateMenuView(menuId, service.updateMenuPrice(menuId, newMenuPrice));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	
	// Menu 삭제
	public void deleteMenu(String menuId) {
		try {
			CafeEndView.deleteMenuView(menuId, service.deleteMenu(menuId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}

	/*============ Ingredient ===============*/
	// 모든 Ingredient 출력 : getAllIngredients();
	public void getAllIngredients() {
		try {
			CafeEndView.showAllIngredients(service.getAllIngredients());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 Ingredient 출력 : getIngredient();
	public void getIngredient(String ingredientId) {
		try {
			CafeEndView.showIngredients(service.getIngredient(ingredientId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// Ingredient 추가 : addIngredient();
	public void addIngredient(IngredientDTO ingredient) {
		try {
			CafeEndView.addIngredientView(ingredient.getIngredientId(), service.addIngredient(ingredient));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Ingredient price 업데이트
	public void updateIngredientPrice(String ingredientId, int newIngredientPrice) {
		try {
			CafeEndView.updateIngredientView(ingredientId, service.updateIngredientPrice(ingredientId, newIngredientPrice));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// Ingredient stock 업데이트
	public void updateIngredientNStock(String ingredientId, int newIngredientStock) {
		try {
			CafeEndView.updateIngredientView(ingredientId, service.updateIngredientNStock(ingredientId, newIngredientStock));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// Ingredient 삭제
	public void deleteIngredient(String ingredientId) {
		try {
			CafeEndView.deleteIngredientView(ingredientId, service.deleteIngredient(ingredientId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	
	/*============ OrderMenu ===============*/
	// 모든 OrderMenu 출력
	public void getAllOrderMenus() {
		try {
			CafeEndView.showAllOrderMenus(service.getAllOrderMenus(), service.getAllMenus());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 OrderMenu 출력
	public void getOrderMenu(String orderMenuId) {
		try {
			CafeEndView.showOrderMenu(service.getOrderMenu(orderMenuId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// OrderMenu 추가
	public void addOrderMenu(String menuId) {
		try {
			CafeEndView.addOrderMenu(service.addOrderMenu(menuId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// OrderMenu menu 수정
	public void updateOrderMenu(String orderId, String orderMenuId) {
		try {
			CafeEndView.updateOrderMenu(orderId, service.updateOrderMenu(orderId, orderMenuId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// OrderMenu menu 삭제
	public void deleteOrderMenu(String orderMenuId) {
		try {
			CafeEndView.deleteOrderMenu(orderMenuId, service.deleteOrderMenu(orderMenuId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	
	/*============ MenuIngredient ===============*/
	// 메뉴id로 관련 MenuIngredient 출력
	public void showMenuIngredientsByMenuId(String menuId) {
		try {
			CafeEndView.showMenuIngredientsByMenuId(menuId, service.getMenuIngredientsByMenuId(menuId));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
