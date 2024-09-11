CREATE SCHEMA `sda-jdbc-67`;
create table students(
    id int primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    age int,
    created_date date
);

insert into students(first_name, last_name, age, created_date) values('John', 'Denis', 25, current_date());
insert into students(first_name, last_name, age, created_date) values('Andrei', 'Jitaru', 19, current_date());
insert into students(first_name, last_name, age, created_date) values('Marian', 'Marinescu', 30, current_date());

select * from students;