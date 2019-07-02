package com.zkp.androidwan.module.main.fragment.welfare;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import com.zkp.androidwan.base.presenter.BasePresenter;
import com.zkp.androidwan.bean.WelFareBean;
import com.zkp.androidwan.http.ApiService;
import com.zkp.androidwan.http.AppConfig;
import com.zkp.androidwan.http.HttpUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.fragment.welfare
 * @time: 2019/5/8 11:28
 * @description:
 */
public class WelFarePresenter extends BasePresenter<WelFareFragmentContract.View> implements WelFareFragmentContract.Presenter {

    private int currentPage = 0;

    @Override
    public void saveBitmap(Bitmap bitmap, String filePath, Context context) {

        if (mView != null) {
            mView.showLoading();

            String fileName = generateFileName();
            File file = new File(filePath, fileName);

            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                mView.saveBitmapError("保存失败");
                mView.hideLoading();
            } catch (IOException e) {
                e.printStackTrace();
                mView.saveBitmapError("保存失败");
                mView.hideLoading();
            }

            //其次把文件插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(context.getContentResolver(),
                        file.getAbsolutePath(), file.getName(), null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                mView.saveBitmapError("保存失败");
                mView.hideLoading();
            }

            //最后通知图库更新
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            context.sendBroadcast(intent);

            mView.saveBitmapSuccess(file.getAbsolutePath());
            mView.hideLoading();

        }
    }

    /**
     * 生成文件名
     *
     * @return
     */
    private String generateFileName() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        //获取当前时间
        Date curDate = new Date(System.currentTimeMillis());
        return "IMG_" + formatter.format(curDate) + ".jpg";
    }

    @Override
    public void getWelFares(int page, boolean isFresh) {
        if (mView != null) {
            mView.showLoading();

            HttpUtil.request(HttpUtil.createApi(AppConfig.BASE_URL_GANK, ApiService.class).getWelFares(page), new HttpUtil.IResponseListener<WelFareBean>() {
                @Override
                public void onSuccess(WelFareBean data) {
                    if (data.isError()) {
                        mView.getWelFaresError("获取福利数据失败");
                    } else {
                        mView.getWelFaresSuccess(data, isFresh);
                    }
                    mView.hideLoading();
                }

                @Override
                public void onFail(String errMsg) {
                    mView.getWelFaresError(errMsg);
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void refresh() {
        currentPage = 0;
        getWelFares(currentPage, true);
    }

    @Override
    public void loadMore() {
        currentPage++;
        getWelFares(currentPage, false);
    }


}
