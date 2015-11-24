package jm.dodamdodam.dodamdodam.socketio;

import android.content.Context;
import android.content.Intent;

import jm.dodamdodam.dodamdodam.Global;

/**
 * Created by IronFactory on 15. 11. 24..
 */
public class SocketReq extends SocketIntent {

    private static final String TAG = "SocketReq";

    public static void insertWord(Context context, int feel, String word) {
        Intent intent = getIntent(context, SocketService.class, Global.INSERT_WORD);
        intent.putExtra(Global.FEEL, feel);
        intent.putExtra(Global.WORD, word);
        context.startService(intent);
    }
}
