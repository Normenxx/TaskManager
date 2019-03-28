import java.util.GregorianCalendar;
import java.util.Calendar;
public class Aufgabe
{
  private String aufgabentext;
  private final GregorianCalendar datumErstellung;

  public Aufgabe(String aufgabentext)
  {
    this.aufgabentext = aufgabentext;
    this.datumErstellung = new GregorianCalendar();
  }

  public String getAufgabenText()
  {
    return this.aufgabentext;
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

  public void abgelaufenDeadline()
	{
    System.out.println("Fehler");
  }

  @Override
  public String toString()
  {
    return "Erstelldatum: " + datumErstellung.get(Calendar.DAY_OF_MONTH)+"."+datumErstellung.get(Calendar.MONTH)+"."+ datumErstellung.get(Calendar.YEAR) + " Text: " + aufgabentext;
  }
}
