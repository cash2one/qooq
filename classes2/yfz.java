import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.ArrayList;

public class yfz
  implements Runnable
{
  public yfz(DatalineRemoteManager paramDatalineRemoteManager, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatalineRemoteManager.a(this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a.add(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */