INSERT INTO lab02.dbo.Agente(CNPJ,Empresa,Login,Senha,Nome) 
VALUES('16935239000193', 'Getsocio', 'Gets', '123', 'Get');

INSERT INTO lab02.dbo.Agente(CNPJ,Empresa,Login,Senha,Nome) 
VALUES('87221731000145', 'Oberlo', 'Ober', '456', 'Obe');

INSERT INTO lab02.dbo.Agente(CNPJ,Empresa,Login,Senha,Nome) 
VALUES('68460689000170', 'Shopify', 'Shopi', '789', 'Shop');

INSERT INTO lab02.dbo.Agente(CNPJ,Empresa,Login,Senha,Nome) 
VALUES('55507526000154', 'Wordlab', 'Wordl', '101112', 'Word');

INSERT INTO lab02.dbo.Agente(CNPJ,Empresa,Login,Senha,Nome) 
VALUES('80394140000120', 'Rhythm Inc', 'Rhyt', '111213', 'Rhy');


INSERT INTO lab02.dbo.Contratante(CPF, RG, Endereco, Profissao, Entidades_Empregadoras, Rendimento, Login, Senha, Nome)
VALUES('93469446091','327062538','Rua Timbra,62 ,Bairro Alto, Cidade Itu, Estado SP','Carpinteiro','Marcenaria', 900.00,'Car','123','Carlos');

INSERT INTO lab02.dbo.Contratante(CPF, RG, Endereco, Profissao, Entidades_Empregadoras, Rendimento, Login, Senha, Nome)
VALUES('69637888047','120789978','Rua Timbra,61 ,Bairro Alto, Cidade Itu, Estado SP','Arquiteto','ALEIA', 1000.00,'Fern','124','Fernando');

INSERT INTO lab02.dbo.Contratante(CPF, RG, Endereco, Profissao, Entidades_Empregadoras, Rendimento, Login, Senha, Nome)
VALUES('42453938070','42453938070','Rua Timbra,60 ,Bairro Alto, Cidade Itu, Estado SP','Engenheiro','Edenge', 12100.00,'Migu','125','Miguel');

INSERT INTO lab02.dbo.Contratante(CPF, RG, Endereco, Profissao, Entidades_Empregadoras, Rendimento, Login, Senha, Nome)
VALUES('34264202019','230109111','Rua Timbra,59 ,Bairro Alto, Cidade Itu, Estado SP','Contabilista','VALLE', 15100.00,'Pedr','126','Pedro');

INSERT INTO lab02.dbo.Contratante(CPF, RG, Endereco, Profissao, Entidades_Empregadoras, Rendimento, Login, Senha, Nome)
VALUES('40858555069','277714254','Rua Timbra,58 ,Bairro Alto, Cidade Itu, Estado SP','Nutricionista','Aporte', 14100.00,'Saul','127','Saulo');


INSERT INTO lab02.dbo.Automovel(Placa, Matricula,Ano,Marca,Modelo, CNPJ_Agente)
VALUES('GQY3147','90466316','2010','Chevrolet','Corsa', '80394140000120');

INSERT INTO lab02.dbo.Automovel(Placa, Matricula,Ano,Marca,Modelo, CPF_Contratante)
VALUES('MZH7319','90466317','2011','Fiat','Punto', '34264202019');

INSERT INTO lab02.dbo.Automovel(Placa, Matricula,Ano,Marca,Modelo, CNPJ_Agente)
VALUES('KJG6100','90466318','2012','Volkswagen','Gol', '16935239000193');

INSERT INTO lab02.dbo.Automovel(Placa, Matricula,Ano,Marca,Modelo, CPF_Contratante)
VALUES('HRN1274','90466319','2013','Ford','Focus', '93469446091');

INSERT INTO lab02.dbo.Automovel(Placa, Matricula,Ano,Marca,Modelo)
VALUES('FFW6314','90466320','2014','Renault','Sandero');


INSERT INTO lab02.dbo.Pedido(CPF_Contratante, Placa_Veiculo)
VALUES('40858555069','FFW6314');

INSERT INTO lab02.dbo.Pedido(CPF_Contratante, Placa_Veiculo)
VALUES('34264202019','HRN1274');

INSERT INTO lab02.dbo.Pedido(CPF_Contratante, Placa_Veiculo)
VALUES('42453938070','KJG6100');

INSERT INTO lab02.dbo.Pedido(CPF_Contratante, Placa_Veiculo)
VALUES('69637888047','MZH7319');

INSERT INTO lab02.dbo.Pedido(CPF_Contratante, Placa_Veiculo)
VALUES('93469446091','GQY3147');

INSERT INTO lab02.dbo.Pedido(CPF_Contratante, Placa_Veiculo)
VALUES('42453938070','HRN1274');


INSERT INTO lab02.dbo.Parecer(CNPJ_Agente, Aprovado, Data, Id_Pedido)
VALUES('80394140000120', 0, '04/10/2021', 5);

INSERT INTO lab02.dbo.Parecer(CNPJ_Agente, Aprovado, Data, Id_Pedido)
VALUES('55507526000154', 1, '04/11/2021', 4);

INSERT INTO lab02.dbo.Parecer(CNPJ_Agente, Aprovado, Data, Id_Pedido)
VALUES('68460689000170', 0, '04/12/2021', 3);

INSERT INTO lab02.dbo.Parecer(CNPJ_Agente, Aprovado, Data, Id_Pedido)
VALUES('87221731000145', 1, '04/13/2021', 2);

INSERT INTO lab02.dbo.Parecer(CNPJ_Agente, Aprovado, Data, Id_Pedido)
VALUES('16935239000193', 0, '04/14/2021', 1);

