package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public abstract class NativeArray
{
  @DoNotStrip
  private HybridData mHybridData;
  
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  protected NativeArray(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }
  
  public native String toString();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\NativeArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */