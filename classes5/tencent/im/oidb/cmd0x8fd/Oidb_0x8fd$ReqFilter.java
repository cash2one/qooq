package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x8fd$ReqFilter
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_level_name_flag" }, new Object[] { Integer.valueOf(0) }, ReqFilter.class);
  public final PBUInt32Field uint32_level_name_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8fd\Oidb_0x8fd$ReqFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */