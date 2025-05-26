ALTER TABLE estoque RENAME TO produto_estoque;

ALTER TABLE produto_estoque
ADD COLUMN Estoque_Id INT;

CREATE TABLE estoque (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255)
);

ALTER TABLE produto_estoque
ADD CONSTRAINT fk_estoque
FOREIGN KEY (Estoque_Id) REFERENCES estoque(id);


ALTER TABLE produto_estoque
ALTER COLUMN Data_Ultima_Atualizacao TYPE TIMESTAMP;

