public class Cursos {

    private int contadorCursosConcluidos = 0; // Contador de cursos concluídos
    private int cursosDisponiveis = 1; // Inicialmente 1 curso disponível
    private final int MAX_CURSOS = 30; // Limite máximo de cursos
    private boolean assinaturaPremium = false;
    private String assinaturaAtual = "Basic";
    private float nota = 0f; // Valor padrão

    public Cursos(boolean assinaturaPremium) {
        this.assinaturaPremium = assinaturaPremium;
    }

    public Cursos() {
    }

    public void setAssinaturaPremium(boolean assinaturaPremium) {
        this.assinaturaPremium = assinaturaPremium;
        if (assinaturaPremium) {
            assinaturaAtual = "Premium";
        }
    }

    public boolean isAssinaturaPremium() {
        return assinaturaPremium;
    }

    // Método para alterar a nota
    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setCursosConcluidos(int n) {
        this.contadorCursosConcluidos = n;
        if (contadorCursosConcluidos >= 12) {
            setAssinaturaPremium(true);
        }
        if (contadorCursosConcluidos >= 1) {
            cursosDisponiveis = (contadorCursosConcluidos * 3) + 1;
        }
        if (cursosDisponiveis >= 30) {
            cursosDisponiveis = MAX_CURSOS;
        }
        showStatus();
    }

    // Método para finalizar um curso
    public void concluirCurso(float nota) {
        setNota(nota);
        if (cursosDisponiveis > 0) {
            System.out.println("\nCurso concluído com nota " + String.format("%.2f", this.nota));

            if (nota >= 7) {
                contadorCursosConcluidos++;
                System.out.println("Parabéns! Você concluiu um curso com sucesso.");

                if (contadorCursosConcluidos >= 12) {
                    setAssinaturaPremium(true);

                }

                // Aumenta a quantidade de cursos disponíveis se ainda não chegou ao máximo
                if (cursosDisponiveis + 3 <= MAX_CURSOS) {
                    cursosDisponiveis += 3;
                } else {
                    cursosDisponiveis = MAX_CURSOS; // Limita ao máximo
                }
            }

            else {
                System.out.println("Nota insuficiente para aprovação no curso! " + String.format("%.2f", this.nota)
                        + " de " + "7.00");
                System.out.println("Refaça o curso novamente para aprovação");
            }

        } else {
            System.out.println("Você não tem cursos disponíveis para concluir.");
        }

    }

    // Método para mostrar o status dos cursos
    public void showStatus() {
        System.out.println("\nCursos disponíveis: " + cursosDisponiveis);
        System.out.println("Cursos concluídos: " + contadorCursosConcluidos);
        System.out.println("Assinatura atual: " + assinaturaAtual);
    }
}
