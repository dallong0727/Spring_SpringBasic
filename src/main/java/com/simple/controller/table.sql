create table score (
    num number(10,0),
    name varchar2(50),
    kor varchar2(50),
    eng varchar2(50),
    math varchar2(50) 
);

alter table score add constraint score_pk primary key (num);
create sequence score_req increment by 1 start with 1 nocache;
select * from score;

create table board (
    num number(10,0),
    name varchar2(50),
    title varchar2(50),
    content varchar2(50)
);

alter table board add constraint board_pk primary key (num);
create sequence board_seq increment by 1 start with 1 nocache;
select * from board;