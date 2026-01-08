package com.example.sotphim.viewmodel.authviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success (val user : FirebaseUser?) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel : ViewModel() {
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()

    var authState by mutableStateOf<AuthState>(AuthState.Idle)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun singUp (email : String, pass : String) {
        isLoading = true
        authState = AuthState.Loading

        auth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener {
                isLoading = false
                authState = AuthState.Success(it.user)

            }
            .addOnFailureListener {
                isLoading = false
                authState = AuthState.Error("Lỗi đăng ký")
            }

    }

}