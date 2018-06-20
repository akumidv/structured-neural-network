package neurnetmodel;

public class NeuronActivateFunc
{
  int iActivateFunc;       /* Функция активации нейрона */

  public NeuronActivateFunc(int i)
  {
    iActivateFunc=i;
  }

  float activate(float flVal)
  {
    switch(iActivateFunc)
    {
      case 0:
        return flVal;
      case 1:
        return ((sign(flVal)-0.5f)*10f);
      case 2:
        return ((sigmoid(flVal)-0.5f)*10f);
    }
    return sigmoid(flVal);
  }

  float sign(float flVal)
  {
    if(flVal<0)
      return 0;
    return 1;
  }

  float sigmoid(float flVal)
  {
    return (float)(1f/(1f+Math.exp(-flVal)));
  }

  public int getActFunc() { return iActivateFunc; }
}
