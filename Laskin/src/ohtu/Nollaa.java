package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 9;
    }
    
    @Override
    public void suorita() {
        this.edellinen = Integer.parseInt(tuloskentta.getText());
        sovellus.nollaa();
        tuloskentta.setText("" + sovellus.tulos());
    }
    
    @Override
    public void peru() {
        tuloskentta.setText("" + this.edellinen);
    }
    
}
