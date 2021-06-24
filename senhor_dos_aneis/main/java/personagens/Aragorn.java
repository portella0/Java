package personagens;
import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import racas.Humano;

public class Aragorn extends Personagem implements Humano
{
    static final String FALA = "A day may come when the courage of men fails… but it is not THIS day.";

    public Aragorn()
    {
        super(10, 7, 6, 60, Classe.GUERREIRO, Faccao.SOCIEDADE);
    }

    public String toString()
    {
        return "A";
    }

    public void envelhecer()
    {
        constituicao -= 1;
    }

    public String falar() {
        return FALA;
    }
}
