class NeuronModel
{
  int iQntIn;       /* Количество входов нейрона */
  int iModel;       /* Номер модели нейрона */
  float flNeur;
  float flW[];      /* Вес входа */
  float flO[];      /* Входы нейрона */

  public NeuronModel(int i1,int i2)
  {
    iQntIn=i1;
    iModel=i2;
    flW=new float[iQntIn];
    flO=new float[iQntIn];
    flO[0]=1;
  }

  float calc_model()
  {
    switch(iModel)
    {
      case 0:     
        return mdlMcCuloch_Pitts();
    }
    return mdlMcCuloch_Pitts();
  }

  float mdlMcCuloch_Pitts()
  {
    flNeur=0;
    int i;
    
    for(i=0;i<iQntIn;i++)
    {
      flNeur+=flW[i]*flO[i];
    }
    return flNeur;
  }

  public int getQntIn()
  {
    return iQntIn;
  }


  public void setW(float f[])
  {
/*    int i;

    for(i=0;i<iQntIn;i++)
      flW[i]=f[i];*/

    flW=f;
  }

  public void setW(int i, float f)
  {
    flW[i]=f;
  }

  public float[] getW()
  {
    return flW;
  }

  public float getW(int i)
  {
    return flW[i];
  }

  public void setO(float f[])
  {
/*    int i;

    for(i=0;i<iQntIn;i++)
      flO[i]=f[i];*/
    flO=f;
  }

  public void setO(int i, float f)
  {
    flO[i]=f;
  }

  public float[] getO()
  {
    return flO;
  }

  public float getO(int i)
  {
    return flO[i];
  }
                  
  public float getNeur()
  {
    return flNeur;
  }
}
