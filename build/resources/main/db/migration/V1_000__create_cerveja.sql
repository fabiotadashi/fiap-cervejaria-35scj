CREATE TABLE TB_CERVEJA (
  id integer NOT NULL AUTO_INCREMENT,
  marca varchar(200) NOT NULL,
  teor_alcoolico double DEFAULT NULL,
  tipo varchar(50) DEFAULT NULL,
  preco double DEFAULT NULL,
  data_lancamento timestamp DEFAULT NULL,
  data_criacao timestamp DEFAULT NULL,
  data_atualizacao timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;