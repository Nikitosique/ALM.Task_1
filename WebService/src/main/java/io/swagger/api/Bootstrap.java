package io.swagger.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Swagger Server",
                version = "1.0.0",
                description = "Specification Document for Cart Validation and Mortgage Calculation Application",
                termsOfService = "",
                contact = @Contact(email = ""),
                license = @License(
                        name = "",
                        url = "http://unlicense.org"
                )
        )
)
public class Bootstrap {
}
