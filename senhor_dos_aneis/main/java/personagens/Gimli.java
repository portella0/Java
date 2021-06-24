package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Anao;

public class Gimli extends Personagem implements Anao
{
    static final String FALA_SOBRIO = "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    static final String FALA_BEBADO = "What did I say? He can't hold his liquor!";
    boolean bebado = false;
    int bebeuVezes = 0;

    public Gimli()
    {
        super(9,2,4,60, Classe.GUERREIRO, Faccao.SOCIEDADE);
    }

    public String toString()
    {
        return "I";
    }


    public void beber()
    {
        bebeuVezes++;
        if(bebeuVezes >= 3)
        {
            bebado = true;
        }
    }

    public String falar()
    {
        if(bebado)
        {
            return FALA_BEBADO;
        }
        return FALA_SOBRIO;
    }
}
