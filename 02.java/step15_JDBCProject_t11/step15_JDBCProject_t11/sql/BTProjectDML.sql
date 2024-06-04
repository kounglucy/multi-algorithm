-- INSERT
INSERT INTO donor VALUES('donor1', '헌혈1', 12, 'M', 'A-', '봉사');
INSERT INTO donor VALUES('donor2', '헌혈2', 67, 'F', 'B-', '검사');
INSERT INTO donor VALUES('donor3', '헌혈3', 35, 'F', 'O-', '봉사');

INSERT INTO recipient VALUES('recipient1', '수혈1', 23, 'F', 'A-', '사고');
INSERT INTO recipient VALUES('recipient2', '수혈2', 21, 'F', 'B-', '사고');
INSERT INTO recipient VALUES('recipient3', '수혈3', 3, 'M', 'O-', '질병');

INSERT INTO bt_project VALUES('A-', 'bt1', 'donor1', 'recipient1', 'A-형간의 수혈');
INSERT INTO bt_project VALUES('B-', 'bt2', 'donor2', 'recipient2', 'B-형간의 수혈');
INSERT INTO bt_project VALUES('O-', 'bt3', 'donor3', 'recipient3', 'O-형간의 수혈');

COMMIT;
