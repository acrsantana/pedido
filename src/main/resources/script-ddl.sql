create table cliente
(
    codigo serial not null primary key,
    nome   varchar(80)
);

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

select *
from cliente;

create table produto
(
    codigo    serial not null primary key,
    descricao varchar(120),
    preco     decimal
);

insert into produto (descricao, preco)
values ('Macarrão a bolonheza', 100);
insert into produto (descricao, preco)
values ('Bife com fritas', 200);
insert into produto (descricao, preco)
values ('Coca-cola', 8);

select *
from produto;

create table pedido
(
    codigo      serial not null primary key,
    data        date,
    cliente_cod int,
    foreign key (cliente_cod) references cliente (codigo)
);

create table itens_pedido
(
    codigo      serial not null primary key,
    pedido_cod  int,
    produto_cod int,
    foreign key (pedido_cod) references pedido (codigo),
    foreign key (produto_cod) references produto (codigo)
);

insert into pedido (data, cliente_cod)
values ('2022-10-22', 4);

select *
from pedido;

insert into itens_pedido (pedido_cod, produto_cod)
values (2, 1);
insert into itens_pedido (pedido_cod, produto_cod)
values (2, 2);
insert into itens_pedido (pedido_cod, produto_cod)
values (2, 3);

select *
from itens_pedido;

select c.nome, p.data, pr.descricao, pr.preco
from pedido p,
     cliente c,
     itens_pedido ip,
     produto pr
where p.cliente_cod = c.codigo
  and ip.pedido_cod = p.codigo
  and ip.produto_cod = pr.codigo;
