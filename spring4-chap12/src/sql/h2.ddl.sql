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

truncate shop.PAYMENT_INFO;
truncate shop.PURCHASE_ORDER;