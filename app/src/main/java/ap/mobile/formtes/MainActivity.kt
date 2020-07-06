package ap.mobile.formtes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMenuTerapi.setOnClickListener() {
            intent = Intent(this, MenuTerapi::class.java)
            startActivity(intent)
        }

        btMenuTes .setOnClickListener(){
            intent = Intent(this, MenuTes::class.java)
            startActivity(intent)
        }
    }
}
