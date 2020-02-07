CREATE TABLE TB_USER (
  id integer NOT NULL AUTO_INCREMENT,
  username varchar(200) NOT NULL,
  password varchar(50) NOT NULL,
  created_date timestamp NOT NULL,
  updated_date timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;