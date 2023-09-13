package week3_SpecialClasses

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PracticeHandlingNullabilityKtTest2 {

    companion object {
        private val bootstrapStudents = mockk<BootstrapStudent>()

        @BeforeAll
        @JvmStatic
        fun setup() {
            every { bootstrapStudents.bootstrap() } returns listOf(
                Student(1, "Student 1"),
                Student(2, "Student 2"),
                Student(3, "Student 3"),
            )
        }
    }

    @Nested
    @DisplayName("hasStudents method")
    inner class HasStudentsMethod {

        @Test
        fun `should return true if there are students`() {
            val studentManager = StudentManager(bootstrapStudents)
            Assertions.assertTrue(studentManager.hasStudents())
        }
    }

    @Nested
    @DisplayName("getStudentById method")
    inner class GetStudentByIdMethod {

        @Test
        fun `should throw NullPointerException if id not found`() {
            val studentManager = StudentManager(bootstrapStudents)
            Assertions.assertThrows(NullPointerException::class.java) {
                studentManager.getStudentById(555)
            }
        }

        @Test
        fun `should return the correct student by id`() {
            val studentManager = StudentManager(bootstrapStudents)
            val student1 = Student(1, "Student 1")
            Assertions.assertEquals(student1, studentManager.getStudentById(student1.id))
        }
    }

    @Nested
    @DisplayName("getStudentByName method")
    inner class GetStudentByNameMethod {

        @Test
        fun `should return null if name not found`() {
            val studentManager = StudentManager(bootstrapStudents)
            Assertions.assertNull(studentManager.getStudentByName("coiso"))
        }

        @ParameterizedTest
        @ValueSource(strings = ["Student 1", "Student 2", "Student 3"])
        fun `should return the correct student by name`(name: String) {
            val studentManager = StudentManager(bootstrapStudents)
            val id = name.replace(Regex("[a-zA-Z]"), "").trim().toInt()
            val student = Student(id, name)
            Assertions.assertEquals(student, studentManager.getStudentByName(name))
        }
    }
}
