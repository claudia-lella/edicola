import java.util.Scanner;


public class Publications1 {
    
    /* ---------- FIELDS ---------- */
    
    private String name = " - inserire il nome della pubblicazione - ";
    private double price = 0.0;
    private double premium = 0.0; 
    private int received = 0;
    private int sold = 0;
    Scanner text = new Scanner(System.in);
    Scanner number = new Scanner(System.in);


    /* ---------- METHODS ---------- */

    /* ---- ENCAPSULATION ---- */

    /* name */
    public void setName(String name) {

        boolean repeat = true;

        /* rule: name.length > 2 */

        do {    
        
            if (name.length() > 2) {

                this.name = name;
                repeat = false;

            } else if (name.length() <= 2 ) {

                System.out.println("Nome non valido, non poò essere minore di tre caratteri.");
                System.out.print("Aggiungere il nome della pubblicazione: ");
                name = text.nextLine();
            }
        
        } while (repeat);
    }

    public String getName() {
        return name;
    }

    /* price */
    public void setPrice(double price) {

        boolean repeat = true;

        /* rule: price > 0 */

        do {    
        
            if (price > 0) {

                this.price = price;
                repeat = false;

            } else if (price <= 0) {

                System.out.println("Prezzo non valido, non può essere minore o uguale a zero.");
                System.out.print("Aggiungere il prezzo della pubblicazione: ");
                price = number.nextDouble();
            }
        
        } while (repeat);
    }

    public double getPrice() {
        
        return price;
    }

    /* premium */
    public void setPremium(double premium) {

        boolean repeat = true;

        /* rule: price > 0 */

        do {    
        
            if (premium >= 0.05 && premium <= 0.2) {

                this.premium = premium;
                repeat = false;

            } else if (premium < 0.05 || premium > 0.2) {

                    System.out.println("Aggio non valido, deve essere compreso fra 0,05 e 0,20.");
                    System.out.println("Inserire l'aggio della pubblicazione (range: 0,05 - 0,20) (es. 0,1 per 10%): ");
                    premium = number.nextDouble();
            }
        
        } while (repeat);
    }

    public double getPremium() {
        return premium;
    }

    /* received */
    public void setReceived(int received) {
        boolean repeat = true;

        /* rule: received > 0 */

        do {    
        
            if (received > 0) {

                this.received = received;
                repeat = false;

            } else if (received <= 0) {

                System.out.println("Numero di pubblicazioni ricevute non valido, non può essere minore o uguale a zero.");
                System.out.print("Aggiungere il numero di pubblicazioni ricevute: ");
                received = number.nextInt();
            }
        
        } while (repeat);
    }

    public int getReceived() {
        return received;
    }

    /* sold */
    public void setSold(int sold) {
        boolean repeat = true;

        /* rule: sold > 0 */

        do {    
        
            if (sold >= 0 && sold <= getReceived()) {

                this.sold = sold;
                repeat = false;

            } else if (sold < 0 || sold > getReceived()) {

                System.out.println("Numero di pubblicazioni vendute non valido, non può essere minore di zero o maggiore delle copie ricevute.");
                System.out.print("Aggiungere il numero di pubblicazioni vendute: ");
                sold = number.nextInt();
            }
        
        } while (repeat);
    }

    public int getSold() {
        return sold;
    }

    /* ---- ENCAPSULATION END ---- */

    /* add publications */
    public void addPublication() {

        System.out.print("Aggiungere il nome della pubblicazione: ");
        setName(text.nextLine());

        System.out.print("Aggiungere il prezzo della pubblicazione: ");
        setPrice(number.nextDouble());

        System.out.print("Inserire l'aggio della pubblicazione (range: 0,05 - 0,20) (es. 0,1 per 10%): ");
        setPremium(number.nextDouble());

        System.out.print("Aggiungere il numero di pubblicazioni ricevute: ");
        setReceived(number.nextInt());

        System.out.print("Aggiungere il numero di pubblicazioni vendute: ");
        setSold(number.nextInt());

        System.out.println(" - Check - ");
        System.out.println("Pubblicazione: " + getName() + "inserita correttamente");
    }

}
