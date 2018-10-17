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

-- drop database first_app_hibernate;