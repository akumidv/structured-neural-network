/*******************
Not Woked,Не знаю как получить данные с класса nm и как их туда засунуть
********************/

class NeuronTeached extends NeuronModel
{
  float flN;        /* Коэффициент скорости обучения */
  float flA;        /* Коэффециент учета предыдущего обучения */
  float flT;        /* Желаемое значение на выходе(для обучения) */
  float flG;        /* Обобщенный сигнал ошибки */
  float flWChng[];  /* Необходимые изменения нейрона */
  float flWChngLast[];  /* Предыдущее изменение нейрона */

  int iTeachAlg;    /* Алгоритм обучения */

  public NeuronTeached(int i1, int i2,int i3)
  {
    super(i1,i2);
    int i;
    iTeachAlg=i3;

    flWChng=new float[super.getQntIn()];
    for(i=0;i<super.getQntIn();i++)
    {
      flWChng[i]=0;
      flWChngLast[i]=0;
    }

    flN=1f;
    flA=0.1f;
  }

  void teach(float flOn)
  {
    switch(iTeachAlg)
    {
      case 0:
      {
        backErrReturn(flOn);
        break;
      }
      default:
      {
        backErrReturn(flOn);
        break;
      }
    }
  }

  void apply_teach() /* Применить обучение нейрона */
  {
    int i;

    for(i=0;i<super.iQntIn;i++)
    {
      flWChngLast[i]=flWChng[i];
      super.setW(i,(super.getW(i)+flWChng[i]));
    }
  }

  void backErrReturn(float flOn)
  {
    neuron_err(flOn);
    cost_change();
  }

  void neuron_err(float flOn)
  {
    flG=flOn*(1-flOn)*(flT-flOn);
  }

  float getCostChng(int i)
  {
    return (flN*flG*super.getO(i)+flA*flWChngLast[i]);
  }

  void cost_change() /*Номер входа нейрона*/
  {
    int i;

    for(i=0;i<super.getQntIn();i++)
      flWChng[i]=getCostChng(i);
  }

  public void setT(float f)
  {
    flT=f;
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

/*
  public int getQntIn()
  {
    return super.getQntIn();
  }


  public void setW(float f[])
  {
    super.setW(f);
  }

  public void setW(int i, float f)
  {
    super.setW(i,f);
  }

  public float[] getW()
  {
    return super.getW();
  }

  public float getW(int i)
  {
    return super.getW(i);
  }

  public void setO(float f[])
  {
    super.setO(f);
  }

  public void setO(int i, float f)
  {
    super.setO(i,f);
  }

  public float[] getO()
  {
    return super.getO();
  }

  public float getO(int i)
  {
    return super.getO(i);
  }
                  
  public float getNeur()
  {
    return super.getNeur();
  }

*/
}
