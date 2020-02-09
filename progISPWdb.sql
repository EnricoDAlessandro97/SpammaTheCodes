-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb_progettoISPW
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb_progettoISPW` ;

-- -----------------------------------------------------
-- Schema mydb_progettoISPW
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb_progettoISPW` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new
-- -----------------------------------------------------
USE `mydb_progettoISPW` ;

-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Users` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Users` (
  `Username` VARCHAR(20) NOT NULL,
  `Cognome` VARCHAR(45) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(16) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `DomandaSegreta` VARCHAR(60) NULL,
  `RispostaSegreta` VARCHAR(45) NULL,
  PRIMARY KEY (`Username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Viaggi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Viaggi` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Viaggi` (
  `idViaggio` INT NOT NULL AUTO_INCREMENT,
  `Creatore` VARCHAR(20) NOT NULL,
  `Destinazione` VARCHAR(45) NOT NULL,
  `Descrizione` TEXT(164) NULL,
  `Fatto` BINARY(1) NULL DEFAULT 0,
  `Likes` INT NULL DEFAULT 0,
  `Open` BINARY(1) NULL DEFAULT 0,
  PRIMARY KEY (`idViaggio`),
  INDEX `fk_Viaggi_Users_idx` (`Creatore` ASC),
  CONSTRAINT `fk_Viaggi_Users`
    FOREIGN KEY (`Creatore`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Viaggi_gruppo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Viaggi_gruppo` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Viaggi_gruppo` (
  `idViaggioG` INT NOT NULL,
  `Creatore` VARCHAR(20) NOT NULL,
  `Prezzo` FLOAT NOT NULL,
  `NumMaxUt` INT NULL,
  `PagAnt` BINARY(1) NOT NULL,
  `ImpAnt` FLOAT NULL,
  `Scadenza` DATE NOT NULL,
  `DataV` DATE NOT NULL,
  `Descrizione` TEXT(164) NOT NULL,
  PRIMARY KEY (`idViaggioG`),
  INDEX `fk_Viaggi_gruppo_Users1_idx` (`Creatore` ASC),
  CONSTRAINT `fk_Viaggi_gruppo_Users1`
    FOREIGN KEY (`Creatore`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Join`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Join` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Join` (
  `Utente` VARCHAR(20) NOT NULL,
  `idViaggioG` INT NOT NULL,
  PRIMARY KEY (`Utente`, `idViaggioG`),
  INDEX `fk_Users_has_Viaggi_Users1_idx` (`Utente` ASC),
  INDEX `fk_Join_Viaggi_gruppo1_idx` (`idViaggioG` ASC),
  CONSTRAINT `fk_Users_has_Viaggi_Users1`
    FOREIGN KEY (`Utente`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Join_Viaggi_gruppo1`
    FOREIGN KEY (`idViaggioG`)
    REFERENCES `mydb_progettoISPW`.`Viaggi_gruppo` (`idViaggioG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Book` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Book` (
  `Utente` VARCHAR(20) NOT NULL,
  `NumViaggiatori` INT NOT NULL,
  `pdf` LONGBLOB NULL,
  `idViaggio` INT NOT NULL,
  PRIMARY KEY (`Utente`, `idViaggio`),
  INDEX `fk_Users_has_Viaggi_Users2_idx` (`Utente` ASC),
  INDEX `fk_Book_Viaggi1_idx` (`idViaggio` ASC),
  CONSTRAINT `fk_Users_has_Viaggi_Users2`
    FOREIGN KEY (`Utente`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Viaggi1`
    FOREIGN KEY (`idViaggio`)
    REFERENCES `mydb_progettoISPW`.`Viaggi` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Wishlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Wishlist` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Wishlist` (
  `Utente` VARCHAR(20) NOT NULL,
  `idViaggio` INT NOT NULL,
  PRIMARY KEY (`Utente`, `idViaggio`),
  INDEX `fk_Users_has_Viaggi_Users3_idx` (`Utente` ASC),
  INDEX `fk_Wishlist_Viaggi1_idx` (`idViaggio` ASC),
  CONSTRAINT `fk_Users_has_Viaggi_Users3`
    FOREIGN KEY (`Utente`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Wishlist_Viaggi1`
    FOREIGN KEY (`idViaggio`)
    REFERENCES `mydb_progettoISPW`.`Viaggi` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Comments` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Comments` (
  `Utente` VARCHAR(20) NOT NULL,
  `Commento` TEXT(280) NOT NULL,
  `idViaggio` INT NOT NULL,
  PRIMARY KEY (`Utente`, `idViaggio`),
  INDEX `fk_Comments_Viaggi1_idx` (`idViaggio` ASC),
  CONSTRAINT `fk_Comments_Users1`
    FOREIGN KEY (`Utente`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comments_Viaggi1`
    FOREIGN KEY (`idViaggio`)
    REFERENCES `mydb_progettoISPW`.`Viaggi` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Reviews` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Reviews` (
  `Utente` VARCHAR(20) NOT NULL,
  `Review` TEXT(560) NOT NULL,
  `ViaggioG` INT NOT NULL,
  `Accettato` BINARY(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`Utente`, `ViaggioG`),
  INDEX `fk_Reviews_Viaggi_gruppo1_idx` (`ViaggioG` ASC),
  CONSTRAINT `fk_Reviews_Users1`
    FOREIGN KEY (`Utente`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reviews_Viaggi_gruppo1`
    FOREIGN KEY (`ViaggioG`)
    REFERENCES `mydb_progettoISPW`.`Viaggi_gruppo` (`idViaggioG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Events` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Events` (
  `Viaggio` INT NOT NULL,
  `Descr_event` TEXT(40) NOT NULL,
  `pdf` LONGBLOB NULL,
  `Ora` TIME NOT NULL,
  `Data` DATETIME NOT NULL,
  PRIMARY KEY (`Viaggio`),
  INDEX `fk_Viaggi_has_Events_Viaggi1_idx` (`Viaggio` ASC),
  CONSTRAINT `fk_Viaggi_has_Events_Viaggi1`
    FOREIGN KEY (`Viaggio`)
    REFERENCES `mydb_progettoISPW`.`Viaggi` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Events` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Events` (
  `Viaggio` INT NOT NULL,
  `Descr_event` TEXT(40) NOT NULL,
  `pdf` LONGBLOB NULL,
  `Ora` TIME NOT NULL,
  `Data` DATETIME NOT NULL,
  PRIMARY KEY (`Viaggio`),
  INDEX `fk_Viaggi_has_Events_Viaggi1_idx` (`Viaggio` ASC),
  CONSTRAINT `fk_Viaggi_has_Events_Viaggi1`
    FOREIGN KEY (`Viaggio`)
    REFERENCES `mydb_progettoISPW`.`Viaggi` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`PersonalInformations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`PersonalInformations` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`PersonalInformations` (
  `User` VARCHAR(20) NOT NULL,
  `DataNascita` DATE NOT NULL,
  `luogoNascita` VARCHAR(45) NOT NULL,
  `CittàResidenza` VARCHAR(45) NOT NULL,
  `Via` VARCHAR(45) NOT NULL,
  `cell` CHAR(20) NOT NULL,
  `tel` CHAR(20) NOT NULL,
  PRIMARY KEY (`User`),
  INDEX `fk_PersonalInformations_Users1_idx` (`User` ASC),
  CONSTRAINT `fk_PersonalInformations_Users1`
    FOREIGN KEY (`User`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Likes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Likes` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Likes` (
  `idViaggio` INT NOT NULL,
  `User` VARCHAR(20) NOT NULL,
  INDEX `fk_Likes_Viaggi1_idx` (`idViaggio` ASC),
  INDEX `fk_Likes_Users1_idx` (`User` ASC),
  PRIMARY KEY (`idViaggio`, `User`),
  CONSTRAINT `fk_Likes_Viaggi1`
    FOREIGN KEY (`idViaggio`)
    REFERENCES `mydb_progettoISPW`.`Viaggi` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Likes_Users1`
    FOREIGN KEY (`User`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Follow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Follow` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Follow` (
  `Seguito` VARCHAR(20) NOT NULL,
  `Seguace` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Seguito`, `Seguace`),
  INDEX `fk_Users_has_Users_Users2_idx` (`Seguace` ASC),
  INDEX `fk_Users_has_Users_Users1_idx` (`Seguito` ASC),
  CONSTRAINT `fk_Users_has_Users_Users1`
    FOREIGN KEY (`Seguito`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Users_Users2`
    FOREIGN KEY (`Seguace`)
    REFERENCES `mydb_progettoISPW`.`Users` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb_progettoISPW`.`Destinazioni`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb_progettoISPW`.`Destinazioni` ;

CREATE TABLE IF NOT EXISTS `mydb_progettoISPW`.`Destinazioni` (
  `idDestinazione` CHAR(30) NOT NULL,
  `idViaggioG` INT NOT NULL,
  PRIMARY KEY (`idDestinazione`, `idViaggioG`),
  INDEX `fk_Destinazioni_Viaggi_gruppo1_idx` (`idViaggioG` ASC),
  CONSTRAINT `fk_Destinazioni_Viaggi_gruppo1`
    FOREIGN KEY (`idViaggioG`)
    REFERENCES `mydb_progettoISPW`.`Viaggi_gruppo` (`idViaggioG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb_progettoISPW` ;

-- -----------------------------------------------------
-- procedure registraUser
-- -----------------------------------------------------

USE `mydb_progettoISPW`;
DROP procedure IF EXISTS `mydb_progettoISPW`.`registraUser`;

DELIMITER $$
USE `mydb_progettoISPW`$$
CREATE PROCEDURE `registraUser` (in N char(45), in C char(45), in username varchar(20),in email varchar(45), in pw varchar(16), in ds varchar(60), in rs varchar(45))
BEGIN

	declare qres int;


	declare exit handler for sqlexception
    begin
        rollback;  -- rollback any changes made in the transaction
        resignal;  -- raise again the sql exception to the caller
    end;
	
	


	START TRANSACTION;

		SELECT count(username)
        FROM Users
        WHERE Username = username
        
        into qres;
        
        if(qres = 0) then
			
            INSERT INTO `Users` (`Cognome`, `Nome`, `Username`, `Password`, `email`, `DomandaSegreta`, `RispostaSegreta`) VALUES (C , N, username, pw, email, ds, rs);
		else
			signal sqlstate '45001'
			set message_text = "An user already owns this username.", MYSQL_ERRNO = 1111;
		end if;

	COMMIT;







END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure creaViaggio
-- -----------------------------------------------------

USE `mydb_progettoISPW`;
DROP procedure IF EXISTS `mydb_progettoISPW`.`creaViaggio`;

DELIMITER $$
USE `mydb_progettoISPW`$$
CREATE PROCEDURE `creaViaggio` (in idV int, in U int, in nv int, in tot float, in pdf longblob)

BEGIN


	declare exit handler for sqlexception
    begin
        rollback;  -- rollback any changes made in the transaction
        resignal;  -- raise again the sql exception to the caller
    end;
    
    START TRANSACTION;
    
    INSERT INTO Viaggi(Utente, Viaggio, NumViaggiatori, Totale, pdf) VALUES (U, idV, nv, tot, pdf);
    
    
    COMMIT;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_to_wishlist
-- -----------------------------------------------------

USE `mydb_progettoISPW`;
DROP procedure IF EXISTS `mydb_progettoISPW`.`add_to_wishlist`;

DELIMITER $$
USE `mydb_progettoISPW`$$
CREATE PROCEDURE `add_to_wishlist` (in U int, in idV int)
BEGIN

declare exit handler for sqlexception
    begin
        rollback;  -- rollback any changes made in the transaction
        resignal;  -- raise again the sql exception to the caller
    end;
    
    START TRANSACTION;
    
    INSERT INTO Wishlist(Utente, Viaggio) VALUES (U, idV);
    
    
    COMMIT;

END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
