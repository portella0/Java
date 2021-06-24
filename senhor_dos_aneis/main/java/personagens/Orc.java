package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Monstro;

public class Orc extends Personagem implements Monstro
{
    static final String GRUNHIDO = "Arrrggghhh";

    public Orc()
    {
        super(7,4,1,30, Classe.GUERREIRO, Faccao.SAURON);
    }

    public String toString()
    {
        return "O";
    }

    public String grunhir()
    {
        return GRUNHIDO;
    }
}
