create table kin_userinfo (
  id character varying
  , name character varying
  , age character varying
  , primary key (id)
);

select * from kin_userinfo;

drop table kin_userinfo;

insert into kin_userinfo(id,name,age)values('02','b','15');

--https://medium-company.com/mybatis-spring/#edithtml
