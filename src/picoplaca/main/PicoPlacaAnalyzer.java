package picoplaca.main;

import java.util.ArrayList;
import java.time.LocalDate;

public class PicoPlacaAnalyzer {
	private Vehicle vehicle;
	private String date;
	private String day;
	private String month;
	private String year;
	private LocalDate localDate;
	private int time;
	private ArrayList<String> restrictions;
	private boolean isOk;
	private String statusMessage;

	private int morningLowerLimit = 700;
	private int morningUpperLimit = 930;
	private int afternoonLowerLimit = 1600;
	private int afternoonUpperLimit = 1930;

	private final int posicionDigito = 6;

	public PicoPlacaAnalyzer(Vehicle vehicle, String date, String time) {
		restrictions = new ArrayList<String>();
		restrictions.add("1-2");
		restrictions.add("3-4");
		restrictions.add("5-6");
		restrictions.add("7-8");
		restrictions.add("9-0");
		restrictions.add("");
		restrictions.add("");
		this.setOk(true);
		this.setVehicle(vehicle);
		if (!vehicle.isOk()) {
			this.setOk(false);
			this.setStatusMessage(vehicle.getStatusMessage());
		}
		this.setDate(date);
		this.setTime(time);
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if (date.length() != 10) {
			this.setOk(false);
			this.setStatusMessage(ErrorMessages.notDateFormat);
		} else {
			if (date.contains("-")) {
				String d[] = date.split("-");
				if (d.length != 3) {
					this.setOk(false);
					this.setStatusMessage(ErrorMessages.notDateFormat);
				} else {
					this.day = d[0];
					this.month = d[1];
					this.year = d[2];
					this.date = date;
					this.localDate = LocalDate.of(Integer.parseInt(this.year), Integer.parseInt(this.month),
							Integer.parseInt(this.day));
				}
			} else {
				this.setOk(false);
				this.setStatusMessage(ErrorMessages.notDateFormat);
			}
		}
	}

	public void setTime(String time) {

		if (time.length() != 5) {
			this.setOk(false);
			this.setStatusMessage(ErrorMessages.notTimeFormat);
		} else {
			if (time.contains(":")) {
				String timeTmp[] = time.split(":");
				if (timeTmp.length == 2) {
					time = time.replace(":", "");
					this.time = Integer.parseInt(time);
				} else {
					this.setOk(false);
					this.setStatusMessage(ErrorMessages.notTimeFormat);
					this.time = -1;
				}
			} else {
				this.setOk(false);
				this.setStatusMessage(ErrorMessages.notTimeFormat);
				this.time = -1;
			}

		}

	}

	public ArrayList<String> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(ArrayList<String> restrictions) {
		this.restrictions = restrictions;
	}

	public int getPosicionDigito() {
		return posicionDigito;
	}

	public String getDigito() {
		String digito = "";
		if (this.vehicle.getPlaca() != null) {
			digito = this.vehicle.getPlaca().substring(posicionDigito);
		}
		return digito;
	}

	public boolean isPicoPlaca() {
		boolean picoPlaca = false;
		if (this.isOk()) {
			int dayNumber = this.localDate.getDayOfWeek().getValue() - 1;
			if (restrictions.get(dayNumber).contains(this.getDigito())) {
				if ((this.time >= this.morningLowerLimit && this.time <= this.morningUpperLimit)
						|| (this.time > this.afternoonLowerLimit && this.time <= this.afternoonUpperLimit)) {
					picoPlaca = true;
				}

			}
		}
		return picoPlaca;
	}
}
