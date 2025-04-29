package ifce.pizza.controllers;

import ifce.pizza.tables.PizzaIngrediente;
import ifce.pizza.repositories.PizzaIngredienteRepository;
import ifce.pizza.repositories.PizzaRepository;
import ifce.pizza.tables.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    @Autowired
    PizzaRepository repository;
    @Autowired
    PizzaIngredienteRepository ingredienteRepository;

    public record CriarPizzaInput(
            String nome,
            boolean disponibilizado,
            char tamanho,
            double preco,
            List<UUID> ingredientesIds
    ) {
    }

    @Transactional
    @PostMapping
    public void criarPizza(@RequestBody CriarPizzaInput input) {
        var pizza = new Pizza(
                null,
                input.nome(),
                input.disponibilizado(),
                input.tamanho(),
                input.preco()
        );
        pizza = repository.save(pizza);
        for (var ingredienteId : input.ingredientesIds()) {
            var pizzaIngredienteId = new PizzaIngrediente.PizzaIngredienteId(
                    pizza.pizzaId(),
                    ingredienteId
            );
            ingredienteRepository.save(new PizzaIngrediente(pizzaIngredienteId));
        }
    }
}
