package jm.dodamdodam.dodamdodam.socketio;

import android.content.Context;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.controller.activity.WordActivity;

/**
 * Created by IronFactory on 15. 11. 24..
 */
public class SocketRes extends SocketIntent {

    private static final String TAG = "SocketRes";

    // TODO: 15. 11. 24. 글귀 추가 응답 처리
    public static void processInsertWord(Context context, JSONObject object) {
        try {
            int code = getCode(object);
            Intent intent = getIntent(context, WordActivity.class, code, Global.INSERT_WORD);
            context.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
