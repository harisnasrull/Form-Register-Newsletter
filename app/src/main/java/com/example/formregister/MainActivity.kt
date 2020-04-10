package com.example.formregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener {
            validate()
        }
    }
    private fun validate() {
        if (validateName() && validateEmail() && validatePassword() && validateGender()) {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateGender() : Boolean {
        if (radio_group.checkedRadioButtonId == -1){
            error_gender.setText("Gender must be Selected")
            return false
        }
        else {
            error_gender.setText(null)
            return true
        }
    }

    private fun validatePassword() : Boolean {
        if (edit_password.text.length == 0 ){
            error_password.setText("Password must be Filled")
            return false
        }
        else if (edit_password.text.length < 8) {
            error_password.setText("Password Must be 8 Character or longer")
            return false
        }
        else {
            error_password.setText(null)
            return true
        }
    }

    private fun validateEmail() : Boolean {
        if (edit_email.text.length == 0){
            error_email.setText("Email must be Filled")
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(edit_email.text).matches()){
            error_email.setText("Must be Valid Email")
            return false
        }
        else {
            error_email.setText(null)
            return true
        }
    }

    fun validateName() : Boolean {
        if (edit_name.text.length == 0 ){
            error_name.setText("Name must be Filled")
            return false
        }
        else {
            error_name.setText(null)
            return true
        }
    }
}
