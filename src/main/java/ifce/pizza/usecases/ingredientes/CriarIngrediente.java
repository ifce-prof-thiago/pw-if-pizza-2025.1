package ifce.pizza.usecases.ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CriarIngrediente {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    private static final String SQL = """
            INSERT INTO Ingrediente
            (ingrediente_id, nome, disponibilizado, preco_p, preco_m, preco_g)
            VALUES (:ingrediente_id, :nome, :disponibilizado, :preco_p, :preco_m, :preco_g)
            """;

    public Output execute(Input in) {
        var id = UUID.randomUUID().toString();
        var params = new MapSqlParameterSource()
                .addValue("ingrediente_id", id)
                .addValue("nome", in.nome())
                .addValue("disponibilizado", in.disponibilizado())
                .addValue("preco_p", in.precoP())
                .addValue("preco_m", in.precoM())
                .addValue("preco_g", in.precoG());

        jdbc.update(SQL, params);

        return new Output(id);
    }

    public record Input(
            String nome,
            boolean disponibilizado,
            Double precoP,
            Double precoM,
            Double precoG
    ) {

    }

    public record Output(String id) {
    }

}
