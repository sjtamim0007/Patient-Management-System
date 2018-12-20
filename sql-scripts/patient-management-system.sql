CREATE DATABASE  IF NOT EXISTS `patient_management_system`;
USE `patient_management_system`;

create table doctors(
id int auto_increment primary key,
name varchar(30),
dept varchar(30),
joining_date varchar(30)
);



create table patients(
id int auto_increment primary key,
name varchar(30),
mobile varchar(20),
age int,
gender enum('M','F'),
occupation varchar(30)
);

insert into doctors(name,dept,joining_date) values ('Dr. Strange','child_speacialist','11-12-2016');

select * from patients;
select * from doctors;

insert into patients(name, mobile, age, gender, occupation)
values('Thanos','01011-000011',57,'M', 'Software Developer');