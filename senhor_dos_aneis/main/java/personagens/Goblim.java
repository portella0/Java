package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Monstro;

public class Goblim extends Personagem implements Monstro
{
    static final String GRUNHIDO = "Iiisshhhh";

    public Goblim()
    {
        super(3,6,1,20, Classe.ARQUEIRO, Faccao.SAURON);
    }

    public String toString()
    {
        return "M";
    }

    public String grunhir() {
        return GRUNHIDO;
    }
}
