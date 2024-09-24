public class Cursos {

    private int contadorCursos = 0;
    private boolean assinaturaPremium = false;
    private float nota = 8f; // Valor padrão

    public Cursos(boolean assinaturaPremium) {
        this.assinaturaPremium = assinaturaPremium;
        verificarNota();
    }

    public Cursos() {
        verificarNota(); // Verifica a nota no momento da criação do objeto
    }

    public void setAssinaturaPremium(boolean assinaturaPremium) {
        this.assinaturaPremium = assinaturaPremium;
    }

    public boolean isAssinaturaPremium() {
        return assinaturaPremium;
    }

    // Método para alterar a nota
    public void setNota(float nota) {
        this.nota = nota;
        verificarNota(); // Atualiza o status da assinatura com base na nova nota
    }

    // Método que verifica se a nota é >= 7 e ativa a assinatura premium
    private void verificarNota() {
        assinaturaPremium = (nota >= 7);
    }

    public void dataScience() {
        System.out.println("Bem vindo ao curso de Data Science");
        contadorCursos++;

        if (nota >= 7) {
            System.out.println("Curso premium");
        }
    }

    public void showCounter() {
        System.out.println("Cursos: " + contadorCursos);
    }
}
