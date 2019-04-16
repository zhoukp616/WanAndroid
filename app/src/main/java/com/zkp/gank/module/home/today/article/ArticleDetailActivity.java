package com.zkp.gank.module.home.today.article;

import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.NestedScrollAgentWebView;
import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.TodayGankBaseBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.today.article
 * @time: 2019/4/11 13:45
 * @description:
 */
public class ArticleDetailActivity extends BaseActivity<ArticleDetailPresenter> implements ArticleDetailContract.View {

    @BindView(R.id.ivBack)
    ImageView mIvBack;

    @BindView(R.id.ivCollection)
    ImageView mIvCollection;

    @BindView(R.id.tvTitle)
    TextView mTvTitle;

    @BindView(R.id.content)
    LinearLayout mContent;

    private AgentWeb mAgentWeb;

    private TodayGankBaseBean mTodayGankBaseBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initView() {
        mTodayGankBaseBean = (TodayGankBaseBean) getIntent().getSerializableExtra("data");
        if (mTodayGankBaseBean != null) {
            mTvTitle.setText(mTodayGankBaseBean.getDesc());

            WebChromeClient webChromeClient = new WebChromeClient() {
                @Override
                public void onReceivedTitle(WebView view, String title) {
                    super.onReceivedTitle(view, title);
                    mTvTitle.setText(Html.fromHtml(title));
                }
            };

            mAgentWeb = AgentWeb.with(this)
                    .setAgentWebParent(mContent, new LinearLayout.LayoutParams(-1, -1))
                    .useDefaultIndicator()
                    .setWebView(new NestedScrollAgentWebView(this))
                    .setWebChromeClient(webChromeClient)
                    .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                    .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
                    .createAgentWeb()
                    .ready()
                    .go(mTodayGankBaseBean.getUrl());
        }
    }

    @Override
    protected void initEventAndData() {


    }

    @OnClick({R.id.ivBack, R.id.ivCollection})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ivCollection:
                Log.d("qwe", "收藏");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }
}
