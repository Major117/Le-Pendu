import java.util.Random;
import java.util.Scanner;

public class Pendu {
    static String[] tabMots = {"methode", "hacker", "bug", "veille", "java", "gif", "ordinateur", "programmation",
            "biere", "algorithme", "popup", "optimisation", "email", "application", "bug", "cookie", "google", "pixel", "processeur",
            "serveur", "virus", "wifi", "cryptographie", "data"};  //tableaux de mots que l'ordinateur utilise.
    static int nbErreurRestante;                    // le nombre d'erreurs.
    static String motChoisi;                        // le mot choisi par l'ordinateur.
    static char[] charDuMotChoisi;                  // le mot choisi par l'odinateur mis dans un tableau de caractère et sauvegardé.
    static char[] motADeviner;                      // les caractères du mot masqués à deviner.
    static char lettreChoisie;                      // le caractère tapé par l'utilisateur.
    static boolean erreur;                          // le boolean erreur qui sert a décrémenter le nB erreur juste au dessus.
    static char reponse = ' ';                      // attend un caractère (o/n) pour relancer la boucle ou non. 
    static Random rdm = new Random();               // appelle l'objet Random, qui pioche un mot au Hasard
    static Scanner scan = new Scanner(System.in);   // appelle l'objet Scanner, permet de recupérer la saisie de l'utilisateur.

    /**
     * choisis un mot au hasard dans le tableau et le trasnforme en tableau de
     * caractères.
     *
     * @return un tableau de caractères.
     */
    public static char[] choisisUnMots() {
        String motChoisiTempo = tabMots[rdm.nextInt(tabMots.length)];
        char[] charDuMotChoisiTempo = motChoisiTempo.toCharArray();
        return charDuMotChoisiTempo;
    }

    /**
     * transforme tout le mot en underscores.
     *
     * @param tabChar le tabeau du mot Choisie
     * @return un tableau de caractère de ('_')
     */
    public static char[] transformeEnUnderscores(char[] tabChar) {
        char[] underscores = new char[tabChar.length];
        for (int i = 0; i < tabChar.length; i++) {
            underscores[i] = '_';
        }
        return underscores;
    }

    /**
     * affiche le mot a deviner et insert des espaces entre les underscores.
     *
     * @param tabChar tableau mot à deviner
     */
    public static void afficheMotADeviner(char[] tabChar) {
        for (int i = 0; i < tabChar.length; i++) {
            System.out.print(tabChar[i]);
            System.out.print(" ");
        }
    }

    /**
     * vérifie si l'utilisateur a bien trouvé toutes les lettres du mot, en analysant si le mot du début et bien égal a celui de fin.
     *
     * @param init tableau du mot choisit
     * @param fin  tableau du mot a deviner
     * @return boolean
     */
    public static boolean conditionVictoire(char[] init, char[] fin) {
        for (int i = 0; i < init.length; i++) {
            if (init[i] != fin[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * cherche si la lettre tapé par l'utilisateur est bien dans le mot initial et si oui, incrémente la lettre dans le mot en cours de recherche.
     *
     * @param lettre lettrechoisie
     * @param init   char du mot choisit
     * @param transf mot a deviner
     * @return un boolean
     */
    public static boolean chercheEtRemplace(char lettre, char[] init, char[] transf) {
        boolean ok = false;
        for (int i = 0; i < init.length; i++) {
            if (init[i] == lettre) {
                transf[i] = lettre;
                ok = true;
            }
        }
        return ok;
    }

    /**
     * l'affichage du jeu qui se trouvre dans la boucle principale.
     */
    public static void afficher() {

        System.out.println();
        System.out.println("*********************************************************************************************************");
        System.out.println();
        afficheMotADeviner(motADeviner);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("il te reste " + nbErreurRestante + " tour");
        System.out.println();
        System.out.print("Entrée une lettre : ");
    }


    public static void main(String[] args) {

        System.out.println("Coucou, nous allons jouer au pendu :)    bonne chance");

        do {                                                             //boucle  qui permet de rejouer
            nbErreurRestante = 7;                                                 
            charDuMotChoisi = choisisUnMots();
            motADeviner = transformeEnUnderscores(charDuMotChoisi);

            while (!conditionVictoire(charDuMotChoisi, motADeviner) && nbErreurRestante != 0) {  // boucle principale avec tout le déroulement du jeu.

                afficher();
                lettreChoisie = scan.next().toLowerCase().toCharArray()[0];
                erreur = chercheEtRemplace(lettreChoisie, charDuMotChoisi, motADeviner);
                if (erreur == false) {
                    nbErreurRestante--;
                }

            }

            if (conditionVictoire(charDuMotChoisi, motADeviner)) {                             // la condition de victoire
                System.out.print("Felicitation vous avez gagné, le mot était bien : ");
                System.out.println(motADeviner);
            }
            if (nbErreurRestante == 0) {                                                        // la condition de défaite
                System.out.println("Game Over...  le Mot était : " + new String(charDuMotChoisi));
            }

            do {
                System.out.println("Voulez-vous réessayer ? (o/n)"); //boucle qui demande au joueur si il veut rejouer.
                reponse = scan.next().toLowerCase().toCharArray()[0];
            } while (reponse != 'o' && reponse != 'n');

        } while (reponse == 'o');

        System.out.println("Au revoir…");
        scan.close();

    }

}