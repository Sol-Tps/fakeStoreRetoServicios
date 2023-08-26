package com.fakestoreapi.questions.response;

import com.fakestoreapi.models.UserModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PutDataResponse implements Question<UserModel> {
    @Override
    public UserModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModel.class);
    }

    public static PutDataResponse was(){
        return new PutDataResponse();
    }
}
