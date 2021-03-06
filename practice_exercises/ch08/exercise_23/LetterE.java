import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
    Stroke of lines drawn to display the E shape 
*/
public class LetterE
{
    private double x;
    private double y;
    
    /**
        Construct a class that handles the drawing of the letter E.
        @param p of the top-left corner of the shape.
    */
    public LetterE(Point2D.Double p)
    {
        x = p.getX();
        y = p.getY();
    }
    
    /**
        draw a shape for this LetterE
        @param g2 the graphics context
    */
    public void draw(Graphics2D g2)
    {
        final int FONT_HEIGHT = 20;
        final int FONT_WIDTH = 12;
        
        Line2D.Double v = new Line2D.Double(x, y, x, y + FONT_HEIGHT);
        Line2D.Double h1 = new Line2D.Double(x, y, x + FONT_WIDTH, y);
        Line2D.Double h2 = new Line2D.Double(x, y + FONT_HEIGHT * 0.5,
            x + FONT_WIDTH, y + FONT_HEIGHT * 0.5);
        Line2D.Double h3 = new Line2D.Double(x, y + FONT_HEIGHT, 
            x + FONT_WIDTH, y + FONT_HEIGHT);
            
        g2.draw(v);
        g2.draw(h1);
        g2.draw(h2);
        g2.draw(h3);
    }
}  