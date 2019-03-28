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

  public List<Aufgabe> getAufgaben()
  {
    return this.aufgaben;
  }

  public void addAufgabe(String aufgabentext)
  {
    Aufgabe neueAufgabe = new Aufgabe(aufgabentext);
    this.aufgaben.add(neueAufgabe);
  }

  public void addAufgabe(String aufgabentext, int YEAR, int MONTH, int DAY)
  {
    AufgabeMitDeadline neueAufgabe = new AufgabeMitDeadline(aufgabentext,YEAR,MONTH,DAY);
    this.aufgaben.add(neueAufgabe);
  }

  public void removeAufgabe(int index)
  {
    this.aufgaben.remove(index);
  }

  public String aufgabeSuchen(String gesucht)
  {
    String returnstring = "";

    for(Aufgabe A : this.aufgaben)
    {
      if(A.getAufgabenText().contains(gesucht))
      {
        returnstring = returnstring + buildString(A);
      }
    }
    return returnstring;
  }

  @Override
  public String toString()
  {
    String returnstring = "";

    for(Aufgabe A : this.aufgaben)
    {
      returnstring = returnstring + buildString(A);
    }

    return returnstring;
  }

  private String buildString(Aufgabe A)
  {
    return "\nKalender: " + this.name + " AufgabeID: (" + this.aufgaben.indexOf(A) + ") " + A.toString();
  }
}
