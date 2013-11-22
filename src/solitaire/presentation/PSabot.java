package solitaire.presentation;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.dnd.DragSourceListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listener.ClickListener;
import listener.MyDragSourceListener;
import solitaire.controleur.CCarte;
import solitaire.controleur.CSabot;


public class PSabot extends JPanel
{

    private static final long serialVersionUID = 1L;

    private CSabot controleur;

    private PTasDeCarte reserve;

    private PTasDeCarte visible;

    protected DragSource dragSource = null;

    protected SabotDragSourceListener myDragSourceListerner = null;

    protected DragGestureEvent theInitialEvent;

    protected DropTargetDropEvent theFinalEvent;

    protected DropTarget dropTarget = null;

    private PCarte selected = null;

    private CCarte selectedControl = null;

    private Point dragOrigin = null;
    
    private JFrame dragFrame = null;

    public PSabot( CSabot s )
    {
        setControleur( s );
        this.reserve = s.getTasCache().getPresentation();
        this.visible = s.getTasVisible().getPresentation();
        add( reserve );
        add( visible );
        setVisible( true );
        reserve.addMouseListener( new RetournerCarteSabot() );
        myDragSourceListerner = new SabotDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( visible, DnDConstants.ACTION_MOVE, new SabotDragGestureListener() );
        dragSource.addDragSourceMotionListener( new SabotDragSourceMotionListener() );
    }

    public class SabotDragSourceMotionListener implements DragSourceMotionListener
    {
        @Override
        public void dragMouseMoved( DragSourceDragEvent evt )
        {
            int parentX = getRootPane().getParent().getX();
            int parentY = getRootPane().getParent().getY();
            int eventX = evt.getLocation().x+5;
            int eventY = evt.getLocation().y-5;
            dragFrame.setLocation( eventX - parentX, eventY - parentY );
            repaint();
        }
    }

    public class SabotDragGestureListener implements DragGestureListener
    {

        @Override
        public void dragGestureRecognized( DragGestureEvent evt )
        {
            selected = null;
            selectedControl = null;
            theInitialEvent = evt;
            dragOrigin = evt.getDragOrigin();
            try
            {
                selected = (PCarte) visible.getComponentAt( dragOrigin );
                selectedControl = (CCarte) selected.getControle();
            }
            catch ( Exception e )
            {

            }

            controleur.p2c_debutDnDDrag( selectedControl );
        }
    }

    public class SabotDragSourceListener extends MyDragSourceListener
    {
            
        @Override
        public void dragDropEnd( DragSourceDropEvent evt )
        {
            controleur.p2c_finDnDDrag( selected.getControle(), evt.getDropSuccess() );
            dragFrame.setVisible( false );
            repaint();
        }

        @Override
        public void dragEnter( DragSourceDragEvent evt )
        {
            evt.getDragSourceContext().setCursor( new Cursor( Cursor.MOVE_CURSOR ) );
        }
    }

    public CSabot getControleur()
    {
        return controleur;
    }

    public void setControleur( CSabot controleur )
    {
        this.controleur = controleur;
    }

    public PTasDeCarte getReserve()
    {
        return reserve;
    }

    public void setReserve( PTasDeCarte reserve )
    {
        this.reserve = reserve;
    }

    public PTasDeCarte getVisible()
    {
        return visible;
    }

    public void setVisible( PTasDeCarte visible )
    {
        this.visible = visible;
    }

    private class RetournerCarteSabot extends ClickListener
    {
        @Override
        public void mouseClicked( MouseEvent e )
        {
            try
            {
                controleur.retournerCarte();
            }
            catch ( Exception e1 )
            {
                e1.printStackTrace();
            }
        }
    }

    public void debutDnDValide(PTasDeCarte tas)
    {
        
        dragSource.startDrag( theInitialEvent, DragSource.DefaultMoveNoDrop, tas, myDragSourceListerner );
        
        dragFrame = new JFrame();
        dragFrame.add( tas );                
        dragFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        dragFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dragFrame.setUndecorated(true);
        dragFrame.setVisible( true );
        dragFrame.pack();
        repaint();
    }

    public void debutDnDInvalide()
    {
        theFinalEvent.acceptDrop( DnDConstants.ACTION_MOVE );
        theFinalEvent.getDropTargetContext().dropComplete( true );
    }

    public void finDnDInvalide()
    {
        theFinalEvent.rejectDrop();
    }
    
    
}
