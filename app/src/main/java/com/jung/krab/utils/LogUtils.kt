package com.jung.krab.utils

import android.util.Log

class LogUtils{
    companion object{
        private const val TAG = "KRAB"

        fun debug(txt:String){
            Log.d(TAG, txt)
        }
        fun debug(tag: String, txt:String){
            Log.d(tag, txt)
        }

        fun error(txt: String){
            Log.e(TAG, txt)
        }

        fun error(tag:String, txt: String){
            Log.e(tag, txt)
        }

        fun warn(txt:String){
            Log.w(TAG, txt);
        }

        fun warn(tag:String, txt:String){
            Log.w(tag, txt);
        }
    }
}