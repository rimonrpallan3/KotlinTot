package app.client.kotlintest2.Landing

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import app.client.kotlintest2.Landing.model.UserDetails
import app.client.kotlintest2.R
import app.client.kotlintest2.SecondActivity.SecondActivity
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var tvCombine: TextView
    lateinit var etNameFirst: EditText
    lateinit var etNameSecond: EditText
    lateinit var etAcNameFirst: EditText
    lateinit var etAcNameSecond: EditText
    lateinit var etAge: EditText
    lateinit var btnCombine: Button
    lateinit var btnDisplay: Button
    lateinit var dlMain: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rimon: Int = 2
        println("rimon euals 2 : ${rimon.equals(2)}")

        val someInt: Int = 10
        val someDouble: Double = 10.84723894
        val someFloat: Float = 10.501F
        val someString: String = "Sentence Here"
        val sum = someInt + someDouble
        var anotherInt: Int

        anotherInt = 10
        Log.d("EA", "the value of otherInt is: ${anotherInt.toString()}")

        anotherInt = 20
        Log.d("EA", anotherInt.toString())

        val someSum: Double = 20.5 + 3.4
        anotherInt = (20 + someSum).toInt()

        Log.d("EA", anotherInt.toString())
        //tvHelloWorld
        val tvHelloWorld: TextView = findViewById(R.id.tvHelloWorld)
        tvCombine = findViewById(R.id.tvCombine)
        etNameFirst = findViewById(R.id.etNameFirst)
        etNameSecond = findViewById(R.id.etNameSecond)
        etAcNameFirst = findViewById(R.id.etAcNameFirst)
        etAcNameSecond = findViewById(R.id.etAcNameSecond)
        dlMain = findViewById(R.id.dlMain)
        etAge = findViewById(R.id.etAge)
        btnCombine = findViewById(R.id.btnCombine)
        btnDisplay = findViewById(R.id.btnDisplay)
        tvHelloWorld.text = "You have started with android"

        btnCombine.setOnClickListener {
            val outputString: String = "${etNameFirst.text} ${etNameSecond.text}"
            tvCombine.text = outputString
            tvCombine.visibility = View.VISIBLE
        }

        btnDisplay.setOnClickListener {
            val userDetails: UserDetails = UserDetails(etAcNameFirst.text.toString(), etAcNameSecond.text.toString(), etAge.text.toString().toInt(), Date())

            val intent: Intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("UserDetails", userDetails)
            startActivityForResult(intent, 12)
        }

        val userDetails: UserDetails = UserDetails("rimon", "Pallan", 8, Date())
        userDetails.age = 10
        Log.d("EA", userDetails.toString())
        Log.d("EA", userDetails.firstName.toString())

        val toogle = ActionBarDrawerToggle(this, dlMain, R.string.drawer_open, R.string.drawer_close)

    }

    override fun onBackPressed() {
        if (dlMain.isDrawerOpen(GravityCompat.START)) {
            dlMain.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.activity_main_drawer,menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when (item.itemId) {
            R.id.home_drawer -> {

            }
            R.id.profile_drawer -> {

            }
            R.id.rate_us_drawer -> {

            }
            R.id.share_drawer -> {

            }
            R.id.report_a_bug -> {

            }
            R.id.reset_tutorials -> {

            }
        }
        dlMain.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                val returnUser: UserDetails = data.getSerializableExtra("returnUser") as UserDetails
                Log.d("EA", returnUser.toString())
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.d("EA", "User Canceled ")

        }
    }

}
