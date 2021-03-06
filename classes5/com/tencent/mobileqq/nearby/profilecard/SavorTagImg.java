package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.widget.HorizontalListView;
import java.security.InvalidParameterException;
import java.util.List;

public class SavorTagImg
  extends LinearLayout
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 60, 60, 60 };
  static final int[] b = { 85, 60, 60 };
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  OnTagClickListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SavorTagImg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SavorTagImg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    removeAllViews();
    int i = getResources().getDimensionPixelSize(2131492999);
    int j = getResources().getDimensionPixelSize(2131493000);
    setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2130904256, null));
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.topMargin = j;
    localLayoutParams.bottomMargin = j;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener != null)
    {
      Object localObject = (SavorImgTagAdapter)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a();
      if (localObject != null)
      {
        localObject = (InterestTagInfo)((SavorImgTagAdapter)localObject).getItem(paramInt);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener.a(paramView, this.jdField_a_of_type_Int, (InterestTagInfo)localObject);
        }
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("兴趣标签,");
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a();
    if (localListAdapter == null) {
      return "";
    }
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(localListAdapter.getCount()).append("个");
    int i = 0;
    if (i < localListAdapter.getCount())
    {
      localStringBuilder.append(",");
      Object localObject = (InterestTagInfo)localListAdapter.getItem(i);
      if (localObject != null) {}
      for (localObject = ((InterestTagInfo)localObject).tagName;; localObject = "")
      {
        localStringBuilder.append((String)localObject);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString, int paramInt, List paramList, OnTagClickListener paramOnTagClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      throw new InvalidParameterException("SavorTagImg can not init twice");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener = paramOnTagClickListener;
    int i = 0;
    int j;
    switch (paramInt)
    {
    default: 
      paramString = getResources();
      float f = paramString.getDisplayMetrics().density;
      j = (int)(jdField_a_of_type_ArrayOfInt[i] * f);
      i = (int)(b[i] * f);
      int k = paramString.getDimensionPixelSize(2131493516);
      int m = paramString.getDimensionPixelSize(2131492999);
      int n = paramString.getDimensionPixelSize(2131493000);
      paramString = new GradientDrawable();
      if (this.jdField_a_of_type_Int == 7)
      {
        paramString.setColor(getResources().getColor(2131427623));
        paramString.setCornerRadius(10.0F * f);
        paramString.setShape(0);
        int i1 = getResources().getDimensionPixelSize(2131493433);
        paramString.setSize(i1, i1);
        label191:
        paramString = new SavorImgTagAdapter(getContext(), paramString, j, i, paramInt);
        paramString.a(m - k);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = new HorizontalListView(getContext());
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(k);
        paramOnTagClickListener = generateDefaultLayoutParams();
        paramOnTagClickListener.width = -1;
        paramOnTagClickListener.height = paramString.a();
        paramOnTagClickListener.bottomMargin = n;
        addView(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, paramOnTagClickListener);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener == null) {
          break label380;
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemLongClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
      }
      break;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(0);
      }
      a(paramList);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      paramString.setColor(getResources().getColor(2131427623));
      paramString.setShape(0);
      paramString.setSize(j, i);
      break label191;
      label380:
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
      throw new InvalidParameterException("can not updateData before init");
    }
    SavorImgTagAdapter localSavorImgTagAdapter = (SavorImgTagAdapter)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a();
    if (localSavorImgTagAdapter == null) {
      return;
    }
    localSavorImgTagAdapter.a(paramList);
    if (paramList == null) {}
    for (int i = 0; i > 0; i = paramList.size())
    {
      paramList = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      paramList.append('(').append(i).append(')');
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList.toString());
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      Rect localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getGlobalVisibleRect(localRect)) && (localRect.bottom - localRect.top >= 0.5D * this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight())) {
        return true;
      }
    }
    return false;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt);
    return true;
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838201, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\SavorTagImg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */