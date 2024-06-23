package com.example.starball24.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starball24.ApiServices.FootballIntance
import com.example.starball24.ApiServices.PredictionClient
import com.example.starball24.Data.RequestBody
import com.example.starball24.Data.ResponsePredict
import com.example.starball24.Data.TeamStanding
import com.example.starball24.Data.response
import com.example.starball24.Data.responsecompression
import kotlinx.coroutines.launch

class MatchesViewModel:ViewModel() {
    private val _matches = MutableLiveData<List<response>>()
    val matches: LiveData<List<response>> = _matches

    private val _predict = MutableLiveData<ResponsePredict>()
    val predict: LiveData<ResponsePredict> = _predict

    private val _standing = MutableLiveData<List<TeamStanding>>()
    val standing: LiveData<List<TeamStanding>> = _standing

    private val _result = MutableLiveData<List<response>>()
    val result: LiveData<List<response>> = _result

    private val _comparison = MutableLiveData<List<responsecompression>>()
    val comparison: LiveData<List<responsecompression>> = _comparison


    fun feacthMatches() {
        viewModelScope.launch {
            try {
                val matches = FootballIntance.retrofit.getMatch(39,2023,"2023-08-12")
                _matches.value = matches.response
            } catch (e: Exception) {
                Log.e("MatchesViewModel", "Error fetching matches: ${e.message}")
            }
        }
    }

    fun predictMatch(requestBody: RequestBody){
        viewModelScope.launch {
            try {
                val matches = PredictionClient.retrofit.predict(requestBody)
                _predict.value = matches
            }catch (e:Exception){
                Log.e("MatchesViewModel", "Error fetching Predict: ${e.message}")
            }
        }
    }

    fun feacthStanding(){
        viewModelScope.launch {
            try {
                val standings = FootballIntance.retrofit.getStanding(39,2023).response
                standings.map {
                    val response = it.league.standings.flatten()
                    _standing.value = response
                    Log.d("Standings", "${response}")
                }


            }catch (e:Exception){
                Log.e("MatchesViewModel", "Error fetching Predict: ${e.message}")
            }
        }
    }

    fun feacthResult(){
        viewModelScope.launch {
            try {
                val result = FootballIntance.retrofit.getMatch(39,2023,"2023-08-12")
                _result.value = result.response
            }catch (e:Exception){
                Log.e("MatchesViewModel", "Error fetching Result: ${e.message}")
            }
        }
    }

    fun feactComparisson(request:requestBodyComparisson){
        viewModelScope.launch {
            try {
                val comparison = FootballIntance.retrofit.getpredictionComparisson(request).comparisonResponse
                _comparison.value
            }catch (e:Exception){
                Log.e("MatchesViewModel", "Error fetching Result: ${e.message}")
            }
        }
    }
}