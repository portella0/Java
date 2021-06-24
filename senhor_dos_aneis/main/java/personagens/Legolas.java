package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Elfo;

public class Legolas extends Personagem implements Elfo
{
    static final String FALA = "They're taking the Hobbits to Isengard!";
    static final String FALA_ELFICO = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

    public Legolas()
    {
        super(5,10,6,80, Classe.ARQUEIRO, Faccao.SOCIEDADE);
    }

    public String toString()
    {
        return "L";
    }

    public String falarElfico()
    {
        return FALA_ELFICO;
    }

    public String falar() {
        return FALA;
    }
}
