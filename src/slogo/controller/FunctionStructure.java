package slogo.controller;

import java.lang.reflect.Method;

public class FunctionStructure extends CommandStructure {
  public FunctionStructure(Class<?> c, Method m) {
    super(c, m);
  }

  void setParaNum(int funcParaNum) {
    numOfPara = funcParaNum;
  }

  @Override
  Class<?> getNextParaType() {
    if (paras.size() == numOfPara) {
      return null;
    }

    return String.class;
  }

  @Override
  Object[] getMethodInvokePara() {
    Object[] par = new Object[1];
    par[0] = paras;
    return par;
  }
}