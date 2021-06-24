public class Batalha
{
    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja)
    {
        Ninja vencedor;

        if (primeiroNinja.nome.equals("Itachi"))
            vencedor = primeiroNinja;
        else if (segundoNinja.nome.equals("Itachi"))
            vencedor = segundoNinja;
        else
        {
            for (int i = 0; i < 3; i++) {
                primeiroNinja.atacar(segundoNinja);
                segundoNinja.atacar(primeiroNinja);
            }

            if (primeiroNinja.getChakra() >= segundoNinja.getChakra())
                vencedor = primeiroNinja;
            else
                vencedor = segundoNinja;
        }

        return vencedor;
    }
}
