package ifce.pizza.usecases.ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DisponibilizarIngrediente {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    private static final String SQL = """
            UPDATE Ingrediente
            SET
                disponibilizado=true
            WHERE ingrediente_id=:ingrediente_id
            """;

    public void execute(Input in) {
        var params = new MapSqlParameterSource()
                .addValue("ingrediente_id", in.id());

        jdbc.update(SQL, params);
    }

    public record Input(String id) {

    }
}
