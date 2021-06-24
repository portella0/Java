package personagens;
import classe_e_faccao.Classe;
import classe_e_faccao.Faccao;
import mapa.Mapa;

public class Personagem
{
    final int forca;
    final int agilidade;
    final int inteligencia;
    int constituicao;
    int posicao;
    final Classe classe;
    boolean agiuNoTurno;
    //boolean UmNaFrentedentroDoMapa, DoisNaFrentedentroDoMapa, TresNaFrentedentroDoMapa; //verifica se o array do mapa possui a posicao indicada
    boolean terceiraCasaDentroDoMapa; //verifica se 3 casas a frente do personagem está dentro do array
    boolean segundaCasaDentroDoMapa; //verifica se 2 casas a frente do personagem está dentro do array
    boolean mapaVaziu;
    final Faccao faccao;

    public Personagem(int forca, int agilidade, int inteligencia, int constituicao, Classe classe, Faccao faccao)
    {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.classe = classe;
        this.faccao = faccao;
    }

    void setConstituicao(int dano)
    {
        if (constituicao - dano >= 0)
        {
            constituicao -= dano;
        }
        else
        {
            constituicao = 0;
        }
    }

    public void setPosicao(int posicao)
    {
        this.posicao = posicao;
    }

    public int getPosicao()
    {
        return posicao;
    }

    public int getConstituicao()
    {
        return constituicao;
    }

    public void resetTurno()
    {
        agiuNoTurno = false;
        segundaCasaDentroDoMapa = false;
        terceiraCasaDentroDoMapa = false;
    }

    public boolean agiuNoTurno()
    {
        return agiuNoTurno;
    }

    public boolean estaMorto()
    {
        return constituicao == 0;
    }

    public boolean getFazParteDaSociedade()
    {
        return faccao == Faccao.SOCIEDADE;
    }

    void ataqueGuerreiro(Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            if (mapa.listaPersonagems[getPosicao() + 1] != null &&
                    !mapa.listaPersonagems[getPosicao() + 1].getFazParteDaSociedade())
            {

                mapa.listaPersonagems[getPosicao() + 1].setConstituicao(2 * forca);
                mapa.checkSeEstaMorto(mapa.listaPersonagems[getPosicao() + 1]);
            }
        }
        else
        {
            if (mapa.listaPersonagems[getPosicao() - 1] != null &&
                    mapa.listaPersonagems[getPosicao() - 1].getFazParteDaSociedade())
            {
                mapa.listaPersonagems[getPosicao() - 1].setConstituicao(2 * forca);
                mapa.checkSeEstaMorto(mapa.listaPersonagems[getPosicao() - 1]);
            }
        }
    }


    void ataqueArqueiro(Mapa mapa)
    {
        if (terceiraCasaDentroDoMapa)
        {
            ataqueArqueiroProcuraInimigoMaisLonge(3,mapa);
        }
        else if (segundaCasaDentroDoMapa)
        {
            ataqueArqueiroProcuraInimigoMaisLonge(2,mapa);
        }
        else
        {
            ataqueArqueiroProcuraInimigoMaisLonge(1,mapa);
        }
    }

    void ataqueArqueiroProcuraInimigoMaisLonge(int distancia, Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            for (int i = distancia; i > 0; i--)
            {
                if (mapa.listaPersonagems[getPosicao() + i] != null &&
                        !mapa.listaPersonagems[getPosicao() + i].getFazParteDaSociedade())
                {
                    mapa.listaPersonagems[getPosicao() + i].setConstituicao(i * agilidade);
                    mapa.checkSeEstaMorto(mapa.listaPersonagems[getPosicao() + i]);
                    break;
                }
            }
        }
        else
        {
            for (int i = distancia; i > 0; i--)
            {
                if (mapa.listaPersonagems[getPosicao() - i] != null &&
                        mapa.listaPersonagems[getPosicao() - i].getFazParteDaSociedade())
                {
                    mapa.listaPersonagems[getPosicao() - i].setConstituicao(i * agilidade);
                    mapa.checkSeEstaMorto(mapa.listaPersonagems[getPosicao() - i]);
                    break;
                }
            }
        }
    }


    void ataqueMago(Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            for (int i = posicao + 1; i < mapa.listaPersonagems.length; i++)
            {
                if (mapa.listaPersonagems[i] != null && !mapa.listaPersonagems[i].getFazParteDaSociedade())
                {
                    mapa.listaPersonagems[i].setConstituicao(inteligencia);
                    mapa.checkSeEstaMorto(mapa.listaPersonagems[i]);
                }
            }
        }
        else
        {
            for (int i = posicao - 1; i >= 0; i--)
            {
                if (mapa.listaPersonagems[i] != null && mapa.listaPersonagems[i].getFazParteDaSociedade())
                {
                    mapa.listaPersonagems[i].setConstituicao(inteligencia);
                    mapa.checkSeEstaMorto(mapa.listaPersonagems[i]);
                }
            }
        }
    }


    void movimentoGuerreiro(Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            if (mapa.listaPersonagems[getPosicao() + 1] == null)
            {
                mapa.atualizarExibicao(getPosicao() + 1, this);
            }
        }
        else
        {
            if (mapa.listaPersonagems[getPosicao() - 1] == null)
            {
                mapa.atualizarExibicao(getPosicao() - 1, this);
            }

        }
    }

    void movimentoArqueiro(Mapa mapa)
    {
        if (segundaCasaDentroDoMapa)
        {
            movimentoArqueiroVerificaSeCaminhoEstaLivre(2,mapa);
        }
        else
        {
            movimentoArqueiroVerificaSeCaminhoEstaLivre(1,mapa);
        }
    }

    void movimentoArqueiroVerificaSeCaminhoEstaLivre(int distancia, Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            for (int i = 1; i <= distancia; i++)
            {
                if (mapa.listaPersonagems[getPosicao() + 1] == null)
                {
                    mapa.atualizarExibicao(getPosicao() + 1, this);
                }
            }
        }
        else
        {
            for (int i = 1; i <= distancia; i++)
            {
                if (mapa.listaPersonagems[getPosicao() - 1] == null)
                {
                    mapa.atualizarExibicao(getPosicao() - 1, this);
                }
            }
        }
    }

    void movimentoMago(Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            if (verificaSeOMapaEstaVazio(mapa))
            {
                mapa.atualizarExibicao(getPosicao() + 1, this);
            }
        }
        else
        {
            if (verificaSeOMapaEstaVazio(mapa))
            {
                mapa.atualizarExibicao(getPosicao() - 1, this);
            }

        }
    }

    boolean verificaSeOMapaEstaVazio(Mapa mapa)
    {
        mapaVaziu = true;
        for (int i = 0; i < mapa.listaPersonagems.length; i++)
        {
            if (mapa.buscarCasa(i) != this && mapa.buscarCasa(i) != null)
            {
                mapaVaziu = false;
            }
        }
        return mapaVaziu;
    }

    void verificarFrente(Mapa mapa)
    {
        if (getFazParteDaSociedade())
        {
            segundaCasaDentroDoMapa = ((getPosicao() + 2) < mapa.listaPersonagems.length);
            terceiraCasaDentroDoMapa = ((getPosicao() + 3) < mapa.listaPersonagems.length);
        }
        else
        {
            segundaCasaDentroDoMapa = ((getPosicao() - 2) >= 0);
            terceiraCasaDentroDoMapa = ((getPosicao() - 3) >= 0);
        }
    }

    public void andar(Mapa mapa)
    {
        verificarFrente(mapa);
        switch (classe)
        {
            case GUERREIRO:
                movimentoGuerreiro(mapa);
                break;
            case ARQUEIRO:
                movimentoArqueiro(mapa);
                break;
            case MAGO:
                movimentoMago(mapa);
                break;
            default:
                throw new IllegalArgumentException("Isso não deve acontecer");
        }
    }


    public void atacar(Mapa mapa)
    {
        agiuNoTurno = true;
        verificarFrente(mapa);
        switch (classe)
        {
            case GUERREIRO:
                ataqueGuerreiro(mapa);
                break;
            case ARQUEIRO:
                ataqueArqueiro(mapa);
                break;
            case MAGO:
                ataqueMago(mapa);
                break;
            default:
                throw new IllegalArgumentException("Isso não deve acontecer");
        }
    }
}

