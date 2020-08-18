package com.example.webview;

import java.util.ArrayList;

public interface MainContract {



    interface presenter{

        void requestDataFromServer();

    }

    interface MainView {

        void setDataToRecyclerView(ArrayList<ResponseModel.Datum> noticeArrayList);

        void onResponseFailure(String throwable);

    }

    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<ResponseModel.Datum> noticeArrayList);
            void onFailure(String t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }

}