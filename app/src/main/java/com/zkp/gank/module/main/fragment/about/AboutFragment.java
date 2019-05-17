package com.zkp.gank.module.main.fragment.about;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.coder.zzq.smartshow.dialog.NotificationDialog;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.vector.update_app.UpdateAppManager;
import com.zkp.gank.BuildConfig;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.http.UpdateAppHttpUtil;
import com.zkp.gank.module.home.detail.ArticleDetailActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment
 * @time: 2019/4/30 13:41
 * @description:
 */
public class AboutFragment extends BaseFragment {

    @BindView(R.id.about_version)
    TextView mAboutVersion;

    private NotificationDialog mNotificationDialog;

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initView() {

        GankApplication.getApplication().addFragment(this);

        try {
            String versionStr = getString(R.string.app_name)
                    + " V" + GankApplication.getContext().getPackageManager()
                    .getPackageInfo(GankApplication.getContext().getPackageName(), 0).versionName;
            mAboutVersion.setText(versionStr);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.about_update, R.id.about_website, R.id.about_source_code,
            R.id.about_feedback, R.id.about_copyright, R.id.about_lottie})
    void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.about_update:
                //检查更新
                new UpdateAppManager
                        .Builder()
                        //当前Activity
                        .setActivity(_mActivity)
                        //更新地址
                        .setUpdateUrl(AppConfig.URL_UPDATE)
                        //实现httpManager接口的对象
                        .setHttpManager(new UpdateAppHttpUtil())
                        .setTopPic(R.drawable.update_dialog_bg)
                        .setThemeColor(R.color.colorPrimary)
                        .build()
                        .update();
                break;
            case R.id.about_website:
                //关于网站
                intent = new Intent(getActivity(), ArticleDetailActivity.class);
                intent.putExtra("articleLink", AppConfig.ABOUT_WEBSITE);
                intent.putExtra("articleId", -1);
                intent.putExtra("isCollected", false);
                intent.putExtra("isShowCollectIcon", false);
                intent.putExtra("articleItemPosition", -1);
                Objects.requireNonNull(getActivity()).startActivity(intent);
                break;
            case R.id.about_source_code:
                //源码下载
                intent = new Intent(getActivity(), ArticleDetailActivity.class);
                intent.putExtra("articleLink", AppConfig.ABOUT_SOURCE_CODE);
                intent.putExtra("articleId", -1);
                intent.putExtra("isCollected", false);
                intent.putExtra("isShowCollectIcon", false);
                intent.putExtra("articleItemPosition", -1);
                Objects.requireNonNull(getActivity()).startActivity(intent);
                break;
            case R.id.about_feedback:
                //意见反馈
                intent = new Intent(getActivity(), ArticleDetailActivity.class);
                intent.putExtra("articleLink", AppConfig.ABOUT_FEEDBACK);
                intent.putExtra("articleId", -1);
                intent.putExtra("isCollected", false);
                intent.putExtra("isShowCollectIcon", false);
                intent.putExtra("articleItemPosition", -1);
                Objects.requireNonNull(getActivity()).startActivity(intent);
                break;
            case R.id.about_copyright:
                //版权声明
                onShowNotificationDialog();
                break;
            case R.id.about_lottie:
                Log.d("qwe", "lottie动画");
                intent = new Intent(getActivity(), LottieActivity.class);
                Objects.requireNonNull(getActivity()).startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void onShowNotificationDialog() {
        if (mNotificationDialog == null) {
            mNotificationDialog = new NotificationDialog()
                    .title("版权声明")
                    .message("本APP完全开源，仅供学习、交流使用，严禁用于商业用途，违者后果自负。");
        }
        mNotificationDialog.showInActivity(getActivity());
    }
}
