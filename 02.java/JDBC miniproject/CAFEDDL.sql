DROP TABLE INGREDIENT;
CREATE TABLE INGREDIENT (
    ingredient_id       VARCHAR2(20 BYTE) NOT NULL,        
    
    ingredient_name     VARCHAR2(20 BYTE) NOT NULL,
    ingredient_price    NUMBER(20) NOT NULL,
    ingredient_stock    NUMBER(20) NOT NULL
);
/

ALTER TABLE INGREDIENT 
    ADD CONSTRAINT ingredient_pk PRIMARY KEY (ingredient_id );
/

DROP TABLE MENU;
CREATE TABLE MENU (
    menu_id       VARCHAR2(20 BYTE) NOT NULL,        
    
    menu_name     VARCHAR2(20 BYTE) NOT NULL,
    menu_price    NUMBER(20) NOT NULL,
    menu_type     VARCHAR2(20) NOT NULL
);
/


ALTER TABLE MENU 
    ADD CONSTRAINT menu_pk PRIMARY KEY (menu_id );
/

DROP TABLE MENU_INGREDIENT;
CREATE TABLE MENU_INGREDIENT (
    m_i_id              VARCHAR2(20) NOT NULL,            
    
    menu_id             VARCHAR2(20 BYTE) NOT NULL,
    ingredient_id       VARCHAR2(20 BYTE) NOT NULL
);    
/
 
ALTER TABLE MENU_INGREDIENT 
    ADD CONSTRAINT m_i_pk PRIMARY KEY (m_i_id );
/
 
ALTER TABLE MENU_INGREDIENT
    ADD FOREIGN KEY ( menu_id )
        REFERENCES MENU ( menu_id )
            ON DELETE CASCADE
    NOT DEFERRABLE;  
/

ALTER TABLE MENU_INGREDIENT
    ADD FOREIGN KEY ( ingredient_id )
        REFERENCES INGREDIENT ( ingredient_id )
            ON DELETE CASCADE
    NOT DEFERRABLE;      
/ 

DROP TABLE ORDER_MENU;
CREATE TABLE ORDER_MENU (
    order_id            VARCHAR2(20) NOT NULL,            
    
    order_date          DATE NOT NULL,
    menu_id          VARCHAR2(50) NOT NULL
);    
/

ALTER TABLE ORDER_MENU 
    ADD CONSTRAINT order_pk PRIMARY KEY (order_id );
/

ALTER TABLE ORDER_MENU
    ADD FOREIGN KEY ( menu_id )
        REFERENCES MENU ( menu_id )
            ON DELETE CASCADE
    NOT DEFERRABLE;      
/ 

/*
om1 주문 : a b c d

주문상세 table 
m1 om1 a
m2 om1 b
m3 om1 c
m4 om1 d
*/





    