-- Table
DROP TABLE donor CASCADE;
DROP TABLE recipient CASCADE;
DROP TABLE bt_project CASCADE;

CREATE TABLE donor (
       donor_id          	VARCHAR2(20) PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       age         			NUMBER(3) 	 NOT NULL,
       sex                	VARCHAR2(20) NOT NULL,
       blood_type          	VARCHAR2(20) NOT NULL,
       purpose_donation		VARCHAR2(50) NOT NULL
);

CREATE TABLE recipient (
       recipient_id         VARCHAR2(20) PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       age         			NUMBER(3)    NOT NULL,
       sex                	VARCHAR2(20) NOT NULL,
       blood_type          	VARCHAR2(20) NOT NULL,
       purpose_transfusion	VARCHAR2(50) NOT NULL
);


CREATE TABLE bt_project (
	   bt_project_name 		VARCHAR2(50)  NOT NULL,
	   bt_project_id    	VARCHAR2(50)  PRIMARY KEY,
       donor_id          	VARCHAR2(20)  NOT NULL,
       recipient_id         VARCHAR2(20)  NOT NULL, 
       bt_content    		VARCHAR2(100) NOT NULL
);


ALTER TABLE bt_project ADD FOREIGN KEY (recipient_id) REFERENCES recipient (recipient_id) ON DELETE CASCADE;
ALTER TABLE bt_project ADD FOREIGN KEY (donor_id)  REFERENCES donor (donor_id) ON DELETE CASCADE;