import java.util.GregorianCalendar;
public class Aufgabe {
  private String aufgabentext;
  private GregorianCalendar datumErstellung;

	public Aufgabe()
  {
    datumErstellung = new GregorianCalendar();
	}

  public String getAufgabenText()
  {
    return aufgabentext;
  }

  public void setAufgabenText(String text)
  {
    aufgabentext = text;
  }

  public GregorianCalendar getDatumErstellung()
  {
    return datumErstellung;
  }
}
