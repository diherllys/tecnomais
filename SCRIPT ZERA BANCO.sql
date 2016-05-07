EXEC sp_MSForEachTable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL'
EXEC sp_MSForEachTable 'DELETE FROM ?'
EXEC sp_MSForEachTable 'ALTER TABLE ? CHECK CONSTRAINT ALL'


DBCC CHECKIDENT ('blocoDeNotas', RESEED, 0);
DBCC CHECKIDENT ('tb_agenda', RESEED, 0);
DBCC CHECKIDENT ('tb_anotacoes', RESEED, 0);
DBCC CHECKIDENT ('tb_backup', RESEED, 0);
DBCC CHECKIDENT ('tb_caixas', RESEED, 0);
DBCC CHECKIDENT ('tb_chaves', RESEED, 0);
DBCC CHECKIDENT ('tb_classes', RESEED, 0);
DBCC CHECKIDENT ('tb_clientes', RESEED, 0);
DBCC CHECKIDENT ('tb_configTelaVendas', RESEED, 0);
DBCC CHECKIDENT ('tb_contas', RESEED, 0);

DBCC CHECKIDENT ('tb_entradas', RESEED, 0);
DBCC CHECKIDENT ('tb_filiais', RESEED, 0);
DBCC CHECKIDENT ('tb_formaPag', RESEED, 0);
DBCC CHECKIDENT ('tb_fornecedores', RESEED, 0);
DBCC CHECKIDENT ('tb_impressoras', RESEED, 0);
DBCC CHECKIDENT ('tb_licenca', RESEED, 0);
DBCC CHECKIDENT ('tb_logomarca', RESEED, 0);
DBCC CHECKIDENT ('tb_movimentacao', RESEED, 0);
DBCC CHECKIDENT ('tb_operacoes', RESEED, 0);
DBCC CHECKIDENT ('tb_operacoesDeSaida', RESEED, 0);
DBCC CHECKIDENT ('tb_permissoes', RESEED, 0);
DBCC CHECKIDENT ('tb_pontos', RESEED, 0);
DBCC CHECKIDENT ('tb_produtos', RESEED, 0);
DBCC CHECKIDENT ('tb_produtosEntrada', RESEED, 0);
DBCC CHECKIDENT ('tb_produtosVendidos', RESEED, 0);
DBCC CHECKIDENT ('tb_unidadeVenda', RESEED, 0);
DBCC CHECKIDENT ('tb_usuarios', RESEED, 0);
DBCC CHECKIDENT ('tb_vendas', RESEED, 0);

insert into tb_filiais (nome) values('Filial 1');
insert into tb_usuarios (usuario, nome_usuario, senha) values('admin', 'Administrador', 'masterkey');
insert into tb_permissoes (abrirGaveta, cadastro, cadastroFilial, cadastroUsuario, cancelarVendas, configurarImp, configurarLogo, configurarPerm, escritorio, idUsuario, movContRecbPagFlxCaixa, movimentacao) values(1,1,1,1,1,1,1,1,1,1,1,1);
insert into tb_clientes (nome) values('CLIENTE BALCAO');
insert into tb_configTelaVendas (IdComputador,limparTelaVendasAposFinalizar,mostraCaixa,mostraCliente
,mostraOperacao,mostraVendedor,nuncaImpPreVenda,sempreImpPreVenda,semprePergImpPreVenda,
passarMercadoriaDiretoComLeitor,permAlteraCaixa,permAlteraCliente,permAlteraOperacao,permAlteraVendedor
,permitirEstqNegativo, InVendCaixa, InVendCliente, InVendOperacao, InVendVendedor) values(1,1,1,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0);
insert into tb_impressoras (impressoraAtual) values('SemImpressora');
insert into tb_unidadeVenda (nome) values('UN');
insert into tb_classes (nome) values('OUTROS');
