-- DROP DATABASE drugstore;
CREATE DATABASE drugstore;
USE drugstore;

CREATE TABLE client (
    id INT AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
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
    id INT AUTO_INCREMENT ,
    title VARCHAR(100),
    price DECIMAL(10, 2),
    stock INT,
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
INSERT INTO credential(id, login, password) VALUES (1, 'lord' , 'passer' );
INSERT INTO credential(id, login, password) VALUES (2, 'soce' , 'passer' );
INSERT INTO credential(id, login, password) VALUES (3, 'soxna' , 'passer' );

INSERT INTO employe(firstname, lastname, type, to_id_credential) VALUES ('Rama', 'Faye' , 'MANAGER',1 );
INSERT INTO employe (firstname, lastname, to_id_credential) VALUES ('Socket', 'Gning', 2);
INSERT INTO employe (firstname, lastname, to_id_credential) VALUES ('Soxna', 'Sall', 3);
INSERT INTO drug (title, price, stock) VALUES ('DOLIPRANE', 905, 300);
INSERT INTO drug(title, price, stock) VALUES ('Paracétamol', 1315, 100);