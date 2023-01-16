
-- SpringAOP > db.sql

-- 회원
create table tblAOPMember (
    id varchar2(30) primary key,
    name varchar2(30) not null,
    lv char(1) not null             -- 1 (일반회원), 2 (관리자)
);

insert into tblAOPMember values('hong', '홍길동', '1');
insert into tblAOPMember values('test', '테스트', '1');
insert into tblAOPMember values('admin', '관리자', '2');


-- 게시판
create table tblAOPBoard (
    seq number primary key,
    subject varchar2(1000) not null,
    content varchar2(1000) not null,
    regdate date default sysdate not null,
    id varchar2(30) not null references tblAOPMember(id)
);

create sequence seqAOPBoard;


-- 로그 (어떤 회원? 어떤 페이지? 언제 방문?)
create table tblAOPLog (
    seq number primary key,
    id varchar2(30) not null references tblAOPMember(id),
    url varchar2(300) not null,
    regdate date default sysdate not null
);

create sequence seqAOPLog;



select * from tblAOPMember;
select * from tblAOPBoard;
select * from tblAOPLog;



