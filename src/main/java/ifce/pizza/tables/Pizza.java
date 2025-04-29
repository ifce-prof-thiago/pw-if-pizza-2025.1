package ifce.pizza.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("pizza")
public record Pizza(
        @Id UUID pizzaId,
        String nome,
        boolean disponibilizado,
        char tamanho,
        double preco
) {

}
