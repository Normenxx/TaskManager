import java.util.GregorianCalendar;
import java.util.Calendar;
public class AufgabeMitDeadline extends Aufgabe
{
	private GregorianCalendar deadline;

	public AufgabeMitDeadline(String aufgabentext, int YEAR, int MONTH, int DAY)
	{
		super(aufgabentext);
		this.deadline = new GregorianCalendar(YEAR,MONTH,DAY);
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
		this.deadline = new GregorianCalendar(YEAR,MONTH,DAY);
	}

	@Override
	public void abgelaufenDeadline()
	{
		GregorianCalendar jetzt = new GregorianCalendar();
		if (deadline.compareTo(jetzt) < 0)
		{
			System.out.println(this.getAufgabenText().toUpperCase());
		}
	}

	@Override
	public String toString()
	{
		return super.toString() + " Deadline: " +deadline.get(Calendar.DAY_OF_MONTH)+"."+deadline.get(Calendar.MONTH)+"."+deadline.get(Calendar.YEAR);
	}
}
