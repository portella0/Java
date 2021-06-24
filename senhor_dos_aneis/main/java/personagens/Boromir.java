package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Humano;

public class Boromir extends Personagem implements Humano
{
    static final String FALA = "One does not simply walk into Mordor.";

    public Boromir()
    {
        super(7, 6, 3, 40, Classe.GUERREIRO, Faccao.SOCIEDADE);
    }

    public String toString()
    {
        return "B";
    }

    public void envelhecer()
    {
        constituicao -= 2;
    }

    public String falar() {
        return FALA;
    }
}
