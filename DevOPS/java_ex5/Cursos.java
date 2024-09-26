import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cursos {
    private final int MAX_CURSOS = 50; // Limite máximo de cursos
    public Map<String, Aluno> alunos = new HashMap<>();

    public Cursos() {
        // Inicializa o dicionário com alunos
        alunos.put("Pedro", new Aluno("Pedro", "Basic", 1, 0, 0));
        alunos.put("Maria", new Aluno("Maria", "Basic", 1, 0, 0));
        alunos.put("João", new Aluno("João", "Basic", 1, 0, 0));
    }

    public void setCursosConcluidos(String nome, int concluidos) {
        if (alunos.containsKey(nome)) {
            Aluno aluno = alunos.get(nome);

            if (concluidos > MAX_CURSOS) {
                concluidos = MAX_CURSOS;
            }

            aluno.cursosRealizados = concluidos;

            if (aluno.cursosRealizados >= 12) {
                aluno.assinatura = "Premium";

            }
            if (aluno.cursosRealizados >= 1) {
                aluno.cursosDisponiveis = (aluno.cursosRealizados * 3) + 1;
            }
            if (aluno.cursosDisponiveis >= MAX_CURSOS) {
                aluno.cursosDisponiveis = MAX_CURSOS;
                System.out.println("\nO aluno " + nome + " concluiu todos os cursos disponíveis");
            }
            showStatus();
        }
    }

    // Método para um aluno concluir um curso
    public void concluirCurso(String nome, float nota) {
        if (alunos.containsKey(nome)) {
            Aluno aluno = alunos.get(nome);

            if (aluno.cursosDisponiveis > 0) {

                if (nota >= 7) {
                    if (aluno.cursosRealizados == MAX_CURSOS) {
                        System.out.println("\nO aluno " + nome + " já concluiu todos os cursos disponiveis");
                        aluno.setAssinatura("Premium");
                    } else {
                        aluno.cursosRealizados++;
                        // Incrementa cursos disponíveis até o máximo permitido
                        if (aluno.cursosDisponiveis + 3 <= MAX_CURSOS) {
                            aluno.cursosDisponiveis += 3;
                        } else {
                            aluno.cursosDisponiveis = MAX_CURSOS;
                        }

                        // Verifica se aluno passou para assinatura Premium
                        if (aluno.cursosRealizados >= 12) {
                            aluno.setAssinatura("Premium");
                        }
                        System.out.println("\n" + nome + " concluiu um curso com nota " + String.format("%.2f", nota)
                                + " e possui " + aluno.cursosDisponiveis + " cursos disponiveis");
                    }
                } else {
                    System.out.println("Nota insuficiente para aprovação no curso! " + String.format("%.2f", nota)
                            + " de 7.00");
                }
            } else {
                System.out.println(nome + " não tem cursos disponíveis para concluir.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método para mostrar o status de todos os alunos
    public void showStatus() {
        System.out.println();
        for (Map.Entry<String, Aluno> entry : alunos.entrySet()) {
            Aluno aluno = entry.getValue();
            System.out
                    .println("Nome: " + entry.getKey() + ", Assinatura: " + aluno.assinatura + ", Cursos disponíveis: "
                            + aluno.cursosDisponiveis + ", Cursos realizados: " + aluno.cursosRealizados +
                            ", Foruns Escritos: " + aluno.forunsEscritos);
        }
    }

    // Classe Aluno para armazenar informações dos alunos
    public static class Aluno {
        String nome;
        String assinatura;
        int cursosDisponiveis;
        int cursosRealizados;
        int forunsEscritos;

        private Aluno(String nome, String assinatura, int cursosDisponiveis, int cursosRealizados, int forunsEscritos) {
            this.nome = nome;
            this.assinatura = assinatura;
            this.cursosDisponiveis = cursosDisponiveis;
            this.cursosRealizados = cursosRealizados;
            this.forunsEscritos = forunsEscritos;
        }

        private void setAssinatura(String assinatura) {
            this.assinatura = assinatura;
        }

    }

    // Gerenciador de Fórum para premiar os alunos
    public static class ForumManager {
        public Cursos cursos;

        public ForumManager(Cursos cursos) {
            this.cursos = cursos;
        }

        public void forumEscito(String aluno) {
            Aluno forumEscrito = cursos.alunos.get(aluno);
            if (forumEscrito != null) {

                forumEscrito.forunsEscritos++;
            }
        }

        // Método para premiar o aluno que escreveu mais tópicos
        public void alunoVencedor() {
            List<Aluno> ganhadores = new ArrayList<>();
            int maxForuns = 0;

            // Itera sobre todos os alunos para encontrar o maior número de fóruns escritos
            for (Map.Entry<String, Aluno> entry : cursos.alunos.entrySet()) {
                Aluno aluno = entry.getValue();

                if (aluno.forunsEscritos > maxForuns) {
                    maxForuns = aluno.forunsEscritos;
                    ganhadores.clear(); // Limpa a lista de ganhadores, pois encontramos um novo valor máximo
                    ganhadores.add(aluno);
                } else if (aluno.forunsEscritos == maxForuns) {
                    ganhadores.add(aluno); // Adiciona o aluno que tem o mesmo número máximo de fóruns escritos
                }
            }

            // Premia todos os ganhadores
            if (!ganhadores.isEmpty()) {
                System.out.println();
                for (Aluno ganhador : ganhadores) {
                    if (ganhador.cursosDisponiveis == cursos.MAX_CURSOS) {
                        System.out.println("\n O aluno " + ganhador.nome + " já possui todos os cursos disponíveis");
                    } else {
                        ganhador.cursosDisponiveis++;
                        System.out
                                .println(ganhador.nome + " ganhou um curso extra! Total de cursos disponíveis: "
                                        + ganhador.cursosDisponiveis);
                    }
                }
            } else {
                System.out.println("Nenhum aluno encontrado.");
            }
        }
    }
}
