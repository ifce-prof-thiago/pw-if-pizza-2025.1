package ifce.pizza.usecases.ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarIngredientesPorFiltro {

    private final static String SQL = """
            SELECT * FROM Ingrediente WHERE nome ILIKE :nome AND disponibilizado = :disponibilizado
            """;

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public List<Output> execute(Input in) {
        var params = new MapSqlParameterSource()
                .addValue("nome", "%" + in.nome() + "%")
                .addValue("disponibilizado", in.disponibilizado());

        return jdbc.query(SQL, params, (row, _rowNum) -> new Output(
                row.getString("ingrediente_id"),
                row.getString("nome"),
                row.getBoolean("disponibilizado"),
                row.getDouble("preco_p"),
                row.getDouble("preco_m"),
                row.getDouble("preco_g")
        ));
    }

    public record Input(
            String nome,
            boolean disponibilizado
    ) {
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
