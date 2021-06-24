package simulador;

import exceptions.SauronDominaOMundoException;
import mapa.Mapa;

public class Simulador
{
    Mapa mapa;
    boolean sociedadeVenceu = false;
    boolean sauronVenceu = false;

    public Simulador(Mapa mapa)
    {
        this.mapa = mapa;
    }

    public void simular()
    {
        do
        {
            System.out.println(mapa.exibir());
            executaAsAcoesDeCadaPersonagem();
            resetaOsPersonagensParaUmNovoTurno();
            verificaSeAlgumLadoVenceu();
        } while (!sociedadeVenceu && !sauronVenceu);
    }

    void executaAsAcoesDeCadaPersonagem()
    {
        for (int i = 0; i < mapa.listaPersonagems.length; i++)
        {
            if (mapa.listaPersonagems[i] != null && !mapa.listaPersonagems[i].agiuNoTurno())
            {
                mapa.listaPersonagems[i].atacar(mapa);
                mapa.listaPersonagems[i].andar(mapa);
            }
        }
    }

    void resetaOsPersonagensParaUmNovoTurno()
    {
        for (int i = 0; i < mapa.listaPersonagems.length; i++)
        {
            if (mapa.listaPersonagems[i] != null)
            {
                mapa.listaPersonagems[i].resetTurno();
            }
        }
    }

    void verificaSeAlgumLadoVenceu()
    {
        if (mapa.listaPersonagems[9] != null && mapa.buscarCasa(9).getFazParteDaSociedade())
        {
            System.out.println(mapa.exibir());
            sociedadeVenceu = true;
        }
        else if (!sociedadeEstaViva())
        {
            System.out.println(mapa.exibir());
            sauronVenceu = true;
            throw new SauronDominaOMundoException();
        }
    }

    boolean sociedadeEstaViva()
    {
        boolean estaViva = false;
        for (int i = 0; i < mapa.listaPersonagems.length; i++)
        {
            if (mapa.listaPersonagems[i] != null && mapa.listaPersonagems[i].getFazParteDaSociedade())
            {
                estaViva = true;
                break;
            }
        }
        return estaViva;
    }
}
