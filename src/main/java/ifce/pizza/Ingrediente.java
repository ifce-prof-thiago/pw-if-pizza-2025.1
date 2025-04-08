package ifce.pizza;


public record Ingrediente(
        String ingredienteId,
        String nome,
        boolean disponibilizado,
        double precoP,
        double precoM,
        double precoG
) {
}