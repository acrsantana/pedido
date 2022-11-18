create table usuario
(
    id           serial not null primary key,
    nome         varchar(100),
    email        varchar(100),
    senha        varchar(255),
    data_criacao timestamp
);
