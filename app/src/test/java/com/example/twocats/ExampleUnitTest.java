package com.example.twocats;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.twocats.bean.Banners;
import com.example.twocats.bean.Content;
import com.example.twocats.bean.DetailImage;
import com.example.twocats.bean.HomeData;
import com.example.twocats.bean.JavaBean;
import com.example.twocats.network.RetrofitClient;
import com.example.twocats.network.service.HomeService;

import java.util.List;

import io.reactivex.rxjava3.functions.Consumer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        RetrofitClient.getInstance().getService(HomeService.class).getContent(1).subscribe(new Consumer<JavaBean<List<Content>>>() {
            @Override
            public void accept(JavaBean<List<Content>> listJavaBean) throws Throwable {
                System.out.println(listJavaBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {

            }
        });

//        OkhttpUit.getInstance().doGet("https://kabuto01.github.io/test/getHome", new Ok() {
//            @Override
//            public void ok(String str) {
//                Gson gson=new Gson();
//                HomeBean<List<HomeData>> stringList = gson.fromJson(str, new TypeToken<HomeBean<List<HomeData>>>() {}.getType());
//                System.out.println(stringList);
//            }
//
//            @Override
//            public void no(IOException e) {
//
//            }
//        });

        while (true) {}

    }


}