package ifce.pizza.usecases.ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarIngredientes {

    private static final String SQL = """
                            SELECT * FROM Ingrediente i
            """;

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public List<Output> execute() {
        return jdbc.query(SQL, mapperToResponse());
    }

    private static RowMapper<Output> mapperToResponse() {
        return (row, _number) -> new Output(
                row.getString("ingrediente_id"),
                row.getString("nome"),
                row.getBoolean("disponibilizado")
        );
    }

    public record Output(
            String id,
            String nome,
            boolean disponibilizado
    ) {
    }

}
