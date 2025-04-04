package ifce.pizza;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("ingredientes")
public class IngredienteController {

    @GetMapping
    public Ingrediente buscarIngredientes() {
        return new Ingrediente(
                UUID.randomUUID().toString(),
                "Calabresa",
                true,
                2,
                3,
                4
        );
    }
}
