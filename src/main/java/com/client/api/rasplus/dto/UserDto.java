package com.client.api.rasplus.dto;

import com.client.api.rasplus.model.SubscriptionType;
import com.client.api.rasplus.model.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Campo name não pode ser nulo")
    @Size(min = 6, message = "Valor mínimo igual a 6 caracteres")
    private String name;

    @Email(message = "Inválido")
    private String email;

    @Size(min = 11, message = "Valor mínimo igual a 11 caracteres")
    private String phone;

    @CPF(message = "Inválido")
    private String cpf;

    private LocalDate dateSubscription = LocalDate.now();

    private LocalDate dateExpiration;

    @NotNull
    private Long userTypeId;

    private Long subscriptionTypeId;

}
