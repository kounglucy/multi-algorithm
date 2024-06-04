-- Ingredient : (id, name, price, stock)
INSERT INTO INGREDIENT VALUES('I1', '재료1', 700, 10);
INSERT INTO INGREDIENT VALUES('I2', '재료2', 200, 10);
INSERT INTO INGREDIENT VALUES('I3', '재료3', 1000, 10);
INSERT INTO INGREDIENT VALUES('I4', '재료4', 400, 10);
INSERT INTO INGREDIENT VALUES('I5', '재료5', 2000, 10);

-- Menu : (ID, NAME, PRICE, TYPE)
INSERT INTO MENU VALUES ('M1', '메뉴1', 4500, '커피');
INSERT INTO MENU VALUES ('M2', '메뉴2', 5500, '스무디');
INSERT INTO MENU VALUES ('M3', '메뉴3', 6500, '차');
INSERT INTO MENU VALUES ('M4', '메뉴4', 6000, '커피');
INSERT INTO MENU VALUES ('M5', '메뉴5', 4000, '차');

-- MenuIngredient : (m_i_id, m_id, i_id)
INSERT INTO MENU_INGREDIENT VALUES('MI1', 'M1', 'I1');
INSERT INTO MENU_INGREDIENT VALUES('MI2', 'M1', 'I2');
INSERT INTO MENU_INGREDIENT VALUES('MI3', 'M1', 'I3');

INSERT INTO MENU_INGREDIENT VALUES('MI4', 'M2', 'I1');
INSERT INTO MENU_INGREDIENT VALUES('MI5', 'M2', 'I4');
INSERT INTO MENU_INGREDIENT VALUES('MI6', 'M2', 'I5');

INSERT INTO MENU_INGREDIENT VALUES('MI7', 'M3', 'I3');
INSERT INTO MENU_INGREDIENT VALUES('MI8', 'M3', 'I4');

INSERT INTO MENU_INGREDIENT VALUES('MI9', 'M4', 'I2');
INSERT INTO MENU_INGREDIENT VALUES('MI10', 'M4', 'I5');

INSERT INTO MENU_INGREDIENT VALUES('MI11', 'M5', 'I1');
INSERT INTO MENU_INGREDIENT VALUES('MI12', 'M5', 'I2');
INSERT INTO MENU_INGREDIENT VALUES('MI13', 'M5', 'I3');
INSERT INTO MENU_INGREDIENT VALUES('MI14', 'M5', 'I5');

-- OrderMenu : (order_id, order_date, menu_id)
INSERT INTO ORDER_MENU VALUES('O1', sysdate, 'M1');
INSERT INTO ORDER_MENU VALUES('O2', sysdate, 'M3');
INSERT INTO ORDER_MENU VALUES('O3', sysdate, 'M2');
INSERT INTO ORDER_MENU VALUES('O4', sysdate, 'M4');

    