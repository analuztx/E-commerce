CREATE DATABASE IF NOT EXISTS desafio_um;
USE desafio_um;

CREATE TABLE produtos(
	id_produto int(3) auto_increment not null primary key,
    nome_produto varchar(50) not null,
    preço_produto double not null,
    quantidade_produto int(100) not null
);

CREATE TABLE compra_finalizada(
	id_compra int(3) auto_increment not null primary key,
    nome_compra varchar(50) not null,
    quantidade_compra int(100) not null
);


INSERT INTO produtos VALUES
(1, 'Amendoim', 5.40, 50),
(2, 'Arroz', 22.50, 50),
(3, 'Farofa', 8.90, 50),
(4, 'Esponja', 4.90, 50),
(5, 'Feijão', 11.99, 50),
(6, 'Detergente', 2.90, 50),
(7, 'Pipoca', 4.90, 50),
(8, 'Canjica', 5.99, 50),
(9, 'Macarrão', 3.20, 50),
(10, 'Miojo', 2.90, 50);


SELECT * FROM produtos;
SELECT * FROM compra_finalizada;

