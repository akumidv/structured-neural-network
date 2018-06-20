/**
 * <p>Title: Neural Network</p>
 * <p>Description: Aspirant work</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author mrka
 * @version 1.0
 */

package neuronnetwork;

import java.applet.*;
import java.awt.*;
//import javax.swing.UIManager;
import javax.swing.*;

public class NrNet extends JApplet {
  boolean packFrame = false;
  public static JApplet applet;
  // Construct the application
  public NrNet() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void init() {
    applet = this;
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
       jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    NrNet nrNet1 = new NrNet();
  }

  private void jbInit() throws Exception {
    NrNetFrame frame = new NrNetFrame();
    //Pack frames that have useful preferred size info, e.g. from their layout
    //Validate frames that have preset sizes
/*    if (packFrame)
      frame.pack();
    else
      frame.validate();
*/
    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    frame.setVisible(true);
  }
}