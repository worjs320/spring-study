DROP TABLE EMPLOYEE;
DROP TABLE TEAM;

-- company DB에 아래 테이블 생성
create table EMPLOYEE (
	EMPLOYEE_ID int auto_increment primary key,
	EMPLOYEE_NUM varchar(10),
	NAME varchar(100),
	HOME_ADDR1 varchar(200),
	HOME_ADDR2 varchar(200),
	HOME_ZIPCODE varchar(10),
	BIRTH_YEAR int,
	TEAM_ID int,
	JOINED_DATE date
);

create table TEAM (
	TEAM_ID int auto_increment primary key,
	NAME varchar(100)
);

-- 테스트 목록 초기 데이터
insert into TEAM values (1, 'BR팀');

insert into EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1', '발악', '서울시 관악구', '신사동', '151872', 1977, 1, '2011-07-01');

insert into EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('2', '홍길동', '전라남도 장성군', '황룡면', '515813', 1983, 1, '2013-01-02');

insert into EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('3', '이순신', '서울시 중구', '인현동', '100282', 1982, 1, '2013-02-01');

insert into EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('4', '김구', '황해도 해주', '백운방 텃골', '111222', 1979, 1, '2013-03-01');

insert into EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('5', '전길남', '일본', '오사카', 'XXXYYY', 1943, 1, '2014-01-02');

insert into EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567895', '제임스고슬링', '캐나다', '어딘가', 'XXXYYY', 1955, 1, '2014-06-01');

create table PERSON (
    PERSON_ID int auto_increment primary key,
    NAME varchar(100),
    GENDER varchar(10),
    EMAIL varchar(50),
    BIRTHDAY date
);

create table PHONE (
    PERSON_ID int,
    PHONE_NUMBER varchar(100)
);

insert into PERSON (PERSON_ID, NAME, GENDER, EMAIL, BIRTHDAY) values (1, '발악', '남', 'barak@naver.com', 2000-03-20);
insert into PERSON (PERSON_ID, NAME, GENDER, EMAIL, BIRTHDAY) values (2, '발악2', '남2', 'barak@naver.com', 2000-03-21);
insert into PHONE (PERSON_ID, PHONE_NUMBER) values (1, '010-1233-1233');