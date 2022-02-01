package testeJUnit2.modelos;

import com.company.testeJUnit2.cliente.Cliente;
import com.company.testeJUnit2.registradora.Registradora;
import com.company.testeJUnit2.vendedor.Vendedor;

public class RegistradoraModelo {
    public static Registradora.RegistradoraBuilder construirCenario(){
        return Registradora.builder()
                .vendedor( new Vendedor(1, "João"))
                .cliente( new Cliente("José"));
    }

}
