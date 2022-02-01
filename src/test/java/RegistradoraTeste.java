import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.math.BigDecimal;
import java.util.List;

public class RegistradoraTeste {
    @Test
    public void deveRegistrarAVendaNoBancoDeDados(){
        // Um teste divide-se em 3 etapas:
        // 1 Arrange - entrada
        var pastelDeCarne = Item.builder().nome("Pastel de Carne").valor(new BigDecimal("7.00")).build();
        var pastelDeFrango = Item.builder().nome("Pastel de Frango").valor(new BigDecimal("6.50")).build();
        List<Item> listaDeItens = Arrays.asList(pastelDeCarne, pastelDeFrango);
        var compra = Compra.builder().itens(listaDeItens).build();
        //  2 Act - ação
        // 3 Assert - resultado


    }
}
