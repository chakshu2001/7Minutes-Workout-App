package com.example.android.a7minuteworkout

import android.database.sqlite.SQLiteReadOnlyDatabaseException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar_history_activity)
        val actionBar = supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title="History"
        }
        toolbar_history_activity.setNavigationOnClickListener{
            onBackPressed()
        }
        getAllCompletedDates()
    }
    private fun getAllCompletedDates(){
        val dbHandler=SqliteOpenHelper(this, null)
        val allCompletedDatesList=dbHandler.getAllCompleteDatesList()
        if(allCompletedDatesList.size>0){
            tvHistory.visibility= View.VISIBLE
            rvHistory.visibility=View.VISIBLE
            tvNoDataAvailable.visibility=View.GONE

            rvHistory.layoutManager=LinearLayoutManager(this)
            val historyAdapter=HistoryAdapter(this,allCompletedDatesList)
            rvHistory.adapter=historyAdapter

        }
        else{
            tvHistory.visibility= View.GONE
            rvHistory.visibility=View.GONE
            tvNoDataAvailable.visibility=View.VISIBLE
        }
    }
}