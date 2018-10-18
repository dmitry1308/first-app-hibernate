use first_app_hibernate;

create table cars
	(
		id int auto_increment primary key,
        marka varchar(15),
        model varchar(15),
        user_id int
	);

alter table cars add constraint ix_user_id foreign key(user_id) references users(id);


-- drop database first_app_hibernate;