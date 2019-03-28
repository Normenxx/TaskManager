import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Kommandozeilenmenue
{

	private Scanner scan;
	private List<Kalender> alleKalender;

	public Kommandozeilenmenue()
	{
		this.scan = new Scanner(System.in);
		this.alleKalender = new ArrayList<Kalender>();
		this.alleKalender.add(new Kalender("Standard"));
	}

	public void MenueAnzeigen() {
		System.out.println("MENUE");
		System.out.println("1  ) Alle Aufgaben anzeigen");
		System.out.println("2  ) Aufgaben durchsuchen (alle Kalender)");
		System.out.println("2.1) Aufgaben durchsuchen (bestimmter Kalender)");
		System.out.println("3  ) Deadline anzeigen");
		System.out.println("4  ) Neue Aufgabe hinzufuegen");
		System.out.println("4.1) Neuer Kalender hinzufuegen");
		System.out.println("5  ) Aufgabe erledigt");
		System.out.println("5.1) Kalender Loeschen");
		System.out.println("6  ) EXIT");
	}

	public void start() {
		String s = "-";
		while (!s.equals("6")) {
			MenueAnzeigen();
			s = scan.nextLine();
			switch(s)
			{
				case "1":
				this.alleAufgabenAnzeigen();
				break;
				case "2":;
				this.aufgabeSucheAlle(getSuchbegriff());
				break;
				case "2.1":
				this.aufgabeSucheEins(getSuchbegriff());
				break;
				case "3":
				this.deadlineAnzeigen();
				break;
				case "4":
				this.aufgabeHinzufuegen();
				break;
				case "4.1":
				this.kalenderHinzufuegen();
				break;
				case "5":
				this.aufgabeErledigt();
				break;
				case "5.1":
				this.kalenderLoeschen();
				break;
				case "6":
				break;
				default:
				this.fehler();
				break;
			}
		}
		scan.close();
	}

	private void alleAufgabenAnzeigen()
	{
		for(Kalender K : alleKalender)
		{
			System.out.println(K.toString());
		}
	}

	private void aufgabeSucheAlle(String gesucht)
	{
		for(Kalender K: alleKalender)
		{
			System.out.println(K.aufgabeSuchen(gesucht));
		}
	}

	private void aufgabeSucheEins(String gesucht)
	{
		int geweahlt = kalenderWaehlen();
		System.out.println(alleKalender.get(geweahlt).aufgabeSuchen(gesucht));
	}

	private String getSuchbegriff()
	{
		System.out.println("Geben Sie einen Suchbegriff ein.");
		String suchbegriff = scan.nextLine();
		return suchbegriff;
	}

	private void deadlineAnzeigen()
	{
		for(int i = 0; i < alleKalender.size(); i++)
		{
			for(int i2 = 0; i2 < alleKalender.get(i).getAufgaben().size(); i2++)
			{
				if (alleKalender.get(i).getAufgaben().get(i2) instanceof  AufgabeMitDeadline)
				{
					AufgabeMitDeadline AMD = (AufgabeMitDeadline)alleKalender.get(i).getAufgaben().get(i2);
				  AMD.abgelaufenDeadline();
				}
			}
		}
	}

	private void aufgabeHinzufuegen()
	{
		int geweahlt = kalenderWaehlen();

		System.out.println("Geben Sie der Aufgabe einen Text:");
		String text = scan.nextLine();

		System.out.println("Moechten Sie eine Aufgabe mit einer Deadline erstellen? (1. Ja, 2. Nein)");
		int eingabe = Integer.parseInt(scan.nextLine());

		if(eingabe == 2)
		{
			alleKalender.get(geweahlt).addAufgabe(text);
		}
		else if (eingabe == 1)
		{
			System.out.println("Geben Sie das Jahr der Deadline ein:");
			int jahr = Integer.parseInt(scan.nextLine());

			System.out.println("Geben Sie den Monat der Deadline ein:");
			int monat = Integer.parseInt(scan.nextLine());

			System.out.println("Geben Sie den Tag der Deadline ein:");
			int tag = Integer.parseInt(scan.nextLine());

			alleKalender.get(geweahlt).addAufgabe(text,jahr,monat,tag);
		}
		else
		{
			System.out.println("Falsche Eingabe");
		}
	}

	private void kalenderHinzufuegen()
	{
		System.out.println("Geben Sie dem Kalender einen Namen");
		String text = scan.nextLine();
		this.alleKalender.add(new Kalender(text));
	}

	private void aufgabeErledigt()
	{
		System.out.println("Waehlen Sie einen Kalender");

		int aktKalenderInt = kalenderWaehlen();
		Kalender aktKalender = alleKalender.get(aktKalenderInt);

		System.out.println("Waehlen Sie eine Aufgabe");

		aktKalender.toString();
		aktKalender.removeAufgabe(scan.nextInt());
	}

	private void kalenderLoeschen()
	{
		System.out.println("Waehlen Sie einen Kalender");
		int geweahlt = kalenderWaehlen();
		alleKalender.remove(geweahlt);
	}

	private int kalenderWaehlen()
	{
		int auswahl = 0;
		System.out.println("Waehlen Sie einen Kalender aus:");
		boolean richtig = false;
		while (!richtig)
		{
			this.kalenderAnzeigen();
			try
			{
					auswahl = Integer.parseInt(scan.nextLine());
					if (auswahl < this.alleKalender.size() && auswahl >= 0)
					{
						richtig = true;
					}
					else
					{
						System.out.println("Geben sie einen gültigen Wert ein");
					}
			}
			catch (Exception e)
			{
					System.out.println("Geben sie einen gültigen Wert ein ");
			}
		}
		return auswahl;
	}

	private void kalenderAnzeigen()
	{
		for(int i = 0; i < alleKalender.size(); i++)
		{
			System.out.println(i + ": " + alleKalender.get(i).getName());
		}
	}

	public void fehler()
	{
		System.out.println("Bitte wählen sie einen der obigen Einträge");
	}


}
