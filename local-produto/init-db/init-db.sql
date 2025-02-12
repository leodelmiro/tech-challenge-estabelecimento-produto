CREATE TABLE IF NOT EXISTS tb_produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    categoria INTEGER NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    descricao TEXT,
    tempo_de_preparo_em_segundos BIGINT NOT NULL,
    criado_em TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS tb_imagem (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    produto_id INTEGER NOT NULL,
    url TEXT NOT NULL,
    criado_em TIMESTAMP DEFAULT current_timestamp,
    FOREIGN KEY (produto_id) REFERENCES tb_produto(id) ON DELETE CASCADE
);