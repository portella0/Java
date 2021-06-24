import java.util.Map;
import java.util.TreeMap;

public class Dicionario
{
    Map<String, String> mapaIngles = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    Map<String, String> mapaPortugues = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario)
    {
        switch (dicionario)
        {
            case INGLES:
                mapaIngles.put(palavra, traducao);
                break;
            case PORTUGUES:
                mapaPortugues.put(palavra, traducao);
                break;
            default:
                throw new IllegalArgumentException("Isso não deve acontecer");
        }
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca)
    {
        String traducao = "";

        switch (dicionarioDeBusca)
        {
            case INGLES:
                if(mapaIngles.get(palavra) == null)
                {
                   throw new PalavraNaoEncontradaException();
                }
                else
                {
                    traducao = mapaIngles.get(palavra);
                }
                break;

            case PORTUGUES:
                if(mapaPortugues.get(palavra)== null)
                {
                    throw new PalavraNaoEncontradaException();
                }
                else
                {
                    traducao = mapaPortugues.get(palavra);
                }
                break;
            default:
                throw new IllegalArgumentException("Isso não deve acontecer");
        }

        return traducao;
    }
}
