package com.nttdata.petstore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearUsuarioStepsDefs {

    @Steps
    CrearUsuario crearUsuario;

    @When("creo el usuario con username {string}, firstname {string}, lastname {string}")
    public void crearUsuario(String username, String firstName, String lastName){
        crearUsuario.crearUsuario(username, firstName, lastName);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @And("el type es {string}")
    public void elTypeEs(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
        System.out.println("Type: " + SerenityRest.lastResponse().body().path("type").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    @Given("step de prueba {string}")
    public void stepDePrueba(String arg0) {
        System.out.println("codigo leido: "+arg0);
    }
    @Given("step de prueba n2 {int}")
    public void stepDePrueban2(int anioactual) {

        crearUsuario.metododeprueba(anioactual);
    }

    @When("consulto la mascota de id {int}")
    public void consultoLaMascotaDeId(int arg0) {
        CrearUsuario.consultamascota(arg0);
    }


}
