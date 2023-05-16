-- 1. ȸ�� �������� �����Ͻÿ�. [ user_seq ]
CREATE SEQUENCE USER_SEQ START WITH 1 INCREMENT BY 1;

-- 2. ȸ�� ���̺��� �����Ͻÿ�. [ userTable ]
CREATE TABLE userTable(
    userNo number PRIMARY key,
    userId VARCHAR2(20) not null unique,
    userPw VARCHAR2(20) not null,
    userTel VARCHAR2(20) unique,
    userMembership VARCHAR2(10) CHECK (userMembership IN ('gold','silver','bronze')),
    userEmail VARCHAR2(20) unique,
    userPoint number default 1000,
    joinDate date default sysdate);
    
-- 3. ������ ������ 5�� �̻� ����

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

--4. ���� ���ǹ��� ó���Ͻÿ�.
-- 1) userNo �� 5 �̻��� ȸ���� �˻��Ͻÿ�.

select * from usertable
where userno >= 5;

--  2) userNo �� 3 ~ 7 ������ ȸ���� �˻��Ͻÿ�.

select * from usertable
where userno BETWEEN 3 and 7;

--  3) userTel ������ 4�ڸ��� '5555' �� ȸ���� �˻��Ͻÿ�

select * from usertable
where userTel LIKE '%-5555';

--  4) userMembership �� 'gold' �� ȸ���� userPoint ����� ����Ͻÿ�. 

select avg(userpoint) from usertable
where usermembership = 'gold';

--  5) userId �� 'id03' �� ȸ���� joinDate �� '19/10/28/'�� �����Ͻÿ�.

update usertable
set joindate = '19/10/28'
where userid = 'id03';

-- 6) userMembership �� 'gold' �� ȸ������ userPoint �� ��� 3�� ������Ű�ÿ�.

update usertable
set userpoint = userpoint * 3
where usermembership = 'gold';

--  7) userId �� 'id08' �� ȸ���� userPw �� '2222'�� �����Ͻÿ�.

update usertable
set userpw = '2222'
where userid = 'id08';

--  8) userMembership �� 'bronze' �� ȸ���� �߿��� 
--  userPoint �� 1000 �̻��� ȸ������ userMembership �� 'silver'�� �����Ͻÿ�.

update usertable
set usermembership = 'silver'
where usermembership = 'bronze' and userpoint >= 1000;

--  9) userNo �� 5 �� ȸ���� �����Ͻÿ�.
DELETE usertable
where userNo = 5;

rollback;


