package Jogador;
import Clube.Clube;

public class Jogador
{
    String nome;
    int idade;
    Clube clubeAtual;
    int reputacaoHistorica;
    String apetiteFinanceiro;
    double preco;

    public Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, String apetiteFinanceiro, double preco)
    {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;

        if(reputacaoHistorica > 10)
            this.reputacaoHistorica = 10;
        else if (reputacaoHistorica < 0)
            this.reputacaoHistorica = 0;
        else
            this.reputacaoHistorica = reputacaoHistorica;
        if(apetiteFinanceiro.equals("INDIFERENTE") || apetiteFinanceiro.equals("CONSERVADOR") || apetiteFinanceiro.equals("MERCENARIO"))
            this.apetiteFinanceiro = apetiteFinanceiro;
        else
            this.apetiteFinanceiro = "Apetite financeiro inválido";
        this.preco = preco;
    }

    public String getClubeAtual()
    {
        if(clubeAtual != null)
            return clubeAtual.nome;
        else
            return "Sem clube";
    }

    public String getApetiteFinanceiro()
    {
        return apetiteFinanceiro;
    }

    public int getReputacaoHistorica()
    {
        return reputacaoHistorica;
    }

    public  boolean interessenEmSerTransferido(Clube clube)
    {
        boolean aceitou;
        if(clube.reputacaoHistorica < 1)
            aceitou = false;
        else
            aceitou = true;
        return aceitou;
    }

    public double getValorDeCompra()
    {
        double valorDeCompra = preco;

        if(apetiteFinanceiro.equals("INDIFERENTE"))
            return  valorDeCompra;
        else if(apetiteFinanceiro.equals("CONSERVADOR"))
            valorDeCompra = preco*1.4;
        else if(apetiteFinanceiro.equals("MERCENARIO"))
            valorDeCompra = preco*1.8;

        return  valorDeCompra;
    }

    public void transferenciaDeClube(Clube novoClube)
    {
        clubeAtual = novoClube;
    }

}
