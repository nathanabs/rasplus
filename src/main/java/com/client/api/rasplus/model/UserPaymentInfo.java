package com.client.api.rasplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "user_payment_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentInfo implements Serializable {

    @Id
    @Column(name = "user_payment_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_expiration_month")
    private Long cardExpirationMonth;
    @Column(name = "card_expiration_year")
    private Long cardExpirationYear;

    @Column(name = "card_security_code")
    private String cardSecurityCode;

    @Column
    private BigDecimal price;

    @Column
    private Long installments;

    @Column(name = "dt_payment")
    private LocalDate datePayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
