import javax.swing.SwingUtilities;

import ui.CuaSoChinhMoi;

public class App {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CuaSoChinhMoi frame = new CuaSoChinhMoi();
            frame.setVisible(true);
        });
    }
}
