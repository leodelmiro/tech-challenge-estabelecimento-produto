package bdd.stepdefinitions;

import bdd.config.RestApiApplicationIT;
import com.leodelmiro.produto.core.domain.Categoria;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static bdd.utils.ProdutoHelper.gerarCadastraProdutoRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

public class ProdutoStepDefinitions extends RestApiApplicationIT {
    private Response response;
    private String baseUrl = "http://localhost:8090/api/v1/produtos";

    @Dado("que eu tenho os dados de um novo produto")
    public void queEuTenhoOsDadosDeUmNovoProduto() {
    }

    @Quando("eu envio uma requisição para criar produto")
    public void euEnvioUmaRequisicaoPOST() {
        response = given()
                .contentType("application/json")
                .body(gerarCadastraProdutoRequest(null))
                .when()
                .post(baseUrl);
    }

    @Então("o produto deve ser cadastrado com sucesso status 201")
    public void produtoDeveSerCadastrado() {
        response.then().statusCode(201);
    }

    @Dado("que eu busco um produto valido")
    public void queEuBuscoUmProdutoValido() {
    }

    @Quando("eu envio uma requisição para buscar produto com Id existente")
    public void euEnvioUmaRequisicaoGETComIdExistente() {
        response = when().get(baseUrl + "/1");
    }

    @Então("o produto deve ser retornado com sucesso status 200")
    public void produtoDeveSerRetornado() {
        response.then().statusCode(200).body("id", notNullValue());
    }

    @Dado("que eu busco um produto inválido")
    public void queEuBuscoUmProdutoInvalido() {
    }

    @Quando("eu envio uma requisição para buscar produto com Id não existente")
    public void euEnvioUmaRequisicaoGETComIdNaoExistente() {
        response = when().get(baseUrl + "/9999");
    }

    @Então("o produto nao deve ser retornado com status 404")
    public void produtoNaoEncontrado() {
        response.then().statusCode(404);
    }

    @Dado("que eu busco os lanches")
    public void queEuBuscoOsLanches() {
        given()
                .contentType("application/json")
                .body(gerarCadastraProdutoRequest(Categoria.LANCHE))
                .when()
                .post(baseUrl);
    }

    @Quando("eu envio uma requisição para listar lanches")
    public void euEnvioUmaRequisicaoGETLanches() {
        response = when().get(baseUrl + "/lanches");
    }

    @Então("uma listagem de lanches deve ser retornado com sucesso status 200")
    public void listagemDeLanchesDeveSerRetornada() {
        response.then().statusCode(200).body("size()", greaterThan(0));
    }

    @Dado("que eu busco os acompanhamentos")
    public void queEuBuscoOsAcompanhamentos() {
        given()
                .contentType("application/json")
                .body(gerarCadastraProdutoRequest(Categoria.ACOMPANHAMENTO))
                .when()
                .post(baseUrl);
    }

    @Quando("eu envio uma requisição para listar acompanhamentos")
    public void euEnvioUmaRequisicaoGETAcompanhamentos() {
        response = when().get(baseUrl + "/acompanhamentos");
    }

    @Então("uma listagem de acompanhamentos deve ser retornado com sucesso status 200")
    public void listagemDeAcompanhamentosDeveSerRetornada() {
        response.then().statusCode(200).body("size()", greaterThan(0));
    }

    @Dado("que eu busco as bebidas")
    public void queEuBuscoAsBebidas() {
        given()
                .contentType("application/json")
                .body(gerarCadastraProdutoRequest(Categoria.BEBIDA))
                .when()
                .post(baseUrl);
    }

    @Quando("eu envio uma requisição para listar bebidas")
    public void euEnvioUmaRequisicaoGETBebidas() {
        response = when().get(baseUrl + "/bebidas");
    }

    @Então("uma listagem de bebidas deve ser retornado com sucesso status 200")
    public void listagemDeBebidasDeveSerRetornada() {
        response.then().statusCode(200).body("size()", greaterThan(0));
    }

    @Dado("que eu busco as sobremesas")
    public void queEuBuscoAsSobremesas() {
        given()
                .contentType("application/json")
                .body(gerarCadastraProdutoRequest(Categoria.SOBREMESA))
                .when()
                .post(baseUrl);
    }

    @Quando("eu envio uma requisição para listar sobremesas")
    public void euEnvioUmaRequisicaoGETSobremesas() {
        response = when().get(baseUrl + "/sobremesas");
    }

    @Então("uma listagem de sobremesas deve ser retornado com sucesso status 200")
    public void listagemDeSobremesasDeveSerRetornada() {
        response.then().statusCode(200).body("size()", greaterThan(0));
    }

    @Dado("que eu edito um produto existente")
    public void queEuEditoUmProdutoExistente() {
    }

    @Quando("eu envio uma requisição editar produto")
    public void euEnvioUmaRequisicaoPUT() {
        response = given()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"nome\": \"Produto Exemplo Editado\",\n" +
                        "\t\"categoria\": \"SOBREMESA\",\n" +
                        "\t\"preco\": 4.99,\n" +
                        "\t\"tempoDePreparoEmSegundos\": 10,\n" +
                        "\t\"descricao\": \"Este é uma Sobremesa de exemplo.\",\n" +
                        "\t\"imagens\": [\n" +
                        "\t\t{\n" +
                        "\t\t\t\"nome\": \"Imagem 1\",\n" +
                        "\t\t\t\"url\": \"http://example.com/imagem1.jpg\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"nome\": \"Imagem 2\",\n" +
                        "\t\t\t\"url\": \"http://example.com/imagem2.jpg\"\n" +
                        "\t\t}\n" +
                        "\t]\n" +
                        "}")
                .when()
                .put(baseUrl + "/1");
    }

    @Então("o produto deve ser editado com sucesso status 200")
    public void produtoDeveSerEditado() {
        response.then().statusCode(200);
    }

    @Dado("que eu removo um produto existente")
    public void queEuRemovoUmProdutoExistente() {
    }

    @Quando("eu envio uma requisição deletar produto")
    public void euEnvioUmaRequisicaoDELETE() {
        response = when().delete(baseUrl + "/1");
    }

    @Então("o produto deve ser removido com sucesso status 204")
    public void produtoDeveSerRemovido() {
        response.then().statusCode(204);
    }
}
