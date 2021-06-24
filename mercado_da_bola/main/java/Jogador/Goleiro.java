package Jogador;

import Clube.Clube;

public class Goleiro extends Jogador
{
    public int penaltisDefendidos;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
                   String apetiteFinanceiro, double preco, int penaltisDefendidos)
    {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidos = penaltisDefendidos;
    }

    @Override
    public double getValorDeCompra()
    {
        return super.getValorDeCompra()*(1+0.04*penaltisDefendidos);
    }
}
