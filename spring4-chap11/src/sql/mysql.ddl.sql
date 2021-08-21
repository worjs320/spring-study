--테이블 생성
create table guestmessage
(
    id           int auto_increment primary key,
    name         varchar(100),
    message      text,
    creationTime datetime
);

create table person
(
    num    int auto_increment primary key,
    name   varchar(100),
    gender varchar(100),
    age    number,
    birth  datetime
);