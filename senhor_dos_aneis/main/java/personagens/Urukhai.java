package personagens;

import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Personagem implements Monstro, Humano
{
    static final String FALA = "Looks like meat's back on the menu boys!";
    static final String GRUNHIDO = "Uuurrrrrr";

    public Urukhai()
    {
        super(8,6,3,45, Classe.GUERREIRO, Faccao.SAURON);
    }

    public String toString()
    {
        return "U";
    }

    @Override
    public String grunhir() {
        return GRUNHIDO;
    }

    public void envelhecer()
    {
        constituicao -= 2;
    }

    public String falar() {
        return FALA;
    }
}
