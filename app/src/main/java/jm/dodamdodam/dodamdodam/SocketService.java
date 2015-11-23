package jm.dodamdodam.dodamdodam;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONObject;


public class SocketService extends Service {

    private static final String TAG = "SocketService";
    private Socket socket;

    public SocketService() {

        try {
            socket = IO.socket("http://dodam-dodam-server.herokuapp.com");
            socket.open();
            socket.connect();

            socket.on(Global.ADD_WORD, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    try {
                        JSONObject object1 = (JSONObject) args[0];
                        int code = object1.getInt(Global.CODE);
                        Log.d(TAG,"code = " + code);

                        Intent intent = new Intent(getApplicationContext(), WordActivity.class);
                        intent.putExtra(Global.CODE,code);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        int a;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            int feel = intent.getIntExtra(Global.FEEL, -1);
            String word = intent.getStringExtra(Global.WORD);

            Log.d(TAG, "feel = " + feel);
            Log.d(TAG, "word = " + word);

            JSONObject object = new JSONObject();
            object.put(Global.FEEL, feel);
            object.put(Global.WORD, word);

            socket.emit(Global.ADD_WORD, object);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
