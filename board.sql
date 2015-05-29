

-- 2. 테이블 생성
create table board (

	num 	 	 number 			primary key,
	name 		 varchar2(10),
	title		 varchar2(100),
	content		 varchar2(1000),
	hits 		 number 			default 0,
	wdate 	 	 date 				default sysdate,
	attachment   varchar2(50)
)

-- 3. 시퀀스 생성
create sequence board_seq


insert into board
values(board_seq.nextval, '리진규', '홍홍', 'aa', default, default, '303.txt')




select * from board order by num desc

delete from 