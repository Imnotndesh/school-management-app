package com.yourapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.school_management_app.db.AdminTable
import com.example.school_management_app.db.AttendanceTable
import com.example.school_management_app.db.ClassesTable
import com.example.school_management_app.db.ExamTable
import com.example.school_management_app.db.KeysTable
import com.example.school_management_app.db.ParentsTable
import com.example.school_management_app.db.RemindersTable
import com.example.school_management_app.db.StudentTable
import com.example.school_management_app.db.TeacherTable

class SchoolDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "school_db"
        const val DATABASE_VERSION = 1

        // Table Names
        const val TABLE_STUDENTS = "students"
        const val TABLE_TEACHERS = "teachers"
        const val TABLE_ADMINS = "admins"
        const val TABLE_CLASSES = "classes"
        const val TABLE_EXAMS = "exams"
        const val TABLE_PARENTS = "parents"
        const val TABLE_ATTENDANCE = "attendance"
        const val TABLE_REMINDERS = "reminders"
        const val TABLE_KEYS = "keys"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create all tables
        db?.execSQL(StudentTable)
        db?.execSQL(TeacherTable)
        db?.execSQL(AdminTable)
        db?.execSQL(ClassesTable)
        db?.execSQL(ExamTable)
        db?.execSQL(ParentsTable)
        db?.execSQL(AttendanceTable)
        db?.execSQL(RemindersTable)
        db?.execSQL(KeysTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TEACHERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_ADMINS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CLASSES")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_EXAMS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PARENTS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_ATTENDANCE")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_REMINDERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_KEYS")
        onCreate(db)
    }

    // INSERTION HELPERS
    fun insertStudent(studentName: String, dateOfBirth: String, parentName: String, gender: String, phone: String?, className: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("student_name", studentName)
            put("date_of_birth", dateOfBirth)
            put("parent_name", parentName)
            put("gender", gender)
            put("phone", phone)
            put("class_name", className)
        }
        val result = db.insert(TABLE_STUDENTS, null, values)
        db.close()
        return result
    }

    // Insert teacher record
    fun insertTeacher(teacherName: String, email: String?, subjects: String, phone: String, className: String, accessUsername: String, accessPassword: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("teacher_name", teacherName)
            put("email", email)
            put("subjects", subjects)
            put("phone", phone)
            put("class_name", className)
            put("access_username", accessUsername)
            put("access_password", accessPassword)
        }
        val result = db.insert(TABLE_TEACHERS, null, values)
        db.close()
        return result
    }

    // Insert admin record
    fun insertAdmin(adminName: String, adminPassword: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("admin_name", adminName)
            put("admin_password", adminPassword)
        }
        val result = db.insert(TABLE_ADMINS, null, values)
        db.close()
        return result
    }

    // Insert class record
    fun insertClass(className: String, classStream: String, grade: Int, teacherName: String, capacity: Int): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("class_name", className)
            put("class_stream", classStream)
            put("grade", grade)
            put("teacher_name", teacherName)
            put("capacity", capacity)
        }
        val result = db.insert(TABLE_CLASSES, null, values)
        db.close()
        return result
    }

    // Insert exam record
    fun insertExam(examDate: String, studentName: Int, catOne: Int, catTwo: Int, finalExam: Int, comments: String?): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("exam_date", examDate)
            put("student_name", studentName)
            put("cat_one", catOne)
            put("cat_two", catTwo)
            put("final_exam", finalExam)
            put("comments", comments)
        }
        val result = db.insert(TABLE_EXAMS, null, values)
        db.close()
        return result
    }

    // Insert parent record
    fun insertParent(parentName: String, email: String, phone: String, studentName: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("parent_name", parentName)
            put("email", email)
            put("phone", phone)
            put("student_name", studentName)
        }
        val result = db.insert(TABLE_PARENTS, null, values)
        db.close()
        return result
    }

    // Insert attendance record
    fun insertAttendance(dateTaken: String, present: Int, absent: Int, studentsMissing: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("date_taken", dateTaken)
            put("present", present)
            put("absent", absent)
            put("students_missing", studentsMissing)
        }
        val result = db.insert(TABLE_ATTENDANCE, null, values)
        db.close()
        return result
    }

    // Insert reminder record
    fun insertReminder(reminderText: String, creationDate: String, reminderDate: String, reminderOwner: String, ownerType: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("reminder_text", reminderText)
            put("creation_date", creationDate)
            put("reminder_date", reminderDate)
            put("reminder_owner", reminderOwner)
            put("owner_type", ownerType)
        }
        val result = db.insert(TABLE_REMINDERS, null, values)
        db.close()
        return result
    }

    // Insert API key record (for managing users)
    fun insertApiKey(apiKey: String, userName: String, userType: String, keyExpiry: Int, dispatchTime: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("api_key", apiKey)
            put("user_name", userName)
            put("user_type", userType)
            put("key_expiry", keyExpiry)
            put("dispatch_time", dispatchTime)
        }
        val result = db.insert(TABLE_KEYS, null, values)
        db.close()
        return result
    }
    // UPDATE HELPERS

    // Update student record
    fun updateStudent(studentName: String, newStudentName: String?, newDateOfBirth: String?, newParentName: String?, newGender: String?, newPhone: String?, newClassName: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newStudentName?.let { put("student_name", it) }
            newDateOfBirth?.let { put("date_of_birth", it) }
            newParentName?.let { put("parent_name", it) }
            newGender?.let { put("gender", it) }
            newPhone?.let { put("phone", it) }
            newClassName?.let { put("class_name", it) }
        }
        val whereClause = "student_name = ?"
        val whereArgs = arrayOf(studentName)
        val result = db.update(TABLE_STUDENTS, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update teacher record
    fun updateTeacher(teacherName: String, newTeacherName: String?, newEmail: String?, newSubjects: String?, newPhone: String?, newClassName: String?, newAccessUsername: String?, newAccessPassword: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newTeacherName?.let { put("teacher_name", it) }
            newEmail?.let { put("email", it) }
            newSubjects?.let { put("subjects", it) }
            newPhone?.let { put("phone", it) }
            newClassName?.let { put("class_name", it) }
            newAccessUsername?.let { put("access_username", it) }
            newAccessPassword?.let { put("access_password", it) }
        }
        val whereClause = "teacher_name = ?"
        val whereArgs = arrayOf(teacherName)
        val result = db.update(TABLE_TEACHERS, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update class record
    fun updateClass(className: String, newClassName: String?, newClassStream: String?, newGrade: Int?, newTeacherName: String?, newCapacity: Int?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newClassName?.let { put("class_name", it) }
            newClassStream?.let { put("class_stream", it) }
            newGrade?.let { put("grade", it) }
            newTeacherName?.let { put("teacher_name", it) }
            newCapacity?.let { put("capacity", it) }
        }
        val whereClause = "class_name = ?"
        val whereArgs = arrayOf(className)
        val result = db.update(TABLE_CLASSES, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update exam record
    fun updateExam(examId: Int, newExamDate: String?, newStudentName: Int?, newCatOne: Int?, newCatTwo: Int?, newFinalExam: Int?, newComments: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newExamDate?.let { put("exam_date", it) }
            newStudentName?.let { put("student_name", it) }
            newCatOne?.let { put("cat_one", it) }
            newCatTwo?.let { put("cat_two", it) }
            newFinalExam?.let { put("final_exam", it) }
            newComments?.let { put("comments", it) }
        }
        val whereClause = "exam_id = ?"
        val whereArgs = arrayOf(examId.toString())
        val result = db.update(TABLE_EXAMS, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update parent record
    fun updateParent(parentName: String, newParentName: String?, newEmail: String?, newPhone: String?, newStudentName: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newParentName?.let { put("parent_name", it) }
            newEmail?.let { put("email", it) }
            newPhone?.let { put("phone", it) }
            newStudentName?.let { put("student_name", it) }
        }
        val whereClause = "parent_name = ?"
        val whereArgs = arrayOf(parentName)
        val result = db.update(TABLE_PARENTS, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update attendance record
    fun updateAttendance(dateTaken: String, newDateTaken: String?, newPresent: Int?, newAbsent: Int?, newStudentsMissing: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newDateTaken?.let { put("date_taken", it) }
            newPresent?.let { put("present", it) }
            newAbsent?.let { put("absent", it) }
            newStudentsMissing?.let { put("students_missing", it) }
        }
        val whereClause = "date_taken = ?"
        val whereArgs = arrayOf(dateTaken)
        val result = db.update(TABLE_ATTENDANCE, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update reminder record
    fun updateReminder(reminderId: Int, newReminderText: String?, newCreationDate: String?, newReminderDate: String?, newReminderOwner: String?, newOwnerType: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newReminderText?.let { put("reminder_text", it) }
            newCreationDate?.let { put("creation_date", it) }
            newReminderDate?.let { put("reminder_date", it) }
            newReminderOwner?.let { put("reminder_owner", it) }
            newOwnerType?.let { put("owner_type", it) }
        }
        val whereClause = "reminder_id = ?"
        val whereArgs = arrayOf(reminderId.toString())
        val result = db.update(TABLE_REMINDERS, values, whereClause, whereArgs)
        db.close()
        return result
    }

    // Update API key record (for managing users)
    fun updateApiKey(apiKey: String, newUserName: String?, newUserType: String?, newKeyExpiry: Int?, newDispatchTime: String?): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            newUserName?.let { put("user_name", it) }
            newUserType?.let { put("user_type", it) }
            newKeyExpiry?.let { put("key_expiry", it) }
            newDispatchTime?.let { put("dispatch_time", it) }
        }
        val whereClause = "api_key = ?"
        val whereArgs = arrayOf(apiKey)
        val result = db.update(TABLE_KEYS, values, whereClause, whereArgs)
        db.close()
        return result
    }
    // DELETE HELPERS

    // Delete student record
    fun deleteStudent(studentName: String): Int {
        val db = writableDatabase
        val whereClause = "student_name = ?"
        val whereArgs = arrayOf(studentName)
        val result = db.delete(TABLE_STUDENTS, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete teacher record
    fun deleteTeacher(teacherName: String): Int {
        val db = writableDatabase
        val whereClause = "teacher_name = ?"
        val whereArgs = arrayOf(teacherName)
        val result = db.delete(TABLE_TEACHERS, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete class record
    fun deleteClass(className: String): Int {
        val db = writableDatabase
        val whereClause = "class_name = ?"
        val whereArgs = arrayOf(className)
        val result = db.delete(TABLE_CLASSES, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete exam record
    fun deleteExam(examId: Int): Int {
        val db = writableDatabase
        val whereClause = "exam_id = ?"
        val whereArgs = arrayOf(examId.toString())
        val result = db.delete(TABLE_EXAMS, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete parent record
    fun deleteParent(parentName: String): Int {
        val db = writableDatabase
        val whereClause = "parent_name = ?"
        val whereArgs = arrayOf(parentName)
        val result = db.delete(TABLE_PARENTS, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete attendance record
    fun deleteAttendance(dateTaken: String): Int {
        val db = writableDatabase
        val whereClause = "date_taken = ?"
        val whereArgs = arrayOf(dateTaken)
        val result = db.delete(TABLE_ATTENDANCE, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete reminder record
    fun deleteReminder(reminderId: Int): Int {
        val db = writableDatabase
        val whereClause = "reminder_id = ?"
        val whereArgs = arrayOf(reminderId.toString())
        val result = db.delete(TABLE_REMINDERS, whereClause, whereArgs)
        db.close()
        return result
    }

    // Delete API key record
    fun deleteApiKey(apiKey: String): Int {
        val db = writableDatabase
        val whereClause = "api_key = ?"
        val whereArgs = arrayOf(apiKey)
        val result = db.delete(TABLE_KEYS, whereClause, whereArgs)
        db.close()
        return result
    }
    // Method to count the number of records in any table
    fun countRecords(tableName: String): Int {
        val db = this.readableDatabase
        var count = 0
        try {
            // Query to count the number of records in the given table
            val cursor = db.rawQuery("SELECT COUNT(*) FROM $tableName", null)
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0) // Get the count from the first column
            }
            cursor.close()
        } catch (e: Exception) {
            Log.e("DatabaseHelper", "Error counting records in $tableName: ${e.message}")
        } finally {
            db.close() // Ensure to close the database connection
        }
        return count
    }

}
