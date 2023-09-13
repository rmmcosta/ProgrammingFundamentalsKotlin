package MyWeek3Katas

import java.time.LocalDateTime

/*
Scenario

Imagine you are creating a forum for coders in a programming community.
In that forum, the user can create a post. For instance, they may talk in their post about their code or projects.
Other coders in that forum can choose a comment to add to that post.  In addition, the users can choose a relationship type.
This indicates the relationship between one user and another.
These are relationship types such as ‘work colleague’, ‘friend’ or being a member of the same sports team.
Finally, you will include the ability for the author of a post to block other users from commenting on the post.
 */

/*
Note: In this exercise, we work with an example that only has one post.
It is posted by the current user (post owner).
If this were a full real-world application, we would also create a relationship between comments, post owner, or even build a Post class.
But for this exercise, you don’t need to do any of that.
 */

/*
This is a summary of your tasks in this exercise:

Store and display comments

Store the user’s relationship to other users

Filter out comments of blocked users
 */

/*
Tip: The map will store the relationships between users. Refer to the
Map and example usages
 reading in Week 3.
The list will be used to store all the comments. Refer to the
Create a List
reading in Week 3. A set is used to store the blocked users. Refer to the
Use a Set
 reading in Week 3.  You can also view the
Collection types
video in Week 3 for what you have learned about map, list and set.
 */

enum class Relationship {
    FRIEND,
    WORK_COLLEAGUE,
    FAMILY,
    SPORTS,
}

data class User(val id: Int, val name: String) {
    private val relationships = mutableMapOf<User, Relationship>()

    fun addRelationship(user: User, relationship: Relationship) {
        relationships += user to relationship
    }

    fun getRelationship(user: User): Relationship? = relationships[user]
}

data class Comment(val user: User, val comment: String, val createdAt: LocalDateTime)

data class Post(val title: String, val post: String, val createdAt: LocalDateTime, val owner: User) {
    private val comments = mutableListOf<Comment>()
    private val blockedUsers = mutableSetOf<User>()

    fun addComment(user: User, comment: String) {
        if (user !in blockedUsers) {
            comments += Comment(user, comment, LocalDateTime.now())
        } else {
            println("This user $user is blocked by the owner $owner of the Post!")
        }
    }

    fun blockUser(user: User) {
        val relationship = owner.getRelationship(user)
        if (relationship == null) {
            blockedUsers += user
        } else {
            println("You can't block your $relationship")
        }
    }
}