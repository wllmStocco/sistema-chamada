package com.escolaprofissoes.sistemachamada

annotation class DB(

-- Tabela Usuário
CREATE TABLE Usuario (
id INT PRIMARY KEY,
nome VARCHAR(100),
email VARCHAR(100),
senha VARCHAR(100),
tipo ENUM('Aluno', 'Professor', 'Adm'),
foto VARCHAR(255),
endereco VARCHAR(255),
numero INT,
responsavel_legal VARCHAR(100)
);

-- Tabela Curso
CREATE TABLE Curso (
id INT PRIMARY KEY,
nome VARCHAR(100),
descricao TEXT,
professor_id INT,
FOREIGN KEY (professor_id) REFERENCES Usuario(id)
);

-- Tabela Turma
CREATE TABLE Turma (
id INT PRIMARY KEY,
nome VARCHAR(100),
curso_id INT,
FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

-- Tabela Grupo
CREATE TABLE Grupo (
id INT PRIMARY KEY,
nome VARCHAR(100),
turma_id INT,
FOREIGN KEY (turma_id) REFERENCES Turma(id)
);

-- Tabela Presença
CREATE TABLE Presenca (
id INT PRIMARY KEY,
data DATE,
aluno_id INT,
turma_id INT,
FOREIGN KEY (aluno_id) REFERENCES Usuario(id),
FOREIGN KEY (turma_id) REFERENCES Turma(id)
);

-- Tabela DataEvento
CREATE TABLE DataEvento (
id INT PRIMARY KEY,
tipo ENUM('Prova', 'Trabalho'),
data DATE,
descricao TEXT,
turma_id INT,
FOREIGN KEY (turma_id) REFERENCES Turma(id)
);

-- Tabela CalendarioAulas
CREATE TABLE CalendarioAulas (
id INT PRIMARY KEY,
data DATE,
descricao TEXT,
turma_id INT,
FOREIGN KEY (turma_id) REFERENCES Turma(id)
);
-- Inserindo Usuários
INSERT INTO Usuario (id, nome, email, senha, tipo, foto, endereco, numero, responsavel_legal) VALUES
(1, 'João Silva', 'joao@example.com', 'senha123', 'Aluno', 'foto1.jpg', 'Rua A', 123, NULL),
(2, 'Maria Souza', 'maria@example.com', 'senha456', 'Aluno', 'foto2.jpg', 'Rua B', 456, NULL),
(3, 'Pedro Santos', 'pedro@example.com', 'senha789', 'Professor', 'foto3.jpg', 'Rua C', 789, NULL),
(4, 'Ana Oliveira', 'ana@example.com', 'senhaabc', 'Adm', 'foto4.jpg', 'Rua D', 789, NULL);

-- Inserindo Cursos
INSERT INTO Curso (id, nome, descricao, professor_id) VALUES
(1, 'Matemática Básica', 'Curso introdutório de matemática', 3),
(2, 'História Antiga', 'Estudo das civilizações antigas', 3),
(3, 'Administração Financeira', 'Gestão financeira empresarial', 3);

-- Inserindo Turmas
INSERT INTO Turma (id, nome, curso_id) VALUES
(101, 'Turma de Matemática Básica A', 1),
(102, 'Turma de História Antiga A', 2),
(103, 'Turma de Administração Financeira A', 3);

-- Inserindo Grupos
INSERT INTO Grupo (id, nome, turma_id) VALUES
(201, 'Grupo de Estudo A', 101),
(202, 'Grupo de Discussão B', 102),
(203, 'Grupo de Trabalho C', 103);

-- Inserindo Presenças
INSERT INTO Presenca (id, data, aluno_id, turma_id) VALUES
(1, '2024-02-26', 1, 101),
(2, '2024-02-26', 2, 102),
(3, '2024-02-26', 1, 103);

-- Inserindo Datas de Eventos
INSERT INTO DataEvento (id, tipo, data, descricao, turma_id) VALUES
(1, 'Prova', '2024-03-10', 'Prova parcial do curso', 101),
(2, 'Trabalho', '2024-03-15', 'Apresentação de trabalhos sobre o tema', 102),
(3, 'Prova', '2024-03-20', 'Prova final do semestre', 103);

-- Inserindo Calendário de Aulas
INSERT INTO CalendarioAulas (id, data, descricao, turma_id) VALUES
(1, '2024-03-01', 'Introdução ao curso', 101),
(2, '2024-03-03', 'Revisão de conceitos básicos', 101),
(3, '2024-03-05', 'Exercícios práticos', 101),
(4, '2024-03-02', 'Discussão sobre temas específicos', 102),
(5, '2024-03-04', 'Apresentação de trabalhos', 102),
(6, '2024-03-06', 'Aprofundamento teórico', 102),
(7, '2024-03-07', 'Análise de casos práticos', 103),
(8, '2024-03-09', 'Estudo de casos reais', 103),
(9, '2024-03-11', 'Revisão para a prova', 103);
)
