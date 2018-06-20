import NeuronActivateFunc;
//import NeuronModel;
import NeuronTeach;
import NeuronTeached;

class Neuron
{
  float flQ;        /* Порог нейрона */
  float flOn;       /* Выходное значение нейрона */

  NeuronActivateFunc naf;
/*  NeuronModel nm;*/
  NeuronTeach nt;
  NeuronTeached nm;

  public float getOn()
  {
    return flOn;
  }

  public Neuron(int iIn, int iModel,int iActivFunc, int iTeachMethod)
  {
    int i;

    nm=new NeuronTeached((iIn+1),iModel,iTeachMethod);
/*    nm=new NeuronModel((iIn+1),iModel);*
    naf=new NeuronActivateFunc(iActivFunc);
/*    nt=new NeuronTeach(nm,iTeachMethod);*/
    
    for(i=0;i<nm.getQntIn();i++)
    {
      nm.setW(i,0.5f);
    }
  
  }

  float calc_neuron()
  {
    flOn=naf.activate(nm.calc_model());
    return nm.getNeur();
  }

  void teach()
  {
    nt.teach(flOn);
  }

  void apply_teach()
  {
    nt.apply_teach();
  }

  public void setQ(float f)
  {
    nm.setW(0,f);
  }

  public float getQ()
  {
    return nm.getW(0);
  }

  public void setW(float f[])
  {
    int i;

    for(i=1;i<nm.getQntIn();i++)
      nm.setW(i,f[i-1]);
  }

  public float[] getW()
  {
    int i;
    float f[]=new float[nm.getQntIn()-1];

    for(i=1;i<nm.getQntIn();i++)
      f[i-1]=nm.getW(i);
    return f;
  }

  public float getW(int i)
  {
    return nm.getW(i+1);
  }

  public void setO(float f[])
  {
    int i;

    for(i=1;i<nm.getQntIn();i++)
      nm.setO(i,f[i-1]);
  }

  public float[] getO()
  {
    int i;
    float f[]=new float[nm.getQntIn()-1];

    for(i=1;i<nm.getQntIn();i++)
      f[i-1]=nm.getO(i);
    return f;
  }

  public float getO(int i)
  {
    return nm.getO(i+1);
  }

/**************************************************/
  public void setT(float f)
  {
    nt.setT(f);
  }

  public float getT()
  {
    return nt.getT();
  }

  public void setN(float f)
  {
    nt.setN(f);
  }

  public float getN()
  {
    return nt.getN();
  }

  public void setA(float f)
  {
    nt.setA(f);
  }

  public float getA()
  {
    return nt.getA();
  }

  public float getG()
  {
    return nt.getG();
  }

  public float[] getWChng()
  {
    int i;
    float f[]=new float[nm.getQntIn()-1];

    for(i=1;i<nm.getQntIn();i++)
      f[i-1]=nt.getWChng(i);
    return f;
  }

  public float getWChng(int i)
  {
    return nt.getWChng(i+1);
  }
}
