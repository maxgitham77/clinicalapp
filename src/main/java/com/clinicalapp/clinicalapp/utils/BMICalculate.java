package com.clinicalapp.clinicalapp.utils;

import com.clinicalapp.clinicalapp.entities.ClinicalData;

import java.util.List;

public class BMICalculate {

    public static void calculateBmi(ClinicalData eachEntry, List<ClinicalData> clinicalData) {
        if (eachEntry.getComponentName().equals("hw")) {
            String[] heightAndWeight = eachEntry.getComponentValue().split("/");
            if (heightAndWeight != null && heightAndWeight.length > 1) {
                float heightMetres = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                float bmi = Float.parseFloat(heightAndWeight[1]) / (heightMetres * heightMetres);
                ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentName("bmi");
                bmiData.setComponentValue(Float.toString(bmi));
                clinicalData.add(bmiData);
            }
        }
    }
}
