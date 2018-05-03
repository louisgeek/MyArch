package com.louisgeek.myarch.http.callback;


import com.google.gson.internal.$Gson$Types;
import com.louisgeek.myarch.tool.GenericTool;
import com.louisgeek.myarch.json.JsonParserFactory;
import com.louisgeek.myarch.tool.ThreadTool;


import java.io.IOException;
import java.lang.reflect.Type;


import okhttp3.Call;
import okhttp3.Response;

public abstract class GsonCallback<T> extends BaseCallback<T> {
    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        if (response.isSuccessful()) {
            String json = response.toString();
            //支持解析一个类的类型，不支持List<T> 的类型
            Type type = GenericTool.getFirstGenericType(getClass());
            //支持解析 List<T> 的类型
            Type typeOfT = $Gson$Types.canonicalize(type);
            final T t = JsonParserFactory.getGson().fromJson(json, typeOfT);
            //
            this.onSuccess(t, response.code());
            //主线程
            ThreadTool.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    onSuccessUi(t, response.code());
                }
            });
        } else {
            this.onError(response.message(), response.code());
        }
    }

}
