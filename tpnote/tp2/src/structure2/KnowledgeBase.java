package tp2.src.structure2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class KnowledgeBase {
	protected FactBase facts;
	protected RuleBase rules;
	public FactBase factssat;


	public KnowledgeBase() {
		facts = new FactBase();
		rules = new RuleBase();
		factssat = new FactBase();
	}

	public KnowledgeBase(String fic) throws IOException {

		System.out.println("Chargement du fichier : " + fic);
		BufferedReader readFile;
		System.out.println("Debut de la lecture du fichier ! ");
		readFile = new BufferedReader(new FileReader (fic));
		String fact;
		String rule = "nomatomeinterdit";//permet les test dans le while , il faut pas qu'un atome s'appelle ainsi
		Rule r;
		System.out.println("Lecture de la 1ere ligne : les faits");
		fact = readFile.readLine();//lis tous les atomes puisqu'ils sont sur une meme ligne
		facts= new FactBase(fact);
		rules = new RuleBase();
		while (rule != null) {
			System.out.println("Lecture de la prochaine regle");
			rule = readFile.readLine();//lis les regles une par une
			if (rule == null || rule == "nomatomeinterdit") {
				rule = null;}
			else {
				r=new Rule(rule);
				rules.addRule(r);}
		}

		factssat = new FactBase(fact);//la base de fait saturee contient au moins les faits presents au depart
	}

	public void ForwardChaining(){
		ArrayList<Atom> atraiter = new ArrayList<Atom>(facts.getAtoms());
		Hashtable compteur = new Hashtable(); //le compteur pour les differentes regles
		for (int i=0; i<rules.size();i++) {
			compteur.put(rules.getRule(i), rules.getRule(i).getHypothesis().size());
		}

		while (!atraiter.isEmpty()) {
			Atom temp = atraiter.remove(0);
			for (int i=0; i<rules.size();i++) {
				for(int j=0;j<rules.getRule(i).getHypothesis().size();j++)
					if (rules.getRule(i).getHypothesis().get(j).equalsA(temp))
					{
						compteur.replace(rules.getRule(i),(int)compteur.get(rules.getRule(i)) - 1);
						if ((int)compteur.get(rules.getRule(i)) == 0) {
							Atom c=rules.getRule(i).getConclusion();

							boolean flag_in = false;
							for(int k=0;k<factssat.getAtoms().size();k++)
								for(int l=0;l<atraiter.size();l++)
									if (!factssat.getAtoms().get(k).equalsA(c) && !atraiter.get(l).equalsA(c)) 
										continue;
									else  flag_in = true;
							if (!flag_in){
								factssat.addAtomWithoutCheck(c);
								atraiter.add(c);
							}

						}
					}
			}
		}
	}


	public boolean BackwardChaining(Atom q,ArrayList<Atom> sup,ArrayList<Atom> echec,ArrayList<Atom> success) {
		if (success.contains(q)) {return true;}
		if (echec.contains(q)) {return false;}
		if (facts.belongsAtom(q)) {return true;}
		boolean test = false;
		for(int i=0;i < rules.size();i++) {
			if (rules.getRule(i).getConclusion().equalsA(q)) {
				for(int j=0; j < rules.getRule(i).getHypothesis().size(); j++) {
					for(int k=0;k<sup.size();k++)
						if (sup.get(k).equalsA(rules.getRule(i).getHypothesis().get(j))) {test = true;}
					if (test == false) {
						int k=1;
						ArrayList<Atom> supClone = (ArrayList<Atom>) sup.clone();
						supClone.add(q);
						while (k<rules.getRule(i).getHypothesis().size() && BackwardChaining(rules.getRule(i).getHypothesis().get(k),supClone,echec,success)) {
							k++;
						}
						if (k >= rules.getRule(i).getHypothesis().size()) {success.add(q);return true;}
					}
				}
			}
			
		}
		echec.add(q);
		return false;
	}

	public FactBase getFacts()
	{
		return facts;
	}

	public FactBase getFactsSat()
	{
		return factssat;
	}

	public RuleBase getRules()
	{
		return rules;
	}


	public String toString() {
		return "Knowledge Base :\n"+facts.toString()+"\n"+rules.toString()+"\n (Saturee) "+factssat.toString();
	}
}
