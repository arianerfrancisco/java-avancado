import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.util.List;
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Compra {
    private List<Item> itens;
}
