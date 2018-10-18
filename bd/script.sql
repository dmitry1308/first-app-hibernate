drop database many_to_many_lesson;

CREATE DATABASE many_to_many_lesson ;

use many_to_many_lesson;


CREATE TABLE  cars (
  id   int auto_increment PRIMARY KEY,
  marka VARCHAR(25),
  model VARCHAR(25)
);

INSERT INTO cars (marka, model) VALUES ('ford', 'dscds');
INSERT INTO cars (marka, model) VALUES ('ford', 'dscsdv');
INSERT INTO cars (marka, model) VALUES ('mazda', 'bgfba');


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


CREATE TABLE  cars_users (
  car_id int NOT NULL,
  user_id int NOT NULL,
  PRIMARY KEY (car_id, user_id),
  CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES users (id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES cars (id)
);

INSERT INTO cars_users (car_id, user_id) VALUES (1, 1);
INSERT INTO cars_users (car_id, user_id) VALUES (1, 2);

INSERT INTO cars_users (car_id, user_id) VALUES (2, 1);
INSERT INTO cars_users (car_id, user_id) VALUES (2, 2);