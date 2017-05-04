package com.jaydenxiao.common.citypicterview.widget;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.citypicterview.model.BaseDates;
import com.jaydenxiao.common.citypicterview.sqlhelper.Sqlrefer;
import com.jaydenxiao.common.citypicterview.utils.SpannerUtils;
import com.jaydenxiao.common.citypicterview.widget.wheel.OnWheelChangedListener;
import com.jaydenxiao.common.citypicterview.widget.wheel.OnWheelScrollListener;
import com.jaydenxiao.common.citypicterview.widget.wheel.WheelView;
import com.jaydenxiao.common.citypicterview.widget.wheel.adapters.SingleWheelPickerAdapter;
import com.jaydenxiao.common.commonutils.DialogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 省市区三级选择
 * 网络请求服务端json数据
 */
public class SinglePicker implements CanShow, OnWheelChangedListener, OnWheelScrollListener {

    private Context context;
    private FragmentManager fragmentManager;
//    private PopupWindow popwindow;

//    private View popview;

    private WheelView mViewProvince;


    private Button btnConfirm;


    List<String> mProvinceList;
    /**
     * key - 市 values - 区
     */
//    protected Map<String, String[]> mDistrictDatasMap = new HashMap<String, String[]>();

    /**
     * key - 区 values - 邮编
     */
//    protected Map<String, String> mZipcodeDatasMap = new HashMap<String, String>();

    /**
     * 当前省的名称
     */
    protected String mCurrentProviceName;

    /**
     * 当前市的名称
     */
    protected String mCurrentCityName;

    /**
     * 当前区的名称
     */
    protected String mCurrentDistrictName = "";

    /**
     * 当前区的邮政编码
     */
    protected String mCurrentZipCode = "";

    private OnCityItemClickListener listener;
    //    private List<BaseDates> provinceList;
    private List<BaseDates> cityList;
    //    private List<BaseDates> districtList;
    private final DialogUtils dialogUtils;
    private SingleWheelPickerAdapter arrayWheelAdapter;


    public interface OnCityItemClickListener {
        void onSelected(int position);
    }

    public void setOnCityItemClickListener(OnCityItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * Default text color
     */
    public static final int DEFAULT_TEXT_COLOR = 0xFF38adac;

    /**
     * Default text size
     */
    public static final int DEFAULT_TEXT_SIZE = 19;

    // Text settings
    private int textColor = DEFAULT_TEXT_COLOR;

    private int textSize = DEFAULT_TEXT_SIZE;

    /**
     * 滚轮显示的item个数
     */
    private static final int DEF_VISIBLE_ITEMS = 5;

    // Count of visible items
    private int visibleItems = DEF_VISIBLE_ITEMS;

    /**
     * 省滚轮是否循环滚动
     */
    private boolean isProvinceCyclic = false;

    /**
     * 市滚轮是否循环滚动
     */
    private boolean isCityCyclic = false;

    /**
     * 区滚轮是否循环滚动
     */
    private boolean isDistrictCyclic = true;

    /**
     * item间距
     */
    private int padding = 10;


    /**
     * Color.BLACK
     */
    private String cancelTextColorStr = "#000000";


    /**
     * 第一次默认的显示省份，一般配合定位，使用
     */
    private String defaultProvinceName = "";

    /**
     * 是否是选择银行
     */
    private boolean showBankChoices = false;


    /**
     * 标题
     */
    private String mTitle = "选择地区";


    public SinglePicker setDefaultProvinceName(String defaultProvinceName) {
        this.defaultProvinceName = defaultProvinceName;
        return this;
    }


    public SinglePicker setShowBankChoices(boolean showBankChoices) {
        this.showBankChoices = showBankChoices;
        return this;

    }

    public static SinglePicker GetcitiPicter(Context context, FragmentManager fragmentManager, List<String> mProvinceList) {

        return new SinglePicker(context, fragmentManager, mProvinceList);
    }

    private SinglePicker(final Context context, FragmentManager fragmentManager, final List<String> mProvinceList) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.mProvinceList = mProvinceList;
        dialogUtils = DialogUtils.Dialog()
                .setClickExternalVanish(true)
//                .setReturnVanish(true)
                .setShowOrientation(Gravity.CENTER)
                .setAnimationStyle(R.style.AnimBottom)
                .setLayoutView(R.layout.single_pop_picker).setViewMonitor(new DialogUtils.ViewMonitor() {
                    @Override
                    public View setView(final DialogUtils du, View v) {
                        mViewProvince = (WheelView) v.findViewById(R.id.id_province);
                        mViewProvince.setDrawShadows(false);
                        mViewProvince.setHasDivideLine(false);
                        btnConfirm = (Button) v.findViewById(R.id.btn_confirm);

                        addListener();

                        btnConfirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                mCurrentProviceName = mProvinceList.get(mViewProvince.getCurrentItem());

//                                String districtCode = districtList.get(mViewDistrict.getCurrentItem()).getCode() + "";
                                if (listener != null) {
                                    listener.onSelected(mViewProvince.getCurrentItem());

                                }
                                du.dismiss();
//                                hide();

                            }
                        });
                        setUpData();
                        return v;
                    }
                }).show(fragmentManager);
    }

    private void addListener() {
        // 添加change事件
        mViewProvince.addChangingListener(this);

        mViewProvince.addScrollingListener(this);

    }


    private void setUpData() {
        int provinceDefault = -1;
        //遍历判断位置
        if (!TextUtils.isEmpty(defaultProvinceName) && mProvinceList.size() > 0) {
            for (int i = 0; i < mProvinceList.size(); i++) {
                if (mProvinceList.get(i).contains(defaultProvinceName)) {
                    provinceDefault = i;
                    break;
                }
            }
        }
        if (-1 != provinceDefault) {
            arrayWheelAdapter = new SingleWheelPickerAdapter(context, mProvinceList, provinceDefault);
        } else {
            arrayWheelAdapter = new SingleWheelPickerAdapter(context, mProvinceList, 0);
        }
//        arrayWheelAdapter = new ArrayWheelAdapter(context, provinceList);
        mViewProvince.setViewAdapter(arrayWheelAdapter);
        //获取所设置的省的位置，直接定位到该位置
        if (-1 != provinceDefault) {
            mViewProvince.setCurrentItem(provinceDefault);
        } else {
            mViewProvince.setCurrentItem(0);
        }
        // 设置可见条目数量
        mViewProvince.setVisibleItems(3);
        mViewProvince.setCyclic(isProvinceCyclic);
        arrayWheelAdapter.setPadding(padding);
        setItemTextSize(mProvinceList.get(0), arrayWheelAdapter);

    }


    @Override
    public void setType(int type) {
    }

    @Override
    public void show() {
        if (!isShow()) {
//            setUpData();
//            dialogUtils.show(fragmentManager);
//            popwindow.showAtLocation(popview, Gravity.BOTTOM, 0, 0);
        }
    }

    @Override
    public void hide() {
        if (isShow()) {
            dialogUtils.dismiss();
//            popwindow.dismiss();
        }
    }

    @Override
    public boolean isShow() {
        return dialogUtils.getShowsDialog();
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        // TODO Auto-generated method stub
        if (wheel == mViewProvince) {
            //获取当前的索引
            int currentItem = mViewProvince.getCurrentItem();
            /**
             * 获取内容
             */
            String text = (String) arrayWheelAdapter.getItemText(currentItem);
            /**
             * 设置字体
             *
             */
            setItemTextSize(text, arrayWheelAdapter);

        }
    }

    @Override
    public void onScrollingStarted(WheelView wheel) {

    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
        if (wheel == mViewProvince) {
            //获取当前的索引
            int currentItem = mViewProvince.getCurrentItem();
            /**
             * 获取内容
             */
            String text = (String) arrayWheelAdapter.getItemText(currentItem);
            /**
             * 设置字体
             *
             */
            setItemTextSize(text, arrayWheelAdapter);

//            updateCities();
        }
    }

    /**
     * @param i    showBankChoices=false 1省，2市，3区，showBankChoices=true 1，银行卡，2，银行卡类型，3待定
     * @param code
     * @return
     */
    private List<BaseDates> getDatesList(int i, int code) {
        List<BaseDates> lists = null;
        switch (i) {
            case 1:
                if (!showBankChoices) {
                    lists = new Sqlrefer(context).province();
                } else {
                    lists = new Sqlrefer(context).banks();
                }
                break;
            case 2:
                if (!showBankChoices) {
                    lists = new Sqlrefer(context).city(code + "");
                } else {
                    lists = new Sqlrefer(context).bankTypes(code + "");
                }
                break;
            case 3:
                if (!showBankChoices) {

                    lists = new Sqlrefer(context).county(code + "");
                } else {
                    lists = new Sqlrefer(context).bankTypes(code + "");
                }
                break;
            default:
                break;
        }
        return lists;
    }


    /**
     * 设置字体大小
     *
     * @param currentItemText
     * @param arrayWheelAdapter
     */
    private void setItemTextSize(String currentItemText, SingleWheelPickerAdapter arrayWheelAdapter) {
        //获取所有的View
        ArrayList<View> arrayLists = arrayWheelAdapter.getTextViews();

        int size = arrayLists.size();
        //当前条目的内容
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textview = (TextView) arrayLists.get(i);
            currentText = textview.getText().toString().trim();

            if (currentItemText.equals(currentText)) {

                SpannerUtils.setDiffColorText(currentText, true, textview);

//                textview.setTextColor(Color.parseColor("#38adac"));
            } else {
                SpannerUtils.setDiffColorText(currentText, false, textview);
//                textview.setTextColor(Color.parseColor("#747474"));
            }


        }

    }

}
