package com.fakestoreapi.questions.response;

import com.fakestoreapi.models.responseDelete.UserModelDelete;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DeleteDataResponse implements Question<UserModelDelete> {
    @Override
    public UserModelDelete answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModelDelete.class);
    }

    public static DeleteDataResponse was(){
        return new DeleteDataResponse();
    }
}
