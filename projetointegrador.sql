-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27-Out-2022 às 20:49
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetointegrador`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `Id_Curso` int(3) NOT NULL,
  `Nome_Do_Curso` varchar(40) NOT NULL,
  `Id_Do_Fornecedor` int(3) NOT NULL,
  `Valor_Do_Curso` varchar(40) NOT NULL,
  `Data_De_Inclusão` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `Id_Endereco` int(3) NOT NULL,
  `Estado` varchar(30) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `Rua` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `Id_Fornecedor` int(3) NOT NULL,
  `Nome_Fornecedor` varchar(30) NOT NULL,
  `Senha_Do_Fornecedor` varchar(20) NOT NULL,
  `Telefone_Do_Fornecedor` varchar(20) NOT NULL,
  `Email_Do_Fornecedor` varchar(30) NOT NULL,
  `CPF_Fornecedor` varchar(20) NOT NULL,
  `Id_Endereco_Fornecedor` int(3) NOT NULL,
  `Data_De_Inscricao_Do_Fornecedor` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` int(3) NOT NULL,
  `Nome_Usuario` varchar(30) NOT NULL,
  `Nome_Verdadeiro_Do_Usuario` varchar(45) NOT NULL,
  `Senha_Do_Usuario` varchar(20) NOT NULL,
  `Telefone_Do_Usuario` varchar(20) NOT NULL,
  `Email_Do_Usuario` varchar(30) NOT NULL,
  `Data_De_Nascimento` varchar(7) NOT NULL,
  `Id_Endereco_Usuario` int(3) NOT NULL,
  `Data_De_Inscricao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`Id_Curso`,`Id_Do_Fornecedor`),
  ADD KEY `Id_Curs_Fornecedor` (`Id_Do_Fornecedor`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`Id_Endereco`);

--
-- Índices para tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`Id_Fornecedor`,`Id_Endereco_Fornecedor`),
  ADD KEY `Id_Forn_Endereco` (`Id_Endereco_Fornecedor`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`,`Id_Endereco_Usuario`),
  ADD KEY `Id_Alun_Endereco` (`Id_Endereco_Usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `Id_Curso` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `Id_Fornecedor` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` int(3) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `Id_Curs_Fornecedor` FOREIGN KEY (`Id_Do_Fornecedor`) REFERENCES `fornecedor` (`Id_Fornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `Id_Forn_Endereco` FOREIGN KEY (`Id_Endereco_Fornecedor`) REFERENCES `endereco` (`Id_Endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `Id_Alun_Endereco` FOREIGN KEY (`Id_Endereco_Usuario`) REFERENCES `endereco` (`Id_Endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
