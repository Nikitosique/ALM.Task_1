package io.swagger.api;

import io.swagger.api.factories.MortgageApiServiceFactory;
import io.swagger.model.CalculatorInput;
import io.swagger.model.MortgageCalculatedData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("/mortgage")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public class MortgageApi {

    private final MortgageApiService delegate;

    public MortgageApi(@Context ServletConfig servletContext) {
        MortgageApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("MortgageApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (MortgageApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = MortgageApiServiceFactory.getMortgageApi();
        }

        this.delegate = delegate;
    }

    @POST
    @Path("/calculation")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Getting mortgage data", description = "Calculating mortgage montlhy payment value and loan amortization data or returning validation messages if input data were invalid", tags = {"calculator"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mortgage data were successfully calculated", content = @Content(schema = @Schema(implementation = MortgageCalculatedData.class))),

            @ApiResponse(responseCode = "400", description = "Mortgage calculator input data are invalid", content = @Content(schema = @Schema(implementation = MortgageCalculatedData.class)))})
    public Response calculatePayments(@Parameter(in = ParameterIn.DEFAULT, description = "Input data for mortgage calculator", required = true) CalculatorInput body

            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.calculatePayments(body, securityContext);
    }

}
