create table cliente
(
    codigo serial not null primary key,
    nome   varchar(80)
);

create table produto
(
    codigo    serial not null primary key,
    descricao varchar(120),
    preco     decimal
);

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
