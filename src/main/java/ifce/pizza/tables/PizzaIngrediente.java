package ifce.pizza.tables;

import ifce.pizza.tables.ids.PizzaIngredienteId;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("pizza_ingrediente")
public record PizzaIngrediente(
        @Id PizzaIngredienteId id
) {
}
