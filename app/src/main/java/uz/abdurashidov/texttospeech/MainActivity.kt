package uz.abdurashidov.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import uz.abdurashidov.texttospeech.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var textToSpeech: TextToSpeech
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.speechBtn.setOnClickListener {
            textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS) {
                    textToSpeech.language = Locale.UK
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak(
                        binding.editText.text.toString(),
                        TextToSpeech.QUEUE_ADD,
                        null
                    )
                }
            })
        }
    }
}