CREATE OR REPLACE FUNCTION public.adm_menu_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_pagina_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_pagina_perfil_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_parametro_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_parametro_categoria_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_perfil_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_usuario_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO public.log_adm_usuario(id,data,operacao,usuario,ip,
    usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha) VALUES
    (nextval('public.log_adm_usuario_seq'), current_timestamp, 'I', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    new.usu_seq,new.usu_login,new.usu_nome,new.usu_cpf,new.usu_email,new.usu_ldap_dn,new.usu_senha);
    RETURN NEW;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO public.log_adm_usuario(id,data,operacao,usuario,ip,xusu_seq,xusu_login,xusu_nome,xusu_cpf,xusu_email,xusu_ldap_dn,xusu_senha,
    usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha) VALUES
    (nextval('public.log_adm_usuario_seq'), current_timestamp, 'U', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.usu_seq,old.usu_login,old.usu_nome,old.usu_cpf,old.usu_email,old.usu_ldap_dn,old.usu_senha,
    new.usu_seq,new.usu_login,new.usu_nome,new.usu_cpf,new.usu_email,new.usu_ldap_dn,new.usu_senha);
    RETURN NEW;
  ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO public.log_adm_usuario(id,data,operacao,usuario,ip,usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha)
 VALUES
    (nextval('public.log_adm_usuario_seq'), current_timestamp, 'D', coalesce(pkg_adm_obter_usuario(), session_user),
    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)),
    old.usu_seq,old.usu_login,old.usu_nome,old.usu_cpf,old.usu_email,old.usu_ldap_dn,old.usu_senha);
    RETURN OLD;
  END IF;
  RETURN NULL;
END;
$function$;

CREATE OR REPLACE FUNCTION public.adm_usuario_ip_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.adm_usuario_perfil_aiud()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
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
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_auditar_tabela(p_esquema character varying, p_tabela character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE                          
    v_comando VARCHAR(32676);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  

    v_comando := pkg_adm_criar_tabela(p_esquema, p_tabela) || v_cr;
    v_comando := v_comando || pkg_adm_criar_sequence(p_esquema, p_tabela) || v_cr;
    v_comando := v_comando || pkg_adm_gerar_function_after(p_esquema, p_tabela) || v_cr;
    v_comando := v_comando || pkg_adm_gerar_trigger_after(p_esquema, p_tabela) || v_cr;
    v_comando := v_comando || pkg_adm_habilita_trigger_after(p_tabela, true) || v_cr;

    RETURN v_comando;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_criar_sequence(p_esquema character varying, p_tabela character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE
	v_comando VARCHAR(4000);
BEGIN
  v_comando := 'CREATE SEQUENCE ' || LOWER(p_esquema) || '.log_' || lower(p_tabela) || '_seq minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 CYCLE;' || chr(13) || chr(10);
  RETURN v_comando;
END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_criar_tabela(p_esquema character varying, p_tabela character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE                          
    v_comando VARCHAR(32000);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  

    v_comando := 'CREATE TABLE ' || LOWER(p_esquema) || '.log_' || LOWER(p_tabela) || ' (' || v_cr;
    v_comando := v_comando || '   id         BIGINT not null primary key,' || v_cr;
    v_comando := v_comando || '   usuario    varchar(30),' || v_cr;
    v_comando := v_comando || '   data       TIMESTAMP(0),' || v_cr;
    v_comando := v_comando || '   operacao   char(1),' || v_cr;
    v_comando := v_comando || '   ip         varchar(50),' || v_cr;
    v_comando := v_comando || '   ' || pkg_adm_obter_estrutura_tabela(p_esquema, p_tabela, 'x') || ',' || v_cr;
    v_comando := v_comando || '   ' || pkg_adm_obter_estrutura_tabela(p_esquema, p_tabela, '') ||');' || v_cr;

    --RAISE NOTICE '%', v_comando;
    RETURN v_comando;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_drop_auditoria(p_esquema character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
DECLARE                          
    tabela_rec RECORD;
    v_comando VARCHAR(32676);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  
    v_comando := '';
    
     FOR tabela_rec in (
	select t.table_name
	from information_schema.tables t
	where t.table_schema=lower(p_esquema)
	and t.table_type='BASE TABLE'
      and t.table_name <> 'adm_usuario'
      and t.table_name not like 'log_%'
      and t.table_name not like 'vw_%'
      and t.table_name not like '%_aud'
      and t.table_name like 'adm_%'
      ORDER BY T.TABLE_NAME
     )
     
     LOOP
         v_comando := v_comando || 'DROP TRIGGER trg_' || lower(tabela_rec.table_name) || '_auid ON log_' || lower(tabela_rec.table_name) || ';' || v_cr;
         v_comando := v_comando || 'DROP FUNCTION trg_' || lower(tabela_rec.table_name) || '_aiud();' || v_cr;
         v_comando := v_comando || 'DROP SEQUENCE log_' || lower(tabela_rec.table_name) || '_seq;' || v_cr;
         v_comando := v_comando || '/*--------------------------------------------------------------*/' || v_cr;
     END LOOP;
     
         v_comando := v_comando || 'DROP TABLE log_ADM_PARAMETRO;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_PARAMETRO_CATEGORIA;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_PAGINA_PERFIL;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_MENU;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_LOG_COLUNA;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_FUNCIONARIO_PERFIL;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_FUNCIONARIO;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_FUNCIONALIDADE_PERFIL;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_FUNCIONALIDADE_PAGINA;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_FUNCIONALIDADE;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_PAGINA;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_CARGO_PERFIL;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_CARGO_FUNCIONARIO;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_CARGO;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_PERFIL;' || v_cr;
         v_comando := v_comando || 'DROP TABLE log_ADM_SETOR;' || v_cr;

     RAISE NOTICE '%', v_comando;
    --RETURN v_comando;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_gerar_function_after(p_esquema character varying, p_tabela character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE
    v_comando VARCHAR(32000);
    v_tabela  VARCHAR(30);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  
    v_tabela := LOWER(p_tabela);

    v_comando := 'CREATE OR REPLACE FUNCTION ' || v_tabela;
    v_comando := v_comando || '_aiud() RETURNS trigger AS' || v_cr;
    v_comando := v_comando || '\$BODY\$' || v_cr;
    v_comando := v_comando || 'BEGIN' || v_cr;
    v_comando := v_comando || '  IF (TG_OP = ''INSERT'') THEN' || v_cr;
    v_comando := v_comando || '    INSERT INTO ' || LOWER(p_esquema) || '.log_' || v_tabela || '(id,data,operacao,usuario,ip,' || v_cr;
    v_comando := v_comando || '    ' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, '')  || ') VALUES' || v_cr;
    v_comando := v_comando || '    (nextval(''' || LOWER(p_esquema) || '.log_' || v_tabela || '_seq''), current_timestamp, ''I'', coalesce(pkg_adm_obter_usuario(), session_user),' || v_cr;
    v_comando := v_comando || '    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),''/'')-1)),' || v_cr;
    v_comando := v_comando || '    ' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, 'NEW.') || ');' || v_cr;
    v_comando := v_comando || '    RETURN NEW;' || v_cr;
    v_comando := v_comando || '  ELSIF (TG_OP = ''UPDATE'') THEN' || v_cr;
    v_comando := v_comando || '    INSERT INTO ' || LOWER(p_esquema) || '.log_' || v_tabela || '(id,data,operacao,usuario,ip,' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, 'X') || ',' || v_cr;
    v_comando := v_comando || '    ' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, '') || ') VALUES' || v_cr;
    v_comando := v_comando || '    (nextval(''' || LOWER(p_esquema) || '.log_' || v_tabela || '_seq''), current_timestamp, ''U'', coalesce(pkg_adm_obter_usuario(), session_user),' || v_cr;
    v_comando := v_comando || '    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),''/'')-1)),' || v_cr;
    v_comando := v_comando || '    ' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, 'OLD.') || ',' || v_cr;
    v_comando := v_comando || '    ' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, 'NEW.') || ');' || v_cr;
    v_comando := v_comando || '    RETURN NEW;' || v_cr;
    v_comando := v_comando || '  ELSIF (TG_OP = ''DELETE'') THEN' || v_cr;
    v_comando := v_comando || '        INSERT INTO ' || LOWER(p_esquema) || '.log_' || v_tabela || '(id,data,operacao,usuario,ip,' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, '') || ')' || v_cr;
    v_comando := v_comando || ' VALUES' || v_cr;
    v_comando := v_comando || '    (nextval(''' || LOWER(p_esquema) || '.log_' || LOWER(p_tabela) || '_seq''), current_timestamp, ''D'', coalesce(pkg_adm_obter_usuario(), session_user),' || v_cr;
    v_comando := v_comando || '    coalesce(pkg_adm_obter_ip_usuario(), substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),''/'')-1)),' || v_cr;
    v_comando := v_comando || '    ' || pkg_adm_obter_colunas_tabela(p_esquema, p_tabela, 'OLD.') || ');' || v_cr;
    v_comando := v_comando || '    RETURN OLD;' || v_cr;
    v_comando := v_comando || '  END IF;' || v_cr;
    v_comando := v_comando || '  RETURN NULL;' || v_cr;
    v_comando := v_comando || 'END;' || v_cr;
    v_comando := v_comando || '\$BODY\$' || v_cr;
    v_comando := v_comando || '  LANGUAGE plpgsql VOLATILE' || v_cr;
    v_comando := v_comando || '  COST 100;' || v_cr;

    --RAISE NOTICE '%', v_comando;
    RETURN v_comando;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_gerar_trigger_after(p_esquema character varying, p_tabela character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE
    v_comando VARCHAR(32000);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  
   v_comando := 'CREATE TRIGGER ' || LOWER(p_esquema) || '.' || 'trg_' || LOWER(p_tabela) || '_auid' || v_cr;
   v_comando := v_comando || 'AFTER INSERT OR UPDATE OR DELETE' || v_cr;
   v_comando := v_comando || 'ON ' || LOWER(p_esquema) || '.' || LOWER(p_tabela) || v_cr;
   v_comando := v_comando || 'FOR EACH ROW' || v_cr;
   v_comando := v_comando || 'EXECUTE PROCEDURE ' || LOWER(p_esquema) || '.' || LOWER(p_tabela) || '_auid();' || v_cr;

    --RAISE NOTICE '%', v_comando;
    RETURN v_comando;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_habilita_trigger_after(p_tabela character varying, p_habilita boolean)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE
    v_comando VARCHAR(32000);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  

    IF p_habilita THEN
      v_comando := 'ALTER TABLE ' || LOWER(p_tabela) || ' ENABLE TRIGGER trg_' || LOWER(p_tabela) || '_auid;' || v_cr;
    ELSE
      v_comando := 'ALTER TABLE ' || LOWER(p_tabela) || ' DISABLE TRIGGER trg_' || LOWER(p_tabela) || '_auid;' || v_cr;
    END IF;    

    --RAISE NOTICE '%', v_comando;
    RETURN v_comando;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_montar_auditoria(p_esquema character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$DECLARE                          
    tabela_rec RECORD;
  BEGIN
     FOR tabela_rec in (
	select t.table_name
	from information_schema.tables t
	where t.table_schema=lower(p_esquema)
	and t.table_type='BASE TABLE'
      and t.table_name not like 'log_%'
      and t.table_name not like 'vw_%'
      and t.table_name not like '%_aud'
      and t.table_name like 'adm_%'
      ORDER BY T.TABLE_NAME
     )
     LOOP
         RAISE NOTICE '%', pkg_adm_auditar_tabela(p_esquema,tabela_rec.TABLE_NAME);
         RAISE NOTICE '--------------------------------------------------------------';
     END LOOP;
  end;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_montar_view_adm_log(p_esquema character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$DECLARE
    tabela_rec RECORD;
    v_colunas RECORD;
  V_QTD bigint;
  V_COLUNA VARCHAR(100);
    v_comando VARCHAR(32676);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  
   RAISE NOTICE '%', 'CREATE OR REPLACE VIEW VW_ADM_LOG_DADOS AS' || v_cr;
   
   FOR tabela_rec in (
	select t.table_name
	from information_schema.tables t
	where t.table_schema=lower(p_esquema)
	and t.table_type='BASE TABLE'
      and t.table_name not like 'log_%'
      and t.table_name not like 'vw_%'
      and t.table_name not like '%_aud'
      and t.table_name like 'adm_%'
      ORDER BY T.TABLE_NAME
   )
     LOOP
	SELECT COUNT(*)
	INTO V_QTD
	FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc,
	INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu
	WHERE kcu.table_schema=p_esquema
	and kcu.table_schema=tc.table_schema
	and kcu.table_name=tabela_rec.Table_NAME
	and kcu.table_name=tc.table_name
	and kcu.constraint_name = tc.CONSTRAINT_name
	and tc.CONSTRAINT_TYPE IN ('PRIMARY KEY');

        IF V_QTD = 1 THEN
		SELECT '''' || kcu.column_name || ''''
		INTO V_COLUNA
		FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc,
		INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu
		WHERE kcu.table_schema=p_esquema
		and kcu.table_schema=tc.table_schema
		and kcu.table_name=tabela_rec.Table_NAME
		and kcu.table_name=tc.table_name
		and kcu.constraint_name = tc.CONSTRAINT_name
		and tc.CONSTRAINT_TYPE IN ('PRIMARY KEY');
        ELSE
          V_COLUNA := 'NULL';
        END IF;

          v_comando := 'SELECT t.usuario, t.data, t.operacao, t.ip, ''' || initcap(replace(substr(tabela_rec.table_name,5,length(tabela_rec.table_name)),'_',' '));
          v_comando := v_comando || ''' entidade, ''' || lower(tabela_rec.table_name) || ''' tabela, ' || V_COLUNA || ' chave, to_number(to_char(t.data,''YYYYMMDDHH24MISS''),''99999999999999'') dataNumero' || v_cr;
          v_comando := v_comando || '    FROM log_' || lower(tabela_rec.table_name) || ' t' || v_cr;		
          v_comando := v_comando || 'UNION';

	  RAISE NOTICE '%', v_comando;
   END LOOP;

   v_comando := 'CREATE OR REPLACE VIEW public.vw_adm_log AS ';
   v_comando := v_comando || 'SELECT row_number() OVER () AS id,v.usuario,v.data,v.operacao,v.ip, v.entidade,v.tabela,v.chave,v.datanumero ';
   v_comando := v_comando || 'FROM ( SELECT DISTINCT t.usuario,t.data,t.operacao,t.ip,t.entidade,t.tabela,t.chave,t.datanumero ';
   v_comando := v_comando || 'FROM vw_adm_log_dados t ';
   v_comando := v_comando || 'ORDER BY t.data DESC) v;';

   RAISE NOTICE '%', v_comando;

  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_montar_view_adm_log_valor(p_esquema character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$DECLARE                          
    tabela_rec RECORD;
    v_colunas RECORD;
  V_QTD bigint;
  V_COLUNA VARCHAR(100);
    v_comando VARCHAR(32676);
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  
   RAISE NOTICE '%', 'CREATE OR REPLACE VIEW VW_ADM_LOG_VALOR_DADOS AS' || v_cr;
   
   FOR tabela_rec in (
	select t.table_name
	from information_schema.tables t
	where t.table_schema=lower(p_esquema)
	and t.table_type='BASE TABLE'
      and t.table_name not like 'log_%'
      and t.table_name not like 'vw_%'
      and t.table_name not like '%_aud'
      and t.table_name like 'adm_%'
      ORDER BY T.TABLE_NAME
   )
     LOOP
	SELECT COUNT(*)
	INTO V_QTD
	FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc,
	INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu
	WHERE kcu.table_schema=p_esquema
	and kcu.table_schema=tc.table_schema
	and kcu.table_name=tabela_rec.Table_NAME
	and kcu.table_name=tc.table_name
	and kcu.constraint_name = tc.CONSTRAINT_name
	and tc.CONSTRAINT_TYPE IN ('PRIMARY KEY');

        IF V_QTD = 1 THEN
		SELECT '''' || kcu.column_name || ''''
		INTO V_COLUNA
		FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc,
		INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu
		WHERE kcu.table_schema=p_esquema
		and kcu.table_schema=tc.table_schema
		and kcu.table_name=tabela_rec.Table_NAME
		and kcu.table_name=tc.table_name
		and kcu.constraint_name = tc.CONSTRAINT_name
		and tc.CONSTRAINT_TYPE IN ('PRIMARY KEY');
        ELSE
          V_COLUNA := 'NULL';
        END IF;

         FOR v_colunas IN (
		SELECT c.COLUMN_NAME nome
		FROM INFORMATION_SCHEMA.COLUMNS c, information_schema.tables t
		WHERE C.TABLE_SCHEMA=lower(p_esquema)
		AND C.TABLE_SCHEMA=T.TABLE_SCHEMA
		AND c.TABLE_NAME=t.TABLE_NAME 
		AND t.TABLE_NAME =lower(tabela_rec.table_name)
		AND t.table_type='BASE TABLE'
		AND c.data_type NOT IN ('bytea','text')
		ORDER BY c.TABLE_NAME, c.ORDINAL_POSITION) 
	LOOP

          v_comando := 'SELECT t.usuario, t.data, t.operacao, t.ip, ''' || initcap(replace(substr(tabela_rec.table_NAME,5,length(tabela_rec.table_NAME)),'_',' '));
          v_comando := v_comando || ''' entidade, ''' || lower(tabela_rec.table_NAME) || ''' tabela, ' || V_COLUNA || ' chave, to_number(to_char(t.data,''YYYYMMDDHH24MISS''),''99999999999999'') dataNumero, ''';
          v_comando := v_comando || replace(lower(substr(v_colunas.nome,5,length(v_colunas.nome))),'_', ' ') || ''' coluna, cast(t.x' || lower(v_colunas.nome) ||  ' as varchar) valorAnterior, cast(t.' || lower(v_colunas.nome) || ' as varchar) valor' || v_cr;
          v_comando := v_comando || '    FROM log_' || lower(tabela_rec.table_NAME) || ' t' || v_cr;
          v_comando := v_comando || 'UNION';

	  RAISE NOTICE '%', v_comando;
     END LOOP;
   END LOOP;

   v_comando := 'CREATE OR REPLACE VIEW public.vw_adm_log_valor AS ';
   v_comando := v_comando || 'SELECT row_number() OVER () AS id,v.usuario,v.data,v.operacao,v.ip,v.entidade,v.tabela,v.chave,v.datanumero,v.coluna,v.valoranterior,v.valor ';
   v_comando := v_comando || 'FROM ( SELECT DISTINCT t.usuario,t.data,t.operacao,t.ip,t.entidade,t.tabela,t.chave,t.datanumero,t.coluna,t.valoranterior,t.valor ';
   v_comando := v_comando || 'FROM vw_adm_log_valor_dados t ';
   v_comando := v_comando || 'ORDER BY t.data DESC) v;';
   
   RAISE NOTICE '%', v_comando;

  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_obter_colunas_tabela(p_esquema character varying, p_tabela character varying, p_prefixo character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$DECLARE
	v_resultado VARCHAR(32000);
	v_colunas RECORD;
BEGIN
	v_resultado := '';

	FOR v_colunas IN (
		SELECT c.COLUMN_NAME nome
		FROM INFORMATION_SCHEMA.COLUMNS c, information_schema.tables t
		WHERE C.TABLE_SCHEMA=lower(p_esquema)
		AND C.TABLE_SCHEMA=T.TABLE_SCHEMA
		AND c.TABLE_NAME=t.TABLE_NAME 
		AND t.TABLE_NAME =lower(p_tabela)
		AND t.table_type='BASE TABLE'
		AND c.data_type NOT IN ('bytea','text')
		ORDER BY c.TABLE_NAME, c.ORDINAL_POSITION) 
	LOOP
		v_resultado := v_resultado || lower(p_prefixo) || lower(v_colunas.nome) || ',';
	END LOOP;

	v_resultado := substr(v_resultado, 1, length(v_resultado) - 1);

	RETURN v_resultado;
END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_obter_estrutura_tabela(p_esquema character varying, p_tabela character varying, p_prefixo_coluna character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE
    v_resultado VARCHAR(32000);
    v_colunas RECORD;
    v_cr CHAR(2);
  BEGIN
    v_cr := chr(13) || chr(10);  
    v_resultado := NULL;

    FOR v_colunas IN (
		SELECT c.COLUMN_NAME coluna, c.data_type tipo, 
		(case c.data_type when 'bigint' then null else c.numeric_precision end) tamanho, 
		c.numeric_scale decimais, c.character_maximum_length tamanho_char
		FROM INFORMATION_SCHEMA.COLUMNS c, information_schema.tables t
		WHERE C.TABLE_SCHEMA=lower(p_esquema)
		AND C.TABLE_SCHEMA=T.TABLE_SCHEMA
		AND c.TABLE_NAME=t.TABLE_NAME 
		AND t.TABLE_NAME =lower(p_tabela)
		AND t.table_type='BASE TABLE'
		AND c.data_type NOT IN ('bytea','text')
		ORDER BY c.TABLE_NAME, c.ORDINAL_POSITION
    ) LOOP

      IF (v_resultado IS NULL) THEN
        v_resultado := p_prefixo_coluna || v_colunas.coluna;
      ELSE
        v_resultado := v_resultado || ',' || p_prefixo_coluna || v_colunas.coluna;
      END IF;

      IF (v_colunas.tipo = 'bigint') THEN
        v_resultado := v_resultado || ' bigint';
      ELSEIF (v_colunas.tipo = 'timestamp') THEN
        v_resultado := v_resultado || ' timestamp(0)';
      ELSIF (v_colunas.tipo IN ('char', 'varchar', 'character varying')) THEN
        v_resultado := v_resultado || ' ' || v_colunas.tipo || '(' || v_colunas.tamanho_char || ')';
      ELSIF (v_colunas.decimais IS NOT NULL) THEN
        v_resultado := v_resultado || ' ' || v_colunas.tipo || '(' || v_colunas.tamanho || ',' || v_colunas.decimais || ')';
      ELSIF (v_colunas.tamanho IS NOT NULL) THEN
        v_resultado := v_resultado || ' ' || v_colunas.tipo || '(' || v_colunas.tamanho || ')';
      ELSE
        v_resultado := v_resultado || ' ' || v_colunas.tipo;
      END IF;

    END LOOP;

    RETURN v_resultado;
  END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_obter_ip_usuario()
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$declare
	v_ip_usuario_aplicacao VARCHAR(50);
BEGIN
	SELECT current_setting('myvars.usuario_ip')
	INTO v_ip_usuario_aplicacao;

	IF strpos(v_ip_usuario_aplicacao,'.') = 0 THEN
		v_ip_usuario_aplicacao:='127.0.0.1';
	END IF;
	RETURN v_ip_usuario_aplicacao;
EXCEPTION
    WHEN OTHERS THEN
	v_ip_usuario_aplicacao:='127.0.0.1';
	RETURN v_ip_usuario_aplicacao;
END;
$function$;

CREATE OR REPLACE FUNCTION public.pkg_adm_obter_usuario()
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$declare
	v_usuario_aplicacao   VARCHAR(30);
BEGIN
	select current_setting('myvars.usuario_login')
	INTO v_usuario_aplicacao;

	IF v_usuario_aplicacao IS NULL THEN
		v_usuario_aplicacao:='sem usuario';
	END IF;

	RETURN v_usuario_aplicacao;
EXCEPTION
    WHEN OTHERS THEN
	v_usuario_aplicacao:='sem usuario';
	RETURN v_usuario_aplicacao;	
END;$function$;
