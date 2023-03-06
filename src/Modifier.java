import javax.swing.JOptionPane;

public class Modifier {
	public static void main(String[] args) {
		Object[] elements = { "Temperature" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Click OK",
				null, JOptionPane.INFORMATION_MESSAGE, null, elements, elements[0]);
		String choice = String.valueOf(selectedValue);
		switch (choice) {
			case "Temperature":
				String[] supoportPurpose = TemperatureConverter.purposeTemperature();
				String consequence = supoportPurpose[0] + "_" + supoportPurpose[1];
				double supportTemperature = TemperatureConverter.ReachTemperature(supoportPurpose[0]);
				double sequence = TemperatureConverter.converter(consequence, supportTemperature);
				String feedback = "Conversion: " + String.format("%.2f", sequence);
				JOptionPane.showMessageDialog(null, feedback);
				break;
		}
		int proceed = JOptionPane.showConfirmDialog(null, "Proceeed?", "Select",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (proceed == 0) {
			main(args);
		} else if (proceed == 1) {
			JOptionPane.showMessageDialog(null, "Finished");
		} else {
			JOptionPane.showMessageDialog(null, "Cloded");
		}
	}
}