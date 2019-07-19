package com.example.aarrowapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.aarrowapp.database.models.EmployeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EmployeeRepository

    val allEmployees: LiveData<List<EmployeeEntity>>

    init {
        val employeeDao = AArrowRoomDatabase.getDatabase(application).employeeDao()
        repository = EmployeeRepository(employeeDao)
        allEmployees = repository.allEmployees
    }

    //viewModelScope.launch makes sure the insert method is not launched on the main thread
    fun insert(employee: EmployeeEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertEmployee(employee)
    }

}