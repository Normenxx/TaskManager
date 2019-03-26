import java.util.GregorianCalendar;
public class AufgabeMitDeadline extends Aufgabe
{
	private GregorianCalendar deadline;

	public AufgabeMitDeadline(String aufgabentext, int YEAR, int MONTH, int DAY)
	{
		super(aufgabentext);
		this.deadline = new GergorianCalendar(YEAR,MONTH,DAY);
	}

	public GregorianCalendar getDeadline()
	{
		return this.deadline;
	}

	public String getDeadlineString()
	{
		return this.deadline.toString();
	}

	public void setDeadline(GregorianCalendar neueDeadline)
	{
		this.deadline = neueDeadline;
	}

	public void setDeadline(int YEAR, int MONTH, int DAY)
	{
		this.deadline = new GergorianCalendar(YEAR,MONTH,DAY);
	}

	public void abgelaufenDeadline()
	{
		GregorianCalendar jetzt = new GregorianCalendar();
		if (deadline.compareTo(jetzt) > 0)
		{
			System.out.println(this.getAufgabenText().toUpperCase());
		}
	}

	@Override
	public String toString()
	{
		return super.toString() + " Deadline: " + deadline.toString();
	}
}
