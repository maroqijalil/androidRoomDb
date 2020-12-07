package my.maroqi.application.moviecatalogue.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.ui.detail.DataDetailsActivity
import my.maroqi.application.moviecatalogue.ui.main.MainActivity.Companion.MAIN_DATA
import my.maroqi.application.moviecatalogue.ui.main.MainActivity.Companion.MAIN_DATA_TYPE
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListPagerAdapter
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.NavigationHandler

class FavouriteActivity : AppCompatActivity(), NavigationHandler {

    private lateinit var btnFavClose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        supportActionBar?.hide()

        val sectionsPagerAdapter = CatalogueListPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        btnFavClose = findViewById(R.id.btn_fav_close)
        btnFavClose.setOnClickListener{
            this.finish()
        }

        tabs.setupWithViewPager(viewPager)
    }

    override fun navigateTo(index: Int, type: ListItemType) {
        val intent = Intent(this, DataDetailsActivity::class.java)

        intent.putExtra(MAIN_DATA, index)
        intent.putExtra(MAIN_DATA_TYPE, type)

        startActivity(intent)
    }
}