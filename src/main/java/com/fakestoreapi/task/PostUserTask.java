package com.fakestoreapi.task;

import com.fakestoreapi.models.UserModel;
import com.fakestoreapi.questions.build.BuildDataUser;
import com.fakestoreapi.utils.LeerExcel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {

    LeerExcel leerExcel = new LeerExcel();
    String [] informacion =leerExcel.obtenerDatosExcel();

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userInfo = actor.asksFor(BuildDataUser.was());
        actor.attemptsTo(
                Post.to(informacion[0]).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }

    public static PostUserTask on(){
        return instrumented(PostUserTask.class);
    }

}
