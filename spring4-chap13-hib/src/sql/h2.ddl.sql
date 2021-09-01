-- shop DB에 아래 테이블 생성
create table ITEM (
	ITEM_ID int auto_increment primary key,
	PRICE INT
);

create table PAYMENT_INFO (
	PAYMENT_INFO_ID int auto_increment primary key,
	PRICE INT
);

create table PURCHASE_ORDER (
	PURCHASE_ORDER_ID int auto_increment primary key,
	ITEM_ID INT,
	PAYMENT_INFO_ID INT,
	ADDRESS varchar(255)
);

insert into ITEM values (1, 15000);

truncate TABLE  PAYMENT_INFO;
truncate TABLE PURCHASE_ORDER;