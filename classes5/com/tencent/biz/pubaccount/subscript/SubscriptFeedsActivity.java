package com.tencent.biz.pubaccount.subscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import icx;
import icy;
import icz;
import ida;
import idb;
import idc;
import idj;
import idk;
import idl;
import idm;
import idn;
import ido;
import idp;
import idq;
import idr;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class SubscriptFeedsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, SwipListView.RightIconMenuListener, Observer
{
  public static final int a = 1002;
  static final String jdField_a_of_type_JavaLangString = "subscript_feeds_readinjoy_articles";
  public static final int b = 1003;
  public static final String b = "subscript_guid";
  public static final int c = 1004;
  private static final String jdField_c_of_type_JavaLangString = SubscriptFeedsActivity.class.getSimpleName();
  public static final int d = 1005;
  private static final String jdField_d_of_type_JavaLangString = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
  public static final int e = 1006;
  private static final String jdField_e_of_type_JavaLangString = "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278";
  public static final int f = 1007;
  private float jdField_a_of_type_Float;
  public long a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private SubscriptFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter;
  private SubscriptObserver jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver = new idj(this);
  private SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  public SubscriptRecommendController a;
  private CustomGuideView jdField_a_of_type_ComTencentBizUiCustomGuideView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ida(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new icx(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  public MqqHandler a;
  protected boolean a;
  private float jdField_b_of_type_Float;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private long jdField_c_of_type_Long;
  public boolean c;
  private long jdField_d_of_type_Long;
  public boolean d;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  protected int g;
  private boolean g;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SubscriptFeedsActivity()
  {
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new idc(this, ThreadManager.b());
  }
  
  private ArrayList a()
  {
    Object localObject2;
    for (Object localObject1 = ReadInJoyHelper.a(this.app, 1);; localObject2 = null) {
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("subscript_feeds_readinjoy_articles", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = (ArrayList)SubscriptFeedsUtils.a((String)localObject1);
          return (ArrayList)localObject1;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_JavaUtilList);
    if (((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.jdField_g_of_type_Int == -1) || (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f == -1)) && (((!this.jdField_g_of_type_Boolean) && (SubscriptRecommendController.a(this.app))) || (PublicAccountUtil.a(this.app))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.jdField_g_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "subscript inner recommend need show !");
      }
    }
    a(true, false, false);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.notifyDataSetChanged();
      i();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null) && (!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.f == 0))
    {
      this.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.a();
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    Object localObject;
    if (paramArrayList != null) {
      localObject = ReadInJoyHelper.a(this.app, 1);
    }
    for (;;)
    {
      try
      {
        paramArrayList = SubscriptFeedsUtils.a(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
          bool1 = bool2;
          return bool1;
        }
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      bool1 = false;
    }
  }
  
  public static void d()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.a, SubscriptFeedsActivity.class);
    localIntent.putExtra("come_from", 1);
    localIntent.setFlags(67108864);
    BaseApplicationImpl.a.startActivity(localIntent);
  }
  
  private void e()
  {
    int j = 1;
    Object localObject = "6.5.5" + this.app.f() + "subscript_guid";
    if ((this.app.getPreferences().getBoolean((String)localObject, true)) && (SubscriptRecommendController.f(this.app))) {
      if (j != 0) {
        break label71;
      }
    }
    label71:
    do
    {
      return;
      j = 0;
      break;
      this.app.getPreferences().edit().putBoolean((String)localObject, false).commit();
      try
      {
        localObject = getResources();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow();
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView = new CustomGuideView(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_g_of_type_Int = ((Resources)localObject).getColor(2131427729);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.f = ((Resources)localObject).getColor(2131427730);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Float = AIOUtils.a(2, 14, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.e = AIOUtils.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Int = AIOUtils.a(30.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b = AIOUtils.a(7.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_h_of_type_Int = AIOUtils.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.c = AIOUtils.a(3.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_JavaLangString = "点击查看更多精彩内容";
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131296528);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_ComTencentBizUiCustomGuideView);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b());
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
        j = this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b();
        int k = getResources().getDisplayMetrics().widthPixels;
        this.rightViewText.post(new ido(this, k, j));
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(jdField_c_of_type_JavaLangString, 2, "showSubscriptCenterGuideWindow, " + localException);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(null);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_c_of_type_JavaLangString, 2, "closeSubscriptCenterGuideWindow, " + localException);
    }
  }
  
  private void g()
  {
    ThreadManager.b(new idp(this));
    if (TroopBarAssistantManager.a().a(this.app)) {
      TroopBarAssistantManager.a().a(this.app.a().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
    this.app.a().addObserver(this);
    if ((ReadInJoyHelper.c(this.app)) && ((SubscriptHandler)this.app.a(64) != null)) {}
    HtmlOffline.b("2278", this.app, true, new idq(this));
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      ThreadManager.a(new icy(this, localArrayList), 5, null, false);
    }
  }
  
  private void i()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300558)).setText(2131364535);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!bool) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427868);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130843537);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(false);
        if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.d();
        }
        return;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427869);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bool) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131427868);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEnabled(true);
      return;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131427869);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.g();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.h();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_h_of_type_Int = ((Integer)paramView.getTag(2131296517)).intValue();
    a(false);
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131299995))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131296519);
      if (paramDragFrameLayout != null)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_h_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
        c();
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1002);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1002);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_c_of_type_JavaLangString, 2, "refreshTroopBarAccountList, error: ", localException);
    }
  }
  
  public void b(View paramView)
  {
    this.jdField_h_of_type_Int = -1;
    a(true);
  }
  
  public void c()
  {
    if (this.leftView != null) {
      ThreadManager.a(new idr(this), 5, null, true);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    Object localObject;
    if (this.jdField_i_of_type_Int == 0)
    {
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentWidgetSwipListView.getLocationOnScreen((int[])localObject);
      this.jdField_i_of_type_Int = localObject[1];
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_h_of_type_Boolean = false;
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getHeight();
      if (f2 >= this.jdField_i_of_type_Int) {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_g_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_AndroidViewView != null))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_AndroidViewView.findViewById(2131300010);
          int[] arrayOfInt = new int[2];
          ((View)localObject).getLocationOnScreen(arrayOfInt);
          if (f2 >= arrayOfInt[1])
          {
            j = arrayOfInt[1];
            if (f2 < ((View)localObject).getHeight() + j) {
              this.jdField_h_of_type_Boolean = true;
            }
          }
        }
        else if (f2 < j + this.jdField_i_of_type_Int)
        {
          j = this.jdField_a_of_type_ComTencentWidgetSwipListView.b((int)f1, (int)f2 - this.jdField_i_of_type_Int);
          if (j != -1)
          {
            j -= this.jdField_a_of_type_ComTencentWidgetSwipListView.m();
            if ((j >= 0) && (j < this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getCount()))
            {
              if (j == this.jdField_h_of_type_Int) {
                this.jdField_h_of_type_Boolean = true;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.getItem(j).equals(SubscriptRecommendController.jdField_a_of_type_JavaLangString))
              {
                this.jdField_h_of_type_Boolean = true;
                continue;
                if (Math.abs(f1 - this.jdField_a_of_type_Float) > Math.abs(f2 - this.jdField_b_of_type_Float))
                {
                  if (f1 - this.jdField_a_of_type_Float > 20.0F)
                  {
                    if (this.jdField_h_of_type_Boolean) {
                      ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                    }
                  }
                  else if (f1 - this.jdField_a_of_type_Float < -20.0F) {
                    ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                  }
                }
                else if (Math.abs(f2 - this.jdField_b_of_type_Float) > 20.0F)
                {
                  continue;
                  ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(false);
                  this.jdField_h_of_type_Boolean = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    PublicTracker.a(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      new MqqHandler().postDelayed(new idk(this), 1000L);
    }
    setContentView(2130903766);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_g_of_type_Int = super.getIntent().getIntExtra("come_from", 0);
    this.jdField_d_of_type_Long = super.getIntent().getLongExtra("start_time", 0L);
    this.f = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = new SubscriptPicManager();
    setTitle(PublicAccountConfigUtil.a(this.app, getApplicationContext()));
    c();
    boolean bool = SubscriptRecommendController.f(this.app);
    this.rightViewText.setText(2131372084);
    if (bool)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131297951);
      this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131299978));
      SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label644;
      }
      paramBundle = getResources().getDrawable(2131427731);
      label281:
      localSwipListView.setDivider(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131494339));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(new idl(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904933, null);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
      ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131300876)).setVisibility(8);
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300896)).setText(String.format(getResources().getString(2131364553), new Object[] { PublicAccountConfigUtil.a(this.app, getApplicationContext()) }));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131300895));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new idm(this));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.a(this.jdField_b_of_type_AndroidViewView);
      e();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter = new SubscriptFeedsAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, getLayoutInflater());
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
      if (ThemeUtil.isInNightMode(this.app)) {
        break label658;
      }
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131427868);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
      ThreadManager.b(new idn(this));
      g();
      if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = new SubscriptRecommendController(this, this.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
      }
      this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      this.rightViewText.setVisibility(8);
      break;
      label644:
      paramBundle = getResources().getDrawable(2131427642);
      break label281;
      label658:
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131427869);
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.app != null) {
      this.app.a(getClass());
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsAdapter = null;
    }
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = null;
    if (this.jdField_d_of_type_Long != 0L)
    {
      this.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      if (!this.f) {
        break label282;
      }
    }
    label282:
    for (int j = 1;; j = 0)
    {
      ReportController.b(this.app, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + j, "" + this.jdField_d_of_type_Long, "", "");
      this.jdField_d_of_type_Long = 0L;
      this.f = false;
      super.doOnDestroy();
      return;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    boolean bool = SubscriptRecommendController.c(this.app);
    Object localObject = super.findViewById(2131297832);
    if (bool) {}
    for (int j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      if (this.jdField_b_of_type_Boolean)
      {
        if ((ReadInJoyHelper.c(this.app)) && ((SubscriptHandler)this.app.a(64) != null)) {}
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        String str = SubscriptRecommendController.a(this.app);
        Intent localIntent = new Intent(this, PublicAccountBrowser.class);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
        }
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.app.f());
        localIntent.putExtra("fromLocalUrl", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("assignBackText", "关闭");
        localIntent.putExtra("hideRightButton", true);
        localIntent.putExtra("assignBackText", PublicAccountConfigUtil.a(this.app, this));
        localIntent.putExtra("call_from", 1001);
        startActivity(localIntent);
        overridePendingTransition(2130968722, 2130968586);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "subscript full recommend need show !");
        }
        this.jdField_g_of_type_Boolean = false;
        ReportController.b(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
      }
      a();
      b();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    TroopBarAssistantManager.a().e(this.app);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    label291:
    label335:
    label504:
    label510:
    label544:
    int k;
    switch (paramView.getId())
    {
    default: 
    case 2131296528: 
    case 2131297183: 
    case 2131299991: 
      do
      {
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
        PublicAccountSearchActivity.a(this, PublicAccountConfigUtil.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
        SubscriptRecommendController.b(this.app, false);
        f();
        return;
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
        PublicAccountSearchActivity.a(this, PublicAccountConfigUtil.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
        SubscriptRecommendController.b(this.app, false);
        f();
        return;
      } while (((Integer)paramView.getTag(2131296518)).intValue() != SubscriptFeedsAdapter.d);
      localObject2 = paramView.getTag(2131296519);
      Object localObject3 = paramView.getTag(2131296520);
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label504;
        }
        j = ((Integer)localObject2).intValue();
        localObject2 = Integer.valueOf(j);
        if (((Integer)localObject2).intValue() <= 0) {
          break label510;
        }
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject3 = (PublicAccountHandler)this.app.a(11);
          if (localObject3 != null) {
            ((PublicAccountHandler)localObject3).a();
          }
        }
        paramView = paramView.getTag(2131296521);
        if (paramView == null) {
          break label544;
        }
      }
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject3 = new Intent(this, ChatActivity.class);
        ((Intent)localObject3).putExtra("uintype", 1008);
        ((Intent)localObject3).putExtra("uin", (String)localObject1);
        ((Intent)localObject3).putExtra("uinname", paramView);
        ((Intent)localObject3).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("red_hot_count", (Serializable)localObject2);
        startActivity((Intent)localObject3);
        f();
        return;
        localObject1 = "";
        break;
        j = 0;
        break label291;
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        break label335;
      }
    case 2131300001: 
    case 2131300003: 
    case 2131300004: 
    case 2131300005: 
    case 2131300006: 
      ReportController.b(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).putExtra("channel_id", 0);
      ((Intent)localObject1).putExtra("readinjoy_launch_source", 9);
      localObject2 = new ArrayList();
      long l;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 4))
      {
        j = 0;
        while (j < 4)
        {
          ((ArrayList)localObject2).add(Long.valueOf(((ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).mArticleID));
          j += 1;
        }
        ((Intent)localObject1).putExtra("subscription_all_article_id", (Serializable)localObject2);
        if ((paramView.getId() == 2131300003) || (paramView.getId() == 2131300004) || (paramView.getId() == 2131300005) || (paramView.getId() == 2131300006))
        {
          j = ((Integer)paramView.getTag()).intValue();
          paramView = (ReadInJoyArticle)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (paramView != null)
          {
            l = paramView.mArticleID;
            ((Intent)localObject1).putExtra("subscription_click_article_id", Long.valueOf(l));
          }
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = true;
        ReadInJoyHelper.a(this.app, this, (Intent)localObject1);
        f();
        return;
        l = -1L;
        break;
        ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
        }
      }
    case 2131299999: 
    case 2131300000: 
      paramView = paramView.getTag(2131296520);
      if (paramView != null)
      {
        paramView = (String)paramView;
        if (TroopBarAssistantManager.a().a(paramView, this.app)) {
          break label1033;
        }
        TroopBarAssistantManager.a().e(paramView, this.app);
        ReportController.b(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        k = TroopBarAssistantManager.a().b();
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (SubscriptionFeed)((Iterator)localObject1).next();
        } while ((((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString.equals(paramView)));
      }
      break;
    }
    for (int j = ((SubscriptionFeed)localObject2).jdField_h_of_type_Int;; j = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064CD", "0X80064CD", 0, 0, "" + j, "" + k, "", "");
      b();
      return;
      paramView = "";
      break;
      label1033:
      TroopBarAssistantManager.a().f(paramView, this.app);
      k = TroopBarAssistantManager.a().b();
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (SubscriptionFeed)((Iterator)localObject1).next();
      } while ((((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString.equals(paramView)));
      for (j = ((SubscriptionFeed)localObject2).jdField_h_of_type_Int;; j = 0)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064CE", "0X80064CE", 0, 0, "" + j, "" + k, "", "");
        break;
        localObject1 = paramView.getTag(2131296520);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          paramView = paramView.getTag(2131296521);
          if (paramView == null) {
            break label1279;
          }
        }
        label1279:
        for (paramView = (String)paramView;; paramView = "")
        {
          localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
          ((ActionSheet)localObject2).a(String.format(getResources().getString(2131364548), new Object[] { paramView }));
          ((ActionSheet)localObject2).a(2131364502, 3);
          ((ActionSheet)localObject2).d(2131367262);
          ((ActionSheet)localObject2).a(new icz(this, (String)localObject1, (ActionSheet)localObject2));
          ((ActionSheet)localObject2).show();
          return;
          localObject1 = "";
          break;
        }
        paramView = paramView.getTag(2131296520);
        if (paramView != null)
        {
          paramView = (String)paramView;
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
          ReportController.b(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
          TroopBarAssistantManager.a().d(paramView, this.app);
          b();
          j = PublicAccountUtil.a(this.app, paramView);
          RecentUtil.b(this.app, paramView, j);
          this.app.a().c(paramView, 1008);
          localObject1 = this.app.a(Conversation.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).sendEmptyMessage(1014);
          }
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (SubscriptionFeed)((Iterator)localObject1).next();
          } while ((((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString.equals(paramView)));
        }
        for (j = ((SubscriptionFeed)localObject2).jdField_h_of_type_Int;; j = 0)
        {
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064D0", "0X80064D0", 0, 0, "" + j, "", "", "");
          return;
          paramView = "";
          break;
        }
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new idb(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != 63534)) {}
    }
    else
    {
      return;
    }
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptFeedsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */