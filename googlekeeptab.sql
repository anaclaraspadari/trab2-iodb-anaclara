drop database if exists googlekeeptab;

create table googlekeeptab;
\c googlekeeptab;

create table googlekeep(
	id serial primary key,
	titulo text,
	texto text,
	cor text,
	data_hora timestamp default current_timestamp,
	foto bytea
);