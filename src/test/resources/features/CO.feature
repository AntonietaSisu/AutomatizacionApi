@Feature
  Feature: Crear order Petstore

    @escenario1
    Scenario Outline: Crear order
      Given la URl para la crear order <url>
      When se realiza la la solicitud Post con los siguientes datos  <id> , <petId> , <quantity> ,<shipDate>,<status>, true
      Then la respuesta debe tener el codigo de estado <statusCode>
      And Status es de tipo "approved"
      Examples:
        | url                                          | id | petId | quantity | shipDate              | status   | statusCode |
        | "https://petstore.swagger.io/v2/store/order" | 8  | 10    | 2        | "2024-08-01T08:30:00" | "approved" | 200      |
        | "https://petstore.swagger.io/v2/store/order" | 11 | 8     | 3        | "2024-08-15T14:45:00" | "approved" | 200      |

    @escenario2
    Scenario Outline: Consultar order
      When consulto la orden con id <orderId>
      Then la respuesta debe tener el codigo de estado <statusCode>
      And Status es de tipo "<expectedStatus>"

      Examples:
        | orderId | statusCode | expectedStatus |
        | 8       | 200        | approved       |
        | 11      | 200        | approved       |

