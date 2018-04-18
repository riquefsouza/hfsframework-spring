insert into ADM_PERFIL (prf_seq, prf_descricao, prf_geral, prf_administrador)
values (1, 'Geral', 'S', 'N');
insert into ADM_PERFIL (prf_seq, prf_descricao, prf_geral, prf_administrador)
values (2, 'Administrador', 'N', 'S');

insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (1, 'admin/admParametroCategoria/listarAdmParametroCategoria.xhtml', 'br.com.hfsframework.admin.view.admParametroCategoria.AdmParametroCategoriaMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (2, 'admin/admParametroCategoria/editarAdmParametroCategoria.xhtml', 'br.com.hfsframework.admin.view.admParametroCategoria.AdmParametroCategoriaMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (3, 'admin/admParametro/listarAdmParametro.xhtml', 'br.com.hfsframework.admin.view.admParametro.AdmParametroMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (4, 'admin/admParametro/editarAdmParametro.xhtml', 'br.com.hfsframework.admin.view.admParametro.AdmParametroMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (5, 'admin/admPerfil/listarAdmPerfil.xhtml', 'br.com.hfsframework.admin.view.admPerfil.AdmPerfilMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (6, 'admin/admPerfil/editarAdmPerfil.xhtml', 'br.com.hfsframework.admin.view.admPerfil.AdmPerfilMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (7, 'admin/admFuncionalidade/listarAdmFuncionalidade.xhtml', 'br.com.hfsframework.admin.view.admFuncionalidade.AdmFuncionalidadeMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (8, 'admin/admFuncionalidade/editarAdmFuncionalidade.xhtml', 'br.com.hfsframework.admin.view.admFuncionalidade.AdmFuncionalidadeMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (9, 'admin/admPagina/listarAdmPagina.xhtml', 'br.com.hfsframework.admin.view.admPagina.AdmPaginaMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (10, 'admin/admPagina/editarAdmPagina.xhtml', 'br.com.hfsframework.admin.view.admPagina.AdmPaginaMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (11, 'admin/admMenu/listarAdmMenu.xhtml', 'br.com.hfsframework.admin.view.admMenu.AdmMenuMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (12, 'admin/admMenu/editarAdmMenu.xhtml', 'br.com.hfsframework.admin.view.admMenu.AdmMenuMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (13, 'admin/admCargo/listarAdmCargo.xhtml', 'br.com.hfsframework.admin.view.admCargo.AdmCargoMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (14, 'admin/admCargo/editarAdmCargo.xhtml', 'br.com.hfsframework.admin.view.admCargo.AdmCargoMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (15, 'admin/admFuncionario/listarAdmFuncionario.xhtml', 'br.com.hfsframework.admin.view.admFuncionario.AdmFuncionarioMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (16, 'admin/admFuncionario/editarAdmFuncionario.xhtml', 'br.com.hfsframework.admin.view.admFuncionario.AdmFuncionarioMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (17, 'admin/admSetor/listarAdmSetor.xhtml', 'br.com.hfsframework.admin.view.admSetor.AdmSetorMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (18, 'admin/admSetor/editarAdmSetor.xhtml', 'br.com.hfsframework.admin.view.admSetor.AdmSetorMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (19, 'admin/admUsuario/listarAdmUsuario.xhtml', 'br.com.hfsframework.admin.view.admUsuario.AdmUsuarioMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (20, 'admin/vwAdmLog/listarVwAdmLog.xhtml', 'br.com.hfsframework.admin.view.vwAdmLog.VwAdmLogMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (21, 'admin/admLogColuna/listarAdmLogColuna.xhtml', 'br.com.hfsframework.admin.view.admLogColuna.AdmLogColunaMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (22, 'admin/admLogColuna/editarAdmLogColuna.xhtml', 'br.com.hfsframework.admin.view.admLogColuna.AdmLogColunaMB');
insert into ADM_PAGINA (pag_seq, pag_url, pag_mb)
values (23, 'admin/visualizarArqLogServidor.xhtml', 'br.com.hfsframework.admin.view.VisualizarArqLogServidorMB');

insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (1, 1, 'Categoria dos Parâmetros de Configuração (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (2, 2, 'Editar Categoria dos Parâmetros de Configuração (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (3, 3, 'Parâmetros de Configuração (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (4, 4, 'Editar Parâmetros de Configuração (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (5, 5, 'Administrar Perfil (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (6, 6, 'Editar Administrar Perfil (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (7, 7, 'Administrar Funcionalidade (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (8, 8, 'Editar Administrar Funcionalidade (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (9, 9, 'Administrar Página (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (10, 10, 'Editar Administrar Página (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (11, 11, 'Administrar Menu (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (12, 12, 'Editar Administrar Menu (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (13, 13, 'Administrar os Cargos (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (14, 14, 'Editar Administrar os Cargos (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (15, 15, 'Administrar os Funcionários (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (16, 16, 'Editar Administrar os Funcionários (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (17, 17, 'Administrar os Setores (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (18, 18, 'Editar Administrar os Setores (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (19, 19, 'Visualizar os Usuários (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (20, 20, 'Visualizar os Logs de Auditoria (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (21, 21, 'Administrar os Campos do Log de Auditoria (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (22, 22, 'Editar Administrar os Campos do Log de Auditoria (Administrativo)');
insert into ADM_FUNCIONALIDADE (fun_seq, fun_pag_seq, fun_descricao)
values (23, 23, 'Visualizar Arquivo de Log do Servidor (Administrativo)');


insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (1, 1);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (2, 2);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (3, 3);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (4, 4);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (5, 5);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (6, 6);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (7, 7);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (8, 8);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (9, 9);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (10, 10);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (11, 11);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (12, 12);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (13, 13);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (14, 14);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (15, 15);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (16, 16);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (17, 17);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (18, 18);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (19, 19);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (20, 20);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (21, 21);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (22, 22);
insert into ADM_FUNCIONALIDADE_PAGINA (fpg_fun_seq, fpg_pag_seq)
values (23, 23);



insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (1, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (2, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (3, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (4, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (5, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (6, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (7, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (8, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (9, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (10, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (11, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (12, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (13, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (14, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (15, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (16, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (17, 1);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (17, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (18, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (19, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (20, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (21, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (22, 2);
insert into ADM_FUNCIONALIDADE_PERFIL (fpl_fun_seq, fpl_prf_seq)
values (23, 2);



insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (1, 'Administrativo', null, null, 1);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (2, 'Categoria dos Parâmetros de Configuração (Administrativo)', 1, 1, 2);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (3, 'Parâmetros de Configuração (Administrativo)', 1, 3, 3);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (4, 'Administrar Perfil (Administrativo)', 1, 5, 4);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (5, 'Administrar Funcionalidade (Administrativo)', 1, 7, 5);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (6, 'Administrar Página (Administrativo)', 1, 9, 6);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (7, 'Administrar Menu (Administrativo)', 1, 11, 7);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (8, 'Administrar os Cargos (Administrativo)', 1, 13, 8);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (9, 'Administrar os Funcionários (Administrativo)', 1, 15, 9);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (10, 'Administrar os Setores (Administrativo)', 1, 17, 10);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (11, 'Visualizar os Usuários (Administrativo)', 1, 19, 11);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (12, 'Visualizar os Logs de Auditoria (Administrativo)', 1, 20, 12);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (13, 'Administrar os Campos do Log de Auditoria (Administrativo)', 1, 21, 13);
insert into ADM_MENU (mnu_seq, mnu_descricao, mnu_pai_seq, mnu_fun_seq, mnu_ordem)
values (14, 'Visualizar Arquivo de Log do Servidor (Administrativo)', 1, 22, 14);



insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (1, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (2, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (3, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (4, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (5, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (6, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (7, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (8, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (9, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (10, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (11, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (12, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (13, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (14, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (15, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (16, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (17, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (18, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (19, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (20, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (21, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (22, 2);
insert into ADM_PAGINA_PERFIL (pgl_pag_seq, pgl_prf_seq)
values (23, 2);

insert into ADM_USUARIO (usu_matricula, usu_login, usu_nome, usu_data, usu_cpf, usu_email, usu_ldap_dn, usu_senha,
created_date,modified_date,created_by,modified_by)
values (93203, 'henrique.souza', 'Henrique Figueiredo de Souza', to_date('17-07-2017 13:49:12', 'dd-mm-yyyy hh24:mi:ss'), 63266661630, 'hfs@temp.com', 
'CN=henrique.souza,OU=DIREM,OU=COAS,OU=SST,OU=TRT,DC=trtrio,DC=gov,DC=br','$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy',
to_date('17-07-2017 13:49:12', 'dd-mm-yyyy hh24:mi:ss'),to_date('17-07-2017 13:49:12', 'dd-mm-yyyy hh24:mi:ss'),'Auditor criador','Auditor Modificador');

insert into ADM_USUARIO_IP (uip_matricula, uip_ip, uip_ativo) values (93203, '10.1.107.123', 'N');
insert into ADM_USUARIO_IP (uip_matricula, uip_ip, uip_ativo) values (93203, '127.0.0.1', 'N');


insert into ADM_PARAMETRO_CATEGORIA (pmc_seq, pmc_descricao, pmc_ordem)
values (1, 'Parâmetros do Tribunal', 1);
insert into ADM_PARAMETRO_CATEGORIA (pmc_seq, pmc_descricao, pmc_ordem)
values (2, 'Parâmetros de Login', 2);
insert into ADM_PARAMETRO_CATEGORIA (pmc_seq, pmc_descricao, pmc_ordem)
values (3, 'Parâmetros de E-mail', 3);
insert into ADM_PARAMETRO_CATEGORIA (pmc_seq, pmc_descricao, pmc_ordem)
values (4, 'Parâmetros de Conexão de Rede', 4);

insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (1, 'Tribunal Regional do Trabalho da 1a. Região', 'Nome do tribunal onde o sistema está instalado.', 'NOME_TRIBUNAL', 1);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (2, 'TRT1', 'Sigla do tribunal onde o sistema está instalado.', 'SIGLA_TRIBUNAL', 1);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (3, '080009', 'Código númérico de 6 dígitos que identifica o órgão no SIAFI.', 'CODIGO_UNIDADE_GESTORA', 1);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (4, '102', 'Código númérico de 3 dígitos da UG no código de barras da GRU.', 'APELIDO_UNIDADE_GESTORA', 1);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (5, 'false', 'Bloquear o sistema para que os usuários, exceto do administador, não façam login', 'BLOQUEAR_LOGIN', 2);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (6, 'Produção', 'Define o ambiente onde o sistema está instalado. Este parâmetro pode ser preenchido com: desenvolvimento, homologação ou produção', 'AMBIENTE_SISTEMA', 2);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (7, 'NOME_USUARIO', 'Define o atributo usado para efetuar login no sistema. Este parâmetro pode ser preenchido com: NOME_USUARIO ou CPF', 'ATRIBUTO_LOGIN', 2);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (8, 'smtp.com.br', 'Servidor SMTP para que o sistema envie e-mail.', 'SMTP_SERVIDOR', 3);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (9, '25', 'Porta do servidor SMTP para que o sistema envie e-mail.', 'SMTP_PORTA', 3);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (10, null, 'Usuário para login no servidor SMTP.', 'SMTP_USERNAME', 3);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (11, null, 'Senha para login no servidor SMTP.', 'SMTP_PASSWORD', 3);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (12, 'sistema@teste.com.br', 'E-mail do sistema.', 'SMTP_EMAIL_FROM', 3);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (13, 'teste.com.br', 'Servidor do Proxy.', 'PROXY_SERVIDOR', 4);
insert into ADM_PARAMETRO (par_seq, par_valor, par_descricao, par_codigo, par_pmc_seq)
values (14, '8080', 'Porta do Proxy.', 'PROXY_PORTA', 4);

insert into ADM_CARGO (car_seq, car_descricao)
values (15369, 'ANALISTA JUD - AESP(PSICOLOGIA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15385, 'ANALISTA JUD - AREA JUD(EXEC MANDAD)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15393, 'ANALISTA JUD - AREA ADM(ADMINISTR)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800707, 'ASSISTENTE ESPECIALIZADO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801420, 'ASSISTENTE DE DIRETOR CJ-1');
insert into ADM_CARGO (car_seq, car_descricao)
values (800658, 'ASSISTENTE SECRETARIO apoio graco');
insert into ADM_CARGO (car_seq, car_descricao)
values (800425, 'ASSESSOR DA PRESIDENCIA ACE');
insert into ADM_CARGO (car_seq, car_descricao)
values (801820, 'SUPERVISOR DA COMISSÃO DE INVENTÁRIO ALMOX PATRIM');
insert into ADM_CARGO (car_seq, car_descricao)
values (801240, 'ASSISTENTE DE SUPERVISOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (15387, 'ANALISTA JUD - AREA JUD - OF JUSTICA AVAL FEDERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (800605, 'ASSISTENTE DE DIRETOR DE SECRETARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15462, 'ANALISTA JUD - AESP (MEDICINA PSIQUIATRIA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (801253, 'DIRETOR DA SECRETARIA-GERAL JUDICIÁRIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (800232, 'SECRETARIO CALCULISTA DE VT');
insert into ADM_CARGO (car_seq, car_descricao)
values (801458, 'ASSISTENTE (VT)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800700, 'CHEFE DE POSTO AVANÇADO FC-6');
insert into ADM_CARGO (car_seq, car_descricao)
values (800690, 'ASSISTENTE DE CHEFE DE POSTO AVANÇADO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801148, 'CHEFE DE GABINETE');
insert into ADM_CARGO (car_seq, car_descricao)
values (802365, 'SECRETARIO DE AUDIENCIAS');
insert into ADM_CARGO (car_seq, car_descricao)
values (801156, 'CHEFE DE DIVISAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801308, 'CHEFE DE SECAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800654, 'ASSISTENTE DE GABINETE');
insert into ADM_CARGO (car_seq, car_descricao)
values (800443, 'ASSISTENTE ADMINISTRATIVO (gab)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800709, 'ASSISTENTE SECRETARIO (jurisp)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800710, 'ASSISTENTE SECRETARIO (socioamb)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800214, 'ASSISTENTE DE DIRETOR DE SECRETARIA  (VT)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800223, 'ASSISTENTE SECRETARIO DE JUIZ  (VT)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15456, 'TECNICO JUD - AESP (TECNO INFORMAÇÃO)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800225, 'ASSISTENTE DE JUIZ SUBSTITUTO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801149, 'CHEFE DE GABINETE 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (801157, 'CHEFE DE COMISSAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801306, 'ASSESSOR DE CONTRATAÇÃO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801307, 'ASSESSOR DE CONFORMIDADE');
insert into ADM_CARGO (car_seq, car_descricao)
values (801310, 'ESPECIALISTA DE CONTRATAÇÃO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801311, 'ESPECIALISTA DE MANUTENÇÃO E INFRAESTRUTURA PREDIAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (801825, 'SUPERVISOR (Ouvidoria)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15463, 'TECNICO JUD - AESP (ENFERMAGEM)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15441, 'ESTAGIARIO - NIVEL SUPERIOR 6H');
insert into ADM_CARGO (car_seq, car_descricao)
values (15407, 'ANALISTA JUD - AREA JUDICIARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15415, 'ANALISTA JUD - AREA ADMINISTRATIVA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15423, 'ANALISTA JUD - AREA ADM(PLANEJ)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15431, 'ESTAGIARIO - NIVEL MEDIO');
insert into ADM_CARGO (car_seq, car_descricao)
values (15440, 'ESTAGIARIO - NIVEL SUPERIOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (999997, 'CARGO FICTICIO - FUNCIONARIO INATIVO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801298, 'ASSISTENTE DE APOIO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801300, 'ASSISTENTE TECNICO DE PAGAMENTO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801303, 'ASSISTENTE DE DIRETOR GERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (801304, 'ASSESSOR JURIDICO');
insert into ADM_CARGO (car_seq, car_descricao)
values (15386, 'OFICIAL DE JUSTICA AVALIADOR FEDERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (800423, 'ASSESSOR DA PRESIDENCIA AIC');
insert into ADM_CARGO (car_seq, car_descricao)
values (15246, 'AGENTE DE SEGURANCA JUDICIARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15452, 'TECNICO JUD - AREA ADM - (TELEC E ELET)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15450, 'TECNICO JUD - AREA ADM - (SEGURANÇA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15451, 'TECNICO JUD - AREA ADM - (MECANICA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15453, 'TECNICO JUD - AREA ADM - (CARP E MARC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15454, 'TECNICO JUD - AREA ADM - ARTES GRÁFICAS');
insert into ADM_CARGO (car_seq, car_descricao)
values (9998, 'SERVIDOR REMOVIDO');
insert into ADM_CARGO (car_seq, car_descricao)
values (1652, 'JUIZ CONVOCADO TRT');
insert into ADM_CARGO (car_seq, car_descricao)
values (1725, 'JUIZ DESIGNADO VT');
insert into ADM_CARGO (car_seq, car_descricao)
values (800079, 'AGENTE ESPECIALIZADO TURMA/GAB.');
insert into ADM_CARGO (car_seq, car_descricao)
values (802063, 'PRESIDENTE COMISSAO PERMANENTE AUDITORIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (801407, 'DIRETOR DE SECRETARIA DE VT (JCJ)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800427, 'ASSISTENTE (FC-2)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15455, 'TECNICO JUD - AREA ADM - (TRANSPORTE)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15457, 'TECNICO JUD - AESP (OPERAÇÃO COMP)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15424, 'ANALISTA JUD - AREA ADM(CONTABILIDADE)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15425, 'ANALISTA JUD - AESP(MEDICINA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15426, 'ANALISTA JUD - AESP(TECNO INFORMAÇÃO)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800656, 'ASSISTENTE SECRETARIO - GRACO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800424, 'ASSESSOR DA PRESIDENCIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15461, 'ANALISTA JUD - AESP-(MEDICINA DO TRABALHO)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800657, 'ASSISTENTE SECRETARIO I');
insert into ADM_CARGO (car_seq, car_descricao)
values (800701, 'ANALISTA ESPECIALIZADO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800702, 'ASSISTENTE DE JUIZ DIRETOR DE FORO DA CAPITAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (800705, 'ANALISTA DE CONTROLE INTERNO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800708, 'SECRETARIO-GERAL DA PRESIDENCIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (507, 'DIRETOR GERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (540, 'ESCRITURARIO');
insert into ADM_CARGO (car_seq, car_descricao)
values (566, 'OFICIAL DE JUSTICA AVALIADOR PJ');
insert into ADM_CARGO (car_seq, car_descricao)
values (574, 'SUPLENTE DE JUIZ DE JCJ');
insert into ADM_CARGO (car_seq, car_descricao)
values (906, 'CHEFE DE SECRETARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (914, 'DIRETOR DE SECRETARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (922, 'DIR DISTRIB MANDADOS JUDICIAIS');
insert into ADM_CARGO (car_seq, car_descricao)
values (930, 'DEPOSITARIO');
insert into ADM_CARGO (car_seq, car_descricao)
values (949, 'DISTRIBUIDOR DE FEITOS JUDICIAIS');
insert into ADM_CARGO (car_seq, car_descricao)
values (1600, 'JUIZ CORREGEDOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (1619, 'JUIZ VICE CORREGEDOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (1627, 'JUIZ CLASSISTA TRT TRABALHADORES');
insert into ADM_CARGO (car_seq, car_descricao)
values (1635, 'JUIZ CLASSISTA TRT EMPREGADORES');
insert into ADM_CARGO (car_seq, car_descricao)
values (1651, 'JUIZ TOGADO TRT');
insert into ADM_CARGO (car_seq, car_descricao)
values (1724, 'JUIZ TITULAR DE VARA DO TRABALHO');
insert into ADM_CARGO (car_seq, car_descricao)
values (1759, 'JUIZ SUBSTITUTO');
insert into ADM_CARGO (car_seq, car_descricao)
values (2151, 'SECRETARIO GERAL DA PRESIDENCIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (2453, 'SUPL JUIZ CLASS REP EMPREGADOS');
insert into ADM_CARGO (car_seq, car_descricao)
values (2500, 'SUPL JUIZ CLASS REP EMPREGADORES');
insert into ADM_CARGO (car_seq, car_descricao)
values (2526, 'SUPL JUIZ CLASS TRT TRABALHADORES');
insert into ADM_CARGO (car_seq, car_descricao)
values (2534, 'SUPL JUIZ CLASS TRT EMPREGADORES');
insert into ADM_CARGO (car_seq, car_descricao)
values (15458, 'ANALISTA JUD - AESP(ARQUIVOLOGIA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15459, 'ANALISTA JUD - AESP(ESTATISTICA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (900030, 'ASSIST CHEFE SECRETARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (900099, 'BIBLIOTECARIO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900102, 'CEDIDO FC-01 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900110, 'CEDIDO FC-02 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900129, 'CEDIDO FC-03 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900137, 'CEDIDO FC-04 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900145, 'CEDIDO FC-05 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900153, 'CEDIDO FC-06 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900161, 'CEDIDO FC-07 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900170, 'CEDIDO FC-08 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900188, 'CEDIDO FC-09 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (900196, 'CEDIDO FC-10 CONTROLE SEC LEGISLACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (15460, 'ANALISTA JUD - AESP-(MEDICINA CARDIOLOGIA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (800045, 'COORDENADOR CJ-2');
insert into ADM_CARGO (car_seq, car_descricao)
values (800166, 'ASSESSOR JURIDICO 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (801823, 'SUPERVISOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (800419, 'ASSESSOR DA PRESIDENCIA AJU');
insert into ADM_CARGO (car_seq, car_descricao)
values (800420, 'ASSESSOR DA PRESIDENCIA ACC');
insert into ADM_CARGO (car_seq, car_descricao)
values (801105, 'COORDENADOR CPL');
insert into ADM_CARGO (car_seq, car_descricao)
values (800170, 'ASSISTENTE DA PRESIDENCIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (99999, 'COMISSIONADO SEM PROVIMENTO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800974, 'ASSESSOR DA PRESIDENCIA II');
insert into ADM_CARGO (car_seq, car_descricao)
values (800421, 'ASSESSOR DA PRESIDENCIA ARR');
insert into ADM_CARGO (car_seq, car_descricao)
values (801282, 'ESPECIALISTA DE CONTROLE INTERNO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800194, 'ASSESSOR DA PRESIDENCIA ACC 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (801286, 'ESPECIALISTA EM TECNOLOGIA DA INFORMACAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801287, 'SUPERVISOR E');
insert into ADM_CARGO (car_seq, car_descricao)
values (801288, 'ASSISTENTE JURIDICO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801289, 'ASSISTENTE DE DIRETOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (801290, 'ASSISTENTE DE COORDENADOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (801291, 'ASSISTENTE DE COORDENADOR DE CPL');
insert into ADM_CARGO (car_seq, car_descricao)
values (801292, 'ANALISTA DA AREA FINANCEIRA');
insert into ADM_CARGO (car_seq, car_descricao)
values (801293, 'ANALISTA DE NEGOCIOS');
insert into ADM_CARGO (car_seq, car_descricao)
values (800078, 'AGENTE ESPECIALIZADO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800167, 'ASSESSOR DESEN CON QUAL SEG TEC INF');
insert into ADM_CARGO (car_seq, car_descricao)
values (800175, 'ASSESSOR DE APOIO EXTERNO E INSTITUC');
insert into ADM_CARGO (car_seq, car_descricao)
values (800418, 'ASSESSOR DA PRESIDENCIA 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (800434, 'ASSESSOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (800442, 'ASSISTENTE ADMINISTRATIVO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800477, 'ASSESSOR ADMINISTRATIVO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800493, 'ASSIST GERAL SECRET PRES');
insert into ADM_CARGO (car_seq, car_descricao)
values (800507, 'ASSISTENTE DIRETOR GERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (800515, 'ASSISTENTE CHEFE');
insert into ADM_CARGO (car_seq, car_descricao)
values (800566, 'ASSIST CHEFE DE DIVISAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800604, 'ASSIST DIR SECRETARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (800620, 'ASSIST TEC ESPECIALIZADO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800655, 'ASSISTENTE SECRETARIO');
insert into ADM_CARGO (car_seq, car_descricao)
values (800930, 'ASSESSOR DA PRESIDENCIA COORDENADOR');
insert into ADM_CARGO (car_seq, car_descricao)
values (800957, 'CHEFE DE SECAO ESPECIALIZADA');
insert into ADM_CARGO (car_seq, car_descricao)
values (800973, 'ASSESSOR DA PRESIDENCIA I');
insert into ADM_CARGO (car_seq, car_descricao)
values (800981, 'ASSESSOR DE PLANEJ E ORCAMENTO PRES');
insert into ADM_CARGO (car_seq, car_descricao)
values (800990, 'ASSESSOR TECNICO DE PLANEJ E ORCAMEN');
insert into ADM_CARGO (car_seq, car_descricao)
values (801007, 'CHEFE DE SEC DE TURMA');
insert into ADM_CARGO (car_seq, car_descricao)
values (801058, 'CHEFE DE COORDENADORIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (801252, 'DIRETOR-GERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (801350, 'DIRETOR DE DEPARTAMENTO');
insert into ADM_CARGO (car_seq, car_descricao)
values (801406, 'DIRETOR DE SECRETARIA 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (801600, 'JUIZ CORREGEDOR 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (801619, 'JUIZ VICE CORREGEDOR 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (802054, 'PRESIDENTE DO TRIBUNAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (802151, 'SECRETARIO GERAL DA PRESIDENCIA 2');
insert into ADM_CARGO (car_seq, car_descricao)
values (802208, 'SECRETARIO DIRETOR GERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (802356, 'SECRETARIO TRIBUNAL PLENO');
insert into ADM_CARGO (car_seq, car_descricao)
values (802380, 'SECRETARIO ESPEC CALCULISTA');
insert into ADM_CARGO (car_seq, car_descricao)
values (802402, 'SUPERVISOR DE SETOR (extinta)');
insert into ADM_CARGO (car_seq, car_descricao)
values (802658, 'VICE PRESIDENTE DO TRIBUNAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (2755, 'JUIZ CLASSISTA REP EMPREGADOS');
insert into ADM_CARGO (car_seq, car_descricao)
values (2801, 'JUIZ CLASSISTA REP EMPREGADORES');
insert into ADM_CARGO (car_seq, car_descricao)
values (9873, 'CARGO EXTINTO');
insert into ADM_CARGO (car_seq, car_descricao)
values (9970, 'FUNCIONARIO ACOMPANHA CONJUGE');
insert into ADM_CARGO (car_seq, car_descricao)
values (9997, 'SERVIDOR REQUISITADO');
insert into ADM_CARGO (car_seq, car_descricao)
values (10081, 'ASSESSOR DE JUIZ');
insert into ADM_CARGO (car_seq, car_descricao)
values (12149, 'ASSESSOR DA PRESIDENCIA 3');
insert into ADM_CARGO (car_seq, car_descricao)
values (12211, 'DIRETOR DE SERVICOS');
insert into ADM_CARGO (car_seq, car_descricao)
values (12220, 'DIRETOR DE DIVISAO');
insert into ADM_CARGO (car_seq, car_descricao)
values (12300, 'SECRETARIO DO TRIBUNAL PLENO');
insert into ADM_CARGO (car_seq, car_descricao)
values (12319, 'ASSESSOR DA CORREGEDORIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15008, 'TECNICO JUDICIARIO (AG ADMIN)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15016, 'TECNICO JUDICIARIO (AG SEG JUD)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15024, 'TECNICO JUDICIARIO (AG TELE ELET)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15032, 'ANALISTA JUDICIARIO (ANALIST SIST)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15040, 'TECNICO JUDICIARIO (ARTIF ART GRAF)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15059, 'TECNICO JUDICIARIO (ART CARP MARC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15067, 'TECNICO JUDICIARIO (ART ELET COM)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15075, 'TECNICO JUDICIARIO (ARTIF MECAN)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15083, 'ANALISTA JUDICIARIO (ASSIST SOC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15091, 'TECNICO JUDICIARIO (ATEND JUDIC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15105, 'TECNICO JUDICIARIO (AUX JUDIC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15113, 'ANALISTA JUDICIARIO (BIBLIOTEC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15121, 'ANALISTA JUDICIARIO (CONTADOR)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15130, 'ANALISTA JUDICIARIO (ENFERMEIRO)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15148, 'ANALISTA JUDICIARIO (MEDICO)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15156, 'ANALISTA JUDICIARIO (OF JUST AV)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15164, 'TECNICO JUDICIARIO (OPER COMP)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15180, 'ANALISTA JUDICIARIO (TECN ADM)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15199, 'ANALISTA JUDICIARIO (TECN JUDIC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15210, 'ASSESSOR DO DIRETOR GERAL');
insert into ADM_CARGO (car_seq, car_descricao)
values (15229, 'TECNICO JUD - AREA JUDICIARIA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15237, 'TECNICO JUD - AREA ADMINISTRATIVA');
insert into ADM_CARGO (car_seq, car_descricao)
values (15245, 'TECNICO JUD - SERV GER(TRANSP E SEG)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15253, 'TECNICO JUD - SERV GER(TELEC E ELET)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15261, 'TECNICO JUD - SERV GER(ARTES GRAFIC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15270, 'TECNICO JUD - SERV GER (CARP E MARC)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15288, 'TECNICO JUD - SERV GERAIS (MECANICA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15326, 'ANALISTA JUD - AESP (SERVICO SOCIAL)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15334, 'ANALISTA JUD - AESP(BIBLIOTECONOMIA)');
insert into ADM_CARGO (car_seq, car_descricao)
values (15350, 'ANALISTA JUD - AESP (ENFERMAGEM)');



insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JFMJ', 'GAB JUIZ JOSE DA FONSECA MARTINS JUNIOR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCR', 'SECRETARIA DA CORREGEDORIA REGIONAL', 'CR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDEP', 'DIVISÃO DE DESENVOLVIMENTO PROFISSIONAL', 'CDES', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEN', 'DIVISÃO DE PESQUISA E DE ENSINO', 'CDES', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAAD', 'SEÇÃO DE APOIO ADMINISTRATIVO', 'DCAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAET', 'SEÇÃO DE ACOMPANHAMENTO DE ESTÁGIO', 'DDES', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEQ', 'SEÇÃO DE PESQUISA E DE ENSINO', 'DDES', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIED', 'DIVISAO DE DESENVOLVIMENTO EDUCACIONAL', 'ESACS RJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPCO', 'DIVISAO DE PLANEJAMENTO E DE CONCURSO', 'ESACS RJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JS', 'CORREGEDORIA', 'PR', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V10', 'GABINETE DE JUIZ CONVOCADO Nº 10', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V11', 'GABINETE DE JUIZ CONVOCADO Nº 11', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V6', 'GABINETE DE JUIZ CONVOCADO No 6', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV2', 'GABINETE DE JUIZ CONVOCADO No 2', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-SJM', 'SECAO PROTOCOLO EXPEDICAO S JOAO MERITI', 'DF', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('OUV', 'OUVIDORIA', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DALC', 'DIVISAO AUDITORIA DE LICITAÇÕES E CONTRATOS', 'SCI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAUTI', 'SEÇÃO DE AUDITORIA DE TECNOLOGIA DA INFORMAÇÃO', 'DALC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAOB', 'SECAO DE AUDITORIA DE OBRAS', 'DALC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAUD', 'SECAO AUDITORIA DE CONCESSÃO DE DIREITOS', 'DARE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAFO', 'SEÇÃO AUDITORIA  FINANCEIRA E ORÇAMENTARIA', 'DIAC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPA', 'SEÇÃO DE AUDITORIA PATRIMONIAL', 'DIAC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COPJ', 'COORDENADORIA DE GESTÃO DE PROJETOS', 'SDE', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SP', 'SECRETARIA DO T. PLENO, O.ESP., DIS. COLETIVOS', 'TP', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SL-SESSAO1', 'SALA DE SESSAO1', 'SP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SL-SESSAO3', 'SALA DE SESSAO3', 'SP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COMIN2010', 'COMISSÃO ANUAL DE INVENTÁRIO PERMANENTE - 2010', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSEG-NT', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA - NITERÓI', 'DISEG-INT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERCA', 'SECAO DE RECEPCAO E APOIO', 'SG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCAD', 'SEÇÃO DE CADASTRAMENTO', 'DAPSA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CBIB', 'COORDENADORIA DE GESTÃO DE ACERVOS BIBLIOGRÁFICOS', 'SGC', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIGAB', 'DIVISÃO DE GERENCIAMENTO DE ACERVO BIBLIOGRÁFICO', 'CBIB', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CGAA', 'COORDENADORIA DE GESTÃO DE ACERVOS ARQUIVISTICOS', 'SGC', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV', 'SETOR DE BENS MOVEIS', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2010-NLOC', 'INV2010-ATIVOS BENS NÃO LOCALIZADOS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARN-II', 'SEÇÃO DE ARQUIVO DE NITEROI II', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TRT-GF', 'SETORES VIRTUAIS GOMES FREIRE', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAGC', 'DIVISÃO DE APOIO A GESTÃO CONTRATUAL', 'SCO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICOD', 'DIVISÃO DE CONTRATOS E DOCUMENTOS DE REFERÊNCIA', 'SCO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEC', 'DIVISÃO DE PESQUISA DE MERCADO E CONTRAT DIRETAS', 'SCO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEP', 'SECRETARIA DE ADMINISTRAÇÃO DE PESSOAL', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECARQ-GP', 'SEÇÃO DE ARQUIVO DE GESTÃO DE PESSOAS', 'SEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CORC', 'COORDENADORIA DE ORGANIZAÇÃO DO CONHECIMENTO', 'SGC', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-NI', 'SETOR DE ARQUIVO DE NOVA IGUAÇU', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPROS', 'DIVISÃO DE PROMOÇÃO DE SAÚDE', 'CSAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SJU-1', 'SECRETARIA JUDICIÁRIA DE 1ª INSTÂNCIA', 'SGJ', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEATUS-1', 'CENTRAL DE ATENDIMENTO AO USUÁRIO - LAVRADIO', 'SJU-1', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPU-1', 'DIVISÃO DE APOIO AO USUÁRIO DE 1ª INSTÂNCIA', 'CFEI-1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDIS-1', 'DIVISÃO DE DISTRIBUIÇÃO DE FEITOS', 'CFEI-1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAN-RJ', 'DIVISÃO DE DISTRIBUIÇÃO DE MANDADOS', 'CMAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPU-NI', 'DIVISÃO DE APOIO AO USUÁRIO DE NOVA IGUAÇU', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CCOT', 'COORDENADORIA DE CONTRATAÇÃO', 'SLG', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIFOA', 'DIVISÃO DE FORMALIZAÇÃO DE AJUSTES', 'CCOT', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEX-NI', 'DIVISÃO DE PROTOCOLO E EXPEDIÇÃO - NOVA IGUAÇU', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CMAP', 'COORDENADORIA DE MATERIAL E PATRIMONIO', 'SLG', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIGEM', 'DIVISÃO DE GESTÃO DE MATERIAIS', 'CMAP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPS-GAB39', 'DIAPS-GAB39', 'SLG', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICO', 'DIVISÃO DE CONTRATAÇÃO', 'SLG', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEALG', 'SEÇÃO DE APOIO AOS PRÉDIOS LAVRADIO E GOMES FREIRE', 'DINF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOB-DIST', 'SEÇÃO DE MOVIMENTAÇÃO DE BENS - DIST', 'SEMOB', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIF-NI', 'SEÇÃO DE PROTOC. E DIST. DE FEITOS - NOVA IGUAÇU', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIM-DC', 'SEÇÃO DE DISTRIBUIÇÃO DE MANDADOS - DUQUE D CAXIAS', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMAC', 'DIVISÃO DE MANUTENÇÃO - CAPITAL', 'SME', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCOP', 'SEÇÃO DE COPA', 'DMANP-AC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-DC', 'SECAO DE PROTOCOLO E EXPEDIÇÃO - DUQUE DE CAXIAS', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCOTE', 'SEÇÃO DE CONTROLE DE MANDADOS', 'DMAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETRED', 'SETOR DE RECEBIMENTO E DEVOLUÇÃO DE MANDADOS', 'SEDIM-RJ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMO', 'SECRETARIA DE MANUTENÇÃO E OBRAS', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAI-DC', 'SEÇÃO DE MANUTENÇÃO DE DUQUE DE CAXIAS', 'DMANI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIOB', 'DIVISÃO DE OBRAS', 'SMO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIOP', 'DIVISÃO DE OPERAÇÕES', 'SMO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIS-2', 'SECAO DE DISTRIBUIÇÃO DE 2ª INSTANCIA', 'DIFE-2', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCALJ', 'SEÇÃO DE CÁLCULOS JUDICIAIS', 'DPRE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAB', 'SECAO DE CONTROLE E BAIXA', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCAR', 'SETOR DE CARGA', 'SEREC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMAN', 'DIVISÃO DE MANUTENÇÃO', 'SMO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAI-NI', 'SETOR DE MANUTENÇÃO DE NOVA IGUAÇU', 'SEMAI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEFIN', 'DIVISÃO DE EXECUÇÃO FINANCEIRA', 'CFIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CAEI', 'COORDENADORIA DE APOIO EXTERNO E INSTITUCIONAL', 'SPR', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST8', 'SECRETARIA DA 8A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOP', 'SEÇÃO DE CONTABILIDADE PÚBLICA', 'DCON', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIFIS', 'DIVISÃO DE ACOMPANHAMENTO E FISCALIZAÇÃO DE OBRAS', 'SOP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUGAM', 'NUCLEO DE GESTAO AMBIENTAL', null, 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-CAAD', 'DESEMB CARLOS ALBERTO ARAUJO DRUMMOND', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-EPMC', 'DESEMB ELMA PEREIRA DE MELO CARVALHO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JATS', 'DESEMB JOSE ANTONIO TEIXEIRA DA SILVA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JLFS', 'DESEMB JOSE LEOPOLDO FELIX DE SOUZA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JMMP', 'DESEMB JOSE MARIA DE MELLO PORTO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('11VTRJ', '11a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-VA', 'POSTO AVANÇADO JUST TRAB  DE VALENÇA - VT-BP', '1VTBP', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIADD', 'DIVISÃO DE ADMINISTRAÇÃO DE DADOS', 'CGSP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-LAPM', 'DESEMB LUIZ AUGUSTO PIMENTA DE MELLO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-MAP', 'DESEMB MARCOS ANTONIO PALACIO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-MOC', 'DESEMB MARCOS DE OLIVEIRA CAVALCANTE', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDACAR', 'GAB DES. ANTONIO CARLOS DE AZEVEDO RODRIGUES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTRB', '1a VT DE RIO BONITO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTRES', '1a VT DE RESENDE', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTRJ', '1a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTSG', '1a VT DE SÃO GONÇALO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTSJM', '1a VT DE SAO JOAO DE MERITI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISET', 'DIVISÃO DE SUPORTE ÀS ESTAÇÕES DE TRABALHO', 'CSTU', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TERCEIROS CSTU', 'TERCEIRIZADA - CSTU', 'CSTU', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGIN', 'DIVISAO DE GESTÃO DE INFRAESTRUTURA', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEGAR', 'SEÇÃO DE GERENCIA DE ATIVOS DE REDE', 'DGIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGSP', 'DIVISÃO DE GESTÃO DE SISTEMAS E PORTAL', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DITE', 'DIVISAO DE TELECOMUNICACOES E REDES', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETEL', 'SEÇÃO DE TELEFONIA', 'DITE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDDV', 'GAB DES. DAMIR VRCIBRADIC', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDEPVL', 'GAB DES. EVANDRO PEREIRA VALADAO LOPES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDFERS', 'GAB DES. FLAVIO ERNESTO RODRIGUES SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDGBLR', 'GAB DES. GISELLE BONDIM LOPES RIBEIRO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDICAF', 'GAB DES. IVAN DA COSTA ALEMÃO FERREIRA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SENAP', 'SEÇÃO DE ANALISE E PROGRAMAÇÃO', 'DSEN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('STA LUZIA', 'DSMI SANTA LUZIA', 'DSMI', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSEG', 'DIVISAO DE SEGURANÇA E VIGILANCIA', 'SES', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPE', 'SEÇÃO ANÁLISE E ATENDIMENTO DE MATERIAL PERMANENTE', 'DPAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMAC', 'GAB DES. MARCELO ANTERO DE CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('35VTRJ', '35a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('36VTRJ', '36a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTCAM', '3a VT DE CAMPOS DOS GOYTACAZES', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTNI', '3a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTNT', '3a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTRJ', '3a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('43VTRJ', '43a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEALM-SOB', 'SEÇÃO DE ALMOXARIFADO - SOBRAS DE INVENTÁRIO', 'SEMOV', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGCJ', 'DIRETORIA GERAL COORDENACAO JUDICIARIA', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SED', 'SECRETARIA DE DISTRIBUIÇÃO', 'DGCJ', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDNTB', 'GAB DES. NELSON TOMAZ BRAGA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDTSG', 'GAB DES. TANIA DA SILVA GARCIA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-ATFBC', 'GAB JUIZ ALEXANDRE TEIXEIRA DE FREITAS B. CUNHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('56VTRJ', '56a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('60VTRJ', '60a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('64VTRJ', '64a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('65VTRJ', '65a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('67VTRJ', '67a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('6VTNT', '6a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('6VTRJ', '6a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPRE', 'SEÇÃO DE CONTROLE PROT.DE RECLAMAÇÕES', 'DIRC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SJU', 'SECRETARIA JUDICIÁRIA', 'DGCJ', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPCO', 'DIVISÃO DE PLANEJAMENTO E CONTRATAÇÃO', 'COAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEOPS', 'SEÇÃO DE PESQUISA', 'DEJE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEPE', 'DIVISÃO DE ENSINO E PESQUISA', 'EJ1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-CJC', 'GAB JUIZ CELIO JUAÇABA CAVALCANTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-DLCN', 'GAB JUIZA DORIS LUISE DE CASTRO NEVES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-EG', 'GAB JUIZ EDILSON GONCALVES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-EPVL', 'GAB JUIZ EVANDRO P VALADAO LOPES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-FERS', 'GAB JUIZ FLAVIO ERNESTO RODRIGUES SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-ISG', 'GAB JUIZ IZIDORO SOLER GUELMAN', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JGF', 'GAB JUIZ JOSE GERALDO DA FONSECA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JLGLV', 'GAB JUIZ JOSE LUIZ DA GAMA L VALENTINO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('73VTRJ', '73a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('74VTRJ', '74a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('7VTDC', '7a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('82VTRJ', '82a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPESE', 'SERVIÇO DE PESQUISA EDUCACIONAL', 'DIED', 'SERVICO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECACO', 'SERVIÇO DE CADASTRO E CONTROLE', 'DSAO', 'SERVICO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MBC', 'GAB JUIZ MERY BUCKER CAMINHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MOC', 'GAB JUIZ MARCOS DE OLIVEIRA CAVALCANTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-NAP', 'GAB JUIZ CONV NURIA DE ANDRADE PERIS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-PRCF', 'GAB JUIZ PAULO R C DA FONSECA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V2', 'GABINETE DE JUIZ CONVOCADO No 2', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIONC4', 'DIONC4', 'SEP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIONC8', 'DIVISÃO DE OPERAÇÃO DE NÚCLEOS DE COMPUTAÇÃO', 'CGNC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIONC9', 'DIVISÃO DE OPERAÇÃO DE NÚCLEOS DE COMPUTAÇÃO', 'CGNC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV7', 'GABINETE DE JUIZ CONVOCADO Nº 7', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUDESG', 'NUCLEO DE ACOMP. DO DESEMP. DO SISTEMA DE GESTÃO', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOI', 'SEÇÃO DE CORREIÇÃO', 'DCIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-CG', 'CENTRAL DE DIST DE MANDADOS CAMPOS', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-NT', 'CENTRAL DE DIST DE MANDADOS DE NITEROI', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-PE', 'CENTRAL DE DIST DE MANDADOS PETROPOLIS', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-VR', 'SECAO DE PROTOCOLO EXPED VOLTA REDONDA', 'DF', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('FALECIDOS', 'FALECIDOS', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CALC', 'COORDENADORIA  DE AUDITORIA LICITAÇÕES E CONTRATOS', 'SCI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CAUP', 'COORDENADORIA DE AUDITORIA DE PESSOAL', 'SCI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAUCO', 'SEÇÃO DE AUDITORIA DE COMPRAS', 'DALC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAPPE', 'SECAO AUDITORIA PAGTO E PROV DE PESSOAL', 'DARE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEST', 'COORDENADORIA DE ESTATÍSTICA', 'SDE', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SDE-GAB', 'GABINETE DA SECR DE DESENVOLVIMENTO INSTITUCIONAL', 'SDE', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SG', 'SECRETARIA GERAL DA PRESIDENCIA', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DF-SG', 'DIRETOR DE FORO - SÃO GONÇALO', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DINF-MSGLAV', 'DIVISÃO DE INFRA-ESTRUTURA - MSGLAV', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAJ-DEPRO', 'DEPOSITO PROVISORIO', 'DIPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESEG-INT', 'SEÇÃO DE SEGURANÇA E VIGILANCIA - INTERIOR', 'COSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSEG-L/G', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA-LAVRADIO/G.FREIRE', 'DISEG-CAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCOPA', 'SETOR DE COPA', 'SG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICON', 'DIVISÃO DE CONCILIAÇÃO', 'CAEP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAPSA', 'DIVISÃO DE APOIO AO PJe E SAPWEB', 'CASJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-AS', 'DEPÓSITO DE BENS MOVEIS - AUGUSTO SEVERO', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOV-RA', 'SECAO DE DEPOSITO DE BENS MOVEIS - RAMOS', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ALMOX DSMI', 'DSMI ALMOXARIFADO', 'DSMI AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2008-ABB', 'INV2008-ATIVOS BENS A BAIXAR', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2008-SLD', 'INV2008-SEM LOCALIZAÇÃO E DESCONCILIADO', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERCA-AS', 'SETOR DE RECEPCAO AUGUSTO SEVERO', 'TRT-AS', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIRPC', 'DIVISÃO DE INSTRUÇÃO DE REAJ E PENALID CONTRATUAIS', 'SCO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPPI', 'DIVISÃO PREPARO DE PAGTO  INATIVOS E PENSIONISTAS', 'CPPE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMEI', 'SEÇÃO DE GESTÃO DE MEMORIAL', 'DIGED', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEP', 'DIVISÃO DE PESQUISA E PUBLICAÇÃO', 'CORC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARN', 'SEÇÃO DE ARQUIVO JUDICIAL - NITERÓI', 'DARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-3', 'SETOR DE ARQUIVO 3 (NT)', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETAB', 'SEÇÃO DE TRATAMENTO DE ACERVO BIBLIOGRÁFICO', 'DIBI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEP-GAB', 'GABINETE DA SECRETARIA DE ADMINISTRAÇÃO DE PESSOAL', 'SEP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AFASTADO', 'AFASTADO AGUARDANDO CONCLUSÃO DE PROCESSO', 'SGP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEMASE', 'CENTRAL DE ATENDIMENTO AO MAGISTRADO E SERVIDOR', 'SGP', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIBEN', 'DIVISÃO DE ADMINISTRAÇÃO DE BENEFÍCIOS', 'CSAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPER', 'DIVISÃO DE ATENDIMENTO PERICIAL', 'CSAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETPAG', 'SETOR DE CONCILIAÇÃO E PAGAMENTO DE BENEFÍCIOS', 'SEBEN', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPROV', 'SEÇÃO DE PROVIMENTO', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CFEI-1', 'COORDENADORIA DE FEITOS DE 1ª INSTANCIA', 'SJU-1', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPU-DC', 'DIVISÃO DE APOIO AO USUÁRIO DE DUQUE DE CAXIAS', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPIP', 'SEÇÃO PREPARO DE PAGTO DE INATIVOS E PENSIONISTAS', 'DPPE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAPERPROV', 'SGP SEÇÃO DE ATENDIMENTO PERICIAL provisoriamente', 'DSAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDIF-NI', 'DIVISÃO DE PROTOC. E DIST. DE FEITOS - NOVA IGUAÇU', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEX-NT', 'DIVISÃO DE PROTOCOLO E EXPEDIÇÃO - NITERÓI', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-DC', 'DIVISÃO APOIO AS VARAS DO TRABALHO- DUQUE D CAXIAS', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-ITG', 'DIVISÃO APOIO AS VARAS DO TRABALHO- ITAGUAI', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEXP-SEDE', 'SEÇÃO DE EXPEDIÇÃO DO EDÍFICIO SEDE', 'DIEMA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIALM', 'DIVISÃO DE ALMOXARIFADO', 'CMAP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOM', 'SEÇÃO DE COMPRAS', 'DICO', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEM', 'SEÇÃO DE EXPEDIÇÃO E MALOTE', 'DINF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETRA', 'SEÇÃO DE TRANSPORTES', 'DINF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP-AC', 'DIVISÃO DE APOIO MANUTENÇÃO PREDIAL-ANTÔNIO CARLOS', 'SMI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SJU-1-GAB', 'GABINETE DA SECRETARIA JUDICIÁRIA DE 1ª INSTÂNCIA', 'SJU-1', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SJU-2', 'SECRETARIA JUDICIÁRIA DE 2ª INSTÂNCIA', 'SGJ', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPU-2', 'DIVISÃO DE APOIO AO USUÁRIO DE 2ª INSTANCIA', 'CFEI-2', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP-L/G', 'DIVISÃO APOIO MANUT PREDIAL-LAVRADIO/GOMES FREIRE', 'SMI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAE-L/G', 'SEÇÃO DE MANUTENÇÃO EQUIPAMENTOS-LAVRADIO/G.FREIRE', 'DIMAE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERLAN', 'SETOR DE LANTERNAGEM', 'SEOFI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPRO-2', 'DIVISÃO DE PROTOCOLO DE 2ª INSTANCIA', 'CFEI-2', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CSEP', 'COORDENADORIA DE SERVICOS PROCESSUAIS', 'SJU-2', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SADIS', 'SEÇÃO DE AUTUAÇÃO E DISTRIBUIÇÃO DE 2ª INSTANCIA', 'DIFE-2', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSEP', 'DIVISAO DE SERVICOS PROCESSUAIS', 'SJU-2', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEX', 'SECAO DE EXPEDICAO', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERAG', 'SEÇÃO DE RECURSO DE AGRAVO DE INSTRUMENTO', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEREC', 'SECAO DE RECURSOS', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERMEC', 'SETOR DE MECÂNICA', 'SEOFI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETELV', 'SETOR DE ELÉTRICA DE VEÍCULOS', 'SEOFI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERPIN', 'SETOR DE PINTURA (PRÉDIOS)', 'SREPA', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETHID', 'SETOR DE HIDRAULICA', 'SREPA', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMO-GAB', 'GABINETE DA SECRETARIA DE MANUTENÇÃO E OBRAS', 'SMO', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPOD', 'DIVISÃO DE PROCESSAMENTO DE DESPESAS', 'CFIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPREC', 'SECAO DE PRECATORIOS', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPR', 'SECRETARIA-GERAL DA PRESIDÊNCIA', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAOCE', 'DIVISÃO DE APOIO OPERACIONAL E CERIMONIAL', 'SPR', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST6', 'SECRETARIA DA 6A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST7', 'SECRETARIA DA 7A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST9', 'SECRETARIA DA 9A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SUAEI', 'SUPERVISÃO DE APOIO EXTERNO E INSTITUCIONAL', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCON', 'DIVISÃO DE CONTABILIDADE', 'SOF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DFIN', 'DIVISÃO FINANCEIRA', 'SOF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEORC', 'SEÇÃO DE ORÇAMENTO', 'DPOR', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPLOR', 'SEÇÃO DE PLANEJAMENTO ORÇAMENTÁRIO', 'DPOR', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-OF', 'SETOR DE ARQUIVO DE FINANÇAS', 'SOF', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPOB', 'DIVISÃO DE PLANEJAMENTO E ORÇAMENTO DE OBRAS', 'SOP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIQUA', 'DIVISÃO DE QUALIDADE DE SOLUÇÕES', 'CITQ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-ACAR', 'DESEMB ANTONIO CARLOS DE A RODRIGUES', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-AMSM', 'DESEMB ANA MARIA SOARES DE MORAES', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-AS', 'DESEMB ALOYSIO SANTOS', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-IDRA', 'DESEMB IVAN DIAS RODRIGUES ALVES', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JCNC', 'DESEMB JOSE CARLOS NOVIS CESAR', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AIC', 'ASSESSORIA DE IMPRENSA E COMUNICAÇÃO SOCIAL', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('19VTRJ', '19a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIABD', 'DIVISÃO DE ADMINISTRAÇÃO DE BANCO DE DADOS', 'CGNC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-MGCVP', 'DESEMB MARIA DAS GRACAS C V PARANHOS', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-MLLS', 'DESEMB MARIA DE LOURDES A SALLABERRY', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-TBSF', 'DESEMB THEOCRITO BORGES DOS SANTOS FILHO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDAGZ', 'GAB DES. ANGELO GALVÃO ZAMORANO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('MANUT DSTU', 'DSTU MANUTENCAO', 'CSTU', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCOT', 'SETOR DE CONTROLE DE TELEFONIA', 'SETEC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SDEMP', 'SEÇÃO DE DESENVOLVIMENTO E MANUTENÇÃO DO PORTAL', 'DGSP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOD', 'SEÇÃO DE CONFIGURAÇÃO E DESEMPENHO', 'DITE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESUP', 'SECAO DE SUPORTE TECNICO', 'DOST', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDEMCT', 'GAB DES. EDITH MARIA CORREA TOURINHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('28VTRJ', '28a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTNT', '2a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('34VTRJ', '34a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AUG.SEVERO', 'DSMI AUGUSTO SEVERO', 'DSMI', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAM', 'SEÇÃO DE CONTROLE DE MATERIAL', 'DMAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJNAN', 'GAB DES. JOSE NASCIMENTO ARAUJO NETTO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDLDB', 'GAB DES. LEONARDO DIAS BORGES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('42VTRJ', '42a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('46VTRJ', '46a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('4VTCAM', '4a VT DE CAMPOS DOS GOYTACAZES', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('4VTSG', '4a VT DE SÃO GONÇALO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERIM', 'SEÇÃO DE REGULARIZAÇÃO E CADASTRO DE BENS IMÓVEIS', 'DPAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETASS', 'SETOR DE ASSISTENCIA SOCIAL', 'SMEDI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIABPROV', 'DIVISÃO DE  ASSIST E BENEFÍCIOS provisoriamente', 'SRH', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPA', 'DIVISÃO DE PAGAMENTO DE PESSOAL', 'SRH', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPAM', 'SEÇÃO DE PAGAMENTO DE MAGISTRADOS', 'DIPA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPAS', 'SEÇÃO DE PAGAMENTO DE SERVIDORES', 'DIPA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DLEG', 'DIVISAO LEGISLACAO E NORMAS DE PESSOAL', 'SRH', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGCJ-GAB', 'GABINETE DA DIRETORIA GERAL DE COORDEN JUDICIARIA', 'DGCJ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDRLD', 'GAB DES. ROQUE LUCARELLI DATTOLI', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDSGCLS', 'GAB DES. SAYONARA GRILLO COUTINHO L. DA SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDVAC', 'GAB DES. VALMIR DE ARAUJO CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('54VTRJ', '54a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('59VTRJ', '59a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('5VTNI', '5a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDAR-RJ', 'SEÇÃO DISTRIBUICAO AUTOM DE RECLAMACOES', 'DIRC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDEC', 'SEÇÃO DE CONTROLE', 'DIST', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEV', 'DIVISÃO DE PROJETOS E EVENTOS', 'CEPE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EJ1-GAB', 'GABINETE DA ESCOLA JUDICIAL', 'EJ1', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ESACS RJ', 'ESCOLA DE ADMINISTRAÇÃO E CAPACITAÇÃO DO SERVIDOR', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-GRFM', 'GAB JUIZA GLORIA REGINA FERREIRA MELLO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JCNC', 'GAB JUIZ JOSE CARLOS NOVIS CESAR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JLFS', 'GAB JUIZ JOSE LEOPOLDO FELIX DE SOUZA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JMMP', 'GAB JUIZ JOSE MARIA DE MELLO PORTO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MACM', 'GAB JUIZA MARIA APARECIDA C MAGALHAES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('75VTRJ', '75a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('81VTRJ', '81a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICAP', 'DIVISÃO DE CAPACITAÇÃO PROFISSIONAL', 'CCAP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIACE', 'DIVISÃO DE ACOMPANHAMENTO DE ESTÁGIO', 'CDES', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIDO', 'SEP CEDIDO A OUTRO ORGAO', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAEM', 'DIVISAO DE ADMINISTRACAO DA EMATRA-RJ', 'EMATRA-RJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MSMP', 'GAB JUIZ MARIO SERGIO MEDEIROS PINHEIRO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-RLD', 'GAB JUIZ ROQUE LUCARELLI DATTOLI', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-TBSF', 'GAB JUIZ THEOCRITO B. DOS SANTOS FILHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V7', 'GABINETE DE JUIZ CONVOCADO Nº 7', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-VAC', 'GAB JUIZ VALMIR DE ARAUJO CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-WVG', 'GAB JUIZ WANDERLEY VALLADARES GASPAR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV1', 'GABINETE DE JUIZ CONVOCADO No 1', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('OE', 'ORGAO ESPECIAL', 'TP', 'TRIBUNAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMON', 'SEÇÃO DE MONITORAMENTO', 'DADM', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECIN', 'SEÇÃO DE INSPEÇÃO', 'DCIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-DC', 'CENTRAL DE DIST DE MANDADOS D. DE CAXIAS', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-SJM', 'SECAO RECL DISTR FEITOS SAO JOAO MERITI', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ACT', 'ASSESSORIA DE CONTRATAÇÕES', 'DG', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SASER', 'SEÇÃO DE AUDITORIA DE SERVIÇOS', 'DALC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDO', 'DIVISAO AUDIT DE DESEMPENHO OPERACIONAL', 'SCI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SL-SESSAO2', 'SALA DE SESSAO2', 'SP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T2PR', 'SEGUNDA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T3PR', 'TERCEIRA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DF-DC', 'DIRETOR DE FORO - DUQUE DE CAXIAS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DF-VR', 'DIRETOR DE FORO - VOLTA REDONDA', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETSEG-L/G', 'SETOR DE SEGURANÇA E VIGILÂNCIA-LAVRADIO/G.FREIRE', 'SESEG-CAP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETSEG-NT', 'SETOR DE SEGURANÇA E VIGILÂNCIA - NITERÓI', 'SESEG-INT', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPE', 'DIVISÃO DE APOIO À EXECUÇÃO', 'CAEP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCALC', 'DIVISÃO DE APOIO AO CÁLCULO', 'COAJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECTAR-2', 'SEÇÃO DE ARQUIVO 2 (RJ2)', 'DIARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECTAR-3', 'SEÇÃO DE ARQUIVO 3 (NT)', 'DIARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-GA', 'DEPÓSITO DE BENS MOVEIS - GAMBOA', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2008-ABNL', 'INV2008-ATIVOS BENS NÃO LOCALIZADOS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JDF-CF', 'JUIZ DIRETOR DO FORUM - CF', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERVI-SEDE', 'SETOR DE VIGILANCIA DA SEDE', 'TRT-SEDE', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCOPE', 'DIVISÃO DE CONTROLE DE PESSOAL', 'CAPE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARQ', 'SEÇÃO DE ARQUIVO', 'DARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-4', 'SETOR DE ARQUIVO 4 (NI)', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-RJ1', 'SETOR DE ARQUIVO DO RIO DE JANEIRO', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMASE', 'SEÇÃO DE ATENDIMENTO AO MAGISTRADO E SERVIDOR', 'SEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DRET', 'DIVISÃO DE RECRUTAMENTO', 'CORA', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGC-GAB', 'GABINETE DA SECRETARIA DA GESTÃO DO CONHECIMENTO', 'SGC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICOE', 'DIVISÃO DE PROTOCOLO E CONTROLE DE FEITOS', 'CFEI-1', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAPER', 'SEÇÃO DE ATENDIMENTO PERICIAL', 'DSAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSADPROV', 'DIVISÃO DE SAÚDE PROVISORIAMENTE', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-GP', 'SETOR DE ARQUIVO DE GESTÃO DE PESSOAS', 'SGP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEX-DC', 'DIVISÃO DE PROTOCOLO E EXPEDIÇÃO - DUQUE DE CAXIAS', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAGF', 'SEÇÃO DE ADMINISTRAÇÃO DO FORO DA AV GOMES FREIRE', 'DIALG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARC', 'SETOR DE ANÁLISE DE REAJUSTE CONTRATUAL', 'SEFEC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAPOP', 'SEÇÃO DE APOIO AO PREDIO SEDE', 'DINF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCOP', 'SETOR DE COPA', 'SAPOP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-PET', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO - PETROPOLIS', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-VR', 'DIVISÃO APOIO AS VARAS DO TRABALHO - VOLTA REDONDA', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCOI', 'DIVISÃO DE COORDENAÇÃO DAS SEÇÕES DO INTERIOR', 'SJU-1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIM-NT', 'SEÇÃO DE DISTRIBUIÇÃO DE MANDADOS - NITEROI', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOB-EVENTOS', 'SEÇÃO DE MOVIMENTAÇÃO DE BENS - EVENTOS', 'DINF', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMAP', 'DIVISÃO DE MATERIAL E PATRIMONIO', 'SLG', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPAD', 'SEÇÃO DE PADRONIZAÇÃO', 'DMAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMAPE', 'SEÇÃO DE MATERIAL PERMANENTE', 'DMAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP-A1', 'DIVISÃO DE APOIO E MANUTENÇÃO PREDIAL - ÁREA 1', 'SMI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIEX', 'DIVISÃO DE EXECUÇÃO', 'SJU-1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDEJ-RJ', 'SEÇÃO DEPOSITO JUDICIAL DO RJ', 'DIEX', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCER', 'SETOR DE CERTIDÕES E CLASSIFICAÇÃO', 'SECOE', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIADP', 'DIVISÃO AUTUAÇÃO DISTRIBUIÇÃO PROTOC 2ª INSTANCIA', 'CFEI-2', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMI-GAB', 'GAB SECRETARIA DE MANUTENÇÃO INFRAESTURA PREDIAL', 'SMI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SOPI-GAB', 'GABINETE DA SECRETARIA DE OBRAS E PROJETOS', 'SMI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COBS', 'COORDENADORIA DE OBRAS', 'SMO', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPLA', 'SEÇÃO DE PLANEJAMENTO E ORÇAMENTO DE OBRAS', 'DIOB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPOB', 'SEÇÃO DE PROJETOS', 'DIOB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAUD', 'DIVISÃO DE AUTUAÇÃO E DISTRIBUIÇÃO 2ª INSTANCIA', 'CFEI-2', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEX-FCC', 'SECAO DE EXPEDICAO FORUM COQ COSTA', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAE-L/G', 'SETOR DE MANUTENÇÃO EQUIPAMENTOS-LAVRADIO/G.FREIRE', 'SEMAE', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAI-NT', 'SETOR DE MANUTENÇÃO DE NITERÓI', 'SEMAI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAP', 'SEÇÃO DE MANUTENÇÃO PREDIAL', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAEIN', 'DIVISÃO DE APOIO EXTERNO E INSTITUCIONAL', 'SPR', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST3', 'SECRETARIA DA 3A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST4', 'SECRETARIA DA 4A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST5', 'SECRETARIA DA 5A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICEO', 'DIVISÃO DE CONTROLE E EXECUÇÃO ORÇAMENTÁRIA', 'CPOR', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPOR', 'DIVISÃO DE PLANEJAMENTO E ORÇAMENTO', 'SOF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEO', 'SEÇÃO DE CONTROLE E EXECUÇÃO ORÇAMENTÁRIA', 'DPOR', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAARQ', 'SETOR DE AUTUAÇÃO E ARQUIVO DA SOF', 'SOF', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAMAP', 'DIVISÃO DE APOIO À MANUTENÇÃO PREDIAL', 'SOP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SOP-GAB', 'GABINETE DA SECRETARIA DE OBRAS E PROJETOS', 'SOP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-ACA', 'DESEMB ANTONIO CARLOS AREAL', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-ATFBC', 'DESEMB ALEXANDRE TEIXEIRA DE F B CUNHA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-DLCN', 'DESEMB DORIS LUISE DE CASTRO NEVES', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-DV', 'DESEMB DAMIR VRCIBRADIC', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JGF', 'DESEMB JOSE GERALDO DA FONSECA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JLGLV', 'DESEMB JOSE LUIZ DA GAMA L VALENTINO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-LAML', 'DESEMB LUIZ ALFREDO MAFRA LINO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUGESP', 'NÚCLEO DE GESTÃO DE PROJETOS', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUGESQ', 'NÚCLEO DE GESTÃO DA QUALIDADE', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ARR', 'ASSESSORIA DE RECURSO DE REVISTA', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('14VTRJ', '14a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTCAM', '1a VT DE CAMPOS DOS GOYTACAZES', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIANP', 'DIVISÃO DE ANÁLISE E PROJETO', 'COAS', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CGIN', 'COORDENADORIA DE GESTÃO DE INFRAESTRUTURA', 'STI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGPIR', 'DIVISÃO GERENCIA E PROJ DE INFRAESTRUTURA DE REDE', 'CGIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIONC', 'DIVISÃO DE OPERAÇÃO DE NÚCLEOS DE COMPUTAÇÃO', 'CGNC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISIN', 'DIVISÃO DE SISTEMAS INSTITUCIONAIS', 'CGSP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-PRCF', 'DESEMB PAULO ROBERTO CAPANEMA DA FONSECA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-WVG', 'DESEMB WANDERLEY VALLADARES GASPAR', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDAFG', 'GAB DES. ALBERTO FORTES GIL', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDCAAD', 'GAB DES. CARLOS ALBERTO ARAUJO DRUMMOND', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTITB', '1a VT DE ITABORAI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTITP', '1a VT DE ITAPERUNA', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTNF', '1a VT DE NOVA FRIBURGO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-NF', 'POSTO AVANÇADO JUST TRAB - CANTAGALO  VT-NF', '1VTNF', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTTE', '1a VT DE TERESOPOLIS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('G.FREIRE', 'DSTU - GOMES FREIRE', 'CSTU', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTDC', '2a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTRES', '2a VT DE RESENDE', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTSG', '2a VT DE SÃO GONÇALO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('32VTRJ', '32a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('STI-SLA', 'SALA DE APOIO DA STI', 'STI', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCATL', 'SEÇÃO DE CATALOGACAO DE MATERIAIS', 'DMAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMAP', 'GAB DES. MARCOS ANTONIO PALACIO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMASO', 'GAB DES. MARCELO AUGUSTO SOUTO DE OLIVEIRA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('39VTRJ', '39a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('45VTRJ', '45a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-SOB', 'DEPÓSITO DE BENS MOVEIS - SOBRAS DE INVENTÁRIO', 'SEMOV', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOV-DF', 'SETOR DE BENS MOVEIS', 'SEMOV', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAD', 'SEÇÃO DE CADASTRO DE FORNECEDORES', 'DSEC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SRH', 'SECRETARIA DE RECURSOS HUMANOS', 'DGCA', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDES', 'SEÇÃO DE AVALIAÇÃO DE DESEMPENHO', 'DLEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDRSVT', 'GAB DES. ROSANA SALIM VILLELA TRAVESEDO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-AOC', 'GAB JUIZA AURORA DE OLIVEIRA COENTRO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('52VTRJ', '52a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('68VTRJ', '68a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('6VTSG', '6a VT DE SÃO GONÇALO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIST', 'DIVISÃO DE DISTRIBUIÇÃO DE MANDADOS', 'SED', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEG-I', 'SECAO DE PROTOCOLO DE PRIMEIRA INSTANCIA', 'DCAD', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SENSI', 'SEÇÃO DE ENSINO', 'DEJE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAPAD', 'SEÇÃO DE APOIO ADMINISTRATIVO', 'DIAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CADM', 'COORDENADORIA DE APOIO ADMINISTRATIVO', 'SCR', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DINSP', 'DIVISÃO DE INSPEÇÃO', 'CCIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCAP', 'DIVISÃO DE CAPACITAÇÃO', 'ESACS RJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDCP', 'SEÇÃO DE CAPACITAÇÃO PROFISSIONAL', 'DCAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ESACS-GAB', 'GABINETE DA ESACS', 'ESACS RJ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GP', 'GABINETE DA PRESIDENCIA DO TRT', 'PR', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EMATRA-RJ', 'EMATRA-RJ', 'OUTROS', 'OUTROS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESAC', 'SECAO ATIVIDADES ACADEM SECR EMATRA-RJ', 'DAEM', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-RLM', 'GAB JUIZ ROGERIO LUCAS MARTINS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIONC3', 'DIONC 3', 'SEP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV6', 'GABINETE DE JUIZ CONVOCADO No 6', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUAGES', 'NUCLEO DE APOIO AO SISTEMA DE GESTAO', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCIN', 'DIVISÃO DE CORREIÇÃO E INSPEÇÃO', 'SCR', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('VCR', 'VICE-CORREGEDORIA REGIONAL', 'CR', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DF', 'DIRETOR DE FORO', 'PR', 'DIRETORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-DC', 'SECAO RECL DISTR FEITOS DUQUE DE CAXIAS', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-MA', 'SECAO RECL DISTR FEITOS DE MACAE', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-NT', 'SECAO RECL DISTR FEITOS DE NITEROI', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PR-CORSA', 'COMISSÃO DE RESPONSABILIDADE SÓCIO AMBIENTAL', 'PR', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DACO', 'DIVISÃO DE AUDITORIA CONTÁBIL', 'SCI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SL-SESSAO5', 'SALA DE SESSAO5', 'SP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T10PR', 'DECIMA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T8PR', 'OITAVA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EXTINTO', 'RESOLUCAO ADMINISTRATIVA PROVISÓRIA', '1', 'FICTICIO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEPRO-CR', 'DEPOSITO PROVISORIO - CORREGEDORIA', 'DIAJ-DEPRO', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETSEG-NI', 'SETOR DE SEGURANÇA E VIGILÂNCIA - NOVA IGUAÇU', 'SESEG-INT', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETSEG-SG', 'SETOR DE SEGURANÇA E VIGILÂNCIA - SÃO GONÇALO', 'SESEG-INT', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSEG-DC', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA - DUQUE DE CAXIAS', 'DISEG-INT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAC', 'DIVISÃO DE MATERIAL DE CONSUMO', 'SAM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEREV', 'SETOR DE REVISTA', 'SG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCEX', 'SEÇÃO DE CENTRALIZAÇÃO DA EXECUÇÃO', 'DIAPE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COAJ', 'COORDENADORIA DE APOIO JUDICIÁRIO', 'SGJ', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2009-ABNL', 'INV2009-ATIVOS BENS NÃO LOCALIZADOS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JDF-DC', 'JUIZ DIRETOR DO FORUM - DC', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JDF-SG', 'JUIZ DIRETOR DO FORUM - SG', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TRT-AS', 'SETORES VIRTUAIS AUGUSTO SEVERO', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TRT-SEDE', 'SETORES VIRTUAIS ANTONIO CARLOS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGEBI', 'DIVISÃO DE GESTÃO DE BENS IMÓVEIS', 'SCO', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCO-GAB', 'GABINETE SECRETARIA DE ADMINISTRAÇÃO DE CONTRATOS', 'SCO', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INATIVOS', 'FUNCIONARIOS INATIVOS', 'SEP', 'INATIVOS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECRUS', 'SEÇÃO DE RELACIONAMENTO COM USUÁRIO INT. E EXT.', 'DESCO', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-RJ2', 'SETOR DE ARQUIVO DE DUQUE DE CAXIAS', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEABI', 'SEÇÃO DE GERENCIAMENTO DE ACERVO BIBLIOGRÁFICO', 'DIBI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AFAST SUSP', 'AFASTADO POR SUSPENSÃO DE CONTRATO', 'SGP', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CORA', 'COORDENADORIA DE RECRUTAMENTO E AVALIAÇÃO', 'SGP', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAC', 'DIVISÃO DE AVALIAÇÃO E ACOMPANHAMENTO', 'CORA', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAP', 'DIVISÃO DE ADMINISTRAÇÃO DE PESSOAL', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAEST', 'SEÇÃO DE ADMINISTRAÇÃO DE ESTÁGIOS', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCER', 'SEÇÃO DE CERTIDÕES E CLASSIFICAÇÃO', 'DIAPU-1', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DRAV', 'DIVISÃO DE RECRUTAMENTO E AVALIAÇÃO', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEVAC', 'SEÇÃO DE AVALIAÇÃO E ACOMPANHAMENTO', 'DRAV', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPROS', 'SEÇÃO DE PROMOÇÃO DE SAÚDE', 'DSAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGPPROV', 'SECRETARIA GESTÃO DE PESSOAS provisoriamente', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-CF', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO - CABO FRIO', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-NF', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO-N.FRIBURGO', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPS', 'DIVISÃO DE APOIO AO PREDIO SEDE', 'CINF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-SJM', 'DIVISÃO APOIO AS VARAS DO TRABALHO- S.JOAO MERITI', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEG-PET', 'SALA DE SEGURANÇA DE PETRÓPOLIS', 'SEAPO-PET', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOB-TERCEIROS', 'SEÇÃO DE MOVIMENTAÇÃO DE BENS -TERCEIRIZADOS', 'DINF', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEGEM', 'SEÇÃO DE GESTÃO DE MATERIAIS', 'DMAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIM-SG', 'SEÇÃO DE DISTRIBUIÇÃO DE MANDADOS - SÃO GONÇALO', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-NI', 'SECAO DE PROTOCOLO E EXPEDICAO NOVA IGUACU', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIFE-1', 'DIVISAO DE FEITOS DE 1ª INSTANCIA', 'SJU-1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOE', 'SECAO DE PROTOCOLO E CONTROLE DE FEITOS', 'DIFE-1', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPRI', 'SECAO DE PROTOCOLO INTEGRADO', 'DIFE-1', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMAD', 'DIVISÃO DE CONTROLE E DISTRIBUIÇÃO DE MANDADOS', 'SJU-1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAPE-2', 'SEÇÃO DE ATENDIMENTO AO USUÁRIO do PJe - SEDE', 'DIAPU-2', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAI-NI', 'SEÇÃO DE MANUTENÇÃO DE NOVA IGUAÇU', 'DMANI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAI-NT', 'SEÇÃO DE MANUTENÇÃO DE NITERÓI', 'DMANI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAP-L/G', 'SEÇÃO DE MANUTENÇÃO PREDIAL-LAVRADIO/G.FREIRE', 'DMANP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEORB', 'SEÇÃO DE OBRAS', 'DIOB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPROP', 'SEÇÃO DE PROJETOS E PLANEJAMENTO', 'DIOB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPIVE', 'SETOR DE PINTURA DE VEÍCULOS', 'SEOFI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIRAG', 'DIVISÃO DE RECURSO DE AGRAVO DE INSTRUMENTO', 'CSEP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCAR', 'SEÇÃO DE CARGA', 'DIREC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAUT', 'SECAO DE AUTUACAO', 'DIFE-2', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPRO-2', 'SEÇÃO DE PROTOCOLO DE 2ª INSTANCIA', 'DIFE-2', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEACI', 'SEÇÃO DE APOIO A CONCILIAÇÃO', 'DPRE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEORP', 'SECAO PROCESSUAL', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAE', 'SEÇÃO DE MANUTENÇÃO DE EQUIPAMENTOS', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAI-DC', 'SETOR DE MANUTENÇÃO DE DUQUE DE CAXIAS', 'SEMAI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SREPA', 'SEÇÃO DE REPAROS', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEATUS-2', 'SEÇÃO DE ATENDIMENTO AO USUÁRIO - SEDE', 'SJU-2', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CDIS', 'COORDEN DISSEMIN SEGUR TRAB E RESP SOCIOAMBIENTAL', 'SPR', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUCECI', 'NÚCLEO DE CENTRALIZAÇÃO DE EXECUÇÃO E CONCILIAÇÃO', 'SPR', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('VP', 'SECRETARIA DA VICE-PRESIDENCIA', 'PR', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SVP', 'SECRETARIA DA VICE-PRESIDENCIA', 'VP', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEFIN', 'SEÇÃO DE EXECUÇÃO FINANCEIRA', 'DFIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECARQ-OF', 'SEÇÃO DE ARQUIVO DE FINANÇAS', 'SOF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMPE', 'DIVISÃO DE IMPLEMENTAÇÃO', 'CITQ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-AOC', 'DESEMB AURORA DE OLIVEIRA COENTRO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-EPVL', 'DESEMB EVANDRO PEREIRA VALADAO LOPES', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-FAZS', 'DESEMB FERNANDO ZORZENON DA SILVA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JFGF', 'DESEMB JORGE FERNANDO GONCALVES DA FONTE', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AJU', 'ASSESSORIA JURIDICA DA PRESIDENCIA', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('17VTRJ', '17a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COAS', 'COORDENADORIA DE ANÁLISE DE SOLUÇÕES', 'SST', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SSTI', 'SECRETARIA DE SOLUÇÕES EM TECNOLOGIA DA INFORMAÇÃO', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCOT', 'SEÇÃO DE CONTROLE DE TELEFONIA', 'DITEL', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CGNC', 'COORDENADORIA DE GESTÃO DE NÚCLEOS DE COMPUTAÇÃO', 'STI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CGSP', 'COORDENADORIA DE GESTÃO DE SISTEMAS E PORTAL', 'STI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDAFSC', 'GAB DES. ANGELA FIORENCIO SOARES DA CUNHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDALCM', 'GAB DES. ALVARO LUIZ CARVALHO MOREIRA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDATFBC', 'GAB DES. ALEXANDRE TEIXEIRA DE FREITAS B. CUNHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTCOR', '1a VT DE CORDEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-ITP', 'POSTO AVANÇADO JUST TRAB  DE S.A. DE PÁDUA -VT-ITP', '1VTITP', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTMAG', '1a VT DE MAGE', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTMAR', '1a VT DE MARICÁ', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETEC', 'SEÇÃO DE TELECOMUNICAÇÕES', 'DGIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGNC', 'DIVISÃO DE GESTÃO DE NÚCLEOS DE COMPUTAÇÃO', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPRO', 'SEÇÃO DE SEGURANÇA E PRODUTIVIDADE', 'DITE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEOPE', 'SECAO DE OPERACAO', 'DOST', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDEPMC', 'GAB DES. ELMA PEREIRA DE MELO CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDERS', 'GAB DES.  ENOQUE RIBEIRO DOS SANTOS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDGTA', 'GAB DES. GUSTAVO TADEU ALKMIM', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJFGF', 'GAB DES. JORGE FERNANDO GONÇALVES DA FONTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('21VTRJ', '21a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('26VTRJ', '26a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTSJM', '2a VT DE SAO JOAO DE MERITI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESET', 'SEÇÃO DE SUPORTE DE ESTAÇÕES DE TRABALHO', 'DSTU', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGSAU', 'SEÇÃO GESTÃO DOS SERVIÇOS DE ATENDIMEN AO USUARIO', 'DSTU', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSIN', 'SEÇÃO DE SEGURANÇA DE TECNOLOGIA DA INFORMAÇÃO', 'STI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGCA', 'DIRETORIA GERAL DE COORDENAÇÃO ADMINISTRATIVA', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SES', 'SECRETARIA DE ENGENHARIA E SEGURANÇA PATRIMONIAL', 'DGCA', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESEG-LAV', 'SEÇÃO DE SEGURANÇA E VIGILANCIA - LAVRADIO', 'DSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMGCVP', 'GAB DES. MARIA DAS GRACAS CABRAL VIEGAS PARANHOS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMLALS', 'GAB DES. MARIA DE LOURDES D''A. LIMA SALLABERRY', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('37VTRJ', '37a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('44VTRJ', '44a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('4VTNT', '4a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('4VTRJ', '4a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPAT', 'SEÇÃO DE PATRIMÔNIO', 'DPAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETENF', 'SETOR DE ENFERMAGEM', 'SMEDI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPAPE', 'SEÇÃO DE PAGAMENTO DE PENSIONISTAS', 'DIPA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SVAPE', 'SEÇÃO DE AVERBAÇÃO E CONCESSÃO DE APOSEN E PENSÕES', 'DLEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SRHPROV', 'SECRETARIA REC. HUMANOS provisoriamente', 'SRH', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-ACAR', 'GAB JUIZ ANTONIO CARLOS A RODRIGUES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('51VTRJ', '51a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('62VTRJ', '62a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('6VTDC', '6a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIRC', 'DIVISÃO DE RECLAMAÇÕES', 'SED', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SJU-GAB', 'GABINETE DA SECRETARIA JUDICIÁRIA', 'SJU', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAPAD', 'DIVISÃO DE APOIO ADMINISTRATIVO', 'COAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JRDAA', 'GAB JUIZ JOSE RICARDO DAMIAO DE ARAUJO AREOSA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-LCTB', 'GAB JUIZ LUIZ CARLOS TEIXEIRA BOMFIM', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('71VTRJ', '71a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('7VTNI', '7a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('80VTRJ', '80a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMOP', 'SEÇÃO DE MOVIMENTAÇÃO PROCESSUAL', 'DIMON', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CDES', 'COORDENADORIA DE DESENVOLVIMENTO', 'ESACS RJ', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DDES', 'DIVISÃO DE DESENVOLVIMENTO', 'ESACS RJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESUPE', 'SERVIÇO DE SUPORTE PEDAGÓGICO', 'DIED', 'SERVICO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPLA', 'SERVIÇO DE AVALIAÇÃO E PLANEJAMENTO', 'DPCO', 'SERVICO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECONC', 'SERVIÇO DE CONCURSO', 'DPCO', 'SERVICO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('OUTROS', 'OUTROS', 'PR', 'OUTROS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('APOSENT', 'APOSENTADOS', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DESLIGADO', 'DESLIGADO', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPUB', 'SECAO DE PUBLIC E DIVULG SECR EMATRA-RJ', 'DAEM', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EMATRA-GAB', 'GABINETE DA EMATRA', 'EMATRA-RJ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESAD', 'SECAO DE ADMINISTRACAO SECRET EMATRA-RJ', 'EMATRA-RJ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MASO', 'GAB JUIZ MARCELO AUGUSTO SOUTO DE OLIVEIRA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MLLS', 'GAB JUIZA MARIA DE LOURDES D''A. LIMA SALLABERRY', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MLN', 'GAB JUIZA MARCIA LEITE NERY', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MLP', 'GAB JUIZA MIRIAN LIPPI PACHECO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-TSG', 'GAB JUIZA TANIA DA SILVA GARCIA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIONC6', 'DIONC6 BBB', 'SEP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CPID', 'COMISSÃO P. DE INVENTÁRIO E DESFAZIMENTO MATERIAIS', 'DG', 'COMISSAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV9', 'GABINETE DE JUIZ CONVOCADO Nº 9', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ACE', 'ASSESSORIA DE CERIMONIAL E EVENTOS', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECVIA', 'SEÇÃO DE VIAGENS', 'ACE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMOP', 'SETOR DE MOVIMENTAÇÃO PROCESSUAL', 'SEMON', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEINS', 'SEÇÃO DE INSPEÇÃO', 'DCIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-SG', 'CENTRAL DE DIST DE MANDADOS SAO GONCALO', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-PE', 'SECAO PROTOCOLO EXPEDICAO PETROPOLIS', 'DF', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-VR', 'SECAO RECL DISTR FEITOS DE VOLTA REDONDA', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COSEG', 'COORDENADORIA DE SEGURANÇA', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EXEXT', 'SGP EXERCICIO EXTERNO', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEM SETOR', 'SEM SETOR', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PR-JURISP', 'SETOR DE JURISPRUDÊNCIA', 'PR', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DARE', 'DIVISAO DE AUDITORIA DE RECURSOS HUMANOS', 'SCI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAC', 'DIVISAO DE AUDITORIA CONTABIL', 'SCI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SDE', 'SECRETARIA DE DESENVOLVIMENTO INSTITUCIONAL', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDI-GAB', 'SECRETARIA DASEÇÃO ESPECIALIZADA DISSIDIOS INDIVID', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T1PR', 'PRIMEIRA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T4PR', 'QUARTA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CMG', 'COMISSÃO DE MODERNIZAÇÃO E GESTÃO', '1', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('BENS_NLOC_2010', 'Setor com bens de setores virtuais NLOC até 2010', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DINF-MSGAC', 'DIVISÃO DE INFRA-ESTRUTURA - MSGAC', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DINF-MSGAS', 'DIVISÃO DE INFRA-ESTRUTURA - MSGAS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETSEG-DC', 'SETOR DE SEGURANÇA E VIGILÂNCIA - DUQUE DE CAXIAS', 'SESEG-INT', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSEG-NI', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA - NOVA IGUAÇU', 'DISEG-INT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DG-GAB', 'GABINETE DA DIRETORIA-GERAL', 'DG', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAM', 'SECRETARIA DE ADMINISTRAÇÃO DE ATIVOS MÓVEIS', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CAEP', 'COORDENADORIA DE APOIO À EFETIVIDADE PROCESSUAL', 'SGJ', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECHAS', 'SEÇÃO DE HASTAS PÚBLICAS', 'DIAPE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCON-2', 'SEÇÃO DE CENTRALIZAÇÃO DA CONCILIAÇÃO DE 2º GRAU', 'DICON', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGC', 'SECRETARIA DA GESTÃO DO CONHECIMENTO', 'SGJ', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DITAB', 'DIVISÃO DE TRATAMENTO DE ACERVO BIBLIOGRÁFICO', 'CBIB', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECTAR-1', 'SEÇÃO DE ARQUIVO 1 (RJ)', 'DIARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-BO', 'DEPÓSITO DE BENS MOVEIS - BONSUCESSO', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-BR', 'DEPÓSITO DE BENS MÓVEIS - AV. BRASIL', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-LAV', 'DEPÓSITO DE BENS MOVEIS - LAVRADIO', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-RA', 'DEPÓSITO DE BENS MOVEIS - RAMOS', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSMI AGORA', 'SETORES VIRTUAIS DA DSMI', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NURES', 'NUCLEO DE RESPONSABILIDADE SOCIAL', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARN-III', 'SEÇÃO DE ARQUIVO DE NITEROI III', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SRR', 'SECRETARIA DE RECURSOS DE REVISTA', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TRT-LAVRADIO', 'SETORES VIRTUAIS MARQUES DO LAVRADIO', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DANDD', 'DIVISÃO DE ANÁLISE DE DIREITOS E DEVERES', 'CAPE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('LIC S/VENC', 'SEP LICENCA SEM VENCIMENTOS', 'SEP', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARJ', 'SEÇÃO DE ARQUIVO GERAL - RJ', 'DARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-1', 'SETOR DE ARQUIVO 1 (RJ)', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEACE', 'SEÇÃO DE GERENCIAMENTO DE ACERVOS', 'DIBI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDAC', 'SEÇÃO DE ACÓRDAOS', 'DIDU', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGP', 'SECRETARIA DE GESTÃO DE PESSOAS', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIRET', 'DIVISÃO DE RECRUTAMENTO', 'CORA', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CSAD', 'COORDENADORIA DE SAÚDE', 'SGP', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECASS', 'SEÇÃO DE ASSISTÊNCIA COMPLEMENTAR À SAÚDE', 'DIBEN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOP', 'SEÇÃO DE MOVIMENTAÇÃO DE PESSOAL', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPPE', 'DIVISÃO DE PREPARO DE PAGAMENTO DE PESSOAL', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DORC', 'DIVISÃO DE ORGANIZAÇÃO DO CONHECIMENTO', 'SGC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEP', 'SEÇÃO DE PESQUISA E PUBLICAÇÃO', 'DORC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGJ-GAB', 'GABINETE DA SECRETARIA-GERAL JUDICIÁRIA', 'SGJ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPRO-1', 'DIVISÃO DE PROTOCOLO DE 1ª INSTANCIA', 'CFEI-1', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERET', 'SEÇÃO DE RECRUTAMENTO', 'DRAV', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('LIC INPS', 'LICENCA INPS', 'SGP', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('MAGISTRADO', 'MAGISTRADO', 'SGP', 'OUTROS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIFEC', 'DIVISÃO DE FISCALIZAÇÃO DE EXECUÇÃO DE CONTRATOS', 'CCOT', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECARC', 'SEÇÃO DE ANÁLISE DE REAJUSTE CONTRATUAL', 'DIFEC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECREB', 'SEÇÃO DE REGULARIZAÇÃO DE BENS IMÓVEIS', 'DIFEC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPU-NT', 'DIVISÃO DE APOIO AO USUÁRIO DE NITERÓI', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPU-SG', 'DIVISÃO DE APOIO AO USUÁRIO DE SÃO GONÇALO', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDIF-DC', 'DIVISÃO PROTOC. E DIST. FEITOS - DUQUE DE CAXIAS', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIEMA', 'DIVISÃO DE EXPEDIÇÃO E MALOTE', 'CINF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETRAP', 'SETOR PROCEDIMENTOS APURATÓRIOS DE PENALIDADES', 'SEFEC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETREB', 'SETOR DE REGULARIZAÇÃO DE BENS IMÓVEIS', 'SEFEC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAPOV', 'SEÇÃO DE APOIO ÀS VARAS DA CAPITAL', 'DINF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETAGF', 'SETOR DE ADMINISTRAÇÃO DO FORO DA AV GOMES FREIRE', 'SEALG', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COEX', 'COORDENADORIA DE EXECUÇÃO', 'SJU-1', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-CF', 'SEÇÃO DE APOIO AS VARAS DO TRABALHO - CABO FRIO', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-CG', 'SEÇÃO DE APOIO AS VARAS DO TRABALHO-CAMPOS', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-PET', 'SEÇÃO DE APOIO AS VARAS DO TRABALHO - PETROPOLIS', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-SJM', 'SEÇÃO DE APOIO AS VARAS DO TRABALHO- S.JOAO MERITI', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIF-SG', 'SEÇÃO DE PROTOC. E DIST. DE FEITOS - S.GONÇALO', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMAI', 'DIVISÃO DE MANUTENÇÃO - INTERIOR', 'SME', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAN-DC', 'SEÇÃO DE MANUTENÇÃO DE DUQUE DE CAXIAS', 'DMAI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAN-NI', 'SEÇÃO DE MANUTENÇÃO DE NOVA IGUAÇU', 'DMAI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SME-GAB', 'GAB DA SECRETARIA DE MANUTENÇÃO E ENGENHARIA', 'SME', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMI', 'SECRETARIA DE MANUTENÇÃO E INFRAESTRUTURA PREDIAL', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEXP-AC', 'SEÇÃO DE EXPEDIÇÃO - ANTÔNIO CARLOS', 'DMANP-AC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-SG', 'SECAO DE PROTOCOLO E EXPEDICAO SAO GONCALO', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDEJ', 'SEÇÃO DE DEPÓSITO JUDICIAL', 'DIEX', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIS-1', 'SECAO DE DISTRIBUIÇÃO DE FEITOS', 'DIFE-1', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPRO-1', 'SECAO DE PROTOCOLO DE 1ª INSTANCIA', 'DIFE-1', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIM-RJ', 'SEÇÃO DE DISTRIBUIÇÃO DE MANDADOS', 'DMAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANI', 'DIVISÃO DE MANUTENÇÃO DO INTERIOR', 'CMAN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP', 'DIVISÃO DE MANUTENÇÃO PREDIAL', 'CMAN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMEQ', 'SEÇÃO DE MÁQUINAS E EQUIPAMENTOS', 'DIOP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPREC', 'DIVISÃO DE PRECATORIOS', 'CPRE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIREC', 'DIVISÃO DE RECURSOS', 'CSEP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPRE', 'DIVISAO DE GESTAO DE PRECATORIOS', 'SJU-2', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEREF', 'SEÇÃO DE REFRIGERAÇÃO', 'DIOP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESOM', 'SEÇÃO DE SOM', 'DIOP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEZEL', 'SEÇÃO DE ZELADORIA DA SEDE', 'DIOP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAN-SE', 'SEÇÃO DE MANUTENÇÃO DO EDIFÍCIO SEDE', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CCON', 'COORDENADORIA DE CONTABILIDADE', 'SOF', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SADES', 'SEÇÃO DE ACOMPANHAMENTO DE DESPESAS', 'DFIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SOF-GAB', 'GABINETE SECR ORÇAMENTO, FINANÇAS E CONTABILIDADE', 'SOF', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPROJ', 'DIVISÃO DE PROJETOS DE INFRAESTRUTURA', 'SOP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-ISG', 'DESEMB IZIDORO SOLER GUELMAN', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JFMJ', 'DESEMB JOSE DA FONSECA MARTINS JUNIOR', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JNAN', 'DESEMB JOSE NASCIMENTO ARAUJO NETTO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCAD', 'SETOR DE CADASTRAMENTO', 'NUGESQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECGER', 'SEÇÃO DE GERENCIAMENTO BOLETIM INT. DIARIO ELT. JT', 'AIC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTANG', '1a VT DE ANGRA DOS REIS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DITEL', 'DIVISÃO DE TELECOMUNICAÇÕES', 'CGIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMPO', 'DIVISÃO DE DESENVOLVIMENTO E MANUTENÇÃO DO PORTAL', 'CGSP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('A.CARLOS', 'CSTU ANTONIO CARLOS', 'CSTU', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-LCTB', 'DESEMB LUIZ CARLOS TEIXEIRA BOMFIM', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-MBC', 'DESEMB MERY BUCKER CAMINHA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-TSG', 'DESEMB TANIA DA SILVA GARCIA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDBLAL', 'GAB DES. BRUNO LOSADA ALBUQUERQUE LOPES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTITG', '1a VT DE ITAGUAI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTPE', '1a VT DE PETROPOLIS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSETI', 'DIVISÃO DE SUPORTE A EQUIPAMENTOS DE TEC DA INFORM', 'CSTU', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('LAVRADIO', 'DSTU LAVRADIO', 'CSTU', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAST', 'DIVISAO DE ADMINISTRACAO DE SISTEMAS', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGPIR', 'SEÇÃO GERENCIA E PROJ DE INFRA-ESTRUTURA DE REDE', 'DGIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEONC', 'SEÇÃO DE OPERAÇÃO DE NÚCLEOS DE COMPUTAÇÃO', 'DGNC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DOST', 'DIVISAO DE OPERACAO E SUPORTE TECNICO', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDAP/BACK', 'SECAO DE APOIO AO USUARIO BACKUP', 'DOST', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEOPE-FCC', 'SECAO DE OPERACAO-AUTO ATENDIMENTO FCC', 'DOST', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDCMC', 'GAB DES. CESAR MARQUES CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDDAO', 'GAB DES. DALVA AMELIA DE OLIVEIRA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJATS', 'GAB DES. JOSE ANTONIO TEIXEIRA DA SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJCNC', 'GAB DES JOSE CARLOS NOVIS CESAR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('23VTRJ', '23a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTRJ', '2a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTVR', '2a VT DE VOLTA REDONDA', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('33VTRJ', '33a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EMPRESA', 'DSMI EMPRESA CONTRATADA', 'DSMI', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESHA', 'SEÇÃO DE SUPORTE A HARDWARE', 'DSMI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESVI-LV', 'SECAO DE SEG E VIG EDIF MARQUES LAVRADIO', 'DSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEVIG-NT', 'SECAO SEG VIG FORUM MIN GERALDO MENEZES', 'DSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SES-GAB', 'GABINETE SECR ENGENHARIA E SEGURANÇA PATRIMONIAL', 'SES', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDLAPM', 'GAB DES. LUIZ AUGUSTO PIMENTA DE MELLO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDLSP', 'GAB DES. LEONARDO DA SILVEIRA PACHECO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMACM', 'GAB DES. MARIA APARECIDA COUTINHO MAGALHAES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMLN', 'GAB DES. MARCIA LEITE NERY', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTSG', '3a VT DE SÃO GONÇALO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('40VTRJ', '40a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('41VTRJ', '41a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-AC', 'DEPÓSITO DE BENS MOVEIS - ANTONIO CARLOS', 'SEMOV', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECLAB', 'SETOR DE CLASSIFICACAO DE BENS', 'SEPAT', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETAOD', 'SETOR DE ATENDIMENTO ODONTOLÓGICO', 'SMEDI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETFIS', 'SETOR DE FISIOTERAPIA', 'SMEDI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEN', 'SEÇÃO DE LOTAÇÃO DE PENSIONISTAS', 'DIPA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPINA', 'SEÇAO DE PAGAMENTO DE INATIVOS', 'DIPA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-APAS', 'GAB JUIZ AFRANIO PEIXOTO ALVES DOS SANTOS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-AS', 'GAB JUIZ ALOYSIO SANTOS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('57VTRJ', '57a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('5VTDC', '5a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('6VTNI', '6a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-NT', 'POSTO AVANÇADO JUST TRAB - MARICÁ  VT-NIT', '6VTNT', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDMA-SG', 'SEÇÃO DISTRIB DE FEITOS E MANDADOS - SÃO GONÇALO', 'DGCJ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEATE', 'SECAO DE ATENDIMENTO PROCESSUAL', 'DCAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEG', 'SECAO DE PROTOCOLO GERAL', 'DCAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEPE', 'COORDENADORIA DE ENSINO PROJETOS E EVENTOS', 'EJ1', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIENS', 'DIVISÃO DE ENSINO', 'CEPE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEV', 'SEÇÃO DE PROJETOS E EVENTOS', 'DEJE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-IDRA', 'GAB JUIZ IVAN DIAS RODRIGUES ALVES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JMM', 'GAB JUIZ JOAO MARIO DE MEDEIROS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JNAN', 'GAB JUIZ JOSE NASCIMENTO A NETTO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('7VTNT', '7a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('8VTNT', '8a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JCJ-EXT', 'JCJ EXTINTA', 'CR', 'JUNTA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAPA', 'POSTO AVANCADO DE PARATY', 'CR', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PARO', 'POSTO AVANCADO DE RIO DAS OSTRAS', 'CR', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CCIN', 'COORDENADORIA DE CORREIÇÃO E INSPEÇÃO', 'SCR', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DADM', 'DIVISÃO DE APOIO ADMINISTRATIVO', 'SCR', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAAD', 'DIVISÃO DE APOIO ADMINISTRATIVO', 'CCAP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSAO', 'DIVISAO DE SUPORTE ADMINISTRATIVO E OPERACIONAL', 'ESACS RJ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EXEPROV', 'SEP EXERCÍCIO PROVISÓRIO', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MGCVP', 'GAB JUIZA MARIA DAS GRACAS C V PARANHOS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MJAT', 'GAB JUIZA MARIA JOSE AGUIAR T OLIVEIRA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V3', 'GABINETE DE JUIZ CONVOCADO No 3', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-ZJMN', 'GAB JUIZA ZULEICA JORGENSEN M NASCIMENTO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV11', 'GABINETE DE JUIZ CONVOCADO Nº 11', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV5', 'GABINETE DE JUIZ CONVOCADO No 5', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JUIZ SUB', 'JUIZ SUBSTITUTO', 'TP', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PR', 'PRESIDENCIA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ACC', 'ASSESSORIA DE COMUNICAÇÃO E CERIMONIAL', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ADI', 'ASSESSORIA DE DESENVOLVIMENTO INSTITUCIONAL', 'PR', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-MA', 'CENTRAL DE DIST DE MANDADOS DE MACAE', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-VR', 'CENTRAL DE DIST DE MANDADOS V REDONDA', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-CG', 'SECAO PROTOC.EXPEDICAO CAMPOS GOYTACAZES', 'DF', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-MA', 'SECAO DE PROTOCOLO EXPEDICAO DE MACAE', 'DF', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ACF', 'ASSESSORIA DE CONFORMIDADE', 'DG', 'ASSESSORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESEG-CAP', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA - CAPITAL', 'COSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('REMOVIDO', 'SEP Removido para outro órgão', 'OUTROS', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCI', 'SECRETARIA DE CONTROLE INTERNO', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDI-II', 'SUBSEÇÃO ESPECIALIZADA DISSIDIOS INDIVIDUAIS II', 'SEDI', 'TRIBUNAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SC', 'SECR SECAO ESPECIAL DISSIDIOS COLETIVOS', 'SP', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T6PR', 'SEXTA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1', 'TRT_AGORA', null, 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DF-ANG', 'DIRETOR DE FORO - ANGRA DOS REIS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DITRA', 'DIVISÃO DE TRANSPORTES', 'SAM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGJ', 'SECRETARIA-GERAL JUDICIÁRIA', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECPEP', 'SEÇÃO DE PESQUISA PATRIMONIAL', 'DIAPE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-BO-GAB', 'DEPÓSITO DE BENS MOVEIS - BONSUCESSO - GABINETE', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2005-NLOC', 'INV2005-ATIVOS BENS NÃO LOCALIZADOS', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('RECLAS', 'BENS RECLASSIFICADOS DE PERMANENTE PARA CONSUMO', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMOB', 'SEÇÃO DE MOVIMENTAÇÃO DE BENS', 'SAM', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCO', 'SECRETARIA DE ADMINISTRAÇÃO DE CONTRATOS', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CONVFERIAS', 'CONVOCAÇÃO DE JUÍZES EM FÉRIAS  PERÍODO > 11 MESES', 'SEP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CPPE', 'COORDENADORIA DE PREPARO DE PAGAMENTO DE PESSOAL', 'SEP', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPPA', 'DIVISÃO DE PREPARO DE PAGAMENTO DE ATIVOS', 'CPPE', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAO-EXT', 'SECAO EXTINTA', 'SEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIGED', 'DIVISÃO DE GESTÃO DE DOCUMENTOS', 'CGAA', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DARQ', 'DIVISÃO DE GESTÃO DE ACERVOS ARQUIVISTICOS', 'SGC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-NT', 'SETOR DE ARQUIVO DE NITERÓI', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEGED', 'SEÇÃO DE GESTÃO DE DOCUMENTOS', 'DARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETADM', 'SETOR DE ADMINISTRAÇÃO DO CENTRO CULTURAL', 'SEGED', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPERPROV', 'SGP DIVISÃO DE ATEND PERICIAL PROVISORIAMENTE', 'CSAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERCE', 'SEÇÃO DE REGISTRO E CONTROLE FUNCIONAIS', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CMAD', 'COORDENAD. DE CONTROLE E DISTRIBUIÇÃO DE MANDADOS', 'SJU-1', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CODI', 'COORDENADORIA DAS DIVISÕES DO INTERIOR', 'SJU-1', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSAD', 'DIVISÃO DE SAÚDE', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETATE', 'SETOR DE ATENDIMENTO', 'SGP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SLG', 'SECRETARIA DE LOGÍSTICA', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-MAC', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO- MACAE', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-NI', 'DIVISÃO APOIO AS VARAS DO TRABALHO - NOVA IGUAÇU', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMOB', 'DIVISÃO DE MOVIMENTAÇÃO DE BENS', 'CINF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DINF', 'DIVISÃO DE INFRA-ESTRUTURA', 'SLG', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOB', 'SEÇÃO DE MOVIMENTAÇÃO DE BENS', 'DINF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-NT', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO - NITEROI', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-SG', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO - S.GONÇALO', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDEJ', 'DIVISÃO DE DEPÓSITO JUDICIAL', 'COEX', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIF-NT', 'SEÇÃO DE PROTOC. E DIST. DE FEITOS - NITERÓI', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAV', 'SETOR DE MANUTENÇÃO DE VEÍCULOS', 'SETRA', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEALM', 'SEÇÃO DE ALMOXARIFADO', 'DMAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GRTA', 'PERÍCIA-GARANTIA', 'SMAPE', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SME', 'SECRETARIA DE MANUTENÇÃO E ENGENHARIA', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAN-SG', 'SEÇÃO DE MANUTENÇÃO DE SÃO GONÇALO', 'DMAI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP-A2', 'DIVISÃO DE APOIO E MANUTENÇÃO PREDIAL - ÁREA 2', 'SMI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP-A4', 'DIVISÃO DE APOIO E MANUTENÇÃO PREDIAL - ÁREA 4', 'SMI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAJ', 'SEÇÃO DE ARRECADAÇÃO JUDICIAL', 'DIEX', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDEJ-RA', 'SEÇÃO DE DEPOSITO JUDICIAL DE RAMOS', 'DIEX', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAMP-AD', 'SEÇÃO DE APOIO MANUT PREDIAL-ARQUIVOS E DEPÓSITOS', 'SMI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CMAN', 'COORDENADORIA DE MANUTENÇÃO', 'SMO', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAI-SG', 'SEÇÃO DE MANUTENÇÃO DE SÃO GONÇALO', 'DMANI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEFIS', 'SEÇÃO DE ACOMPANHAMENTO E FISCALIZAÇÃO DE OBRAS', 'DIOB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECDIG', 'SEÇÃO DE DIGITALIZAÇÃO', 'DIRAG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETDIG', 'SETOR DE DIGITALIZAÇÃO', 'SERAG', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERCOP', 'SETOR DE COPIAS XEROGRÁFICAS', 'DIOP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAI-SG', 'SETOR DE MANUTENÇÃO DE SÃO GONÇALO', 'SEMAI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAN-LV', 'SEÇÃO DE MANUTENÇÃO  EDIFÍCIO MARQUES DO LAVRADÍO', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETMAP-L/G', 'SETOR DE MANUTENÇÃO PREDIAL-LAVRADIO/G.FREIRE', 'SEMAP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETALV', 'SETOR DE ALVENARIA', 'SREPA', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SI', 'SECR SECAO ESPEC DISSIDIOS INDIVIDUAIS', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPOD', 'SEÇÃO DE PROCESSAMENTO DE DESPESA', 'DFIN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CITQ', 'COORDENADORIA DE IMPLEMENTAÇÃO, TESTE E QUALIDADE', 'SST', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-AFSC', 'DESEMB ANGELA FIORENCIO S. DA CUNHA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-CMC', 'DESEMB CESAR MARQUES CARVALHO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-EG', 'DESEMB EDILSON GONCALVES', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-EMCT', 'DESEMB EDITH MARIA CORREA TOURINHO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-FERS', 'DESEMB FLAVIO ERNESTO RODRIGUES SILVA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('10VTRJ', '10a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('13VTRJ', '13a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('15VTRJ', '15a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('18VTRJ', '18a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTARA', '1a VT DE ARARUAMA', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTCF', '1a VT DE CABO FRIO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DITES', 'DIVISÃO DE TESTE E HOMOLOGAÇÃO', 'CITQ', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SST-GAB', 'GABINETE SEC SOLUÇÕES EM TECNOLOGIA DA INFORMAÇÃO', 'SST', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('STI-SLR', 'SALA DE REUNIÃO DA STI', 'SST', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('STI', 'SECRETARIA DE TECNOLOGIA DA INFORMAÇÃO', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIGAR', 'DIVISÃO DE GERENCIA DE ATIVOS DE REDE', 'CGIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-NTB', 'DESEMB NELSON TOMAZ BRAGA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-MAC', 'POSTO AVANÇADO - RIO DAS OSTRAS', '1VTMA', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTNT', '1a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTTR', '1a VT DE TRÊS RIOS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CURSO', 'TREINAMENTO PARA USUARIO ARCHON', 'DAST', 'OUTROS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEABD', 'SEÇÃO DE ADMINISTRAÇÃO DE BANCO DE DADOS', 'DGNC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDCJC', 'GAB DES. CELIO JUAÇABA CAVALCANTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDCSGF', 'GAB DES. CLAUDIA DE SOUZA GOMES FREIRE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTVR', '1a VT DE VOLTA REDONDA', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('22VTRJ', '22a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('27VTRJ', '27a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('29VTRJ', '29a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTCF', '2a VT DE CABO FRIO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTITG', '2a VT DE ITAGUAI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTPE', '2a VT DE PETROPOLIS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('31VTRJ', '31a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPL', 'SEÇÃO DE APLICATIVOS', 'DSEN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSMI', 'DIVISÃO DE SUPORTE A MICROINFORMATICA', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMAT', 'DIVISÃO DE MATERIAL', 'SMP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEACO', 'SEÇÃO DE ANALISE E ATENDIMENTO DE MATERIAL CONSUMO', 'DMAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPAT', 'DIVISÃO DE PATRIMÔNIO', 'SMP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJFMJ', 'GAB DES. JOSE DA FONSECA MARTINS JUNIOR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJGF', 'GAB DES. JOSE GERALDO DA FONSECA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJRDAA', 'GAB DES. JOSE RICARDO DAMIAO DE ARAUJO AREOSA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('38VTRJ', '38a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTMA', '3a VT DE MACAE', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTSJM', '3a VT DE SAO JOAO DE MERITI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('49VTRJ', '49a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('4VTDC', '4a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('4VTNI', '4a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDTBSF', 'GAB DES. THEOCRITO BORGES DOS SANTOS FILHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDVBC', 'GAB DES. VOLIA BOMFIM CASSAR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-ACA', 'GAB JUIZ ANTONIO CARLOS AREAL', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-AFG', 'GAB JUIZ ALBERTO FORTES GIL', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-AMSM', 'GAB JUIZA ANA MARIA SOARES DE MORAES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('5VTNT', '5a VT DE NITEROI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('63VTRJ', '63a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SED-GAB', 'GABINETE DA SECRETARIA DE DISTRIBUICAO', 'SED', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEG-II', 'SECAO DE PROTOCOLO DE SEGUNDA INSTANCIA', 'DCAD', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COAD', 'COORDENADORIA DE ADMINISTRAÇÃO', 'EJ1', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEJE', 'DIVISÃO DE ENSINO PROJETOS E EVENTOS', 'EJ1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAD', 'DIVISÃO DE ADMINISTRAÇÃO', 'EJ1', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-CMC', 'GAB JUIZ CESAR MARQUES CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-EPMC', 'GAB JUIZA ELMA PEREIRA DE MELO CARVALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-FAZS', 'GAB JUIZ FERNANDO ANTONIO ZORZENON DA SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-GTA', 'GAB JUIZ GUSTAVO TADEU ALKMIM', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-LAML', 'GAB JUIZ LUIZ ALFREDO MAFRA LINO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('77VTRJ', '77a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('78VTRJ', '78a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('79VTRJ', '79a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('8VTRJ', '8a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('9VTRJ', '9a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICOI', 'DIVISÃO DE CORREIÇÃO', 'CCIN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SELOGI', 'SERVIÇO DE LOGÍSTICA', 'DSAO', 'SERVICO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-MAP', 'GAB JUIZ MARCOS ANTONIO PALACIO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-NAA', 'GAB JUIZA NIDIA DE ASSUNCAO AGUIAR', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-RAMB', 'GAB JUIZ RILDO ALBUQUERQUE MOUSINHO DE BRITO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V4', 'GABINETE DE JUIZ CONVOCADO No 4', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V8', 'GABINETE DE JUIZ CONVOCADO Nº 8', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV10', 'GABINETE DE JUIZ CONVOCADO Nº 10', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV4', 'GABINETE DE JUIZ CONVOCADO No 4', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV8', 'GABINETE DE JUIZ CONVOCADO Nº 8', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUAGESQ', 'NUCLEO DE APOIO AO SISTEMA DE GESTAO', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUAUSG', 'NUCLEO DE APOIO AS AUDITORIAS DO SISTEMA DE GESTAO', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUDEST', 'NÚCLEO DE ESTATÍSTICA', 'ADI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCR-GAB', 'GABINETE DA SECRETARIA DA CORREGEDORIA REGIONAL', 'SCR', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-CA', 'SECAO RECL DISTR FEITOS DE CAMPOS', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-SG', 'SECAO RECL DISTR FEITOS DE SAO GONCALO', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DG', 'DIRETORIA-GERAL', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COPC', 'COORDENADORIA DE GESTÃO DE PROCESSOS', 'SDE', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISF', 'DIVISAO DE DISTRIBUICAO DE FEITOS 2 GRAU', 'SG', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T7PR', 'SETIMA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T9PR', 'NONA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SET AGORA', 'SETORES VIRTUAIS AGORA', '1', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COMIN/2009', 'COMISSÃO ANUAL DE INVENTÁRIO PERMANENTE - 2009', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COMIN2011', 'COMISSÃO ANUAL DE INVENTÁRIO PERMANENTE - 2011', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CSEG', 'COORDENADORIA DE SEGURANÇA', 'DG', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSEG-SG', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA - SÃO GONÇALO', 'DISEG-INT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCMAT', 'DIVISÃO DE CONTROLE DE  MATERIAL', 'SAM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DDESF', 'DIVISÃO DE DESFAZIMENTO DE BENS', 'SAM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAP', 'DIVISÃO DE MATERIAL PERMANENTE', 'SAM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CASJ', 'COORDENADORIA DE APOIO AOS SISTEMAS JUDICIÁRIOS', 'SGJ', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECTAR-4', 'SEÇÃO DE ARQUIVO 4', 'DIARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-ED', 'DEPÓSITO DE BENS MOVEIS - ENGENHO DE DENTRO', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('INV2008-IBB', 'INV2008-INATIVOS BENS A BAIXAR', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NDI', 'NUCLEO DE DESENVOLVIMENTO INSTITUCIONAL', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECGRA', 'SEÇÃO DE GRÁFICA', 'SAM', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CAPE', 'COORDENADORIA DE ADMINISTRAÇÃO DE PESSOAL', 'SEP', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEDI', 'SEÇÃO DE CADASTRAMENTO APOIO CERTIFICAÇÃO DIGITAL', 'SEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECADM', 'SEÇÃO DE ADMINISTRAÇÃO DO CENTRO CULTURAL', 'DIGED', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECGEC', 'SEÇÃO DE GESTÃO DO CONTEÚDO', 'DESCO', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARC', 'SECAO DE ARQUIVO JUDICIAL - DUQUE DE CAXIAS', 'DARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ-2', 'SETOR DE ARQUIVO 2 (RJ2)', 'SEARQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEARQ-NI', 'SEÇÃO DE ARQUIVO JUDICIAL DE NOVA IGUAÇÚ', 'DARQ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDU', 'DIVISAO DE DOCUMENTACAO', 'SGC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEADI', 'SEÇÃO DE APROPRIAÇÃO E DIVULGAÇÃO DO CONHECIMENTO', 'DIDU', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEBIB', 'SEÇÃO DE BIBLIOTECA', 'DIDU', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCOPE', 'SEÇÃO DE CONTROLE DE PESSOAL', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEBEN', 'SEÇÃO DE ADMINISTRAÇÃO DE BENEFÍCIOS', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETACS', 'SETOR DE ASSISTÊNCIA COMPLEMENTAR À SAÚDE', 'SEBEN', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETREC', 'SETOR DE RECEPÇÃO E APOIO ADMINISTRATIVO', 'SEBEN', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEATEN', 'SETOR DE ATENDIMENTO INTERNO E EXTERNO', 'SEPEP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAPE-1', 'SEÇÃO DE ATENDIMENTO AO USUÁRIO DO PJe-LAVRADIO', 'DIAPU-1', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPRI', 'DIVISÃO DE PROTOCOLO INTEGRADO', 'CFEI-1', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECRED', 'SEÇÃO DE RECEBIMENTO E DEVOLUÇÃO DE MANDADOS', 'DIMAN-RJ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPPA', 'SEÇÃO DE PREPARO DE PAGAMENTO DE ATIVOS', 'DPPE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGP-GAB', 'GABINETE DA SECRETARIA DE GESTÃO DE PESSOAS', 'SGP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SGPTRANS', 'SECRETARIA GESTAO PESSOAS transitorio', 'SGP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICOM', 'DIVISÃO DE COMPRAS', 'CCOT', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAN-DC', 'DIVISÃO DISTRIBUIÇÃO DE MANDADOS - DUQUE D CAXIAS', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAN-NT', 'DIVISÃO DE DISTRIBUIÇÃO DE MANDADOS - NITEROI', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPEX-SG', 'DIVISÃO DE PROTOCOLO E EXPEDIÇÃO - SÃO GONÇALO', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIALG', 'DIVISÃO DE APOIO AOS PRÉDIOS LAVRADIO/GOMES FREIRE', 'CINF', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPAD', 'DIVISÃO DE PADRONIZAÇÃO', 'CMAP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAPS-GAB05', 'DIAPS-GAB05', 'SLG', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDOR', 'SEÇÃO DE  DOCUMENTO DE REFERÊNCIA', 'DICO', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETEXP-SEDE', 'SETOR DE EXPEDIÇÃO DO EDÍFICIO SEDE', 'SECEM', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-RES', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO - RESENDE', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-VR', 'SEÇÃO DE APOIO AS VARAS DO TRABALHO  VOLTA REDONDA', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIF-DC', 'SEÇÃO PROTOC. E DIST. DE FEITOS - DUQUE DE CAXIAS', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SLG-GAB', 'GABINETE DA SECRETARIA DE LOGÍSTICA', 'SLG', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAN-NT', 'SEÇÃO DE MANUTENÇÃO DE NITERÓI', 'DMAI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DMANP-A3', 'DIVISÃO DE APOIO E MANUTENÇÃO PREDIAL - ÁREA 3', 'SMI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEX-NT', 'SECAO DE PROTOCOLO EXPEDICAO DE NITEROI', 'DCOI', 'SECAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEATUS-1', 'SEÇÃO DE ATENDIMENTO AO USUÁRIO - LAVRADIO', 'SJU-1', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAE', 'DIVISÃO DE MANUTENÇÃO DE EQUIPAMENTOS', 'CMAN', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERCOP-FCC', 'SETOR DE COPIAS XEROGRAFICAS-FMCC', 'SEMEQ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERLUB', 'SETOR DE LUBRIFICAÇÃO', 'SEOFI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCOE', 'SEÇÃO DE CONTROLE DE EXPEDIENTE', 'DIREC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIFE-2', 'DIVISAO DE FEITOS DE 2ª INSTANCIA', 'SJU-2', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPREC', 'SECAO DE PRECATORIOS', 'DPRE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECAR', 'SEÇÃO DE CARPINTARIA', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SELET', 'SEÇÃO DE ELÉTRICA', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SOF', 'SECRETARIA DE ORÇAMENTO FINANÇAS E CONTABILIDADE', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICOG', 'DIVISÃO DE CONTABILIDADE GERENCIAL', 'CCON', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CFIN', 'COORDENADORIA FINANCEIRA', 'SOF', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETCOE', 'SETOR DE CONTROLE DE EXPEDIENTE', 'SEREC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETHAS', 'SETOR DE HASTAS PÚBLICAS', 'NUCECI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPR-ADIDAS', 'SECRETARIA-GERAL DA PRESIDÊNCIA-ADIDAS', 'SPR', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST2', 'SECRETARIA DA 2A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDI', 'SEÇÃO ESPECIALIZADA EM  DISSIDIOS INDIVIDUAIS', 'TP', 'TRIBUNAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPLOR', 'DIVISÃO DE PLANEJAMENTO ORÇAMENTÁRIO', 'CPOR', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SOP', 'SECRETARIA DE OBRAS E PROJETOS', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('NUPERG', 'NUCLEO DE PESQUISA ERGONOMICA', null, 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-AFG', 'DESEMB ALBERTO FORTES GIL', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-GRFM', 'DESEMB GLORIA REGINA FERREIRA MELLO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-GTA', 'DESEMB GUSTAVO TADEU ALKMIM', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JMM', 'DESEMB JOAO MARIO DE MEDEIROS', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-JRDAA', 'DESEMB JOSE RICARDO DAMIAO DE A AREOSA', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CR', 'CORREGEDORIA REGIONAL', 'PR', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('12VTRJ', '12a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('16VTRJ', '16a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTBM', '1a VT DE BARRA MANSA', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTBP', '1a VT DE BARRA DO PIRAI', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIREM', 'DIVISÃO DE REQUISITO E MÉTRICA', 'COAS', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISAG', 'DIVISÃO DE SISTEMAS DE APOIO A GESTÃO', 'CGSP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CSTU', 'COORDENADORIA DE SUPORTE TÉCNICO AO USUÁRIO', 'STI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISAU', 'DIVISÃO GESTÃO DOS SERVIÇOS DE ATENDIM. AO USUARIO', 'CSTU', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-NAA', 'DESEMB NIDIA DE ASSUNCAO AGUIAR', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-RSVT', 'DESEMB ROSANA SALIM VILLELA TRAVESEDO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-ZJMN', 'DESEMB ZULEICA JORGENSEN M NASCIMENTO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDAMSM', 'GAB DES. ANA MARIA SOARES DE MORAES', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTDC', '1a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-SAP', 'POSTO AVANÇADO JUST TRAB  DE S.A. DE PÁDUA -VT-ITP', '1VTITP', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTMA', '1a VT DE MACAE', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-CAN', 'POSTO AVANÇADO JUST TRAB - CANTAGALO  VT-NF', '1VTNF', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTNIL', '1a VT DE NILOPOLIS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETSI', 'SETOR DE SEGURANÇA DE TECNOLOGIA DA INFORMAÇÃO', 'SEONC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEADA', 'SEÇÃO DE ADMINISTRAÇÃO DE DADOS', 'DGSP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDFAZS', 'GAB DES. FERNANDO ANTONIO ZORZENON DA SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDGRFM', 'GAB DES. GLORIA REGINA FERREIRA MELLO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('25VTRJ', '25a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTCAM', '2a VT DE CAMPOS DOS GOYTACAZES', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTNF', '2a VT DE NOVA FRIBURGO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('30VTRJ', '30a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('MANUT DSMI', 'DSMI MANUTENCAO', 'DSMI', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSTU', 'DIVISÃO DE SUPORTE TÉCNICO AO USUÁRIO', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESEG-SEDE', 'SEÇÃO DE SEGURANÇA E VIGILANCIA - SEDE', 'DSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESVI-SE', 'SECAO DE SEG E VIG EDIF SEDE', 'DSEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMP', 'SECRETARIA DE MATERIAL E PATRIMÔNIO', 'DGCA', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJLGLV', 'GAB DES. JOSE LUIZ DA GAMA LIMA VALENTINO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDLAML', 'GAB DES. LUIZ ALFREDO MAFRA LINO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMBC', 'GAB DES. MERY BUCKER CAMINHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-RO', 'POSTO AVANÇADO JUST TRAB RIO DAS OSTRAS VT-CF', '3VTMA', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTVR', '3a VT DE VOLTA REDONDA', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('47VTRJ', '47a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('48VTRJ', '48a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMOV', 'SEÇÃO DE DEPÓSITO DE BENS MÓVEIS', 'DPAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-SC', 'DEPÓSITO DE BENS MOVEIS - SÃO CRISTÓVÃO', 'SEMOV', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSEC', 'DIVISÃO DE SERVIÇOS COMPRAS E CONTRATOS', 'SMP', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOT', 'SEÇÃO DE CONTRATOS', 'DSEC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SMEDI', 'SEÇÃO MÉDICA', 'DIAB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETPSI', 'SETOR DE ATENDIMENTO PSICOLOGICO', 'SMEDI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SELEG', 'SEÇÃO DE LEGISLAÇÃO DE PESSOAL', 'DLEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDPPBS', 'GAB DES. PATRICIA PELLEGRINI BAPTISTA DA SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDRAMB', 'GAB DES. RILDO ALBUQUERQUE MOUSINHO DE BRITO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDRN', 'GAB DES. ROBERTO NORRIS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-AFSC', 'GAB JUIZ ANGELA FIORENCIO SOARES DA CUNHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-ASAB', 'GABJUIZ ALEXANDRE DE SOUZA AGRA BELMONTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('53VTRJ', '53a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('55VTRJ', '55a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('5VTRJ', '5a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('61VTRJ', '61a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('66VTRJ', '66a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('69VTRJ', '69a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIS', 'SEÇÃO DE DISTRIBUIÇÃO', 'DIST', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-DV', 'GAB JUIZ DAMIR VRCIBRADIC', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JATS', 'GAB JUIZ JOSE ANTONIO TEIXEIRA DA SILVA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-LAPM', 'GAB JUIZ LUIZ AUGUSTO P DE MELLO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('70VTRJ', '70a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('72VTRJ', '72a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('76VTRJ', '76a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('7VTRJ', '7a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMON', 'DIVISÃO DE MONITORAMENTO', 'CADM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECORC', 'SEÇÃO DE ORÇAMENTO E CONTRATAÇÃO', 'DICAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETORC', 'SETOR DE ORÇAMENTO E CONTRATAÇÃO', 'SEDCP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDEP', 'SEÇÃO DE DESENVOLVIMENTO PROFISSIONAL', 'DDES', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEBID', 'SECAO BIBLIOTECA E DOCUM SECR EMATRA-RJ', 'EMATRA-RJ', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-NTB', 'GAB JUIZ NELSON TOMAZ BRAGA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-RSVT', 'GAB JUIZ ROSANA SALIM VILLELA TRAVESEDO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V1', 'GABINETE DE JUIZ CONVOCADO No 1', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V5', 'GABINETE DE JUIZ CONVOCADO No 5', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-V9', 'GABINETE DE JUIZ CONVOCADO Nº 9', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJV3', 'GABINETE DE JUIZ CONVOCADO No 3', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-NI', 'CENTRAL DE DIST DE MANDADOS NOVA IGUACU', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEDIST-SJM', 'CENTRAL DE DIST DE MANDADOS S J MERITI', 'DF', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-NI', 'SECAO RECL DISTR FEITOS NOVA IGUACU', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERDI-PE', 'SECAO RECL DISTR FEITOS DE PETROPOLIS', 'DF', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CACO', 'COORDENADORIA DE AUDITORIA CONTÁBIL', 'SCI', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DAUP', 'DIVISÃO DE AUDITORIA DE PESSOAL', 'SCI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SCI-GAB', 'GABINETE DA SECRETARIA DE CONTROLE INTERNO', 'SCI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIC', 'SEÇÃO ESPECIALIZADA EM DISSIDIOS COLETIVOS', 'TP', 'TRIBUNAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SL-SESSAO4', 'SALA DE SESSAO4', 'SP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('T5PR', 'QUINTA TURMA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('COMIN/2006', 'COMISSÃO ANUAL DE INVENTÁRIO PERMANENTE - 2006', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DF-CF', 'DIRETOR DE FORO - CABO FRIO', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIPAT AGORA', 'SETORES VIRTUAIS DA DIPAT', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEPRO-PR', 'DEPOSITO PROVISORIO - PRESIDENCIA', 'DIAJ-DEPRO', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DPAT AGORA', 'SETORES VIRTUAIS DA DPAT', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISEG-CAP', 'DIVISÃO DE SEGURANÇA E VIGILÂNCIA - CAPITAL', 'CSEG', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECSEG-SEDE', 'SEÇÃO DE SEGURANÇA E VIGILÂNCIA - SEDE', 'DISEG-CAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DISEG-INT', 'DIVISÃO DE SEGURANÇA E VIGILANCIA - INTERIOR', 'CSEG', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GES', 'GRUPO ESPECIAL DE SEGURANÇA', 'CSEG', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DECOM', 'DIVISÃO DE ESPECIFICAÇÃO E COMPRA DE MATERIAIS', 'SAM', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECMAV', 'SEÇÃO DE MANUTENÇÃO DE VEÍCULOS', 'DITRA', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECCON-1', 'SEÇÃO DE CENTRALIZAÇÃO DA CONCILIAÇÃO DE 1º GRAU', 'DICON', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIARQ', 'DIVISÃO DE ARQUIVO', 'CGAA', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-DF', 'SETOR DE BENS MOVEIS', 'DPAT AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JDF-ANG', 'JUIZ DIRETOR DO FORUM -ANG', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('JDF-VR', 'JUIZ DIRETOR DO FORUM - VR', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TRT-SL', 'SETORES VIRTUAIS SANTA LUZIA', 'SET AGORA', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SAM-GAB', 'GABINETE SECRETARIA DE ADMINISTRAÇÃO ATIVOS MÓVEIS', 'SAM', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CPL', 'COMISSAO PERMANENTE DE LICITACAO E PREGOEIROS', 'SCO', 'COMISSAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('LIC TRANS', 'SEP LICENCA TRANSITO', 'SEP', 'SEM SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DESCO', 'DIVISÃO DE ESTRUTURAÇÃO DO CONHECIMENTO', 'CORC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETGEM', 'SETOR DE GESTÃO DE MEMORIAL', 'SEGED', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIBI', 'DIVISÃO DE GESTÃO DE ACERVOS BIBLIOGRÁFICOS', 'SGC', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDID', 'SEÇÃO DE ANÁLISE DE DIREITOS E DEVERES', 'DIAP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETARQ', 'SETOR DE ARQUIVO DA SEC RECURSOS HUMANOS', 'SEMOP', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESCO', 'SEÇÃO DE ESTRUTURAÇÃO DO CONHECIMENTO', 'DORC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETGEC', 'SETOR DE GESTÃO DO CONTEÚDO', 'SESCO', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETRUS', 'SETOR DE RELACIONAMENTO COM USUÁRIO INT. E EXT.', 'SESCO', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICMA', 'DIVISÃO DE CONTROLE DE MANDADOS', 'CMAD', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('FC-VAGAS-1', 'FC A DISTRIBUIR - VARA A INSTALAR', 'SGP', 'OUTROS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDOR', 'DIVISÃO DE  DOCUMENTO DE REFERÊNCIA', 'CCOT', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECRAP', 'SEÇÃO PROCEDIMENTOS APURATÓRIOS DE PENALIDADES', 'DIFEC', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CINF', 'COORDENADORIA DE INFRAESTRUTURA', 'SLG', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDIF-NT', 'DIVISÃO DE PROTOC. E DIST. DE FEITOS - NITERÓI', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIDIF-SG', 'DIVISÃO DE PROTOC. E DIST. DE FEITOS - S.GONÇALO', 'CODI', 'DIVISAO PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAN-NI', 'DIVISÃO DE DISTRIBUIÇÃO DE MANDADOS - NOVA IGUAÇU', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIMAN-SG', 'DIVISÃO DE DISTRIBUIÇÃO DE MANDADOS - SÃO GONÇALO', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIVAP-CG', 'DIVISÃO DE APOIO AS VARAS DO TRABALHO-CAMPOS', 'CODI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEFEC', 'SEÇÃO DE FISCALIZAÇÃO DE EXECUÇÃO DE CONTRATOS', 'DICO', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEFOA', 'SEÇÃO DE FORMALIZAÇÃO DE AJUSTES', 'DICO', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICAJ', 'DIVISÃO DE ARRECADAÇÃO JUDICIAL', 'COEX', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-MAC', 'SECAO DE APOIO AS VARAS DO TRABALHO- MACAE', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAPO-NF', 'SECAO DE APOIO AS VARAS DO TRABALHO-N.FRIBURGO', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDIM-NI', 'SEÇÃO DE DISTRIBUIÇÃO DE MANDADOS - NOVA IGUAÇU', 'DCOI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETGRA', 'SETOR DE GRÁFICA', 'SEGEM', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CEATUS-2', 'CENTRAL DE ATENDIMENTO AO USUÁRIO - SEDE', 'SJU-2', 'CENTRAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CFEI-2', 'COORDENADORIA DE FEITOS DE 2ª INSTANCIA', 'SJU-2', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECEXP-L/G', 'SEÇÃO DE EXPEDIÇÃO - LAVRADIO/GOMES FREIRE', 'DMANP-L/G', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SPROJ', 'SEÇÃO DE PROJETOS', 'DIOB', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEOFI', 'SEÇÃO DE OFICINA DE VEÍCULOS', 'DIOP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CPRE', 'COORDENADORIA DE GESTAO DE PRECATORIOS', 'SJU-2', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPRC', 'SECAO DE PRECATORIOS', 'DPRE', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEJUD', 'SECAO DE APOIO JUDICIARIO', 'DSEP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEMAI', 'SEÇÃO DE MANUTENÇÃO DO INTERIOR', 'DMAN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DICOP', 'DIVISÃO DE CONTABILIDADE PÚBLICA', 'CCON', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SJU-2-GAB', 'GABINETE DA SECRETARIA JUDICIÁRIA DE 2ª INSTÂNCIA', 'SJU-2', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAEI', 'SEÇÃO DE APOIO EXTERNO E INSTITUCIONAL', 'SPR', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEAOC', 'SEÇÃO DE APOIO OPERACIONAL E CERIMONIAL', 'SPR', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('FC-VAGAS-2', 'FC A DISTRIBUIR - LEI 11877/08 / POSTO AVANÇADO', 'SPR-ADIDAS', 'OUTROS');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST1', 'SECRETARIA DA 1A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('ST10', 'SECRETARIA DA 10A TURMA', 'PR', 'TURMA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDI-I', 'SUBSEÇÃO ESPECIALIZADA DISSIDIOS INDIVIDUAIS I', 'SEDI', 'TRIBUNAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CPOR', 'COORDENADORIA DE PLANEJAMENTO E ORÇAMENTO', 'SOF', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECOG', 'SEÇÃO DE CONTABILIDADE GERENCIAL', 'DCON', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SST', 'SECRETARIA DE SOLUÇÕES EM TECNOLOGIA DA INFORMAÇÃO', 'DG', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('TP', 'TRIBUNAL PLENO', null, 'TRIBUNAL');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-ASAB', 'DESEMB ALEXANDRE DE SOUZA AGRA BELMONTE', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SETGER', 'SETOR DE GERENCIAMENTO BOLETIM INT. DIARIO ELT. JT', 'AIC', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-AR', 'POSTO AVANÇADO - PARATY', '1VTANG', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-PAR', 'POSTO AVANÇADO - PARATY', '1VTANG', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-BP', 'POSTO AVANÇADO JUST TRAB  DE VALENÇA - VT-BP', '1VTBP', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-MLP', 'DESEMB MIRIAN LIPPI PACHECO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('AS-VAC', 'DESEMB VALMIR DE ARAUJO CARVALHO', 'TP', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDACCD', 'GAB DES. ANTONIO CESAR COUTINHO DAIHA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDASAB', 'GAB DES. ALEXANDRE DE SOUZA AGRA BELMONTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTNI', '1a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('1VTQDS', '1a VT DE QUEIMADOS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SASRM', 'SEÇÃO DE ADM DE SISTEMAS DE RECURSOS MATERIAIS', 'DAST', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESAG', 'SEÇÃO DE SISTEMAS DE APOIO A GESTÃO', 'DGSP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESIN', 'SEÇÃO DE SISTEMAS INSTITUCIONAIS', 'DGSP', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DSEN', 'DIVISAO DE DESENVOLVIMENTO DE SISTEMAS', 'STI', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDCRB', 'GAB DES. CARINA RODRIGUES BICALHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDCRVMB', 'GAB DES.  CLAUDIA REGINA VIANNA MARQUES BARROZO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJAP', 'GAB DES. JOSE ANTONIO PITON', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('20VTRJ', '20a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('24VTRJ', '24a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('PAV-CF', 'POSTO AVANÇADO JUST TRAB RIO DAS OSTRAS VT-CF', '2VTCF', 'POSTO AVANCADO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTMA', '2a VT DE MACAE', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('2VTNI', '2a VT DE NOVA IGUAÇU', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEDAD', 'SEÇÃO DE BANCO DE DADOS', 'DSEN', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SECES', 'SEÇÃO DE CONTROLE EQUIPAMENTOS E SUPRIMENTOS', 'DSMI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SESSO', 'SEÇÃO DE SUPORTE A SOFTWARE E SIST OPERACIONAIS', 'DSMI', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('STI-GAB', 'GABINETE DA SECRETARIA DE TECNOLOGIA DA INFORMAÇÃO', 'STI', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DGCA-GAB', 'GABINETE DA DIRETORIA GERAL DE COOR ADMINISTRATIVA', 'DGCA', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEREP', 'SEÇÃO DE REPROGRAFIA', 'DMAT', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDJLCX', 'GAB DES. JOSE LUIS CAMPOS XAVIER', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMBVP', 'GAB DES.  MONICA BATISTA VIEIRA PUGLIA', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMLP', 'GAB DES. MIRIAN LIPPI PACHECO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMOC', 'GAB DES. MARCOS DE OLIVEIRA CAVALCANTE', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('3VTDC', '3a VT DE DUQUE DE CAXIAS', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DEMOV-DIS', 'SETOR DE BENS MOVEIS', 'SEMOV', 'AGORA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CLASS DISP', 'CLASSISTAS EM DISPONIBILIDADE', 'SRH', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DIAB', 'DIVISÃO DE ASSISTENCIA E BENEFÍCIOS', 'SRH', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SERAP', 'SEÇÃO CONTROLE E REGIST APOSENTADORIAS E PENSÕES', 'DLEG', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GRACO', 'GRUPO DE APOIO CORREICIONAL ÀS VARAS DO TRABALHO', 'DGCJ', 'SETOR');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDMSMP', 'GAB DES. MARIO SERGIO MEDEIROS PINHEIRO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDPMMS', 'GAB DES. PAULO MARCELO DE MIRANDA SERRANO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GDRLM', 'GAB DES. ROGERIO LUCAS MARTINS', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('50VTRJ', '50a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('58VTRJ', '58a VT DO RIO DE JANEIRO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('5VTSG', '5a VT DE SÃO GONÇALO', 'CR', 'VARA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('DCAD', 'DIVISAO DE CADASTRAMENTO PROCESSUAL', 'SJU', 'DIVISAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPEG-RSUL', 'SECAO DE PROTOCOLO GERAL - POSTO RIO SUL', 'DCAD', 'SETOR PROTOCOLO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('EJ1', 'ESCOLA JUDICIAL', 'PR', 'SECRETARIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('SEPCO', 'SEÇÃO DE PLANEJAMENTO E CONTRATAÇÃO', 'DIAD', 'SECAO');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('CCAP', 'COORDENADORIA DE CAPACITAÇÃO', 'ESACS RJ', 'COORDENADORIA');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-CAAD', 'GAB JUIZ CARLOS ALBERTO ARAUJO DRUMMOND', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-EMCT', 'GAB JUIZA EDITH MARIA CORREA TOURINHO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-EXTINTO', 'GABINETE DE JUIZ EXTINTO', 'TP', 'GABINETE');
insert into ADM_SETOR (set_sigla, set_nome, set_pai, set_tipo)
values ('GJ-JFGF', 'GAB JUIZ JORGE FERNANDO G DA FONTE', 'TP', 'GABINETE');

insert into ADM_FUNCIONARIO (fun_codigo, fun_nome, fun_cpf, fun_email, fun_telefone, fun_celular, fun_set_sigla, fun_car_seq, fun_data_admissao, fun_data_saida, fun_ativo)
values (93203, 'HENRIQUE FIGUEIREDO DE SOUZA', 63266661630, 'henrique.souza@com.br', '(21)3174-1958', '(11)95267-5198', 'DIREM', 15426, to_date('17-03-2014', 'dd-mm-yyyy'), null, 'S');

insert into ADM_FUNCIONARIO_PERFIL (usp_prf_seq, usp_fun_codigo)
values (2, 93203);

insert into ADM_CARGO_FUNCIONARIO (cfn_data_exercicio, cfn_fun_codigo, cfn_car_seq, cfn_data_desligamento, cfn_data_posse, cfn_situacao, cfn_presidente, cfn_diretor_geral, cfn_responsavel_orcamento, cfn_chefe_sepo)
values (to_date('17-03-2014', 'dd-mm-yyyy'), 93203, 15426, null, to_date('17-03-2014', 'dd-mm-yyyy'), 'E', 'N', 'N', 'N', 'N');
