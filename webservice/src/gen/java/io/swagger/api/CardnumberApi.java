package io.swagger.api;

import io.swagger.api.factories.CardnumberApiServiceFactory;
import io.swagger.model.CardInput;
import io.swagger.model.CardValidationData;
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

@Path("/cardnumber")

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public class CardnumberApi {

    private final CardnumberApiService delegate;

    public CardnumberApi(@Context ServletConfig servletContext) {
        CardnumberApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("CardnumberApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (CardnumberApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = CardnumberApiServiceFactory.getCardnumberApi();
        }

        this.delegate = delegate;
    }

    @POST
    @Path("/validation")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Getting credit card info", description = "Resolving credit card's payment system or returning validation messages if card number is invalid", tags = {"card"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment system was succesfully resolved", content = @Content(schema = @Schema(implementation = CardValidationData.class))),

            @ApiResponse(responseCode = "400", description = "Card number input data is invalid", content = @Content(schema = @Schema(implementation = CardValidationData.class)))})
    public Response validateCard(@Parameter(in = ParameterIn.DEFAULT, description = "Card number to process", required = true) CardInput body

            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.validateCard(body, securityContext);
    }

}
