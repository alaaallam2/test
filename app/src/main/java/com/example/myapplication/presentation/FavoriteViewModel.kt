package com.example.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.Doctor
import com.example.myapplication.domain.DoctorRepository
import com.google.android.datatransport.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: DoctorRepository
) : ViewModel() {

    private val _favoriteDoctors = MutableLiveData<List<Doctor>>()
    val favoriteDoctors: LiveData<List<Doctor>> get() = _favoriteDoctors

    private val _doctorDetails = MutableLiveData<Doctor>()
    val doctorDetails: LiveData<Doctor> get() = _doctorDetails

    private val _errorEvent = MutableLiveData<Event<String>>()
    val errorEvent: LiveData<Event<String>> get() = _errorEvent

    fun updateFavoriteDoctors(doctors: List<Doctor>) {
        _favoriteDoctors.value = doctors
    }

    fun addFavoriteDoctor(doctorId: String) {
        viewModelScope.launch {
            try {
                repository.addFavoriteDoctor(doctorId)
                // يمكنك هنا تحديث القائمة المفضلة إذا لزم الأمر
            } catch (e: Exception) {
                _errorEvent.value = Event("فشل في إضافة الطبيب للمفضلة: ${e.message}")
            }
        }
    }

    fun removeFavoriteDoctor(doctorId: String) {
        viewModelScope.launch {
            try {
                repository.removeFavoriteDoctor(doctorId)
                // يمكنك هنا تحديث القائمة المفضلة إذا لزم الأمر
            } catch (e: Exception) {
                _errorEvent.value = Event("فشل في إزالة الطبيب من المفضلة: ${e.message}")
            }
        }
    }

    fun getDoctorDetails(doctorId: String) {
        viewModelScope.launch {
            try {
                val doctorDetails = repository.getDoctorDetails(doctorId)
                _doctorDetails.value = doctorDetails
            } catch (e: Exception) {
                _errorEvent.value = Event("فشل في جلب تفاصيل الطبيب: ${e.message}")
            }
        }
    }
}