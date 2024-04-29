package Com.admin.model;

public class Rate {
	
	    private int id;
	    private double CommRate;
	   
	    private double DomRate;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getCommRate() {
			return CommRate;
		}

		public void setComRate(double coomRate) {
			this.CommRate = coomRate;
		}

		public double getDomRate() {
			return DomRate;
		}

		public void setDomRate(double domRate) {
			DomRate = domRate;
		}

		public Rate(int id, double coomRate, double domRate) {
			super();
			this.id = id;
			this.CommRate = coomRate;
			DomRate = domRate;
		}

		public Rate() {
			// TODO Auto-generated constructor stub
		}
	    
	    

}

	   