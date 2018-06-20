package neurnetmodel;

import neurnetmodel.Neuron;

public class NeuronNet
{
  int iTypeNeuronNet;
  int iMaxQntIterNet;

  int iTeachAlg;
  int iCalcAlg;

  Neuron nrNet[][];

  public NeuronNet(int iModel,int iActivFunc, int iTeachMethod, int iCalcMethod, int iNet)
  {
    int i;

    iTypeNeuronNet=iNet;
    iTeachAlg=iTeachMethod;
    iCalcAlg=iCalcMethod;
    initnet(iModel, iActivFunc);
  }

  void initnet(int iModel,int iActivFunc)
  {
    int i;
    int arNrnCnct[][];

//    System.out.println("Model N"+iTypeNeuronNet);
    switch(iTypeNeuronNet)
    {
      case 0:
        nrNet=new Neuron[2][];
        nrNet[0]=new Neuron[3];
        nrNet[1]=new Neuron[1];

/* ������ ����� ������� �������� � �������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[0][2]=new Neuron(1,0, 0, arNrnCnct,(short)-1);

/* ������ �������� ������ � 3 ������� + 1 �����=4 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[1][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)1);
        break;

      case 1: /*������ �� 3�2�1*/
        nrNet=new Neuron[3][];
        nrNet[0]=new Neuron[3];
        nrNet[1]=new Neuron[2];
        nrNet[2]=new Neuron[1];

/* ������ ����� ������ � �������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=1;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=2;
        nrNet[0][2]=new Neuron(1,0, 0, arNrnCnct,(short)-1);

/* ������ ������ � 2 ������� + 1 �����=3 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[1][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[1][0].setW(0,2.5f);

/* ������ ������ � 2 ������� + 1 �����=3 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[1][1]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[1][1].setW(0,2.5f);

/* ������ ������ � 2 ������� + 1 �����=3 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[2][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)1);
        nrNet[2][0].setW(0,2.5f);
        break;
/*****************************************************************************/
      case 2: /* 14x2x12x2 */

        nrNet=new Neuron[5][];
        nrNet[0]=new Neuron[16];
        nrNet[1]=new Neuron[2];
        nrNet[2]=new Neuron[12];
        nrNet[3]=new Neuron[3];
        nrNet[4]=new Neuron[2];

/* 1L ***************/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;//
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;//
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;//
        nrNet[0][2]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;//
        nrNet[0][3]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=1;//
        nrNet[0][4]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=3;
        arNrnCnct[2][0]=1;//
        nrNet[0][5]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=4;
        arNrnCnct[2][0]=1;//
        nrNet[0][6]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=5;
        arNrnCnct[2][0]=1;//
        nrNet[0][7]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=6;
        arNrnCnct[2][0]=1;//
        nrNet[0][8]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=6;
        arNrnCnct[2][0]=2;//
        nrNet[0][9]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=7;
        arNrnCnct[2][0]=1;//
        nrNet[0][10]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;//
        nrNet[0][11]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
//
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=8;
        arNrnCnct[2][0]=1;//
        nrNet[0][12]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
//
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=9;
        arNrnCnct[2][0]=1;//
        nrNet[0][13]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=10;
        arNrnCnct[2][0]=1;//
        nrNet[0][14]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=11;
        arNrnCnct[2][0]=1;//
        nrNet[0][15]=new Neuron(1,0, 0, arNrnCnct,(short)-1);

/* 2L *****************/
        arNrnCnct=new int[3][9];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;//
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=0;
        arNrnCnct[2][1]=2;//
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=1;
        arNrnCnct[2][2]=2;//
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=2;
        arNrnCnct[2][3]=2;//
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=3;
        arNrnCnct[2][4]=2;//
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=4;
        arNrnCnct[2][5]=2;//
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=5;
        arNrnCnct[2][6]=2;//
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=6;
        arNrnCnct[2][7]=3;//
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=7;
        arNrnCnct[2][8]=2;//
        nrNet[1][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[1][0].setW(0,2.5f);
        arNrnCnct=new int[3][5];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;//
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=8;
        arNrnCnct[2][1]=2;//
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=9;
        arNrnCnct[2][2]=2;//
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=10;
        arNrnCnct[2][3]=2;//
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=11;
        arNrnCnct[2][4]=2;//
        nrNet[1][1]=new Neuron(2,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[1][1].setW(0,0f);

/* 3L */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;//
        nrNet[2][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][0].setW(0,2.5f);
        nrNet[2][0].setW(1,2f);
        nrNet[2][0].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;//
        nrNet[2][1]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][1].setW(0,2.5f);
        nrNet[2][1].setW(1,2f);
        nrNet[2][1].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;//
        nrNet[2][2]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][2].setW(0,2.5f);
        nrNet[2][2].setW(1,2f);
        nrNet[2][2].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=4;//
        nrNet[2][3]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][3].setW(0,2.5f);
        nrNet[2][3].setW(1,2f);
        nrNet[2][3].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;//
        nrNet[2][4]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][4].setW(0,2.5f);
        nrNet[2][4].setW(1,2f);
        nrNet[2][4].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=2;//
        nrNet[2][5]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][5].setW(0,2.5f);
        nrNet[2][5].setW(1,2f);
        nrNet[2][5].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=3;//
        nrNet[2][6]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][6].setW(0,3.5f);
        nrNet[2][6].setW(1,2f);
        nrNet[2][6].setW(2,2f);
        nrNet[2][6].setW(3,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=4;//
        nrNet[2][7]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][7].setW(0,2.5f);
        nrNet[2][7].setW(1,2f);
        nrNet[2][7].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=1;//
        nrNet[2][8]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][8].setW(0,2.5f);
        nrNet[2][8].setW(1,2f);
        nrNet[2][8].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=2;//
        nrNet[2][9]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][9].setW(0,2.5f);
        nrNet[2][9].setW(1,2f);
        nrNet[2][9].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=3;//
        nrNet[2][10]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][10].setW(0,2.5f);
        nrNet[2][10].setW(1,2f);
        nrNet[2][10].setW(2,1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=4;//
        nrNet[2][11]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[2][11].setW(0,2.5f);
        nrNet[2][11].setW(1,2f);
        nrNet[2][11].setW(2,1f);

/* 4L ������ ������ � 1 ������� + 1 �����=2 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;//
        nrNet[3][0]=new Neuron(5,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[3][0].setW(0,6f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=2;//
        nrNet[3][1]=new Neuron(5,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[3][1].setW(0,6f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=3;//
        nrNet[3][2]=new Neuron(5,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[3][2].setW(0,6f);


/* 5L */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[4][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)1);
        nrNet[4][0].setW(0,1.5f);

        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[4][1]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)1);
        nrNet[4][1].setW(0,5f);
        break;
/*****************************************************************************/
      case 3: /*������ �� 6�3�1*/
        nrNet=new Neuron[3][];
        nrNet[0]=new Neuron[6];
        nrNet[1]=new Neuron[3];
        nrNet[2]=new Neuron[1];

/* ������ ����� ������ � �������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[0][2]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;
        nrNet[0][3]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=2;
        nrNet[0][4]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=1;
        nrNet[0][5]=new Neuron(1,0, 0, arNrnCnct,(short)-1);

/* 2L*/
        arNrnCnct=new int[3][3];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=3;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=2;
        nrNet[1][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0);
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=2;
        arNrnCnct[2][1]=3;
        nrNet[1][1]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[1][1].setW(0,5f);
        nrNet[1][1].setW(1,3f);
        nrNet[1][1].setW(2,3f);
        nrNet[1][1].setW(3,-1f);
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[1][2]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0);
        nrNet[1][2].setW(0,8f);
        nrNet[1][2].setW(1,5f);
        nrNet[1][2].setW(2,-1f);
        nrNet[1][2].setW(3,-2f);

/* 3L */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[2][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)1);
//        nrNet[1][1].setW(0,2.5f);
        break;
/*****************************************************************************/
      case 4: /*������ �� 2�2�1*/
        iActivFunc=0;
        nrNet=new Neuron[3][];
        nrNet[0]=new Neuron[2];
        nrNet[1]=new Neuron[2];
        nrNet[2]=new Neuron[1];

/* ������ ����� ������ � �������� */
        arNrnCnct=new int[3][3];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=0;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=1;
        arNrnCnct[2][2]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=2;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1);

/* 1L */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[1][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
//        nrNet[1][0].setW(0,2f);
        nrNet[1][0].setW(0,0f);
        nrNet[1][0].setW(1,1f);
        nrNet[1][0].setW(2,-2f);
        /* ������ ������ � 2 ������� + 1 �����=3 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[1][1]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
//        nrNet[1][1].setW(0,-2f);
        nrNet[1][1].setW(0,0f);
        nrNet[1][1].setW(1,-1f);
        nrNet[1][1].setW(2,2f);
/* 2L*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[2][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)1);
        nrNet[2][0].setW(0,0f);
        nrNet[2][0].setW(1,1f);
        nrNet[2][0].setW(2,-3f);
        nrNet[2][0].setW(3,-3f);
        break;
/*****************************************************************************/
      case 5: /*������ �� 2�2�1*/
        iActivFunc=1;
        nrNet=new Neuron[3][];
        nrNet[0]=new Neuron[2];
        nrNet[1]=new Neuron[2];
        nrNet[2]=new Neuron[1];

/* ������ ����� ������ � �������� */
        arNrnCnct=new int[3][3];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=0;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=1;
        arNrnCnct[2][2]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1);
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=2;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1);

/* 1L */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[1][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
//        nrNet[1][0].setW(0,3f);
        nrNet[1][0].setW(0,0f);
        nrNet[1][0].setW(1,1f);
        nrNet[1][0].setW(2,2f);
        /* ������ ������ � 2 ������� + 1 �����=3 */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[1][1]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0);
//        nrNet[1][1].setW(0,3f);
        nrNet[1][1].setW(0,0f);
        nrNet[1][1].setW(1,-1f);
        nrNet[1][1].setW(2,2f);
/* 2L*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[2][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)1);
        nrNet[2][0].setW(0,-5f);
        nrNet[2][0].setW(1,0f);
        nrNet[2][0].setW(2,0.5f);
        nrNet[2][0].setW(3,0.5f);
        break;
/*****************************************************************************/
      case 6: /*�� ���������������� ����������*/
//        iActivFunc=1;
        nrNet=new Neuron[6][];
        nrNet[0]=new Neuron[11];
        nrNet[1]=new Neuron[3];
        nrNet[2]=new Neuron[6];
        nrNet[3]=new Neuron[5];
        nrNet[4]=new Neuron[3];
        nrNet[5]=new Neuron[1];

/* ������������� ������� */
        arNrnCnct=new int[3][3];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1,"��������� ������ ����������");
        arNrnCnct=new int[3][4];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=0;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=1;
        arNrnCnct[2][2]=2;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=2;
        arNrnCnct[2][3]=2;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1,"��������� ������ ������ ��������");
        arNrnCnct=new int[3][4];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=0;
        arNrnCnct[2][1]=2;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=1;
        arNrnCnct[2][2]=3;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=2;
        arNrnCnct[2][3]=3;
        nrNet[0][2]=new Neuron(1,0, 0, arNrnCnct,(short)-1,"��������� ������ ������� ��������");
/* �������� ����������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;
        nrNet[0][3]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "�������� �����������");
/* ���������� � ���� - ��������������, ����������� ��������� */
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=3;
        arNrnCnct[2][1]=1;
        nrNet[0][4]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "���������� � ����");
/* ��������� ����������� ��������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=3;
        arNrnCnct[2][0]=2;
        nrNet[0][5]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "��������� ����������� ���������");
/* �������� � ����� ���������� */
        arNrnCnct=new int[3][4];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=4;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=5;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=1;
        arNrnCnct[2][2]=3;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=2;
        arNrnCnct[2][3]=3;
        nrNet[0][6]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "�������� � ����� ����������");
/* ��������� ���� */
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=2;
        arNrnCnct[2][1]=1;
        nrNet[0][7]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "��������� ����");
/* �������� �������� ������ */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[0][8]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "�������� �������� ������");
/* ���������� �� ����� ������ �������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[0][9]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "���������� �� ����� ������ ��������");
/* ���������� �� ����� ������� �������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=4;
        nrNet[0][10]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "���������� �� ����� ������� ��������");

/* 1L */
/*����� ����������*/
        arNrnCnct=new int[3][5];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=4;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=2;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=2;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=4;
        arNrnCnct[2][3]=2;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=5;
        arNrnCnct[2][4]=2;
        nrNet[1][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0,"����� ����������");
        nrNet[1][0].setW(0,10f);
        nrNet[1][0].setW(1,1f);
        nrNet[1][0].setW(2,-1f);
        nrNet[1][0].setW(3,-1f);

/*��������� ������� ������� ���� 1*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=3;
        arNrnCnct[2][0]=1;
        nrNet[1][1]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0,"��������� ������� ������� ���� 1");
        nrNet[1][1].setW(0,-1.5f);
        nrNet[1][1].setW(1,-0.5f);
        nrNet[1][1].setW(2,1f);
        nrNet[1][1].setW(3,-0.5f);
/*��������� ������� ������� ���� 2*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=3;
        arNrnCnct[2][0]=2;
        nrNet[1][2]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0,"��������� ������� ������� ���� 2");
        nrNet[1][2].setW(0,-1.5f);
        nrNet[1][2].setW(1,0.5f);
        nrNet[1][2].setW(2,-1f);
        nrNet[1][2].setW(3,0.5f);

/* 2L */
/*����� ������ ��������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[2][0]=new Neuron(5,iModel, iActivFunc, arNrnCnct,(short)0,"����� ������ ��������");
        nrNet[2][0].setW(0,5f);
        nrNet[2][0].setW(1,1f);
        nrNet[2][0].setW(2,-1f);
        nrNet[2][0].setW(3,1f);
        nrNet[2][0].setW(4,1f);
/*����� ������� ��������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[2][1]=new Neuron(5,iModel, iActivFunc, arNrnCnct,(short)0,"����� ������� ��������");
        nrNet[2][1].setW(0,12.5f);
        nrNet[2][1].setW(1,-1f);
        nrNet[2][1].setW(2,-1f);
        nrNet[2][1].setW(3,1f);
        nrNet[2][1].setW(4,1f);
/*����� ���������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[2][2]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0,"����� ���������");
        nrNet[2][2].setW(0,10f);
        nrNet[2][2].setW(1,-1f);
        nrNet[2][2].setW(2,-1f);
        nrNet[2][2].setW(3,-1f);
/*����*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=1;
        nrNet[2][3]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"����");
        nrNet[2][3].setW(0,2.5f);
        nrNet[2][3].setW(1,1.5f);
        nrNet[2][3].setW(2,1.5f);

/*��������� ������� ������� ���� ���������� 1*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=4;
        arNrnCnct[2][0]=1;
        nrNet[2][4]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"��������� ������� ������� ���� ���������� 1");
        nrNet[2][4].setW(0,-1.5f);
        nrNet[2][4].setW(1,-1f);
        nrNet[2][4].setW(2,1f);
/*��������� ������� ������� ���� ���������� 2*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=4;
        arNrnCnct[2][0]=2;
        nrNet[2][5]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"��������� ������� ������� ���� ���������� 2");
        nrNet[2][5].setW(0,-1.5f);
        nrNet[2][5].setW(1,1f);
        nrNet[2][5].setW(2,-1f);

/* 3L */
/*����� ������� ���������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[3][0]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"����� ������� ���������");
        nrNet[3][0].setW(0,-7.5f);
        nrNet[3][0].setW(1,1f);
        nrNet[3][0].setW(2,1f);
/*�������� �����������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=2;
        nrNet[3][1]=new Neuron(2,iModel, iActivFunc, arNrnCnct,(short)0,"�������� �����������");
        nrNet[3][1].setW(0,0f);
        nrNet[3][1].setW(1,1f);
/*��������������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=1;
        nrNet[3][2]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"��������������");
        nrNet[3][2].setW(0,-3.5f);
        nrNet[3][2].setW(1,1f);
        nrNet[3][2].setW(2,-0.5f);
/*����������� ���������*/
        arNrnCnct=new int[3][2];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=1;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=2;
        arNrnCnct[2][1]=2;
        nrNet[3][3]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"����������� ���������");
        nrNet[3][3].setW(0,-1f);
        nrNet[3][3].setW(1,0.5f);
        nrNet[3][3].setW(2,1f);
/*���� ����������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=4;
        arNrnCnct[1][0]=2;
        arNrnCnct[2][0]=3;
        nrNet[3][4]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"���� ����������");
        nrNet[3][4].setW(0,2.5f);
        nrNet[3][4].setW(1,1.5f);
        nrNet[3][4].setW(2,1.5f);

/* 4L */
/* ����������� ������ ������ � �������� ������ */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=5;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        nrNet[4][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0,"����������� ������ ������ � �������� ������");
        nrNet[4][0].setW(0,-2.5f);
        nrNet[4][0].setW(1,0.5f);
        nrNet[4][0].setW(2,1f);
        nrNet[4][0].setW(3,0.5f);
/* ����������� ���� ������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=5;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        nrNet[4][1]=new Neuron(3,iModel, iActivFunc, arNrnCnct,(short)0,"����������� ���� �������");
        nrNet[4][1].setW(0,2.5f);
/* ����������� ���������� ������� */
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=5;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        nrNet[4][2]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)0,"����������� ���������� �������");

/* 5L*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[5][0]=new Neuron(4,iModel, iActivFunc, arNrnCnct,(short)1,"�����");
        nrNet[5][0].setW(0,10f);
        nrNet[5][0].setW(1,1f);
        nrNet[5][0].setW(2,1f);
        nrNet[5][0].setW(3,1f);
        break;
/*****************************************************************************/

/*****************************************************************************/
      case 7: /*�� ���������������� ���������� - ���� ������� ��������������� */
//        iActivFunc=1;
        nrNet=new Neuron[4][];
        nrNet[0]=new Neuron[11];
        nrNet[1]=new Neuron[10];
        nrNet[2]=new Neuron[10];
        nrNet[3]=new Neuron[7];

/* ������������� ������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=1;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=1;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=1;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=1;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=1;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=1;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=1;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=1;
        nrNet[0][0]=new Neuron(1,0, 0, arNrnCnct,(short)-1,"��������� ������ ����������");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=2;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=2;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=2;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=2;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=2;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=2;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=2;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=2;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=2;
        nrNet[0][1]=new Neuron(1,0, 0, arNrnCnct,(short)-1,"��������� ������ ������ ��������");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=3;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=3;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=3;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=3;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=3;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=3;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=3;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=3;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=3;
        nrNet[0][2]=new Neuron(1,0, 0, arNrnCnct,(short)-1,"��������� ������ ������� ��������");
/* �������� ����������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=4;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=4;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=4;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=4;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=4;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=4;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=4;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=4;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=4;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=4;
        nrNet[0][3]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "�������� �����������");
/* ���������� � ���� - ��������������, ����������� ��������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=5;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=5;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=5;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=5;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=5;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=5;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=5;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=5;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=5;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=5;
        nrNet[0][4]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "���������� � ����");
/* ��������� ����������� ��������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=6;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=6;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=6;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=6;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=6;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=6;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=6;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=6;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=6;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=6;
        nrNet[0][5]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "��������� ����������� ���������");
/* �������� � ����� ���������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=7;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=7;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=7;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=7;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=7;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=7;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=7;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=7;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=7;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=7;
        nrNet[0][6]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "�������� � ����� ����������");
/* ��������� ���� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=8;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=8;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=8;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=8;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=8;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=8;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=8;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=8;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=8;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=8;
        nrNet[0][7]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "��������� ����");
/* �������� �������� ������ */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=9;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=9;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=9;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=9;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=9;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=9;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=9;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=9;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=9;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=9;
        nrNet[0][8]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "�������� �������� ������");
/* ���������� �� ����� ������ �������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=10;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=10;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=10;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=10;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=10;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=10;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=10;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=10;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=10;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=10;
        nrNet[0][9]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "���������� �� ����� ������ ��������");
/* ���������� �� ����� ������� �������� */
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=1;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=11;
        arNrnCnct[0][1]=1;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=11;
        arNrnCnct[0][2]=1;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=11;
        arNrnCnct[0][3]=1;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=11;
        arNrnCnct[0][4]=1;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=11;
        arNrnCnct[0][5]=1;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=11;
        arNrnCnct[0][6]=1;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=11;
        arNrnCnct[0][7]=1;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=11;
        arNrnCnct[0][8]=1;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=11;
        arNrnCnct[0][9]=1;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=11;
        nrNet[0][10]=new Neuron(1,0, 0, arNrnCnct,(short)-1, "���������� �� ����� ������� ��������");





/*1L*****************/
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=1;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=1;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=1;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=1;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=1;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=1;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=1;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=1;
        nrNet[1][0]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=2;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=2;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=2;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=2;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=2;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=2;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=2;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=2;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=2;
        nrNet[1][1]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=3;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=3;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=3;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=3;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=3;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=3;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=3;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=3;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=3;
        nrNet[1][2]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=4;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=4;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=4;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=4;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=4;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=4;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=4;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=4;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=4;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=4;
        nrNet[1][3]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=5;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=5;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=5;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=5;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=5;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=5;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=5;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=5;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=5;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=5;
        nrNet[1][4]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=6;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=6;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=6;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=6;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=6;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=6;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=6;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=6;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=6;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=6;
        nrNet[1][5]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=7;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=7;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=7;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=7;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=7;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=7;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=7;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=7;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=7;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=7;
        nrNet[1][6]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=8;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=8;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=8;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=8;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=8;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=8;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=8;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=8;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=8;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=8;
        nrNet[1][7]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=9;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=9;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=9;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=9;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=9;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=9;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=9;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=9;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=9;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=9;
        nrNet[1][8]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][10];
        arNrnCnct[0][0]=2;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=10;
        arNrnCnct[0][1]=2;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=10;
        arNrnCnct[0][2]=2;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=10;
        arNrnCnct[0][3]=2;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=10;
        arNrnCnct[0][4]=2;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=10;
        arNrnCnct[0][5]=2;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=10;
        arNrnCnct[0][6]=2;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=10;
        arNrnCnct[0][7]=2;
        arNrnCnct[1][7]=7;
        arNrnCnct[2][7]=10;
        arNrnCnct[0][8]=2;
        arNrnCnct[1][8]=8;
        arNrnCnct[2][8]=10;
        arNrnCnct[0][9]=2;
        arNrnCnct[1][9]=9;
        arNrnCnct[2][9]=10;
        nrNet[1][9]=new Neuron(12,iModel, iActivFunc, arNrnCnct,(short)0,"");

/*2L*****************/
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=1;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=1;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=1;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=1;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=1;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=1;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=1;
        nrNet[2][0]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=2;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=2;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=2;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=2;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=2;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=2;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=2;
        nrNet[2][1]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=3;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=3;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=3;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=3;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=3;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=3;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=3;
        nrNet[2][2]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=4;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=4;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=4;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=4;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=4;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=4;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=4;
        nrNet[2][3]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=5;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=5;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=5;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=5;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=5;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=5;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=5;
        nrNet[2][4]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=6;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=6;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=6;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=6;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=6;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=6;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=6;
        nrNet[2][5]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=7;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=7;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=7;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=7;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=7;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=7;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=7;
        nrNet[2][6]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=8;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=8;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=8;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=8;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=8;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=8;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=8;
        nrNet[2][7]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=9;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=9;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=9;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=9;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=9;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=9;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=9;
        nrNet[2][8]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");
        arNrnCnct=new int[3][7];
        arNrnCnct[0][0]=3;
        arNrnCnct[1][0]=0;
        arNrnCnct[2][0]=10;
        arNrnCnct[0][1]=3;
        arNrnCnct[1][1]=1;
        arNrnCnct[2][1]=10;
        arNrnCnct[0][2]=3;
        arNrnCnct[1][2]=2;
        arNrnCnct[2][2]=10;
        arNrnCnct[0][3]=3;
        arNrnCnct[1][3]=3;
        arNrnCnct[2][3]=10;
        arNrnCnct[0][4]=3;
        arNrnCnct[1][4]=4;
        arNrnCnct[2][4]=10;
        arNrnCnct[0][5]=3;
        arNrnCnct[1][5]=5;
        arNrnCnct[2][5]=10;
        arNrnCnct[0][6]=3;
        arNrnCnct[1][6]=6;
        arNrnCnct[2][6]=10;
        nrNet[2][9]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)0,"");

/*3L*****************/
        /*����������� ���������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][0]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"����������� ���������");
        /*��������� ��������������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][1]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"��������� ��������������");
        /*�� ������������ ������ ����������������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][2]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"�� ������������ ������ ����������������");
        /*���������� ��������� � ����� ���������� � ������ ����������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][3]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"���������� ��������� � ����� ���������� � ������ ����������");
        /*���������� ������������ ���� � ������ ����������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][4]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"���������� ������������ ���� � ������ ����������");
        /*�� ��������� �������� ������������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][5]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"�� ��������� �������� ������������");
        /*�� ������������ ������ ������ ��������� ������*/
        arNrnCnct=new int[3][1];
        arNrnCnct[0][0]=-1;
        arNrnCnct[1][0]=-1;
        arNrnCnct[2][0]=-1;
        nrNet[3][6]=new Neuron(11,iModel, iActivFunc, arNrnCnct,(short)1,"�� ������������ ������ ������ ��������� ������");
        break;
/*****************************************************************************/


      default:
        break;
    }
    iMaxQntIterNet=0;//���������� ���������� �������� � ����
    for(i=0;i<nrNet.length;i++)
    {
      iMaxQntIterNet+=nrNet[i].length;
    }
  }

  public int getQntInptNeuron()
  {
    int i,j, iQntN=0;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
        if(nrNet[i][j].getStatus()==-1){
          iQntN++;
        }
      }
    }
    return iQntN;
  }

  public void setInNeuron(int iL, int iN, float f[]){
    nrNet[iL][iN].setO(f);
  }

  public void setInNeuron(int iL, int iN, int k,float f)
  {
    nrNet[iL][iN].setO(k,f);
  }

  public void setInptNeuron(int iN, float f)
  {
    int k,i,j,l=0;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
        if(nrNet[i][j].getStatus()==-1){
          if(iN==l){
            nrNet[i][j].setO(0,f);
            return;
          }
          else{
            l++;
          }
        }
      }
    }
  }

  public float getInptNeuron(int iN)
  {
    int k,i,j,l=0;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
        if(nrNet[i][j].getStatus()==-1){
          if(iN==l){
            return nrNet[i][j].getO(0);
          }
          else{
            l++;
          }
        }
      }
    }
    return 0;
  }

  public int getQntOutpNeuron()
  {
    int i,j, iQntN=0;

    for(i=0;i<nrNet.length;i++)
    {
      for(j=0;j<nrNet[i].length;j++)
      {
        if(nrNet[i][j].getStatus()==1)
        {
          iQntN++;
        }
      }
    }
    return iQntN;
  }

  public float getOtpNeuron(int iN)
  {
    int k,i,j,l=0;
    float f=0f;
    boolean blIsFind;

    blIsFind=false;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
        if(nrNet[i][j].getStatus()==1){
          if(iN==l++){
            f=nrNet[i][j].getOn();
            blIsFind=true;
          }
        }
        if(blIsFind==true){
          break;
        }
      }
      if(blIsFind==true){
        break;
      }
    }
    if(blIsFind==false){
      f=-1f;
    }
    return f;
  }


  public float getTchOtpNeuron(int iN)
  {
    int k,i,j,l=0;
    float f=0f;
    boolean blIsFind;

    blIsFind=false;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
        if(nrNet[i][j].getStatus()==1){
          if(iN==l++){
            f=nrNet[i][j].getTchOn();
            blIsFind=true;
          }
        }
        if(blIsFind==true){
          break;
        }
      }
      if(blIsFind==true){
        break;
      }
    }
    if(blIsFind==false){
      f=-1f;
    }
    return f;
  }

  public float getTchNeuron(int iL, int iN)
  {
    return nrNet[iL][iN].getTchOn();
  }

  public void setTchNeuron(int iL, int iN, float f)
  {
    nrNet[iL][iN].setTchOn(f);
  }

  public void setTchOtpNeuron(int iN, float f)
  {
    int i,j,l=0;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
        if(nrNet[i][j].getStatus()==1){
          if(iN==l++){
            nrNet[i][j].setTchOn(f);
            return;
          }
        }
      }
    }
  }

  public void calcNet()
  {
    int k,i,j,l;
    boolean blAllNetCalc=true;

    switch(iCalcAlg) {
      default:
      case 0: //������ �� ��������� ������ ������������� ����, ��� ��������������������� ��������, � �������� ������
    for(k=0;k<iMaxQntIterNet;k++)
    {
      blAllNetCalc=true;
      for(i=0;i<nrNet.length;i++)
      {
        for(j=0;j<nrNet[i].length;j++){
          if(nrNet[i][j].getReady()==0){
            nrNet[i][j].calc_neuron();
            for(l=0;l<nrNet[i][j].getQntCnct();l++){
/***********�������� �������� �� ����� �� ����, ���-�� ��������, ��� ������ � ���� -1 */
//          System.out.println("i:"+i+"j"+j+" Ly:"+nrNet[i][j].getLayer(l)+" nrNum:"+nrNet[i][j].getNrnNum(l)+" NumIn:"+nrNet[i][j].getNumIn(l)+" On:"+nrNet[i][j].getOn()+" QI:"+nrNet[i][j].getQntIn());
              if(nrNet[i][j].getStatus()!=1){
                nrNet[nrNet[i][j].getLayer(l)][nrNet[i][j].getNrnNum(l)].setO(nrNet[i][j].getNumIn(l),nrNet[i][j].getOn());
              }
            }
          }
          else{
            if(nrNet[i][j].getReady()==-1){
              blAllNetCalc=false;
            }
          }
        }
      }
      if(blAllNetCalc){
        break;
      }
    }
    break;
    }
  }

  public void teachNet()
  {
    int k,i,j,l;
    boolean blAllNetTeach=true;

    switch(iTeachAlg) {
      default:
      case 0: //�������� �� ��������� ��������� ���������������
    for(k=0;k<iMaxQntIterNet;k++)
    {
      blAllNetTeach=true;
      for(i=(nrNet.length-1);i>=0;i--)
      {
        for(j=0;j<nrNet[i].length;j++){
          if(nrNet[i][j].getStatus()!=-1){//�� ������� ������� �������
            if(nrNet[i][j].getTchReady()==-1){//���� ������ ��� �� ����������� � ��������
              if(nrNet[i][j].getStatus()!=1){//�������� ������� ������ ���� ������ ����
                float flSumGW=0;
                boolean blAllCnctNrTeaced=true;
                int iQntCnt=nrNet[i][j].getQntCnct();
                for(l=0;l<iQntCnt;l++){
/***********�������� �������� �� ����� �� ����, ���-�� ��������, ��� ������ � ���� -1 */
                  int iL, iN;
                  iL=nrNet[i][j].getLayer(l);
                  iN=nrNet[i][j].getNrnNum(l);
                  if(nrNet[iL][iN].getTchReady()==1){//���� ������ ��� ������
                  int iIn=nrNet[i][j].getNumIn(l);
                    flSumGW+=nrNet[iL][iN].getG()*nrNet[iL][iN].getW(iIn);
                  }
                  else{
                    blAllCnctNrTeaced=false;
                    break;
                  }
                }
                if(blAllCnctNrTeaced){
                  nrNet[i][j].setCalcT(flSumGW);
                }
              }
            }
            if(nrNet[i][j].getTchReady()==0){
              nrNet[i][j].teach_neuron(iTeachAlg);
            }
          }
        }
      }
      if(blAllNetTeach){
        break;
      }
    }
      break;
    }
  }

  public void netReset()
  {
    int i,j;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
          nrNet[i][j].setReadyClear();
          nrNet[i][j].setTchReadyClear();
      }
    }
  }

  public void netOnlyNetReset()
  {
    int i,j;

    for(i=0;i<nrNet.length;i++){
      for(j=0;j<nrNet[i].length;j++){
          nrNet[i][j].setReadyClearOnlyNet();
          nrNet[i][j].setTchReadyClearOnlyNet();
      }
    }
  }
  public int getQntNetLayers() {
    return nrNet.length;
  }

  public int getQntNetLayerNeurons(int i) {
    return nrNet[i].length;
  }

  public float[] getW(int i, int j)
  {
    return nrNet[i][j].getW();
  }

  public void setW(int i, int j, int k, float f)
  {
    nrNet[i][j].setW(k,f);
  }

  public int getQntCnct(int i, int j) { return nrNet[i][j].getQntCnct(); }

  public int getLayer(int i, int j, int l)
  {
    return nrNet[i][j].getLayer(l);
  }
  public int getNrnNum(int i, int j, int l)
  {
    return nrNet[i][j].getNrnNum(l);
  }
  public int getNumIn(int i, int j, int l) {
    return nrNet[i][j].getNumIn(l);
  }

  public int getNeurReady(int i, int j)
  {
    return nrNet[i][j].getReady();
  }

  public int getNeurTchReady(int i, int j)
  {
    return nrNet[i][j].getTchReady();
  }

  public float getNrOut(int i, int j)
  {
    return nrNet[i][j].getOn();
  }

  public float[] getO(int i, int j)
  {
    return nrNet[i][j].getO();
  }

  public float getA()
  {
    return nrNet[0][0].getA();
  }

  public void setA(float flA) {
    nrNet[0][0].setA(flA);
  }

  public float getN() {
    return nrNet[0][0].getN();
  }

  public void setN(float flN) {
    nrNet[0][0].setN(flN);
  }

  public String getNText(int i, int j) {
    return nrNet[i][j].getNText();
  }

  public void setNText(int i, int j, String szNText) {
    nrNet[i][j].setNText(szNText);
  }

  public int getTeachAlg() { return iTeachAlg; }
  public int getCalcAlg() { return iCalcAlg; }

  public int getNrnQntIn(int i, int j) { return nrNet[i][j].getQntIn(); }
  public int getNrnModel(int i, int j) { return nrNet[i][j].getModel(); }
  public int getNeurStatus(int i, int j) { return nrNet[i][j].getStatus(); }
  public int getNrnActFunc(int i, int j) { return nrNet[i][j].getActFunc(); }


  /*������� ���� �� �-�����*/
  public void CreateNrNet(int iQntLy, int iCalcMethod, int iTeachMethod) {
    nrNet=new Neuron[iQntLy][];
    iTeachAlg=iTeachMethod;
    iCalcAlg=iCalcMethod;
  }
  /*������� ���� �� �-��������*/
  public void CreateLyNrNet(int iLy, int iQntNrn) { nrNet[iLy]=new Neuron[iQntNrn]; }
  /*������� ������ � ������� ������� � ����*/
  public void CreateNrnNrNet(int iLy, int iNrn, int iQntIn, int iModel, int iActivFunc, int arNrnCnct[][],short shStatus, String szText) {
    nrNet[iLy][iNrn]=new Neuron(iQntIn, iModel, iActivFunc, arNrnCnct, shStatus, szText);
  }

}
