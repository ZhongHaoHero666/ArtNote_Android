package com.jaydenxiao.common.citypicterview.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.citypicterview.model.BaseDates;
import com.jaydenxiao.common.citypicterview.sqlhelper.Sqlrefer;
import com.jaydenxiao.common.citypicterview.widget.wheel.OnWheelChangedListener;
import com.jaydenxiao.common.citypicterview.widget.wheel.WheelView;
import com.jaydenxiao.common.citypicterview.widget.wheel.adapters.ArrayWheelAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 省市区三级选择
 * 作者：liji on 2015/12/17 10:40
 * 邮箱：lijiwork@sina.com
 */
public class CityPicker implements CanShow, OnWheelChangedListener {

    private Context context;

    private PopupWindow popwindow;

    private View popview;

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
    protected Map<String, String[]> mCitisDatasMap = new HashMap<String, String[]>();

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
    private List<BaseDates> provinceList;
    private List<BaseDates> cityList;
    private List<BaseDates> districtList;
    private ArrayWheelAdapter arrayWheelAdapter;
    private ArrayWheelAdapter cityWheel;
    private ArrayWheelAdapter districtWheel;

    public interface OnCityItemClickListener {
        void onSelected(String... citySelected);
    }

    public void setOnCityItemClickListener(OnCityItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * Default text color
     */
    public static final int DEFAULT_TEXT_COLOR = 0xFF585858;

    /**
     * Default text size
     */
    public static final int DEFAULT_TEXT_SIZE = 18;

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
    private boolean isProvinceCyclic = true;

    /**
     * 市滚轮是否循环滚动
     */
    private boolean isCityCyclic = true;

    /**
     * 区滚轮是否循环滚动
     */
    private boolean isDistrictCyclic = true;

    /**
     * item间距
     */
    private int padding = 5;


    /**
     * Color.BLACK
     */
    private String cancelTextColorStr = "#000000";


    /**
     * Color.BLUE
     */
    private String confirmTextColorStr = "#0000FF";

    /**
     * 标题背景颜色
     */
    private String titleBackgroundColorStr = "#E9E9E9";
    /**
     * 标题颜色
     */
    private String titleTextColorStr = "#E9E9E9";

    /**
     * 第一次默认的显示省份，一般配合定位，使用
     */
    private String defaultProvinceName = "上海市";

    /**
     * 第一次默认得显示城市，一般配合定位，使用
     */
    private String defaultCityName = "上海市";

    /**
     * 第一次默认得显示，一般配合定位，使用
     */
    private String defaultDistrict = "徐汇区";

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

    /**
     * 设置popwindow的背景
     */
    private int backgroundPop = 0xa0000000;

    private CityPicker(Builder builder) {
        this.textColor = builder.textColor;
        this.textSize = builder.textSize;
        this.visibleItems = builder.visibleItems;
        this.isProvinceCyclic = builder.isProvinceCyclic;
        this.isDistrictCyclic = builder.isDistrictCyclic;
        this.isCityCyclic = builder.isCityCyclic;
        this.context = builder.mContext;
        this.padding = builder.padding;
        this.mTitle = builder.mTitle;
        this.titleBackgroundColorStr = builder.titleBackgroundColorStr;
        this.confirmTextColorStr = builder.confirmTextColorStr;
        this.cancelTextColorStr = builder.cancelTextColorStr;

        this.defaultDistrict = builder.defaultDistrict;
        this.defaultCityName = builder.defaultCityName;
        this.defaultProvinceName = builder.defaultProvinceName;
        this.showBankChoices = builder.showBankChoices;
        this.showProvinceAndCity = builder.showProvinceAndCity;
        this.backgroundPop = builder.backgroundPop;
        this.titleTextColorStr = builder.titleTextColorStr;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        popview = layoutInflater.inflate(R.layout.pop_citypicker, null);

        mViewProvince = (WheelView) popview.findViewById(R.id.id_province);
        mViewCity = (WheelView) popview.findViewById(R.id.id_city);
        mViewDistrict = (WheelView) popview.findViewById(R.id.id_district);
        mRelativeTitleBg = (RelativeLayout) popview.findViewById(R.id.rl_title);
        mTvOK = (TextView) popview.findViewById(R.id.tv_confirm);
        mTvTitle = (TextView) popview.findViewById(R.id.tv_title);
        mTvCancel = (TextView) popview.findViewById(R.id.tv_cancel);


        popwindow = new PopupWindow(popview, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        popwindow.setBackgroundDrawable(new ColorDrawable(backgroundPop));
        popwindow.setAnimationStyle(R.style.AnimBottom);
        popwindow.setTouchable(true);
        popwindow.setOutsideTouchable(false);
        popwindow.setFocusable(true);


        /**
         * 设置标题背景颜色
         */
        if (!TextUtils.isEmpty(this.titleBackgroundColorStr)) {
            mRelativeTitleBg.setBackgroundColor(Color.parseColor(this.titleBackgroundColorStr));
        }

        /**
         * 设置标题
         */
        if (!TextUtils.isEmpty(this.mTitle)) {
            mTvTitle.setText(this.mTitle);
        }


        //设置确认按钮文字颜色
        if (!TextUtils.isEmpty(this.titleTextColorStr)) {
            mTvTitle.setTextColor(Color.parseColor(this.titleTextColorStr));
        }


        //设置确认按钮文字颜色
        if (!TextUtils.isEmpty(this.confirmTextColorStr)) {
            mTvOK.setTextColor(Color.parseColor(this.confirmTextColorStr));
        }

        //设置取消按钮文字颜色
        if (!TextUtils.isEmpty(this.cancelTextColorStr)) {
            mTvCancel.setTextColor(Color.parseColor(this.cancelTextColorStr));
        }


        //只显示省市两级联动
        if (this.showProvinceAndCity) {
            mViewDistrict.setVisibility(View.GONE);
        } else {
            mViewDistrict.setVisibility(View.VISIBLE);
        }

        //初始化城市数据
        initProvinceDatas(context);

        // 添加change事件
        mViewProvince.addChangingListener(this);
        // 添加change事件
        mViewCity.addChangingListener(this);
        // 添加change事件
        mViewDistrict.addChangingListener(this);
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
                mCurrentProviceName = provinceList.get(mViewProvince.getCurrentItem()).getName();
                mCurrentCityName = cityList.get(mViewCity.getCurrentItem()).getName();
                mCurrentDistrictName = districtList.get(mViewDistrict.getCurrentItem()).getName();
                String proinceCode = provinceList.get(mViewProvince.getCurrentItem()).getCode() + "";
                String cityCode = cityList.get(mViewCity.getCurrentItem()).getCode() + "";
                String districtCode = districtList.get(mViewDistrict.getCurrentItem()).getCode() + "";
                if (showProvinceAndCity) {
                    listener.onSelected(mCurrentProviceName, mCurrentCityName, proinceCode, cityCode);
                } else {
                    listener.onSelected(mCurrentProviceName, mCurrentCityName, mCurrentDistrictName, proinceCode, cityCode, districtCode);
                }
                hide();
            }
        });

    }

    public static class Builder {
        /**
         * Default text color
         */
        public static final int DEFAULT_TEXT_COLOR = 0xFF585858;

        /**
         * Default text size
         */
        public static final int DEFAULT_TEXT_SIZE = 18;

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
        private boolean isProvinceCyclic = true;

        /**
         * 市滚轮是否循环滚动
         */
        private boolean isCityCyclic = true;

        /**
         * 区滚轮是否循环滚动
         */
        private boolean isDistrictCyclic = true;

        private Context mContext;

        /**
         * item间距
         */
        private int padding = 5;


        /**
         * Color.BLACK
         */
        private String cancelTextColorStr = "#000000";


        /**
         * Color.BLUE
         */
        private String confirmTextColorStr = "#0000FF";

        /**
         * 标题背景颜色
         */
        private String titleBackgroundColorStr = "#E9E9E9";

        /**
         * 标题颜色
         */
        private String titleTextColorStr = "#E9E9E9";


        /**
         * 第一次默认的显示省份，一般配合定位，使用
         */
        private String defaultProvinceName = "上海市";

        /**
         * 第一次默认得显示城市，一般配合定位，使用
         */
        private String defaultCityName = "上海市";

        /**
         * 第一次默认得显示，一般配合定位，使用
         */
        private String defaultDistrict = "徐汇区";

        /**
         * 标题
         */
        private String mTitle = "选择地区";

        /**
         * 两级联动
         */
        private boolean showProvinceAndCity = false;
        /**
         * 是否是选择银行
         */
        private boolean showBankChoices = false;

        /**
         * 设置popwindow的背景
         */
        private int backgroundPop = 0xa0000000;

        public Builder(Context context) {
            this.mContext = context;
        }

        /**
         * 设置popwindow的背景
         *
         * @param backgroundPopColor
         * @return
         */
        public Builder backgroundPop(int backgroundPopColor) {
            this.backgroundPop = backgroundPopColor;
            return this;
        }

        /**
         * 设置标题背景颜色
         *
         * @param colorBg
         * @return
         */
        public Builder titleBackgroundColor(String colorBg) {
            this.titleBackgroundColorStr = colorBg;
            return this;
        }

        /**
         * 设置标题背景颜色
         *
         * @param titleTextColorStr
         * @return
         */
        public Builder titleTextColor(String titleTextColorStr) {
            this.titleTextColorStr = titleTextColorStr;
            return this;
        }


        /**
         * 设置标题
         *
         * @param mtitle
         * @return
         */
        public Builder title(String mtitle) {
            this.mTitle = mtitle;
            return this;
        }

        /**
         * 是否只显示省市两级联动
         *
         * @param flag
         * @return
         */
        public Builder onlyShowProvinceAndCity(boolean flag) {
            this.showProvinceAndCity = flag;
            return this;
        }

        /**
         * 是否是选择银行
         */

        public Builder showBankChoices(boolean flag) {
            this.showBankChoices = flag;
            return this;
        }

        /**
         * 第一次默认的显示省份，一般配合定位，使用
         *
         * @param defaultProvinceName
         * @return
         */
        public Builder province(String defaultProvinceName) {
            this.defaultProvinceName = defaultProvinceName;
            return this;
        }

        /**
         * 第一次默认得显示城市，一般配合定位，使用
         *
         * @param defaultCityName
         * @return
         */
        public Builder city(String defaultCityName) {
            this.defaultCityName = defaultCityName;
            return this;
        }

        /**
         * 第一次默认地区显示，一般配合定位，使用
         *
         * @param defaultDistrict
         * @return
         */
        public Builder district(String defaultDistrict) {
            this.defaultDistrict = defaultDistrict;
            return this;
        }

        //        /**
        //         * 确认按钮文字颜色
        //         * @param color
        //         * @return
        //         */
        //        public Builder confirTextColor(int color) {
        //            this.confirmTextColor = color;
        //            return this;
        //        }

        /**
         * 确认按钮文字颜色
         *
         * @param color
         * @return
         */
        public Builder confirTextColor(String color) {
            this.confirmTextColorStr = color;
            return this;
        }

        //        /**
        //         * 取消按钮文字颜色
        //         * @param color
        //         * @return
        //         */
        //        public Builder cancelTextColor(int color) {
        //            this.cancelTextColor = color;
        //            return this;
        //        }

        /**
         * 取消按钮文字颜色
         *
         * @param color
         * @return
         */
        public Builder cancelTextColor(String color) {
            this.cancelTextColorStr = color;
            return this;
        }

        /**
         * item文字颜色
         *
         * @param textColor
         * @return
         */
        public Builder textColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        /**
         * item文字大小
         *
         * @param textSize
         * @return
         */
        public Builder textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        /**
         * 滚轮显示的item个数
         *
         * @param visibleItems
         * @return
         */
        public Builder visibleItemsCount(int visibleItems) {
            this.visibleItems = visibleItems;
            return this;
        }

        /**
         * 省滚轮是否循环滚动
         *
         * @param isProvinceCyclic
         * @return
         */
        public Builder provinceCyclic(boolean isProvinceCyclic) {
            this.isProvinceCyclic = isProvinceCyclic;
            return this;
        }

        /**
         * 市滚轮是否循环滚动
         *
         * @param isCityCyclic
         * @return
         */
        public Builder cityCyclic(boolean isCityCyclic) {
            this.isCityCyclic = isCityCyclic;
            return this;
        }

        /**
         * 区滚轮是否循环滚动
         *
         * @param isDistrictCyclic
         * @return
         */
        public Builder districtCyclic(boolean isDistrictCyclic) {
            this.isDistrictCyclic = isDistrictCyclic;
            return this;
        }

        /**
         * item间距
         *
         * @param itemPadding
         * @return
         */
        public Builder itemPadding(int itemPadding) {
            this.padding = itemPadding;
            return this;
        }

        public CityPicker build() {
            CityPicker cityPicker = new CityPicker(this);
            return cityPicker;
        }

    }

    private void setUpData() {
        int provinceDefault = -1;
        //遍历判断位置
        if (!TextUtils.isEmpty(defaultProvinceName) && provinceList.size() > 0) {
            for (int i = 0; i < provinceList.size(); i++) {
                if (provinceList.get(i).getName().contains(defaultProvinceName)) {
                    provinceDefault = i;
                    break;
                }
            }
        }
        if (-1 != provinceDefault) {

            arrayWheelAdapter = new ArrayWheelAdapter(context, provinceList, provinceDefault);
        } else {
            arrayWheelAdapter = new ArrayWheelAdapter(context, provinceList, 0);

        }
        mViewProvince.setViewAdapter(arrayWheelAdapter);
        //获取所设置的省的位置，直接定位到该位置
        if (-1 != provinceDefault) {
            mViewProvince.setCurrentItem(provinceDefault);
        }
        // 设置可见条目数量
        mViewProvince.setVisibleItems(visibleItems);
        mViewCity.setVisibleItems(visibleItems);
        mViewDistrict.setVisibleItems(visibleItems);
        mViewProvince.setCyclic(isProvinceCyclic);
        mViewCity.setCyclic(isCityCyclic);
        mViewDistrict.setCyclic(isDistrictCyclic);
        arrayWheelAdapter.setPadding(padding);
        arrayWheelAdapter.setTextColor(textColor);
        arrayWheelAdapter.setTextSize(textSize);

        updateCities();
        updateAreas();
    }

    /**
     * 解析省市区的XML数据
     */

    protected void initProvinceDatas(Context context) {
        //可在此预设值默认位置

//        AssetManager asset = context.getAssets();
        try {
//            provinceList = new Sqlrefer(context).province();
            provinceList = getDatesList(1, 0+"");
//            InputStream input = asset.open("province_data.xml");
//            // 创建一个解析xml的工厂对象
//            SAXParserFactory spf = SAXParserFactory.newInstance();
//            // 解析xml
//            SAXParser parser = spf.newSAXParser();
//            XmlParserHandler handler = new XmlParserHandler();
//            parser.parse(input, handler);
//            input.close();
//            // 获取解析出来的数据
//            provinceList = handler.getDataList();
//
            //*/ 初始化默认选中的省、市、区
//            if (provinceList != null && !provinceList.isEmpty()) {
//                mCurrentProviceName = provinceList.get(0).getName();
//                cityList = new Sqlrefer(context).city(provinceList.get(0).getId() + "");
//                if (cityList != null && !cityList.isEmpty()) {
//                    mCurrentCityName = cityList.get(0).getName();
//                    districtList = new Sqlrefer(context).county(cityList.get(0).getId() + "");
//                    mCurrentDistrictName = districtList.get(0).getName();
////                    mCurrentZipCode = districtList.get(0).getZipcode();
//                }
//            }
            //*/
//            mProvinceDatas = new String[provinceList.size()];
//            for (int i = 0; i < provinceList.size(); i++) {
//                // 遍历所有省的数据
//                mProvinceDatas[i] = provinceList.get(i).getName();
//                List<Citys> cityList = provinceList.get(i).getCityList();
//                String[] cityNames = new String[cityList.size()];
//                for (int j = 0; j < cityList.size(); j++) {
//                    // 遍历省下面的所有市的数据
//                    cityNames[j] = cityList.get(j).getName();
//                    List<Districts> districtList = cityList.get(j).getDistrictList();
//                    String[] distrinctNameArray = new String[districtList.size()];
//                    Districts[] distrinctArray = new Districts[districtList.size()];
//                    for (int k = 0; k < districtList.size(); k++) {
//                        // 遍历市下面所有区/县的数据
//                        Districts districtModel = new Districts(districtList.get(k).getName(),
//                                districtList.get(k).getZipcode());
//                        // 区/县对于的邮编，保存到mZipcodeDatasMap
////                        JLogUtils.D("zipcode: " + mProvinceDatas[i] + cityNames[j] +
////                                districtList.get(k).getName() + "  " + districtList.get(k).getZipcode());
//                        mZipcodeDatasMap.put(mProvinceDatas[i] + cityNames[j] +
//                                        districtList.get(k).getName(),
//                                districtList.get(k).getZipcode());
//                        distrinctArray[k] = districtModel;
//                        distrinctNameArray[k] = districtModel.getName();
//                    }
//                    // 市-区/县的数据，保存到mDistrictDatasMap
//                    mDistrictDatasMap.put(cityNames[j], distrinctNameArray);
//                }
//                // 省-市的数据，保存到mCitisDatasMap
//                mCitisDatasMap.put(provinceList.get(i).getName(), cityNames);
//            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 根据当前的市，更新区WheelView的信息
     */
    private void updateAreas() {
        Log.e("cotys---->", cityList.size() + "");
        int pCurrent = mViewCity.getCurrentItem();
        Log.e("cotys---->", pCurrent + "-----pCurrent");
//        mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName)[pCurrent];
//        mCurrentCityName = cityList.get(pCurrent).getName();
//        String[] areas = mDistrictDatasMap.get(mCurrentCityName);
//
//        if (areas == null) {
//            areas = new String[]{""};
//        }
//        districtList = new Sqlrefer(context).county(cityList.get(pCurrent).getId() + "");
        districtList = getDatesList(3, cityList.get(pCurrent).getCode());
        int districtDefault = -1;
        if (!TextUtils.isEmpty(defaultDistrict) && districtList.size() > 0) {
            for (int i = 0; i < districtList.size(); i++) {
                if (districtList.get(i).getName().contains(defaultDistrict)) {
                    districtDefault = i;
                    break;
                }
            }
        }
        if (-1 != districtDefault) {
            districtWheel = new ArrayWheelAdapter(context, districtList, districtDefault);
        } else {
            districtWheel = new ArrayWheelAdapter(context, districtList, 0);
        }
        // 设置可见条目数量
        districtWheel.setTextColor(textColor);
        districtWheel.setTextSize(textSize);
        mViewDistrict.setViewAdapter(districtWheel);
        if (-1 != districtDefault) {
            mViewDistrict.setCurrentItem(districtDefault);
            //获取默认设置的区
            mCurrentDistrictName = defaultDistrict;
        } else {
            mViewDistrict.setCurrentItem(0);
            // 获取第一个区名称
            mCurrentDistrictName = districtList.get(0).getName();

        }
        districtWheel.setPadding(padding);
//        JLogUtils.D("zipcode key: " + mCurrentProviceName + mCurrentCityName + mCurrentDistrictName);
        //获取第一个区名称
//        mCurrentZipCode = mZipcodeDatasMap.get(mCurrentProviceName + mCurrentCityName + mCurrentDistrictName);
    }

    /**
     * 根据当前的省，更新市WheelView的信息
     */
    private void updateCities() {
        int pCurrent = mViewProvince.getCurrentItem();
//        provinceList = new Sqlrefer(context).province();
//        mCurrentProviceName = mProvinceDatas[pCurrent];
        mCurrentProviceName = provinceList.get(pCurrent).getName();
//        cityList = new Sqlrefer(context).city(provinceList.get(pCurrent).getId() + "");
        cityList = getDatesList(2, provinceList.get(pCurrent).getCode());
//        String[] cities = mCitisDatasMap.get(mCurrentProviceName);
//        if (cities == null) {
//            cities = new String[]{""};
//        }

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

        // 设置可见条目数量
        cityWheel.setTextColor(textColor);
        cityWheel.setTextSize(textSize);
        mViewCity.setViewAdapter(cityWheel);
        if (-1 != cityDefault) {
            mViewCity.setCurrentItem(cityDefault);
        } else {
            mViewCity.setCurrentItem(0);
            defaultCityName = cityList.get(0).getName();
        }
//
        cityWheel.setPadding(padding);
        updateAreas();
    }

    @Override
    public void setType(int type) {
    }

    @Override
    public void show() {
        if (!isShow()) {
            setUpData();
            popwindow.showAtLocation(popview, Gravity.BOTTOM, 0, 0);
        }
    }

    @Override
    public void hide() {
        if (isShow()) {
            popwindow.dismiss();
        }
    }

    @Override
    public boolean isShow() {
        return popwindow.isShowing();
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        // TODO Auto-generated method stub
        if (wheel == mViewProvince) {

            updateCities();
        } else if (wheel == mViewCity) {
            updateAreas();
        } else if (wheel == mViewDistrict) {

//            mCurrentDistrictName = mDistrictDatasMap.get(mCurrentCityName)[newValue];
//            JLogUtils.D("zipcode key: " + mCurrentProviceName + mCurrentCityName + mCurrentDistrictName);
//            mCurrentZipCode = mZipcodeDatasMap.get(mCurrentProviceName + mCurrentCityName + mCurrentDistrictName);
        }
    }

    /**
     * @param i    showBankChoices=false 1省，2市，3区，showBankChoices=true 1，银行卡，2，银行卡类型，3待定
     * @param code
     * @return
     */
    private List<BaseDates> getDatesList(int i, String code) {
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
}
