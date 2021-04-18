create table category (
id bigint not null auto_increment,
description varchar(50) not null,
primary key (id)
)engine=InnoDB default charset=utf8;

create table product (
id bigint not null auto_increment,
name varchar(50) not null,
code varchar(50) not null,
category_id bigint not null,
unique key unique_code (code),
primary key (id),
foreign key (category_id) references category (id)
)engine=InnoDB default charset=utf8;