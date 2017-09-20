package com.matthew.weatherapp.Extensions

import com.matthew.weatherapp.extensions.toDateString
import org.junit.Test
import java.text.DateFormat
import kotlin.test.assertEquals

/**
 * Created by Matthew on 20/09/2017.
 */
class ExtensionTest {

    //Work Example
    @Test
    fun testLongToDateString() {
        assertEquals("19-oct-2015", 1445275635000L.toDateString())
    }

    //Fail Example
    @Test
    fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015",
                1445275635000L.toDateString(DateFormat.FULL))
    }
}