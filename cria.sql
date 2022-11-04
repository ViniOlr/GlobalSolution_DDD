CREATE TABLE t_se_usuario (
    rm              NUMBER(10) NOT NULL,
    nome            VARCHAR2(100) NOT NULL,
    rg              NUMBER(15) NOT NULL,
    cpf             NUMBER(15) NOT NULL,
    telefone        VARCHAR2(20) NOT NULL,
    email           VARCHAR2(80) NOT NULL,
    data_nascimento DATE NOT NULL,
    setor           VARCHAR(40) NOT NULL,
    login           VARCHAR(40) NOT NULL,
    senha           VARCHAR(30) NOT NULL
);

CREATE SEQUENCE SQ_SE_USUARIO_RM START WITH 1;

CREATE TABLE t_se_motorista (
    id_motorista            NUMBER(8) NOT NULL,
    nome                    VARCHAR2(100) NOT NULL,
    rg                      NUMBER(7) NOT NULL,
    cpf                     NUMBER(11) NOT NULL,
    telefone                VARCHAR2(20) NOT NULL,
    email                   VARCHAR2(80) NOT NULL,
    data_nascimento         DATE NOT NULL,
    numero_habilitacao      NUMBER(11) NOT NULL,
    categoria_habilitacao   VARCHAR2(5) NOT NULL,
    data_expedicao          DATE NOT NULL
);

CREATE SEQUENCE SQ_SE_MOTORISTA START WITH 1;

CREATE TABLE t_se_empresa (
    id_empresa       NUMBER(8) NOT NULL,
    cnpj             NUMBER(16) NOT NULL,
    nome             VARCHAR2(80) NOT NULL,
    qtd_funcionarios NUMBER(10) NOT NULL,
    endereco         VARCHAR2(80) NOT NULL,
    telefone         VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE SQ_SE_EMPRESA START WITH 1;

CREATE TABLE t_se_carro (
    id_carro        NUMBER(8) NOT NULL,
    marca           VARCHAR2(80) NOT NULL,
    modelo          VARCHAR2(80) NOT NULL,
    ano             NUMERIC(7) NOT NULL,
    placa           VARCHAR2(10) NOT NULL,
    km_por_litro    NUMERIC(10) NOT NULL
);

CREATE SEQUENCE SQ_SE_CARRO START WITH 1;



