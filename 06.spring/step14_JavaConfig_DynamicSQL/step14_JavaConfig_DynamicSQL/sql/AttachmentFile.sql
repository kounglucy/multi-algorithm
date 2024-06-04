DROP TABLE attachment_file;

CREATE TABLE attachment_file
(
    attachment_file_no NUMBER,
	file_path VARCHAR(255),
	attachment_file_name VARCHAR(255),
	attachment_original_file_name VARCHAR(255),
	registered_date DATE,
	attachment_file_size NUMBER,
	deptno NUMBER,
    PRIMARY KEY(attachment_file_no)
);

CREATE SEQUENCE seq_attachment_file_no
	START WITH 1
	INCREMENT BY 1;

COMMIT;