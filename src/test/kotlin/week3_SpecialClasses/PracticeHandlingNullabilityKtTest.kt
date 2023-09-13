package week3_SpecialClasses


import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PracticeHandlingNullabilityKtTest {

    private val bootstrapStudents = mockk<BootstrapStudent>()

    @BeforeEach
    fun setup() {
        every { bootstrapStudents.bootstrap() } returns listOf(Student(1, "Student 1"))
    }

    @Test
    fun shouldHaveAListOfStudents() {
        val studentManager = StudentManager(bootstrapStudents)
        Assertions.assertTrue(studentManager.hasStudents(), "There are students")
    }

    @Test
    fun shouldThrowNPEIfIdNotFound() {
        val studentManager = StudentManager(bootstrapStudents)
        Assertions.assertThrowsExactly(NullPointerException::class.java) { studentManager.getStudentById(555) }
    }

    @Test
    fun shouldReturnTheCorrectStudentById() {
        val studentManager = StudentManager(bootstrapStudents)
        val student1 = Student(1, "Student 1")
        Assertions.assertEquals(studentManager.getStudentById(student1.id), student1, "Given a student whose id exists")
    }

    @Test
    fun shouldReturnNotFoundIfNameNotFound() {
        val studentManager = StudentManager(bootstrapStudents)
        Assertions.assertEquals(
            studentManager.getStudentByName("coiso"),
            null,
            "Return null when student name not found"
        )
    }

    @Test
    fun shouldReturnTheCorrectStudentByName() {
        val studentManager = StudentManager(bootstrapStudents)
        val student1 = Student(1, "Student 1")
        Assertions.assertEquals(
            studentManager.getStudentByName(student1.fullName),
            student1,
            "Given a student whose name exists"
        )
    }
}