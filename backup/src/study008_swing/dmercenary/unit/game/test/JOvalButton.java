package study008_swing.dmercenary.unit.game.test;

import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

public class JOvalButton extends JComponent implements Accessible {
	/** The look and feel delegate for this component. */
    protected transient ComponentUI ui;
    
    /** A list of event listeners for this component. */
    protected EventListenerList listenerList = new EventListenerList();
}
