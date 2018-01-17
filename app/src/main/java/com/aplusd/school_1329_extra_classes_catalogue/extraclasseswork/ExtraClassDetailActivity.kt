package com.aplusd.school_1329_extra_classes_catalogue.extraclasseswork

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.aplusd.school_1329_extra_classes_catalogue.R
import com.aplusd.school_1329_extra_classes_catalogue.databinding.ActivityExtraclassBinding
import com.aplusd.school_1329_extra_classes_catalogue.model.ExtraClass
import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.Config




/**
 * @author Azamat Dzhonov
 * @date 16.01.2018
 *
 */
class ExtraClassDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!intent.hasExtra(Config.INTENT_EXTRACOURSE))
            finish()

        var extraClass = intent.getSerializableExtra(Config.INTENT_EXTRACOURSE) as ExtraClass

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = extraClass.name


        var binding = DataBindingUtil
                .setContentView<ActivityExtraclassBinding>(this, R.layout.activity_extraclass)
        binding.extraClass = extraClass

        var tvEmail = findViewById<TextView>(R.id.tvEmail)

        tvEmail.setOnClickListener{
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_EMAIL, tvEmail.text)
            startActivity(i)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
       return true
    }
}