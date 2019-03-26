import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Kalender
{
  private String name;
  private List<Aufgabe> aufgaben;

  public Kalender(String name)
  {
    this.name = name;
    this.aufgaben = new ArrayList<Aufgabe>();
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return this.name;
  }

  public void addAufgabe(String aufgabentext)
  {
    Aufgabe neueAufgabe = new Aufgabe(aufgabentext);
    aufgaben.add(neueAufgabe);
  }

  public void addAufgabe(String aufgabentext, int YEAR, int MONTH, int DAY)
  {
    Aufgabe neueAufgabe = new AufgabeMitDeadline(aufgabentext,YEAR,MONTH,DAY);
    aufgaben.add(neueAufgabe);
  }

  public int removeAufgabe(int index)
  {
    aufgaben.remove(index);
  }

  public String aufgabeSuchen(String gesucht)
  {
    String returnstring = "";

    for(Aufgabe A : aufgaben)
    {
      if(A.getAufgabenText().contains(gesucht))
      {
        returnstring += buildString(A);
      }
    }
    return returnstring;
  }

  @Override
  public String toString()
  {
    String returnstring = "";

    for(Aufgabe A : aufgaben)
    {
      returnstring += buildString(A);
    }

    return returnstring;
  }

  private String buildString(Aufgabe A)
  {
    return "\n" + this.name + "(" + aufgaben.indexOf(A) + ") " + A.toString();
  }
}
