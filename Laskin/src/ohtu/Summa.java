
package ohtu;
import javax.swing.JTextField;

public class Summa implements Komento{
private Sovelluslogiikka sovellus; private JTextField tuloskentta;private JTextField syotekentta;
private int edellinen;

    
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus=sovellus;
        this.tuloskentta=tuloskentta;
        this.syotekentta=syotekentta;
        this.edellinen=0;
    }

    @Override
    public void suorita() {
        int lisattava=Integer.parseInt(syotekentta.getText());
        this.edellinen=lisattava;
        sovellus.plus(lisattava);
        tuloskentta.setText(""+sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinen);
        tuloskentta.setText(""+sovellus.tulos());
    }
}
