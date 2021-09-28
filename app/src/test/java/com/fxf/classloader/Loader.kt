package com.fxf.classloader

import dalvik.system.PathClassLoader
import org.junit.Test

class Loader {

    @Test
    fun t0(){
        PathClassLoader("",null)
    }
}