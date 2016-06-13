/*
 * Copyright (C) 2016, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.yifeiyuan.wilfulrv;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 程序亦非猿 on 16/6/13.
 *
 */
public class WilfulRV extends RecyclerView {

    private int mLastX;
    private int mLasty;

    public WilfulRV(Context context) {
        super(context);
    }

    public WilfulRV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WilfulRV(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        final LinearLayoutManager lm = (LinearLayoutManager) getLayoutManager();

        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (isStartOrEnd(lm)) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isStartOrEnd(lm)) {
                    int diffY = (int) (e.getY() - mLasty);
                    int diffX = (int) (e.getX() - mLastX);
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        requestDisallowInterceptTouchEvent(true);
                    }
                }
                break;
        }
        mLastX = (int) e.getX();
        mLasty = (int) e.getY();
        return super.onTouchEvent(e);
    }

    /**
     * 是否是在最左边or最右边
     * */
    private boolean isStartOrEnd(LinearLayoutManager lm) {
        return lm.findLastCompletelyVisibleItemPosition() == getAdapter().getItemCount() - 1 || lm.findFirstVisibleItemPosition() == 0;
    }
}
