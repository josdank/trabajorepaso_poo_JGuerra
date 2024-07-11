create database vehiculos;

use vehiculos;

create table vehiculo(
placa varchar(8) not null primary key,
marca varchar(30) not null,
cilindraje decimal (4,2) not null,
combustible varchar (20) not null,
color varchar (20) not null,
propietario varchar (20) not null
);



select * from vehiculo;