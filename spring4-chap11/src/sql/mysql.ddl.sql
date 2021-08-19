--테이블 생성
create table guestbook.guestmessage (
	id int auto_increment primary key,
	name varchar(100),
	message text,
	creationTime datetime
) engine=InnoDB character set = utf8;
