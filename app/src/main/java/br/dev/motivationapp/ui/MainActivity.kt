package br.dev.motivationapp.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.dev.motivationapp.helper.MotivationConstants
import br.dev.motivationapp.repository.PhraseRepository
import br.dev.motivationapp.R
import br.dev.motivationapp.databinding.ActivityMainBinding
import br.dev.motivationapp.repository.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences
    private val phraseRepository = PhraseRepository()
    private var filter: Int = MotivationConstants.PHRASEFILTER.ALL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        securityPreferences = SecurityPreferences(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setListeners()
        getUserName()

        handleFilter(R.id.imageview_all)
        refreshPhrase()
    }

    private fun refreshPhrase() {
        binding.textviewPhrase.text = phraseRepository.getPhrase(filter)
    }

    private fun getUserName() {
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.textviewName.text = name
    }

    override fun onClick(v: View) {
        val listId = listOf(
            R.id.imageview_all,
            R.id.imageview_happy,
            R.id.imageview_sunny,
        )

        if (v.id == R.id.button_new_phrase) {
            refreshPhrase()
        } else if (v.id in listId) {
            handleFilter(v.id)
        }
    }

    private fun handleFilter(id: Int) {
        //faz as imageviews ficarem pretos para evitar que mais de um item esteja na cor branca
        binding.imageviewAll
            .setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageviewHappy
            .setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageviewSunny
            .setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            R.id.imageview_all -> {
                filter = MotivationConstants.PHRASEFILTER.ALL
                binding.imageviewAll
                    .setColorFilter(ContextCompat.getColor(this, R.color.white))
            }

            R.id.imageview_happy -> {
                filter = MotivationConstants.PHRASEFILTER.HAPPY
                binding.imageviewHappy
                    .setColorFilter(ContextCompat.getColor(this, R.color.white))
            }

            R.id.imageview_sunny -> {
                filter = MotivationConstants.PHRASEFILTER.SUNNY
                binding.imageviewSunny
                    .setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        }
    }

    private fun setListeners() {
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageviewAll.setOnClickListener(this)
        binding.imageviewHappy.setOnClickListener(this)
        binding.imageviewSunny.setOnClickListener(this)
    }
}