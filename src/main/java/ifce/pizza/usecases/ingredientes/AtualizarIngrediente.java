package ifce.pizza.usecases.ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtualizarIngrediente {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    private static final String SQL = """
            UPDATE Ingrediente
            SET
                nome=:nome,
                disponibilizado=:disponibilizado,
                preco_p=:preco_p,
                preco_m=:preco_m,
                preco_g=:preco_g
            WHERE ingrediente_id=:ingrediente_id
            """;

    public void execute(Input in) {
        var params = new MapSqlParameterSource()
                .addValue("ingrediente_id", in.id())
                .addValue("nome", in.nome())
                .addValue("disponibilizado", in.disponibilizado())
                .addValue("preco_p", in.precoP())
                .addValue("preco_m", in.precoM())
                .addValue("preco_g", in.precoG());

        jdbc.update(SQL, params);
    }

    public record Input(
            String id,
            String nome,
            boolean disponibilizado,
            Double precoP,
            Double precoM,
            Double precoG
    ) {

    }

}
