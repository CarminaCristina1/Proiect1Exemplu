import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Meniu {
    //constanta pentru modul de inchidere
    private static final int EXIT_ON_CLOSE = 0;
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // Creăm o listă pentru a stoca obiectele Store
        List<Store> magazine = new ArrayList<>();

        //setarea informatiilor in obiect
	    Store st = new Store(denumire, culoare , pret);
	    st.setDenumire(denumire);
	    st.setCuloare(culoare);
	    st.setPret(pret);
    //in partea din stanga se declara o variabila "st" de tip referinta 
    //si se stocheaza adresa unui obiect, in partea din dreapta se 
    //creeaza un obiect de tip "Store" unde se aloca in memoria heap

	int meniu = input.nextInt();

        // Meniu principal
        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Introducere articol");
            System.out.println("2. Sortare alfabetică");
            System.out.println("3. Sortare după preț");
            System.out.println("4. Afișare articole");
            System.out.println(EXIT_ON_CLOSE + ". Ieșire");

            int optiune = input.nextInt();

            switch (optiune) {
                case 1:
                    // Introducere articol
                    System.out.println("Introduceti denumirea articolului: ");
                    String name = input.next();

                    System.out.println("Introduceti culoarea: ");
                    String color = input.next();

                    System.out.println("Introduceti pretul: ");
                    int price = input.nextInt();

                    Store store = new Store(name, color, price);
                    magazine.add(store);
                    break;
                case 2:
                    // Sortare alfabetică
                    Collections.sort(magazine, Comparator.comparing(Store::getName));
                    break;
                case 3:
                    // Sortare după preț
                    Collections.sort(magazine, Comparator.comparingInt(Store::getPrice));
                    break;
                case 4:
                    // Afișare articole
                    for (Store s : magazine) {
                        System.out.println(s.toString());
                    }
                    break;
                case EXIT_ON_CLOSE:
                    System.out.println("La revedere!");
                    System.exit(0);
                default:
                    System.out.println("Ati introdus tasta gresita ! Va rugam incercati din nou!");
            }
        }
    }
}