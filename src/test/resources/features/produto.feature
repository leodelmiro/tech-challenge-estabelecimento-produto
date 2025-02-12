# language: pt
Funcionalidade: Produto API

  Cenário: Cadastro de um novo produto
    Dado que eu tenho os dados de um novo produto
    Quando eu envio uma requisição para criar produto
    Então o produto deve ser cadastrado com sucesso status 201

  Cenário: Busca de um produto válido
    Dado que eu busco um produto valido
    Quando eu envio uma requisição para buscar produto com Id existente
    Então o produto deve ser retornado com sucesso status 200

  Cenário: Busca de um produto inválido
    Dado que eu busco um produto inválido
    Quando eu envio uma requisição para buscar produto com Id não existente
    Então o produto nao deve ser retornado com status 404

  Cenário: Listagem de lanches
    Dado que eu busco os lanches
    Quando eu envio uma requisição para listar lanches
    Então uma listagem de lanches deve ser retornado com sucesso status 200

  Cenário: Listagem de acompanhamentos
    Dado que eu busco os acompanhamentos
    Quando eu envio uma requisição para listar acompanhamentos
    Então uma listagem de acompanhamentos deve ser retornado com sucesso status 200

  Cenário: Listagem de bebidas
    Dado que eu busco as bebidas
    Quando eu envio uma requisição para listar bebidas
    Então uma listagem de bebidas deve ser retornado com sucesso status 200

  Cenário: Listagem de sobremesas
    Dado que eu busco as sobremesas
    Quando eu envio uma requisição para listar sobremesas
    Então uma listagem de sobremesas deve ser retornado com sucesso status 200

  Cenário: Edição de um produto
    Dado que eu edito um produto existente
    Quando eu envio uma requisição editar produto
    Então o produto deve ser editado com sucesso status 200

  Cenário: Remoção de um produto
    Dado que eu removo um produto existente
    Quando eu envio uma requisição deletar produto
    Então o produto deve ser removido com sucesso status 204