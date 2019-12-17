create schema `stock_market_charting`;
use `stock_market_charting`;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_user_name` VARCHAR(15) NOT NULL,
  `us_password` VARCHAR(200) NOT NULL,
  `us_email` VARCHAR(50) NOT NULL,
  `us_mobile_number` VARCHAR(10) NOT NULL,
  `us_confirmed` BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`user_role` (
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT NOT NULL,
  `ur_ro_id` INT NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_user_role_user1_idx` (`ur_us_id` ASC),
  INDEX `fk_user_role_role1_idx` (`ur_ro_id` ASC),
  CONSTRAINT `fk_user_role_user1`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `stock_market_charting`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `stock_market_charting`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`company` (
  `cp_id` INT NOT NULL AUTO_INCREMENT,
  `cp_name` VARCHAR(30) NOT NULL,
  `cp_turnover` BIGINT NOT NULL,
  `cp_ceo` VARCHAR(30) NOT NULL,
  `cp_board_of_directors` VARCHAR(30) NOT NULL,
  `cp_listed_stock_exchanges` BOOLEAN DEFAULT FALSE,
  `cp_se_id` INT NOT NULL,
  `cp_brief` VARCHAR(600) NOT NULL,
  `cp_stock_code` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cp_id`),
  INDEX `cp_se_fk_idx` (`cp_se_id` ASC),
  CONSTRAINT `cp_se_fk`
    FOREIGN KEY (`cp_se_id`)
    REFERENCES `stock_market_chart`.`sector` (`se_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`stock_price` (
  `sp_id` INT NOT NULL AUTO_INCREMENT,
  `sp_company_code` VARCHAR(20) NOT NULL,
  `sp_stock_exchange` VARCHAR(30) NOT NULL,
  `sp_current_price` BIGINT NOT NULL,
  `sp_date` DATE NOT NULL,
  `sp_time` TIME(0) NOT NULL ,
   PRIMARY KEY (`sp_id`) )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`ipo` (
  `ipo_id` INT NOT NULL AUTO_INCREMENT,
  `ipo_company_name` VARCHAR(30) NOT NULL,
  `ipo_stock_exchange` VARCHAR(30) NOT NULL,
  `ipo_share_price` BIGINT NOT NULL,
  `ipo_total_shares` INT NOT NULL,
  `ipo_date` DATETIME NOT NULL,
  `ipo_remarks` VARCHAR(400) NULL,
   PRIMARY KEY (`ipo_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `stock_market_chart`.`sector`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`sector` (
  `se_id` INT NOT NULL AUTO_INCREMENT,
  `se_sector_name` VARCHAR(30) NOT NULL,
  `se_brief` VARCHAR(400) NOT NULL,
  PRIMARY KEY (`se_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market_charting`.`stock_exchange` (
  `ex_id` INT NOT NULL AUTO_INCREMENT,
  `ex_stock_exchange` VARCHAR(30) NOT NULL,
  `ex_brief` VARCHAR(400) NOT NULL,
  `ex_address` VARCHAR(200) NOT NULL,
  `ex_remarks` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ex_id`))
ENGINE = InnoDB;


insert into user values (1,'admin','$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS','admin@gmail.com',9999999999,true);
insert into user values (2,'user','$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS','user@gmail.com',8888888888,true);