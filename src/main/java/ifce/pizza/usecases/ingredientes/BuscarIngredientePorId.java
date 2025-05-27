package ifce.pizza.usecases.ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BuscarIngredientePorId {

    private final static String SQL = """
            SELECT * FROM Ingrediente WHERE ingrediente_id = :id
            """;

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public Output execute(Input in) {
        var params = new MapSqlParameterSource()
                .addValue("id", in.id());

        return jdbc.queryForObject(SQL, params, mapperToOutput());
    }

    private static RowMapper<Output> mapperToOutput() {
        return (row, _rowNum) -> new Output(
                row.getString("ingrediente_id"),
                row.getString("nome"),
                row.getBoolean("disponibilizado"),
                row.getDouble("preco_p"),
                row.getDouble("preco_m"),
                row.getDouble("preco_g")
        );
    }

    public record Input(String id) {
    }

    public record Output(
            String id,
            String nome,
            boolean disponibilizado,
            Double precoP,
            Double precoM,
            Double precoG) {
    }

}
