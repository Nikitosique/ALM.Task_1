package io.swagger.api.impl;

import dev.andrylat.banking.common.card.paymentsystem.PaymentSystem;
import dev.andrylat.banking.common.card.paymentsystem.PaymentSystemResolver;
import dev.andrylat.banking.common.card.validation.CardValidator;
import dev.andrylat.banking.common.card.validation.CompositeCardValidator;
import io.swagger.api.CardnumberApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.CardInput;
import io.swagger.model.CardValidationData;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public class CardnumberApiServiceImpl extends CardnumberApiService {
    @Override
    public Response validateCard(CardInput body, SecurityContext securityContext) throws NotFoundException {
        CardValidationData validationData = new CardValidationData();

        CardValidator validator = new CompositeCardValidator();
        List<String> failureMessages = validator.validate(body.getCardNumber());
        validationData.setValidationMessages(failureMessages);

        if (failureMessages.isEmpty()) {
            PaymentSystemResolver resolver = new PaymentSystemResolver();
            PaymentSystem system = resolver.resolvePaymentSystem(body.getCardNumber());
            validationData.setValidationResult(true);
            validationData.setPaymentSystemName(system.getName());
            return Response.status(Response.Status.OK).entity(validationData).build();
        } else {
            validationData.setValidationResult(false);
            return Response.status(Response.Status.BAD_REQUEST).entity(validationData).build();
        }
    }

}
