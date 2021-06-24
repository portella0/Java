public class PalavraNaoEncontradaException extends RuntimeException
{
    public PalavraNaoEncontradaException()
    {
        super("Não encontrou a palavra");
    }
}
