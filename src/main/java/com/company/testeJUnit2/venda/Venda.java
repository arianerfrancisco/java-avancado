package com.company.testeJUnit2.venda;

import com.company.testeJUnit2.cliente.Cliente;
import com.company.testeJUnit2.vendedor.Vendedor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
public class Venda {
    private final BigDecimal totalCompra;
    private final BigDecimal troco;
    private final Vendedor vendedor;
    private final Cliente cliente;

    @Builder.Default
    private final LocalDate dataDaVenda = LocalDate.now();

}
