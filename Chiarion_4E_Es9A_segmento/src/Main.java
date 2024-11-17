public class Main {
    public static void main(String[] args) {
        /* istanzio tutti gli oggetti */
        Punto puntoA = new Punto();
        Punto puntoB = new Punto();
        Punto puntoC = new Punto();
        Punto puntoD = new Punto();
        Punto puntoO = new Punto();
        Segmento segmento = null;

        /* istanzio gli oggetti per l'esecuzione del codice,
        * gestendo eventuali eccezioni */
        try {
            puntoA = new Punto(2,3);
            puntoB = new Punto(-4, 2);
            puntoC = new Punto(-3,-9);
            puntoD = new Punto(5,-6);
            puntoO = new Punto(0,0);
            segmento = new Segmento(puntoA, puntoB);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /* ora stampo i quadranti in cui si trovano i punti
        * indicati */
        try{
            System.out.println("Il punto A si trova nel "+puntoA.getQuadrante()+"^ quadrante");
            System.out.println("Il punto B si trova nel "+puntoB.getQuadrante()+"^ quadrante");
            System.out.println("Il punto C si trova nel "+puntoC.getQuadrante()+"^ quadrante");
            System.out.println("Il punto D si trova nel "+puntoD.getQuadrante()+"^ quadrante");
            System.out.println("Il punto O si trova nel "+puntoO.getQuadrante()+"^ quadrante");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /* ora stampo le indicazioni relative al segmento */
        try{
            System.out.println(segmento.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
