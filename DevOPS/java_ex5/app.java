public class app {
    public static void main(String[] args) {
        
        Cursos cursos = new Cursos();
        
        System.out.println("Assinatura premium? " + cursos.isAssinaturaPremium());

        cursos.setNota(7.8f);
        System.out.println("Assinatura premium? " + cursos.isAssinaturaPremium());

        cursos.setNota(6.8f);
        System.out.println("Assinatura premium? " + cursos.isAssinaturaPremium());
        
    }
}
