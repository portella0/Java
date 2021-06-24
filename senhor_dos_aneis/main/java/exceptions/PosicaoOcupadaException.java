package exceptions;

public class PosicaoOcupadaException extends RuntimeException
{
    public PosicaoOcupadaException()
    {
        super("Ja existe um personagem na posicao");
    }
}
