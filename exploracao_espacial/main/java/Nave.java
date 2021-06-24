import Recursos.Recursos;

import java.util.ArrayList;

public class Nave
{
    int combustivel;
    int posicao = 0;
    Planeta planeta;
    ArrayList<Planeta> planetas = new ArrayList<Planeta>();
    public ArrayList<Recursos> recursos = new ArrayList<Recursos>();
    public boolean semCombustivel = false;

    public Nave(int combustivel)
    {
        this.combustivel = combustivel;
    }

    public int getQuantidadeDeCombustivel()
    {
        return combustivel;
    }

    public int getValorRecursosColetados()
    {
        int valorTotal = 0;

        for(int i = 0; i<recursos.size();i++)
        {
            valorTotal += recursos.get(i).valor;
        }

        return valorTotal;
    }

    public int getValorPesoRecursosColetados()
    {
        int valorPorPeso = 0;

        for(int i = 0; i<recursos.size();i++)
        {
            valorPorPeso += recursos.get(i).valor/recursos.get(i).peso;
        }

        return valorPorPeso;
    }

    public  int getPosicao()
    {
        return  posicao;
    }

    public ArrayList<Recursos> explorar(ArrayList<Planeta> planetas)
    {
        this.planetas = planetas;

        for (int i = 0; i < planetas.size(); i++)
        {
            for (int k = posicao; k < planetas.get(i).posicao; k++)
            {
                if (getQuantidadeDeCombustivel() >= 3)
                {
                    combustivel -= 3;
                    posicao++;
                }
                else
                {
                    semCombustivel = true;
                }

                if (posicao == planetas.get(i).posicao)
                {
                    recursos.addAll(planetas.get(i).recursos);
                }
            }
        }

        for (int i = 0; i < planetas.get(planetas.size() - 1).posicao; i++)
        {
            if (getQuantidadeDeCombustivel() >= 3)
            {
                combustivel -= 3;
                posicao--;
            }
            else
            {
                semCombustivel = true;
            }
        }

        return recursos;
    }

    public ArrayList<Recursos> explorar(Planeta planeta)
    {
        this.planeta = planeta;

        for (int i = 0; i < planeta.posicao; i++)
        {
            if (getQuantidadeDeCombustivel() >= 3)
            {
                combustivel -= 3;
                posicao++;
            }
            else
            {
                semCombustivel = true;
            }
        }

        if (posicao == planeta.posicao)
        {
            recursos.addAll(planeta.recursos);
            for (int i = 0; i < planeta.posicao; i++)
            {
                if (getQuantidadeDeCombustivel() >= 3)
                {
                    combustivel -= 3;
                    posicao--;
                }
                else
                {
                    semCombustivel = true;
                }
            }
        }

        return recursos;
    }
}
