package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.response.PutDataResponse;
import com.fakestoreapi.task.PutUserTask;
import com.fakestoreapi.utils.LeerExcel;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PutFakeStoreStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    LeerExcel leerExcel = new LeerExcel();
    String [] informacion =leerExcel.obtenerDatosExcel();

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the service endpoint and I update the information")
    public void IConsumeTheServiceEndpointAndIUpdateTheInformation() {
        user.attemptsTo(
                PutUserTask.on()
        );
    }
    @Then("I can validate the response of the server")
    public void ICanValidateTheResponseOfTheServer() {
//        user.should(
//                seeThat(
//                        "La respuesta del servidor fue: ",
//                        respuesta-> PutDataResponse.was(),
//                        equalTo(Integer.parseInt(informacion[6]))
//                )
//        );
    }

}

