package com.kilicma.mvvm_guesst_word.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _word = MutableLiveData<String>()
    val word: LiveData<String> get() = _word

    private val _score= MutableLiveData<Int>()
    val score : LiveData<Int> get() = _score

    private lateinit var wordList: MutableList<String>

    init {
        resetList()
        nextWord()
        _score.value = 0
    }
    private fun resetList(){

        wordList = mutableListOf(
            "elma", "armut", "kalem", "defter", "bilgisayar", "telefon", "ev", "araba", "gitar", "kedi",
            "köpek", "masa", "sandalye", "gözlük", "kitap", "tren", "uçak", "gemi", "ayakkabı", "şapka",
            "kamera", "bahçe", "deniz", "göl", "orman", "dağ", "nehir", "bulut", "güneş", "ay", "yıldız",
            "dünya", "mars", "merkür", "venüs", "jüpiter", "satürn", "uranüs", "neptün", "plüton", "cüce"
        )
        wordList.shuffle()
    }

    private fun nextWord(){
        if (wordList.isNotEmpty()){
            _word.value= wordList[0]
        }else{
            _word.value="Oyun Bitti !!!"
        }
    }
    fun onSkip(){
        _score.value = _score.value?.minus(1)
        nextWord()
    }
    fun onCorrect(){
        if ((_score.value ?: 0) < 42){
            _score.value = _score.value?.plus(1)
        }
        nextWord()
    }


}