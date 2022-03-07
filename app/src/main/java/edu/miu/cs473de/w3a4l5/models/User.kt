package edu.miu.cs473de.w3a4l5.models

import java.io.Serializable

public class User:Serializable{
      var Id: Long =0
     lateinit var firstName:String
     lateinit var lastName:String
     lateinit var email:String
     lateinit var userName:String
     lateinit var password:String

    constructor()
    constructor(
        Id: Long,
        firstName: String,
        lastName: String,
        email: String,
        userName: String,
        password: String
    ) {
        this.Id = Id
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.userName = userName
        this.password = password
    }


}
