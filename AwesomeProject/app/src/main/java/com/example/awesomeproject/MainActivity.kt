package com.example.awesomeproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var workoutInput: EditText
    private lateinit var recommendButton: Button
    private lateinit var dietPlanText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customSetContentView()
    }

    @SuppressLint("InflateParams")
    private fun customSetContentView() {
        // Inflate the layout from XML
        val inflater = LayoutInflater.from(this)
        val inflatedView = inflater.inflate(R.layout.layout, null)

        // Initialize UI elements
        workoutInput = inflatedView.findViewById(R.id.workoutInput)
        recommendButton = inflatedView.findViewById(R.id.recommendButton)
        dietPlanText = inflatedView.findViewById(R.id.dietPlanText)

        // Set click listener for the recommendButton
        recommendButton.setOnClickListener {
            onRecommendButtonClick(it)
        }

        // Set the content view of the activity
        setContentView(inflatedView)
    }
    private fun onRecommendButtonClick(view: View) {
        // Get user input
        val workoutDetails = workoutInput.text.toString()

        // Call a function to get diet recommendation based on workout details
        val dietPlan = getDietRecommendation(workoutDetails)

        // Display the diet plan
        dietPlanText.text = dietPlan
    }

    private fun getDietRecommendation(workoutDetails: String): String {
        // Dummy logic - replace with your actual recommendation algorithm
        // This is a hardcoded example
        return when {
            workoutDetails.contains("cardio") -> "High-protein, low-fat diet"
            workoutDetails.contains("strength training") -> "Balanced diet with sufficient protein intake"
            else -> "General diet recommendation"
        }
    }
}
