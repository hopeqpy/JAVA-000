DELIMITER //
CREATE PROCEDURE insert_function (count INT UNSIGNED)
BEGIN
DECLARE i INT UNSIGNED DEFAULT 1;
WHILE i <= count DO
INSERT INTO `t_user` values (i,'姓名',0,'倪晨',NOW(),1,NOW(),NOW(),'地址','sdasf','dasfsa',1,0,'132421431','3213124214')
SET i=i+1;
END WHILE;
END;
//