package picoplaca.main;

public class Vehicle {

	private String placa;
	private boolean isOk;
	private String statusMessage;

	private static final int maxChars = 7;

	public Vehicle() {
		this.setPlaca(null);
	}

	public Vehicle(String placa) {
		this.setPlaca(placa);
	}

	/*
	 * Gets Placa number
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Sets Placa number. Expects XXXX-#### format
	 * 
	 * @param placa
	 */
	public void setPlaca(String placa) {
		if (placa == null) {
			this.placa = "";
			this.setOk(false);
			this.setStatusMessage(ErrorMessages.notExpectedFormat);
		} else {
			this.setOk(true);
			this.setStatusMessage(ErrorMessages.statusOK);
			this.placa = placa;
			
			this.removeDash(placa);
			
			this.checkPlacaDigits();
			this.checkPlacaSiglas();
			this.checkPlacaLenght();
		}
	}

	public boolean isOk() {
		return isOk;
	}

	private void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	private void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getSiglas() {
		String siglas = this.placa.substring(0, 2);
		return siglas;
	}
	
	public String getDigitos() {
		String digitos = this.placa.substring(3, 6);
		return digitos;
	}

	private void removeDash(String placa) {
		String tmp = placa.replace("-", "");
		this.placa = tmp;
	}

	private void checkPlacaLenght() {
		if (this.placa.length() != maxChars) {
			this.setOk(false);
			this.setStatusMessage(ErrorMessages.maxChars);
		}
	}

	private void checkPlacaSiglas() {
		if (!this.checkLetters(getSiglas())) {
			this.setOk(false);
			this.setStatusMessage(ErrorMessages.notCharFormat);
		}
	}

	private void checkPlacaDigits() {
		if (!this.checkNumbers(getDigitos())) {
			this.setOk(false);
			this.setStatusMessage(ErrorMessages.notNumericFormat);
		}
	}

	private boolean checkLetters(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isLetter(s.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkNumbers(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isDigit(s.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}
