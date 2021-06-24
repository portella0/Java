public class Ninja
{
    String nome;
    Jutsu jutsuPrincipal;
    int chakra = 100;

    public Ninja(String nome, Jutsu jutsuPrincipal)
    {
        this.nome = nome;
        this.jutsuPrincipal = jutsuPrincipal;
    }

    public void atacar (Ninja oponente)
    {
        chakra = chakra - jutsuPrincipal.chakra;
        oponente.receberGolpe(jutsuPrincipal.dano);
    }

    public void receberGolpe (int dano)
    {
        chakra = chakra - dano;
    }

    public int getChakra() {
        return chakra;
    }
}
