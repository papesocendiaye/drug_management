
USE drugstore;

CREATE TABLE medicament (
       id INT AUTO_INCREMENT,
       intitule VARCHAR(100),
       CONSTRAINT PK_medicament PRIMARY KEY (id)
);


INSERT medicament (intitule) VALUES ("DOLIPRANE");