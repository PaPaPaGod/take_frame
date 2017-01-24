package com.example.takeretrofit.retrofit.httpsubscriber.httpwithdata;

import android.util.Log;


import com.example.takeretrofit.Config;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by price on 1/13/2017.
 */

public abstract class HttpResultSubscriber<T> extends Subscriber<HttpResult<T>> {

    private String tag = "HttpResultSubscriber";
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e(tag,e.getMessage());
        e.printStackTrace();
        //在这里做全局的错误处理
        if (e instanceof HttpException) {
            // ToastUtils.getInstance().showToast(e.getMessage());
        }
        _onError(e);
    }

    @Override
    public void onNext(HttpResult<T> t) {
        int code = t.getCode();
        Log.e(tag,code+"");
//        code = 0;
        switch (code){
            case Config.SUCCESS_WITH_DATAS:
                onSuccessWithData(t.getData());
                break;
            case Config.SUCCESS_WITH_STATUS:
                onSuccessWithMsg(t);
                break;
            case Config.FAILED_WITH_STATUS:
                _onError(new Throwable("error: "+t.getMsg()));
                break;
            case Config.TOKEN_INVALED:
                _onError(new Throwable("error: "+t.getMsg()));
                break;
        }
    }

    public abstract void onSuccessWithData(T t);

    public abstract void onSuccessWithMsg(HttpResult<T> httpResult);

    public abstract void _onError(Throwable throwable);
}
