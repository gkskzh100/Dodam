package jm.dodamdodam.dodamdodam.socketio;

import android.content.Context;
import android.content.Intent;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.controller.activity.WordActivity;

/**
 * Created by IronFactory on 15. 11. 24..
 */
public class SocketReq {


    public static void insertWord(Context context, int feel, String word) {
        Intent intent = getIntent(context, WordActivity.class, Global.INSERT_WORD);
        intent.putExtra(Global.FEEL, feel);
        intent.putExtra(Global.WORD, word);
        context.startService(intent);
    }


    private static Intent getIntent(Context context, Class activity, String command) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(Global.COMMAND, command);
        return intent;
    }
}
