package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Maia;

public class Gandalf extends Personagem implements Maia
{
    static final String FALA = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

    public Gandalf()
    {
        super(2,3,10,80, Classe.MAGO, Faccao.SOCIEDADE);
    }

    public String toString()
    {
        return "G";
    }

    public Personagem ressucitar()
    {
        if(constituicao == 0)
        {
            return new Gandalf();
        }
        return null;
    }

    public String falar()
    {
        return FALA;
    }
}
