import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class mjb
  extends ContactBindObserver
{
  public mjb(RegisterQQNumberActivity paramRegisterQQNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = " + paramBoolean1 + "; isBindOk = " + paramBoolean2 + ";hadbind = " + paramBoolean3 + ";uin =" + paramString);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        RegisterQQNumberActivity.a(this.a, true);
        RegisterQQNumberActivity.b(this.a);
        return;
      }
      if ((paramBoolean3) && (!TextUtils.isEmpty(paramString)))
      {
        RegisterQQNumberActivity.a(this.a);
        Intent localIntent = new Intent(this.a, VerifyPhoneNumActivity.class);
        localIntent.putExtra("phonenum", this.a.d);
        localIntent.putExtra("key", this.a.e);
        localIntent.putExtra("uin", RegisterQQNumberActivity.a(this.a));
        localIntent.putExtra("key_register_sign", RegisterQQNumberActivity.a(this.a));
        localIntent.putExtra("key_register_binduin", paramString);
        this.a.startActivity(localIntent);
        this.a.finish();
        return;
      }
      RegisterQQNumberActivity.b(this.a);
      return;
    }
    RegisterQQNumberActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */