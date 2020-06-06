drop table if exists user;

create table IF NOT EXISTS USER (
    ID varchar(200) primary key,
    AGE int,
    NAME varchar(200),
    EMAIL varchar(200),
    PERSONALITY varchar(200),
    RANGER varchar(200)
  );