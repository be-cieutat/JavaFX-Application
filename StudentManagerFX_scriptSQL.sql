
DROP DATABASE IF EXISTS Student;
CREATE DATABASE IF NOT EXISTS Student;
USE Student;

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

-- création des utilisateurs
/*create user 'root' identified by 'root' ;
grant all on student.* to 'root';

create user 'phosphore'@'localhost' identified by 'phosphore' ;
grant all on student.* to 'phosphore'@'localhost';
select user,host from MySQL.user;*/

-- insertion dans la table studenttable
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (1,'Jean','male','jean.valjean@gmail.com','1980-01-01','https://compagnieaffable.files.wordpress.com/2015/05/jean-valjean-gc3a9rard-depardieu-les-misc3a9rables.jpg',4.0,'Great student');
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (2,'Boyan','male','be.cieutat@funnyguy.fr','1980-01-01','https://media-exp1.licdn.com/dms/image/C5603AQGAyGoEw4HBJQ/profile-displayphoto-shrink_400_400/0/1643105673586?e=1674086400&v=beta&t=FaqLIxKzvNjnqbhI7K8XbvWxIlkOFrFOS_ifAS_YYqU',3.5);
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (3,'Pacôme','male','pâcome@cooldude.za','1980-01-01','https://media-exp1.licdn.com/dms/image/D4E03AQGS4F0SRqTX2g/profile-displayphoto-shrink_400_400/0/1666517575979?e=1674086400&v=beta&t=J6KfJmGiVzClnQ0auY80XezqkVV_3wYRfhxHOE-8Q8c',4.0,'Outstanding performance');
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (4,'Franky','other','f.smith@yahoo.uk','1980-01-01','https://i.pinimg.com/474x/f3/83/5e/f3835e625fdd7d6a0109f0eb070cc38f.jpg',2.7,'Room for improvement'); 
INSERT INTO `student`.`studenttable` (`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (5,'Edouard','male','Edouard@gmail.com','2000-12-03','https://t1.ev.ltmcdn.com/fr/posts/4/3/3/le_koala_est_il_un_animal_en_voie_de_disparition_334_600.jpg',2);
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (6,'Allison','female','a.li@edu.devinci.fr','1980-01-01','https://photos.tf1info.fr/images/700/700/la-lettre-d-amour-d-alison-wheeler-a-notre-dame-aaadd2-0@1x.jpeg',2.7);
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (7,'Anne','female','anne.sounanthanam@protonmail.com','1980-01-01','https://www.mlactu.fr/wp-content/uploads/2022/04/Anne-avec-un-E-ce-que-lon-soupconne-sur.jpg',4.0,'Good Friend');
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`birthdate`,`photo`) VALUES (8,'Sabine','female','1980-01-01','https://static.actu.fr/uploads/2022/03/elonmusk.jpg');
INSERT INTO `student`.`studenttable`(`id_student`,`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES (9,'Mme. THAI','female','noemie.thai@edu.devinci.fr','1992-01-01','https://media-exp1.licdn.com/dms/image/C4E03AQHByJo1zJeVtA/profile-displayphoto-shrink_800_800/0/1517463435482?e=2147483647&v=beta&t=ME_ltottsdqs7PWg8P1Q633IYfLYx0r3crZLidK_toU',4.0);
INSERT INTO `student`.`studenttable`(`name`,`gender`,`email`,`birthdate`,`photo`,`mark`) VALUES ('Nemo','other','nemo.nobody@gmail.com','1980-01-01','https://cinefilosfrustrados.com/wp-content/uploads/2017/11/Las-Vidas-Posibles-de-Mr-Nobody-768x326.jpg', 1.0);


SELECT * from studenttable;
SELECT AVG(`mark`) FROM  `studenttable` 