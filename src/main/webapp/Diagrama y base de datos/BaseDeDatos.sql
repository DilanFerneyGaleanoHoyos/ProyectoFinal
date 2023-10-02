-- MySQL Script generated by MySQL Workbench
-- Sun Oct  1 13:21:33 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Materias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Materias` (
                                                 `idMaterias` INT NOT NULL AUTO_INCREMENT,
                                                 `nombreMateria` VARCHAR(45) NOT NULL,
                                                 `codigoMateria` INT NOT NULL,
                                                 `notaFinal` DECIMAL(2) NOT NULL,
                                                 PRIMARY KEY (`idMaterias`),
                                                 UNIQUE INDEX `idMaterias_UNIQUE` (`idMaterias` ASC) )
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Actividades` (
                                                    `idActividades` INT NOT NULL AUTO_INCREMENT,
                                                    `actividadesNombre` VARCHAR(45) NOT NULL,
                                                    `tipoActividad` ENUM('Evalucion', 'Talleres', 'Proyecto', 'Otros') NOT NULL,
                                                    `fechaEntrega` DATE NOT NULL,
                                                    `Ponderado` INT NOT NULL,
                                                    `Materias_idMaterias` INT NOT NULL,
                                                    PRIMARY KEY (`idActividades`, `Materias_idMaterias`),
                                                    UNIQUE INDEX `idActividades_UNIQUE` (`idActividades` ASC) ,
                                                    INDEX `fk_Actividades_Materias_idx` (`Materias_idMaterias` ASC) ,
                                                    CONSTRAINT `fk_Actividades_Materias`
                                                        FOREIGN KEY (`Materias_idMaterias`)
                                                            REFERENCES `mydb`.`Materias` (`idMaterias`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
