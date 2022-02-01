package com.company.testeJUnit1;

import org.junit.jupiter.api.Test;

public class Calculadora {
    @Test
    public int somar(String expressao) {
        int soma = 0;
        for (String valorSomar: expressao.split("\\+"))
            soma += Integer.valueOf(valorSomar);
        System.out.println(soma);
        return soma;
    }


}
