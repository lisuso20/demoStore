create database if not exists demoStore;
use demoStore;

CREATE TABLE if not exists telephone_store(
    id int auto_increment,
    category varchar(30) not null ,
    count_products int default 0,
    primary key (id)
);
CREATE TABLE if not exists music_store(
    id int auto_increment,
    category varchar(30) not null ,
    count_products int default 0,
    primary key (id)
);
CREATE TABLE if not exists products(
    title varchar(30) not null,
    category varchar(30) not null ,
    status varchar(30) not null,
    price int not null,
    primary key (title)
);

insert into telephone_store (category) values ('old_phones');
insert into telephone_store (category) values ('smartphones');
insert into music_store (category) values ('metal');
insert into music_store (category) values ('classic');