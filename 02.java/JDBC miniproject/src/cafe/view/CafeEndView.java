package cafe.view;

import java.util.ArrayList;

import cafe.dto.IngredientDTO;
import cafe.dto.MenuDTO;
import cafe.dto.MenuIngredientDTO;
import cafe.dto.OrderMenuDTO;

public class CafeEndView {
	/*============= Menu =====================*/
	// 모든 Menu 출력
	public static void showAllMenus(ArrayList<MenuDTO> allMenus) {
	       int length = allMenus.size();
		   if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("검색정보 " + (index+1) + " - " + allMenus.get(index));
		        }
	        }
		}
		
    // 특정 Menu 출력 
    public static void showmenus(MenuDTO menu) {
	   System.out.println(menu);
				
	}
	        
	// Menu 추가 
	public static void addMenuView(String menuId, boolean addMenu) {
		System.out.println("Menu, " + menuId + "가 추가되었습니다.");
				
	}
	
	// Menu 수정 
    public static void updateMenuView(String menuId, boolean updateMenuPrice) {
    	System.out.println("Menu, " + menuId + "가 업데이트되었습니다.");
		
	}
		
    // Menu 삭제 
	public static void deleteMenuView(String menuId, boolean deleteMenu) {
		System.out.println("Menu, " + menuId + "가 삭제되었습니다.");
		
	}


	
	
	/*============= Ingredient =====================*/
	// 모든 Ingredient 출력
	public static void showAllIngredients(ArrayList<IngredientDTO> allIngredients) {
		int length = allIngredients.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("검색정보 " + (index+1) + " - " + allIngredients.get(index));
			}
		}
	}
	
	// 특정 Ingredient 출력
	public static void showIngredients(IngredientDTO ingredient) {
		System.out.println(ingredient);
	}

	// Ingredient 추가
	public static void addIngredientView(String ingredientId, boolean addIngredient) {
		System.out.println("Ingredient, " + ingredientId + "가 추가되었습니다.");
	}

	// Ingredient 수정
	public static void updateIngredientView(String ingredientId, boolean updateIngredient) {
		System.out.println("Ingredient, " + ingredientId + "가 업데이트되었습니다.");
	}

	// Ingredient 삭제
	public static void deleteIngredientView(String ingredientId, boolean deleteIngredient) {
		System.out.println("Ingredient, " + ingredientId + "가 삭제되었습니다.");
	}

	
	/*============= OrderMenu =====================*/
	// 모든 OrderMenu 출력
	public static void showAllOrderMenus(ArrayList<OrderMenuDTO> allOrderMenus, ArrayList<MenuDTO> allMenus) {
		int orderMenuLength = allOrderMenus.size();
		int menuLength = allMenus.size();
		
		if( orderMenuLength != 0 && menuLength != 0 ){ // 
			
			for(int index1 = 0; index1 < orderMenuLength; index1++){
				for(int index2 = 0; index2 < menuLength; index2++) {
					if(allOrderMenus.get(index1).getOrderList().equals(allMenus.get(index2).getMenuId()))
						System.out.println("검색정보 " + (index1+1) + " - " + allOrderMenus.get(index1) + " 가격 : " + allMenus.get(index2).getMenuPrice());
				}
			}
		}
	}

	// 특정 OrderMenu 출력
	public static void showOrderMenu(OrderMenuDTO orderMenu) {
		System.out.println(orderMenu);
	}
	
	// OrderMenu menu 수정
	public static void updateOrderMenu(String orderMenuId, boolean updateOrderMenu) {
		System.out.println("OrderMenu, " + orderMenuId + "가 수정되었습니다.");
	}
	
	// OrderMenu menu 삭제
	public static void deleteOrderMenu(String orderMenuId, boolean deleteOrderMenu) {
		System.out.println("OrderMenu, " + orderMenuId + "가 삭제되었습니다.");
	}
	
	/*============= MenuIngredient =====================*/
	// menuId로 관련 MenuIngredient 출력
	public static void showMenuIngredientsByMenuId(String menuId,
			ArrayList<MenuIngredientDTO> menuIngredientsByMenuId) {
		int length = menuIngredientsByMenuId.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("검색정보 " + (index+1) + " - " + menuIngredientsByMenuId.get(index));
			}
		}
	}

	public static void addOrderMenu(boolean addOrderMenu) {
		System.out.println("OrderMenu가 생성되었습니다.");
	}

}
