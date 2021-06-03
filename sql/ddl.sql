create table market
(
   id bigint auto_increment,
   name varchar(255),
   owner varchar(255),
   description varchar(1000),
   level int,
   address varchar(500),
   phone varchar(500),
   primary key(id)
);

create table businesstimes
(
    id int,
    day varchar(45),
    open varchar(45),
    close varchar(45),
    market_id int,
    foreign key (market_id) references market(id)
)