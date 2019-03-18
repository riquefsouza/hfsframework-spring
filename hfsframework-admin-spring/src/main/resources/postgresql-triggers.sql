CREATE TABLE public.log_adm_menu (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xmnu_seq bigint,xmnu_descricao character varying(255),xmnu_pai_seq bigint,xmnu_pag_seq bigint,xmnu_ordem numeric(3,0),
   mnu_seq bigint,mnu_descricao character varying(255),mnu_pai_seq bigint,mnu_pag_seq bigint,mnu_ordem numeric(3,0));

CREATE SEQUENCE public.log_adm_menu_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_menu_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_menu(id,data,operacao,usuario,ip,
    mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES
    (nextval('public.log_adm_menu_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.mnu_seq,new.mnu_descricao,new.mnu_pai_seq,new.mnu_pag_seq,new.mnu_ordem);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_menu(id,data,operacao,usuario,ip,xmnu_seq,xmnu_descricao,xmnu_pai_seq,xmnu_pag_seq,xmnu_ordem,
    mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES
    (nextval('public.log_adm_menu_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.mnu_seq,old.mnu_descricao,old.mnu_pai_seq,old.mnu_pag_seq,old.mnu_ordem,
    new.mnu_seq,new.mnu_descricao,new.mnu_pai_seq,new.mnu_pag_seq,new.mnu_ordem);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_menu(id,data,operacao,usuario,ip,mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem)
 VALUES
    (nextval('public.log_adm_menu_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.mnu_seq,old.mnu_descricao,old.mnu_pai_seq,old.mnu_pag_seq,old.mnu_ordem);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_menu_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_menu
FOR EACH ROW
EXECUTE PROCEDURE public.adm_menu_auid();

ALTER TABLE adm_menu ENABLE TRIGGER trg_adm_menu_auid;



CREATE TABLE public.log_adm_pagina (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xpag_seq bigint,xpag_url character varying(255),xpag_descricao character varying(255),
   pag_seq bigint,pag_url character varying(255),pag_descricao character varying(255));

CREATE SEQUENCE public.log_adm_pagina_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_pagina_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_pagina(id,data,operacao,usuario,ip,
    pag_seq,pag_url,pag_descricao) VALUES
    (nextval('public.log_adm_pagina_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.pag_seq,new.pag_url,new.pag_descricao);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_pagina(id,data,operacao,usuario,ip,xpag_seq,xpag_url,xpag_descricao,
    pag_seq,pag_url,pag_descricao) VALUES
    (nextval('public.log_adm_pagina_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.pag_seq,old.pag_url,old.pag_descricao,
    new.pag_seq,new.pag_url,new.pag_descricao);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_pagina(id,data,operacao,usuario,ip,pag_seq,pag_url,pag_descricao)
 VALUES
    (nextval('public.log_adm_pagina_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.pag_seq,old.pag_url,old.pag_descricao);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_pagina_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_pagina
FOR EACH ROW
EXECUTE PROCEDURE public.adm_pagina_auid();

ALTER TABLE adm_pagina ENABLE TRIGGER trg_adm_pagina_auid;



CREATE TABLE public.log_adm_pagina_perfil (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xpgl_pag_seq bigint,xpgl_prf_seq bigint,
   pgl_pag_seq bigint,pgl_prf_seq bigint);

CREATE SEQUENCE public.log_adm_pagina_perfil_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_pagina_perfil_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_pagina_perfil(id,data,operacao,usuario,ip,
    pgl_pag_seq,pgl_prf_seq) VALUES
    (nextval('public.log_adm_pagina_perfil_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.pgl_pag_seq,new.pgl_prf_seq);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_pagina_perfil(id,data,operacao,usuario,ip,xpgl_pag_seq,xpgl_prf_seq,
    pgl_pag_seq,pgl_prf_seq) VALUES
    (nextval('public.log_adm_pagina_perfil_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.pgl_pag_seq,old.pgl_prf_seq,
    new.pgl_pag_seq,new.pgl_prf_seq);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_pagina_perfil(id,data,operacao,usuario,ip,pgl_pag_seq,pgl_prf_seq)
 VALUES
    (nextval('public.log_adm_pagina_perfil_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.pgl_pag_seq,old.pgl_prf_seq);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_pagina_perfil_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_pagina_perfil
FOR EACH ROW
EXECUTE PROCEDURE public.adm_pagina_perfil_auid();

ALTER TABLE adm_pagina_perfil ENABLE TRIGGER trg_adm_pagina_perfil_auid;



CREATE TABLE public.log_adm_parametro (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xpar_seq bigint,xpar_valor character varying(4000),xpar_descricao character varying(255),xpar_codigo character varying(255),xpar_pmc_seq bigint,
   par_seq bigint,par_valor character varying(4000),par_descricao character varying(255),par_codigo character varying(255),par_pmc_seq bigint);

CREATE SEQUENCE public.log_adm_parametro_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_parametro_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_parametro(id,data,operacao,usuario,ip,
    par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES
    (nextval('public.log_adm_parametro_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.par_seq,new.par_valor,new.par_descricao,new.par_codigo,new.par_pmc_seq);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_parametro(id,data,operacao,usuario,ip,xpar_seq,xpar_valor,xpar_descricao,xpar_codigo,xpar_pmc_seq,
    par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES
    (nextval('public.log_adm_parametro_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.par_seq,old.par_valor,old.par_descricao,old.par_codigo,old.par_pmc_seq,
    new.par_seq,new.par_valor,new.par_descricao,new.par_codigo,new.par_pmc_seq);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_parametro(id,data,operacao,usuario,ip,par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq)
 VALUES
    (nextval('public.log_adm_parametro_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.par_seq,old.par_valor,old.par_descricao,old.par_codigo,old.par_pmc_seq);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_parametro_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_parametro
FOR EACH ROW
EXECUTE PROCEDURE public.adm_parametro_auid();

ALTER TABLE adm_parametro ENABLE TRIGGER trg_adm_parametro_auid;



CREATE TABLE public.log_adm_parametro_categoria (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xpmc_seq bigint,xpmc_descricao character varying(100),xpmc_ordem numeric(2,0),
   pmc_seq bigint,pmc_descricao character varying(100),pmc_ordem numeric(2,0));

CREATE SEQUENCE public.log_adm_parametro_categoria_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_parametro_categoria_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_parametro_categoria(id,data,operacao,usuario,ip,
    pmc_seq,pmc_descricao,pmc_ordem) VALUES
    (nextval('public.log_adm_parametro_categoria_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.pmc_seq,new.pmc_descricao,new.pmc_ordem);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_parametro_categoria(id,data,operacao,usuario,ip,xpmc_seq,xpmc_descricao,xpmc_ordem,
    pmc_seq,pmc_descricao,pmc_ordem) VALUES
    (nextval('public.log_adm_parametro_categoria_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.pmc_seq,old.pmc_descricao,old.pmc_ordem,
    new.pmc_seq,new.pmc_descricao,new.pmc_ordem);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_parametro_categoria(id,data,operacao,usuario,ip,pmc_seq,pmc_descricao,pmc_ordem)
 VALUES
    (nextval('public.log_adm_parametro_categoria_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.pmc_seq,old.pmc_descricao,old.pmc_ordem);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_parametro_categoria_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_parametro_categoria
FOR EACH ROW
EXECUTE PROCEDURE public.adm_parametro_categoria_auid();

ALTER TABLE adm_parametro_categoria ENABLE TRIGGER trg_adm_parametro_categoria_auid;



CREATE TABLE public.log_adm_perfil (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xprf_seq bigint,xprf_descricao character varying(255),xprf_geral character,xprf_administrador character,
   prf_seq bigint,prf_descricao character varying(255),prf_geral character,prf_administrador character);

CREATE SEQUENCE public.log_adm_perfil_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_perfil_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_perfil(id,data,operacao,usuario,ip,
    prf_seq,prf_descricao,prf_geral,prf_administrador) VALUES
    (nextval('public.log_adm_perfil_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.prf_seq,new.prf_descricao,new.prf_geral,new.prf_administrador);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_perfil(id,data,operacao,usuario,ip,xprf_seq,xprf_descricao,xprf_geral,xprf_administrador,
    prf_seq,prf_descricao,prf_geral,prf_administrador) VALUES
    (nextval('public.log_adm_perfil_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.prf_seq,old.prf_descricao,old.prf_geral,old.prf_administrador,
    new.prf_seq,new.prf_descricao,new.prf_geral,new.prf_administrador);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_perfil(id,data,operacao,usuario,ip,prf_seq,prf_descricao,prf_geral,prf_administrador)
 VALUES
    (nextval('public.log_adm_perfil_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.prf_seq,old.prf_descricao,old.prf_geral,old.prf_administrador);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_perfil_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_perfil
FOR EACH ROW
EXECUTE PROCEDURE public.adm_perfil_auid();

ALTER TABLE adm_perfil ENABLE TRIGGER trg_adm_perfil_auid;



CREATE TABLE public.log_adm_usuario (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xusu_seq bigint,xusu_login character varying(60),xusu_nome character varying(60),xusu_cpf numeric(11,0),xusu_email character varying(255),xusu_ldap_dn character varying(255),xusu_senha character varying(128),xcreated_date timestamp without time zone,xmodified_date timestamp without time zone,xcreated_by character varying(255),xmodified_by character varying(255),
   usu_seq bigint,usu_login character varying(60),usu_nome character varying(60),usu_cpf numeric(11,0),usu_email character varying(255),usu_ldap_dn character varying(255),usu_senha character varying(128),created_date timestamp without time zone,modified_date timestamp without time zone,created_by character varying(255),modified_by character varying(255));

CREATE SEQUENCE public.log_adm_usuario_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_usuario_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_usuario(id,data,operacao,usuario,ip,
    usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha,created_date,modified_date,created_by,modified_by) VALUES
    (nextval('public.log_adm_usuario_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.usu_seq,new.usu_login,new.usu_nome,new.usu_cpf,new.usu_email,new.usu_ldap_dn,new.usu_senha,new.created_date,new.modified_date,new.created_by,new.modified_by);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_usuario(id,data,operacao,usuario,ip,xusu_seq,xusu_login,xusu_nome,xusu_cpf,xusu_email,xusu_ldap_dn,xusu_senha,xcreated_date,xmodified_date,xcreated_by,xmodified_by,
    usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha,created_date,modified_date,created_by,modified_by) VALUES
    (nextval('public.log_adm_usuario_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.usu_seq,old.usu_login,old.usu_nome,old.usu_cpf,old.usu_email,old.usu_ldap_dn,old.usu_senha,old.created_date,old.modified_date,old.created_by,old.modified_by,
    new.usu_seq,new.usu_login,new.usu_nome,new.usu_cpf,new.usu_email,new.usu_ldap_dn,new.usu_senha,new.created_date,new.modified_date,new.created_by,new.modified_by);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_usuario(id,data,operacao,usuario,ip,usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha,created_date,modified_date,created_by,modified_by)
 VALUES
    (nextval('public.log_adm_usuario_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.usu_seq,old.usu_login,old.usu_nome,old.usu_cpf,old.usu_email,old.usu_ldap_dn,old.usu_senha,old.created_date,old.modified_date,old.created_by,old.modified_by);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_usuario_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_usuario
FOR EACH ROW
EXECUTE PROCEDURE public.adm_usuario_auid();

ALTER TABLE adm_usuario ENABLE TRIGGER trg_adm_usuario_auid;



CREATE TABLE public.log_adm_usuario_ip (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xuip_usu_seq bigint,xuip_ip character varying(15),xuip_ativo character,
   uip_usu_seq bigint,uip_ip character varying(15),uip_ativo character);

CREATE SEQUENCE public.log_adm_usuario_ip_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_usuario_ip_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_usuario_ip(id,data,operacao,usuario,ip,
    uip_usu_seq,uip_ip,uip_ativo) VALUES
    (nextval('public.log_adm_usuario_ip_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.uip_usu_seq,new.uip_ip,new.uip_ativo);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_usuario_ip(id,data,operacao,usuario,ip,xuip_usu_seq,xuip_ip,xuip_ativo,
    uip_usu_seq,uip_ip,uip_ativo) VALUES
    (nextval('public.log_adm_usuario_ip_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.uip_usu_seq,old.uip_ip,old.uip_ativo,
    new.uip_usu_seq,new.uip_ip,new.uip_ativo);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_usuario_ip(id,data,operacao,usuario,ip,uip_usu_seq,uip_ip,uip_ativo)
 VALUES
    (nextval('public.log_adm_usuario_ip_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.uip_usu_seq,old.uip_ip,old.uip_ativo);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_usuario_ip_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_usuario_ip
FOR EACH ROW
EXECUTE PROCEDURE public.adm_usuario_ip_auid();

ALTER TABLE adm_usuario_ip ENABLE TRIGGER trg_adm_usuario_ip_auid;



CREATE TABLE public.log_adm_usuario_perfil (
   id         BIGINT not null primary key,
   usuario    varchar(30),
   data       TIMESTAMP(0),
   operacao   char(1),
   ip         varchar(50),
   xusp_prf_seq bigint,xusp_usu_seq bigint,
   usp_prf_seq bigint,usp_usu_seq bigint);

CREATE SEQUENCE public.log_adm_usuario_perfil_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;

CREATE OR REPLACE FUNCTION adm_usuario_perfil_aiud() RETURNS trigger AS
$BODY$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_usuario_perfil(id,data,operacao,usuario,ip,
    usp_prf_seq,usp_usu_seq) VALUES
    (nextval('public.log_adm_usuario_perfil_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.usp_prf_seq,new.usp_usu_seq);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_usuario_perfil(id,data,operacao,usuario,ip,xusp_prf_seq,xusp_usu_seq,
    usp_prf_seq,usp_usu_seq) VALUES
    (nextval('public.log_adm_usuario_perfil_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.usp_prf_seq,old.usp_usu_seq,
    new.usp_prf_seq,new.usp_usu_seq);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_usuario_perfil(id,data,operacao,usuario,ip,usp_prf_seq,usp_usu_seq)
 VALUES
    (nextval('public.log_adm_usuario_perfil_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.usp_prf_seq,old.usp_usu_seq);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER public.trg_adm_usuario_perfil_auid
AFTER INSERT OR UPDATE OR DELETE
ON public.adm_usuario_perfil
FOR EACH ROW
EXECUTE PROCEDURE public.adm_usuario_perfil_auid();

ALTER TABLE adm_usuario_perfil ENABLE TRIGGER trg_adm_usuario_perfil_auid;



