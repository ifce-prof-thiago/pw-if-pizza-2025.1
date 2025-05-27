package ifce.pizza.controllers;

import ifce.pizza.usecases.ingredientes.AtualizarIngrediente;
import ifce.pizza.usecases.ingredientes.BuscarIngredientes;
import ifce.pizza.usecases.ingredientes.BuscarIngredientesPorFiltro;
import ifce.pizza.usecases.ingredientes.CriarIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredientes")
public class IngredienteController {

    @Autowired
    private CriarIngrediente criarIngrediente;

    @Autowired
    private AtualizarIngrediente atualizarIngrediente;

    @Autowired
    private BuscarIngredientesPorFiltro buscarIngredientesPorFiltro;

    @PostMapping
    public CriarIngrediente.Output criar(@RequestBody CriarIngrediente.Input input) {
        return criarIngrediente.execute(input);
    }

    @PutMapping
    public void atualizar(@RequestBody AtualizarIngrediente.Input input) {
        atualizarIngrediente.execute(input);
    }

    @GetMapping
    public List<BuscarIngredientesPorFiltro.Output> buscarPorFiltro(@RequestBody BuscarIngredientesPorFiltro.Input input){
        return buscarIngredientesPorFiltro.execute(input);
    }
}