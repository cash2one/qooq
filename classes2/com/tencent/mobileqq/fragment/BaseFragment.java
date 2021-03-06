package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;

public class BaseFragment
  extends Fragment
{
  protected View a;
  public IphoneTitleBarActivity a;
  protected TitlebarStatus a;
  protected QQProgressNotifier a;
  protected boolean a;
  protected int b;
  protected boolean b;
  public boolean c;
  
  public BaseFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (QLog.isColorLevel()) {
      QLog.i("Fragment", 2, "new BaseFragment:" + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  protected void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void c()
  {
    e();
    onHiddenChanged(false);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onPageSelected() " + getClass().getSimpleName());
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void e()
  {
    if ((getActivity() instanceof NearbyActivity)) {
      ((NearbyActivity)getActivity()).a(this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onActivityCreated() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NBase", 2, "onActivityResult() BaseFragment");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onAttach() " + getClass().getSimpleName() + " " + hashCode());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus == null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus = new TitlebarStatus(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)getActivity());
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onCreate() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onCreateView() " + getClass().getSimpleName() + " " + hashCode());
    }
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDestroy() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDestroyView() " + getClass().getSimpleName() + " " + hashCode());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDetach() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onHiddenChanged() " + getClass().getSimpleName() + " " + hashCode() + " hidden=" + paramBoolean);
    }
    if (paramBoolean)
    {
      onPause();
      return;
    }
    onResume();
  }
  
  public void onPause()
  {
    super.onPause();
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onPause() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onResume() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onStart() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onStop() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */