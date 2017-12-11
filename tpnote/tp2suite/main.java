package tp2suite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {

		System.out.println("Chargement de la base .... ");
		KnowledgeBase k=new KnowledgeBase("C:\\Users\\Fireez\\Desktop\\Master\\eclipse\\reunionsuite.txt");
		System.out.println(k.toString());
		/*
		k.ForwardChaining();
		System.out.println();
		System.out.println(k.toString());
		
		
		
		while(true) {
			
			String x;
			ArrayList<Atom> a = new ArrayList<Atom>();
			ArrayList<Atom> success = new ArrayList<Atom>();
			ArrayList<Atom> echec = new ArrayList<Atom>();
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un atome :");
			String str = sc.nextLine();
			System.out.println("Vous avez saisi : " + str);
			
			Atom X = new Atom(str);
			
			System.out.println("Recherche dans la base de faits saturée ");
			if (k.factssat.belongsAtom(X)) {
				System.out.println("Réponse : oui !");
			}
			else 
				System.out.println("Réponse : non !");
			
			System.out.println("Recherche par BackwardChaining ");
			
			if (k.BackwardChaining(X,a,success,echec)) {
				System.out.println("Réponse : oui !");
			}
			else 
				System.out.println("Réponse : non !");
		}*/
		
	}

}
