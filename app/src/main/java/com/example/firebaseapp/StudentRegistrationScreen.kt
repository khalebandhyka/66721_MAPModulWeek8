package com.example.firebaseapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StudentRegistrationScreen(viewModel: StudentViewModel = viewModel()) {
    var studentId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var program by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Student ID") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = program,
            onValueChange = { program = it },
            label = { Text("Program") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (studentId.isNotBlank() && name.isNotBlank() && program.isNotBlank()) {
                    viewModel.addStudent(Student(studentId, name, program))
                    studentId = ""
                    name = ""
                    program = ""
                }
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        ) {
            Text("Submit")
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Text(
            text = "Student List",
            style = MaterialTheme.typography.titleMedium
        )

        LazyColumn {
            items(viewModel.students) { student ->
                Text(text = "${student.id} - ${student.name} - ${student.program}")
            }
        }
    }
}
