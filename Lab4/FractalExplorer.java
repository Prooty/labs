import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int size;

    private JImageDisplay display;

    private FractalGenerator generator;

    private Rectangle2D.Double range;

    public FractalExplorer(int size) {
        this.size = size;
        display = new JImageDisplay(size, size);
        generator = new Mandelbrot();
        range = new Rectangle2D.Double();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().
        frame.getContentPane().add(display, BorderLayout.CENTER);
        JButton button = new JButton("Reset");
        button.setActionCommand("reset");
        button.addActionListener(new ButtonHandler());
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.getContentPane().addMouseListener(new MouseHandler());

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() {
        float hue;

        for (int y = 0; y < size; y++){
            for (int x = 0; x < size; x++){
                //x - пиксельная координата; xCoord - координата в пространстве фрактала
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);
                int iterations = generator.numIterations(xCoord, yCoord);
                hue = 0.7f + (float) iterations / 200f;
                int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                display.drawPixel(x, y, rgbColor);
            }
        }
        display.repaint();
    }

    public class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("reset")){
                range = new Rectangle2D.Double();
                generator.getInitialRange(range);
                drawFractal();
            }
        }
    }

    public class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            double x = FractalGenerator.getCoord(range.x, range.x + range.width, size, e.getX());
            double y = FractalGenerator.getCoord(range.y, range.y + range.height, size, e.getY());
            generator.recenterAndZoomRange(range, x, y, 0.5);
            drawFractal();
        }
    }

    public static void main(String[] args) {
        FractalExplorer window = new FractalExplorer(600);
        window.createAndShowGUI();
        window.drawFractal();
    }

}