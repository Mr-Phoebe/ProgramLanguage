package com.androidbook.telephony;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.EditText;

public class Status extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String opName = telManager.getNetworkOperatorName();
        Log.i("telephony", "operator name = " + opName);
        
        String phoneNumber = telManager.getLine1Number();
        Log.i("telephony", "phone number = " + phoneNumber);
        
        String providerName = telManager.getSimOperatorName();
        Log.i("telephony", "provider name = " + providerName);
        
        int callStatus = telManager.getCallState();
        String callState = getCallStateString(callStatus);
        Log.i("telephony", callState);
        
        telManager.listen(new PhoneStateListener() {
            public void onCallStateChanged(int state, String incomingNumber) {
                String newState = getCallStateString(state);
                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    Log.i("telephony", newState + " number = " + incomingNumber);
                } else {
                    Log.i("telephony", newState);
                }
                    
            }
            
        }, PhoneStateListener.LISTEN_CALL_STATE);
        
        ServiceState serviceState = new ServiceState();
        int serviceStatus = serviceState.getState();
        String serviceStateString = getServiceStateString(serviceStatus);
        Log.i("telephony", serviceStateString);
        
        
        boolean isRoaming = serviceState.getRoaming();
        Log.i("telephony", "Roaming state is " + isRoaming);
        
        
        String formattedNumber = PhoneNumberUtils.formatNumber("9995551212");
        Log.i("telephony", formattedNumber);
        
        setContentView(R.layout.main);
        EditText numberEntry = (EditText) findViewById(R.id.number_entry);
        numberEntry.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        
    }
    
    private String getCallStateString(int callState)    {
        String callStateString = null;
        switch (callState) {
            case TelephonyManager.CALL_STATE_IDLE:
                callStateString = "Phone is idle.";
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                callStateString = "Phone is in use.";
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                callStateString = "Phone is ringing!";
                break;
        }
        
        return callStateString;
    }
    
    private String getServiceStateString(int serviceState) {
        String serviceStateString = null;
        switch (serviceState) {
            case ServiceState.STATE_EMERGENCY_ONLY:
                serviceStateString = "Emergency calls only";
                break;
            case ServiceState.STATE_IN_SERVICE:
                serviceStateString = "Normal service";
                break;
            case ServiceState.STATE_OUT_OF_SERVICE:
                serviceStateString = "No service available";
                break;
            case ServiceState.STATE_POWER_OFF:
                serviceStateString = "Telephony radio is off";
                break;
        }
        
        return serviceStateString;
        
    }

}
