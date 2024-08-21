@FeatureAll
Feature: Crear usuario PetStore

  @test1
  Scenario: Crear usuario
    #Given step de prueba "70395115"
    #And  step de prueba n2 7355
    When creo el usuario con username "jkbenites", firstname "Jean", lastname "Benites"
    Then el código de respuesta es 200
    And el type es "unknown"


    @consultamascota
    Scenario: consulta mascota
      When consulto la mascota de id 5
      Then el código de respuesta es 200
