DROP TABLE notice;

CREATE TABLE notice (
	no NUMBER PRIMARY KEY,
    user_id VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(50) NOT NULL,
    title VARCHAR2(255) NOT NULL,
    content VARCHAR2(255),
    hit NUMBER
);