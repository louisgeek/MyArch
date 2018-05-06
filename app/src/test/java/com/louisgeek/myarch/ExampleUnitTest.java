package com.louisgeek.myarch;

import com.louisgeek.myarch.json.BaseJsonParserFactory;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.model.bean.NewsBean;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void tesJson() {

        String json_nul = null;
        //空字符串
        String json_empty = "";
        //空字符串 引号
        String json_empty_str = "\"\"";
        //null字符串
        String json_null = "null";
        //null字符串 引号
        String json_null_str = "\"null\"";
        //空对象
        String json_null_object = "{}";
        //空对象 引号
        String json_null_object_str = "\"{}\"";
        //空数组
        String json_null_array = "[]";
        //空数组 引号
        String json_null_array_str = "\"[]\"";

        String json_comm_empty = "{\"data\": \"\", \"code\": 1, \"msg\": \"请求失败\"}";
        String json_comm_null = "{\"data\": null, \"code\": 1, \"msg\": \"请求失败\"}";
        String json_comm_object = "{\"data\": {\"newsID\":0,\"title\":\"title1\",\"content\":\"content1\"}, \"code\": 1, \"msg\": \"请求失败\"}";
//        String mJsonxxxx = "{\"data\": \"{\\\"newsID\\\":0,\\\"title\\\":\\\"title1\\\"}\", \"code\": 1, \"msg\": \"请求失败\"}";
//        String mJsonyyy = "{\"data\": \"[{\\\"newsID\\\":0,\\\"title\\\":\\\"title1\\\"}]\", \"code\": 1, \"msg\": \"请求失败\"}";
        String json_comm_array = "{\"data\": [{\"newsID\":0,\"title\":\"title0\",\"content\":\"content0\"},{\"newsID\":1,\"title\":\"title1\",\"content\":\"content1\"}], \"code\": 1, \"msg\": \"请求失败\"}";
        //
        String json_comm_object_str = "\"{\\\"data\\\": {\\\"newsID\\\":0,\\\"title\\\":\\\"title1\\\"}, \\\"code\\\": 1, \\\"msg\\\": \\\"请求失败\\\"}\"";

    /*    BaseJson baseJson_json_nul = new MyGson().fromJson(json_nul, String.class);
        BaseJson baseJson_json_empty = new MyGson().fromJson(json_empty, String.class);
        BaseJson baseJson_json_empty_str = new MyGson().fromJson(json_empty_str, String.class);
        BaseJson baseJson_json_null = new MyGson().fromJson(json_null, String.class);
        BaseJson baseJson_json_null_str = new MyGson().fromJson(json_null_str, String.class);
        BaseJson baseJson_json_null_object = new MyGson().fromJson(json_null_object, String.class);
        BaseJson baseJson_json_null_object_str = new MyGson().fromJson(json_null_object_str, String.class);
        BaseJson baseJson_json_null_array = new MyGson().fromJson(json_null_array, String.class);
        BaseJson baseJson_json_null_array_str = new MyGson().fromJson(json_null_array_str, String.class);
        BaseJson<NewsBean> baseJson_json_comm_empty = new MyGson().fromJson(json_comm_empty, NewsBean.class);
        BaseJson<NewsBean> baseJson_json_comm_null = new MyGson().fromJson(json_comm_null, NewsBean.class);
        BaseJson<NewsBean> baseJson_json_comm_object = new MyGson().fromJson(json_comm_object, NewsBean.class);
        BaseJson<List<NewsBean>> baseJson_json_comm_array = new MyGson().fromJson(json_comm_array, NewsBean.class);
        BaseJson<NewsBean> baseJson_json_comm_object_str = new MyGson().fromJson(json_comm_object_str, NewsBean.class);

*/
        BaseJson baseJson_json_nul = BaseJsonParserFactory.getFastJson().fromJson(json_nul, String.class);
        BaseJson baseJson_json_empty = BaseJsonParserFactory.getFastJson().fromJson(json_empty, String.class);
        BaseJson baseJson_json_empty_str = BaseJsonParserFactory.getFastJson().fromJson(json_empty_str, String.class);
        BaseJson baseJson_json_null = BaseJsonParserFactory.getFastJson().fromJson(json_null, String.class);
        BaseJson baseJson_json_null_str = BaseJsonParserFactory.getFastJson().fromJson(json_null_str, String.class);
        BaseJson baseJson_json_null_object = BaseJsonParserFactory.getFastJson().fromJson(json_null_object, String.class);
        BaseJson baseJson_json_null_object_str = BaseJsonParserFactory.getFastJson().fromJson(json_null_object_str, String.class);
        BaseJson baseJson_json_null_array = BaseJsonParserFactory.getFastJson().fromJson(json_null_array, String.class);
        BaseJson baseJson_json_null_array_str = BaseJsonParserFactory.getFastJson().fromJson(json_null_array_str, String.class);
        BaseJson<NewsBean> baseJson_json_comm_empty = BaseJsonParserFactory.getFastJson().fromJson(json_comm_empty, NewsBean.class);
        BaseJson<NewsBean> baseJson_json_comm_null = BaseJsonParserFactory.getFastJson().fromJson(json_comm_null, NewsBean.class);
        BaseJson<NewsBean> baseJson_json_comm_object = BaseJsonParserFactory.getFastJson().fromJson(json_comm_object, NewsBean.class);
        BaseJson<List<NewsBean>> baseJson_json_comm_array = BaseJsonParserFactory.getFastJson().fromJson(json_comm_array, NewsBean.class);
        BaseJson<NewsBean> baseJson_json_comm_object_str = BaseJsonParserFactory.getFastJson().fromJson(json_comm_object_str, NewsBean.class);

    }
}