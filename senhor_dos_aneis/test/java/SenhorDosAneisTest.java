import simulador.Simulador;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;
import mapa.Mapa;
import personagens.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SenhorDosAneisTest
{
    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|A|L| | | | | |O| |M|"
        String resultadoEsperado = "| | | | |A| | | | |L|";

        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início: "|A| |I| | | | |U|O|M|"
        // Fim:    "| | | | | | |O|M| | |"

        Aragorn aragorn = new Aragorn();
        Gimli gimli = new Gimli();
        Urukhai urukhai = new Urukhai();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(2, gimli);
        mapa.inserir(7, urukhai);
        mapa.inserir(8, orc);
        mapa.inserir(9, goblim);
        simulador.simular();
    }

    @Test
    public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|G| | | | | | | | |S|"
        String resultadoEsperado = "| | | | | | | | | |G|";

        Gandalf gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|L| | | | | | | |U|O|"
        // Fim:     "| | | | | |U| | | | |";

        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, legolas);
        mapa.inserir(8, urukhai);
        mapa.inserir(9, orc);
        simulador.simular();

    }

    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|B| | | | | | | | |U|"
        // Fim:     "| | | | |U| | | | | |";

        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, boromir);
        mapa.inserir(9, urukhai);
        simulador.simular();
    }

    @Test(expected = PersonagemJaEstaNoMapaException.class)
    public void inserirPersonagemJaNoMapa()
    {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        mapa.exibir();
        mapa.inserir(3, aragorn);
        mapa.exibir();
        mapa.inserir(9, aragorn);
        mapa.exibir();
    }

    @Test(expected = PosicaoOcupadaException.class)
    public void inserirPersonagemNaMesmaPosicao()
    {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        mapa.exibir();
        mapa.inserir(3, legolas);
        mapa.exibir();
        mapa.inserir(3, aragorn);
        mapa.exibir();
    }

    @Test(expected = PersonagemNaoEncontradoNoMapaException.class)
    public void buscarPosicaoPersonagemNaoEncontrado()
    {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        mapa.exibir();
        mapa.inserir(3, aragorn);
        mapa.exibir();
        mapa.buscarPosicao(legolas);
    }

    @Test
    public void buscarPosicao()
    {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        mapa.exibir();
        mapa.inserir(3, aragorn);
        mapa.exibir();
        int posicao = mapa.buscarPosicao(aragorn);

        assertEquals(3, posicao);
    }

    @Test
    public void buscarCasaVazia()
    {
        Mapa mapa = new Mapa();
        Personagem esperado = mapa.buscarCasa(5);

        assertNull(esperado);
    }

    @Test (expected = PersonagemNaoEncontradoNoMapaException.class)
    public void removerPersonagemNaoExistente()
    {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        mapa.remover(aragorn);
    }

    @Test
    public void deveRessucitarGandalfDepoisDeMortoENaoSaruman()
    {
        // Início:  "|G| | | | | | | | |S|"
        String resultadoEsperado = "|G| | | | | | | | | |";

        Gandalf gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();

        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);

        Personagem vazioComGandalfAindaVivo = gandalf.ressucitar();

        for(int i = 0; i<9;i++)
        {
            saruman.atacar(mapa);
        }
        Personagem personagemEsperadoGandalf = gandalf.ressucitar();
        mapa.inserir(0,personagemEsperadoGandalf);

        for(int i = 0; i<9;i++)
        {
            gandalf.atacar(mapa);
        }
        Personagem personagemEsperadoSaruman = saruman.ressucitar();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
        Assert.assertNull(personagemEsperadoSaruman);
        Assert.assertNull(vazioComGandalfAindaVivo);
    }

    @Test
    public void envelhecerHumanos()
    {
        Aragorn aragorn = new Aragorn();
        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();

        aragorn.envelhecer();
        boromir.envelhecer();
        urukhai.envelhecer();

        int consEsperadaAragorn = 59;
        int consEsperadaBoromir = 38;
        int consEsperadaUruk = 43;

        Assert.assertEquals(consEsperadaAragorn, aragorn.getConstituicao());
        Assert.assertEquals(consEsperadaBoromir,  boromir.getConstituicao());
        Assert.assertEquals(consEsperadaUruk,  urukhai.getConstituicao());
    }

    @Test
    public void testeFalaEGrunhidosDosPersonagens()
    {
        Aragorn aragorn = new Aragorn();
        String falaEsperadaAragorn = "A day may come when the courage of men fails… but it is not THIS day.";

        Boromir boromir = new Boromir();
        String falaEsperadaBoromir = "One does not simply walk into Mordor.";

        Legolas legolas = new Legolas();
        String falaEsperadaLegolas = "They're taking the Hobbits to Isengard!";
        String falaElficaEsperadaLegolas = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

        Gimli gimli = new Gimli();
        String gimliAntesDeBeber = gimli.falar();
        String falaEsperadaGimli = "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        String falaBebadoEsperadaGimli = "What did I say? He can't hold his liquor!";

        Gandalf gandalf = new Gandalf();
        String falaEsperadaGandalf = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

        Orc orc = new Orc();
        String grunhidoEsperadoOrc = "Arrrggghhh";

        Goblim goblim = new Goblim();
        String grunhidoEsperadoGoblim = "Iiisshhhh";

        Urukhai urukhai = new Urukhai();
        String falaEsperadaUruk = "Looks like meat's back on the menu boys!";
        String grunhidoEsperadoUruk = "Uuurrrrrr";

        Saruman saruman = new Saruman();
        String falaEsperadaSaruman = "Against the power of Mordor there can be no victory.";

        gimli.beber();
        gimli.beber();
        gimli.beber();

        String gimliDepoisDeBeberTresVezes = gimli.falar();

        assertEquals(falaEsperadaAragorn, aragorn.falar());
        assertEquals(falaEsperadaBoromir, boromir.falar());
        assertEquals(falaEsperadaLegolas, legolas.falar());
        assertEquals(falaElficaEsperadaLegolas, legolas.falarElfico());
        assertEquals(falaEsperadaGimli, gimliAntesDeBeber);
        assertEquals(falaBebadoEsperadaGimli, gimliDepoisDeBeberTresVezes);
        assertEquals(falaEsperadaGandalf, gandalf.falar());
        assertEquals(grunhidoEsperadoOrc, orc.grunhir());
        assertEquals(grunhidoEsperadoGoblim, goblim.grunhir());
        assertEquals(falaEsperadaUruk, urukhai.falar());
        assertEquals(grunhidoEsperadoUruk, urukhai.grunhir());
        assertEquals(falaEsperadaSaruman, saruman.falar());

    }
}
