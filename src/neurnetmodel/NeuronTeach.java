package neurnetmodel;

import neurnetmodel.NeuronModel;

class NeuronTeach
{
  static float flN=1f;//********static?      /* ����������� �������� �������� */
  static float flA=0.1f;//********static?    /* ����������� ����� ����������� �������� */
  float flT;        /* �������� �������� �� ������(��� ��������) */
  float flG;        /* ���������� ������ ������ */
  float flWChng[];  /* ����������� ��������� ������� */
  float flWChngLast[];  /* ���������� ��������� ������� */

  NeuronModel nm;

  public NeuronTeach(NeuronModel nmNM)
  {
    nm=nmNM;

    flWChng=new float[nm.getQntIn()];
    flWChngLast=new float[nm.getQntIn()];
    for(int i=0;i<nm.getQntIn();i++)
    {
      flWChng[i]=0;
      flWChngLast[i]=0;
    }

    flN=1f;
    flA=0.1f;
  }


  void teach(float flOn, int iTeachAlg) {
    switch(iTeachAlg) { //������� ������ �� ��������� ��� ���� ��������
      case 0: { //�������� ��������� ��������������� ������
        backErrReturn(flOn);
        break;
      }
      default: {
        backErrReturn(flOn);
        break;
      }
    }
  }

  void apply_teach() /* ��������� �������� ������� */
  {
    int i;

    for(i=0;i<nm.iQntIn;i++)
    {
      flWChngLast[i]=flWChng[i];
      nm.setW(i,(nm.getW(i)+flWChng[i]));
    }
  }

  void backErrReturn(float flOn) /*�������� ��������� ��������������� ������*/
  {
    neuron_errBackErr(flOn);
    cost_changeBackErr();
  }

  void neuron_errBackErr(float flOn)/*������ ������ �� �������� �������� ������ �������. ���. ��������� ��������������� ������*/
  {
    flG=(flOn+5.05f)*(5.05f-flOn)*(flT-flOn)/10f;
//    flG=flOn*(5f-flOn)*(flT-flOn)/5f;
  /*    flG=((flOn+5)/10)*(1-(flOn+5)/10)*((flT+5)/10-(flOn+5)/10);*/
  }

  float getCostChngBackErr(int i)/*������ ���������� ��������� ����� �������. ���. ��������� ��������������� ������*/
  {
    return (flN*flG*(nm.getO(i)+5)/10+flA*flWChngLast[i]);
  }

  void cost_changeBackErr() /*��������� ����� �������, �� ����������� ��������. ���. ��������� ��������������� ������*/
  {
    int i;

    for(i=0;i<nm.getQntIn();i++)
      flWChng[i]=getCostChngBackErr(i);
  }

  public void setT(float f)
  {
    flT=f;
  }

  public void setCalcT(float f, float flOn)
  {
    flT=flOn + f;
  }


  public float getT()
  {
    return flT;
  }

  public void setN(float f)
  {
    flN=f;
  }

  public float getN()
  {
    return flN;
  }

  public void setA(float f)
  {
    flA=f;
  }

  public float getA()
  {
    return flA;
  }

  public float getG()
  {
    return flG;
  }

  public float[] getWChng()
  {
    return flWChng;
  }

  public float getWChng(int i)
  {
    return flWChng[i];
  }
}
