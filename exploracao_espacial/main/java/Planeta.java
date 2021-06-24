import Recursos.Recursos;
import java.util.ArrayList;

public class Planeta
{
    int posicao;
    public ArrayList<Recursos> recursos;

    public Planeta(int posicao, ArrayList<Recursos> recursos)
    {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int valorTotal()
    {
        int valorTotal = 0;

        for(int i = 0; i<recursos.size();i++)
        {
            valorTotal += recursos.get(i).valor;
        }

        return valorTotal;
    }

    public int valorPorPeso()
    {
        int valorPorPeso = 0;

        for(int i = 0; i<recursos.size();i++)
        {
            valorPorPeso += recursos.get(i).valor/recursos.get(i).peso;
        }

        return valorPorPeso;
    }
}
