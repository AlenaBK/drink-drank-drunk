CREATE TABLE `stockofbottles`.`alcohol` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`strength` DOUBLE NULL,
`value` DOUBLE NULL,
`approve` BIT(1) NULL,
`quantity` INT NULL,
PRIMARY KEY (`id`));


