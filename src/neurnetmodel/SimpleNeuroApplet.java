package neurnetmodel;

import NeuronNet;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import borland.jbcl.layout.*;

public class SimpleNeuroApplet extends Applet implements ActionListener{

  NeuronNet nrn;
  XYLayout xYLayout1;
  Panel pnlMenu;
  Panel pnlIn;
  Panel pnlOut;
  XYLayout xYLayoutMenu;
  XYLayout xYLayoutIn;
  XYLayout xYLayoutOut;
  TextField txtfldNet;
  TextField txtfld[];
  Label labl[];
  TextField txtfldOut[];
  Label lablOut[];
//  TextField txtfldW[][][];
//  Label lablW[][][];
  int XY[][][][];
  int neurXY[][][];
  int iQNTIn;
  int iQNTOut;
  int iQntLay;
  int WWidth, WHeight;
  private NeuronWindow NrWind;

  int iYStart=100, iXStart=5;
  int iXSteep=35, iYNxtLy=70, iYNxtLyW=50;
  int iYMenu=40, iYIn=65, iYOut=60;
  int NrRad=30;//Радиус отображаемого нейрона
  int iValMin=-5, iValMax=5;

  Choice choiceNrNet;
  Canvas canvasNrNet;
  TextField textField1 = new TextField();

  public void init()
  {
    int iNet=3;
    xYLayout1 = new XYLayout();
    this.setLayout(xYLayout1);
//    this.setSize(600, 400);

    pnlMenu=new Panel();
    xYLayoutMenu = new XYLayout();
    pnlMenu.setLayout(xYLayoutMenu);
    pnlMenu.setSize(new Dimension(150, iYMenu));

    Button b=new Button("Рассчет");
    b.addActionListener(this);
    pnlMenu.add(b, new XYConstraints(5, 5, 75, -1));

    choiceNrNet = new Choice();
    choiceNrNet.addItem("0");
    choiceNrNet.addItem("1");
    choiceNrNet.addItem("2");
    choiceNrNet.addItem("3");
    choiceNrNet.select(""+iNet);
    choiceNrNet.addItemListener(new SimpleNeuroApplet_choice_itemAdapter(this));
    pnlMenu.add(choiceNrNet,new XYConstraints(100, 5, 40, -1));
    this.add(pnlMenu,new XYConstraints(0, 5, -1, -1));

    pnlIn=new Panel();

    xYLayoutIn = new XYLayout();
    pnlIn.setLayout(xYLayoutIn);
    this.add(pnlIn,new XYConstraints(0, 35, -1, -1));

    canvasNrNet=new Canvas();
    canvasNrNet.addMouseListener(new SimpleNeuroApplet_this_mouseAdapter(this));
    this.add(canvasNrNet,new XYConstraints(0, 90, -1, -1));

    pnlOut=new Panel();
    xYLayoutOut = new XYLayout();
    pnlOut.setLayout(xYLayoutOut);
    this.add(pnlOut,new XYConstraints(0, 350, -1, -1));

    setNet(iNet);
  }


  void setNet(int iNet)
  {
    int i;
    int pnlY;


    pnlY=iYMenu;
    nrn=new NeuronNet(1,2,0,iNet);

    iQntLay=nrn.getQntNetLayers();
    iQNTIn=nrn.getQntInptNeuron();
    iQNTOut=nrn.getQntOutpNeuron();

    int iMaxNr=0;
    for(i=0;i<iQntLay;i++)
    {
      int iQntNeur=nrn.getQntNetLayerNeurons(i);
      if(iMaxNr<iQntNeur) iMaxNr=iQntNeur;
    }

    int WWidth1=iQNTIn*iXSteep+10+35;//35-Все опять же неправильный вывод W
    int WWidth2=iQNTOut*(iXSteep+20)+10+35;
    int WWidth3=iMaxNr*iXSteep+10+35;
    if(WWidth1>WWidth2) WWidth=WWidth1;
    else WWidth=WWidth2;
    if(WWidth<WWidth3) WWidth=WWidth3;

//    WWidth=iMaxNr*iXSteep+10+35;



//Панель значений входа сети
/*    pnlIn=new Panel();
*/
    txtfld=new TextField[iQNTIn];
    labl=new Label[iQNTIn];
    for(i=0;i<iQNTIn;i++)
    {
      labl[i]=new Label();
      labl[i].setText("In"+i);

//      pnlIn.add(labl[i], new XYConstraints(5+iXSteep*i, 0, 29, -1));
      pnlIn.add(labl[i]);
      labl[i].setLocation(5+iXSteep*i,0);

      txtfld[i]=new TextField();
      txtfld[i].setSize(new Dimension(24, 23));
      txtfld[i].setText("-5");
//      pnlIn.add(txtfld[i], XYConstraints(5+iXSteep*i, 25, -1, -1));
      pnlIn.add(txtfld[i]);
      txtfld[i].setLocation(5+iXSteep*i,25);
    }

    pnlIn.setSize(new Dimension(WWidth, iYIn));
//    this.add(pnlIn,new XYConstraints(0, pnlY, -1, -1));
    pnlIn.setLocation(0,pnlY);
////////////////******************88
    pnlY+=iYIn;

//!!!!!!!!!Сделать чтобы при определении ширины окна учитывалось и возможно большее кол-во нейронов в слое, а высоты кол-во слоев

//Расчет координат размещение нейронов
    XY=new int[iQntLay][][][];
    neurXY=new int[iQntLay][][];

    int y=0;
    for(i=0;i<iQntLay;i++)
    {
      int iQntNeur=nrn.getQntNetLayerNeurons(i);

      XY[i]=new int[iQntNeur][][];
      neurXY[i]=new int[iQntNeur][];

      int x=(WWidth-2*iXStart-iQntNeur*iXSteep)/2+iXStart;
      for(int j=0;j<iQntNeur;j++)
      {
        float fW[];
        fW=nrn.getW(i,j);
        int iQntW=fW.length;
        XY[i][j]=new int[iQntW][];
        neurXY[i][j]=new int[2];
        neurXY[i][j][0]=x;
        neurXY[i][j][1]=y;
        x+=iXSteep;
      }
      y+=iYNxtLy;
    }

/*    canvasNrNet=new Canvas();
    canvasNrNet.addMouseListener(new SimpleNeuroApplet_this_mouseAdapter(this));*/
    canvasNrNet.setSize(new Dimension(WWidth, y));
//    this.add(canvasNrNet,new XYConstraints(0, pnlY, -1, -1));
    canvasNrNet.setLocation(0,pnlY);
    ////////////////*****************
    pnlY+=y;

//Панель значений выхода нейронной сети
/*    pnlOut=new Panel();
    xYLayoutOut = new XYLayout();
    pnlOut.setLayout(xYLayoutOut);*/
    txtfldOut=new TextField[iQNTOut];
    lablOut=new Label[iQNTOut];
    for(i=0;i<iQNTOut;i++)
    {
      lablOut[i]=new Label();
      lablOut[i].setText("Out"+i);
//      pnlOut.add(lablOut[i], new XYConstraints(5+(iXSteep+20)*i, 0, 35, -1));
      pnlOut.add(lablOut[i]);
      lablOut[i].setLocation(5+(iXSteep+20)*i, 0);
      txtfldOut[i]=new TextField();
      txtfldOut[i].setSize(new Dimension(24, 23));
      txtfldOut[i].setText("*");
      txtfldOut[i].setEditable(false);
//      pnlOut.add(txtfldOut[i], new XYConstraints(5+(iXSteep+20)*i, 25, 50, -1));
      pnlOut.add(txtfldOut[i]);
      txtfldOut[i].setLocation(5+(iXSteep+20)*i, 25);
    }
    pnlOut.setSize(new Dimension(WWidth, iYOut));
//    this.add(pnlOut,new XYConstraints(0, pnlY, -1, -1));
    pnlOut.setLocation(0,pnlY);
////////////////******************
    pnlY+=iYNxtLy;
    this.setSize(WWidth, pnlY);

}

  public void actionPerformed(ActionEvent e)
  {
    String arg = e.getActionCommand();

    if(arg.equals("Рассчет"))
    {
      nrn.netReset();
      float f;
      int i;

      for(i=0;i<iQNTIn;i++)
      {
        f=Float.valueOf(txtfld[i].getText()).floatValue();
        nrn.setInptNeuron(i,f);
      }

      nrn.calcNet();
      SetOut();
//      repaint();
      NetDraw();
    }

    if(arg.equals("Обучить"))
    {
/*      nrn.apply_teach(); */
      repaint();
    }
  }


  void SetOut()
  {
      for(int i=0;i<iQNTOut;i++)
      {
        txtfldOut[i].setText(""+nrn.getOtpNeuron(i)); //!!!!!!!!!сделать нормально
      }

  }

  public void NetDraw()
  {
    Graphics g;
    int i0,j0,k0;
    Color grcolor;

    g=canvasNrNet.getGraphics();

    for(int i=0;i<iQntLay;i++)
    {
      int iQntNeur=nrn.getQntNetLayerNeurons(i);
      for(int j=0;j<iQntNeur;j++)
      {
        switch(nrn.getNeurReady(i,j))//Ввести еще средний цвет для неопределенного состояния нейрона
        {
          case 0:
            grcolor=new Color(0,0,0);
            break;
          case 1:
            float o;
            o=nrn.getNrOut(i,j);
            float z;
            z=(iValMax-iValMin)/2+iValMin;
            if(o>z)
            {
              float a;
              a=(nrn.getNrOut(i,j)+z)/(iValMax-z);
              int c;
              c=(int)(126*a);
              grcolor=new Color(126+c,126-c,0);
            }
            else
            {
              float a;
              a=(nrn.getNrOut(i,j)-z)/(iValMin+z);
              int c;
              c=(int)((255-150)*a);
              grcolor=new Color(126-c,126+c,0);
            }
            break;
          default:
            grcolor=new Color(0,0,255);
        }
        g.setColor(grcolor);
        switch(nrn.getNeurStatus(i,j))
        {
          case -1:
            g.fillRect(neurXY[i][j][0],neurXY[i][j][1],NrRad,NrRad);
            break;
          case 1:
            g.fillRoundRect(neurXY[i][j][0],neurXY[i][j][1],NrRad,NrRad, NrRad/2,NrRad/2);
            break;
          default:
            g.fillOval(neurXY[i][j][0],neurXY[i][j][1],NrRad,NrRad);
        }

        int iQntCnt=nrn.getQntCnct(i,j);
        for(int k=0;k<iQntCnt;k++)
        {
          i0=nrn.getLayer(i,j,k);
          if(i0==-1) continue;
          j0=nrn.getNrnNum(i,j,k);
          g.drawLine(neurXY[i][j][0]+NrRad/2, neurXY[i][j][1]+NrRad/2, neurXY[i0][j0][0]+NrRad/2, neurXY[i0][j0][1]+NrRad/2);
        }
      }
    }


//        canvasNrNet.paint(g);
  }

/*  public void show()
  {
    super.show();
    NetDraw();
  }*/

/*  public void repaint()
  {
    super.repaint();
    NetDraw();
  }
*/
  public void paint(Graphics g)
  {
    NetDraw();
  }

///////////JBuilderAdded
  public SimpleNeuroApplet() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void jbInit() throws Exception{

  }

  void this_mouseClicked(MouseEvent e) {
    boolean blFind=false;
    int mx=e.getX();
    int my=e.getY();

    for(int i=0;i<iQntLay;i++)
    {
      int iQntNeur=nrn.getQntNetLayerNeurons(i);
      for(int j=0;j<iQntNeur;j++)
      {
        int nx=neurXY[i][j][0];
        int ny=neurXY[i][j][1];
        if(mx>nx &&
           mx<(nx+NrRad) &&
           my>ny &&
           my<(ny+NrRad))
        {
           blFind=true;
           float fW[];
           fW=nrn.getW(i,j);
           NrWind=new NeuronWindow("Нейрон N"+j+" слоя"+i,nrn,i,j);
           NrWind.pack();
           NrWind.show();
           break;
        }
      }
      if(blFind) break;
    }
  }

  void choiceNrNet_itemStateChanged(ItemEvent e) {
    int i;

    for(i=0;i<labl.length;i++)
    {
      labl[i].removeNotify();
      txtfld[i].removeNotify();
      xYLayoutIn.removeLayoutComponent(labl[i]);
      xYLayoutIn.removeLayoutComponent(txtfld[i]);
    }

    for(i=0;i<lablOut.length;i++)
    {
      lablOut[i].removeNotify();
      txtfldOut[i].removeNotify();
      xYLayoutOut.removeLayoutComponent(labl[i]);
      xYLayoutOut.removeLayoutComponent(txtfld[i]);
    }

//    pnlIn.removeNotify();
//    canvasNrNet.removeNotify();
//    pnlOut.removeNotify();
//    pnlMenu.removeNotify();
//    xYLayout1.removeLayoutComponent(pnlIn);
//    xYLayout1.removeLayoutComponent(canvasNrNet);
//    xYLayout1.removeLayoutComponent(pnlOut);
//    xYLayout1.removeLayoutComponent(pnlMenu);

    setNet(choiceNrNet.getSelectedIndex());
    repaint();
  }
}

class SimpleNeuroApplet_this_mouseAdapter extends java.awt.event.MouseAdapter {
  SimpleNeuroApplet adaptee;

  SimpleNeuroApplet_this_mouseAdapter(SimpleNeuroApplet adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.this_mouseClicked(e);
  }
}

class SimpleNeuroApplet_choice_itemAdapter implements java.awt.event.ItemListener {
  SimpleNeuroApplet adaptee;

  SimpleNeuroApplet_choice_itemAdapter(SimpleNeuroApplet adaptee) {
    this.adaptee = adaptee;
  }

  public void itemStateChanged(ItemEvent e) {
    adaptee.choiceNrNet_itemStateChanged(e);
  }
}

class NeuronWindow extends Frame {
  Label lablW[];
  TextField txtfldW[];
  Label lablOn;
  Label lablLW;//Line W
  Label lablLI;//Line In
  TextField txtfldOn;
//  Label lablOn[];
  TextField txtfldO[];
  int iXFldSteep=45;
  XYLayout xYLayout1 = new XYLayout();
  float fW[],fO[];
  NeuronNet nrn;
  int iLy, iNr;

  NeuronWindow(String title, NeuronNet nrNet, int iLy0, int iNr0){
    Button b;

    nrn=nrNet;
    iLy=iLy0;
    iNr=iNr0;
    fW=nrn.getW(iLy,iNr);
    fO=nrn.getO(iLy,iNr);
    setTitle(title);
    this.setSize(new Dimension(400, 250));
    this.setLayout(xYLayout1);

//    b=new Button("Закрыть");
//    this.add(b, new XYConstraints(5, 5, 50, -1));
    b=new Button("Занести");
    this.add(b, new XYConstraints(60, 5, -1, -1));

    lablW=new Label[fW.length];
    txtfldW=new TextField[fW.length];
    txtfldO=new TextField[fW.length];
    lablOn=new Label();
    lablOn.setText("Out");
    this.add(lablOn, new XYConstraints(5, 30, 29, -1));
    lablLW=new Label();
    lablLW.setText("W:");
    this.add(lablLW, new XYConstraints(2, 115, 20, -1));
    lablLI=new Label();
    lablLI.setText("In:");
    this.add(lablLI, new XYConstraints(2, 140, 20, -1));

    txtfldOn=new TextField();
    txtfldOn.setText(""+nrn.getNrOut(iLy,iNr));
//    txtfldOn.setEditable(true);
    this.add(txtfldOn, new XYConstraints(5, 55, 50, -1));
    for(int k=0;k<fW.length;k++)
    {
      lablW[k]=new Label();
      lablW[k].setText("In"+k);
      this.add(lablW[k], new XYConstraints(25+iXFldSteep*k, 90, iXFldSteep-2, -1));

      txtfldW[k]=new TextField();
      txtfldW[k].setSize(new Dimension(24, 23));
      txtfldW[k].setText(""+fW[k]);
      this.add(txtfldW[k], new XYConstraints(25+iXFldSteep*k, 115, iXFldSteep-2, -1));

      txtfldO[k]=new TextField();
      txtfldO[k].setSize(new Dimension(24, 23));
      txtfldO[k].setText(""+fO[k]);
      this.add(txtfldO[k], new XYConstraints(25+iXFldSteep*k, 140, iXFldSteep-2, -1));
    }
  }

  public boolean action (Event evt, Object arg){
    if(arg.equals("Занести")){
      for(int k=0;k<fW.length;k++)
        fW[k]=Float.valueOf(txtfldW[k].getText()).floatValue();
      return true;
    }
//    return super.handleEvent(evt);
    return true;
  }

  public boolean handleEvent (Event evt){
    if(evt.id==Event.WINDOW_DESTROY){
      dispose();
      return true;
    }
//    return super.handleEvent(evt);
    return true;
  }
}


