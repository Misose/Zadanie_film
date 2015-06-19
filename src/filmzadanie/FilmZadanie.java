/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filmzadanie;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author R7
 */
public class FilmZadanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        System.out.println("Aktualny cas: " + Film.ft.format(new Date()));



        //citanie JSONU
        JSONParser parser = new JSONParser();
        try {
            Object obj2 = parser.parse(new FileReader(args[0]));

            JSONObject jsonObject1 = (JSONObject) obj2;

            JSONArray slideContent = (JSONArray) jsonObject1.get("Filmy");

            Film[] filmy = new Film[slideContent.size()]; // vytvorenie pola objektov podla poctu filmov

            if (!(slideContent == null)) //ak neexistuje ziaden zaznam, teoreticky osetrit treba aj pre kazdu premennu.. ale predpokladm ze *.json je OK
            {
                Iterator i = slideContent.iterator();
                int poradie_cyklu = 0;
                while (i.hasNext()) {
                    JSONObject slide = (JSONObject) i.next();
                    //  String title = (String) slide.get("title");
                    int ID_filmu = (int) (long) slide.get("ID_filmu");
                    String Nazov_filmu = (String) slide.get("Nazov_filmu");
                    int Dlzka_trvania = (int) (long) slide.get("Dlzka_trvania");
                    String Jednoduchy_popis = (String) slide.get("Jednoduchy_popis");

                    Date Datum_posledneho_pozicania = Film.ft.parse((String) slide.get("Datum_posledneho_pozicania"));

                    Date Datum_posledneho_vratenia = null;

                    Datum_posledneho_vratenia = Film.ft.parse((String) slide.get("Datum_posledneho_vratenia"));

                    boolean Je_pozicany = (boolean) slide.get("Je_pozicany");

                    filmy[poradie_cyklu] = new Film(ID_filmu, Nazov_filmu, Dlzka_trvania, Jednoduchy_popis, Datum_posledneho_vratenia, Je_pozicany);
                    poradie_cyklu++;

                }


            }
            //koniec citania JSONU
            GuiFrame gui = new GuiFrame(filmy); // vytvorenie GUI
            gui.setVisible(true); //zobrazenie gui

        } catch (FileNotFoundException e) { //obidenie chyby programu
            e.printStackTrace();
            System.out.println("Nenaslo zadany subor, spusti program znova " + args[0]);

        } catch (IOException e) {
            e.printStackTrace();



        } catch (ParseException e) {
            e.printStackTrace();


        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
            System.out.println("Problem s priradenim datumu z json");

        }






    }
}
