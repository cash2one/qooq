import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;

public class pai
  implements Runnable
{
  public pai(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = RichmediaClient.a().a().a(this.a.q);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.a.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.a.setResult(1001, (Intent)localObject);
      this.a.finish();
      return;
      this.a.n();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */