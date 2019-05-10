package com.zkp.gank.module.main.fragment.welfare;

import android.content.Intent;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.coder.zzq.smartshow.dialog.EnsureDialog;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zkp.gank.R;
import com.zkp.gank.base.fragment.BaseFragment;
import com.zkp.gank.bean.WelFareBean;
import com.zkp.gank.http.AppConfig;
import com.zkp.gank.module.main.activity.ComponentActivity;
import com.zkp.gank.module.main.fragment.welfare.adapter.WelFareAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.welfare
 * @time: 2019/5/8 11:30
 * @description:
 */
public class WelFareFragment extends BaseFragment<WelFarePresenter> implements WelFareFragmentContract.View {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<WelFareBean.ResultsBean> mWelFareList;
    private WelFareAdapter mAdapter;

    private EnsureDialog mEnsureDialog;

    public static WelFareFragment newInstance() {
        return new WelFareFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welfare;
    }

    @Override
    protected void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mWelFareList = new ArrayList<>();
        mAdapter = new WelFareAdapter(R.layout.item_welfare_list, mWelFareList);

        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (ComponentActivity.getmToolbar().getVisibility() == View.VISIBLE) {
                ComponentActivity.getmToolbar().setVisibility(View.GONE);
            } else {
                ComponentActivity.getmToolbar().setVisibility(View.VISIBLE);
            }
        });

        mAdapter.setOnItemChildLongClickListener((adapter, view, position) -> {
            //ImageView点击事件处理
            AndPermission.with(getActivity())
                    .runtime()
                    .permission(Permission.Group.STORAGE)
                    .onGranted(permissions -> {
                        //保存图片到手机
                        showEnsureDialog(view);

                    })
                    .onDenied(permissions -> {
                        AndPermission.with(getActivity())
                                .runtime()
                                .permission(Permission.Group.STORAGE)
                                .start();
                    })
                    .start();
            return true;
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.setAdapter(mAdapter);
    }

    private void showEnsureDialog(View view) {
        mEnsureDialog = new EnsureDialog()
                .message("确定要保存这张图片到手机吗？")
                .confirmBtn("确定", (dialog, which, data) -> {
                    dialog.dismiss();
                    ImageView imageView = (ImageView) view;
                    imageView.setDrawingCacheEnabled(true);
                    mPresenter.saveBitmap(imageView.getDrawingCache(), AppConfig.APP_PATH, getActivity());
                    imageView.setDrawingCacheEnabled(false);
                });
        mEnsureDialog.showInActivity(getActivity());
    }

    @Override
    protected void initEventAndData() {
        initRefreshLayout();

        mPresenter = new WelFarePresenter();
        mPresenter.attachView(this);

        mPresenter.refresh();
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPresenter.refresh();
            refreshLayout.finishRefresh();
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.loadMore();
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    public void getWelFaresSuccess(WelFareBean data, boolean isFresh) {
        if (mAdapter == null) {
            return;
        }
        if (isFresh) {
            mAdapter.replaceData(data.getResults());
        } else {
            mAdapter.addData(data.getResults());
        }
    }

    @Override
    public void getWelFaresError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void saveBitmapSuccess(String path) {
        //保存图片成功，询问用户是否打开
        mEnsureDialog = new EnsureDialog()
                .message("现在查看打开这张图片吗？")
                .confirmBtn("确定", (dialog, which, data) -> {
                    dialog.dismiss();

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setDataAndType(FileProvider.getUriForFile(Objects.requireNonNull(getActivity()), "com.zkp.gank.provider", new File(path)), "image/*");
                    startActivity(intent);

                });
        mEnsureDialog.showInActivity(getActivity());
    }

    @Override
    public void saveBitmapError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
