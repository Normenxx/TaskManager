import java.util.GregorianCalendar;
public class Aufgabe
{
  private String aufgabentext;
  private final GregorianCalendar datumErstellung;

  public Aufgabe(String aufgabentext)
  {
    this.aufgabentext = aufgabentext;
    this.datumErstellung = new GregorianCalendar();
    this.erledigt = false;
  }

  public String getAufgabenText()
  {
    return this.ufgabentext;
  }

  public void setAufgabenText(String text)
  {
    this.aufgabentext = text;
  }

  public GregorianCalendar getDatumErstellung()
  {
    return this.datumErstellung;
  }

  public String getDatumErstellungString()
  {
    return this.datumErstellung.toString();
  }

  @Override
  public String toString()
  {
    return "Erstelldatum: " + datumErstellung.toString() + " Text: " + aufgabentext;
  }
}
