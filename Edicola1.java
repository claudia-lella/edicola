/*
 * Questo esercizio è stato eseguito all'interno del corso di Generation Italy 
 * con l'affiancamento di Accademia del Levante. Ogni diritto è riservato.
 * 
 * Esercizio edicola
 * 
 * 23_06_19
 * 
 * Traccia base:
 * Realizzare un programma Edicola che, utilizzato dal gestore di una rivendita di riviste e quotidiani,
 * tenga conto giornalmente, per le pubblicazioni che vende:
 *      - delle copie received dal fornitore,
 *      - delle copie vendute ai clienti,
 *      - delle copie rese (received – vendute) da restituire al distributore di zona.
 * 
 * Immettendo nel programma i prezzi di copertina delle singole pubblicazioni, 
 * nonché l'aggio per ogni copia venduta (la quota di ricavato che resta all'edicolante), 
 * determinare il guadagno giornaliero del negoziante dalla somma dei guadagni dalle vendite 
 * delle pubblicazioni precedentemente inserite. 
 * 
 * Immettere i dati necessari ricorrendo alla classe Scanner1 e a un ciclo 
 * per reiterare il processo in inserimento di dati, predisponendo un criterio di uscita 
 * (per esempio nome pubblicazione X):
 *      - nomi delle pubblicazioni, a scelta tra quotidiani, riviste, fumetti, …;
 *      - quantità di copie received per ciascuna pubblicazione;
 *      - prezzo di copertina di ciascuna pubblicazione;
 *      - aggio (percentuale del prezzo di copertina trattenuto dall'edicolante per ogni copia venduta;
 *        es.: su un giornale che costa 1,50€, l'aggio del 10% fa guadagnare all'edicolante 
 *        15 centesimi per ogni copia venduta; usare aggi tipici tra il 5 e il 20%);
 *      - quantità di copie vendute a fine giornata per ciascuna pubblicazione.
 * 
 * I dati dovranno essere incapsulati al fine di ostacolare l'immissione di prezzi e numeri di copie non corretti,
 * che l'edicolante che usa il programma dev'essere invitato a inserire nuovamente. 
 * 
 * L'incapsulamento con controllo di coerenza degli input è condizione necessaria per considerare svolto l'esercizio.
 * 
 * Traccia avanzata:
 * Potenziare il programma con uno switch() dove, oltre alle funzioni di inserimento e riepilogo, 
 * dare la possibilità all'edicolante di effettuare operazioni singole su pubblicazioni già inserite 
 * (modifiche dei singoli campi, rimozione di una pubblicazione terminata): 
 * la modifica deve avvenire nel modo più pratico possibile per l'edicolante.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Edicola1 {

    /* ---------- FIELDS ---------- */
    ArrayList<Publications1> shelf = new ArrayList<Publications1>();
    public double gainTotal = 0.0;
    public double gainEach = 0.0;
    public int i = 1;
    Scanner text = new Scanner(System.in);
    Scanner number = new Scanner(System.in);

    /* ---------- METHODS ---------- */

    public void print() {

        System.out.println("------ Chiusura ------");

        for (Publications1 issue : shelf) {

            System.out.print("" + (shelf.indexOf(issue) + 1) + ". ");
            System.out.println("Pubblicazione: " + issue.getName() + ";");
            System.out.println("Copie da restituire: " + (issue.getReceived() - issue.getSold()) + ";");
            gainEach = Math.floor(issue.getSold()*issue.getPremium()*issue.getPrice()*100)/100;
            gainTotal += gainEach;
            System.out.println(" ------- ");

        }

        System.out.println("Guadagno totale giornaliero: " + (Math.floor(gainTotal*100)/100) + " euro.");
        System.out.println("A domani!");

    }

    public void open() {

        boolean repeat = true;
        boolean again = true;
        
        do {
            
        System.out.println("Benvenuto nel software di gestione.");
        System.out.print("Istruzioni: 1. per aggiungere una pubblicazione 2. modificare una pubblicazione  0. per stampare la ricevuta di chiusura ed uscire. Digita: ");
        int response = number.nextInt();
        int position;
        
        switch(response) {

            case 1:

                Publications1 newPublication = new Publications1();
                newPublication.addPublication();
                shelf.add(newPublication);
                break;

            case 2:

                do { 
                    
                    for (Publications1 issue : shelf) {

                        System.out.print("" + (shelf.indexOf(issue) + 1) + ". ");
                        System.out.println("Pubblicazione: " + issue.getName() + ";");
                        System.out.println();

                    }

                    System.out.println("Inserire il numero della pubblicazione per selezionarla oppure premi 0 per tornare al menù principale.");
                    position = number.nextInt();

                    if (position == 0) {

                        again = false;
                        break;
                        
                    } else {

                        System.out.println("Istruzioni: 1. modifica nome 2. modifica prezzo 3. modifica aggio 4. modifica copie ricevute 5. modifica copie vendute 6. elimina un'intera pubblicazione 0. esci");
                        int select = number.nextInt();

                        

                        switch (select) {

                            case 1:
                                System.out.print("Aggiungere il nome della pubblicazione: ");
                                shelf.get((position - 1)).setName(text.nextLine());
                                break;

                            case 2:
                                System.out.print("Aggiungere il prezzo della pubblicazione: ");
                                shelf.get((position - 1)).setPrice(number.nextDouble());
                                break;

                            case 3:
                                System.out.print("Inserire l'aggio della pubblicazione (range: 0,05 - 0,20) (es. 0,1 per 10%): ");
                                shelf.get((position - 1)).setPremium(number.nextDouble());
                                break;

                            case 4:
                                System.out.print("Aggiungere il numero di pubblicazioni ricevute: ");
                                shelf.get((position - 1)).setReceived(number.nextInt());
                                break;

                            case 5:
                                System.out.print("Aggiungere il numero di pubblicazioni vendute: ");
                                shelf.get((position - 1)).setSold(number.nextInt());
                                break;

                            case 6:
                                System.out.println("Sicuro di voler rimuovere la pubblicazione selezionata (S/N)?");
                                char answer = text.next().toUpperCase().charAt(0);

                                switch (answer) {
                                case 'S': 
                                    shelf.remove((position - 1));
                                    break;
                                case 'N':
                                    break;
                                }

                                break;

                            case 0:
                                again = false;
                                break;

                            default:
                                System.out.println("Imput non valido.");

                                System.out.println("Istruzioni: 1. modifica nome 2. modifica prezzo 3. modifica aggio 4. modifica copie ricevute 5. modifica copie vendute 6. elimina un'intera pubblicazione 0. esci");
                                select = number.nextInt();

                                break;
                        } 

                        }

                } while (again);
                
                break;
                
            case 0:

                print();
                repeat = false;
                break;

            default:

                System.out.println("Input non valido. Riprovare.");
                System.out.print("Istruzioni: 1. per aggiungere una pubblicazione 2. per stampare le pubblicazioni in corso 3. modificare una pubblicazione  0. per stampare la ricevuta di chiusura ed uscire. Digita: ");
                response = number.nextInt();
                break;

        }

        } while (repeat);

    }    
    
}
