DROP TABLE TRADING;
DROP TABLE INVESTOR;
DROP TABLE STOCKS;



-- INVESTOR TABLE
CREATE TABLE scott.investor (
    user_id    VARCHAR2(20 BYTE) NOT NULL,
    password   VARCHAR2(20 BYTE),
    user_name  VARCHAR2(20 BYTE),
    user_money NUMBER
);


ALTER TABLE scott.investor
    ADD CONSTRAINT investor_pk PRIMARY KEY ( user_id );
        
-- STOCKS TABLE     
        
CREATE TABLE scott.stocks (
    stocks_code  VARCHAR2(20 BYTE) NOT NULL,
    price        NUMBER,
    company_name VARCHAR2(20 BYTE),
    asset   NUMBER,
    debt NUMBER,
    sales NUMBER,
    stockdate Date
);


ALTER TABLE scott.stocks
    ADD CONSTRAINT stocks_pk PRIMARY KEY ( stocks_code );
   
        
--TRADING TABLE        
        

CREATE TABLE scott.trading (
    trading_id    VARCHAR2(20 BYTE) NOT NULL,
    stocks_code   VARCHAR2(20 BYTE),
    user_id       VARCHAR2(20 BYTE),
    volume        NUMBER,
    trading_price NUMBER,
    status        VARCHAR2(20 BYTE)
);


ALTER TABLE scott.trading
    ADD CONSTRAINT trading_pk PRIMARY KEY ( trading_id );
       

ALTER TABLE scott.trading
    ADD CONSTRAINT trading_investor_fk FOREIGN KEY ( user_id )
        REFERENCES scott.investor ( user_id );
    

ALTER TABLE scott.trading
    ADD CONSTRAINT trading_stocks_fk FOREIGN KEY ( stocks_code )
        REFERENCES scott.stocks ( stocks_code );
  
    



insert into investor values ('kim08', 'thispasskk', 'kim', 1000000);
INSERT INTO INVESTOR VALUES('hello','world','choi',1000000);
INSERT INTO INVESTOR VALUES('rhkrhk','6503','kwak',1100000);
INSERT INTO investor VALUES('hong2', '0205', 'hong', 1000000);
INSERT INTO INVESTOR VALUES('lilili','stay','cho',1000000);



INSERT INTO STOCKS VALUES('1',65000,'SAMSUNG',448424500,93674900,302231360,sysDate);

INSERT INTO STOCKS VALUES('2',85000,'SK',103871512, 40580970,44621568,sysDate);
INSERT INTO STOCKS VALUES('3',90000,'KIA',73710965,34367884,86559029,sysDate);
INSERT INTO STOCKS VALUES('4',70000,'LG',150710965,33678844,246559029,sysDate);

insert into trading values ('1', '1', 'kim08', 1,100000,'sale');
insert into trading values ('2', '1', 'kim08', 2,100000,'sale');

select * from INVESTOR;
select * from STOCKS ;
select * from trading ;



commit;

