--CREATE DATABASE pedroniautopecas
--  WITH OWNER = postgres
--       ENCODING = 'UTF8'
--       TABLESPACE = pg_default
--       LC_COLLATE = 'Portuguese_Brazil.1252'
--       LC_CTYPE = 'Portuguese_Brazil.1252'
--       CONNECTION LIMIT = -1;

-- Table: pessoa
-- DROP TABLE pessoa;

CREATE TABLE pessoa
(
  id bigint NOT NULL,
  carteiradetrabalho bigint,
  cpf bigint NOT NULL,
  email character varying(40),
  endereco character varying(40),
  nascimento character varying(40),
  nome character varying(40),
  salariofixo double precision,
  senha character varying(40) NOT NULL,
  tipo character varying(255),
  CONSTRAINT pessoa_pkey PRIMARY KEY (id),
  CONSTRAINT uk_nlwiu48rutiltbnjle59krljo UNIQUE (cpf)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pessoa
  OWNER TO postgres;

-- Table: veiculo
-- DROP TABLE veiculo;

CREATE TABLE veiculo
(
  id bigint NOT NULL,
  cor character varying(40),
  modelo character varying(40),
  placa character varying(40) NOT NULL,
  tipo character varying(255),
  CONSTRAINT veiculo_pkey PRIMARY KEY (id),
  CONSTRAINT uk_luoyk9d8idgi0wif7bxtefsr5 UNIQUE (placa)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE veiculo
  OWNER TO postgres;

-- Table: venda
-- DROP TABLE venda;

CREATE TABLE venda
(
  id bigint NOT NULL,
  datadavenda character varying(40),
  descricao character varying(255),
  quantidade integer,
  status character varying(255),
  tipo character varying(255),
  valorunitario double precision,
  id_vendedor bigint,
  CONSTRAINT venda_pkey PRIMARY KEY (id),
  CONSTRAINT fk_ben0gt0tq31cdgwdyp3r3xn64 FOREIGN KEY (id_vendedor)
      REFERENCES pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE venda
  OWNER TO postgres;

-- Table: ordemdeservico
-- DROP TABLE ordemdeservico;

CREATE TABLE ordemdeservico
(
  id bigint NOT NULL,
  datafim character varying(40),
  datainicio character varying(40),
  id_cliente bigint,
  id_veiculo bigint,
  CONSTRAINT ordemdeservico_pkey PRIMARY KEY (id),
  CONSTRAINT fk_iahob958n1w1q18rw15j9d007 FOREIGN KEY (id_cliente)
      REFERENCES pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ld4jxidwn1kp0heqs2nmqqp4g FOREIGN KEY (id_veiculo)
      REFERENCES veiculo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ordemdeservico
  OWNER TO postgres;

-- Table: vendasproduto
-- DROP TABLE vendasproduto;

CREATE TABLE vendasproduto
(
  id_venda_prod bigint NOT NULL,
  vendasproduto_id bigint NOT NULL,
  CONSTRAINT fk_5awslhtcu7vxu0ytvo482bn8o FOREIGN KEY (id_venda_prod)
      REFERENCES ordemdeservico (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_rsklbitcnoll90n6o151sv5rr FOREIGN KEY (vendasproduto_id)
      REFERENCES venda (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_rsklbitcnoll90n6o151sv5rr UNIQUE (vendasproduto_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vendasproduto
  OWNER TO postgres;

-- Table: vendasservico
-- DROP TABLE vendasservico;

CREATE TABLE vendasservico
(
  id_venda_serv bigint NOT NULL,
  vendasservico_id bigint NOT NULL,
  CONSTRAINT fk_1smtlxhtjusdnutwh4shn9gam FOREIGN KEY (id_venda_serv)
      REFERENCES ordemdeservico (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_rcmsxsxxqb1yf6hbgi8hux88r FOREIGN KEY (vendasservico_id)
      REFERENCES venda (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_rcmsxsxxqb1yf6hbgi8hux88r UNIQUE (vendasservico_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vendasservico
  OWNER TO postgres;
