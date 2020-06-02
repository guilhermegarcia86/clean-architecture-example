drop table if exists user;

create table IF NOT EXISTS USER (
    ID integer auto_increment primary key,
    AGE int,
    NAME varchar(200),
    EMAIL varchar(200),
    PERSONALITY varchar(200),
    RANGER varchar(200)
  );