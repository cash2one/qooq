import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pnr
  implements Runnable
{
  pnr(pnl parampnl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQAVFunnyFaceInvest.a(this.a.a)) {
      return;
    }
    this.a.a.a.setImageResource(2130839126);
    this.a.a.b.setPressed(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */