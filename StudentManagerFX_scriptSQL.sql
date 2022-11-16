DROP DATABASE IF EXISTS student;
CREATE DATABASE IF NOT EXISTS student;
USE student;

DROP TABLE IF EXISTS studenttable ;
CREATE TABLE studenttable (
id_student INT AUTO_INCREMENT NOT NULL,
name VARCHAR(25),
gender ENUM('male','female','other'),
email VARCHAR(50),
birthdate DATE,
photo VARCHAR(200),
mark DOUBLE,
comments VARCHAR(200),
PRIMARY KEY (id_student)
) ENGINE=InnoDB;

-- insertion dans la table studenttable
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (1,'Jean','male','jean.valjean@gmail.com','1980-01-01','placeholder',4.0,'Great student');
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (2,'Boyan','male','be.cieutat@funnyguy.fr','1980-01-01','placeholder',3.5);
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (3,'Pacôme','male','pâcome@cooldude.za','1980-01-01','placeholder',4.0,'Outstanding performance');
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (4,'Franky','other','f.smith@yahoo.uk','1980-01-01','placeholder',2.7,'Room for improvement'); 
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (5,'Edouard','male','Edouard@gmail.com','2000-12-03','placeholder',2);
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`birthdate`,`mark`) VALUES (6,'Allison','female','a.li@edu.devinci.fr','1980-01-01',2.7);
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`photo`,`mark`,`comments`) VALUES (7,'Anne','female','anne.sounanthanam@protonmail.com','placeholder',4.0,'Good Friend');
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`birthdate`,`photo`) VALUES (8,'Sabine','female','1980-01-01','placeholder');
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`email`,`birthdate`,`photo`,`mark`) VALUES (9,'Alyx','a.olleric@gmail.com','1980-01-01','placeholder',3.0);
INSERT INTO `student`.`studenttable`(`id_student`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (10,'other','nemo.nobody@gmail.com','1980-01-01','placeholder', 1.0);


SELECT * from studenttable