create database projetointegrador;

use projetointegrador;

create table curso(
Id_Curso Int(3) NOT NULL Primary Key auto_Increment,
Nome_Curso Varchar(40) NOT NULL,
Valor_Do_Curso Varchar(40) NOT NULL
)ENGINE = innodb;

create table fornecedor(
Id_Fornecedor Int(3) NOT NULL Primary Key auto_Increment,
Nome_Fornecedor Varchar(30) NOT NULL,
Nome_Verdadeiro_Fornecedor Varchar(45) NOT NULL,
Senha_Fornecedor Varchar(20) NOT NULL,
Telefone_Fornecedor Varchar(20) NOT NULL,
Email_Fornecedor Varchar(30) NOT NULL,
CPF_Fornecedor Varchar(20) NOT NULL,
DataDeNasc_Fornecedor Varchar(7)NOT NULL,
Estado_Fornecedor Varchar(30) NOT NULL,
Cidade_Fornecedor Varchar(30) NOT NULL,
Rua_Fornecedor Varchar(30) NOT NULL
)ENGINE = innodb;

create table usuario(
Id_Usuario Int(3) NOT NULL Primary Key auto_Increment,
Nome_Usuario Varchar(30) NOT NULL,
Nome_Verdadeiro_Usuario Varchar(45) NOT NULL,
Senha_Usuario Varchar(20) NOT NULL,
Telefone_Usuario Varchar(20) NOT NULL,
Email_Usuario Varchar(30) NOT NULL,
CPF_Usuario Varchar(20) NOT NULL,
DataDeNasc_Usuario Varchar(7)NOT NULL,
Estado_Usuario Varchar(30) NOT NULL,
Cidade_Usuario Varchar(30) NOT NULL,
Rua_Usuario Varchar(30) NOT NULL
)ENGINE = innodb;


ALTER TABLE `curso` ADD CONSTRAINT `fk_fornecedor_curso` FOREIGN KEY ( `Id_Fornecedor` ) REFERENCES `fornecedor` ( `Id_Fornecedor` ) ;