create table usuarios(
	rut varchar(45),
	pass varchar(100),
	nombre1 varchar(45),
	nombre2 varchar(45),
	paterno varchar(45),
	materno varchar(45),
	mail varchar(45),
	tipo int,
	primary key(rut)
	);

insert into usuarios values 
('11111111','pass','Nombre1','Nombre2','Paterno','Materno','profesor@mail.com',1),
('22222222','pass','Nombre1','Nombre2','Paterno','Materno','alumno@mail.com',2),
('17134298','85638020','Sebastián','Andrés','Segovia','Cordero','s.segovia.c@gmail.com',1);

create table alumnos(
	rut varchar(45),
	ano_ingreso varchar(45),
	vez_cursado varchar(45),
	edad varchar(45),
	primary key(rut),
	foreign key(rut) references usuarios(rut) on delete cascade on update cascade
	);
	
insert into alumnos values
('22222222','2009','3','23');

	
create table profesores(
	rut varchar(45),
	ano_curso varchar(45),
	primary key(rut),
	foreign key(rut) references usuarios(rut) on delete cascade on update cascade
	);

insert into profesores values
('11111111','2014'),
('17134298','2014');
	
create table esquemas(
	rut varchar(45),
	nombre varchar(45),
	fecha timestamp,
	visible boolean,
	primary key(rut,nombre),
	foreign key(rut) references usuarios(rut) on delete cascade on update cascade
	);


insert into esquemas values
('17134298','ejemplo',(select current_timestamp),true);

--Esquema Mio
create schema ejemplo_17134298;

create table ejemplo_17134298.edificios_emp(
	edificio text,
	supmediadesp int,
	primary key(edificio)
	);

insert into ejemplo_17134298.edificios_emp values
	('Marina',15),
	('Diagonal',10);

create table ejemplo_17134298.despachos(
	edificio text,
	numero int,
	superficie int,
	primary key(edificio,numero)
	);

insert into ejemplo_17134298.despachos values
	('Marina',120,10),
	('Marina',230,20),
	('Diagonal',120,10),
	('Diagonal',440,10);

create table ejemplo_17134298.empleados_adm(
	id int,
	nombre text,
	apellido text,
	edificiodesp text,
	numerodesp int,
	primary key(id)
	);

insert into ejemplo_17134298.empleados_adm values
	(40444255,'Juan','Garcia','Marina',120),
	(33567711,'Marta','Roca','Marina',120);

create table ejemplo_17134298.empleados_prod(
	id int,
	nombreemp text,
	apellidoemp text,
	edificiodesp text,
	numerodesp int,
	primary key(id)
	);

insert into ejemplo_17134298.empleados_prod values
	(33567711,'Marta','Roca','Marina',120),
	(55898425,'Carlos','Buendia','Diagonal',120),
	(77232144,'Elena','Pla','Marina',230),
	(21335245,'Jorge','Soler',null,null),
	(88999210,'Pedro','Gonzalez',null,null);

create table ejemplo_17134298._resp(
	id int,
	pregunta text,
	relacion varchar(60),
	consultas text,
	primary key(id)
	);

-- Respuestas

create sequence sec_resultados;
	
create table resultados(
	id int default nextval('sec_resultados'),
	bd varchar(60),
	fecha_bd timestamp,
	cant_ejercicios int,
	cant_correctas int,
	cant_erroneas int,
	cant_omitidas int,
	fecha timestamp,
	primary key(id)
	);	
	
create sequence sec_respuestas;
	
create table respuestas(
	id int default nextval('sec_respuestas'),
	rut varchar(60),
	bd varchar(60),
	fecha_bd timestamp,
	ejercicio int,
	resultado boolean,
	intento int,
	tiempo_ejercicio time,
	tiempo_sesion time,
	fecha timestamp,
	primary key(id)
	);
	
create sequence sec_consultas;
	
create table consultas(
	id int default nextval('sec_consultas'),
	id_respuestas int,
	numero int,
	query text,
	error text,
	fecha timestamp,
	primary key(id),
	foreign key(id_respuestas) references respuestas(id) on delete cascade on update cascade
	);

-- borrar resultaados
drop table consultas cascade;
drop table respuestas cascade;
drop table resultados cascade;
drop sequence sec_resultados cascade;
drop sequence sec_respuestas cascade;
drop sequence sec_consultas cascade;
	
	