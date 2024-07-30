package ip.tomichek.tv

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class GroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_group)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val l1: ConstraintLayout = findViewById(R.id.l1)
        val l2: ConstraintLayout = findViewById(R.id.l2)
        val l3: ConstraintLayout = findViewById(R.id.l3)
        val l4: ConstraintLayout = findViewById(R.id.l4)
        val l5: ConstraintLayout = findViewById(R.id.l5)
        val l6: ConstraintLayout = findViewById(R.id.l6)
        val l7: ConstraintLayout = findViewById(R.id.l7)
        val l8: ConstraintLayout = findViewById(R.id.l8)
        val l9: ConstraintLayout = findViewById(R.id.l9)
        val l10: ConstraintLayout = findViewById(R.id.l10)
        val l11: ConstraintLayout = findViewById(R.id.l11)


        l1.setOnClickListener {

            val intent = Intent(this, TelechannelsHDFHD::class.java)
            startActivity(intent)
        }
        l2.setOnClickListener {

            val intent = Intent(this, TV_Premium::class.java)
            startActivity(intent)
        }
        l3.setOnClickListener {

            val intent = Intent(this, Films_HD_FHD::class.java)
            startActivity(intent)
        }
        l4.setOnClickListener {

            val intent = Intent(this, MultFilms_HD_FHD::class.java)
            startActivity(intent)
        }
        l5.setOnClickListener {

            val intent = Intent(this, Serials_FHD::class.java)
            startActivity(intent)
        }
        l6.setOnClickListener {

            val intent = Intent(this, UFC_FHD::class.java)
            startActivity(intent)
        }
        l7.setOnClickListener {

            val intent = Intent(this, FORSAZH::class.java)
            startActivity(intent)
        }
        l8.setOnClickListener {

            val intent = Intent(this, AMERICANPIE::class.java)
            startActivity(intent)
        }
        l9.setOnClickListener {

            val intent = Intent(this, FOUR_K::class.java)
            startActivity(intent)
        }
        l10.setOnClickListener {

            val intent = Intent(this, TajikistanTV::class.java)
            startActivity(intent)
        }
        l11.setOnClickListener {

            val intent = Intent(this, IranTV::class.java)
            startActivity(intent)
        }

    }
}