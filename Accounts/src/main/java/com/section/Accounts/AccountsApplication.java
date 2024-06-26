package com.section.Accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservices Rest Api Documentation",
				description = "EazyBank Accounts microservices RestAPI Documentation",
				version = "v1",
				contact = @Contact(
						name = "Lucas Andrade",
						email = "lucas@gmail.com",
						url = "htpps//:www.google.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "htpps//:www.google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank accounts microservices",
				url = "www.springboot.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
