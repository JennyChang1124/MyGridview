package com.example.mygridview

class Modal: java.io.Serializable{
    var name:String? =null
    var image:Int? = null

    constructor(name:String, image:Int){
        this.name=name;
        this.image=image;
    }
}