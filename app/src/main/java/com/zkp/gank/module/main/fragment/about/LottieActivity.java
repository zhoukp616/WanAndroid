package com.zkp.gank.module.main.fragment.about;

import com.airbnb.lottie.LottieAnimationView;
import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.about
 * @time: 2019/5/17 15:40
 * @description:
 */
public class LottieActivity extends BaseActivity {

    @BindView(R.id.animationView)
    LottieAnimationView mAnimationView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_lottie;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAnimationView.setProgress(0f);
        mAnimationView.playAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAnimationView.cancelAnimation();
    }
}
