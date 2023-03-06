import javax.swing.JOptionPane;

public class TemperatureConverter {
	public static double ReachTemperature(String temperatureDescription) {
		String inputValue;
		String testeDouble = "(\\-?\\d*\\,?\\d+)|(\\-?\\d*\\.?\\d+)";
		do {
			inputValue = JOptionPane
					.showInputDialog("Enter the temperature in " + temperatureDescription);
			if (!inputValue.matches(testeDouble)) {
				JOptionPane.showMessageDialog(null, "Enter a value", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} while (!inputValue.matches(testeDouble));
		if (!(inputValue.indexOf(',') == -1)) {
			inputValue = inputValue.replace(',', '.');
		}
		return Double.parseDouble(inputValue);
	}

	public static String[] purposeTemperature() {
		String[] temperatures = TemperatureConverter.temperatures();
		Object supportTemperature = JOptionPane.showInputDialog(null, "Temperature you want to convert", null,
				JOptionPane.INFORMATION_MESSAGE, null, temperatures, temperatures[0]);
		Object targetTemperature;
		do {
			targetTemperature = JOptionPane.showInputDialog(null, "Temperature that will convert", "Select",
					JOptionPane.INFORMATION_MESSAGE, null, temperatures, temperatures[0]);
			if (targetTemperature == supportTemperature) {
				JOptionPane.showMessageDialog(null, "Cannot convert to same scale", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (supportTemperature == targetTemperature);
		return new String[] { String.valueOf(supportTemperature), String.valueOf(targetTemperature) };
	}

	public static String[] temperatures() {
		return new String[] { "Celsius", "Fahrenheit", "Kelvin" };
	}

	public static double converter(String consequence, double result) {
		double solution = 0;
		switch (consequence) {
			case "Celsius_Kelvin":
				solution = result + 273;
				break;
			case "Celsius_Fahrenheit":
				solution = (result * 9 / 5) + 32;
				break;
			case "Fahrenheit_Celsius":
				solution = 5 * ((result - 32) / 9);
				break;
			case "Fahrenheit_Kelvin":
				solution = 273 + (result - 32) * 5 / 9;
				break;
			case "Kelvin_Celsius":
				solution = result - 273;
				break;
			case "Kelvin_Fahrenheit":
				solution = (result - 273) * 9 / 5 + 32;
				break;
		}
		return solution;
	}
}