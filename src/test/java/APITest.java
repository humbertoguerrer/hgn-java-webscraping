import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class APITest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Test
    public void returnAllNews() {
        RestAssured.given()
                .when()
                .get("/news")
                .then()
                .statusCode(200);
    }

    @Test
    public void addNews() {
        RestAssured.given()
                .body("https://www.infomoney.com.br/mercados/brf-disputada-confira-os-cenarios-caso-a-marfrig-queira-comprar-100-da-companhia-e-as-dificuldades-que-a-jbs-pode-impor/")
                .when()
                .post("/news")
                .then()
                .statusCode(201);
    }

    @Test
    public void returnNewsByWord() {
        RestAssured.given()
                .when()
                .get("/news/filter?keyword=fusão")
                .then()
                .statusCode(200);
    }

    @Test
    public void returnNewsById() {
        RestAssured.given()
                .when()
                .get("/news/1")
                .then()
                .statusCode(200);
    }
}
