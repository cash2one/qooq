import android.os.AsyncTask;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class bj
  extends AsyncTask
{
  public bj(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  DataLineMsgRecord a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = 63536;
    localDataLineMsgRecord.groupId = paramInt1;
    localDataLineMsgRecord.groupSize = paramInt2;
    localDataLineMsgRecord.groupIndex = paramInt3;
    return localDataLineMsgRecord;
  }
  
  protected Void a(Bundle... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
    if (paramVarArgs == null) {
      return null;
    }
    a(paramVarArgs);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.a.a(false);
  }
  
  void a(List paramList)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.app.a(8);
    for (;;)
    {
      int j = paramList.size();
      if (j <= 3)
      {
        i = 0;
        while (i < j)
        {
          localDataLineHandler.a(a((String)paramList.get(i), 0, 0, 0), false);
          i += 1;
        }
      }
      if ((j > 3) && (j < 50))
      {
        localArrayList = new ArrayList();
        int k = localDataLineHandler.a();
        i = 0;
        while (i < j)
        {
          localArrayList.add(a((String)paramList.get(i), k, j, i));
          i += 1;
        }
        DataLineReportUtil.n(this.a.app);
        localDataLineHandler.a(localArrayList, false);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      j = localDataLineHandler.a();
      int i = 0;
      while (i < 50)
      {
        localArrayList.add(a((String)paramList.get(i), j, 50, i));
        i += 1;
      }
      DataLineReportUtil.n(this.a.app);
      localDataLineHandler.a(localArrayList, false);
      i = 0;
      while (i < 50)
      {
        paramList.remove(0);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */