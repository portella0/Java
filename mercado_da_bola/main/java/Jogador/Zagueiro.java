package Jogador;

import Clube.Clube;

public class Zagueiro extends Jogador
{

    public Zagueiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, String apetiteFinanceiro, double preco)
    {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public double getValorDeCompra()
    {
        double valorDeCompra = super.getValorDeCompra();

        if(idade >30)
        {
            valorDeCompra = super.getValorDeCompra()*0.8;
        }

        return valorDeCompra;
    }
}
