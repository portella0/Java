package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Maia;

public class Saruman extends Personagem implements Maia
{
    static final String FALA = "Against the power of Mordor there can be no victory.";

    public Saruman()
    {
        super(2,2,9,70, Classe.MAGO, Faccao.SAURON);
    }

    public String toString()
    {
        return "S";
    }

    public Personagem ressucitar()
    {
        return null;
    }

    public String falar() {
        return FALA;
    }
}
