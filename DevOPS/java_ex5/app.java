public class App {
    public static void main(String[] args) {

        Cursos cursos = new Cursos();
        Cursos.ForumManager forumManager = new Cursos.ForumManager(cursos);

        // Simula alunos concluindo cursos
        cursos.concluirCurso("Pedro", 8.565f);

        cursos.concluirCurso("Pedro", 6f);
        cursos.concluirCurso("Pedro", 10f);


        // Mostra status antes de premiar
        cursos.showStatus();

        // Adicona um forum escrito para o aluno
        forumManager.forumEscito("João");
        forumManager.forumEscito("João");
        forumManager.forumEscito("Pedro");
        forumManager.forumEscito("Maria");
        forumManager.forumEscito("Maria");

        // Exibe os alunos com o maior numero de foruns Escritos
        forumManager.alunoVencedor();
        // Mostra status após premiação
        cursos.showStatus();

        // Degine a quantidade de cursos que o aluno fez > se passar do maximo
        // disponivel, atribui a quantidade maxima de cursos disponiveis
        cursos.setCursosConcluidos("João", 51);
    }
}
