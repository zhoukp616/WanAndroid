package com.zkp.androidwan.http;

import android.util.Log;

import com.zkp.androidwan.app.App;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zkp.androidwan.http.AppConfig.TIMEOUT_CONNECTION;
import static com.zkp.androidwan.http.AppConfig.TIMEOUT_READ;


/**
 * @author: zkp
 * @project: Demos
 * @package: com.zkp.demos.http
 * @time: 2019/4/8 14:10
 * @description: Http请求工具类
 */
public class HttpUtil {

    private static OkHttpClient mOkHttpClient;

    public static <T> T createApi(String baseUrl, Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public static OkHttpClient getInstance() {

        mOkHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .build();

        return mOkHttpClient;

    }

    public static <T> void request(Observable<T> observable, final IResponseListener<T> listener) {
        if (!NetUtil.isConnected(App.getContext())) {
            if (listener != null) {
                listener.onFail("网络无连接");
            }
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {

                               @Override
                               public void onSubscribe(Disposable disposable) {

                               }

                               @Override
                               public void onNext(T data) {
                                   if (listener != null) {
                                       listener.onSuccess(data);
                                   }
                               }

                               @Override
                               public void onError(Throwable e) {
                                   e.printStackTrace();
                                   Log.d("qwe", e.getMessage());
                                   if (listener != null) {
                                       listener.onFail("连接失败");
                                   }
                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }

    public interface IResponseListener<T> {
        /**
         * 请求成功回调
         *
         * @param data JavaBean
         */
        void onSuccess(T data);

        /**
         * 请求失败回调
         *
         * @param errMsg String 错误信息
         */
        void onFail(String errMsg);
    }

}
