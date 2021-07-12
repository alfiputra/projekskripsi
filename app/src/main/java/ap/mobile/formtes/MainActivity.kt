package ap.mobile.formtes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ap.mobile.formtes.terapi.KategoriInsmnia
import ap.mobile.formtes.tes.PenyimpananTes
import ap.mobile.formtes.tes.SoalTes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_terapi.setOnClickListener() {
            intent = Intent(this, KategoriInsmnia::class.java)
            startActivity(intent)
        }

        menu_tes.setOnClickListener(){
            intent = Intent(this, SoalTes::class.java)
            startActivity(intent)
        }

        menu_riwayat.setOnClickListener {
            intent = Intent(this, PenyimpananTes::class.java)
            startActivity(intent)
        }

        menu_bantuan.setOnClickListener{
            intent = Intent(this, BantuanAplikasi::class.java )
            startActivity(intent)
        }

    }
}
