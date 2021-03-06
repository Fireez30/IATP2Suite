package tp2.src.structure2;



public class Application0 {
	public static void main(String[] args)
	{
		// creation de la base de faits de 2 facons differentes
		FactBase bf = new FactBase("P");
		bf.addAtomWithoutCheck(new Atom("Q"));
		System.out.println("Base de faits initiale :\n"+bf);
	
		// creation de la base de regles
		RuleBase br = new RuleBase();
		br.addRule(new Rule("P;S"));
		br.addRule(new Rule("Q;S;R"));
		System.out.println("Base de regles :\n"+br);
	}
}
