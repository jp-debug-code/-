create table diary(id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date date NOT NULL ,
  title VARCHAR(40) NOT NULL,
  text VARCHAR(1000) NOT NULL
  );