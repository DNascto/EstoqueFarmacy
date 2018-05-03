show databases;

use farmacia1;

show tables;

select * from tbusuario;
select * from tbproduto;
select * from tbfornecedor;
select * from tbProduto where nome = 'Dipirona';
select * from tbProduto where nome LIKE 'Dipirona';
select * from tbEstoque;
select * from tbProduto where nome = 'Dipirona';
select * from tbEstoque inner join tbproduto on tbestoque.id_Produto = tbproduto.id_produto;
select * from tbEstoque inner join tbproduto on tbestoque.id_Produto = tbproduto.id_produto where nome = 'dipirona';
select nome, count(*) from tbEstoque inner join tbproduto on tbestoque.id_Produto = tbproduto.id_produto group by nome;

select nome, count(*) from tbproduto GROUP BY nome;

select distinct nome from tbproduto;

describe tbestoque;
describe tbusuario;
describe tbproduto;
describe tbfornecedor;


insert into tbusuario (nome, fone, login, senha, endereco) values ('Gabriel', '96623080', 'admin', 'admin', 'Rio Grande do Sul, 42');

select * from tbusuario;

delete from tbestoque where id_produto = 1;


select * from tbproduto where id_produto = 1;