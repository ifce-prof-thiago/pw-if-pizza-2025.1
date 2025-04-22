package ifce.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    @Autowired
    JdbcTemplate jdbc;

    @PostMapping
    public void criarPizza(@RequestBody Pizza pizza) {
        var id = UUID.randomUUID().toString();
        jdbc.update(
                "INSERT INTO  Pizza VALUES (?, ?, ?, ?, ?)",
                id,
                pizza.nome(),
                pizza.disponibilizado(),
                pizza.tamanho(),
                pizza.preco()
        );
    }
}
