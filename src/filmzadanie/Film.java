/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filmzadanie;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author R7
 */
public class Film {
    //definovanie potrebnych parametrov (premennych)
    //a ich funkcie, set, get

    private int ID_filmu;
    private String Nazov_filmu;
    private int Dlzka_trvania;
    private String Jednoduchy_popis;
    private Date Datum_posledneho_pozicania;
    private Date Datum_posledneho_vratenia;
    private boolean Je_pozicany;
    // definovanie triedy datumu
    private Date Cas;
    // definovanie formatu casu
    public static SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    //constructor definovanie hodnot premennych
    public Film(int ID_filmu, String Nazov_filmu, int Dlzka_trvania, String Jednoduchy_popis, /*Date Datum_posledneho_pozicania,*/ Date Datum_posledneho_vratenia, boolean Je_pozicany) //Funkcia nastavenia jednotlivých parametrov okrem posledného požičania - void
    {
        //nastavenie jednotlivych parametrov zo vstupu    
        this.ID_filmu = ID_filmu;
        this.Nazov_filmu = Nazov_filmu;
        this.Dlzka_trvania = Dlzka_trvania;
        this.Jednoduchy_popis = Jednoduchy_popis;
        //this.Datum_posledneho_pozicania=Datum_posledneho_pozicania;
        this.Datum_posledneho_vratenia = Datum_posledneho_vratenia;
        this.Je_pozicany = Je_pozicany;

    }

    //  Metoda požičania – nastaví, dátum posledného požičania a hodnotu, či je požičaný – vráti true/false, podľa toho či je možné tento film požičať
    public boolean Funkcia_pozicania(Date Datum_posledneho_pozicania) //Funkcia nastavenia jednotlivých parametrov okrem posledného požičania - void
    {
        //nastavenie jednotlivych parametrov zo vstupu    
        this.Datum_posledneho_pozicania = Datum_posledneho_pozicania;
        if (!this.Je_pozicany) //kontrola ci sa da pozicat
        {
            this.Je_pozicany = true;
            return true;    //znamena ze sa da pozicat
        } else {
            return false; //znamena ze sa neda pozicat

        }

    }

    public long Funkcia_vratenia(Date Datum_posledneho_vratenia) //Funkcia nastavenia jednotlivých parametrov okrem posledného požičania - void
    {
        long pocet_dni = 0;
        final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        //nastavenie jednotlivych parametrov zo vstupu    
        this.Datum_posledneho_vratenia = Datum_posledneho_vratenia;

        if (this.Je_pozicany) {
            this.Je_pozicany = false;

            if (!(this.Datum_posledneho_pozicania == null)) {
                return (this.Datum_posledneho_vratenia.getTime() - this.Datum_posledneho_pozicania.getTime()) / DAY_IN_MILLIS; //definovanie datum_posledneho_vratenia-datum_posledneho_pozicania
            } else {
                return -1;
            }

        } else {
            return -1;
        }

    }

    public int get_Film_ID_filmu() {
        return this.ID_filmu;

    }

    public String get_Film_Nazov_filmu() {
        return this.Nazov_filmu;

    }

    public int get_Film_Dlzka_trvania() {
        return this.Dlzka_trvania;

    }

    public String get_Film_Jednoduchy_popis() {
        return this.Jednoduchy_popis;

    }

    public Date get_Film_Datum_posledneho_pozicania() {
        return this.Datum_posledneho_pozicania;

    }

    public Date get_Film_Datum_posledneho_vratenia() {
        return this.Datum_posledneho_vratenia;

    }

    public boolean get_Film_Je_pozicany() {
        return this.Je_pozicany;

    }
}
