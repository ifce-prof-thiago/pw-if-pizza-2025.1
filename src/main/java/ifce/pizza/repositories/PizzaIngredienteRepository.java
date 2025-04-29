package ifce.pizza.repositories;


import ifce.pizza.tables.PizzaIngrediente;
import org.springframework.data.repository.CrudRepository;

public interface PizzaIngredienteRepository extends CrudRepository<PizzaIngrediente, PizzaIngrediente.PizzaIngredienteId> {
}
