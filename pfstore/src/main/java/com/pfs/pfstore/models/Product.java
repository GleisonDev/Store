package com.pfs.pfstore.models;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String section;

    @NumberFormat(pattern = "#,###.00")
    @Column(columnDefinition = "decimal(10,2)")
    private BigDecimal price;

    @NumberFormat(pattern = "#,###.00")
    @Column(columnDefinition = "decimal(10,2)")
    private BigDecimal cost;

    private Integer amount;
    @Column(name = "register_date", nullable = false, unique = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date registerDate;
    @Column(name = "delete_date", nullable = false, unique = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date deleteDate;
    private boolean active = true;

}
