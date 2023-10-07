package com.example.android.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast



import kotlinx.android.synthetic.main.activity_bmiactivity.*
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    val METRIC_UNITS_VIEW="METRIC_UNIT_VIEW"
    val US_UNITS_VIEW="US_UNIT_VIEW"
    var currentVisibleView:String=METRIC_UNITS_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)

        setSupportActionBar(toolbar_bmi_activity)

        val actionbar=supportActionBar
        if(actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title="CALCULATE BMI"
        }
        toolbar_bmi_activity.setNavigationOnClickListener{
            onBackPressed()
        }


        btnCalculateUnits.setOnClickListener {
            if(currentVisibleView.equals(METRIC_UNITS_VIEW)){
                if(validateMetricUnit()) {
                    val heightValue: Float = etMetricUnitHeight.text.toString().toFloat() / 100
                    val weightValue: Float = etMetricUnitWeight.text.toString().toFloat()

                    val bmi = weightValue / (heightValue * heightValue)
                    displayBMIResult(bmi)
                }
                    else{
                        Toast.makeText(this@BMIActivity,"Please enter valid values.",Toast.LENGTH_SHORT).show()
                    }
            }
            else{
                if(validateUSUnit()){
                    val usUnitHeightValueFeet:String=etUsUnitHeightFeet.text.toString()
                    val usUnitHeightValueInch:String=etUsUnitHeightInch.text.toString()
                    val usUnitWeightValue:Float=etUsUnitWeight.text.toString().toFloat()

                    var heightValue=usUnitHeightValueFeet.toFloat() * 12 + usUnitHeightValueInch.toFloat()
                    val bmi=703*(usUnitWeightValue/(heightValue*heightValue))
                    displayBMIResult(bmi)



                }
                else{
                    Toast.makeText(this@BMIActivity,"Please enter valid values.",Toast.LENGTH_SHORT).show()


                }
            }

        }
        makeVisibleMetricView()
        rgUnits.setOnCheckedChangeListener{group, checkedId ->
            if(checkedId==R.id.rbMetricUnits){
                makeVisibleMetricView()
            }
            else{
                makeVisibleUsUnitsView()
            }
        }
    }


    private fun validateMetricUnit():Boolean{
        var isValid=true
        if(etMetricUnitWeight.text.toString().isEmpty())
            isValid=false

        else if(etMetricUnitHeight.text.toString().isEmpty())
            isValid=false

        return isValid
    }

    private fun validateUSUnit():Boolean{
        var isValid=true
        if(etUsUnitWeight.text.toString().isEmpty())
            isValid=false

        else if(etUsUnitHeightFeet.text.toString().isEmpty() || etUsUnitHeightInch.text.toString().isEmpty())
            isValid=false

        return isValid
    }
    private fun makeVisibleUsUnitsView(){
        currentVisibleView=US_UNITS_VIEW
        tilMetricUnitHeight.visibility=View.GONE
        tilMetricUnitWeight.visibility=View.GONE

        etUsUnitWeight.text!!.clear()
        etUsUnitHeightFeet.text!!.clear()
        etUsUnitHeightInch.text!!.clear()

        tilUsUnitWeight.visibility=View.VISIBLE
        llUsUnitsHeight.visibility=View.VISIBLE

        llDisplayBMIResult.visibility=View.GONE



    }
    private fun makeVisibleMetricView(){
        currentVisibleView=METRIC_UNITS_VIEW
        tilMetricUnitHeight.visibility=View.VISIBLE
        tilMetricUnitWeight.visibility=View.VISIBLE

        etMetricUnitWeight.text!!.clear()
        etMetricUnitHeight.text!!.clear()

        tilUsUnitWeight.visibility=View.GONE
        llUsUnitsHeight.visibility=View.GONE

        llDisplayBMIResult.visibility=View.GONE



    }


    private fun displayBMIResult(bmi:Float){
        val bmiLabel:String
        val bmiDescription:String

        if(bmi.compareTo(15f)<=0 ){
            bmiLabel="Very severely underweight"
            bmiDescription="Oops! You really need to take care of your better! Eat more!"
        }
        else if(bmi.compareTo(15f)>0 && bmi.compareTo(16f)<=0){
            bmiLabel="severely underweight"
            bmiDescription="Oops! You really need to take care of your better! Eat more!"
        }
        else if(bmi.compareTo(16f)>0 && bmi.compareTo(18.5f)<=0){
            bmiLabel="Underweight"
            bmiDescription="Oops! You really need to take care of your better! Eat more!"
        }
        else if(bmi.compareTo(18.5f)>0  && bmi.compareTo(25f)<=0){
            bmiLabel="Normal"
            bmiDescription="Congratulation! You are good in shape!"
        }
        else if(bmi.compareTo(25f)>0 && bmi.compareTo(30f)<=0){
            bmiLabel="Overweight"
            bmiDescription="Oops! You really need to take care of yourself! workout maybe!"
        }
        else if(bmi.compareTo(30f)>0 && bmi.compareTo(35f)<=0){
            bmiLabel="Obese class | (Moderately obese)"
            bmiDescription="Oops! You really need to take care of yourself! workout maybe!"
        }
        else if(bmi.compareTo(35f)>0 && bmi.compareTo(40f)<=0){
            bmiLabel="Obese class || (Severely obese)"
            bmiDescription="OMG! You are in very dangerous condition! Act now!"
        }
        else {
            bmiLabel="Obese Class ||| (Very severely obese)"
            bmiDescription="OMG! You are in a very dangerous condition! Act now!"
        }
        llDisplayBMIResult.visibility=View.VISIBLE
//        tvYourBMI.visibility= View.VISIBLE
//        tvBMIValue.visibility= View.VISIBLE
//        tvBMIType.visibility=View.VISIBLE
//        tvBMIDescription.visibility=View.VISIBLE

        val bmiValue=BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
        tvBMIValue.text=bmiValue
        tvBMIType.text=bmiLabel
        tvBMIDescription.text=bmiDescription


    }
}