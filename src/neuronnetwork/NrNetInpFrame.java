/**
 * <p>Title: Neural Network</p>
 * <p>Description: Aspirant work</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author mrka
 * @version 1.0
 */

package neuronnetwork;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import neurnetmodel.NeuronNet;

public class NrNetInpFrame extends JFrame {
  JToolBar jToolBar1 = new JToolBar();
  JPanel jPanel1 = new JPanel();
  JButton jButton1 = new JButton();

  Box boxIn[];
  JLabel jLabelIn[];
  JTextField jTextFieldIn[];
  NeuronNet nrn;
  JTextField jTextField1 = new JTextField();
  JButton jButton2 = new JButton();
  NrNetPnl jPnNrNet;

  public NrNetInpFrame(NrNetPnl jPnNrNet0, NeuronNet nrn0) {
    nrn=nrn0;
    jPnNrNet=jPnNrNet0;
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    jButton1.setText("Занести");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    jTextField1.setText("-5");
    jButton2.setText("Заполнить");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
    jToolBar1.add(jButton1, null);
    jToolBar1.add(jTextField1, null);
    jToolBar1.add(jButton2, null);
    this.getContentPane().add(jPanel1,  BorderLayout.CENTER);

    boxIn=new Box[nrn.getQntInptNeuron()];
    jLabelIn=new JLabel[nrn.getQntInptNeuron()];
    jTextFieldIn=new JTextField[nrn.getQntInptNeuron()];

    for(int k=0;k<nrn.getQntInptNeuron();k++)
    {
      boxIn[k] = Box.createVerticalBox();
      jPanel1.add(boxIn[k], null);
      jLabelIn[k] = new JLabel();
      jLabelIn[k].setText("In"+k);
      boxIn[k].add(jLabelIn[k], null);
      jTextFieldIn[k] = new JTextField();
      jTextFieldIn[k].setText(""+nrn.getInptNeuron(k));
      boxIn[k].add(jTextFieldIn[k], null);
    }
  }

  void jButton1_actionPerformed(ActionEvent e) {
    for(int k=0;k<nrn.getQntInptNeuron();k++){
      nrn.setInptNeuron(k,Float.valueOf(jTextFieldIn[k].getText()).floatValue());
    }
    jPnNrNet.paint(jPnNrNet.getGraphics());
  }

  void jButton2_actionPerformed(ActionEvent e) {
    for(int k=0;k<jTextFieldIn.length;k++){
      jTextFieldIn[k].setText(jTextField1.getText());
    }
  }
}