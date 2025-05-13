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

    public List<Response> execute() {
        return jdbc.query(SQL, mapperToResponse());
    }

    private static RowMapper<Response> mapperToResponse() {
        return (row, _number) -> new Response(
                row.getString("ingrediente_id"),
                row.getString("nome"),
                row.getBoolean("disponibilizado")
        );
    }

    public record Response(
            String id,
            String nome,
            boolean disponibilizado
    ) {
    }

}
