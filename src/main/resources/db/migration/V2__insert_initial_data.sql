insert into cliente (nome)
values ('Cezar Vilela');
insert into cliente (nome)
values ('Joice Camara');
insert into cliente (nome)
values ('Luna Carvalho');
insert into cliente (nome)
values ('Artur Ribeiro');
insert into cliente (nome)
values ('Carlos Castro');

insert into produto (descricao, preco)
values ('Macarrão a bolonheza', 100);
insert into produto (descricao, preco)
values ('Bife com fritas', 200);
insert into produto (descricao, preco)
values ('Coca-cola', 8);

insert into pedido (data, cliente_cod)
values ('2022-10-22', 4);

insert into itens_pedido (pedido_cod, produto_cod)
values (1, 1);
insert into itens_pedido (pedido_cod, produto_cod)
values (1, 2);
insert into itens_pedido (pedido_cod, produto_cod)
values (1, 3);
