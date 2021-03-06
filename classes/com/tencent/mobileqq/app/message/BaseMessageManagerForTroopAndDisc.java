package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopCalendarMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopDingdongAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHasGiftMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHomeworkPraiseMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopPubAccountMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReplyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import qku;
import qkv;
import qkw;

public abstract class BaseMessageManagerForTroopAndDisc
  extends BaseMessageManager
{
  public static final String b = "key_from_parallel_pull";
  public static final String c = "key_paraller_pull_pkg_num";
  
  public BaseMessageManagerForTroopAndDisc(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private HashMap a(String paramString, int paramInt, List paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return localHashMap;
    }
    Object localObject = paramList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while (localMessageRecord.shmsgseq <= 0L);
    for (long l = localMessageRecord.uniseq;; l = 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh find msg in cache id = " + ((MessageRecord)localObject).getId() + ", msg = " + ((MessageRecord)localObject).getLogColorContent() + ", uniseq = " + ((MessageRecord)localObject).uniseq + " , msgtime = " + ((MessageRecord)localObject).time + " , shMsgSeq = " + ((MessageRecord)localObject).shmsgseq + " , extra = " + ((MessageRecord)localObject).extraflag);
        }
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localMessageRecord = (MessageRecord)paramList.next();
          } while (localMessageRecord.shmsgseq != ((MessageRecord)localObject).shmsgseq);
          StringBuilder localStringBuilder = new StringBuilder();
          if (localMessageRecord.getId() > 0L) {}
          for (paramString = "id&" + localMessageRecord.getId();; paramString = "uniseq&" + localMessageRecord.uniseq)
          {
            localHashMap.put(paramString + "&" + localMessageRecord.shmsgseq, localMessageRecord);
            break;
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
      }
      return localHashMap;
    }
  }
  
  private void a(int paramInt, String paramString, long paramLong, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label323:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (MsgProxyUtils.a((MessageRecord)localObject2));
      }
      for (long l1 = ((ChatMessage)localObject2).shmsgseq;; l1 = 0L)
      {
        if ((l1 > paramLong) || (paramLong == 0L) || (l1 == 0L)) {
          break label323;
        }
        long l2 = MessageCache.a();
        localObject1 = paramList.iterator();
        do
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (((ChatMessage)localObject2).shmsgseq != paramLong);
        l1 = ((ChatMessage)localObject2).time;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = (MessageForTroopUnreadTips)MessageRecordFactory.a(61527);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, paramString, (String)localObject2, "", l1, 61527, paramInt, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, (String)localObject2, false, false);
        paramString = new ArrayList();
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add((ChatMessage)((Iterator)localObject2).next());
        }
        MsgProxyUtils.a(paramString, (MessageRecord)localObject1, true);
        paramList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramList.add((ChatMessage)paramString.next());
        }
        break;
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearLimitCountHistory uin = " + paramString1 + ", type = " + paramInt1 + ", needDeleteDB = " + paramBoolean1 + ", delNum = " + paramInt2);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, false, false);
    if (1 == paramInt1) {}
    for (String str = String.format("shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString2, Integer.valueOf(paramInt2) });; str = null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, str, null, null);
      }
      return i;
    }
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  protected abstract String a(String paramString1, String paramString2);
  
  public List a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return new ArrayList();
    }
    long l2 = 0L;
    Object localObject2 = ((List)localObject1).iterator();
    do
    {
      l1 = l2;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
    } while (((MessageRecord)localObject3).shmsgseq <= 0L);
    long l1 = ((MessageRecord)localObject3).uniseq;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1);
    Object localObject3 = a(paramString, paramInt1, (List)localObject1);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    int i;
    int j;
    label222:
    label310:
    label511:
    label636:
    int k;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      if (i < localList.size())
      {
        if (((MessageRecord)localList.get(i)).uniseq != l1) {
          break label1548;
        }
        j = i;
        for (;;)
        {
          try
          {
            localObject1 = new ArrayList();
            if (localObject2 == null)
            {
              l1 = 0L;
              if (j == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
                }
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
                if (l1 - paramInt2 < 0L) {
                  break label1557;
                }
                l2 = l1 - paramInt2;
                break label1530;
                Object localObject4;
                ((List)localObject1).addAll(((MsgProxy)localObject2).b(paramString, paramInt1, l2, localObject4));
                ((List)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject3));
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
                }
                return (List)localObject1;
              }
            }
            else
            {
              l1 = ((MessageRecord)localObject2).shmsgseq;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 0, cacheIndex = " + j + " timestamp = " + System.currentTimeMillis());
            }
            if (j < paramInt2) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
            }
            i = j - paramInt2;
            l2 = ((MessageRecord)localList.get(i)).shmsgseq;
            if ((i > 0) && (((MessageRecord)localList.get(i - 1)).shmsgseq == ((MessageRecord)localList.get(i)).shmsgseq))
            {
              i -= 1;
              if (!QLog.isColorLevel()) {
                break label1521;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i);
              continue;
            }
            if (i != 0) {
              break label1053;
            }
            if (!QLog.isColorLevel()) {
              break label1569;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
          }
          finally {}
          if ((i < localList.size() - 1) && (((MessageRecord)localList.get(i)).shmsgseq == ((MessageRecord)localList.get(i + 1)).shmsgseq))
          {
            k += 1;
            if (!QLog.isColorLevel()) {
              break label1582;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + k);
            break label1582;
          }
          i = k + 1;
          if (i > j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 3, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
            }
            ((List)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject3));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 4, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
            }
          }
          else
          {
            ((List)localObject1).addAll(localList.subList(i, j));
            paramInt2 -= ((List)localObject1).size();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 5, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
            if (l2 - paramInt2 < 0L) {
              break label1591;
            }
            l1 = l2 - paramInt2;
            label980:
            ((List)localObject1).addAll(0, ((MsgProxy)localObject2).b(paramString, paramInt1, l1, l2));
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 6, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
              continue;
              label1053:
              ((List)localObject1).addAll(localList.subList(i, j));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 7, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
              }
            }
          }
        }
        l2 = ((MessageRecord)localList.get(0)).shmsgseq;
        k = 0;
        i = 0;
      }
    }
    for (;;)
    {
      if ((i < localList.size() - 1) && (((MessageRecord)localList.get(i)).shmsgseq == ((MessageRecord)localList.get(i + 1)).shmsgseq))
      {
        k += 1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + k);
        }
      }
      else
      {
        i = k + 1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + l2 + ",itemListStartPoint = " + i + ", timestamp = " + System.currentTimeMillis());
        }
        if (i > j)
        {
          ((List)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, (Map)localObject3));
          label1333:
          paramInt2 -= ((List)localObject1).size();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 1, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
          if (l2 - paramInt2 < 0L) {
            break label1515;
          }
        }
        label1515:
        for (l1 = l2 - paramInt2;; l1 = 0L)
        {
          ((List)localObject1).addAll(0, ((MsgProxy)localObject2).b(paramString, paramInt1, l1, l2));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 2, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
          break;
          ((List)localObject1).addAll(localList.subList(i, j));
          break label1333;
        }
        label1521:
        break label511;
        j = 0;
        break label222;
        for (;;)
        {
          label1530:
          if (l1 - 1L < 0L) {
            break label1563;
          }
          l3 = l1 - 1L;
          break label310;
          label1548:
          i += 1;
          break;
          label1557:
          l2 = 0L;
        }
        label1563:
        long l3 = 0L;
        break label310;
        label1569:
        k = j - paramInt2;
        i = k;
        break label636;
        label1582:
        i += 1;
        break label636;
        label1591:
        l1 = 0L;
        break label980;
      }
      i += 1;
    }
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    if ((MsgProxyUtils.a(str, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(str, paramInt))) && (paramRefreshMessageContext.d) && (paramRefreshMessageContext.b < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more long msg");
      }
      paramRefreshMessageContext.b += 1;
      b(str, paramInt, 15, paramRefreshMessageContext);
      return;
    }
    super.a(paramRefreshMessageContext, paramInt);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.f = false;
    paramRefreshMessageContext.d = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_c_of_type_Int = paramInt;
    if ((!paramRefreshMessageContext.h) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.containsKey(MsgProxyUtils.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.put(MsgProxyUtils.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qkw(this, paramRefreshMessageContext, paramString, paramInt, paramLong2, paramBoolean));
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    boolean bool2 = paramBundle.getBoolean("success");
    long l3 = paramBundle.getLong("beginSeq", -1L);
    long l4 = paramBundle.getLong("endSeq", -1L);
    boolean bool3 = paramBundle.getBoolean("key_from_parallel_pull", false);
    List localList;
    Object localObject1;
    Object localObject2;
    int i;
    label111:
    long l1;
    label277:
    long l2;
    label292:
    label328:
    Object localObject3;
    if ((paramInt == 1) && (bool3) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      localList = a(paramString, paramInt, paramList1.size());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
      localObject2 = new StringBuilder().append("refresh roam step 1 , result = ");
      if (paramList1 != null) {
        break label729;
      }
      i = -1;
      ((QQMessageFacade)localObject1).a(i + " , success = " + bool2 + " , beginSeq = " + l3 + " , endSeq = " + l4, " , timestamp = " + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramBundle.getInt("counter")));
      if (localList == null) {
        break label1122;
      }
      localObject1 = paramList2;
      if (paramList2 == null) {
        localObject1 = new ArrayList();
      }
      if ((paramList1 == null) || (paramList1.isEmpty())) {
        break label853;
      }
      paramList2 = new ArrayList();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
      if (l3 - 15L <= 0L) {
        break label740;
      }
      l1 = l3 - 15L;
      if (l3 - 1L <= 0L) {
        break label746;
      }
      l2 = l3 - 1L;
      paramList2.addAll(((MsgProxy)localObject2).b(paramString, paramInt, l1, l2));
      paramList2.addAll(localList);
      paramList1 = paramList1.iterator();
      if (!paramList1.hasNext()) {
        break label853;
      }
      localObject2 = (MessageRecord)paramList1.next();
      localObject3 = paramList2.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)((Iterator)localObject3).next(), (MessageRecord)localObject2, false, true));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + ((MessageRecord)localObject2).senderuin + " mr.msgtype: " + ((MessageRecord)localObject2).msgtype + " mr.frienduin: " + ((MessageRecord)localObject2).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject2).shmsgseq + " mr.time:" + ((MessageRecord)localObject2).time + " mr.msg: " + ((MessageRecord)localObject2).getLogColorContent());
        }
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, (MessageRecord)localObject2, paramList2);
          if (localObject3 != null) {
            if (((MessageRecord)localObject3).isValid) {
              break label1149;
            }
          }
        }
      }
      label729:
      label740:
      label746:
      label853:
      label1122:
      label1149:
      for (paramInt = 1;; paramInt = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject3).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
        if (((MessageRecord)localObject3).msgtype == 63519)
        {
          byte[] arrayOfByte = MsgProxyUtils.a((MessageRecord)localObject3, (MessageRecord)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject3).uniseq, arrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
        }
        if (paramInt == 0) {
          break label328;
        }
        ((MessageRecord)localObject3).shmsgseq = ((MessageRecord)localObject2).shmsgseq;
        ((MessageRecord)localObject3).time = ((MessageRecord)localObject2).time;
        ((MessageRecord)localObject3).extraflag = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((MessageRecord)localObject3);
        break label328;
        localList = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
        break;
        i = paramList1.size();
        break label111;
        l1 = 0L;
        break label277;
        l2 = 0L;
        break label292;
        ((List)localObject1).add(localObject2);
        if (!QLog.isColorLevel()) {
          break label328;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 2 , mr.msg = " + ((MessageRecord)localObject2).getLogColorContent() + " , mr.seq = " + ((MessageRecord)localObject2).shmsgseq + " , mr.msgtype = " + ((MessageRecord)localObject2).msgtype + ", isExist = " + bool1 + " , extra = " + ((MessageRecord)localObject2).extraflag);
        break label328;
        paramBundle.putBoolean("success", bool2);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)((List)localObject1).get(0)).istroop).a((List)localObject1, null);
        }
        paramList1 = ((List)localObject1).iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (MessageRecord)paramList1.next();
          if (paramList2.getId() < 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "refresh insert db error ! , mr.msg = " + paramList2.getLogColorContent() + " , mr.seq = " + paramList2.shmsgseq + " , mr.uniseq = " + paramList2.uniseq + " , extra = " + paramList2.extraflag);
            }
          }
          else
          {
            MsgProxyUtils.c(localList, paramList2, true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 3 , mr.msg = " + paramList2.getLogColorContent() + " , mr.seq = " + paramList2.shmsgseq + " , mr.uniseq = " + paramList2.uniseq + " , extra = " + paramList2.extraflag);
            }
          }
        }
        try
        {
          localList.notify();
          if (bool3) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramString, l3, l4);
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    int i = -1;
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      MessageInfo localMessageInfo = localMessageRecord.mMessageInfo;
      if ((localMessageInfo != null) && (!localMessageRecord.isread))
      {
        if (localMessageRecord.istroop == 1) {}
        for (boolean bool = true;; bool = false)
        {
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = localRecentUserProxy.a(paramString, localMessageRecord.istroop);
          if (!localMessageInfo.a()) {
            break;
          }
          int k = localMessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool, localMessageRecord.frienduin);
          if (k < localRecentUser.msgType) {
            break;
          }
          localRecentUser.msgType = k;
          localRecentUser.msg = MessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localMessageInfo, localRecentUser.msg, localMessageRecord, bool);
          localRecentUserProxy.a(localRecentUser);
          i = localMessageRecord.istroop;
          j = 1;
          break;
        }
      }
    }
    if (j != 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, i));
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager.troop.revoked_troop_msg", 2, "cleanBizTypeMarkForMsgRevoke==>uin:" + paramString + "|type:" + paramInt + "|seqFrom:" + paramLong);
    }
    if ((paramString == null) || (paramLong < 0L)) {
      return false;
    }
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(paramString, paramInt);
    TroopInfoManager localTroopInfoManager;
    int i;
    if ((localRecentUser != null) && (localRecentUser.shouldShowInRecentList()))
    {
      localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (((localRecentUser.msg instanceof TroopAtMeMsg)) && (((TroopAtMeMsg)localRecentUser.msg).a.a == paramLong)) {
        i = 15;
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        return false;
        if (((localRecentUser.msg instanceof TroopSpecialAttentionMsg)) && (((TroopSpecialAttentionMsg)localRecentUser.msg).a.a == paramLong))
        {
          i = 10;
          continue;
        }
        if (((localRecentUser.msg instanceof TroopAtAllMsg)) && (((TroopAtAllMsg)localRecentUser.msg).a.a == paramLong))
        {
          i = 8;
          continue;
        }
        if (((localRecentUser.msg instanceof TroopHomeworkSpecialMsg)) && (((TroopHomeworkSpecialMsg)localRecentUser.msg).a.a == paramLong))
        {
          i = 4;
          continue;
        }
        if (((localRecentUser.msg instanceof TroopReceivedFlowsersMsg)) && (((TroopReceivedFlowsersMsg)localRecentUser.msg).a.a == paramLong))
        {
          i = 17;
          continue;
        }
        if (((localRecentUser.msg instanceof TroopDingdongAtMeMsg)) && (((TroopDingdongAtMeMsg)localRecentUser.msg).a.a == paramLong))
        {
          i = 11;
          continue;
        }
        if (((localRecentUser.msg instanceof TroopReplyMsg)) && (((TroopReplyMsg)localRecentUser.msg).a.a == paramLong))
        {
          i = 14;
          continue;
        }
        if (((localRecentUser.msg instanceof TroopCalendarMsg)) && (((TroopCalendarMsg)localRecentUser.msg).a.a == paramLong)) {
          i = 13;
        }
      }
      else
      {
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        localRecentUserProxy.a(localRecentUser);
        if (paramInt == 1) {
          localTroopInfoManager.a(paramString, i);
        }
        for (;;)
        {
          return true;
          if (paramInt == 3000) {
            localTroopInfoManager.a(paramString + "&" + 3000, i);
          }
        }
        return false;
      }
      i = -1;
    }
  }
  
  public boolean a(String paramString1, int paramInt, List paramList, String paramString2)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(MsgProxyUtils.a(paramString1, paramInt), Boolean.valueOf(true));
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString1, paramInt);
    } while ((paramString1 == null) || (paramString1.isEmpty()));
    paramList = MsgProxyUtils.a(paramList, true);
    int i;
    if (((MessageRecord)paramList.get(0)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L)
    {
      i = 1;
      if (i == 0) {
        break label289;
      }
      paramInt = 0;
      label151:
      if (paramInt >= paramList.size()) {
        break label313;
      }
      if (((MessageRecord)paramList.get(paramInt)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
        break label269;
      }
    }
    for (;;)
    {
      paramList = paramList.subList(paramInt, paramList.size());
      if ((!paramList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramList.get(0)).shmsgseq)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList, paramString2);
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label269:
        paramInt += 1;
        break label151;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramList, paramString2);
        continue;
        label289:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList, paramString2);
      }
      label313:
      paramInt = 0;
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "pullTroopMsgParallelInSilence, start...count:" + paramInt);
      }
      TroopMessageManager.e = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).e(paramString, 1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    return;
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    long l1;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if (((MessageRecord)localObject3).shmsgseq > 0L)
      {
        l1 = ((MessageRecord)localObject3).uniseq;
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "aioMsgList size:" + ((List)localObject1).size());
      }
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(paramString, 1, l1);
      if (localObject1 == null) {}
      long l2;
      for (l1 = 0L;; l1 = ((MessageRecord)localObject1).shmsgseq)
      {
        localObject1 = a(paramString, 1, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "lastContinuedSeq:" + l1 + " locallist size:" + ((List)localObject1).size());
        }
        i = 0;
        if (((List)localObject1).isEmpty()) {
          break label1252;
        }
        int j = ((List)localObject1).size() - 1;
        l2 = l1;
        i = 0;
        while ((j >= 0) && (l2 - ((MessageRecord)((List)localObject1).get(j)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject1).get(j)).shmsgseq;
          i += 1;
          j -= 1;
        }
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        long l3;
        long l5;
        if (paramInt - i < 0)
        {
          paramInt = 0;
          l3 = l4 - paramInt + 1L;
          l5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1);
          paramInt = 1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 0, delSeq = " + l5 + ", endSeq = " + l4 + ",beginSeq = " + l3 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L) {
            paramInt = 0;
          }
          if (l4 > l5) {
            break label695;
          }
          paramInt = 0;
          l1 = l3;
        }
        for (;;)
        {
          label525:
          if (l1 < 0L) {
            l1 = 0L;
          }
          for (;;)
          {
            localObject2 = new ArrayList();
            localObject3 = ((List)localObject1).iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label804;
              }
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
              if (localMessageRecord.shmsgseq < l1)
              {
                ((List)localObject2).add(localMessageRecord);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint invalid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
                continue;
                paramInt -= i;
                break;
                label695:
                if (l3 > l5) {
                  break label1245;
                }
                l1 = 1L + l5;
                break label525;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint valid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
              }
            }
            label804:
            ((List)localObject1).removeAll((Collection)localObject2);
            ((List)localObject2).clear();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 1, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
            }
            if ((l4 < l1) || (l4 <= 0L) || (paramInt == 0)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis() + " beginSeq:" + l1 + " endSeq:" + l4);
            }
            l2 = (l4 - l1) / 20L;
            if ((l4 - l1) % 20L == 0L) {}
            for (paramInt = 0;; paramInt = 1)
            {
              l2 = paramInt;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putBoolean("key_from_parallel_pull", true);
              ((Bundle)localObject2).putBoolean("success", false);
              paramInt = 0;
              while (l1 < l4)
              {
                ThreadManager.a(new qku(this, l1 + 19L, l4, paramInt, l1, paramString, (Bundle)localObject2), 8, null, false);
                l1 += 20L;
                paramInt += 1;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(MsgProxyUtils.a(paramString, 1), Boolean.valueOf(false));
            if (NetworkUtil.h(BaseApplication.getContext())) {}
            try
            {
              localObject1.wait(35000L);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 4 , size = " + ((List)localObject1).size() + " , timestamp = " + System.currentTimeMillis());
              }
              if ((!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(MsgProxyUtils.a(paramString, 1))) || (!((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(MsgProxyUtils.a(paramString, 1))).booleanValue())) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
            finally {}
          }
          label1245:
          l1 = l3;
        }
        label1252:
        l2 = l1;
      }
      i = 0;
      l1 = 0L;
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    long l3;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (((MessageRecord)localObject2).shmsgseq > 0L)
      {
        l3 = ((MessageRecord)localObject2).uniseq;
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
        a(paramRefreshMessageContext, paramInt1);
        return;
      }
      MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3);
      long l1;
      if (localMessageRecord1 == null)
      {
        l1 = 0L;
        if (localMessageRecord1 != null) {
          break label305;
        }
      }
      long l2;
      label305:
      for (int j = 3;; j = localMessageRecord1.versionCode)
      {
        localObject2 = a(paramString, paramInt1, paramInt2);
        i = 0;
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label1905;
        }
        int k = ((List)localObject2).size() - 1;
        l2 = l1;
        i = 0;
        while ((k >= 0) && (l2 - ((MessageRecord)((List)localObject2).get(k)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject2).get(k)).shmsgseq;
          i += 1;
          k -= 1;
        }
        l1 = localMessageRecord1.shmsgseq;
        break;
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        long l5;
        long l6;
        if (paramInt2 - i < 0)
        {
          i = 0;
          l5 = l4 - i + 1L;
          l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 0, delSeq = " + l6 + ", endSeq = " + l4 + ",beginSeq = " + l5 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L)
          {
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
            i = 0;
          }
          if (l4 > l6) {
            break label659;
          }
          paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
          i = 0;
          l1 = l5;
        }
        for (;;)
        {
          label484:
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localObject1 = new ArrayList();
          Iterator localIterator = ((List)localObject2).iterator();
          Object localObject3;
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label767;
            }
            localObject3 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject3).shmsgseq < l2)
            {
              ((List)localObject1).add(localObject3);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint invalid: id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
              continue;
              i = paramInt2 - i;
              break;
              label659:
              if (l5 > l6) {
                break label1898;
              }
              l1 = l6 + 1L;
              break label484;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint valid: id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
            }
          }
          label767:
          ((List)localObject2).removeAll((Collection)localObject1);
          ((List)localObject1).clear();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
          }
          boolean bool2 = true;
          boolean bool1 = bool2;
          if (!paramRefreshMessageContext.jdField_c_of_type_Boolean)
          {
            bool1 = bool2;
            if (l4 >= l2)
            {
              bool1 = bool2;
              if (l4 > 0L)
              {
                bool1 = bool2;
                if (i != 0)
                {
                  localObject1 = new Bundle();
                  i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
                  ((Bundle)localObject1).putInt("counter", i);
                  ((Bundle)localObject1).putBoolean("success", false);
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis());
                  }
                  if (paramInt1 == 3000) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(paramString).longValue(), l2, l4, true, (Bundle)localObject1);
                  }
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(false));
                    if (NetworkUtil.h(BaseApplication.getContext())) {}
                    try
                    {
                      localObject2.wait(35000L);
                      bool1 = ((Bundle)localObject1).getBoolean("success");
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 4 , size = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
                      }
                      if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(MsgProxyUtils.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(MsgProxyUtils.a(paramString, paramInt1))).booleanValue()))
                      {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
                        a(paramRefreshMessageContext, paramInt1);
                        return;
                        if (paramInt1 != 1) {
                          continue;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l2, l4, true, (Bundle)localObject1, 0);
                      }
                    }
                    catch (InterruptedException localInterruptedException)
                    {
                      for (;;)
                      {
                        localInterruptedException.printStackTrace();
                      }
                    }
                    finally {}
                  }
                }
              }
            }
          }
          if (((((List)localObject2).isEmpty()) && (l4 > 0L)) || ((!bool1) && (((List)localObject2).size() < paramInt2)))
          {
            if (((List)localObject2).isEmpty()) {
              break label1891;
            }
            HashMap localHashMap = new HashMap();
            localObject3 = ((List)localObject2).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              MessageRecord localMessageRecord2 = (MessageRecord)((Iterator)localObject3).next();
              if (localMessageRecord2.shmsgseq == ((MessageRecord)((List)localObject2).get(0)).shmsgseq)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                if (localMessageRecord2.getId() > 0L) {}
                for (localObject1 = "id&" + localMessageRecord2.getId();; localObject1 = "uniseq&" + localMessageRecord2.uniseq)
                {
                  localHashMap.put((String)localObject1 + "&" + localMessageRecord2.shmsgseq, localMessageRecord2);
                  break;
                }
              }
            }
            ((List)localObject2).addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)((List)localObject2).get(0)).shmsgseq, localHashMap));
          }
          label1629:
          label1635:
          label1785:
          label1880:
          label1891:
          for (l1 = ((MessageRecord)((List)localObject2).get(0)).shmsgseq - 1L;; l1 = l4)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
            if (localMessageRecord1 == null)
            {
              l2 = 0L;
              localObject1 = ((MsgProxy)localObject1).a(paramString, paramInt1, l2, j, l1, paramInt2 - ((List)localObject2).size(), null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam fail step 0 , size = " + ((List)localObject1).size() + ",seq = " + l1 + " , timestamp = " + System.currentTimeMillis());
              }
              if (!((List)localObject1).isEmpty()) {
                break label1785;
              }
              paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
              paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg", 2, "context.isLocalOnly = " + paramRefreshMessageContext.jdField_c_of_type_Boolean);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject2);
              paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject2);
              paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
              localObject1 = new StringBuilder().append("refresh finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
              if (localObject2 != null) {
                break label1880;
              }
            }
            for (paramInt2 = -1;; paramInt2 = ((List)localObject2).size())
            {
              paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
              a(paramRefreshMessageContext, paramInt1);
              return;
              l2 = localMessageRecord1.getId();
              break;
              ((List)localObject2).addAll(0, (Collection)localObject1);
              break label1629;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + l3 + " , locallist = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, (List)localObject2);
              break label1635;
            }
          }
          label1898:
          l1 = l5;
        }
        label1905:
        l2 = l1;
      }
      i = 0;
      l3 = 0L;
    }
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ThreadManager.a(new qkv(this, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramMessageRecord), l), 8, null, true);
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread return : uin=null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  protected void d(String paramString, int paramInt, long paramLong)
  {
    if ((paramString == null) || (paramLong < 0L)) {}
    label664:
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).a(paramString, paramInt);
      if ((localRecentUser != null) && (localRecentUser.shouldShowInRecentList()) && ((((localRecentUser.msg instanceof TroopAtMeMsg)) && (((TroopAtMeMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopSpecialAttentionMsg)) && (((TroopSpecialAttentionMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopAtAllMsg)) && (((TroopAtAllMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopHomeworkSpecialMsg)) && (((TroopHomeworkSpecialMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopReceivedFlowsersMsg)) && (((TroopReceivedFlowsersMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopHasGiftMsg)) && (((TroopHasGiftMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopPubAccountMsg)) && (((TroopPubAccountMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopDingdongAtMeMsg)) && (((TroopDingdongAtMeMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopNotificationMsg)) && (((TroopNotificationMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopCalendarMsg)) && (((TroopCalendarMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopReplyMsg)) && (((TroopReplyMsg)localRecentUser.msg).a.a <= paramLong)) || (((localRecentUser.msg instanceof TroopHomeworkPraiseMsg)) && (((TroopHomeworkPraiseMsg)localRecentUser.msg).a.a <= paramLong))))
      {
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        ((RecentUserProxy)localObject).a(localRecentUser);
        localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (paramInt == 1)
        {
          ((TroopInfoManager)localObject).a(paramString, 15);
          ((TroopInfoManager)localObject).a(paramString, 8);
          ((TroopInfoManager)localObject).a(paramString, 10);
          ((TroopInfoManager)localObject).a(paramString, 4);
          ((TroopInfoManager)localObject).a(paramString, 17);
          ((TroopInfoManager)localObject).a(paramString, 11);
          ((TroopInfoManager)localObject).a(paramString, 14);
          ((TroopInfoManager)localObject).a(paramString, 13);
          ((TroopInfoManager)localObject).a(paramString, 3);
        }
        for (;;)
        {
          if (paramInt != 1) {
            break label664;
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
          if ((paramInt == 1) || (paramInt == 4)) {
            break;
          }
          RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
          return;
          if (paramInt == 3000)
          {
            ((TroopInfoManager)localObject).a(paramString + "&" + 3000, 0);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "cleanBizTypeMark TYPE_ALL_MSG==>uin:" + paramString + "|seqFrom:" + paramLong);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\BaseMessageManagerForTroopAndDisc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */