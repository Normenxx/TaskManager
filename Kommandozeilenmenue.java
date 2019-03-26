import java.util.Scanner;
import java.util.List;

public class Kommandozeilenmenue
{

	private Scanner scan;
	private List<Kalender> alleKalender;

	public Kommandozeilenmenue()
	{
		this.scan = new Scanner(System.in);
	}

	public void MenueAnzeigen() {
		System.out.println("MENUE");
		System.out.println("1  ) Alle Aufgaben anzeigen");
		System.out.println("2  ) Aufgaben durchsuchen (alle Kalender)");
		System.out.println("2.1) Aufgaben durchsuchen (bestimmter Kalender)");
		System.out.println("3  ) Deadline anzeigen");
		System.out.println("4  ) Neue Aufgabe hinzufügen");
		System.out.println("5  ) Aufgabe erledigt");
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
				case "2":
					this.aufgabeSucheAlle(scan.nextLine());
					break;
				case "2.1":
					this.aufgabeSucheEins(scan.nextLine());
					break;
				case "3":
					this.deadlineAnzeigen();
					break;
				case "4":
					this.aufgabeHinzufuegen();
					break;
				case "5":
					this.aufgabeErledigt();
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
			K.toString();
		}
	}

	private void aufgabeSucheAlle(String gesucht)
	{
		for(Kalender K: alleKalender)
		{
			K.aufgabeSuchen(gesucht);
		}
	}

	private void aufgabeSucheEins(String gesucht)
	{
			int geweahlt = kalenderWaehlen();
		  alleKalender.get(geweahlt).aufgabeSuchen(gesucht);
	}

	private void deadlineAnzeigen()
	{
		for(int i = 0; i < alleKalender.size(); i++)
		{
			for(int i2 = 0; i2 < alleKalender.get(i).aufgaben.size(); i2++)
			{
				if (alleKalender.get(i).aufgabeng.get(i2) instanceof  AufgabeMitDeadline)
				{
					alleKalender.get(i).abgelaufenDeadline();
				}
			}
		}
	}

	private void aufgabeHinzufuegen()
	{
		int geweahlt = kalenderWaehlen();

		System.out.println("Geben Sie der Aufgabe einen Text:");
		int text = scan.nextInt();

		System.out.println("Moechten Sie eine Aufgabe mit einer Deadline erstellen? (1. Ja, 2. Nein)");
		int eingabe = scan.nextInt();

		if(eingabe == 1)
		{
				alleKalender.get(geweahlt).addAufgabe(text);
		}
		else if (eingabe == 2)
		{
			System.out.println("Geben Sie das Jahr der Deadline ein:");
			int jahr = scan.nextInt();

			System.out.println("Geben Sie den Monat der Deadline ein:");
			int monat = scan.nextInt();

			System.out.println("Geben Sie den Tag der Deadline ein:");
			int tag = scan.nextInt();

			alleKalender.get(geweahlt).addAufgabe(text,jahr,monat,tag);
		}
		else
		{
			System.out.println("Falsche Eingabe");
		}
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

	private int kalenderWaehlen()
	{
		System.out.println("Waehlen Sie einene Kalender aus:");
		this.kalenderAnzeigen();
		int auswahl = scan.nextInt();
		return auswahl;
	}

	private int kalenderAnzeigen()
	{
		for(int i = 0; i < alleKalender.size(); i++)
		{
			System.out.println(i + ": " + alleKalender.get(i).getName());
		}
	}

	public void fehler()
	{
		System.out.println("Sie kuennen nur 1,2,3,4,5 oder 6 eingeben!");
	}


}
