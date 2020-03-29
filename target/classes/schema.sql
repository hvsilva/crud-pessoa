DROP TABLE IF EXISTS TBL_PESSOAS;
DROP TABLE IF EXISTS TBL_CONTATO;
 
CREATE TABLE TBL_PESSOAS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  rg VARCHAR(250) NOT NULL,
  dtnascimento VARCHAR(250) NOT NULL,
  cpf VARCHAR(250) DEFAULT NULL,
  fl_ativo BOOLEAN(250) DEFAULT NULL
);


CREATE TABLE TBL_CONTATO (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  telefone VARCHAR(250) NOT NULL,
  celular VARCHAR(250) NOT NULL,
  pessoa_id INT NOT NULL,
  fl_ativo BOOLEAN(250) DEFAULT NULL
  
);