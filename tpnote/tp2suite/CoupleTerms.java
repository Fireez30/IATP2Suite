package tp2suitebackupetape1;

public class CoupleTerms {

		protected Term t1;
		protected Term t2;
		
		
		public CoupleTerms() {
			t1 = null;
			t2 = null;
		}
		
		public CoupleTerms(Term a, Term b) {
			t1 = a;
			t2 = b;
		}
		
		// Accesseurs
		
		public Term getT1() {
			return this.t1;
		}
		
		public Term getT2() {
			return this.t2;
		}
		
		
		//toString
		public String toString() {
			return "t1 : "+getT1().toString()+" t2 : "+getT2().toString();
		}
}
