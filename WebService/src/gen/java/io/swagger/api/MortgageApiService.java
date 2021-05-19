package io.swagger.api;

import io.swagger.model.CalculatorInput;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public abstract class MortgageApiService {

    public abstract Response calculatePayments(CalculatorInput body, SecurityContext securityContext) throws NotFoundException;

}
