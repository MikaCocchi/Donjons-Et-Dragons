package equipement.defence;

public class Shield extends Defence{
    public Shield() {
        setDefenceAmount(2);
        setUsageLeft(5);
        setName("Shield");
        setImage("\\_              _/\n" +
                "] --__________-- [\n" +
                "|       ||       |\n" +
                "\\       ||       /\n" +
                " [      ||      ]\n" +
                " |______||______|\n" +
                " |------..------|\n" +
                " ]      ||      [\n" +
                "  \\     ||     /\n" +
                "   [    ||    ]\n" +
                "   \\    ||    /\n" +
                "    [   ||   ]\n" +
                "     \\__||__/\n" +
                "        --");
    }
}
