create database if not exists dbhotel;
use dbhotel;

create table if not exists Funcionario (
	idFuncionario	int 	not null auto_increment,
    nomeUsuario		varchar(20)		not null,
    nome_Completo	varchar(150)	not null,
    e_mailFuncionario	varchar(50)		not null,
    cpf		bigint(11)	not null,
    senhaFunc	varchar(20)		not null,
    dtNasc		datetime	not null,
    telefone_Func	varchar(11)		 not null,

	primary key (idFuncionario)
);

create table if not exists Hospede (
	idHospede	int 	not null auto_increment,
    nome_Completo		varchar(150)		not null,
    e_mailHospede	varchar(50)		not null,
    cpf		bigint(11)	not null,
    dtNasc		datetime	not null,
    telefone_Hosp	varchar(11)		 not null,

	primary key (idHospede)
);

create table Quartos(
    idQuartos int(11) not null auto_increment, 
    Numero_Quarto int(11) not null, 
    Disponibilidade varchar(20) not null, 
    Preco double(8,2) not null, 
    idHospede int(11) not null, 
    primary key (idQuartos), 
    CONSTRAINT fk_Hospede
        FOREIGN KEY(idHospede)
        REFERENCES dbhotel.Hospede(idHospede)
);

insert into Quartos(Numero_Quarto, Disponibilidade, Preco, idHospede)
value(237, "Livre", 279.99, 2);

ALTER TABLE quartos modify column Disponibilidade varchar(20) null;

ALTER TABLE quartos modify column Preco double(8,2) null;

ALTER TABLE quartos modify column idHospede int null;

ALTER TABLE quartos modify column Numero_Quarto int null;
