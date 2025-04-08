package ifce.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("ingredientes")
public class IngredienteController {

    @Autowired
    private JdbcTemplate jdbc;

    @GetMapping
    public Ingrediente buscarIngredientes(
            String nome,
            boolean disponibilizado,
            double precoP,
            double precoM,
            double precoG
    ) {
        var id = UUID.randomUUID().toString();
        jdbc.update(
                "INSERT INTO Ingrediente VALUES (?, ?, ?, ?, ?, ?)",
                id,
                nome,
                disponibilizado,
                precoP,
                precoM,
                precoG
        );
        return new Ingrediente(
                id,
                nome,
                disponibilizado,
                precoP,
                precoM,
                precoG
        );
    }
}
