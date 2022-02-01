package testeJUnit2;

import com.company.testeJUnit2.banco_de_dados.BancoDeDados;
import com.company.testeJUnit2.compra.Compra;
import com.company.testeJUnit2.compra.Item;
import org.junit.jupiter.api.BeforeEach;
import testeJUnit2.modelos.RegistradoraModelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.math.BigDecimal;
import java.util.List;

public class RegistradoraTeste {
    @BeforeEach
    // este metodo irá resetar a lista, pois um teste não pode depender de outro teste
    void reiniciarBancoDeDados(){
        BancoDeDados.reset();
    }
    @Test
    public void deveRegistrarAVendaNoBancoDeDados(){
        // 1 Arrange - entrada
        var pastelDeCarne = Item.builder().nome("Pastel de Carne").valor(new BigDecimal("7.00")).build();
        var pastelDeFrango = Item.builder().nome("Pastel de Frango").valor(new BigDecimal("6.50")).build();
        List<Item> listaDeItens = Arrays.asList(pastelDeCarne, pastelDeFrango);
        var compra = Compra.builder().itens(listaDeItens).build();
        // template
        var registradora = RegistradoraModelo.construirCenario()
                .compra(compra)
                .valorRecebido(new BigDecimal("13.50"))
                .build();
        //  2 Act - ação
        registradora.efetivarVenda();
        // 3 Assert - resultado
        Assertions.assertEquals(1, BancoDeDados.vendas.size());
        Assertions.assertEquals(new BigDecimal("13.50"), BancoDeDados.vendas.get(0).getTotalCompra());
        Assertions.assertEquals(new BigDecimal("00.00"), BancoDeDados.vendas.get(0).getTroco());
        Assertions.assertEquals("João", BancoDeDados.vendas.get(0).getVendedor().getNome());
        Assertions.assertEquals("José", BancoDeDados.vendas.get(0).getCliente().getNome());
        Assertions.assertEquals(LocalDate.now(), BancoDeDados.vendas.get(0).getDataDaVenda());
    }
    @Test
public void naoDeveRegistrarAVendaQuandoOValorRecebidoForMenorQueOTotal(){
    var pastelDeCarne = Item.builder().nome("Pastel de Carne").valor(new BigDecimal("7.00")).build();
    var pastelDeFrango = Item.builder().nome("Pastel de Frango").valor(new BigDecimal("6.50")).build();
    List<Item> listaDeItens = Arrays.asList(pastelDeCarne, pastelDeFrango);
    var compra = Compra.builder().itens(listaDeItens).build();
    var registradora = RegistradoraModelo.construirCenario()
            .compra(compra)
            .valorRecebido(new BigDecimal("13.00"))
    // O valor correto do total da compra seria: R$13.50, logo a compra não poderia ter sido efetivada
    // a correção deste bug está na Class Registradora método > efetivarVenda() na condição if;
            .build();
    registradora.efetivarVenda();
    Assertions.assertEquals(0, BancoDeDados.vendas.size());
}
}
