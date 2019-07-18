create sequence hibernate_sequence start with 1 increment by 1;
create table parkinglot(id integer not null, capacity integer not null check (capacity>=0), name varchar(255) not null, position varchar(255) not null, primary key (id));
alter table parkinglot add constraint UK_2w49woqis4x25gei7vnre7x1i unique(name);
