package com.eland.Process;


import com.eland.getRequest.*;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String enterKeyword = request.getParameter("enterKeyword");
        String enterLowDate = request.getParameter("enterLowDate");
        String enterHighDate = request.getParameter("enterHighDate");
        String enterLowPrice = request.getParameter("enterLowPrice");
        String enterHighPrice = request.getParameter("enterHighPrice");
        String enterLanguage = request.getParameter("enterLanguage");
        System.out.println("輸入的enterLowDate: " + enterLowDate);
        System.out.println("輸入的enterHighDate: " + enterHighDate);
        System.out.println("輸入的enterLowPrice: " + enterLowPrice);
        System.out.println("輸入的enterHighPrice: " + enterHighPrice);
        System.out.println("輸入的enterLanguage: " + enterLanguage);

        GetRequest getRequest = new GetRequest();
        getRequest.setQueryType("keyword");     /*設定query_type*/

        getRequest.setKeyword(enterKeyword);     /*設定keyword*/

        ArrayList<String> targetDb = new ArrayList<>();     /*設定target_db*/
        targetDb.add("Database");
        getRequest.setTargetDb(targetDb);

        SearchRange searchRange = new SearchRange();    /*設定search_range*/
        searchRange.setStartPos(0);
        searchRange.setMaxRecord(100);
        getRequest.setSearchRange(searchRange);

        ArrayList<String> resultField = new ArrayList<>();    /*設定result_field*/
        resultField.add("Title");
        resultField.add("Author");
        resultField.add("Content");
        resultField.add("Date");
//        resultField.add("DateOnly");
        resultField.add("BrowseNum");
        resultField.add("Price");
        resultField.add("Language");
        getRequest.setResultField(resultField);


//        getRequest.getFieldFilter().getExpr().getAnd().setExprString("DateFilter & PriceFilter & LanguageFilter");
//        getRequest.getFieldFilter().getExpr().getAnd().getFieldMap().getDateFilter().setDate("1960/01/01 00:00:00 ~ 2019/10/09 00:00:00");
//        getRequest.getFieldFilter().getExpr().getAnd().getFieldMap().getPriceFilter().setPrice("0~500");
//        getRequest.getFieldFilter().getExpr().getAnd().getFieldMap().getLanguageFilter().setLanguage("English");


        LanguageFilter languageFilter = new LanguageFilter();
        languageFilter.setLanguage(enterLanguage);  /*設定語言English、Chinese、Japanese*/
        FieldMap fieldMap = new FieldMap();
        fieldMap.setLanguageFilter(languageFilter);

        PriceFilter priceFilter = new PriceFilter();
        priceFilter.setPrice(enterLowPrice + "~" + enterHighPrice); /*設定價格*/
        DateFilter dateFilter = new DateFilter();
        dateFilter.setDate(enterLowDate + "~" + enterHighDate );
        fieldMap.setPriceFilter(priceFilter);
        fieldMap.setDateFilter(dateFilter);
        And and = new And();
        and.setFieldMap(fieldMap);
        and.setExprString("LanguageFilter & PriceFilter & DateFilter");  /*設定ExprString內容*/
        Expr expr = new Expr();
        expr.setAnd(and);
        FieldFilter fieldFilter = new FieldFilter();
        fieldFilter.setExpr(expr);
        getRequest.setFieldFilter(fieldFilter);


        Gson gson = new Gson();
        String requestString = gson.toJson(getRequest);
        System.out.println("request JSON字串:  " + requestString);


        CloseableHttpClient closeableHttpClient = null;
        try {
            closeableHttpClient = HttpClients
                    .custom()
                    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE)
                            .build())
                    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        HttpPost httpPost = new HttpPost("http://172.17.13.115:8080/web/P2PServer.jsp?");
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("txtInput_json", requestString));
        pairList.add(new BasicNameValuePair("action", "search"));
        pairList.add(new BasicNameValuePair("cache_mode", "checked"));
        StringEntity stringEntity = new StringEntity(pairList.toString(), "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");

        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "UTF-8"));
        System.out.println("post request: " + pairList.toString());

        CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println("result: " + result);
        PrintWriter out = response.getWriter();
        out.print(result);


    }
}
