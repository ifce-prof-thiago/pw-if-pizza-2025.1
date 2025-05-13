package ifce.pizza.controllers;

import ifce.pizza.tables.PizzaIngrediente;
import ifce.pizza.repositories.PizzaIngredienteRepository;
import ifce.pizza.repositories.PizzaRepository;
import ifce.pizza.tables.Pizza;
import ifce.pizza.tables.ids.PizzaIngredienteId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    @Autowired
    PizzaRepository repository;
    @Autowired
    PizzaIngredienteRepository ingredienteRepository;

    @Autowired
    JdbcTemplate jdbc;

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
            var pizzaIngredienteId = new PizzaIngredienteId(
                    pizza.pizzaId().toString(),
                    ingredienteId.toString()
            );
            ingredienteRepository.save(new PizzaIngrediente(pizzaIngredienteId));
        }
    }

    @GetMapping
    public List<ListarPizzasResponse> listarPizzas() {
        var list = new ArrayList<ListarPizzasResponse>();
        jdbc.query("SELECT p.pizza_id, i.ingrediente_id, i.nome as ingredienteNome, p.nome as pizzaNome FROM pizza_ingrediente pi JOIN ingrediente i JOIN pizza p ON i.ingrediente_id = pi.ingrediente_id AND p.pizza_id = pi.pizza_id", (linha) -> {
            var resp = new ListarPizzasResponse(
                    linha.getString("pizza_id"),
                    linha.getString("ingrediente_id"),
                    linha.getString("ingredienteNome"),
                    linha.getString("pizzaNome")
            );
            list.add(resp);
        });
        return list;
    }

    record ListarPizzasResponse(
            String pizzaId,
            String ingredienteId,
            String ingredienteNome,
            String pizzaNome
    ) {

    }
}
