package ifce.pizza;

public record Pizza(
        String pizzaId,
        String nome,
        boolean disponibilizado,
        char tamanho,
        double preco
) {
}
