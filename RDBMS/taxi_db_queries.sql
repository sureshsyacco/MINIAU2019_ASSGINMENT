
create database taxi_db;

use taxi_db;
create table user(user_id int primary key,user_name varchar(20),
email varchar(20),gender varchar(10),phone_no int,age int,
pickup_address varchar(100),destination_address varchar(100));


create table taxi(taxi_id int primary key,taxi_name varchar(20),
taxi_type varchar(20),taxi_reg_no varchar(20),taxi_owner varchar(20));

create table booking_table(booking_id int primary key,payment_id int,
amuont int,number_of_passengers int,taxi_id int,user_id int,
foreign key(user_id) references user(user_id),
foreign key(taxi_id) references taxi(taxi_id));

create table driver(driver_id int primary key,driver_name varchar(20),
driver_licence_number int,trips_completed int);

create table allocates(driver_id int,booking_id int,
foreign key(driver_id) references driver(driver_id),
foreign key(booking_id) references booking_table(booking_id),
primary key(driver_id,booking_id));

insert into user values(1,"suresh","s.@gmail.com","male",
7760,20,"banashankari,banglore","whitefield,banglore");
insert into user values(2,"ram","s1.@gmail.com","male",
7760,20,"banashankari,banglore","whitefield,banglore");
insert into user values(3,"abhijit","s3.@gmail.com","male",
7760,20,"banashankari,banglore","whitefield,banglore");
insert into user values(4,"pawan","s4.@gmail.com","male",
7760,20,"banashankari,banglore","whitefield,banglore");
insert into user values(5,"ramya","s5.@gmail.com","male",
7760,20,"banashankari,banglore","whitefield,banglore");
insert into user values(6,"hanuma","s6.@gmail.com","male",
7760,20,"banashankari,banglore","whitefield,banglore");

insert into taxi values(1,"taxi1","prime","123","ssy");
insert into taxi values(2,"taxi2","luxury","173","ssy");
insert into taxi values(3,"taxi3","prime","123","ssy");
insert into taxi values(4,"taxi4","prime","1233","ssy");
insert into taxi values(5,"taxi5","luxury","123","ssy");

insert into booking_table values(1,1,230,3,1,4);
insert into booking_table values(2,2,20,3,1,1);
insert into booking_table values(3,3,2930,3,5,2);
insert into booking_table values(4,5,280,3,3,1);
insert into booking_table values(5,9,2300,3,5,3);

insert into driver values(1,"subbu",234,12);
insert into driver values(2,"suraj",234,127);
insert into driver values(3,"subbu",25,162);
insert into driver values(4,"suma",236,182);
insert into driver values(5,"sumitra",34,129);


insert into allocates values(1,1);
insert into allocates values(1,2);
insert into allocates values(1,5);
insert into allocates values(3,1);
insert into allocates values(4,3);

select * from user;
select taxi_type from taxi where taxi_owner="ssy";
select count(*) as number_of_bookings from booking_table;
select user_name from user
 where exists(select distinct user_id from booking_table);
select sum(amuont) from booking_table;


