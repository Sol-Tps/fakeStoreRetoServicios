package com.fakestoreapi.questions.response;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PutDataResponse implements Question<Object> {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static PutDataResponse was(){
        return new PutDataResponse();
    }
}
