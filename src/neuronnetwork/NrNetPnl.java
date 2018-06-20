package neuronnetwork;

import javax.swing.JPanel;
import java.awt.*;
import neurnetmodel.NeuronNet;
import java.awt.event.*;

/**
 * <p>Title: Neural Network</p>
 * <p>Description: Aspirant work</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author mrka
 * @version 1.0
 */

public class NrNetPnl extends JPanel {
  NeuronNet nrn;

  int neurXY[][][];
  int iQntLay;

  static final int NrRad=30;//������ ������������� �������
  static final int iValMin=-5, iValMax=5;


  public void setNrNet(NeuronNet nrn1, int neurXY1[][][], int iQntLay1){
    nrn=nrn1;
    neurXY=neurXY1;
    iQntLay=iQntLay1;
  }

  public void paint(Graphics g){
    int i0,j0,k0;
    Color grcolor;

    g.clearRect(0,0,this.getWidth(),this.getHeight());

    for(int i=0;i<iQntLay;i++) {
      int iQntNeur=nrn.getQntNetLayerNeurons(i);
      for(int j=0;j<iQntNeur;j++) {
        switch(nrn.getNeurReady(i,j)) {
          case 0:
            grcolor=new Color(0,0,0);
            break;
          case 1:
            float o;
            o=nrn.getNrOut(i,j);
            float z;
            z=(iValMax-iValMin)/2+iValMin;
            if(o>z) {
              float a;
              a=(nrn.getNrOut(i,j)+z)/(iValMax-z);
              int c;
              c=(int)(126*a);
              if(c>126) c=126;
              grcolor=new Color(126+c,126-c,0);
            }
            else {
              float a;
              a=(nrn.getNrOut(i,j)-z)/(iValMin+z);
              int c;
              c=(int)((255-150)*a);
              if(c>126) c=126;
              grcolor=new Color(126-c,126+c,0);
            }
            break;
          default:
            grcolor=new Color(0,0,255);
        }
        g.setColor(grcolor);
        switch(nrn.getNeurStatus(i,j)) {
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
        for(int k=0;k<iQntCnt;k++) {
          i0=nrn.getLayer(i,j,k);
          if(i0==-1) continue;
          j0=nrn.getNrnNum(i,j,k);
          g.drawLine(neurXY[i][j][0]+NrRad/2, neurXY[i][j][1]+NrRad/2, neurXY[i0][j0][0]+NrRad/2, neurXY[i0][j0][1]+NrRad/2);
        }
      }
    }
  }
}