

import Recursos.Recursos;
import Recursos.Agua;
import Recursos.Oxigenio;
import Recursos.Silicio;
import Recursos.Ferro;
import Recursos.Ouro;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class exploracaoEspacialTest
{
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();

        int posicaoEsperada = 3;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, recursosTatooine);

        milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteOProximoPlaneta()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        ArrayList<Recursos> recursosMustafar = new ArrayList<Recursos>();

        ArrayList<Planeta> planetas = new ArrayList<Planeta>();

        int posicaoEsperada = 4;
        Nave milleniumFalcon = new Nave(13);
        Planeta tatooine = new Planeta(4, recursosTatooine);
        Planeta mustafar = new Planeta(6, recursosMustafar);

        planetas.add(tatooine);
        planetas.add(mustafar);

        milleniumFalcon.explorar(planetas);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveAvisarQuandoAcabaOCombustivel()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();

        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, recursosTatooine);

        milleniumFalcon.explorar(tatooine);

        Assert.assertTrue(milleniumFalcon.semCombustivel);
    }

    @Test
    public void deveExplorarUmPlanetaERetornarParaOInicio()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();

        int posicaoEsperada = 0;
        Nave milleniumFalcon = new Nave(39);
        Planeta tatooine = new Planeta(4, recursosTatooine);

        milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveExplorarMaisDeUmPlanetaERetornarParaOInicio()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        ArrayList<Recursos> recursosMustafar = new ArrayList<Recursos>();

        ArrayList<Planeta> planetas = new ArrayList<Planeta>();

        int posicaoEsperada = 0;
        Nave milleniumFalcon = new Nave(69);
        Planeta tatooine = new Planeta(4, recursosTatooine);
        Planeta mustafar = new Planeta(6, recursosMustafar);

        planetas.add(tatooine);
        planetas.add(mustafar);

        milleniumFalcon.explorar(planetas);
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerColetadoRecursosDeUmPlanete()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();

        recursosTatooine.add(new Agua(180,  10));
        recursosTatooine.add(new Oxigenio( 300,  2));
        recursosTatooine.add(new Silicio( 60,  16));
        recursosTatooine.add(new Ouro( 120,  25));
        recursosTatooine.add(new Ferro( 30,  32));

        ArrayList<Recursos>  recursosEsperados = recursosTatooine;
        Nave milleniumFalcon = new Nave(20);
        Planeta tatooine = new Planeta(4, recursosTatooine);

        milleniumFalcon.explorar(tatooine);

        Assert.assertEquals(recursosEsperados, milleniumFalcon.recursos);
    }

    @Test
    public void deveTerColetadoRecursosDeMaisDeUmPlanete()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        recursosTatooine.add(new Agua(180,  10));
        recursosTatooine.add(new Oxigenio( 300,  2));
        recursosTatooine.add(new Silicio( 60,  16));
        recursosTatooine.add(new Ouro( 120,  25));
        recursosTatooine.add(new Ferro( 30,  32));

        ArrayList<Recursos> recursosMustafar = new ArrayList<Recursos>();
        recursosMustafar.add(new Agua(150,  10));
        recursosMustafar.add(new Oxigenio( 200,  2));
        recursosMustafar.add(new Silicio( 80,  16));
        recursosMustafar.add(new Ouro( 100,  25));
        recursosMustafar.add(new Ferro( 16,  32));

        ArrayList<Planeta> planetas = new ArrayList<Planeta>();
        Planeta tatooine = new Planeta(4, recursosTatooine);
        Planeta mustafar = new Planeta(6, recursosMustafar);
        planetas.add(tatooine);
        planetas.add(mustafar);

        ArrayList<Recursos>  recursosEsperados = new ArrayList<Recursos>();
        recursosEsperados.addAll(recursosTatooine);
        recursosEsperados.addAll(recursosMustafar);

        Nave milleniumFalcon = new Nave(40);

        milleniumFalcon.explorar(planetas);

        Assert.assertEquals(recursosEsperados, milleniumFalcon.recursos);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso()
    {
        int valorTotalEsperado = 0;
        Planeta tatooine = new Planeta(4, new ArrayList());

        Assert.assertEquals(valorTotalEsperado, tatooine.valorTotal());
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        recursosTatooine.add(new Agua(180,  10));
        recursosTatooine.add(new Oxigenio( 300,  2));
        recursosTatooine.add(new Silicio( 60,  16));
        recursosTatooine.add(new Ouro( 120,  25));
        recursosTatooine.add(new Ferro( 30,  32));

        int valorTotalEsperado = 690;
        Planeta tatooine = new Planeta(4, recursosTatooine);

        Assert.assertEquals(valorTotalEsperado, tatooine.valorTotal());
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso()
    {
        int valorPorPesoEsperado = 0;
        Planeta tatooine = new Planeta(4, new ArrayList());

        Assert.assertEquals(valorPorPesoEsperado, tatooine.valorPorPeso());
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        recursosTatooine.add(new Agua(180,  10));
        recursosTatooine.add(new Oxigenio( 300,  2));
        recursosTatooine.add(new Silicio( 60,  16));
        recursosTatooine.add(new Ouro( 120,  25));
        recursosTatooine.add(new Ferro( 30,  32));

        int valorPorPesoEsperado = 175;
        Planeta tatooine = new Planeta(4, recursosTatooine);

        Assert.assertEquals(valorPorPesoEsperado, tatooine.valorPorPeso());
    }

    @Test
    public void deveTerValorTotalDeRecursosColetados()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        recursosTatooine.add(new Agua(180,  10));
        recursosTatooine.add(new Oxigenio( 300,  2));
        recursosTatooine.add(new Silicio( 60,  16));
        recursosTatooine.add(new Ouro( 120,  25));
        recursosTatooine.add(new Ferro( 30,  32));

        int valorPorPesoEsperado = 690;
        Nave milleniumFalcon = new Nave(20);
        Planeta tatooine = new Planeta(4, recursosTatooine);

        milleniumFalcon.explorar(tatooine);

        Assert.assertEquals(valorPorPesoEsperado, milleniumFalcon.getValorRecursosColetados());
    }

    @Test
    public void deveTerValorPesoDeRecursosColetados()
    {
        ArrayList<Recursos> recursosTatooine = new ArrayList<Recursos>();
        recursosTatooine.add(new Agua(180,  10));
        recursosTatooine.add(new Oxigenio( 300,  2));
        recursosTatooine.add(new Silicio( 60,  16));
        recursosTatooine.add(new Ouro( 120,  25));
        recursosTatooine.add(new Ferro( 30,  32));

        int valorPorPesoEsperado = 175;
        Nave milleniumFalcon = new Nave(20);
        Planeta tatooine = new Planeta(4, recursosTatooine);

        milleniumFalcon.explorar(tatooine);

        Assert.assertEquals(valorPorPesoEsperado, milleniumFalcon.getValorPesoRecursosColetados());
    }
}
