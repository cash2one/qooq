package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$BusinessEntryInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_business_entry_new", "uint32_business_entry_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BusinessEntryInfo.class);
  public final PBUInt32Field uint32_business_entry_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_business_entry_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\torch_transfer$BusinessEntryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */