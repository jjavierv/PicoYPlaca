package picoplaca;

import picoplaca.main.PicoPlacaAnalyzer;
import picoplaca.main.Vehicle;

public class Program {

	public static void main(String[] args) {
		String date;
		String time;
		Vehicle vehicle;
		if (args.length == 3) {
			vehicle = new Vehicle(args[0]);
			date = args[1];
			time = args[2];
			if (vehicle.isOk()) {
				PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
				if (ppa.isOk()) {
					if (ppa.isPicoPlaca())
						System.out.println("License Plate " + vehicle.getPlaca() + " IS on Pico y Placa at " + time
								+ " on " + date);
					else
						System.out.println("License Plate " + vehicle.getPlaca() + " IS NOT on Pico y Placa at " + time
								+ " on " + date);
				} else {
					System.out.println("Error:");
					System.out.println(ppa.getStatusMessage());
				}
			}
		} else {
			System.out.println(
					"You should enter parameters in the following order: license plate number, date and time.");
			System.out.println("Separated by spaces.  For example:");
			System.out.println("$java Program ABC-9999 01-12-2019 00:00");
		}

	}

}
