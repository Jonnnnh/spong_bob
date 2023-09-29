import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        DrawPanel panel = new DrawPanel();
        this.add(panel);
    }
}
