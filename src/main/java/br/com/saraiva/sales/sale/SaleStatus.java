package br.com.saraiva.sales.sale;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public enum SaleStatus {

    PENDING(1, "Pendente"),
    CONFIRMED(2, "Confirmado"),
    BLOCKED(3, "Bloqueado");

    private Integer id;
    private String description;

}
