package edu.miu.cs473de.w3a4l5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import edu.miu.cs473de.w3a4l5.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var users:HashMap<String,User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        users=initialUsers()
    }

    private fun initialUsers():HashMap<String,User>{
        val userss=HashMap<String,User>()
        userss["cris-p@gmail.com"]=User(1,"Cris","Pana","cris-p@gmail.com","cris-p","12345678")
        return userss
    }

    private fun validateUser(email:String,pass:String):Boolean{
        return if (users.containsKey(email))
            users[email]?.email==email && users[email]?.password==pass
        else false
    }

    private fun goToShoppingCategoryActivity(userName:String){
        val intent=Intent(this,ShoppingCategoryActivity::class.java)
        intent.putExtra("userName",userName)
        startActivity(intent)
    }

    fun signIn(view: View) {
        val email=findViewById<EditText>(R.id.edt_email).text.toString()
        val pass=findViewById<EditText>(R.id.edt_pass).text.toString()

        if (validateUser(email,pass)) goToShoppingCategoryActivity(userName = users[email]?.userName!!)
        else Toast.makeText(this,"We don't have this user",Toast.LENGTH_SHORT).show()
    }

    fun goToRegisterActivity(view: View) {
        startActivityForResult(Intent(this,RegisterActivity::class.java),1)
    }


}