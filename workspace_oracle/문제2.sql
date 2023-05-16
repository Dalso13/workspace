-- 1. å ���̺��� �����Ͻÿ�. [ book ]
create table book(
    bookid number PRIMARY key,
    bookname VARCHAR2(50),
    publisher VARCHAR2(50),
    price   number);

--  2. �� ���̺��� �����Ͻÿ� [ customer ]
create table customer(
    customerid  number PRIMARY key,
    name VARCHAR2(20),
    address VARCHAR2(50),
    phone   VARCHAR2(20));
    
--  3. �ֹ� ���̺��� �����Ͻÿ� [ orders ]
create table orders(
    orderid   number PRIMARY key,
    customerid  number REFERENCES customer(customerid),
    bookid  number REFERENCES book(bookid),
    saleprice   number,
    orderdate   date );

insert into book values (1, '�౸�ǿ���', '�½�����', 7000);
insert into book values (2, '�౸�ƴ¿���', '������', 13000);
insert into book values (3, '�౸������', '���ѹ̵��', 22000);
insert into book values (4, '�������̺�', '���ѹ̵��', 35000);
insert into book values (5, '�ǰܱ���', '�½�����', 6000);
insert into book values (6, '�����ܰ躰���', '�½�����', 6000);
insert into book values (7, '�߱����߾�', '�̻�̵��', 20000);
insert into book values (8, '�߱�����Ź��', '�̻�̵��', 13000);
insert into book values (9, '�ø����̾߱�', '�Ｚ��', 7500);
insert into book values (10, '�ø���è�Ǿ�', '�Ǿ', 13000);

insert into customer values (1, '������', '���� ��ü����', '010-0000-0000');
insert into customer values (2, '�迬��', '���ѹα� ����', '010-1111-1111');
insert into customer values (3, '��̶�', '���ѹα� ������', '010-2222-2222');
insert into customer values (4, '�߽ż�', '�̱� �ػ罺', '010-4444-4444');
insert into customer values (5, '�ڼ���', '���ѹα� ����', '010-5555-5555');

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

-- 4. bookid�� 1�� å�� �̸��� ����Ͻÿ�.
select bookname from book
where bookid = 1;

--  5. ������ 20000�� �̻��� å�� �̸��� ��� ����Ͻÿ�.
select bookname from book
where price >= 20000;

--  6. ���ǻ� �ߺ��� �����Ͽ� ����Ͻÿ�.
select DISTINCT publisher from book;

--  7. �� �Ǹŵ� å�� ������ ���ϰ�, �÷����� '���Ǹž�'���� ����Ͻÿ�.
select sum(saleprice) as "���Ǹž�" from orders;

--  8. �������� �� ���ž��� ���Ͻÿ�.
select sum(saleprice)  from orders
where  customerid   = (select customerid from customer
                        where name = '������');
        -- join ���� �غ���
    select sum(saleprice) from orders left OUTER join customer
    on orders.customerid = customer.customerid
    where customer.name = '������';

--  9. �������� ������ ���� ���� ���Ͻÿ�.
select count(saleprice)  from orders
where   customerid   = (select customerid from customer
                        where name = '������');
        -- join ���� �غ���  
    select count(saleprice) from orders left OUTER join customer
    on orders.customerid = customer.customerid
    where customer.name = '������';
                        
--  10. 2014�� 7�� 4�Ϻ��� 7�� 7�� ���̿� �ֹ� ���� �ֹ� ������ ����Ͻÿ�. (+@ �Ⱓ ���� ���� ���)
select orderid,customerid,bookid,saleprice from orders
where orderdate BETWEEN '2014-07-04' and '2014-07-07';

--  11. �ֹ��� ���� ���� ���� �̸��� ����Ͻÿ�. 
select name from customer left OUTER join orders
on customer.customerid  = orders.customerid
where orders.customerid is null;

--  12. �������� ������ ������ ���ǻ� ��(�ߺ�����)�� ����Ͻÿ�.
select DISTINCT count(publisher) from book 
where bookid in (select  orders.bookid from orders left OUTER join customer
        on orders.customerid = customer.customerid
        where customer.name = '������');
        
--  13. ���� ��� �̸��� ���� �� ���ž��� �Բ� ����Ͻÿ�.
SELECT customer.name, sum(orders.saleprice)
from customer left outer join orders
on orders.customerid = customer.customerid
group by customer.name;

--  13-1. ���� ������ �ִ� ���� �̸��� ���� �� ���ž��� �Բ� ����Ͻÿ�.
SELECT customer.name, sum(orders.saleprice)
from customer right outer join orders   -- ���� ���̺��� �����̳� �������̳� ����
on orders.customerid = customer.customerid
group by customer.name;

--  13-2. ���� ��� �̸��� ���� �� ���ž��� �Բ� ����ϵ� ���� ������ ���� ���� ���� �ݾ��� 0���� ����Ͻÿ�.
SELECT customer.name, nvl(sum(orders.saleprice),0)  -- nvl �Ἥ null �� �ٲ㼭 ���
from customer left outer join orders
on orders.customerid = customer.customerid
group by customer.name;
