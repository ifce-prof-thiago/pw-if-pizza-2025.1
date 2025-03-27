CREATE TABLE Ingrediente
(
    ingrediente_id  char(36) PRIMARY KEY,
    nome            varchar(100) NOT NULL UNIQUE,
    disponibilizado bool,
    preco_p         decimal(5, 2),
    preco_m         decimal(5, 2),
    preco_g         decimal(5, 2)
);

