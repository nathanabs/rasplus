package com.client.api.rasplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptions_type")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionType implements Serializable {

    @Id
    @Column(name = "subscriptions_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "access_months")
    private Long accessMonths;

    @Column
    private BigDecimal price;

    @Column(name = "product_key", unique = true)
    private String productKey;

}
