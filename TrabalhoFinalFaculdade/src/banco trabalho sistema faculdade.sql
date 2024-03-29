create database sistema_faculdade;

CREATE TABLE usuario(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
senha VARCHAR(50) NOT NULL,
tipo INT);

CREATE TABLE disciplina (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50));

CREATE TABLE turma (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
codDisciplina INT NOT NULL,
FOREIGN KEY(codDisciplina) REFERENCES disciplina(id));

CREATE TABLE usuarioTurma(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
codTurma INT NOT NULL,
codUsuario INT NOT NULL,
FOREIGN KEY(codUsuario) REFERENCES usuario(id),
FOREIGN KEY(codTurma) REFERENCES turma(id));

CREATE TABLE avaliacao (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
codTurma INT NOT NULL,
FOREIGN KEY(codTurma) REFERENCES turma(id));

CREATE TABLE nota(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
codAvaliacao INT NOT NULL,
codUsuario INT NOT NULL,
conceito CHAR(1) NOT NULL,
FOREIGN KEY(codAvaliacao) REFERENCES avaliacao(id),
FOREIGN KEY(codUsuario) REFERENCES usuario(id));

CREATE TABLE aula(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
dia date);

CREATE TABLE chamada(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
codAula INT NOT NULL,
codUsuario INT NOT NULL,
presenca boolean,
FOREIGN KEY(codAula) REFERENCES aula(id),
FOREIGN KEY(codUsuario) REFERENCES usuario(id));