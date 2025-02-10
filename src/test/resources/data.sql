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

INSERT INTO tb_produto (nome, categoria, preco, descricao, tempo_de_preparo_em_segundos)
VALUES ('Lanche', 1, 25.00, 'Lanche com Bacon.', 900);

INSERT INTO tb_imagem (nome, produto_id, url)
VALUES ('lanche.jpg', 1, 'https://example.com/images/lanche.jpg');

INSERT INTO tb_produto (nome, categoria, preco, descricao, tempo_de_preparo_em_segundos)
VALUES ('Acompanhamento', 2, 1.00, 'Acompanhamento pra Lanche com Bacon.', 60);

INSERT INTO tb_imagem (nome, produto_id, url)
VALUES ('acompanhamento.jpg', 2, 'https://example.com/images/acompanhamento.jpg');

INSERT INTO tb_produto (nome, categoria, preco, descricao, tempo_de_preparo_em_segundos)
VALUES ('Suco', 3, 10.00, 'Suco de Laranja.', 600);

INSERT INTO tb_imagem (nome, produto_id, url)
VALUES ('suco.jpg', 3, 'https://example.com/images/suco.jpg');

INSERT INTO tb_produto (nome, categoria, preco, descricao, tempo_de_preparo_em_segundos)
VALUES ('Pudim', 4, 45.90, 'Pudim saboroso', 900);

INSERT INTO tb_imagem (nome, produto_id, url)
VALUES ('pudim.jpg', 4, 'https://example.com/images/pudim.jpg');
