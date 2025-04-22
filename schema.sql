CREATE TABLE Ingrediente
(
    ingrediente_id  char(36) PRIMARY KEY,
    nome            varchar(100) NOT NULL UNIQUE,
    disponibilizado bool,
    preco_p         decimal(5, 2),
    preco_m         decimal(5, 2),
    preco_g         decimal(5, 2)
);

create table Pizza
(
    pizza_id        char(36) PRIMARY KEY,
    nome            varchar(100) NOT NULL,
    disponibilizado bool,
    tamanho         char(1),
    preco           decimal(5, 2),

    CONSTRAINT uk_no_ta UNIQUE (nome, tamanho),
    CONSTRAINT ck_ta CHECK ( tamanho IN ('P', 'M', 'G') )
);

