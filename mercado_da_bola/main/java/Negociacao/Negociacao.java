package Negociacao;

import Clube.Clube;
import Jogador.Jogador;

public class Negociacao
{
    private boolean temInteresseEmJogarPeloClubeOfertado(Jogador jogador, Clube clube)
    {
        return jogador.interessenEmSerTransferido(clube);
    }

    private boolean podeComprarJogador (Jogador jogador, Clube clube)
    {
        if(clube.saldoDisponivelEmCaixa >= jogador.getValorDeCompra())
            return  true;
        return  false;
    }

    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse)
    {
        if(temInteresseEmJogarPeloClubeOfertado(jogadorDeInteresse, clubeInteressado) &&
                podeComprarJogador(jogadorDeInteresse, clubeInteressado))
        {
            jogadorDeInteresse.transferenciaDeClube(clubeInteressado);
            clubeInteressado.saldoDisponivelEmCaixa = clubeInteressado.saldoDisponivelEmCaixa - jogadorDeInteresse.getValorDeCompra();
            return true;
        }
        else
            return false;
    }
}
