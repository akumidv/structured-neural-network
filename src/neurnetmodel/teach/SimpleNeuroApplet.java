import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import Neuron;


public class SimpleNeuroApplet extends Applet implements ActionListener
{
  Neuron nrn;

  TextField txtfldQ;
  TextField txtfldO0;
  TextField txtfldO1;
  TextField txtfldO2;
  TextField txtfldT;

  public void init()
  {
    nrn=new Neuron(3,0,1,0);

    resize(500,250);
/*    GridLayout grid = new GridLayout(2,2);
    setLayout(grid);*/
    Button b=new Button("Рассчитать");
    b.addActionListener(this);
    add(b);
    b=new Button("Обучить");
    b.addActionListener(this);
    add(b);

    
    txtfldQ=new TextField("5",5);
    add(txtfldQ);
    txtfldO0=new TextField("-5",4);
    add(txtfldO0);
    txtfldO1=new TextField("-5",4);
    add(txtfldO1);
    txtfldO2=new TextField("-5",4);
    add(txtfldO2);
    txtfldT=new TextField("0.1",5);
    add(txtfldT);
  }

  public void actionPerformed(ActionEvent e) 
  {
    String arg = e.getActionCommand();
    if(arg=="Рассчитать")
    {
      repaint();
    }
    if(arg=="Обучить")
    {
      nrn.apply_teach();
      repaint();
    }
  }


  public void paint(Graphics g)
  {
    nrn.setQ(Float.valueOf(txtfldQ.getText()).floatValue());
    g.drawString("Q:"+nrn.getQ(),0,50);

    float f[]=new float[3];
    f[0]=Float.valueOf(txtfldO0.getText()).floatValue();
    f[1]=Float.valueOf(txtfldO1.getText()).floatValue();
    f[2]=Float.valueOf(txtfldO2.getText()).floatValue();
    nrn.setO(f);

    g.drawString("O1:"+nrn.getO(0),50,50);
    g.drawString("O2:"+nrn.getO(1),150,50);
    g.drawString("O3:"+nrn.getO(2),300,50);

    g.drawString("Neuron:"+nrn.calc_neuron(),0,75);
    g.drawString("Net Out:"+nrn.getOn(),150,75);

/*    nrn.setT(Float.valueOf(txtfldT.getText()).floatValue());
    g.drawString("T:"+nrn.getT(),0,100);*/

    g.drawString("W0:"+nrn.getW(0),0,125);
    g.drawString("W1:"+nrn.getW(1),150,125);
    g.drawString("W2:"+nrn.getW(2),300,125);
/*    nrn.teach();
    g.drawString("G:"+nrn.getG(),0,150);
    g.drawString("WChng0:"+nrn.getWChng(0),0,175);
    g.drawString("WChng1:"+nrn.getWChng(1),150,175);
    g.drawString("WChng2:"+nrn.getWChng(2),300,175);*/
  }
}