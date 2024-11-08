CREATE TABLE IF NOT EXISTS estoque  (
    ID SERIAL PRIMARY KEY,
    Produto_ID INTEGER NOT NULL,
    Quantidade_Disponivel INTEGER NOT NULL,
    Data_Ultima_Atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_produto
        FOREIGN KEY (Produto_ID) 
        REFERENCES produto(id)
);
