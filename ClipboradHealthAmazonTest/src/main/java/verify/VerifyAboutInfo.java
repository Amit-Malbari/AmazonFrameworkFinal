package verify;

public final class VerifyAboutInfo {
	
	private VerifyAboutInfo() {	
	}
	
	public static String getAboutThisItemText() {
		return ("About this item\r\n"
				+ "Resolution: 4K Ultra HD (3840x2160) | Refresh Rate: 120 hertz\r\n"
				+ "Connectivity: 4 HDMI ports to connect set top box, Blu Ray players, gaming console | 2 USB ports to connect hard drives and other USB devices\r\n"
				+ "Sound : 20 Watts Output\r\n"
				+ "Smart TV Features : Smart TV with free apps\r\n"
				+ "Display : QLED | LED Panel | Slim and stylish design\r\n"
				+ "Warranty Information: 1 year 1 Year Comprehensive + 1 Year Additional on Panel by Samsung from date of purchase\r\n"
				+ "Installation: For requesting Samsung sanitized installation/wallmounting/demo of this product once delivered, please directly call Samsung support on [1800407267864/180057267864] and provide product's model name as well as seller's details mentioned on the invoice"
				).replaceAll("(\r\n|\n)", "<br />");
	}

}
