import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PATextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.OpenAppClient;

public class nmv
  implements View.OnClickListener
{
  public nmv(PATextItemBuilder paramPATextItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (nmw)AIOUtils.a(paramView);
    if (PAMessageUtil.a(paramView.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidContentContext)) {}
    for (;;)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramView instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
      return;
      if ((paramView.b == null) || (!paramView.b.equals("open_local"))) {
        break;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("schemaurl", paramView.c);
      ((Bundle)localObject).putString("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Bundle)localObject).putString("vkey", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
      OpenAppClient.b((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Bundle)localObject);
    }
    Object localObject = new Intent(this.a.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((Intent)localObject).putExtra("url", paramView.c);
    ((Intent)localObject).putExtra("assignBackText", this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367975));
    ((Intent)localObject).putExtra("puin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("source_name", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    MessageForPubAccount localMessageForPubAccount;
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {
        break label412;
      }
    }
    label412:
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if (l >= 0L) {
        ((Intent)localObject).putExtra("msg_id", String.valueOf(l));
      }
      ((Intent)localObject).putExtra("fromAio", true);
      PublicAccountUtil.a((Intent)localObject, paramView.c);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramView.c, "", "", "");
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */