package com.client.api.rasplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

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

    @Column
    private String card_number;

    @Column(name = "card_expiration_month")
    private Integer cardExpirationMonth;
    @Column(name = "card_expiration_year")
    private Integer cardExpirationYear;

    @Column(name = "card_security_code")
    private String cardSecurityCode;

    @Column
    private BigDecimal price;

    @Column
    private Long instalments;

    @Column(name = "dt_payment")
    private Long datePayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;
}
