package personale;

public class Docente extends Dipendente{
    protected String disciplina;

    public Docente(String nominativo, char genere, String indirizzo, String disciplina) {
        super(nominativo, genere, indirizzo, Docente.class.getSimpleName());
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String upperIndirizzo(){
        return super.getIndirizzo().toUpperCase();
    }

    @Override
    public double getIncentivo(){
        return super.getIncentivo()*2;
    }

    @Override
    public String toString() {
        return String.format("%s\nMateria: %s", super.toString(), this.getDisciplina());
    }
}
