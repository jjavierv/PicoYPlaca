package picoplaca.test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import picoplaca.main.PicoPlacaAnalyzer;
import picoplaca.main.Vehicle;

public class TestJunit {
	
	@Test
	public void testWithoutDash() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF9368");
		assertEquals(true, vehicle.isOk());
	}
	
	@Test
	public void testWithDash() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		assertEquals(true, vehicle.isOk());
	}
	
	@Test
	public void testExtraDigits() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-**9368");
		assertEquals(false, vehicle.isOk());
	}
	
	@Test
	public void testSiglasWrongFormat() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("AGBD9368");
		assertEquals(false, vehicle.isOk());
	}
	
	@Test
	public void testSiglasWidth() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-985674");
		assertEquals(false, vehicle.isOk());
	}
	
	@Test
	public void testIfNull() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle();
		assertEquals(false, vehicle.isOk());
	}
	
	@Test
	public void testIsPicoPlaca() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		String date="16-05-2019";
		String time="08:16";
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
		assertEquals(true, ppa.isPicoPlaca());
	}
	
	@Test
	public void testIsNotPicoPlaca_byDate() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		String date="17-05-2019";
		String time="08:16";
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
		assertEquals(false, ppa.isPicoPlaca());
	}

	@Test
	public void testIsNotPicoPlaca_byTime() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		String date="16-05-2019";
		String time="09:31";
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
		assertEquals(false, ppa.isPicoPlaca());
	}
	
	@Test
	public void testIsNotPicoPlaca_byDayAndTime() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		String date="17-05-2019";
		String time="15:31";
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
		assertEquals(false, ppa.isPicoPlaca());
	}
	
	@Test
	public void testPicoPlaca_FechaNotOk() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		String date="17-05-2019888";
		String time="15:31";
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
		assertEquals(false, ppa.isOk());
	}
	
	@Test
	public void testPicoPlaca_TimeNotOk() {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle("GSF-9368");
		String date="17-05-2019";
		String time="15Y31g";
		PicoPlacaAnalyzer ppa = new PicoPlacaAnalyzer(vehicle, date, time);
		assertEquals(false, ppa.isOk());
	}
}
