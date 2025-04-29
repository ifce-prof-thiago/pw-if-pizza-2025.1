package ifce.pizza.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("pizza_ingrediente")
public record PizzaIngrediente(
        @Id PizzaIngredienteId id
) {
    public record PizzaIngredienteId(
            UUID pizzaId,
            UUID ingredienteId
    ) {
    }
}
