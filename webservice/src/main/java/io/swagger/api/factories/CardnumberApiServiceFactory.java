package io.swagger.api.factories;

import io.swagger.api.CardnumberApiService;
import io.swagger.api.impl.CardnumberApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public class CardnumberApiServiceFactory {

    private final static CardnumberApiService service = new CardnumberApiServiceImpl();

    public static CardnumberApiService getCardnumberApi() {
        return service;
    }

}
