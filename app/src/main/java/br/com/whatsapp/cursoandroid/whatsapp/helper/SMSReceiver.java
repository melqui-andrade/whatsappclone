package br.com.whatsapp.cursoandroid.whatsapp.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Melqui on 19/02/2017.
 */

public class SMSReceiver extends BroadcastReceiver {

    private final SmsManager smsManager = SmsManager.getDefault();

    public SMSReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage smsAtual = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String telefone = smsAtual.getDisplayOriginatingAddress();

                    String quemEnviou = telefone;
                    String message = smsAtual.getDisplayMessageBody();

                    Toast toast = Toast.makeText(context, "Mensagem de : "+ quemEnviou + ", Msg : " + message, Toast.LENGTH_LONG);
                    toast.show();

                }
            }

        } catch (Exception e) {
            Log.e("SMSReceiver", "Exception smsReceiver" +e);
        }
    }
}
