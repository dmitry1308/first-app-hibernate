drop DATABASE one_to_many_lesson;

CREATE DATABASE one_to_many_lesson;

use one_to_many_lesson;


CREATE TABLE IF NOT EXISTS cars (
  id   int auto_increment PRIMARY KEY ,
  cost INT,
  mark VARCHAR(25)
);

INSERT INTO cars (mark, cost) VALUES ('ford', 100000);
INSERT INTO cars (mark, cost) VALUES ('ford', 10984673);
INSERT INTO cars (mark, cost) VALUES ('mazda', 10984673);


CREATE TABLE IF NOT EXISTS engines (
  id       int PRIMARY KEY auto_increment,
  name     VARCHAR(25) NOT NULL,
  power    int     NOT NULL,
  car_mark VARCHAR(25)
);

INSERT INTO engines (name, power, car_mark) VALUES ('super-engine', 10000, 'ford');