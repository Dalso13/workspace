-- 1. 회원 시퀀스를 생성하시오. [ user_seq ]
CREATE SEQUENCE USER_SEQ START WITH 1 INCREMENT BY 1;

-- 2. 회원 테이블을 생성하시오. [ userTable ]
CREATE TABLE userTable(
    userNo number PRIMARY key,
    userId VARCHAR2(20) not null unique,
    userPw VARCHAR2(20) not null,
    userTel VARCHAR2(20) unique,
    userMembership VARCHAR2(10) CHECK (userMembership IN ('gold','silver','bronze')),
    userEmail VARCHAR2(20) unique,
    userPoint number default 1000,
    joinDate date default sysdate);
    
-- 3. 적절한 데이터 5개 이상 삽입

insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id01', '1111', '010-1111-1111', 'gold', 'id01@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id02', '1111', '010-1111-2222', 'silver', 'id02@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id03', '1111', '010-1111-3333', 'bronze', 'id03@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id04', '1111', '010-1111-4444', 'gold', 'id04@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id05', '1111', '010-1111-5555', 'silver', 'id05@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id06', '1111', '010-1111-6666', 'bronze', 'id06@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id07', '1111', '010-1111-7777', 'gold', 'id07@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id08', '1111', '010-1111-8888', 'silver', 'id08@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id09', '1111', '010-1111-9999', 'bronze', 'id09@aa.com');
insert into userTable (userNo, userId, userPw, userTel, userMembership, userEmail) values (user_seq.nextval, 'id10', '1111', '010-1111-0000', 'gold', 'id10@aa.com');
commit;

TRUNCATE table usertable;
select * from usertable;

--4. 다음 질의문을 처리하시오.
-- 1) userNo 이 5 이상인 회원을 검색하시오.

select * from usertable
where userno >= 5;

--  2) userNo 이 3 ~ 7 사이인 회원을 검색하시오.

select * from usertable
where userno BETWEEN 3 and 7;

--  3) userTel 마지막 4자리가 '5555' 인 회원을 검색하시오

select * from usertable
where userTel LIKE '%-5555';

--  4) userMembership 이 'gold' 인 회원의 userPoint 평균을 출력하시오. 

select avg(userpoint) from usertable
where usermembership = 'gold';

--  5) userId 가 'id03' 인 회원의 joinDate 를 '19/10/28/'로 수정하시오.

update usertable
set joindate = '19/10/28'
where userid = 'id03';

-- 6) userMembership 이 'gold' 인 회원들의 userPoint 를 모두 3배 증가시키시오.

update usertable
set userpoint = userpoint * 3
where usermembership = 'gold';

--  7) userId 가 'id08' 인 회원의 userPw 를 '2222'로 수정하시오.

update usertable
set userpw = '2222'
where userid = 'id08';

--  8) userMembership 이 'bronze' 인 회원들 중에서 
--  userPoint 가 1000 이상인 회원들의 userMembership 을 'silver'로 수정하시오.

update usertable
set usermembership = 'silver'
where usermembership = 'bronze' and userpoint >= 1000;

--  9) userNo 가 5 인 회원을 삭제하시오.
DELETE usertable
where userNo = 5;

rollback;


