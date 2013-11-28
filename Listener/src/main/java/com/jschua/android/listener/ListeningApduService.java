package com.jschua.android.listener;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by chuajiesheng on 28/11/13.
 */
public class ListeningApduService extends HostApduService {

    private static final String TAG = "HostApduService";

    @Override
    public byte[] processCommandApdu(byte[] apdu, Bundle extras) {
        Log.d(TAG, "APDU: " + getHexString(apdu));

        return null;
    }

    @Override
    public void onDeactivated(int reason) {
        Log.d(TAG, "Deactivated: " + reason);
    }

    public static String getHexString(byte[] data) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < data.length; i++) {
            String bs = Integer.toHexString(data[i] & 0xFF);
            bs = bs.toUpperCase();

            if (bs.length() == 1) {
                sb.append(0);
            }

            sb.append(bs + " ");
        }

        return sb.toString();
    }
}

