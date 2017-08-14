SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `softwave` DEFAULT CHARACTER SET utf8;
USE `softwave`;

CREATE TABLE IF NOT EXISTS `softwave`.`usuario`(
	`prontuario` INT(7) UNSIGNED NOT NULL,
    `permissoes` ENUM('ALUNO', 'PROFESSOR', 'ADMIN') NOT NULL,
    PRIMARY KEY(`prontuario`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`turma`(
	`numero` INT(3) UNSIGNED NOT NULL,
    `nome` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`numero`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`usuario_has_turma`(
	`usuario_prontuario` INT(7) UNSIGNED NOT NULL,
    `turma_numero` INT(3) UNSIGNED NOT NULL,
    PRIMARY KEY(`usuario_prontuario`, `turma_numero`),
    INDEX `fk_usuario_has_turma_usuario_idx`(`usuario_prontuario` ASC),
    INDEX `fk_usuario_has_turma_turma_idx`(`turma_numero` ASC),
    CONSTRAINT `fk_usuario_has_turma_usuario`
		FOREIGN KEY(`usuario_prontuario`)
        REFERENCES `softwave`.`usuario`(`prontuario`),
	CONSTRAINT `fk_usuario_has_turma_turma`
		FOREIGN KEY(`turma_numero`)
        REFERENCES `softwave`.`turma`(`numero`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`disciplina`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `turma_numero` INT(3) UNSIGNED NOT NULL,
    PRIMARY KEY(`id`, `turma_numero`),
    INDEX `fk_disciplina_turma_idx`(`turma_numero` ASC),
    CONSTRAINT `fk_disciplina_turma`
		FOREIGN KEY(`turma_numero`)
        REFERENCES `softwave`.`turma`(`numero`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`atividade` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `descricao` TEXT NOT NULL,
    `lancada` DATETIME NOT NULL,
    `disciplina_id` INT UNSIGNED NOT NULL,
    `disciplina_turma_numero` INT(3) UNSIGNED NOT NULL,
    PRIMARY KEY (`id`, `disciplina_id`, `disciplina_turma_numero`),
    INDEX `fk_atividade_disciplina_idx`(`disciplina_id` ASC, `disciplina_turma_numero` ASC),
    CONSTRAINT `fk_atividade_disciplina`
		FOREIGN KEY(`disciplina_id`)
        REFERENCES `softwave`.`disciplina`(`id`),
	CONSTRAINT `fk_atividade_disciplina_turma`
		FOREIGN KEY(`disciplina_turma_numero`)
        REFERENCES `softwave`.`turma`(`numero`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`questao`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `pergunta` TEXT NOT NULL,
    `resposta_correta` ENUM('A', 'B', 'C', 'D', 'E') NOT NULL,
    `atividade_id` INT UNSIGNED NOT NULL,
    `atividade_disciplina_id` INT UNSIGNED NOT NULL,
    `atividade_disciplina_turma_numero` INT(3) UNSIGNED NOT NULL,
    PRIMARY KEY(`id`, `atividade_id`, `atividade_disciplina_id`, `atividade_disciplina_turma_numero`),
    INDEX `fk_questao_atividade_idx`(`atividade_id` ASC, `atividade_disciplina_id` ASC, `atividade_disciplina_turma_numero` ASC),
    CONSTRAINT `fk_questao_atividade`
		FOREIGN KEY(`atividade_id`)
        REFERENCES `softwave`.`atividade`(`id`),
	CONSTRAINT `fk_questao_atividade_disciplina`
		FOREIGN KEY(`atividade_disciplina_id`)
        REFERENCES `softwave`.`disciplina`(`id`),
	CONSTRAINT `fk_questao_atividade_disciplina_turma`
		FOREIGN KEY(`atividade_disciplina_turma_numero`)
        REFERENCES `softwave`.`turma`(`numero`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`mensagem`(
	`texto` TEXT NOT NULL,
    `enviada` DATETIME NOT NULL,
    `recebida` TINYINT UNSIGNED NOT NULL,
    `transmissor` INT(7) UNSIGNED NOT NULL,
    `receptor` INT(7) UNSIGNED NOT NULL,
    PRIMARY KEY(`transmissor`, `receptor`),
    INDEX `fk_mensagem_usuario_idx`(`receptor` ASC),
    CONSTRAINT `fk_mensagem_usuarioTransmissor`
		FOREIGN KEY(`transmissor`)
        REFERENCES `softwave`.`usuario`(`prontuario`),
	CONSTRAINT `fk_mensagem_usuarioReceptor`
		FOREIGN KEY(`receptor`)
        REFERENCES `softwave`.`usuario`(`prontuario`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`areaConhecimento`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `softwave`.`blog`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(2048) NOT NULL,
    `visible` TINYINT NOT NULL,
    `usuario_prontuario` INT(7) UNSIGNED NOT NULL,
    `areaConhecimento_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY(`id`, `usuario_prontuario`, `areaConhecimento_id`),
    INDEX `fk_blog_usuario_idx`(`usuario_prontuario` ASC),
    INDEX `fk_blog_areaConhecimento_idx`(`areaConhecimento_id` ASC),
    CONSTRAINT `fk_blog_usuario`
		FOREIGN KEY(`usuario_prontuario`)
        REFERENCES `softwave`.`usuario`(`prontuario`),
	CONSTRAINT `fk_blog_areaConhecimento`
		FOREIGN KEY(`areaConhecimento_id`)
        REFERENCES `softwave`.`areaConhecimento`(`id`)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softwave`.`comentario`(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `texto` VARCHAR(1024) NOT NULL,
    `visible` TINYINT NOT NULL,
    `comentador` INT(7) UNSIGNED NOT NULL,
    `blog_id` INT UNSIGNED NOT NULL,
    `receptor` INT(7) UNSIGNED NOT NULL,
    `blog_areaConhecimento_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY(`id`, `comentador`, `blog_id`, `receptor`, `blog_areaConhecimento_id`),
    INDEX `fk_comentario_usuario_idx`(`receptor` ASC),
    INDEX `fk_comentario_blog_idx`(`blog_id` ASC, `receptor` ASC, `blog_areaConhecimento_id` ASC),
    CONSTRAINT `fk_comentario_usuario`
		FOREIGN KEY(`comentador`)
        REFERENCES `softwave`.`usuario`(`prontuario`),
	CONSTRAINT `fk_comentario_blog`
		FOREIGN KEY(`blog_id`)
        REFERENCES `softwave`.`blog`(`id`),
	CONSTRAINT `fk_cometario_blog_usuario`
		FOREIGN KEY(`receptor`)
        REFERENCES `softwave`.`usuario`(`prontuario`),
	CONSTRAINT `fk_comentario_blog_areaConhecimento`
		FOREIGN KEY(`blog_areaConhecimento_id`)
        REFERENCES `softwave`.`areaconhecimento`(`id`)
)ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;