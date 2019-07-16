package com.example.aarrowapp.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.aarrowapp.database.daos.EmployeeDao
import com.example.aarrowapp.database.models.EmployeeEntity

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    val allEmployees: LiveData<List<EmployeeEntity>> = employeeDao.getAllEmployeesByName()

    @WorkerThread
    suspend fun insertEmployee(employeeEntity: EmployeeEntity) {
        employeeDao.insert(employeeEntity)
    }


}