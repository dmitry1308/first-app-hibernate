drop database first_app_hibernate;

create database first_app_hibernate;

use first_app_hibernate;

create table users
    (
        id int auto_increment primary key,
        name varchar(50),
        age int,
        birthday date
	);

insert users (name,age,birthday) values
		('Schepin  Dmitriy',32,'1986.08.13'),
		('Hohlov Roman',32,'1985.07.05');



create table cars
	(
		id int auto_increment primary key,
        marka varchar(15),
        model varchar(15),
        user_id int
	);

alter table cars add constraint ix_user_id foreign key(user_id) references users(id);




Alter table cars add column engine_id varchar(25);

create table engine 
	(
		id int auto_increment primary key,
		model varchar(25)
    );

alter table cars change engine_id engine_id int; 
alter table cars add constraint ix_engine_id foreign key(engine_id) references engine(id);







