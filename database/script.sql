DROP DATABASE drugstore;
CREATE DATABASE drugstore;
USE drugstore;


CREATE TABLE client (
    id INT AUTO_INCREMENT,
    CONSTRAINT PK_client PRIMARY KEY (id)
);

CREATE TABLE credential (
    id INT AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL ,
    CONSTRAINT PK_credential PRIMARY KEY (id)
);

CREATE TABLE employe (
    id INT AUTO_INCREMENT,
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    type ENUM('EMPLOYE', 'MANAGER') DEFAULT 'EMPLOYE',
    to_id_credential INT,
    CONSTRAINT Fk_credential FOREIGN KEY (to_id_credential) REFERENCES credential(id),
    CONSTRAINT PK_employe PRIMARY KEY (id)
);

CREATE TABLE `order` (
    id INT AUTO_INCREMENT,
    date DATE,
    amount FLOAT,
    client INT,
    to_id_employe INT,
    CONSTRAINT Fk_client FOREIGN KEY (client) REFERENCES client(id),
    CONSTRAINT Fk_employe FOREIGN KEY (to_id_employe) REFERENCES employe(id),
    CONSTRAINT PK_order PRIMARY KEY (id)
);

CREATE TABLE drug (
    id INT AUTO_INCREMENT,
    title VARCHAR(100),
    CONSTRAINT PK_medicament PRIMARY KEY (id)
);

CREATE TABLE drug_order (
    to_id_drug INT,
    to_id_order INT,
    quantity INT,
    CONSTRAINT Pk_drug_order PRIMARY KEY (to_id_drug, to_id_order),
    CONSTRAINT Fk_order FOREIGN KEY (to_id_order) REFERENCES `order`(id),
    CONSTRAINT Fk_drug FOREIGN KEY (to_id_drug) REFERENCES drug(id)
);




/* INSERTS */
INSERT INTO employe(firstname, lastname, type) VALUES ('RAMA', 'FAYE' , 'MANAGER' );
INSERT employe (firstname, lastname) VALUES ("Socket", "Gning");
INSERT drug (title) VALUES ("DOLIPRANE");
