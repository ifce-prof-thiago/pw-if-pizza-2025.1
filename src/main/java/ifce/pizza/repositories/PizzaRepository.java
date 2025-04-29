package ifce.pizza.repositories;


import ifce.pizza.tables.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PizzaRepository extends CrudRepository<Pizza, UUID> {
}
