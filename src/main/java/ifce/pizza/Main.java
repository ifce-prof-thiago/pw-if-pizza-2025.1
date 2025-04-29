package ifce.pizza;

import ifce.pizza.tables.Pizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    BeforeConvertCallback<Pizza> beforeConvertPizza() {
        return (pizza) -> {
            if (pizza.pizzaId() == null)
                return new Pizza(
                        UUID.randomUUID(),
                        pizza.nome(),
                        pizza.disponibilizado(),
                        pizza.tamanho(),
                        pizza.preco()
                );
            return pizza;
        };
    }
}
