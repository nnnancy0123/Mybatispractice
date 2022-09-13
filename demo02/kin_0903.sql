create table kin_0903 (
  id character varying
  , name character varying
  , age character varying
  , primary key (id)
);

select * from kin_0903;

drop table kin_0903;

insert into kin_0903(id,name,age)values('02','b','15');
