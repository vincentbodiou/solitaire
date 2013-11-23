package listener;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

public class ADropTargetListener implements DropTargetListener
{
    @Override
    public void dragEnter( DropTargetDragEvent dtde ){}   

    @Override
    public void dragExit( DropTargetEvent dte ){}

    @Override
    public void dragOver( DropTargetDragEvent dtde ){}

    @Override
    public void drop( DropTargetDropEvent dtde ){}

    @Override
    public void dropActionChanged( DropTargetDragEvent dtde ){}

}
