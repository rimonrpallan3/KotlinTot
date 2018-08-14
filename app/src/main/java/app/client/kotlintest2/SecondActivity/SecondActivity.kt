package app.client.kotlintest2.SecondActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import app.client.kotlintest2.Landing.model.UserDetails
import app.client.kotlintest2.R

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    lateinit var tvFN:TextView
    lateinit var tvLN:TextView
    lateinit var tvAge:TextView
    lateinit var btnSave:Button
    lateinit var btnCancel:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        val userDetails:UserDetails = intent.getSerializableExtra("UserDetails")as UserDetails
        tvFN = findViewById(R.id.tvFN)
        tvLN = findViewById(R.id.tvLN)
        tvAge = findViewById(R.id.tvAge)
        btnSave = findViewById(R.id.btnSave)
        btnCancel = findViewById(R.id.btnCancel)
        tvFN.text = userDetails.firstName
        tvLN.text = userDetails.lastName
        tvAge.text = userDetails.age.toString()
        Log.d("EA", userDetails.toString())

        btnSave.setOnClickListener{
            val userDetails:UserDetails =UserDetails("First Name Has Been changed","Last Name Changed",22)
            val returnIntent:Intent = Intent()
            returnIntent.putExtra("returnUser",userDetails)
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }
        btnCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
