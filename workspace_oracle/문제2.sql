-- 1. 책 테이블을 생성하시오. [ book ]
create table book(
    bookid number PRIMARY key,
    bookname VARCHAR2(50),
    publisher VARCHAR2(50),
    price   number);

--  2. 고객 테이블을 생성하시오 [ customer ]
create table customer(
    customerid  number PRIMARY key,
    name VARCHAR2(20),
    address VARCHAR2(50),
    phone   VARCHAR2(20));
    
--  3. 주문 테이블을 생성하시오 [ orders ]
create table orders(
    orderid   number PRIMARY key,
    customerid  number REFERENCES customer(customerid),
    bookid  number REFERENCES book(bookid),
    saleprice   number,
    orderdate   date );

insert into book values (1, '축구의역사', '굿스포츠', 7000);
insert into book values (2, '축구아는여자', '나무수', 13000);
insert into book values (3, '축구의이해', '대한미디어', 22000);
insert into book values (4, '골프바이블', '대한미디어', 35000);
insert into book values (5, '피겨교본', '굿스포츠', 6000);
insert into book values (6, '역도단계별기술', '굿스포츠', 6000);
insert into book values (7, '야구의추억', '이상미디어', 20000);
insert into book values (8, '야구를부탁해', '이상미디어', 13000);
insert into book values (9, '올림픽이야기', '삼성당', 7500);
insert into book values (10, '올림픽챔피언', '피어슨', 13000);

insert into customer values (1, '박지성', '영국 맨체스터', '010-0000-0000');
insert into customer values (2, '김연아', '대한민국 서울', '010-1111-1111');
insert into customer values (3, '장미란', '대한민국 강원도', '010-2222-2222');
insert into customer values (4, '추신수', '미국 텍사스', '010-4444-4444');
insert into customer values (5, '박세리', '대한민국 대전', '010-5555-5555');

insert into orders values (1, 1, 1, 6000, '2014-07-01');
insert into orders values (2, 1, 3, 21000, '2014-07-03');
insert into orders values (3, 2, 5, 8000, '2014-07-03');
insert into orders values (4, 3, 6, 6000, '2014-07-04');
insert into orders values (5, 4, 7, 20000, '2014-07-07');
insert into orders values (6, 1, 2, 12000, '2014-07-07');
insert into orders values (7, 4, 8, 13000, '2014-07-07');
insert into orders values (8, 3, 10, 12000, '2014-07-08');
insert into orders values (9, 2, 10, 7000, '2014-07-09');
insert into orders values (10, 3, 8, 13000, '2014-07-10');

commit;
select * from book;
select * from customer;
select * from orders;

-- 4. bookid가 1인 책의 이름을 출력하시오.
select bookname from book
where bookid = 1;

--  5. 가격이 20000원 이상인 책의 이름을 모두 출력하시오.
select bookname from book
where price >= 20000;

--  6. 출판사 중복을 제거하여 출력하시오.
select DISTINCT publisher from book;

--  7. 총 판매된 책의 가격을 구하고, 컬럼명을 '총판매액'으로 출력하시오.
select sum(saleprice) as "총판매액" from orders;

--  8. 박지성의 총 구매액을 구하시오.
select sum(saleprice)  from orders
where  customerid   = (select customerid from customer
                        where name = '박지성');
        -- join 으로 해보기
    select sum(saleprice) from orders left OUTER join customer
    on orders.customerid = customer.customerid
    where customer.name = '박지성';

--  9. 박지성의 구매한 도서 수를 구하시오.
select count(saleprice)  from orders
where   customerid   = (select customerid from customer
                        where name = '박지성');
        -- join 으로 해보기  
    select count(saleprice) from orders left OUTER join customer
    on orders.customerid = customer.customerid
    where customer.name = '박지성';
                        
--  10. 2014년 7월 4일부터 7월 7일 사이에 주문 받은 주문 정보를 출력하시오. (+@ 기간 제외 정보 출력)
select orderid,customerid,bookid,saleprice from orders
where orderdate BETWEEN '2014-07-04' and '2014-07-07';

--  11. 주문한 적이 없는 고객의 이름을 출력하시오. 
select name from customer left OUTER join orders
on customer.customerid  = orders.customerid
where orders.customerid is null;

--  12. 박지성이 구매한 도서의 출판사 수(중복없이)를 출력하시오.
select DISTINCT count(publisher) from book 
where bookid in (select  orders.bookid from orders left OUTER join customer
        on orders.customerid = customer.customerid
        where customer.name = '박지성');
        
--  13. 고객의 모든 이름과 고객별 총 구매액을 함께 출력하시오.
SELECT customer.name, sum(orders.saleprice)
from customer left outer join orders
on orders.customerid = customer.customerid
group by customer.name;

--  13-1. 구매 내역이 있는 고객의 이름과 고객별 총 구매액을 함께 출력하시오.
SELECT customer.name, sum(orders.saleprice)
from customer right outer join orders   -- 기준 테이블이 왼쪽이냐 오른쪽이냐 차이
on orders.customerid = customer.customerid
group by customer.name;

--  13-2. 고객의 모든 이름과 고객별 총 구매액을 함께 출력하되 구매 내역이 없는 고객의 구매 금액은 0으로 출력하시오.
SELECT customer.name, nvl(sum(orders.saleprice),0)  -- nvl 써서 null 값 바꿔서 출력
from customer left outer join orders
on orders.customerid = customer.customerid
group by customer.name;
