--DROP TABLE TB_FINANCIAMENTO
--DROP TABLE TB_CLIENTE
--DROP TABLE TB_CARTAO
--DROP TABLE TB_TELEFONE
--DROP TABLE TB_ENDERECO
--DROP TABLE TB_CONTA
--DROP TABLE TB_TP_CONTA
--DROP TABLE TB_TP_CARTAO

CREATE TABLE tb_cartao (
    id_cartao          NUMBER(6) NOT NULL,
    dia_fatura_cartao  NUMBER(2) NOT NULL,
    dt_validade_cartao VARCHAR2(10) NOT NULL,
    nr_cartao          NUMBER(16) NOT NULL,
    id_conta           NUMBER(6),
    id_tp_cartao       NUMBER(6) NOT NULL
);

ALTER TABLE tb_cartao ADD CONSTRAINT cartao_pk PRIMARY KEY ( id_cartao );

ALTER TABLE tb_cartao ADD CONSTRAINT tb_cartao_nr_cartao_un UNIQUE ( nr_cartao );

CREATE TABLE tb_cliente (
    id_cliente            NUMBER(6) NOT NULL,
    nm_cliente            VARCHAR2(50) NOT NULL,
    cpf_cliente           VARCHAR2(11) NOT NULL,
    dt_nascimento_cliente VARCHAR2(10) NOT NULL,
    id_endereco           NUMBER(6) NOT NULL,
    id_conta              NUMBER(6) NOT NULL,
    id_telefone           NUMBER(6) NOT NULL
);

CREATE UNIQUE INDEX tb_cliente__idxv1 ON
    tb_cliente (
        id_telefone
    ASC );

ALTER TABLE tb_cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id_cliente );

ALTER TABLE tb_cliente ADD CONSTRAINT tb_cliente__un UNIQUE ( cpf_cliente );

CREATE TABLE tb_conta (
    id_conta      NUMBER(6) NOT NULL,
    nr_conta      NUMBER(6) NOT NULL,
    agencia_conta VARCHAR2(4) NOT NULL,
    id_tp_conta   NUMBER(6) NOT NULL
);

ALTER TABLE tb_conta ADD CONSTRAINT conta_pk PRIMARY KEY ( id_conta );

ALTER TABLE tb_conta ADD CONSTRAINT tb_conta_nr_conta_un UNIQUE ( nr_conta );

CREATE TABLE tb_endereco (
    id_endereco          NUMBER(6) NOT NULL,
    cep_endereco         VARCHAR2(11) NOT NULL,
    nr_endereco          NUMBER(6) NOT NULL,
    estado_endereco      VARCHAR2(2) NOT NULL,
    complemento_endereco VARCHAR2(50)
);

ALTER TABLE tb_endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( id_endereco );

CREATE TABLE tb_financiamento (
    id_financiamento            NUMBER(6) NOT NULL,
    dia_fatura_financiamento    NUMBER(2) NOT NULL,
    qtd_parcelas_financiamento  NUMBER(3) NOT NULL,
    vl_financiado_financiamento NUMBER(10) NOT NULL,
    id_conta                    NUMBER(6)
);

ALTER TABLE tb_financiamento ADD CONSTRAINT financiamento_pk PRIMARY KEY ( id_financiamento );

CREATE TABLE tb_telefone (
    id_telefone NUMBER(6) GENERATED ALWAYS AS IDENTITY,
    nr_telefone VARCHAR2(11) NOT NULL
);

ALTER TABLE tb_telefone ADD CONSTRAINT telefone_pk PRIMARY KEY ( id_telefone );

ALTER TABLE tb_telefone ADD CONSTRAINT tb_telefone__un UNIQUE ( nr_telefone );

CREATE TABLE tb_tp_cartao (
    id_tp_cartao NUMBER(6) NOT NULL,
    tp_cartao    VARCHAR2(15) NOT NULL
);

ALTER TABLE tb_tp_cartao ADD CONSTRAINT tipo_cartao_pk PRIMARY KEY ( id_tp_cartao );

CREATE TABLE tb_tp_conta (
    id_tp_conta NUMBER(6) NOT NULL,
    tp_conta    VARCHAR2(15) NOT NULL
);

ALTER TABLE tb_tp_conta ADD CONSTRAINT tipo_conta_pk PRIMARY KEY ( id_tp_conta );

ALTER TABLE tb_cartao
    ADD CONSTRAINT cartao_conta_fk FOREIGN KEY ( id_conta )
        REFERENCES tb_conta ( id_conta );

ALTER TABLE tb_cartao
    ADD CONSTRAINT cartao_tp_cartao_fk FOREIGN KEY ( id_tp_cartao )
        REFERENCES tb_tp_cartao ( id_tp_cartao );

ALTER TABLE tb_cliente
    ADD CONSTRAINT cliente_conta_fk FOREIGN KEY ( id_conta )
        REFERENCES tb_conta ( id_conta );

ALTER TABLE tb_cliente
    ADD CONSTRAINT cliente_endereco_fk FOREIGN KEY ( id_endereco )
        REFERENCES tb_endereco ( id_endereco );

ALTER TABLE tb_cliente
    ADD CONSTRAINT cliente_telefone_fk FOREIGN KEY ( id_telefone )
        REFERENCES tb_telefone ( id_telefone );

ALTER TABLE tb_conta
    ADD CONSTRAINT conta_tp_conta_fk FOREIGN KEY ( id_tp_conta )
        REFERENCES tb_tp_conta ( id_tp_conta );

ALTER TABLE tb_financiamento
    ADD CONSTRAINT financiamento_conta_fk FOREIGN KEY ( id_conta )
        REFERENCES tb_conta ( id_conta );




