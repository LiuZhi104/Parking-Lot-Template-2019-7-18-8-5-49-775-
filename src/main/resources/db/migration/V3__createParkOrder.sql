create sequence hibernate_sequence start with 1 increment by 1;
create table parkorder( orderNumber Long not null,carNumber Long not null, parkinglotName  varchar(255)  not null , startTime date not null, endTime date not null,status tinyint not null, primary key (parkorder));
