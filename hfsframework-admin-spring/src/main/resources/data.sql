insert into ADM_PERFIL (prf_seq, prf_descricao, prf_geral, prf_administrador) values (1, 'Geral', 'S', 'N');
insert into ADM_PERFIL (prf_seq, prf_descricao, prf_geral, prf_administrador) values (2, 'Administrador', 'N', 'S');

INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (1,'admParametroCategoriaMB/listar','Categoria dos Parâmetros de Configuração');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (2,'admParametroCategoriaMB/editar','Editar Categoria dos Parâmetros de Configuração');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (3,'admParametroMB/listar','Parâmetros de Configuração');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (4,'admParametroMB/editar','Editar Parâmetros de Configuração');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (5,'admPerfilMB/listar','Administrar Perfil');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (6,'admPerfilMB/editar','Editar Administrar Perfil');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (7,'admPaginaMB/listar','Administrar Página');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (8,'admPaginaMB/editar','Editar Administrar Página');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (9,'admMenuMB/listar','Administrar Menu');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (10,'admMenuMB/editar','Editar Administrar Menu');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (11,'admUsuarioMB/listar','Administrar Usuário');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (12,'admUsuarioMB/editar','Editar Administrar Usuário');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (13,'vwAdmLogMB/listar','Visualizar os Logs de Auditoria');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (14,'visualizarArqLogServidorMB/listar','Visualizar Arquivo de Log do Servidor');
INSERT INTO adm_pagina (pag_seq,pag_url,pag_descricao) VALUES (15,'alterarSenhaMB','Alterar Senha');


INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (1,'Administrativo',NULL,NULL,1);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (2,'Categoria dos Parâmetros de Configuração',1,1,2);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (3,'Parâmetros de Configuração',1,3,3);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (4,'Administrar Perfil',1,5,4);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (5,'Administrar Página',1,7,5);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (6,'Administrar Menu',1,9,6);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (7,'Administrar Usuário',1,11,7);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (8,'Visualizar os Logs de Auditoria',1,13,8);
INSERT INTO adm_menu (mnu_seq,mnu_descricao,mnu_pai_seq,mnu_pag_seq,mnu_ordem) VALUES (9,'Visualizar Arquivo de Log do Servidor',1,14,9);



INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (15,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (6,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (8,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (9,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (12,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (11,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (14,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (10,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (7,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (13,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (2,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (3,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (1,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (4,2);
INSERT INTO adm_pagina_perfil (pgl_pag_seq,pgl_prf_seq) VALUES (5,2);


INSERT INTO adm_usuario (usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha,created_date,modified_date,created_by,modified_by) 
VALUES (1,'henrique.souza','HENRIQUE FIGUEIREDO DE SOUZA',2685748474,'riquefsouza@gmail.com','','d033e22ae348aeb5660fc2140aec35850c4da997',
'2017-07-17 00:00:00.000','2019-03-02 21:17:32.000',NULL,NULL);
INSERT INTO adm_usuario (usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha,created_date,modified_date,created_by,modified_by) 
VALUES (2,'henrique','HENRIQUE SPRING',2685748474,'hfs3000@hotmail.com','','$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy',
'2017-07-17 00:00:00.000','2019-03-02 21:17:32.000',NULL,NULL);
INSERT INTO adm_usuario (usu_seq,usu_login,usu_nome,usu_cpf,usu_email,usu_ldap_dn,usu_senha,created_date,modified_date,created_by,modified_by) 
VALUES (3,'rafael.remiro','Rafael Rene Leal Remiro',0,'rafael.remiro@gmail.com','','7ce0359f12857f2a90c7de465f40a95f01cb5da9',
'2019-03-17 08:58:58.357','2019-03-17 08:59:11.178','henrique.souza','henrique.souza');


INSERT INTO adm_usuario_ip (uip_usu_seq,uip_ip,uip_ativo) VALUES (1,'127.0.0.1','S');
INSERT INTO adm_usuario_ip (uip_usu_seq,uip_ip,uip_ativo) VALUES (2,'127.0.0.1','N');
INSERT INTO adm_usuario_ip (uip_usu_seq,uip_ip,uip_ativo) VALUES (2,'0:0:0:0:0:0:0:1','S');

INSERT INTO adm_usuario_perfil (usp_prf_seq,usp_usu_seq) VALUES (2,1);
INSERT INTO adm_usuario_perfil (usp_prf_seq,usp_usu_seq) VALUES (2,2);


INSERT INTO adm_parametro_categoria (pmc_seq,pmc_descricao,pmc_ordem) VALUES (1,'Parâmetros do Tribunal',1);
INSERT INTO adm_parametro_categoria (pmc_seq,pmc_descricao,pmc_ordem) VALUES (2,'Parâmetros de Login',2);
INSERT INTO adm_parametro_categoria (pmc_seq,pmc_descricao,pmc_ordem) VALUES (3,'Parâmetros de E-mail',3);
INSERT INTO adm_parametro_categoria (pmc_seq,pmc_descricao,pmc_ordem) VALUES (4,'Parâmetros de Conexão de Rede',4);


INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (1,'Tribunal Regional do Trabalho da 1a. Região','Nome do tribunal onde o sistema está instalado.','NOME_TRIBUNAL',1);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (2,'TRT1','Sigla do tribunal onde o sistema está instalado.','SIGLA_TRIBUNAL',1);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (3,'080009','Código númérico de 6 dígitos que identifica o órgão no SIAFI.','CODIGO_UNIDADE_GESTORA',1);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (4,'102','Código númérico de 3 dígitos da UG no código de barras da GRU.','APELIDO_UNIDADE_GESTORA',1);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (5,'false','Bloquear o sistema para que os usuários, exceto do administador, não façam login','BLOQUEAR_LOGIN',2);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (6,'Produção','Define o ambiente onde o sistema está instalado. Este parâmetro pode ser preenchido com: desenvolvimento, homologação ou produção','AMBIENTE_SISTEMA',2);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (7,'NOME_USUARIO','Define o atributo usado para efetuar login no sistema. Este parâmetro pode ser preenchido com: NOME_USUARIO ou CPF','ATRIBUTO_LOGIN',2);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (9,'25','Porta do servidor SMTP para que o sistema envie e-mail.','SMTP_PORTA',3);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (10,NULL,'Usuário para login no servidor SMTP.','SMTP_USERNAME',3);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (11,NULL,'Senha para login no servidor SMTP.','SMTP_PASSWORD',3);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (14,'8080','Porta do Proxy.','PROXY_PORTA',4);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (12,'sistema@com.br','E-mail do sistema.','SMTP_EMAIL_FROM',3);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (13,'sistema.com.br','Servidor do Proxy.','PROXY_SERVIDOR',4);
INSERT INTO adm_parametro (par_seq,par_valor,par_descricao,par_codigo,par_pmc_seq) VALUES (8,'smtp.com.br','Servidor SMTP para que o sistema envie e-mail.','SMTP_SERVIDOR',3);



