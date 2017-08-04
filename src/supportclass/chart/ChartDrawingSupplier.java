/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass.chart;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.plot.DefaultDrawingSupplier;

/**
 *
 * @author DELL
 */
public class ChartDrawingSupplier extends DefaultDrawingSupplier{
    public Paint[] paintSequence;
    public int paintIndex;
    public int fillPaintIndex;
    
    {
        paintSequence = new Paint[]{
            new Color(37, 143, 188),
            new Color(5, 85, 119),
            new Color(10, 175, 126),
            new Color(44, 55, 89),
            new Color(63, 89, 130),
            new Color(84, 116, 165),
            new Color(20, 85, 186),
            new Color(3, 38, 91),
            new Color(3, 16, 35),
            new Color(159, 174, 196)
        };
    }
    
    
    @Override
    public Paint getNextPaint(){
        Paint result = paintSequence[paintIndex % paintSequence.length];
        paintIndex++;
        return result;
    }
    
    @Override
    public Paint getNextFillPaint(){
        Paint result = paintSequence[fillPaintIndex % paintSequence.length];
        fillPaintIndex++;
        return result;
    }
}
