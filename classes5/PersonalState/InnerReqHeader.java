package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class InnerReqHeader
  extends JceStruct
{
  public long iClientIp;
  public int iSeq;
  public long lUIN;
  public int nAppid;
  public short shVersion;
  public String strA2;
  public String strImei;
  public long uClientPort;
  
  public InnerReqHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strA2 = "";
    this.strImei = "";
  }
  
  public InnerReqHeader(long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    this.strA2 = "";
    this.strImei = "";
    this.lUIN = paramLong1;
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.nAppid = paramInt2;
    this.iClientIp = paramLong2;
    this.strA2 = paramString1;
    this.uClientPort = paramLong3;
    this.strImei = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.shVersion = paramJceInputStream.read(this.shVersion, 1, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 2, true);
    this.nAppid = paramJceInputStream.read(this.nAppid, 3, true);
    this.iClientIp = paramJceInputStream.read(this.iClientIp, 4, false);
    this.strA2 = paramJceInputStream.readString(5, false);
    this.uClientPort = paramJceInputStream.read(this.uClientPort, 6, false);
    this.strImei = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.shVersion, 1);
    paramJceOutputStream.write(this.iSeq, 2);
    paramJceOutputStream.write(this.nAppid, 3);
    paramJceOutputStream.write(this.iClientIp, 4);
    if (this.strA2 != null) {
      paramJceOutputStream.write(this.strA2, 5);
    }
    paramJceOutputStream.write(this.uClientPort, 6);
    if (this.strImei != null) {
      paramJceOutputStream.write(this.strImei, 7);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\InnerReqHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */