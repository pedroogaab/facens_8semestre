public class app {
    public static void main(String[] args) {

        Cursos cursos = new Cursos();

        cursos.showStatus(); // Mostra o status inicial

        //Conclui o curso e ficam disponiveis mais 3 outros
        cursos.concluirCurso(7.8093f);
        cursos.concluirCurso(7.f); 

        // Reprova no curso com nota abaixo de 7
        cursos.concluirCurso(5f); 
        
        cursos.showStatus(); // Verifica o status final

        cursos.setCursosConcluidos(10); // Define a quantidade de cursos concluidos

        cursos.setCursosConcluidos(13);

    }
}
