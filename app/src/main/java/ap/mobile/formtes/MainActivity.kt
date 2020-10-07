package ap.mobile.formtes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_terapi.setOnClickListener() {
            intent = Intent(this, MenuTerapiAsmrtist::class.java)
            startActivity(intent)
        }

        menu_tes.setOnClickListener(){
            intent = Intent(this, MenuTes::class.java)
            startActivity(intent)
        }
    }
}
