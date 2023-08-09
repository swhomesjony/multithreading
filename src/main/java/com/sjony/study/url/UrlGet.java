package com.sjony.study.url;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UrlGet {

    /**
     * @description： 核心问题在于控制并发数的情况下，最快速完成请求
     * 1.线程池控制并发数：具体需要结合业务场景判断线程回收等待时间 拒绝策略还有队列
     * 2.对请求url进行分片，因为控制了并发量，因此要尽可能均匀的分配（此处不考虑各url的性能，业务场景等）
     * @param urlList
     * @param maxRequest
     */
    public void parallelRequest(List<String> urlList, int maxRequest) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(maxRequest, maxRequest, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        List<List<String>> requestPartList = parrtion(urlList, maxRequest);
        List<Future<String>> resultUrlList = new ArrayList<>();
        for(List<String> urlPartList : requestPartList) {
            resultUrlList.add(threadPoolExecutor.submit(() -> requestUrl(urlPartList)));
        }
        for(Future<String> future : resultUrlList) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @description url分批
     * @param urlList
     * @param maxRequest
     * @return
     */
    public List<List<String>> parrtion(List<String> urlList, int maxRequest) {
        List<List<String>> result = new ArrayList<>(maxRequest);
        int partSize = urlList.size()%2==0 ? urlList.size()/maxRequest : urlList.size()/maxRequest+1;
        int start = 0;
        List<String> partUrlList = null;
        for(String url : urlList) {
            if(start == 0) {
                partUrlList = new ArrayList<>();
            }
            partUrlList.add(url);
            if(start == partSize) {
                start = 0;
                result.add(partUrlList);
                continue;
            }
            start++;
        }
        return result;
    }

    public String requestUrl(List<String> urlList) {
        for(String url : urlList) {
            System.out.println("请求连接:" + url);
        }
        return "success";
    }
}
