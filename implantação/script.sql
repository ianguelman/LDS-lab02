-- lab02.dbo.Agente definition

-- Drop table

-- DROP TABLE lab02.dbo.Agente

CREATE TABLE lab02.dbo.Agente (

	CNPJ varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Empresa varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Login varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Senha varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Nome varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Placa_Veiculo varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_Agente PRIMARY KEY (CNPJ),
	CONSTRAINT FK_Agente_Automovel FOREIGN KEY (Placa_Veiculo) REFERENCES lab02.dbo.Automovel(Placa)
);


-- lab02.dbo.Automovel definition

-- Drop table

-- DROP TABLE lab02.dbo.Automovel

CREATE TABLE lab02.dbo.Automovel (
	Placa varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Matricula varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Ano int NULL,
	Marca varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Modelo varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_Veiculo PRIMARY KEY (Placa)
);


-- lab02.dbo.Contratante definition

-- Drop table

-- DROP TABLE lab02.dbo.Contratante

CREATE TABLE lab02.dbo.Contratante (
	CPF varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	RG varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Endereco varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Profissao varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Entidades_Empregadoras varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Rendimento float NOT NULL,
	Login varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Senha varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Nome varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Placa_Veiculo varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_Contratante PRIMARY KEY (CPF),
	CONSTRAINT FK_Contratante_Automovel FOREIGN KEY (Placa_Veiculo) REFERENCES lab02.dbo.Automovel(Placa),
);


-- lab02.dbo.Pedido definition

-- Drop table

-- DROP TABLE lab02.dbo.Pedido

CREATE TABLE lab02.dbo.Pedido (
	Id_Pedido INTEGER NOT NULL,
	CPF_Contratante varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Placa_Veiculo varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_Pedido_1 PRIMARY KEY (Id_Pedido),
	CONSTRAINT FK_Pedido_Automovel FOREIGN KEY (Placa_Veiculo) REFERENCES lab02.dbo.Automovel(Placa),
	CONSTRAINT FK_Pedido_Contratante FOREIGN KEY (CPF_Contratante) REFERENCES lab02.dbo.Contratante(CPF)
);


-- lab02.dbo.Parecer definition

-- Drop table

-- DROP TABLE lab02.dbo.Parecer

CREATE TABLE lab02.dbo.Parecer (
	Id_Parecer INTEGER NOT NULL,
	Id_Pedido INTEGER NOT NULL,
	CNPJ_Agente varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Aprovado bit NOT NULL,
	[Data] date NOT NULL,
	CONSTRAINT PK_Parecer PRIMARY KEY (Id_Parecer),
	CONSTRAINT FK_Parecer_Agente FOREIGN KEY (CNPJ_Agente) REFERENCES lab02.dbo.Agente(CNPJ),
	CONSTRAINT FK_Parecer_Pedido FOREIGN KEY (Id_Pedido) REFERENCES lab02.dbo.Pedido(Id_Pedido)
)
