package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.response.DeleteDataResponse;
import com.fakestoreapi.task.DeleteUserTask;
import com.fakestoreapi.utils.LeerExcel;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteFakeStoreStepDef {
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

    @When("I consume the endpoint and I send the id")
    public void iConsumeTheEndpointAndISendTheId() {
        user.attemptsTo(
                DeleteUserTask.on()
        );
    }
    @Then("I can validate the phone")
    public void iCanValidateThePhone() {
        user.should(
                seeThat(
                        "The server response was",
                        res-> DeleteDataResponse.was().answeredBy(user).getPhone(),
                        equalTo(informacion[8].toString())
                )
        );
    }


}
