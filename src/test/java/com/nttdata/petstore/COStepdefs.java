package com.nttdata.petstore;
import static org.hamcrest.CoreMatchers.equalTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class COStepdefs {

    COStep order;
    private Response response;
    @Before
    public void setUp() {
        order = new COStep();
    }
    @Given("la URl para la crear order {string}")
    public void laURlParaLaCrearOrderUrl(String url) {
        System.out.println("La URLL: " + url);
    }

    @When("se realiza la la solicitud Post con los siguientes datos  {int} , {int} , {int} ,{string},{string}, true")
    public void seRealizaLaLaSolicitudPostConLosSiguientesDatosTrue(int id, int petId, int quantity, String shipDate, String status) {
        order.crearorder(id , petId , quantity , shipDate , status);
    }

    @Then("la respuesta debe tener el codigo de estado {int}")
    public void laRespuestaDebeTenerElCodigoDeEstado(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
        System.out.println("Código esperado: " + statusCode);
    }

    @And("Status es de tipo {string}")
    public void statusEsDeTipo(String arg0) {
        restAssuredThat(response -> response.body("'status'", equalTo(arg0)));
        System.out.println("status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    @When("consulto la orden con id {int}")
    public void consultoLaOrdenConId(int idOrder) {
        order.consultarOrder(idOrder);
    }

    @And("el cuerpo de la respuesta debe contener la siguiente estructura:")
    public void elCuerpoDeLaRespuestaDebeContenerLaSiguienteEstructura(String expectedJson) {
        System.out.println("la estructura: "+expectedJson);
    }
}
