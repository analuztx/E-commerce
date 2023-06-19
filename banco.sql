create database desafio_um;
use desafio_um;

create table produtos(
	id_produto int(3) auto_increment not null primary key,
    nome_produto varchar(50) not null,
    preço_produto double not null,
    quantidade_produto int(100) not null
);

create table compra_finalizada(
	id_compra int(3) auto_increment not null primary key,
    nome_compra varchar(50) not null,
    quantidade_compra int(100) not null
);

select * from produtos;
select * from compra_finalizada;


