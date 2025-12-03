DROP DATABASE PEDIDOS;
CREATE DATABASE PEDIDOS;

USE PEDIDOS;
DROP TABLE PEDIDO;
DROP TABLE CLIENTE;
DROP TABLE PRODUTO;
DROP TABLE ITEM_PRODUTO CASCADE;

create table PEDIDO (
NUMERO INT PRIMARY KEY auto_increment,
total_fatura decimal,
CEP varchar(10),	
ID_CLI INT not null
);

create table CLIENTE (
CODIGO int not null auto_increment,
NOME varchar(60) not null,
CEP varchar(10) not null,
constraint PK_CLIENTE primary key (CODIGO)
);

create table PRODUTO (
id INT not null auto_increment,
DESCRICAO varchar(80) not null,
TIPO varchar(10) not null,
constraint PK_PRODUTO primary key (id)
);

create table ITEM_PRODUTO (
   CODIGO_PRO           INT                not null,
   NUMERO_PED           INT             not null,
   QUANTIDADE           INT(5)             not null,
   VALOR_ITEM           FLOAT(7,2)           not null,
   constraint PK_ITEM_PRODUTO primary key (CODIGO_PRO, NUMERO_PED)
);

alter table ITEM_PRODUTO
   add constraint FK_ITEM_PRODUTO foreign key (CODIGO_PRO)
      references PRODUTO (ID);
      
alter table ITEM_PRODUTO
   add constraint FK_ITEM_PEDIDO foreign key (CODIGO_PRO)
      references PEDIDO (NUMERO);
      
      alter table PEDIDO
   add constraint FK_PED_CLIENTE foreign key (ID_CLI)
      references CLIENTE (CODIGO);
      
      select * from produto;	
      select * from cliente;
      select * from pedido;
      select * from item_produto;