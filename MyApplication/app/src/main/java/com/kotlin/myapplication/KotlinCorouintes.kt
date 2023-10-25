package com.kotlin.myapplication

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
fun doSomething() {

}

fun doSomethingElse() {

}

suspend fun doLongRunningTask() {
    withContext(Dispatchers.Default) {
        // code for doing a long running task
        // Added delay to simulate
        delay(2000)
    }
}
fun main()= runBlocking {
print("Main program starts\n");
  var deferred=  GlobalScope.launch {
        print("fake work starts\n")
      task1();
      task2()
        mySuspendFunction(2000)
        print("fake work finshed\n")
    }
    mySuspendFunction(3000)
    print("program ends\n")
}


private fun task1()
{
    print("task1")
}
private fun task2()
{
    print("task2")
}
private suspend fun doLongRunningTaskOne(): Int {
    print("Task1")
    return withContext(Dispatchers.Default) {
        // your code for doing a long running task
        // Added delay to simulate
        delay(2000)
        return@withContext 10
    }
}
private suspend fun doLongRunningTaskTwo(): Int {
    print("Task2")
    return withContext(Dispatchers.Default) {
        // your code for doing a long running task
        // Added delay to simulate
        delay(2000)
        return@withContext 10
    }
}

suspend fun mySuspendFunction(time:Long)
{
    print("inside supend function${time}\n")
    delay(time)
    print("Finshed:   inside supend function${time}\n")
}
