package com.example.android.worthit.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    companion object{
        private val TAG = "GameViewModel"
    }

    private var _score = MutableLiveData(0)
        val score: LiveData<Int> get() = _score

    private var _currentWordCount = MutableLiveData(0)
        val currentWordCount: LiveData<Int> get() = _currentWordCount

    private var _currentScrambledWord = MutableLiveData<String>()
        val currentScrambledWord: LiveData<String>
            get() = _currentScrambledWord

    private var wordsList = mutableListOf<String>()

    private lateinit var currentWord: String

    init {
        Log.d(TAG, "GameViewModel  is Created")
        getNextWord()
    }

    private  fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while(tempWord.toString().equals(currentWord, false)){
            tempWord.shuffle()
        }

        if(wordsList.contains(currentWord)){
            getNextWord()
        }else{
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)

        }
    }

    fun nextWord(): Boolean{
        return if(_currentWordCount.value!! < MAX_NO_OF_WORDS){
            getNextWord()
            true
        }else false
    }

    fun increaseScore(){
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(userWord: String): Boolean{
        return if(userWord == currentWord){
            increaseScore()
            true
        }else false
    }

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }


}