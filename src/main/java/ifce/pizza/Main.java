package ifce.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Configuration
    public class Init {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Bean
        public String insert() {
            var ingredienteId = UUID.randomUUID().toString();
            var nome = "Marguerita";
            var disponibilizado = false;
            var precoP = 10.00;
            var precoM = 15.00;
            var precoG = 20.00;
            jdbcTemplate.update(
                    "INSERT INTO Ingrediente VALUES (?, ?, ?, ?, ?, ?)",
                    ingredienteId,
                    nome,
                    disponibilizado,
                    precoP,
                    precoM,
                    precoG
            );
            return "";
        }

    }
}
