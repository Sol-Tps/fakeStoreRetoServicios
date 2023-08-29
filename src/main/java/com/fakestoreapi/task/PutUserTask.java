package com.fakestoreapi.task;

import com.fakestoreapi.models.UserModel;
import com.fakestoreapi.questions.build.BuildDataUser;
import com.fakestoreapi.utils.LeerExcel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    LeerExcel leerExcel = new LeerExcel();
    String [] informacion =leerExcel.obtenerDatosExcel();

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userInfo = actor.asksFor(BuildDataUser.was()); //LLama la construccion de la data con el modelo correspondiente

        actor.attemptsTo(
                Put.to(informacion[0].toString()+"/"+informacion[7].toString())
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)//tipo de formato a utilizar
                                        .body(userInfo) // es un objeto
                        )
        );

    }
    public static PutUserTask on(){
        return instrumented(PutUserTask.class);
    } //metodo de interaccion con la task

}
