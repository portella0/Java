package Jogador;

import Clube.Clube;

public class Lateral extends Jogador
{
    public int cruzamentosCerteiros;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
                   String apetiteFinanceiro, double preco, int cruzamentosCerteiros)
    {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.cruzamentosCerteiros = cruzamentosCerteiros;
    }

    @Override
    public double getValorDeCompra()
    {
        double valorDeCompra = super.getValorDeCompra()*(1+0.02*cruzamentosCerteiros);

        if(idade >28)
        {
            valorDeCompra = super.getValorDeCompra()*0.7;
        }

        return valorDeCompra;
    }
}
