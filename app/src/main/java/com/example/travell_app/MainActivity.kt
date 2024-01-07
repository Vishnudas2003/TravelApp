package com.example.travell_app

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentImage = 1
    lateinit var image : ImageView
    var places = arrayOf("CN Tower", "High park", "Toronto Music Garden", "Berczy Park", "Bluffers Park")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val next = findViewById<ImageButton>(R.id.btnNext)
        val previous = findViewById<ImageButton>(R.id.btnPrevious)
        val placeName = findViewById<TextView>(R.id.tVName)
        next.setOnClickListener{
            var idCurrentImage= "place$currentImage"

            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImage, "id", packageName)
            image= findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage= (5+currentImage+1)%5
            var idImageToShowString= "place$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            placeName.text= places[currentImage]
        }

        previous.setOnClickListener{
            var idCurrentImage= "place$currentImage"

            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImage, "id", packageName)
            image= findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage= (5+currentImage-1)%5
            var idImageToShowString= "place$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            placeName.text= places[currentImage]
        }
    }
}