package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;

public class COStep {

    private static String URL = "https://petstore.swagger.io/v2/store/order";
    public void crearorder(int id, int petId, int quantity, String shipDate, String status) {
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\":\""+ id +"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \""+true+"\"\n" +

                        "}")
                .log().all()
                .post(URL)
                .then().log().all()
        ;
    }

    public void consultarOrder(int idOrder) {
        SerenityRest.given()
                .contentType("application/json")
                .log().all()
                .get(URL+"/"+idOrder)
                .then().log().all()
        ;
    }
}
