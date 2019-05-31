import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Gerador {

    private static String[] nomes = {"Miguel", "Sophia", "Davi", "Alice", "Arthur", "Julia", "Pedro", "Isabella", "Gabriel", "Manuela", "Bernardo", "Laura", "Lucas", "Luiza", "Matheus", "Valentina", "Rafael", "Giovanna", "Heitor", "Maria Eduarda", "Enzo", "Helena", "Guilherme", "Beatriz", "Nicolas", "Maria Luiza", "Lorenzo", "Lara", "Gustavo", "Mariana", "Felipe", "Nicole", "Samuel", "Rafaela", "João Pedro", "Heloísa", "Daniel", "Isadora", "Vitor", "Lívia", "Leonardo", "Maria Clara", "Henrique", "Ana Clara"};
    private static String[] sobrenomes = {"Almeida", "Alves", "Andrade", "Barbosa", "Batista", "Borges", "Campos", "Cardoso", "Carvalho", "Castro", "Costa", "Dias", "Duarte", "Freitas", "Fernandes", "Ferreira", "Garcia", "Gomes", "Gonçalves", "Lima", "Lopes", "Machado", "Marques", "Martins", "Medeiros", "Melo", "Mendes", "Miranda", "Monteiro", "Moraes", "Moreira", "Moura", "Nascimento"};

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <= 50; i++)
            System.out.printf("INSERT INTO funcionario (idfuncionario, nome, carteiratrabalho, dataContratacao, salario) VALUES (%d, \'%s\', %d, \'%s\', %.2f);\n", i, getNome(random), Integer.parseInt(geraCarteiraTrabalho()), geraDataContratacao(), (random.nextInt(30000) / 4.0) + 1000);
        for (int i = 1; i <= 50; i++)
            System.out.printf("INSERT INTO diretor (iddiretor, nome) VALUES (%d, \'%s\');\n", i, getNome(random));
    }

    private static String getNome(Random random) {
        return nomes[random.nextInt(nomes.length - 1)] + " " + sobrenomes[random.nextInt(sobrenomes.length - 1)];
    }

    public static String geraCarteiraTrabalho() {
        Random random = new Random();
        return "" + random.nextInt(9) + "" + random.nextInt(9) + "" + random.nextInt(9) + "" + random.nextInt(9) + "" + random.nextInt(9) + "" + random.nextInt(9) + "";
    }

    public static String geraDataContratacao() {
        Random random = new Random();
        String format = LocalDate.of(random.nextInt(20) + 2019 - 20, random.nextInt(11) + 1, random.nextInt(27) + 1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return format;
    }
}
