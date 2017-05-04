package com.jaydenxiao.common.citypicterview.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.citypicterview.model.BaseDates;
import com.jaydenxiao.common.citypicterview.sqlhelper.Sqlrefer;
import com.jaydenxiao.common.citypicterview.widget.wheel.OnWheelChangedListener;
import com.jaydenxiao.common.citypicterview.widget.wheel.OnWheelScrollListener;
import com.jaydenxiao.common.citypicterview.widget.wheel.WheelView;
import com.jaydenxiao.common.citypicterview.widget.wheel.adapters.ArrayWheelAdapter;
import com.jaydenxiao.common.commonutils.DialogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 省市区三级选择
 * 网络请求服务端json数据
 */
public class CityPickerFromJson implements CanShow, OnWheelChangedListener, OnWheelScrollListener {

    private Context context;
    private FragmentManager fragmentManager;
//    private PopupWindow popwindow;

//    private View popview;

    private WheelView mViewProvince;

    private WheelView mViewCity;

    private WheelView mViewDistrict;

    private RelativeLayout mRelativeTitleBg;

    private TextView mTvOK;

    private TextView mTvTitle;

    private TextView mTvCancel;

    /**
     * 所有省
     */
    protected String[] mProvinceDatas;

    /**
     * key - 省 value - 市
     */
    private Map<String, List<BaseDates>> mCitisDatasMap = new HashMap<String, List<BaseDates>>();
    List<BaseDates> mProvinceList;
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
    private ArrayWheelAdapter districtWheel;
    private ArrayWheelAdapter arrayWheelAdapter;
    private ArrayWheelAdapter cityWheel;


    public interface OnCityItemClickListener {
        void onSelected(String... citySelected);
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
     * Color.BLUE
     */
    private String confirmTextColorStr = "#525252";

    /**
     * 标题背景颜色
     */
    private String titleBackgroundColorStr = "#f6f6f6";
    /**
     * 标题颜色
     */
    private String titleTextColorStr = "#E9E9E9";

    /**
     * 第一次默认的显示省份，一般配合定位，使用
     */
    private String defaultProvinceName = "";

    /**
     * 第一次默认得显示城市，一般配合定位，使用
     */
    private String defaultCityName = "";

    /**
     * 第一次默认得显示，一般配合定位，使用
     */
    private String defaultDistrict = "";

    /**
     * 两级联动
     */
    private boolean showProvinceAndCity = false;

    /**
     * 是否是选择银行
     */
    private boolean showBankChoices = false;


    /**
     * 标题
     */
    private String mTitle = "选择地区";


    public CityPickerFromJson setDefaultProvinceName(String defaultProvinceName) {
        this.defaultProvinceName = defaultProvinceName;
        return this;
    }


    public CityPickerFromJson setDefaultCityName(String defaultCityName) {
        this.defaultCityName = defaultCityName;
        return this;

    }


    public CityPickerFromJson setShowProvinceAndCity(boolean showProvinceAndCity) {
        this.showProvinceAndCity = showProvinceAndCity;
        return this;

    }


    public CityPickerFromJson setShowBankChoices(boolean showBankChoices) {
        this.showBankChoices = showBankChoices;
        return this;

    }

    public static CityPickerFromJson GetcitiPicter(Context context, FragmentManager fragmentManager, Map<String, List<BaseDates>> mCitisDatasMap, List<BaseDates> mProvinceList) {

        return new CityPickerFromJson(context, fragmentManager, mCitisDatasMap, mProvinceList);
    }

    private CityPickerFromJson(final Context context, FragmentManager fragmentManager, final Map<String, List<BaseDates>> mCitisDatasMap, final List<BaseDates> mProvinceList) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.mCitisDatasMap = mCitisDatasMap;
        this.mProvinceList = mProvinceList;
        dialogUtils = DialogUtils.Dialog()
                .setClickExternalVanish(true)
//                .setReturnVanish(true)
                .setShowOrientation(Gravity.BOTTOM)
                .setAnimationStyle(R.style.AnimBottom)
                .setLayoutView(R.layout.pop_citypicker).setViewMonitor(new DialogUtils.ViewMonitor() {
                    @Override
                    public View setView(final DialogUtils du, View v) {
                        mViewProvince = (WheelView) v.findViewById(R.id.id_province);
                        mViewCity = (WheelView) v.findViewById(R.id.id_city);
                        mViewDistrict = (WheelView) v.findViewById(R.id.id_district);
                        mViewProvince.setDividePadding(13, 0);
                        mViewCity.setDividePadding(0, 13);
                        mRelativeTitleBg = (RelativeLayout) v.findViewById(R.id.rl_title);
                        mTvOK = (TextView) v.findViewById(R.id.tv_confirm);
                        mTvTitle = (TextView) v.findViewById(R.id.tv_title);
                        mTvCancel = (TextView) v.findViewById(R.id.tv_cancel);
                        /**
                         * 设置标题背景颜色
                         */
//                        if (!TextUtils.isEmpty(titleBackgroundColorStr)) {
//                            mRelativeTitleBg.setBackgroundColor(Color.parseColor(titleBackgroundColorStr));
//                        }

                        /**
                         * 设置标题
                         */
//                        if (!TextUtils.isEmpty(mTitle)) {
//                            mTvTitle.setText(mTitle);
//                        }


                        //设置确认按钮文字颜色
//                        if (!TextUtils.isEmpty(titleTextColorStr)) {
//                            mTvTitle.setTextColor(Color.parseColor(titleTextColorStr));
//                        }


                        //设置确认按钮文字颜色
//                        if (!TextUtils.isEmpty(confirmTextColorStr)) {
//                            mTvOK.setTextColor(Color.parseColor(confirmTextColorStr));
//                        }

                        //设置取消按钮文字颜色
//                        if (!TextUtils.isEmpty(cancelTextColorStr)) {
//                            mTvCancel.setTextColor(Color.parseColor(cancelTextColorStr));
//                        }


                        //只显示省市两级联动
                        if (showProvinceAndCity) {
                            mViewDistrict.setVisibility(View.GONE);
                        } else {
                            mViewDistrict.setVisibility(View.VISIBLE);
                        }

                        //初始化城市数据
                        initProvinceDatas(context);

                        addListener();
                        // 添加onclick事件
                        mTvCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                hide();
                            }
                        });
                        mTvOK.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mCurrentProviceName = mProvinceList.get(mViewProvince.getCurrentItem()).getName();
                                mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName).get(mViewCity.getCurrentItem()).getName();
//                                mCurrentDistrictName = districtList.get(mViewDistrict.getCurrentItem()).getName();
                                String proinceCode = mProvinceList.get(mViewProvince.getCurrentItem()).getCode() + "";
                                String cityCode = mCitisDatasMap.get(mCurrentProviceName).get(mViewCity.getCurrentItem()).getCode() + "";
//                                String districtCode = districtList.get(mViewDistrict.getCurrentItem()).getCode() + "";
                                if (listener != null) {

                                    if (showProvinceAndCity) {
                                        listener.onSelected(mCurrentProviceName, mCurrentCityName, proinceCode, cityCode);
                                    } else {
                                        listener.onSelected(mCurrentProviceName, mCurrentCityName, mCurrentDistrictName, proinceCode, cityCode, "");
                                    }
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
        // 添加change事件
        mViewCity.addChangingListener(this);
        // 添加change事件
        mViewDistrict.addChangingListener(this);

        mViewProvince.addScrollingListener(this);
        mViewCity.addScrollingListener(this);
        mViewDistrict.addScrollingListener(this);
    }


    private void setUpData() {
        int provinceDefault = -1;
        //遍历判断位置
        if (!TextUtils.isEmpty(defaultProvinceName) && mProvinceList.size() > 0) {
            for (int i = 0; i < mProvinceList.size(); i++) {
                if (mProvinceList.get(i).getName().contains(defaultProvinceName)) {
                    provinceDefault = i;
                    break;
                }
            }
        }
        if (-1 != provinceDefault) {
            arrayWheelAdapter = new ArrayWheelAdapter(context, mProvinceList, provinceDefault);
        } else {
            arrayWheelAdapter = new ArrayWheelAdapter(context, mProvinceList, 0);
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
        mViewProvince.setVisibleItems(visibleItems);
        mViewCity.setVisibleItems(visibleItems);
        mViewDistrict.setVisibleItems(visibleItems);
        mViewProvince.setCyclic(isProvinceCyclic);
        mViewCity.setCyclic(isCityCyclic);
        mViewDistrict.setCyclic(isDistrictCyclic);
        arrayWheelAdapter.setPadding(padding);
//        arrayWheelAdapter.setTextColor(textColor);
        arrayWheelAdapter.setTextSize(textSize);
        setItemTextSize(mProvinceList.get(0).getName(), arrayWheelAdapter);
        updateCities();
//        updateAreas();

    }

    /**
     * 解析省市区的XML数据
     */

    protected void initProvinceDatas(Context context) {
        //可在此预设值默认位置
//
//        try {
//
//            provinceList = getDatesList(1, 0);
//
//        } catch (Throwable e) {
//            e.printStackTrace();
//        } finally {
//
//        }
    }

    /**
     * 根据当前的市，更新区WheelView的信息
     */
    private void updateAreas() {

//        int pCurrent = mViewCity.getCurrentItem();
//
//        districtList = getDatesList(3, cityList.get(pCurrent).getCode());
//        int districtDefault = -1;
//        if (!TextUtils.isEmpty(defaultDistrict) && districtList.size() > 0) {
//            for (int i = 0; i < districtList.size(); i++) {
//                if (districtList.get(i).getName().contains(defaultDistrict)) {
//                    districtDefault = i;
//                    break;
//                }
//            }
//        }
//        if (-1 != districtDefault) {
//            districtWheel = new ArrayWheelAdapter(context, districtList, districtDefault);
//        }
//        {
//            districtWheel = new ArrayWheelAdapter(context, districtList, 0);
//        }
//        // 设置可见条目数量
//        districtWheel.setTextColor(textColor);
//        districtWheel.setTextSize(textSize);
//        mViewDistrict.setViewAdapter(districtWheel);
//        if (-1 != districtDefault) {
//            mViewDistrict.setCurrentItem(districtDefault);
//            //获取默认设置的区
//            mCurrentDistrictName = defaultDistrict;
//        } else {
//            mViewDistrict.setCurrentItem(0);
//            // 获取第一个区名称
//            mCurrentDistrictName = districtList.get(0).getName();
//
//        }
//        districtWheel.setPadding(padding);
    }

    /**
     * 根据当前的省，更新市WheelView的信息
     */
    private void updateCities() {
        int pCurrent = mViewProvince.getCurrentItem();

        mCurrentProviceName = mProvinceList.get(pCurrent).getName();

        cityList = mCitisDatasMap.get(mCurrentProviceName);

        int cityDefault = -1;
        if (!TextUtils.isEmpty(defaultCityName) && cityList.size() > 0) {
            for (int i = 0; i < cityList.size(); i++) {
                if (cityList.get(i).getName().contains(defaultCityName)) {
                    cityDefault = i;
                    break;
                }
            }
        }
        if (-1 != cityDefault) {
            cityWheel = new ArrayWheelAdapter(context, cityList, cityDefault);
        } else {
            cityWheel = new ArrayWheelAdapter(context, cityList, 0);
        }
        cityWheel.setTextSize(textSize);
        mViewCity.setViewAdapter(cityWheel);
        if (-1 != cityDefault) {
            mViewCity.setCurrentItem(cityDefault);
        } else {
            mViewCity.setCurrentItem(0);
            defaultCityName = cityList.get(0).getName();
        }

        cityWheel.setPadding(padding);

        updateAreas();
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

            updateCities();
        } else if (wheel == mViewCity) {
            //获取当前的索引
            int currentItem = mViewCity.getCurrentItem();
            /**
             * 获取内容
             */
            String text = (String) cityWheel.getItemText(currentItem);
            /**
             * 设置字体
             *
             */
            setItemTextSize(text, cityWheel);
            updateAreas();
        } else if (wheel == mViewDistrict) {

//            mCurrentDistrictName = mDistrictDatasMap.get(mCurrentCityName)[newValue];
//            JLogUtils.D("zipcode key: " + mCurrentProviceName + mCurrentCityName + mCurrentDistrictName);
//            mCurrentZipCode = mZipcodeDatasMap.get(mCurrentProviceName + mCurrentCityName + mCurrentDistrictName);
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
        } else if (wheel == mViewCity) {
            //获取当前的索引
            int currentItem = mViewCity.getCurrentItem();
            /**
             * 获取内容
             */
            String text = (String) cityWheel.getItemText(currentItem);
            /**
             * 设置字体
             *
             */
            setItemTextSize(text, cityWheel);
//            updateAreas();
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
    private void setItemTextSize(String currentItemText, ArrayWheelAdapter arrayWheelAdapter) {
        //获取所有的View
        ArrayList<View> arrayLists = arrayWheelAdapter.getTextViews();

        int size = arrayLists.size();
        //当前条目的内容
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textview = (TextView) arrayLists.get(i);
            currentText = textview.getText().toString().trim();

            if (currentItemText.equals(currentText)) {
                textview.setTextColor(Color.parseColor("#38adac"));
            } else {
                textview.setTextColor(Color.parseColor("#747474"));
            }


        }

    }

}
