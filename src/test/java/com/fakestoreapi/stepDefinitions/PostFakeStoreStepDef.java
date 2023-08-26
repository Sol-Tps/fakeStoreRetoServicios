package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.response.ServerResponse;
import com.fakestoreapi.task.PostUserTask;
import com.fakestoreapi.utils.LeerExcel;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostFakeStoreStepDef {

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
    @Cuando("consumo la url del servicio")
    public void consumoLaUrlDelServicio() {
        user.attemptsTo(
                PostUserTask.on()
        );
    }
    @Entonces("validamos la respuesta del servicio")
    public void validamosLaRespuestaDelServicio() {

        user.should(
                seeThat(
                        "El codigo de respuesta fue: ",
                        ServerResponse.was(),
                        equalTo(Integer.parseInt(informacion[6]))
                )
        );
    }

}
