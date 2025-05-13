package ifce.pizza.controllers;

import ifce.pizza.Ingrediente;
import ifce.pizza.usecases.ingredientes.BuscarIngredientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("ingredientes")
public class IngredienteController {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private BuscarIngredientes buscarIngredientes;

    @GetMapping
    public List<BuscarIngredientes.Response> buscarTodos() {
        return buscarIngredientes.execute();
    }

    @PostMapping
    public Response criar(
            @RequestBody Ingrediente ingrediente
    ) {
        var id = UUID.randomUUID().toString();
        jdbc.update(
                "INSERT INTO Ingrediente VALUES (?, ?, ?, ?, ?, ?)",
                id,
                ingrediente.nome(),
                ingrediente.disponibilizado(),
                ingrediente.precoP(),
                ingrediente.precoM(),
                ingrediente.precoG()
        );
        return new Response(id);
    }

    record Response(String id) {
    }
}