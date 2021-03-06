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

public class NrNetSetTchFrame extends JFrame {
  JToolBar jToolBar1 = new JToolBar();
  JPanel jPanel1 = new JPanel();

  Box boxIn[];
  JLabel jLabelIn[];
  JTextField jTextFieldIn[];
  NeuronNet nrn;
  NrNetPnl jPnNrNet;
  Box box1;
  Box box2;
  Box box9;
  JTextField jTextField1 = new JTextField();
  JButton jButton2 = new JButton();
  JTextField jTextField2 = new JTextField();
  JLabel jLabel2 = new JLabel();
  Box box3;
  JTextField jTextField3 = new JTextField();
  JLabel jLabel3 = new JLabel();
  JButton jButton1 = new JButton();

  public NrNetSetTchFrame(NrNetPnl jPnNrNet0, NeuronNet nrn0) {
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
    box9 = Box.createVerticalBox();
    box2 = Box.createVerticalBox();
    box3 = Box.createVerticalBox();
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    jTextField1.setText("-5.0");
    jButton2.setText("���������");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jLabel2.setText("����. ��. ����. ����.");
    jTextField2.setText(String.valueOf(nrn.getA()));
    jLabel3.setText("�������� ����.");
    jTextField3.setText(String.valueOf(nrn.getN()));
    jButton1.setText("�������");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
    box2.add(jLabel2, null);
    box2.add(jTextField2, null);
    box3.add(jLabel3, null);
    box3.add(jTextField3, null);
    jToolBar1.add(jButton1, null);
    jToolBar1.add(box3, null);
    jToolBar1.add(box2, null);
    jToolBar1.add(box9, null);
    box9.add(jTextField1, null);
    box9.add(jButton2, null);
    this.getContentPane().add(jPanel1,  BorderLayout.CENTER);

    boxIn=new Box[nrn.getQntOutpNeuron()];
    jLabelIn=new JLabel[nrn.getQntOutpNeuron()];
    jTextFieldIn=new JTextField[nrn.getQntOutpNeuron()];

    for(int k=0;k<nrn.getQntOutpNeuron();k++)
    {
      boxIn[k] = Box.createVerticalBox();
      jPanel1.add(boxIn[k], null);
      jLabelIn[k] = new JLabel();
      jLabelIn[k].setText("In"+k);
      boxIn[k].add(jLabelIn[k], null);
      jTextFieldIn[k] = new JTextField();
      jTextFieldIn[k].setText(String.valueOf(nrn.getTchOtpNeuron(k)));
      boxIn[k].add(jTextFieldIn[k], null);
    }
  }

  void jButton1_actionPerformed(ActionEvent e) {
    for(int k=0;k<nrn.getQntOutpNeuron();k++){
      nrn.setTchOtpNeuron(k,Float.valueOf(jTextFieldIn[k].getText()).floatValue());
    }
    nrn.setA(Float.valueOf(jTextField2.getText()).floatValue());
    nrn.setN(Float.valueOf(jTextField3.getText()).floatValue());
//    jPnNrNet.paint(jPnNrNet.getGraphics());
  }

  void jButton2_actionPerformed(ActionEvent e) {
    for(int k=0;k<jTextFieldIn.length;k++){
      jTextFieldIn[k].setText(jTextField1.getText());
    }
  }
}