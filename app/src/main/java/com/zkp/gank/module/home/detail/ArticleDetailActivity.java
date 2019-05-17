package com.zkp.gank.module.home.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.NestedScrollAgentWebView;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.CollectListBean;
import com.zkp.gank.http.AppConfig;

import java.lang.reflect.Method;
import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.home.detail
 * @time: 2019/4/28 15:48
 * @description:
 */
public class ArticleDetailActivity extends BaseActivity<ArticleDetailPresenter> implements ArticleDetailContract.View {

    @BindView(R.id.content_layout)
    CoordinatorLayout mContent;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mTitle;

    private AgentWeb mAgentWeb;
    private MenuItem mCollectItem;

    /**
     * 文章ID
     */
    private int articleId;
    /**
     * 文章Url
     */
    private String articleLink;
    /**
     * 标题
     */
    private String title;
    /**
     * 是否收藏
     */
    private boolean isCollected;
    /**
     * 是否显示收藏icon
     */
    private boolean isShowCollectIcon;
    private int articleItemPosition;

    /**
     * 是否为测试博客
     */
    private boolean isCnBlogs = false;

    private int page = 0;

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

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressedSupport() {
        if (!mAgentWeb.back()) {
            super.onBackPressedSupport();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initView() {
        GankApplication.getApplication().addActivity(this);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            if (!TextUtils.isEmpty(title)) {
                mTitle.setText(Html.fromHtml(title));
            }
            mTitle.setSelected(true);
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {

        mPresenter = new ArticleDetailPresenter();
        mPresenter.attachView(this);

        getBundleData();

        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mTitle.setText(Html.fromHtml(title));
                if (isCnBlogs) {
                    mCollectItem.setIcon(R.drawable.ic_like_not_white);
                    page = 0;
                    mPresenter.getCollectList(page);
                }
            }
        };

        WebViewClient webViewClient = new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                articleLink = url;
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                articleLink = request.getUrl().toString();
                return super.shouldOverrideUrlLoading(view, request);
            }
        };

        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        NestedScrollAgentWebView mNestedWebView = new NestedScrollAgentWebView(this);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mContent, layoutParams)
                .useDefaultIndicator()
                .setWebView(mNestedWebView)
                .setWebChromeClient(webChromeClient)
                .setWebViewClient(webViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
                .createAgentWeb()
                .ready()
                .go(articleLink);
    }

    private void getBundleData() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        title = bundle.getString("title");
        articleLink = bundle.getString("articleLink");
        articleId = bundle.getInt("articleId");
        isCnBlogs = bundle.getBoolean("isCnBlogs");
        isCollected = bundle.getBoolean("isCollected");
        isShowCollectIcon = bundle.getBoolean("isShowCollectIcon");
        articleItemPosition = bundle.getInt("articleItemPosition", -1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_acticle_detail, menu);
        mCollectItem = menu.findItem(R.id.item_collect);
        mCollectItem.setVisible(isShowCollectIcon);
        mCollectItem.setIcon(isCollected ? R.drawable.ic_like_white : R.drawable.ic_like_not_white);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_share:
                SmartToast.show("分享");
                break;
            case R.id.item_collect:
                if (isCollected) {
                    mPresenter.unCollectArticle(articleId);
                } else {
                    if (isCnBlogs) {
                        mPresenter.collectOutArticle(mTitle.getText().toString(), AppConfig.CNBLOGS_AUTHOR, articleLink);
                        isCnBlogs = false;
                    } else {
                        mPresenter.collectArticle(articleId);
                    }
                }
                isCollected = !isCollected;
                break;
            case R.id.item_system_browser:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(articleLink)));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 让菜单同时显示图标和文字
     *
     * @param featureId Feature id
     * @param menu      Menu
     * @return menu if opened
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if ("MenuBuilder".equalsIgnoreCase(menu.getClass().getSimpleName())) {
                try {
                    @SuppressLint("PrivateApi")
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void collectArticleSuccess() {
        mCollectItem.setIcon(isCollected ? R.drawable.ic_like_white : R.drawable.ic_like_not_white);
    }

    @Override
    public void collectArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void getCollectListSuccess(CollectListBean data) {

        for (CollectListBean.DataBean.DatasBean datasBean : data.getData().getDatas()) {
            if (datasBean.getAuthor().equals(AppConfig.CNBLOGS_AUTHOR) &&
                    datasBean.getTitle().equals(mTitle.getText().toString()) &&
                    datasBean.getLink().equals(articleLink)) {
                //这篇文章已在收藏列表中
                isCollected = true;
                mCollectItem.setIcon(R.drawable.ic_like_white);
                return;
            }
        }

        if (!data.getData().isOver()) {
            //收藏文章数>1页
            page++;
            mPresenter.getCollectList(page);
        }
    }

    @Override
    public void getCollectListError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void collectOutArticleSuccess(CollectListBean data) {
        mCollectItem.setIcon(isCollected ? R.drawable.ic_like_white : R.drawable.ic_like_not_white);
    }

    @Override
    public void collectOutArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    public void unCollectArticleSuccess() {
        mCollectItem.setIcon(isCollected ? R.drawable.ic_like_white : R.drawable.ic_like_not_white);
    }

    @Override
    public void unCollectArticleError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
