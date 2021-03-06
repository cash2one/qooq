package com.tencent.mobileqq.nearby;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.richstatus.BitmapDecoder;
import com.tencent.mobileqq.richstatus.BitmapDecoder.IBitmapListener;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import thw;
import thx;

public class NearbyIconDecoder
  implements Handler.Callback, BitmapDecoder.IBitmapListener, IIconDecoder
{
  static final int jdField_a_of_type_Int = 1;
  static final String jdField_a_of_type_JavaLangString = NearbyIconDecoder.class.getSimpleName();
  Handler jdField_a_of_type_AndroidOsHandler;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  NearbyProcObserver jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver = new thx(this);
  BitmapDecoder jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  List b;
  List c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyIconDecoder(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    this.b = new ArrayList(1);
    this.c = new ArrayList(1);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.b(), this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver, true);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 1) || (paramInt2 == 201)) {}
    do
    {
      try
      {
        if (BaseApplicationImpl.a != null)
        {
          localBitmap2 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultBig");
          localBitmap1 = localBitmap2;
          if (localBitmap2 == null) {
            localBitmap1 = localBitmap2;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        Bitmap localBitmap2;
        Bitmap localBitmap1;
        return null;
      }
      try
      {
        localBitmap2 = BitmapManager.a(BaseApplicationImpl.a().getResources(), 2130842866);
        localBitmap1 = localBitmap2;
        BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localBitmap2, (byte)0);
        localBitmap1 = localBitmap2;
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError2) {}
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.a().getResources(), 2130842866);
      return localBitmap1;
      if (BaseApplicationImpl.a == null) {
        break;
      }
      localBitmap2 = (Bitmap)BaseApplicationImpl.a.get("StatusIcon_RichStatusDefaultSmall");
      localBitmap1 = localBitmap2;
    } while (localBitmap2 != null);
    localBitmap1 = BitmapManager.a(BaseApplicationImpl.a().getResources(), 2130842868);
    BaseApplicationImpl.a.put("StatusIcon_RichStatusDefaultSmall", localBitmap1, (byte)0);
    return localBitmap1;
    return BitmapManager.a(BaseApplicationImpl.a().getResources(), 2130842868);
    throw new IllegalArgumentException("type[" + paramInt1 + "] is not valid");
    return localOutOfMemoryError1;
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder = new BitmapDecoder("StatusIcon_", this);
      }
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(10);
      }
      paramString = NearbyUtils.a(this.jdField_a_of_type_JavaLangStringBuilder, "_s_", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        ??? = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(paramString, null, str);
        if ((??? == null) && (!paramBoolean1) && (TextUtils.isEmpty(str))) {
          a(paramString);
        }
        if ((??? != null) || (!paramBoolean2)) {
          break label194;
        }
        return a(paramInt1, paramInt2);
      }
    }
    throw new IllegalArgumentException("type[" + paramInt1 + "] is not valid");
    label194:
    return (Bitmap)???;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        synchronized (this.b)
        {
          this.b.clear();
        }
      }
    }
    synchronized (this.c)
    {
      this.c.clear();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
      localObject3 = finally;
      throw ((Throwable)localObject3);
      localObject4 = finally;
      throw ((Throwable)localObject4);
    }
  }
  
  public void a(IIconDecoder.IIconListener paramIIconListener)
  {
    if (paramIIconListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramIIconListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramIIconListener);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.c)
    {
      if (this.c.contains(paramString)) {
        return;
      }
      synchronized (this.b)
      {
        if (!this.b.contains(paramString))
        {
          this.b.add(paramString);
          NearbyUtils.a(jdField_a_of_type_JavaLangString, "requestIcon", new Object[] { paramString });
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 500L);
          }
        }
        return;
      }
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    NearbyUtils.a(jdField_a_of_type_JavaLangString, "notifyGetIcon", new Object[] { paramString, paramBitmap });
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.runOnUiThread(new thw(this, paramString, paramBitmap));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    synchronized (this.c)
    {
      this.c.remove(paramString1);
      synchronized (this.b)
      {
        this.b.remove(paramString1);
        if (TextUtils.isEmpty(paramString2)) {}
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder = new BitmapDecoder("StatusIcon_", this);
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(paramString1, null, paramString2);
      if (??? != null) {
        a(paramString1, (Bitmap)???);
      }
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "onGetIconUrl", new Object[] { paramString1, paramString2, Integer.valueOf(this.c.size()), Integer.valueOf(this.b.size()) });
      return;
      paramString1 = finally;
      throw paramString1;
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    NearbyUtils.a(jdField_a_of_type_JavaLangString, "onDecodeBitmap", new Object[] { paramString1, paramString2, paramBitmap, Integer.valueOf(paramInt) });
    if (paramString1 == null) {}
    while (paramBitmap == null) {
      return;
    }
    a(paramString1, paramBitmap);
  }
  
  public void b(IIconDecoder.IIconListener paramIIconListener)
  {
    if (paramIIconListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIIconListener);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    NearbyUtils.a(jdField_a_of_type_JavaLangString, "MSG_GET_ICON_URL", new Object[] { Integer.valueOf(this.b.size()), Integer.valueOf(this.c.size()) });
    paramMessage = new ArrayList(this.b.size());
    synchronized (this.b)
    {
      paramMessage.addAll(this.b);
      this.b.clear();
    }
    synchronized (this.c)
    {
      this.c.addAll(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramMessage);
      return false;
      paramMessage = finally;
      throw paramMessage;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyIconDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */