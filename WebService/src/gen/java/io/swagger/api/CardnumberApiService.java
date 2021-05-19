package io.swagger.api;

import io.swagger.model.CardInput;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public abstract class CardnumberApiService {

    public abstract Response validateCard(CardInput body, SecurityContext securityContext) throws NotFoundException;

}
