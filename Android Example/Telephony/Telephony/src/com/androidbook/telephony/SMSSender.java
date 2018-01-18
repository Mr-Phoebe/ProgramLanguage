package com.androidbook.telephony;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.gsm.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SMSSender extends Activity {
    
    BroadcastReceiver rcvMsgSent = null;
    BroadcastReceiver rcvMsgReceipt = null;
    
    BroadcastReceiver rcvIncoming = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        final EditText messageEntry = (EditText) findViewById(R.id.short_message);

        final SmsManager sms = SmsManager.getDefault();
        
        // format the number
        final EditText numberEntry = (EditText) findViewById(R.id.number_entry);
        numberEntry.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        // prepare listening intents
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        Intent msgReceipt = new Intent("ACTION_MSG_RECEIPT");

        final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this, 0, msgSent, 0);
        final PendingIntent pendingMsgReceipt = PendingIntent.getBroadcast(this, 0, msgReceipt, 0);

        // handle the send message button
        Button sendSMS = (Button) findViewById(R.id.send_sms);
        sendSMS.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String destination = numberEntry.getText().toString();
                String message = messageEntry.getText().toString();
                sms.sendTextMessage(destination, null, message, pendingMsgSent, pendingMsgReceipt);
                
                
                if (rcvMsgSent != null) {
                    unregisterReceiver(rcvMsgSent);
                    rcvMsgSent = null;
                }

                // listen for status notifications
                rcvMsgSent = new BroadcastReceiver() {

                    @Override
                    public void onReceive(Context context, Intent intent) {
                        int result = getResultCode();
                        if (result != Activity.RESULT_OK) {
                            Log.e("telephony", "SMS send failed code = " + result);
                            pendingMsgReceipt.cancel();
                        } else {
                            Log.i("telephony", "SMS message sent!");
                            messageEntry.setText("");
                        }

                    }
                };
                registerReceiver(rcvMsgSent, new IntentFilter("ACTION_MSG_SENT"));

                
                /*
                // This block doesn't work right -- it doesn't register, ends up leaking the IntentFilter, and causes lots of log grief
                if (rcvMsgReceipt != null) {
                    unregisterReceiver(rcvMsgSent);
                    rcvMsgReceipt = null;
                }
                rcvMsgReceipt = new BroadcastReceiver() {

                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Log.e("telephony", "SMS received receipt received.");
                    }
                };
                Intent test = registerReceiver(rcvMsgReceipt, new IntentFilter("ACTION_MSG_RECEIPT"));
                if (test!= null) {
                    Log.i("telephony", "test is not null!!");
                    
                } else {
                    Log.i("telephony", "oh snap! test is null!?");
                }
                */
                


            }

        });
        
        
        final TextView receivedMessage = (TextView)findViewById(R.id.received_message);
        rcvIncoming = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("telephony", "SMS received");
                Bundle data = intent.getExtras();
                if (data != null) {
                    // SMS uses a data format known as a PDU
                    Object pdus[] = (Object[]) data.get("pdus");
                    String message = "New message:\n";
                    String sender = null;
                    for (Object pdu : pdus) {
                        SmsMessage part = SmsMessage.createFromPdu((byte[])pdu);
                        message += part.getDisplayMessageBody();
                        if (sender == null) {
                            sender = part.getDisplayOriginatingAddress();
                        }
                    }
                    receivedMessage.setText(message+"\nFrom: "+sender);
                    numberEntry.setText(sender);
                }
            }
        };
        registerReceiver(rcvIncoming, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        
        
    }

    @Override
    protected void onPause() {
        try {
        if (rcvMsgSent != null) {
            unregisterReceiver(rcvMsgSent);
            rcvMsgSent = null;
        }
        } catch (Exception e) {
            Log.e("telephony", "Failed to unregister rcvMsgSent", e);
        }
        try {
        if (rcvMsgReceipt != null) {
            unregisterReceiver(rcvMsgSent);
            rcvMsgReceipt = null;
        }
        } catch(Exception e) {
            Log.e("telephony", "Failed to unregister rcvMsgReceipt", e);
            
        }
        
        try {
            if (rcvIncoming != null) {
                unregisterReceiver(rcvIncoming);
                rcvIncoming = null;
            }
            } catch (Exception e) {
                Log.e("telephony", "Failed to unregister rcvIncoming", e);
            }
        super.onStop();
    }

}
