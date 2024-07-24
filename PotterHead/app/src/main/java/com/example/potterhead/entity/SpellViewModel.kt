package com.example.potterhead.entity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potterhead.service.PotterApiService
import kotlinx.coroutines.launch

class SpellViewModel : ViewModel() {

    private  val  TAG = this.javaClass.simpleName
    private val _spellsList = MutableLiveData<List<Spell>>()
    val spellsList: LiveData<List<Spell>> = _spellsList


   fun getSpellsList(){
       viewModelScope.launch {
           try{
               _spellsList.value = PotterApiService.retrofitApiService.getAllSpells()
               Log.d(TAG,"List received : ${spellsList.value?.size}")
           }catch (e:Exception){
               Log.d(TAG,"ERROR : "+e.message)
           }
       }
   }
}