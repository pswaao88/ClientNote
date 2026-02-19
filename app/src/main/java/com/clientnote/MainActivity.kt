package com.clientnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.clientnote.ui.ClientNoteApp
import com.clientnote.ui.theme.ClientNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClientNoteTheme {
                ClientNoteApp()
            }
        }
    }
}
