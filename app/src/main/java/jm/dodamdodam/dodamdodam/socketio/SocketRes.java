package jm.dodamdodam.dodamdodam.socketio;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.controller.activity.WordActivity;

/**
 * Created by IronFactory on 15. 11. 24..
 */
public class SocketRes {

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



    private static Intent getIntent(Context context, Class activity, int code, String command) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Global.COMMAND, command);
        intent.putExtra(Global.CODE, code);
        return intent;
    }


    private static int getCode(JSONObject object) throws JSONException {
        int code = object.getInt(Global.CODE);
        String command = object.getString(Global.COMMAND);
        Log.d(TAG, "code = " + code);
        Log.d(TAG, "command = " + command);
        return code;
    }
}
