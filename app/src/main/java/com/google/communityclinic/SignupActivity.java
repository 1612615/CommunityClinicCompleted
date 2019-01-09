package com.google.communityclinic;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    private static final String URL_FOR_REGISTRATION = "https://community-clinic.000webhostapp.com/insert_data.php";
    ProgressDialog progressDialog;

    private EditText signupInputPhoneNumber;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        signupInputPhoneNumber = (EditText) findViewById(R.id.editTextPhone);

        btnSignUp = (Button) findViewById(R.id.button);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(getApplicationContext(), signupInputPhoneNumber.getText().toString());
            }
        });

    }

    private void registerUser(Context context, final String phoneNumber) {
        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(context);

        //send data
        try{
            StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_FOR_REGISTRATION, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONObject jsonObject;

                try {
                    jsonObject = new JSONObject(response);
                    int success = jsonObject.getInt("success");
                    String message = jsonObject.getString("message");
                    if (success==0) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), "Error. " + error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("phone", phoneNumber);
                return params;
            }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }
        };
        // Adding request to request queue
            queue.add(strReq);
    }

        catch (Exception e) {
            e.printStackTrace();
        }
}}