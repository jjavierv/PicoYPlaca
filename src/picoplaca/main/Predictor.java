package picoplaca.main;

public class Predictor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v = new Vehicle("GSF-9360");
		System.out.println(v.getPlaca());
		System.out.println(v.isOk());
		System.out.println(v.getStatusMessage());
		System.out.println(v.getPlaca().length());
		
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(v, "16-05-2019", "09:31");
		PicoPlacaAnalyzer ppa2 = new PicoPlacaAnalyzer(v, "17-05-2019", "19:30");
		
		System.out.println(ppa.isPicoPlaca());
		System.out.println(ppa2.isPicoPlaca());
	}

}
