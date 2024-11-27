public class Main {
    public static void main(String[] args) {
        /* istanzio tutti gli oggetti */
        Punto puntoA = new Punto();
        Punto puntoC = new Punto();
        Rettangolo rettangolo = null;
        int deltaX = 2, deltaY = 5;

        /* istanzio gli oggetti per l'esecuzione del codice,
        * gestendo eventuali eccezioni */
        try {
            puntoA = new Punto(2,3);
            puntoC = new Punto(-2,7);
            rettangolo = new Rettangolo(puntoA, puntoC);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /* ora stampo i quadranti in cui si trovano i punti
        * indicati */
        try{
            System.out.println("Il punto A si trova nel "+puntoA.getQuadrante()+"^ quadrante");
            System.out.println("Il punto C si trova nel "+puntoC.getQuadrante()+"^ quadrante");
            System.out.println(rettangolo.toString());
            rettangolo.stampaRettangolo();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /* effetto la traslazione */
        try{
            rettangolo.traslaRettangolo(deltaX, deltaY);
            System.out.println("Il rettangolo è stato traslato");
            System.out.println(rettangolo.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
