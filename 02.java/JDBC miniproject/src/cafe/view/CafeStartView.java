package cafe.view;

import java.time.LocalDateTime;

import cafe.controller.CafeController;

public class CafeStartView {
	public static void main(String[] args) {
		CafeController controller = CafeController.getInstance();
		
		// 모든 Ingredient 출력
//		controller.getAllIngredients();
		
		// 특정 Ingredient 출력
//		controller.getIngredient("i1");
		
		// Ingredient 추가
//		controller.addIngredient(new IngredientDTO("i2", "lemon", 500, 3));
//		controller.getAllIngredients();
		
		// Ingredient price 업데이트
//		controller.updateIngredientPrice("i1", 1000);
//		controller.getAllIngredients();
		
		// Ingredient stock 업데이트
//		controller.updateIngredientStock("i1", 10);
//		controller.getAllIngredients();
		
		// Ingredient 삭제
//		controller.deleteIngredient("i1");
		
		
		/* ======================== OrderMenu ====================== */
		
		// 모든 OrderMenu 출력
//		System.out.println("=====모든 OrderMenu 검색=====");
		controller.getAllOrderMenus();
		
		// 특정 OrderMenu 출력
//		System.out.println("=====특정 OrderMenu 검색=====");
//		controller.getOrderMenu("ORDER2");
		
		// OrderMenu 추가
//		controller.addOrderMenu("M3");
		
		// 주문목록 수정
//		System.out.println("=====주문목록 수정=====");
//		controller.updateOrderMenu("om1", "M2");
//		controller.getAllOrderMenus();
		
//		 주문목록 삭제
//		System.out.println("=====주문목록 삭제=====");
//		controller.deleteOrderMenu("om1");
//		controller.getAllOrderMenus();
		/* ======================== MenuIngredient ====================== */
		// menuId로 관련 MenuIngredient 출력
//		controller.showMenuIngredientsByMenuId("M6");
		
		
		
	/* ======================== Menu ====================== */
		
		// 모든 Menu 출력 
//		System.out.println("==== 1. 모든 menu 출력 ====");
//		controller.getAllMenus();
		
		// 특정 Menu 출력
//		System.out.println("==== 2. 특정 Menu 출력 ====");
//		controller.getMenu("m1");
		
		// Menu 추가 
//		System.out.println("==== 3. menu 추가 ====");
//		controller.addMenu(new MenuDTO("m2","메뉴6",6500,"라떼"));
//		controller.getAllMenus();
//		
		
		// Menu Name 수정 
//		System.out.println("==== 4. Menu Name 수정 ==== ");
//		controller.updateMenuName("m1", "메뉴7");
//		controller.getAllMenus();
		
		
		// Menu Price 수정
//		System.out.println("==== 5. Menu Price 수정 ====");
//		controller.updateMenuPrice("m1", 7000);
//		controller.getAllMenus();
	
//		 Menu 삭제 
//		System.out.println("==== 6. menu 삭제 ====");
//		controller.deleteMenu("m1");
		
		// 존재하지 않는 메뉴 : 예외 처리 
//		System.out.println("==== 7. 존재하지 않는 메뉴 : 예외 처리 ==== ");
//		controller.getMenu("m8");
		
		
		
		
		
	}
}
