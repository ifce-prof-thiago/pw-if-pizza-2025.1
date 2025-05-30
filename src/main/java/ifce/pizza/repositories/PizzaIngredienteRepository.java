package ifce.pizza.repositories;


import ifce.pizza.tables.PizzaIngrediente;
import ifce.pizza.tables.ids.PizzaIngredienteId;
import org.springframework.data.repository.CrudRepository;

public interface PizzaIngredienteRepository extends CrudRepository<PizzaIngrediente, PizzaIngredienteId> {
}
