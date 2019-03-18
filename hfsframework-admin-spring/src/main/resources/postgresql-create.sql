CREATE DATABASE hfsbanco_spring
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE public.adm_log_coluna (
	col_nome varchar(30) NOT NULL,
	col_nome_exibicao varchar(100) NOT NULL,
	col_comando varchar(4000) NULL,
	CONSTRAINT adm_log_coluna_pkey PRIMARY KEY (col_nome)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_menu (
	mnu_seq int8 NOT NULL,
	mnu_descricao varchar(255) NOT NULL,
	mnu_pai_seq int8 NULL,
	mnu_pag_seq int8 NULL,
	mnu_ordem numeric(3) NULL,
	CONSTRAINT adm_menu_pkey PRIMARY KEY (mnu_seq),
	CONSTRAINT adm_menu_un UNIQUE (mnu_descricao),
	CONSTRAINT adm_menu_adm_pagina_fk FOREIGN KEY (mnu_pag_seq) REFERENCES adm_pagina(pag_seq),
	CONSTRAINT adm_menu_mnu_pai_seq_fkey FOREIGN KEY (mnu_pai_seq) REFERENCES adm_menu(mnu_seq)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_pagina (
	pag_seq int8 NOT NULL,
	pag_url varchar(255) NOT NULL,
	pag_descricao varchar(255) NOT NULL,
	CONSTRAINT adm_pagina_pk PRIMARY KEY (pag_seq),
	CONSTRAINT adm_pagina_un UNIQUE (pag_url)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_pagina_perfil (
	pgl_pag_seq int8 NOT NULL,
	pgl_prf_seq int8 NOT NULL,
	CONSTRAINT adm_pagina_perfil_pkey PRIMARY KEY (pgl_pag_seq, pgl_prf_seq),
	CONSTRAINT adm_pagina_perfil_adm_pagina_fk FOREIGN KEY (pgl_pag_seq) REFERENCES adm_pagina(pag_seq),
	CONSTRAINT adm_pagina_perfil_pgl_prf_seq_fkey FOREIGN KEY (pgl_prf_seq) REFERENCES adm_perfil(prf_seq)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_parametro (
	par_seq int8 NOT NULL,
	par_valor varchar(4000) NULL,
	par_descricao varchar(255) NOT NULL,
	par_codigo varchar(255) NOT NULL,
	par_pmc_seq int8 NOT NULL,
	CONSTRAINT adm_parametro_pkey PRIMARY KEY (par_seq),
	CONSTRAINT adm_parametro_un UNIQUE (par_descricao),
	CONSTRAINT uk_adm_parametro UNIQUE (par_codigo),
	CONSTRAINT adm_parametro_par_pmc_seq_fkey FOREIGN KEY (par_pmc_seq) REFERENCES adm_parametro_categoria(pmc_seq)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_parametro_categoria (
	pmc_seq int8 NOT NULL,
	pmc_descricao varchar(100) NOT NULL,
	pmc_ordem numeric(2) NULL,
	CONSTRAINT adm_parametro_categoria_pkey PRIMARY KEY (pmc_seq),
	CONSTRAINT adm_parametro_categoria_un UNIQUE (pmc_descricao)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_perfil (
	prf_seq int8 NOT NULL,
	prf_descricao varchar(255) NULL,
	prf_geral bpchar(1) NULL DEFAULT 'N'::bpchar,
	prf_administrador bpchar(1) NULL DEFAULT 'N'::bpchar,
	CONSTRAINT adm_perfil_pkey PRIMARY KEY (prf_seq),
	CONSTRAINT adm_perfil_un UNIQUE (prf_descricao)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_usuario (
	usu_seq int8 NOT NULL,
	usu_login varchar(60) NOT NULL,
	usu_nome varchar(60) NOT NULL,
	usu_cpf numeric(11) NULL,
	usu_email varchar(255) NULL,
	usu_ldap_dn varchar(255) NULL,
	usu_senha varchar(128) NULL,
	created_date timestamp NOT NULL DEFAULT now(),
	modified_date timestamp NULL,
	created_by varchar(255) NULL,
	modified_by varchar(255) NULL,
	CONSTRAINT adm_usuario_pk PRIMARY KEY (usu_seq)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_usuario_ip (
	uip_usu_seq int8 NOT NULL,
	uip_ip varchar(15) NOT NULL,
	uip_ativo bpchar(1) NULL,
	CONSTRAINT adm_usuario_ip_pkey PRIMARY KEY (uip_usu_seq, uip_ip),
	CONSTRAINT adm_usuario_ip_adm_usuario_fk FOREIGN KEY (uip_usu_seq) REFERENCES adm_usuario(usu_seq)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.adm_usuario_perfil (
	usp_prf_seq int8 NOT NULL,
	usp_usu_seq int8 NOT NULL,
	CONSTRAINT adm_usuario_perfil_pkey PRIMARY KEY (usp_prf_seq, usp_usu_seq),
	CONSTRAINT adm_usuario_perfil_adm_usuario_fk FOREIGN KEY (usp_usu_seq) REFERENCES adm_usuario(usu_seq),
	CONSTRAINT adm_usuario_perfil_usp_prf_seq_fkey FOREIGN KEY (usp_prf_seq) REFERENCES adm_perfil(prf_seq)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_menu (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xmnu_seq int8 NULL,
	xmnu_descricao varchar(255) NULL,
	xmnu_pai_seq int8 NULL,
	xmnu_pag_seq int8 NULL,
	xmnu_ordem numeric(3) NULL,
	mnu_seq int8 NULL,
	mnu_descricao varchar(255) NULL,
	mnu_pai_seq int8 NULL,
	mnu_pag_seq int8 NULL,
	mnu_ordem numeric(3) NULL,
	CONSTRAINT log_adm_menu_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_pagina (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xpag_seq int8 NULL,
	xpag_url varchar(255) NULL,
	xpag_descricao varchar(255) NULL,
	pag_seq int8 NULL,
	pag_url varchar(255) NULL,
	pag_descricao varchar(255) NULL,
	CONSTRAINT log_adm_pagina_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_pagina_perfil (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xpgl_pag_seq int8 NULL,
	xpgl_prf_seq int8 NULL,
	pgl_pag_seq int8 NULL,
	pgl_prf_seq int8 NULL,
	CONSTRAINT log_adm_pagina_perfil_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_parametro (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xpar_seq int8 NULL,
	xpar_valor varchar(4000) NULL,
	xpar_descricao varchar(255) NULL,
	xpar_codigo varchar(255) NULL,
	xpar_pmc_seq int8 NULL,
	par_seq int8 NULL,
	par_valor varchar(4000) NULL,
	par_descricao varchar(255) NULL,
	par_codigo varchar(255) NULL,
	par_pmc_seq int8 NULL,
	CONSTRAINT log_adm_parametro_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_parametro_categoria (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xpmc_seq int8 NULL,
	xpmc_descricao varchar(100) NULL,
	xpmc_ordem numeric(2) NULL,
	pmc_seq int8 NULL,
	pmc_descricao varchar(100) NULL,
	pmc_ordem numeric(2) NULL,
	CONSTRAINT log_adm_parametro_categoria_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_perfil (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xprf_seq int8 NULL,
	xprf_descricao varchar(255) NULL,
	xprf_geral bpchar(1) NULL,
	xprf_administrador bpchar(1) NULL,
	prf_seq int8 NULL,
	prf_descricao varchar(255) NULL,
	prf_geral bpchar(1) NULL,
	prf_administrador bpchar(1) NULL,
	CONSTRAINT log_adm_perfil_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_usuario (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xusu_seq int8 NULL,
	xusu_login varchar(60) NULL,
	xusu_nome varchar(60) NULL,
	xusu_cpf numeric(11) NULL,
	xusu_email varchar(255) NULL,
	xusu_ldap_dn varchar(255) NULL,
	xusu_senha varchar(128) NULL,
	usu_seq int8 NULL,
	usu_login varchar(60) NULL,
	usu_nome varchar(60) NULL,
	usu_cpf numeric(11) NULL,
	usu_email varchar(255) NULL,
	usu_ldap_dn varchar(255) NULL,
	usu_senha varchar(128) NULL,
	CONSTRAINT log_adm_usuario_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_usuario_ip (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xuip_usu_seq int8 NULL,
	xuip_ip varchar(15) NULL,
	xuip_ativo bpchar(1) NULL,
	uip_usu_seq int8 NULL,
	uip_ip varchar(15) NULL,
	uip_ativo bpchar(1) NULL,
	CONSTRAINT log_adm_usuario_ip_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE public.log_adm_usuario_perfil (
	id int8 NOT NULL,
	usuario varchar(30) NULL,
	"data" timestamp NULL,
	operacao bpchar(1) NULL,
	ip varchar(50) NULL,
	xusp_prf_seq int8 NULL,
	xusp_usu_seq int8 NULL,
	usp_prf_seq int8 NULL,
	usp_usu_seq int8 NULL,
	CONSTRAINT log_adm_usuario_perfil_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;
