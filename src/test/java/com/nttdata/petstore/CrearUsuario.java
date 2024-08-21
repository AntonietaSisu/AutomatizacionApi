package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearUsuario {

    private static String CREATE_USER = "https://petstore.swagger.io/v2/user";

    public static void consultamascota(int petID) {
        SerenityRest.given()
                .contentType("application/json")
                .baseUri("https://petstore.swagger.io/v2/")
                .log().all()
                .get("pet/"+petID)
                .then().log().all()
        ;
    }

    @Step("Crear usuario {0} en PetStore")
    public void crearUsuario(String username, String firstName, String lastName){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \""+username+"\",\n" +
                        "  \"firstName\": \""+firstName+"\",\n" +
                        "  \"lastName\": \""+lastName+"\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .log().all()
                .post(CREATE_USER)
                .then().log().all()
        ;

    }

    public void metododeprueba(int anio) {
        System.out.println("CODIGO LEIDO desde Step: " + anio);
    }
}
