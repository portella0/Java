import org.junit.Test;
import org.junit.Assert;

import Jogador.Goleiro;
import Jogador.Atacante;
import Jogador.MeioCampo;
import Jogador.Lateral;
import Jogador.Zagueiro;
import Clube.Clube;
import Negociacao.Negociacao;

public class mercadoDaBolaTest
{
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa()
    {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, 100000000);
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, "INDIFERENTE", 800500, 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void DeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMaiorQueASua()
    {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 11, 100000000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, "CONSERVADOR", 80050, 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua()
    {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, 100000000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 25, null, 10, "CONSERVADOR", 800500, 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel()
    {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 11, 100000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 25, null, 10, "MERCENARIO", 800500, 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos()
    {
        MeioCampo meioCampo = new MeioCampo("Cristiano Ronaldo", 25, null, 10, "CONSERVADOR", 1000);

        int valorEsperado = 1400;

        Assert.assertEquals(valorEsperado, meioCampo.getValorDeCompra(), 0.01);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos()
    {
        MeioCampo meioCampo = new MeioCampo("Cristiano Ronaldo", 35, null, 10, "CONSERVADOR", 1000);

        int valorEsperado = 980;

        Assert.assertEquals(valorEsperado, meioCampo.getValorDeCompra(), 0.01);
    }

    @Test
    public void deveAtribuirDezSeReputacaoHistoricaDoJogadorForMaiorQueDez()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 18, "INDIFERENTE", 800500, 12);

        int valorEsperado = 10;

        Assert.assertEquals(valorEsperado, goleiro.getReputacaoHistorica(), 0.01);
    }

    @Test
    public void deveAtribuirZeroSeReputacaoHistoricaDoJogadorForMenorQueZero()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, -2, "MERCENARIO", 800500, 12);

        int valorEsperado = 0;

        Assert.assertEquals(valorEsperado, goleiro.getReputacaoHistorica(), 0.01);
    }

    @Test
    public void informaQueApetiteFinanceiroEhInvalido()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, "ERRADO", 800500, 12);

        String textoEsperado = "Apetite financeiro inválido";

        Assert.assertEquals(textoEsperado, goleiro.getApetiteFinanceiro());
    }

    @Test
    public void informaClubeDoJogador()
    {
        Clube clube = new Clube("Internacional", 11, 10000000);
        Zagueiro zagueiro = new Zagueiro("Marcelo Grohe", 33, clube, 8, "MERCENARIO", 800500);

        String nomeEsperado = clube.nome;

        Assert.assertEquals(nomeEsperado, zagueiro.getClubeAtual());
    }

    @Test
    public void informaQueJogadorEstaSemClube()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, "INDIFERENTE", 800500, 12);

        String textoEsperado = "Sem clube";

        Assert.assertEquals(textoEsperado, goleiro.getClubeAtual());
    }

    @Test
    public void naoDeveSerPossivelNegociarUmMeioCampoComUmClubeQueTemReputacaoHistoricaMaiorQueASua()
    {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 13, 100000000);
        MeioCampo meioCampo = new MeioCampo("Cristiano Ronaldo", 35, null, 10, "CONSERVADOR", 800500);

        boolean foiPossivelNegociar = negociacao.negociar(clube, meioCampo);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void DeveSerPossivelNegociarUmMeioCampoComUmClubeQueTemReputacaoHistoricaDeNoMinimoDoisPontosMenorQueASua()
    {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 5, 100000000);
        MeioCampo meioCampo = new MeioCampo("Cristiano Ronaldo", 25, null, 10, "CONSERVADOR", 800500);

        boolean foiPossivelNegociar = negociacao.negociar(clube, meioCampo);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmMeioCampoComUmClubeQueTemReputacaoHistoricaUmPontoMenorQueASua()
    {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 9, 100000000);
        MeioCampo meioCampo = new MeioCampo("Cristiano Ronaldo", 35, null, 10, "CONSERVADOR", 800500);

        boolean foiPossivelNegociar = negociacao.negociar(clube, meioCampo);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmMeioCampoComUmClubeQueTemReputacaoHistoricaMenorUm()
    {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 0, 100000000);
        MeioCampo meioCampo = new MeioCampo("Cristiano Ronaldo", 35, null, 10, "CONSERVADOR", 800500);

        boolean foiPossivelNegociar = negociacao.negociar(clube, meioCampo);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void seApetiteFinanceiroForIndiferenteNaoMudaOValorDeCompra()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, "INDIFERENTE", 1000, 0);

        int valorEsperado = 1000;

        Assert.assertEquals(valorEsperado, goleiro.getValorDeCompra(), 0.01);
    }

    @Test
    public void seApetiteFinanceiroForConservadorAumentaOValorDeCompraEm40PorCento()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, "CONSERVADOR", 1000, 0);

        int valorEsperado = 1400;

        Assert.assertEquals(valorEsperado, goleiro.getValorDeCompra(), 0.01);
    }

    @Test
    public void seApetiteFinanceiroForMercenarioAumentaOValorDeCompraEm80PorCento()
    {
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, "MERCENARIO", 1000, 0);

        int valorEsperado = 1800;

        Assert.assertEquals(valorEsperado, goleiro.getValorDeCompra(), 0.01);
    }

    @Test
    public void deveDiminuirPrecoDoZagueiroSeTiverMaisQue30Anos()
    {
        Zagueiro zagueiro = new Zagueiro("Marcelo Grohe", 33, null, 8, "INDIFERENTE", 1000);

        int valorEsperado = 800;

        Assert.assertEquals(valorEsperado, zagueiro.getValorDeCompra(), 0.01);
    }

    @Test
    public void naoDeveDiminuirPrecoDoZagueiroSeTiverMaisQue30Anos()
    {
        Zagueiro zagueiro = new Zagueiro("Marcelo Grohe", 28, null, 8, "INDIFERENTE", 1000);

        int valorEsperado = 1000;

        Assert.assertEquals(valorEsperado, zagueiro.getValorDeCompra(), 0.01);
    }

    @Test
    public void deveDiminuirPrecoDoLateralSeTiverMaisQue28Anos()
    {
        Lateral lateral = new Lateral("Marcelo Grohe", 33, null, 8, "INDIFERENTE", 1000, 0);

        int valorEsperado = 700;

        Assert.assertEquals(valorEsperado, lateral.getValorDeCompra(), 0.01);
    }

    @Test
    public void naoDveDiminuirPrecoDoLateralSeTiverMenosQue28Anos()
    {
        Lateral lateral = new Lateral("Marcelo Grohe", 25, null, 8, "INDIFERENTE", 1000, 0);

        int valorEsperado = 1000;

        Assert.assertEquals(valorEsperado, lateral.getValorDeCompra(), 0.01);
    }
}
