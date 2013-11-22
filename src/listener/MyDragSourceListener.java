package listener;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

public abstract class MyDragSourceListener implements DragSourceListener
{
    public void dragDropEnd( DragSourceDropEvent arg0 ){}
    public void dragEnter( DragSourceDragEvent arg0 ){}
    public void dragExit( DragSourceEvent arg0 ){}
    public void dragOver( DragSourceDragEvent arg0 ){}
    public void dropActionChanged( DragSourceDragEvent arg0 ){}
 
}
