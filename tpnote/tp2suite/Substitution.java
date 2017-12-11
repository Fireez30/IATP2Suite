package tp2suitebackupetape1;

import java.util.ArrayList;

public class Substitution {

		protected ArrayList<CoupleTerms> list;
		
		public Substitution() {
			list = new ArrayList<CoupleTerms>();
		}
		
		public Substitution(ArrayList<CoupleTerms> l) {
			list = new ArrayList<CoupleTerms>(l);
		}
		
		
		//Accesseurs
		
		public ArrayList<CoupleTerms> getList(){
			return this.list;
		}
		
		//toString
		
		public String toString() {
			return list.toString();
		}
}
