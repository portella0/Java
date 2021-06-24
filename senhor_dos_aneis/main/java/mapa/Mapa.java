package mapa;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import personagens.Personagem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapa
{
    String posicoes = "| | | | | | | | | | |";

    public Personagem[] listaPersonagems = new Personagem[10];

    public String exibir()
    {
        return posicoes;
    }

    public void inserir(int posicao, Personagem personagem)
    {
        if(posicoes.charAt(2*posicao+1) != ' ')
        {
            throw new PosicaoOcupadaException();
        }
        else if (posicoes.contains(personagem.toString()))
        {
            throw new PersonagemJaEstaNoMapaException();
        }
        else
        {
            listaPersonagems[posicao] = personagem;
            personagem.setPosicao(posicao);
            posicoes = posicoes.substring(0, 2 * posicao + 1) + personagem.toString() + posicoes.substring(2 * posicao + 2);
        }
    }

    public void atualizarExibicao(int posicao, Personagem personagem)
    {
        posicoes = posicoes.substring(0, 2 * personagem.getPosicao() + 1) + " " + posicoes.substring(2 * personagem.getPosicao() + 2);
        listaPersonagems[personagem.getPosicao()] = null;
        personagem.setPosicao(posicao);
        listaPersonagems[posicao] = personagem;
        posicoes = posicoes.substring(0, 2 * posicao + 1) + personagem.toString() + posicoes.substring(2 * posicao + 2);
    }

    public void checkSeEstaMorto(Personagem personagem)
    {
        if (personagem.estaMorto())
        {
            remover(personagem);
        }
    }

    public void remover(Personagem personagem)
    {
        List<Personagem> listaPersonagensConversion = new ArrayList<>(Arrays.asList(listaPersonagems));

        if(listaPersonagensConversion.contains(personagem))
        {
            listaPersonagems[personagem.getPosicao()] = null;
            posicoes = posicoes.substring(0, 2 * personagem.getPosicao() + 1) + " " + posicoes.substring(2 * personagem.getPosicao() + 2);
        }
        else
        {
            throw new PersonagemNaoEncontradoNoMapaException();
        }
    }

    public int buscarPosicao(Personagem personagem)
    {
        List<Personagem> listaPersonagensConversion = new ArrayList<>(Arrays.asList(listaPersonagems));

        if(listaPersonagensConversion.contains(personagem))
        {
            return  personagem.getPosicao();
        }
        else
        {
            throw new PersonagemNaoEncontradoNoMapaException();
        }
    }

    public Personagem buscarCasa(int posicao)
    {
        return listaPersonagems[posicao];
    }
}
