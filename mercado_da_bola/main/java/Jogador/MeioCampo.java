package Jogador;

import Clube.Clube;

public class MeioCampo extends Jogador
{
    public MeioCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, String apetiteFinanceiro, double preco)
    {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public double getValorDeCompra()
    {
        double valorDeCompra = super.getValorDeCompra();

        if(idade >30)
        {
            valorDeCompra = super.getValorDeCompra()*0.7;
        }

        return valorDeCompra;
    }

    @Override
    public boolean interessenEmSerTransferido(Clube clube)
    {
        if(clube.reputacaoHistorica <= reputacaoHistorica - 2)
            return super.interessenEmSerTransferido(clube);
        else
            return false;
    }
}
