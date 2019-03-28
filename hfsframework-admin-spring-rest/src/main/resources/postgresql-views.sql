CREATE OR REPLACE VIEW public.vw_adm_log AS
 SELECT row_number() OVER () AS id,
    v.usuario,
    v.data,
    v.operacao,
    v.ip,
    v.entidade,
    v.tabela,
    v.chave,
    v.datanumero
   FROM ( SELECT DISTINCT t.usuario,
            t.data,
            t.operacao,
            t.ip,
            t.entidade,
            t.tabela,
            t.chave,
            t.datanumero
           FROM vw_adm_log_dados t
          ORDER BY t.data DESC) v;

CREATE OR REPLACE VIEW public.vw_adm_log_dados AS
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Menu'::text AS entidade,
    'adm_menu'::text AS tabela,
    'mnu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_menu t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina'::text AS entidade,
    'adm_pagina'::text AS tabela,
    'pag_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_pagina t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina Perfil'::text AS entidade,
    'adm_pagina_perfil'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_pagina_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro'::text AS entidade,
    'adm_parametro'::text AS tabela,
    'par_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_parametro t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro Categoria'::text AS entidade,
    'adm_parametro_categoria'::text AS tabela,
    'pmc_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_parametro_categoria t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Perfil'::text AS entidade,
    'adm_perfil'::text AS tabela,
    'prf_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Ip'::text AS entidade,
    'adm_usuario_ip'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_usuario_ip t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Perfil'::text AS entidade,
    'adm_usuario_perfil'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero
   FROM log_adm_usuario_perfil t;

CREATE OR REPLACE VIEW public.vw_adm_log_valor AS
 SELECT row_number() OVER () AS id,
    v.usuario,
    v.data,
    v.operacao,
    v.ip,
    v.entidade,
    v.tabela,
    v.chave,
    v.datanumero,
    v.coluna,
    v.valoranterior,
    v.valor
   FROM ( SELECT DISTINCT t.usuario,
            t.data,
            t.operacao,
            t.ip,
            t.entidade,
            t.tabela,
            t.chave,
            t.datanumero,
            t.coluna,
            t.valoranterior,
            t.valor
           FROM vw_adm_log_valor_dados t
          ORDER BY t.data DESC) v;

CREATE OR REPLACE VIEW public.vw_adm_log_valor_dados AS
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Menu'::text AS entidade,
    'adm_menu'::text AS tabela,
    'mnu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'seq'::text AS coluna,
    t.xmnu_seq::character varying AS valoranterior,
    t.mnu_seq::character varying AS valor
   FROM log_adm_menu t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Menu'::text AS entidade,
    'adm_menu'::text AS tabela,
    'mnu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'descricao'::text AS coluna,
    t.xmnu_descricao AS valoranterior,
    t.mnu_descricao AS valor
   FROM log_adm_menu t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Menu'::text AS entidade,
    'adm_menu'::text AS tabela,
    'mnu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'pai seq'::text AS coluna,
    t.xmnu_pai_seq::character varying AS valoranterior,
    t.mnu_pai_seq::character varying AS valor
   FROM log_adm_menu t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Menu'::text AS entidade,
    'adm_menu'::text AS tabela,
    'mnu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'pag seq'::text AS coluna,
    t.xmnu_pag_seq::character varying AS valoranterior,
    t.mnu_pag_seq::character varying AS valor
   FROM log_adm_menu t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Menu'::text AS entidade,
    'adm_menu'::text AS tabela,
    'mnu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'ordem'::text AS coluna,
    t.xmnu_ordem::character varying AS valoranterior,
    t.mnu_ordem::character varying AS valor
   FROM log_adm_menu t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina'::text AS entidade,
    'adm_pagina'::text AS tabela,
    'pag_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'seq'::text AS coluna,
    t.xpag_seq::character varying AS valoranterior,
    t.pag_seq::character varying AS valor
   FROM log_adm_pagina t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina'::text AS entidade,
    'adm_pagina'::text AS tabela,
    'pag_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'url'::text AS coluna,
    t.xpag_url AS valoranterior,
    t.pag_url AS valor
   FROM log_adm_pagina t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina'::text AS entidade,
    'adm_pagina'::text AS tabela,
    'pag_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'descricao'::text AS coluna,
    t.xpag_descricao AS valoranterior,
    t.pag_descricao AS valor
   FROM log_adm_pagina t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina Perfil'::text AS entidade,
    'adm_pagina_perfil'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'pag seq'::text AS coluna,
    t.xpgl_pag_seq::character varying AS valoranterior,
    t.pgl_pag_seq::character varying AS valor
   FROM log_adm_pagina_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Pagina Perfil'::text AS entidade,
    'adm_pagina_perfil'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'prf seq'::text AS coluna,
    t.xpgl_prf_seq::character varying AS valoranterior,
    t.pgl_prf_seq::character varying AS valor
   FROM log_adm_pagina_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro'::text AS entidade,
    'adm_parametro'::text AS tabela,
    'par_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'seq'::text AS coluna,
    t.xpar_seq::character varying AS valoranterior,
    t.par_seq::character varying AS valor
   FROM log_adm_parametro t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro'::text AS entidade,
    'adm_parametro'::text AS tabela,
    'par_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'valor'::text AS coluna,
    t.xpar_valor AS valoranterior,
    t.par_valor AS valor
   FROM log_adm_parametro t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro'::text AS entidade,
    'adm_parametro'::text AS tabela,
    'par_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'descricao'::text AS coluna,
    t.xpar_descricao AS valoranterior,
    t.par_descricao AS valor
   FROM log_adm_parametro t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro'::text AS entidade,
    'adm_parametro'::text AS tabela,
    'par_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'codigo'::text AS coluna,
    t.xpar_codigo AS valoranterior,
    t.par_codigo AS valor
   FROM log_adm_parametro t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro'::text AS entidade,
    'adm_parametro'::text AS tabela,
    'par_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'pmc seq'::text AS coluna,
    t.xpar_pmc_seq::character varying AS valoranterior,
    t.par_pmc_seq::character varying AS valor
   FROM log_adm_parametro t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro Categoria'::text AS entidade,
    'adm_parametro_categoria'::text AS tabela,
    'pmc_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'seq'::text AS coluna,
    t.xpmc_seq::character varying AS valoranterior,
    t.pmc_seq::character varying AS valor
   FROM log_adm_parametro_categoria t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro Categoria'::text AS entidade,
    'adm_parametro_categoria'::text AS tabela,
    'pmc_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'descricao'::text AS coluna,
    t.xpmc_descricao AS valoranterior,
    t.pmc_descricao AS valor
   FROM log_adm_parametro_categoria t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Parametro Categoria'::text AS entidade,
    'adm_parametro_categoria'::text AS tabela,
    'pmc_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'ordem'::text AS coluna,
    t.xpmc_ordem::character varying AS valoranterior,
    t.pmc_ordem::character varying AS valor
   FROM log_adm_parametro_categoria t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Perfil'::text AS entidade,
    'adm_perfil'::text AS tabela,
    'prf_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'seq'::text AS coluna,
    t.xprf_seq::character varying AS valoranterior,
    t.prf_seq::character varying AS valor
   FROM log_adm_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Perfil'::text AS entidade,
    'adm_perfil'::text AS tabela,
    'prf_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'descricao'::text AS coluna,
    t.xprf_descricao AS valoranterior,
    t.prf_descricao AS valor
   FROM log_adm_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Perfil'::text AS entidade,
    'adm_perfil'::text AS tabela,
    'prf_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'geral'::text AS coluna,
    t.xprf_geral::character varying AS valoranterior,
    t.prf_geral::character varying AS valor
   FROM log_adm_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Perfil'::text AS entidade,
    'adm_perfil'::text AS tabela,
    'prf_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'administrador'::text AS coluna,
    t.xprf_administrador::character varying AS valoranterior,
    t.prf_administrador::character varying AS valor
   FROM log_adm_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'seq'::text AS coluna,
    t.xusu_seq::character varying AS valoranterior,
    t.usu_seq::character varying AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'login'::text AS coluna,
    t.xusu_login AS valoranterior,
    t.usu_login AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'nome'::text AS coluna,
    t.xusu_nome AS valoranterior,
    t.usu_nome AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'cpf'::text AS coluna,
    t.xusu_cpf::character varying AS valoranterior,
    t.usu_cpf::character varying AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'email'::text AS coluna,
    t.xusu_email AS valoranterior,
    t.usu_email AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'ldap dn'::text AS coluna,
    t.xusu_ldap_dn AS valoranterior,
    t.usu_ldap_dn AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario'::text AS entidade,
    'adm_usuario'::text AS tabela,
    'usu_seq'::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'senha'::text AS coluna,
    t.xusu_senha AS valoranterior,
    t.usu_senha AS valor
   FROM log_adm_usuario t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Ip'::text AS entidade,
    'adm_usuario_ip'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'usu seq'::text AS coluna,
    t.xuip_usu_seq::character varying AS valoranterior,
    t.uip_usu_seq::character varying AS valor
   FROM log_adm_usuario_ip t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Ip'::text AS entidade,
    'adm_usuario_ip'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'ip'::text AS coluna,
    t.xuip_ip AS valoranterior,
    t.uip_ip AS valor
   FROM log_adm_usuario_ip t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Ip'::text AS entidade,
    'adm_usuario_ip'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'ativo'::text AS coluna,
    t.xuip_ativo::character varying AS valoranterior,
    t.uip_ativo::character varying AS valor
   FROM log_adm_usuario_ip t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Perfil'::text AS entidade,
    'adm_usuario_perfil'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'prf seq'::text AS coluna,
    t.xusp_prf_seq::character varying AS valoranterior,
    t.usp_prf_seq::character varying AS valor
   FROM log_adm_usuario_perfil t
UNION
 SELECT t.usuario,
    t.data,
    t.operacao,
    t.ip,
    'Usuario Perfil'::text AS entidade,
    'adm_usuario_perfil'::text AS tabela,
    NULL::text AS chave,
    to_number(to_char(t.data, 'YYYYMMDDHH24MISS'::text), '99999999999999'::text) AS datanumero,
    'usu seq'::text AS coluna,
    t.xusp_usu_seq::character varying AS valoranterior,
    t.usp_usu_seq::character varying AS valor
   FROM log_adm_usuario_perfil t;
