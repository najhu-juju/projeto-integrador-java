CREATE TABLE produto (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    nome         VARCHAR(100) NOT NULL,
    preco        DECIMAL(10,2) NOT NULL,
    quantidade   INTEGER NOT NULL,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(IDcategoria)
);