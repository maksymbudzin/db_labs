CREATE SCHEMA IF NOT EXISTS budzin_db_lab4_jdbc DEFAULT CHARACTER SET utf8;
USE budzin_db_lab4_jdbc;

DROP TABLE IF EXISTS TripAdvizor_object;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Feedback;
DROP TABLE IF EXISTS rating;
DROP TABLE IF EXISTS Owner_information;
DROP TABLE IF EXISTS Location;
DROP TABLE IF EXISTS Trip_Order;

-- -----------------------------------------------------
-- Table `budzin_db`.`TripAdvizor_object`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`TripAdvizor_object`
(
    `id`                  INT         NOT NULL AUTO_INCREMENT,
    `objec_name`          VARCHAR(30) NOT NULL,
    `number_of_star`      VARCHAR(1)  NOT NULL,
    `free_room`           VARCHAR(2)  NOT NULL,
    `busy_room`           VARCHAR(2)  NULL,
    `all_inclusive`       INT     NULL,
    `ultra_all_inclusive` INT     NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `budzin_db`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`Customer`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(20) NOT NULL,
    `surname` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`Feedback`
(
    `id`                     INT         NOT NULL AUTO_INCREMENT,
    `feedback_text`          VARCHAR(45) NOT NULL,
    `time`                   VARCHAR(45) NOT NULL,
    `Customer_id`            INT         NOT NULL,
    `Customer_Trip_Order_id` INT         NOT NULL,
    PRIMARY KEY (`id`, `Customer_id`, `Customer_Trip_Order_id`)

)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`rating`
(
    `Id`                     INT    NOT NULL AUTO_INCREMENT,
    `number_of_star`         INT(5) NOT NULL,
    `date`                   VARCHAR(30)  NOT NULL,
    `Customer_id`            INT    NOT NULL,
    `Customer_Trip_Order_id` INT    NOT NULL,
    PRIMARY KEY (`Id`, `Customer_id`, `Customer_Trip_Order_id`)

)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Owner_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`Owner_information`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `Name`    VARCHAR(45) NOT NULL,
    `Surname` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Owner_information_has_TripAdvizor_object`
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `budzin_db`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`Location`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `Country` VARCHAR(45) NOT NULL,
    `City`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Locatio_TripAdvizor_object`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `budzin_db`.`Trip_Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab4_jdbc.`Trip_Order`
(
    `id`               INT        NOT NULL AUTO_INCREMENT,
    `price_in_dollars` VARCHAR(4) NOT NULL,
    `date`             VARCHAR(30)       NOT NULL,
    `Customer_id`      INT        NOT NULL,
    PRIMARY KEY (`id`, `Customer_id`)

)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Trip_Order_TripAdvizor_object`
-- -----------------------------------------------------


insert into tripadvizor_object (id, objec_name, number_of_star, free_room, busy_room, all_inclusive,
                                ultra_all_inclusive)
values ('1', 'Amway', '5', '50', '30', '1', '0'),
       ('2', 'Hotel_Lviv', '4', '50', '30', '1', '0'),
       ('3', '7Dniv', '3', '80', '20', '1', '0'),
       ('4', 'Ramada', '5', '50', '30', '1', '0'),
       ('5', 'Hotel_kyiv', '5', '50', '20', '1', '0'),
       ('6', 'Plaza', '4', '50', '30', '1', '0'),
       ('7', 'Radison', '5', '50', '30', '1', '0'),
       ('8', 'Amway_hotel', '3', '50', '30', '1', '0'),
       ('9', 'Radison', '5', '50', '20', '1', '0'),
       ('10', 'Amway', '5', '50', '30', '1', '0');

INSERT INTO customer (id, name, surname)
VALUES (1, 'Smart', 'Man'),
       (2, 'Shurhot', 'Vitalii'),
       (3, 'Vislak', 'Nazarii'),
       (4, 'Melnychuk', 'Valentyna'),
       (5, 'Pavelchak', 'Andrii '),
       (6, 'Maksym', 'Budzin'),
       (7, 'Svyatoslav', 'Kostiv'),
       (8, 'Dmitro', 'Titusa'),
       (9, 'Roman', 'Hadupiak'),
       (10, 'Amdriy', 'Pidkivka');

insert into feedback (id, feedback_text, time, Customer_id, Customer_Trip_Order_id)
values ('1', 'very cool', '04.01.2002', '1', '1'),
       ('2', 'COOOlll...', '08.05.2000', '2', '1'),
       ('3', 'goood', '05.04.2012', '3', '1'),
       ('4', 'very nice', '06.01.2017', '4', '1'),
       ('5', 'very goood', '27.05.2021', '5', '1'),
       ('6', 'You must visit it ', '05.02.2020', '6', '1'),
       ('7', 'Awesome', '04.01.2019', '7', '1'),
       ('8', 'Beautiful...', '04.01.2016', '8', '1'),
       ('9', 'very nice', '04.01.2015', '9', '1'),
       ('10', 'very beautiful', '04.01.2012', '10', '1');

insert into rating (Id, number_of_star, date, Customer_id, Customer_Trip_Order_id)
values ('1', '5', '04.01.2017', '1', '1'),
       ('2', '5', '08.09.2019', '1', '1'),
       ('3', '5', '01.01.2020', '1', '1'),
       ('4', '5', '04.01.2017', '1', '1'),
       ('5', '5', '06.02.2014', '1', '1'),
       ('6', '5', '04.01.2017', '1', '1'),
       ('7', '5', '04.01.2019', '1', '1'),
       ('8', '5', '06.02.2002', '1', '1'),
       ('9', '5', '04.01.2017', '1', '1'),
       ('10', '5', '04.01.2017', '1', '1');

insert into owner_information (id, Name, Surname, country)
values ('1', 'Maksym', 'Budzin', 'Ukraine'),
       ('2', 'Maksym', 'Budzin', 'Ukraine'),
       ('3', 'Maksym', 'Budzin', 'Ukraine'),
       ('4', 'Maksym', 'Budzin', 'Ukraine'),
       ('5', 'Maksym', 'Budzin', 'Ukraine'),
       ('6', 'Maksym', 'Budzin', 'Ukraine'),
       ('7', 'Maksym', 'Budzin', 'Ukraine'),
       ('8', 'Maksym', 'Budzin', 'Ukraine'),
       ('9', 'Maksym', 'Budzin', 'Ukraine'),
       ('10', 'Maksym', 'Budzin', 'Ukraine');


insert into location (id, Country, City)
values ('1', 'Ukraine', 'Lviv'),
       ('2', 'USA', 'Washington'),
       ('3', 'Bilorus', 'Minsk'),
       ('4', 'Ukraine', 'Kyiv'),
       ('5', 'Ukraine', 'Kharkiv'),
       ('6', 'Turkey', 'Istanbul'),
       ('7', 'Poland', 'Warsawa'),
       ('8', 'Ukraine', 'Lviv'),
       ('9', 'Canada', 'Ottawa'),
       ('10', 'Turkey', 'Ankara');




insert into Trip_Order (id, price_in_dollars, date, Customer_id)
values (1, 200, '04.01.2002', '1'),
       (2, 175, '04.01.2002', '1'),
       (3, 50, '04.01.2002', '1'),
       (4, 25, '04.01.2002', '1'),
       (5, 180, '04.01.2002', '1'),
       (6, 250, '04.01.2002', '1'),
       (7, 500, '04.01.2002', '1'),
       (8, 140, '04.01.2002', '1'),
       (9, 50, '04.01.2002', '1'),
       (10, 300, '04.01.2002', '1');




SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
