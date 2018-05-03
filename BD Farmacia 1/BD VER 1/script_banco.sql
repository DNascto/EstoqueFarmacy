-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Farmacia1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Farmacia1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Farmacia1` DEFAULT CHARACTER SET utf8 ;
USE `Farmacia1` ;

-- -----------------------------------------------------
-- Table `Farmacia1`.`tbProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmacia1`.`tbProduto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `codBarras` INT NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_produto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia1`.`tbEstoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmacia1`.`tbEstoque` (
  `id_Estoque` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `lote` INT NOT NULL,
  `vencimento` DATE NOT NULL,
  `id_Produto` INT NOT NULL,
  PRIMARY KEY (`id_Estoque`),
  INDEX `idProduto_idx` (`id_Produto` ASC),
  CONSTRAINT `idProduto`
    FOREIGN KEY (`id_Produto`)
    REFERENCES `Farmacia1`.`tbProduto` (`id_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia1`.`tbUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmacia1`.`tbUsuario` (
  `id_Usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `fone` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Usuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
