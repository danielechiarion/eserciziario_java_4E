package backend;

public class PC extends ProdottoElettronico {
    private String processore;
    private int hardDisk;
    private final double COSTOUNITAHDD = 5.0;

    public PC(String codiceProdotto, double prezzo, String marca, String processore, int hardDisk) throws Exception {
        super(codiceProdotto, prezzo, marca);
        this.setProcessore(processore);
        this.setHardDisk(hardDisk);
    }

    public String getProcessore() {
        return processore;
    }

    public void setProcessore(String processore) {
        this.processore = processore;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(int hardDisk) throws Exception {
        if (hardDisk < 0) {
            throw new Exception("Memoria non valida: valore negativo inserito");
        }
        this.hardDisk = hardDisk;
    }

    public double getPrezzo() {
        return (double) hardDisk / 100 * COSTOUNITAHDD;
    }

    @Override
    public String toString() {
        return String.format("PC: %s\nProcessore: %s\tMemoria: %dGB\tPrezzo: %.2f€", super.toString(), this.processore, this.hardDisk, this.getPrezzo());
    }
}
