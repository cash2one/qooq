package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class PALongMessageHandler
  extends BaseHandler
{
  public PALongMessageHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private byte[] a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (RichProto.RichProtoReq.LongStructMessageDownReq)paramList.get(0);
    mobileqq_mp.LongMsgUrlRequest localLongMsgUrlRequest = new mobileqq_mp.LongMsgUrlRequest();
    try
    {
      l = Long.parseLong(paramList.d);
      localLongMsgUrlRequest.puin.set(l);
      localLongMsgUrlRequest.str_fileid.set(paramList.jdField_a_of_type_JavaLangString);
      return localLongMsgUrlRequest.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    paramProtoReq = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (paramProtoReq.getResultCode() == 1000) {}
    try
    {
      if (localRichProtoResp.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramProtoResp = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        paramProtoReq = (RichProto.RichProtoResp.LongStructMessageDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        paramProtoReq.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)paramProtoResp.ret_info.get());
        paramProtoReq.jdField_a_of_type_JavaLangString = paramProtoResp.str_url.get();
        paramProtoReq.b = paramProtoResp.str_file_md5.get();
      }
      for (;;)
      {
        RichProtoProc.a(localRichProtoReq, localRichProtoResp);
        return;
        int i = paramProtoReq.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(paramProtoReq);
          paramProtoReq = paramProtoReq.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          a(-1, 9311, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(paramProtoReq);
          paramProtoReq = paramProtoReq.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          a(-1, 9044, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception paramProtoResp)
    {
      for (;;) {}
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    paramRichProtoReq = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    paramRichProtoReq.jdField_a_of_type_JavaUtilList.clear();
    RichProto.RichProtoResp.LongStructMessageDownResp localLongStructMessageDownResp = new RichProto.RichProtoResp.LongStructMessageDownResp();
    paramRichProtoReq.jdField_a_of_type_JavaUtilList.add(localLongStructMessageDownResp);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\PALongMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */