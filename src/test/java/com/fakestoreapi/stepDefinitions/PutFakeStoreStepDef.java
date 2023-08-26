package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.response.PutDataResponse;
import com.fakestoreapi.task.PutUserTask;
import com.fakestoreapi.utils.LeerExcel;
import io.cucumber.java.Before;
import io.cucumber.java.ast.Cuando;
import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

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

    @Cuando("consumo la url y actualizo la informacion")
    public void consumoLaUrlYActualizoLaInformacion() {
        user.attemptsTo(
                PutUserTask.on()
        );
    }
    @Entonces("validamos la respuesta del servidor")
    public void validamosLaRespuestaDelServidor() {
        user.should(
                seeThat(
                        "La respuesta del servidor fue: ",
                        PutDataResponse.was(),
                        Matchers.equalTo(Integer.parseInt(informacion[6]))
                        //respuesta-> PutDataResponse.was().answeredBy(user).getPhone(), //almacena la respuesta res en esa variable, funcion flecha
                       // equalTo("1-570-236-7033")
                )
        );
    }

}
