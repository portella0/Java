package Jogador;

import Clube.Clube;

public class Atacante extends Jogador
{
    public int golsFeitos;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
                    String apetiteFinanceiro, double preco, int golsFeitos)
    {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.golsFeitos = golsFeitos;
    }

    @Override
    public double getValorDeCompra()
    {
        double valorDeCompra = super.getValorDeCompra()*(1+0.01*golsFeitos);

        if(idade >30)
        {
            valorDeCompra = super.getValorDeCompra()*0.7;
        }

        return valorDeCompra;
    }

    @Override
    public boolean interessenEmSerTransferido(Clube clube)
    {
        if(clube.reputacaoHistorica > reputacaoHistorica)
            return super.interessenEmSerTransferido(clube);
        else
            return false;
    }
}
