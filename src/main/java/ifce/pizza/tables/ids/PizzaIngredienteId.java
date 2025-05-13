package ifce.pizza.tables.ids;

import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

public record PizzaIngredienteId(
        @Column("pizza_id") String pizzaId,
        @Column("ingrediente_id") String ingredienteId
) {
}
