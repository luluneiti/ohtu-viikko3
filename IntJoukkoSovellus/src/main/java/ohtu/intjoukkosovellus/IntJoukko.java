package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukonLuvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukonLuvut = new int[5];
        alkioidenLkm = 0;
        this.kasvatuskoko = 5;
    }

    public IntJoukko(int kapasiteetti) {
        tarkistaKapasiteetti(kapasiteetti);
        joukonLuvut = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = 5;

    }

    public void tarkistaKapasiteetti(int kapasiteetti) throws IndexOutOfBoundsException {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        tarkistaKapasiteetti(kapasiteetti);
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatus väärin.");//heitin vaan jotain :D
        }
        joukonLuvut = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaJoukkoon(int luku) {

        if (!kuuluu(luku)) {
            if (alkioidenLkm == 0) {
                joukonLuvut[0] = luku;
                alkioidenLkm++;
            } else {
                joukonLuvut[alkioidenLkm] = luku;
                alkioidenLkm++;
            }
            if (alkioidenLkm % joukonLuvut.length == 0) {
                lisaTilaa();
            }
            return true;
        }
        return false;
    }

    public void lisaTilaa() {
        int[] vanhaTaulukko = new int[joukonLuvut.length];
        vanhaTaulukko = joukonLuvut;
        kopioiTaulukko(joukonLuvut, vanhaTaulukko);
        joukonLuvut = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(vanhaTaulukko, joukonLuvut);
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukonLuvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poistaJoukosta(int luku) {

        int kohta = poistettavanIndeksi(luku);
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                int apu = joukonLuvut[j];
                joukonLuvut[j] = joukonLuvut[j + 1];
                joukonLuvut[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    public int poistettavanIndeksi(int luku) {
        int paluu = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukonLuvut[i]) {
                joukonLuvut[i] = 0;
                paluu = i; //ku löytyy tuosta kohdasta :D

            }
        }
        return paluu;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int annaAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + joukonLuvut[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += joukonLuvut[i];
                tuotos += ", ";
            }
            tuotos += joukonLuvut[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukonLuvut[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaaJoukkoon(aTaulu[i]);
            x.lisaaJoukkoon(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaaJoukkoon(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaaJoukkoon(aTaulu[i]);
            z.poistaJoukosta(i);
        }
        return z;
    }

}
