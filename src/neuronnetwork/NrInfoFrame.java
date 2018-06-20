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

public class NrInfoFrame extends JFrame {
/*//  Label lablOn[];
  TextField txtfldO[];
  int iXFldSteep=45;
  XYLayout xYLayout1 = new XYLayout();*/
  float fW[],fO[];
  NeuronNet nrn;
  int iLy, iNr;
  JToolBar jToolBar1 = new JToolBar();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  NrNetPnl jPnNrNet;

  Box boxW[];
  JLabel jLabelW[];
  JTextField jTextFieldW[];
  Box boxIn[];
  JLabel jLabelIn[];
  JTextField jTextFieldIn[];
  JLabel jLabelOn;
  JTextField jTextFieldOn;
  Box boxOn;
  JButton jButton1 = new JButton();
  JLabel jLabelOn1;
  JTextField jTextFieldOn1;
  JComboBox jComboBox1=new JComboBox();
  JComboBox jComboBox2 = new JComboBox();
  JLabel jLabelT;
  JTextField jTextFieldT;
  Box boxT;
/*  JRadioButton jRadioButton3 = new JRadioButton();
  JRadioButton jRadioButton2 = new JRadioButton();
  JRadioButton jRadioButton1 = new JRadioButton();
  Box bxStats;*/
//  ButtonGroup buttonGroup1 = new ButtonGroup();

  public NrInfoFrame(NrNetPnl jPnNrNet0,String title, NeuronNet nrNet, int iLy0, int iNr0){
    nrn=nrNet;
    iLy=iLy0;
    iNr=iNr0;
    jPnNrNet=jPnNrNet0;
    fW=nrn.getW(iLy,iNr);
    fO=nrn.getO(iLy,iNr);
    setTitle(title);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    jLabelOn = new JLabel();
    jTextFieldOn = new JTextField();
    boxOn = Box.createVerticalBox();
    jLabelOn1 = new JLabel();
    jTextFieldOn1 = new JTextField();
//    bxStats = Box.createVerticalBox();
    jLabelT = new JLabel();
    jTextFieldT = new JTextField();
    boxT = Box.createVerticalBox();
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setResizable(false);

    jLabelOn.setText("On");
    jTextFieldOn.setEditable(false);
    jTextFieldOn.setText(String.valueOf(nrn.getNrOut(iLy,iNr)));
    jButton1.setText("Занести");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jLabelT.setText("T");
    jTextFieldT.setText(String.valueOf(nrn.getTchNeuron(iLy,iNr)));
    jTextFieldT.setEditable(false);
    this.getContentPane().add(jToolBar1,  BorderLayout.NORTH);
    boxOn.add(jLabelOn, null);
    boxOn.add(jTextFieldOn, null);
    jComboBox1.addItem("Не задан");
    jComboBox1.addItem("Не рассчитан");
    jComboBox1.addItem("Рассчитан");
    jComboBox1.setSelectedIndex(nrn.getNeurReady(iLy,iNr)+1);
    jComboBox2.addItem("Не подготовлен");
    jComboBox2.addItem("Не обучен");
    jComboBox2.addItem("Обучен");
    jComboBox2.setSelectedIndex(nrn.getNeurTchReady(iLy,iNr)+1);
    boxT.add(jLabelT, null);
    boxT.add(jTextFieldT, null);
    jToolBar1.add(boxT, null);
    jToolBar1.add(jComboBox2, null);
    jToolBar1.add(jComboBox1, null);
    jToolBar1.add(jButton1, null);
    jToolBar1.add(boxOn, null);
    this.getContentPane().add(jPanel1,  BorderLayout.SOUTH);
    this.getContentPane().add(jPanel2,  BorderLayout.CENTER);


    boxW=new Box[fW.length];
    jLabelW=new JLabel[fW.length];
    jTextFieldW=new JTextField[fW.length];
    boxIn=new Box[fW.length];
    jLabelIn=new JLabel[fW.length];
    jTextFieldIn=new JTextField[fW.length];

    for(int k=0;k<fW.length;k++)
    {
      boxW[k] = Box.createVerticalBox();
      jPanel1.add(boxW[k], null);
      jLabelW[k] = new JLabel();
      jLabelW[k].setText("W"+k);
      boxW[k].add(jLabelW[k], null);
      jTextFieldW[k] = new JTextField();
      jTextFieldW[k].setText(""+fW[k]);
      boxW[k].add(jTextFieldW[k], null);

      boxIn[k] = Box.createVerticalBox();
      jPanel2.add(boxIn[k], null);
      jLabelIn[k] = new JLabel();
      jLabelIn[k].setText("In"+k);
      boxIn[k].add(jLabelIn[k], null);
      jTextFieldIn[k] = new JTextField();
      if(k==0 && nrn.getNeurStatus(iLy,iNr)!=-1)
        jTextFieldIn[k].setEditable(false);
      jTextFieldIn[k].setText(""+fO[k]);
      boxIn[k].add(jTextFieldIn[k], null);
    }

  }

  void jButton1_actionPerformed(ActionEvent e) {
    for(int k=0;k<fW.length;k++)
    {
//      fW[k]=Float.valueOf(jTextFieldW[k].getText()).floatValue();
      nrn.setW(iLy,iNr, k, Float.valueOf(jTextFieldW[k].getText()).floatValue());
      nrn.setInNeuron(iLy,iNr, k,Float.valueOf(jTextFieldIn[k].getText()).floatValue());
//      jComboBox1.getSelectedIndex();
      jPnNrNet.paint(jPnNrNet.getGraphics());
    }
  }
}

