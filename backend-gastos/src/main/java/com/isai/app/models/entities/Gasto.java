package com.isai.app.models.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.isai.app.models.enums.EnumMetodoPago;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto")
    private Long idGasto;

    @NotNull
    private BigDecimal monto;

    @NotEmpty
    private String descripcion;

    @Column(name = "fecha_gasto")
    private LocalDate fechaGasto;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private EnumMetodoPago metodoPago;

    @Column(name = "creado_en")
    @NotNull
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }
}
