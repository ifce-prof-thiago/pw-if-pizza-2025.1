package ifce.pizza;

import java.math.BigDecimal;

public class Ingrediente {

    private String ingredienteId;
    private String nome;
    private Boolean disponibilizado;
    private BigDecimal precoP;
    private BigDecimal precoM;
    private BigDecimal precoG;

    public Ingrediente(String ingredienteId,
                       String nome,
                       Boolean disponibilizado,
                       BigDecimal precoP,
                       BigDecimal precoM,
                       BigDecimal precoG
    ) {
        this.ingredienteId = ingredienteId;
        this.nome = nome;
        this.disponibilizado = disponibilizado;
        this.precoP = precoP;
        this.precoM = precoM;
        this.precoG = precoG;
    }
}
