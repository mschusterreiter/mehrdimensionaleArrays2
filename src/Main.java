import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Spielerverwaltung sv = new Spielerverwaltung();


    public static void main(String[] args) throws IOException {

        runTicTacToe();

        FileInAndOut fia = new FileInAndOut();

        if(fia.readFromFile().length != 0) {
            sv.setSpieler(fia.readFromFile());
        }

        boolean playing = true;
        while(playing) {
            System.out.println("========== SPIELESAMMLUNG ==========");
            System.out.println("1 - Spielen");
            System.out.println("2 - Spieler verwalten");
            System.out.println("3 - Programm beenden");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Welches Spiel wollen Sie spielen?");
                    System.out.println("1 - Schiffe versenken");
                    System.out.println("2 - 4 Gewinnt");
                    System.out.println("3 - Tic Tac Toe");
                    switch (sc.nextInt()) {
                        case 1:
                            //TODO Schiffe versenken
                            break;
                        case 2:
                            //TODO 4 Gewinnt
                            break;
                        case 3:
                            //TODO Tic Tac Toe
                            break;
                    }
                case 2:
                    System.out.println("Was wollen Sie tun?");
                    System.out.println("1 - Spieler hinzufügen");
                    System.out.println("2 - Alle Spieler anzeigen");
                    System.out.println("3 - Nach einem Spieler suchen");
                    System.out.println("4 - Spieler entfernen");

                    fall2();
                    break;
                case 3:
                    playing = false;
                    break;
            }
        }
        fia.writeToFile(sv.getSpieler());
    }

    private static void runTicTacToe() {
        TicTacToe t = new TicTacToe();
        t.move();
    }

    private static void fall2() {
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Wählen Sie einen Benutzername: ");
                sv.addSpieler(sc.next());
                break;
            case 2:
                System.out.println(sv);
                break;
            case 3:
                System.out.print("Geben Sie den Benutzername zum Suchen ein: ");
                Spieler ges = sv.getSpieler(sc.next());
                if (ges == null) {
                    System.out.println("Es wurde kein Spieler gefunden");
                } else System.out.println(ges);
                break;
            case 4:
                System.out.print("Welchen Spieler wollen Sie entfernen: ");
                sv.entferneSpieler(sc.next());
                break;
        }
    }
}
