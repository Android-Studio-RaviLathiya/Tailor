package com.example.mytailor.OtpLoging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.mytailor.Activity.MainActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpSendActivity extends AppCompatActivity {

    TextView text, changenumber;
    Animation bottomanim;
    FloatingActionButton ok;
    PinView enterpin;
    private String mVerificationId;
    private FirebaseAuth mAuth;
    ProgressBar progressbar;
    TextView mobilenumber, uname;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_send);

        ok = findViewById(R.id.ok);
        enterpin = findViewById(R.id.enterpin);
        progressbar = findViewById(R.id.progressbar);
        mobilenumber = findViewById(R.id.mobilenumber);
        uname = findViewById(R.id.uname);
        time = findViewById(R.id.time);
        changenumber = findViewById(R.id.changenumber);


        mAuth = FirebaseAuth.getInstance();
        sendverificationcode(MyPrefrence.getuphone());

        mobilenumber.setText(MyPrefrence.getuphone());
        uname.setText(MyPrefrence.getuname());


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPrefrence.setulogin(true);
                String code = enterpin.getText().toString().trim();

                if (code.isEmpty() || code.length() < 6) {

                    Toast toast = Toast.makeText(OtpSendActivity.this, "Enter Code", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    enterpin.requestFocus();
                    return;
                }
                verifycode(code);
            }
        });


        //Animation
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);

        //status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }

        /*Auto time */
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("00:" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("Time Finish!");
            }
        }.start();

    }


    private void sendverificationcode(String getuphone) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(

                "+91" + MyPrefrence.getuphone(),        // Phone number to verify
                40,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                enterpin.setText(code);
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OtpSendActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;

        }
    };

    private void verifycode(String code) {
        try {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
            signInWithPhoneAuthCredential(credential);

        } catch (Exception e) {
            Toast toast = Toast.makeText(this, "Verification Code is wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(OtpSendActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            Intent intent = new Intent(OtpSendActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        } else {

                            Toast.makeText(OtpSendActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                            //verification unsuccessful.. display an error message

//                            String message = "Somthing is wrong, we will fix it soon...";
//
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                message = "Invalid code entered...";
//                            }
//
//                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
//                            snackbar.setAction("Dismiss", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//
//                                }
//                            });
//                            snackbar.show();
//                        }
                        }
                    }
                });
    }

    public void changenumber(View view) {
        startActivity(new Intent(OtpSendActivity.this, LoginWithMobileNoActivity.class));
        finish();
    }
}
