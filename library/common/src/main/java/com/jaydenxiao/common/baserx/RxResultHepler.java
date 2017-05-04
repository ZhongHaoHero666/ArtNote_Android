package com.jaydenxiao.common.baserx;

/**
 * Created by RXPC-D252 on 2017/2/20.
 */

import com.jaydenxiao.common.basebean.BaseRespose;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Rx处理服务器返回数据
 * Created by YoKey.
 */

public class RxResultHepler {

    public static <T> Observable.Transformer<BaseRespose<T>, T> handleResult() {
        return new Observable.Transformer<BaseRespose<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseRespose<T>> tObservable) {
                return tObservable.flatMap(
                        new Func1<BaseRespose<T>, Observable<T>>() {
                            @Override
                            public Observable<T> call(BaseRespose<T> result) {
                                if (result.isSuccess()) {
                                    return createData(result.result);
                                } else {
                                    return Observable.error(new ServerException(result.getMsg()));
                                }
                            }
                        }

                );
            }
        };
    }

    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}

