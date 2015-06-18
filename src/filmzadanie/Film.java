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
     private int ID_filmu;
    private String Nazov_filmu;
    private Date Cas;
    
    public static SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss ");
    
    private int Dlzka_trvania;
    private String Jednoduchy_popis;
    private Date Datum_posledneho_pozicania;
    private Date Datum_posledneho_vratenia;
    private boolean Je_pozicany;
    private int testing;
    
}
