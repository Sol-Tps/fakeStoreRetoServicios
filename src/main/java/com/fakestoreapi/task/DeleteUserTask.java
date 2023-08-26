package com.fakestoreapi.task;

import com.fakestoreapi.utils.LeerExcel;
import io.cucumber.java.hu.De;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {

    LeerExcel leerExcel = new LeerExcel();
    String [] informacion =leerExcel.obtenerDatosExcel();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(informacion[0]+"/"+informacion[8])
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                        )
        );
    }

    public static DeleteUserTask on(){
     return instrumented(DeleteUserTask.class);
    }
}
