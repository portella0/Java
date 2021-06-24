package exceptions;

public class PersonagemNaoEncontradoNoMapaException extends RuntimeException
{
    public PersonagemNaoEncontradoNoMapaException()
    {
        super("Personagem nao encontrado");
    }
}
